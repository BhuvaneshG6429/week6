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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceNowAssignIncident extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	String incidentResultNumber="";
	
    @When("Clicked on the assignment group lookup")
    public void clicked_on_the_assignment_group_lookup() throws Throwable {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_update")));
    	driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
    }

    @Then("Select {string} as assignment group name and click Update button")
    public void select_as_assignment_group_name_and_click_update_button(String assignmentgroup) throws Throwable {
    	Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		
		WebElement selectAssignGroupName = driver.findElement(By.xpath("(//div[@class='input-group']//select)[1]"));
		Select select2 = new Select(selectAssignGroupName);
		select2.selectByVisibleText("Name");
		
		WebElement inputAssignGroupName = driver.findElement(By.xpath("(//div[@class='input-group']//input)[1]"));
		inputAssignGroupName.sendKeys(assignmentgroup,Keys.ENTER);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sys_user_group_table")));
		driver.findElement(By.xpath("//a[text()='"+assignmentgroup+"']")).click();
		driver.switchTo().window(list.get(0));
		driver.switchTo().frame(0);
		String assignGroup = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		Assert.assertEquals(assignmentgroup, assignGroup);
		
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("assigned group as software");
		
		//click on update button
		WebElement updateButton = driver.findElement(By.id("sysverb_update"));
		updateButton.click();
    }

    @Then("Check if the assignment group is updated for the incident {string}")
    public void check_if_the_assignment_group_is_updated(String incident) throws Throwable {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='incident_table']")));
		//search the updated incident
		WebElement selectListBox1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//select)[1]"));
		Select select1 = new Select(selectListBox1);
		select1.selectByVisibleText("Number");
		
		WebElement searchInc1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//input)[1]"));
		searchInc1.sendKeys(incident,Keys.ENTER);
	
		WebElement incLink1 = driver.findElement(By.xpath("(//table[@id='incident_table']//a[@class='linked formlink'])[1]"));
		incLink1.click();
		
		//screenshot after the updating the assignment group
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_update")));
		File screenshot2 = driver.getScreenshotAs(OutputType.FILE);
		File imageAfter = new File("./images/serviceNow/"+incidentResultNumber+"_afterAssignGroup"+".jpg");
		FileUtils.copyFile(screenshot2, imageAfter);
    }

}
