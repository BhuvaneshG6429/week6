package assignment.week6day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseClass{
	
	String firstRowText="";
	String secondRowText="";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@When("The Merge Leads link is clicked in the Leads Main Page")
	public void the_merge_leads_link_is_clicked_in_the_leads_main_page() {
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
	}

	@Then("The Merge Leads Page should be displayed")
	public void the_merge_leads_page_should_be_displayed() {
		driver.findElement(By.xpath("//span[text()='From Lead']//following::a[1]")).isDisplayed();
	}

	@Then("Click on the From Lead lookup image")
	public void click_on_the_from_lead_lookup_image() {
		WebElement fromWidget = driver.findElement(By.xpath("//span[text()='From Lead']//following::a[1]"));
		fromWidget.click();
	}

	@Then("Click on First Resulting Lead on the new window")
	public void click_on_first_resulting_lead_on_the_new_window() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='x-grid3-row-table'])[1]//a[1]")));
		WebElement firstRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//a[1]"));
		firstRowText = firstRowValue.getText();
		firstRowValue.click();
		driver.switchTo().window(list.get(0));
	}

	@Then("Window should be changed to default")
	public void window_should_be_changed_to_default() {
		
		String fromLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).getAttribute("value");
		Assert.assertEquals(firstRowText, fromLeadValue);
	}

	@Then("Click on the To Lead lookup image")
	public void click_on_the_to_lead_lookup_image() {
		WebElement toWidget = driver.findElement(By.xpath("//span[text()='To Lead']//following::a[1]"));
		toWidget.click();
		  
	}

	@Then("Click on Second Resulting Lead on the new window")
	public void click_on_second_resulting_lead_on_the_new_window() {
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(list1.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[1]")));
		WebElement secondRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[1]"));
		secondRowText = secondRowValue.getText();
		secondRowValue.click();
		driver.switchTo().window(list1.get(0));
		
	}
	
	@Then("Window should be changed to default again")
	public void window_should_be_changed_to_default_again() {
		String toLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).getAttribute("value");
		Assert.assertEquals(secondRowText, toLeadValue);
	}
	

	@When("Clicked on Merge button")
	public void clicked_on_merge_button() {
		 driver.findElement(By.xpath("//form[@name='MergePartyForm']//child::a[text()='Merge']")).click();
	}


	@When("The Alert is accepted")
	public void the_alert_is_accepted() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Then("View Lead Page should be displayed")
	public void view_lead_page_should_be_displayed() {
		Assert.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");
	}
			
	
}
