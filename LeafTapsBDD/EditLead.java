package assignment.week6day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass{
	
	@When("Clicked on Edit button")
	public void clicked_on_edit_button() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Then("Edit Lead page should be displayed")
	public void edit_lead_page_should_be_displayed() {
		driver.findElement(By.id("updateLeadForm_description")).isDisplayed();
	}

	@Then("Edit the Important Note as {string}")
	public void edit_the_important_note_as(String impNote) {
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys(impNote);
	}


	@Then("Click on Update button")
	public void click_on_update_button() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("Then The Edited Lead should be displayed on the View Lead Page")
	public void then_the_edited_lead_should_be_displayed_on_the_view_lead_page() {
		System.out.println("The title is "+driver.getTitle());
	}
}
