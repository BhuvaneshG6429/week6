package assignment.week6day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass{
	
				
				@When("Clicked on Duplicate Lead button")
				public void clicked_on_duplicate_lead_button() {
					driver.findElement(By.linkText("Duplicate Lead")).click();
				}

				@Then("Duplicate Lead page should be displayed")
				public void duplicate_lead_page_should_be_displayed() {
					driver.findElement(By.id("createLeadForm_companyName")).isDisplayed();
					
				}

				@Then("Edit the Company Name as {string}")
				public void edit_the_company_name_as(String companyNameDup) {
					driver.findElement(By.id("createLeadForm_companyName")).clear();
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyNameDup);
				}

				@Then("Edit the First Name as {string}")
				public void edit_the_first_name_as(String firstNameDup) {
					driver.findElement(By.id("createLeadForm_firstName")).clear();
					driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstNameDup);
				}

				@Then("Click on Create Lead button")
				public void click_on_create_lead_button() {
					driver.findElement(By.className("smallSubmit")).click();
				}

				@Then("Then The Created Lead should be displayed on the View Lead Page")
				public void then_the_created_lead_should_be_displayed_on_the_view_lead_page() {
					System.out.println("The title is "+driver.getTitle());
				}

	}


