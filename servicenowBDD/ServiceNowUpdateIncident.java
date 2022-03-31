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

import com.fasterxml.jackson.databind.ObjectReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ServiceNowUpdateIncident extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String incidentResultNumber="";
		
		
	    @Then("Click on the resulting incident from incident table")
	    public void click_on_the_resulting_incident_from_incident_table() throws Throwable {
	    	WebElement incLink = driver.findElement(By.xpath("(//table[@id='incident_table']//a[@class='linked formlink'])[1]"));
			incidentResultNumber = incLink.getText();
			incLink.click();
	    }


	    @Then("Check Incident has been Updated")
	    public void check_incident_has_been_updated() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='incident_table']")));
			//search the updated incident
			WebElement selectListBox1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//select)[1]"));
			Select select1 = new Select(selectListBox1);
			select1.selectByVisibleText("Number");
			
			WebElement searchInc1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//input)[1]"));
			searchInc1.sendKeys("INC0010013",Keys.ENTER);
		
			WebElement incLink1 = driver.findElement(By.xpath("(//table[@id='incident_table']//a[@class='linked formlink'])[1]"));
			incLink1.click();
			//screenshot after the updating the incident state
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_update")));
			File screenshot2 = driver.getScreenshotAs(OutputType.FILE);
			File imageAfter = new File("./images/serviceNow/"+incidentResultNumber+"_after"+".jpg");
			FileUtils.copyFile(screenshot2, imageAfter);
	    }

	    @And("Searched with the Incident {string}")
	    public void searched_with_the_incident(String incident) throws Throwable {
	    	driver.switchTo().frame("gsft_main");
			WebElement selectListBox = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//select)[1]"));
			Select select = new Select(selectListBox);
			select.selectByVisibleText("Number");
			
			WebElement searchInc = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//input)[1]"));
			searchInc.sendKeys(incident,Keys.ENTER);
			
	    }

	    @And("Change the incident state and click Update button")
	    public void change_the_incident_state_and_click_update_button() throws Throwable {
	    	WebElement updateButton = driver.findElement(By.id("sysverb_update"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_update")));
			
			//screenshot before updating the incident
			File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
			File imageBefore = new File("./images/serviceNow/"+incidentResultNumber+"_before"+".jpg");
			FileUtils.copyFile(screenshot1, imageBefore);
			
			String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
			Assert.assertEquals(incidentResultNumber, incidentNumber);
			
			//update the incident state
			WebElement selectState = driver.findElement(By.id("incident.state"));
			Select selectIncState = new Select(selectState);
			if(selectIncState.getFirstSelectedOption().getText().equals("New")) {
				selectIncState.selectByVisibleText("In Progress");
			}
			else{
				selectIncState.selectByVisibleText("New");
			}
			
			updateButton.click();
	    }
	    
}
