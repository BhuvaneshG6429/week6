package assignment.week6day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass{
	
	String leadID="";
	
	@When("The Find Lead link is clicked in the Leads Main Page")
	public void the_find_lead_link_is_clicked_in_the_leads_main_page() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	}

	@Then("The Find Lead Page should be displayed")
	public void the_find_lead_page_should_be_displayed() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).isDisplayed();
	}

	@Then("Click on the Phone tab under the Find By Section")
	public void click_on_the_phone_tab_under_the_find_by_section() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Then("Enter the Phone Number as {string}")
	public void enter_the_phone_number_as(String phoneNumber) {
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
	}

	@Then("Click on Find Leads button")
	public void click_on_find_leads_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
	}

	@Then("Select The First result from Lead list")
	public void select_the_first_result_from_lead_list() {
		WebElement leadIDFirstElement = driver.findElement(By.xpath("(//span[contains(text(),'Lead List')]//following::a[@class='linktext'])[1]"));
		 leadID= leadIDFirstElement.getText();
		leadIDFirstElement.click();
	}

	@When("Clicked on Delete button")
	public void clicked_on_delete_button() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@Then("Find Lead page should be displayed")
	public void find_lead_page_should_be_displayed() {
		driver.findElement(By.linkText("Find Leads")).isDisplayed();
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@Then("Enter the Lead ID captured from the Lead list before deletion")
	public void enter_the_lead_id_captured_from_the_lead_list_before_deletion() {
		driver.findElement(By.xpath("//span[text()='Name and ID']/following::input[@name='id']")).sendKeys(leadID);
		
	}

	@Then("Click on Find Leads Search button")
	public void click_on_find_leads_search_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@Then("No records should be displayed")
	public void no_records_should_be_displayed() {
		WebElement pageInfo = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String verificationMessage = pageInfo.getText();
		System.out.println("Verification message is "+verificationMessage);
		if(verificationMessage.equals("No records to display")) {
			System.out.println("verified the Lead is deleted");
		}
		else {
			System.out.println("Lead is not deleted");
		}
	}
}
