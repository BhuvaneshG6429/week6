package assignment.servicenowBDD;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowNewIncident extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	String incidentNumber="";
	 @Given("Enter the username as {string}")
	    public void enter_the_username_as(String username) throws Throwable {
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driver.findElement(By.id("user_name")).sendKeys(username);
	    }

	    @And("the Login button is clicked")
	    public void the_login_button_is_clicked() throws Throwable {
	    	driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	    	driver.switchTo().defaultContent();
	    }

	    @When("Clicked on New Button")
	    public void clicked_on_new_button() throws Throwable {
	    	driver.switchTo().frame("gsft_main");
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New' and @id='sysverb_new']")));
			driver.findElement(By.xpath("//button[text()='New' and @id='sysverb_new']")).click();
	    }

	    @When("Clicked on Caller search button")
	    public void clicked_on_caller_search_button() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='New record']")));
			driver.findElement(By.id("lookup.incident.caller_id")).click();
	    }


	    @Then("The Home Page should be displayed")
	    public void the_home_page_should_be_displayed() throws Throwable {
	    	driver.findElement(By.id("filter")).isDisplayed();
	    }

	    @Then("Search Incidents using the filter navigator")
	    public void search_incidents_using_the_filter_navigator() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter")));
			WebElement filterNavSearch = driver.findElement(By.id("filter"));
			filterNavSearch.sendKeys("incident",Keys.ENTER);
	    }

	    @Then("The Create New Incident section should be displayed")
	    public void the_create_new_incident_section_should_be_displayed() throws Throwable {
	    	driver.findElement(By.id("lookup.incident.caller_id")).isDisplayed();
	    }

	    @Then("From the resulting new window select first caller value")
	    public void from_the_resulting_new_window_select_first_caller_value() throws Throwable {
	    	Set<String> windowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(windowHandles);
			driver.switchTo().window(list.get(1));
			WebElement firstValue = driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]"));
			firstValue.click();
			driver.switchTo().window(list.get(0));
	    }

	    @And("Enter the password as {string}")
	    public void enter_the_password_as(String password) throws Throwable {
	    	driver.findElement(By.id("user_password")).sendKeys(password);
	    	
	    }

	    @And("Click on All")
	    public void click_on_all() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='filter']//following::span[text()='Incident'])[1]")));
			driver.findElement(By.xpath("(//span[text()='Incident']//following::div[text()='All'])[1]")).click();
	    }

	    @And("Provide short description as {string}")
	    public void provide_short_description_as(String shortdescription) throws Throwable {
	    	
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incident.short_description")));
			driver.findElement(By.id("incident.short_description")).sendKeys(shortdescription);
	    }
	    
	    @And("Click on Submit button")
	    public void click_on_submit_button() {
	    	incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
			System.out.println("Incident number : "+incidentNumber);
	    	driver.findElement(By.id("sysverb_insert")).click();
	    }
	    
	    @And("Check Incident has been created")
	    public void check_incident_has_been_created() throws IOException {
	    	WebElement selectListBox = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//select)[1]"));
			Select select = new Select(selectListBox);
			select.selectByVisibleText("Number");
			
			WebElement searchInc = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//input)[1]"));
			searchInc.sendKeys(incidentNumber,Keys.ENTER);
			
			WebElement incLink = driver.findElement(By.xpath("(//table[@id='incident_table']//a[@class='linked formlink'])[1]"));
			String incidentResultNumber = incLink.getText();
			Assert.assertEquals(incidentNumber, incidentResultNumber);
			
			incLink.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incident.short_description")));
			
			File screenshot = driver.getScreenshotAs(OutputType.FILE);
			File image = new File("./images/serviceNow/"+incidentNumber+".jpg");
			FileUtils.copyFile(screenshot, image);
		
	    }
		

}
