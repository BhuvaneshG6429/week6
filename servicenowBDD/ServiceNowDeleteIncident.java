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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ServiceNowDeleteIncident extends BaseClass{
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    @Then("Check if the incident {string} is deleted")
	    public void check_if_the_incident_is_deleted(String incident) throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='incident_hide_search']//select)[1]")));
			WebElement selectListBox1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//select)[1]"));
			Select select1 = new Select(selectListBox1);
			select1.selectByVisibleText("Number");
			
			WebElement searchInc1 = driver.findElement(By.xpath("(//span[@id='incident_hide_search']//input)[1]"));
			searchInc1.sendKeys(incident,Keys.ENTER);
			
			WebElement recordsDisplay = driver.findElement(By.xpath("//td[contains(text(),'No records to display')]"));
			if(recordsDisplay.isDisplayed()) {
				System.out.println("Incident has been deleted");
			}
			
			//screenshot after the updating the assignment group
			File screenshot2 = driver.getScreenshotAs(OutputType.FILE);
			File imageAfter = new File("./images/serviceNow/"+incident+"_afterDeleteIncident"+".jpg");
			FileUtils.copyFile(screenshot2, imageAfter);
	    }

	    @And("Click on the Delete button for the incident {string}")
	    public void click_on_the_delete_button(String incident) throws Throwable {
	    	WebElement deleteButton = driver.findElement(By.id("sysverb_delete"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_delete")));
			
			//screenshot before updating the assignment group
			File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
			File imageBefore = new File("./images/serviceNow/"+incident+"_beforeDeleteIncident"+".jpg");
			FileUtils.copyFile(screenshot1, imageBefore);
			
			//delete the incident
			deleteButton.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delete_confirm_form']")));
			driver.findElement(By.xpath("//div[@id='delete_confirm_form']//button[text()='Delete']")).click();
	    }

		
}
