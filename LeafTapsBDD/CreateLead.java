package assignment.week6day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{

//	@Given("A Chrome browser is launched")
//	public void a_chrome_browser_is_launched() {
//	    // Write code here that turns the phrase above into concrete actions
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//
//	@And("Load the Leaftaps url")
//	public void load_the_leaftaps_url() {
//	    // Write code here that turns the phrase above into concrete actions
//		driver.get("http://leaftaps.com/opentaps/control/login");
//	}
//
//	@And("Maximize the browser")
//	public void maximize_the_browser() {
//	    // Write code here that turns the phrase above into concrete actions
//	    driver.manage().window().maximize();
//	}
	
	@Given("Enter the username as {string}")
	public void enter_the_username_as_demo_sales_manager(String username) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement usernameEle = driver.findElement(By.id("username"));
		usernameEle.sendKeys(username);
		
	}

	@And("Enter the password as {string}")
	public void enter_the_password_as_crmsfa(String password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement passwordEle = driver.findElement(By.id("password"));
		passwordEle.sendKeys(password);
	}

	@When("the Login button is clicked")
	public void the_login_button_is_clicked() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
	}
	
	@Then("The Welcome Page should be displayed")
	public void the_welcome_page_should_be_displayed() {
		driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
	}
	
	@When("The CRM\\/SFA link is clicked")
	public void the_crm_sfa_link_is_clicked() {
		WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SFA"));
		linkTextCRM.click();
	}

	@Then("The Home Page should be displayed")
	public void the_home_page_should_be_displayed() {
		driver.findElement(By.linkText("Leads")).isDisplayed();
	}

	@When("The Leads button is clicked in the home page")
	public void the_leads_button_is_clicked_in_the_home_page() {
		WebElement leads = driver.findElement(By.linkText("Leads"));
		leads.click();
	}

	@Then("The Leads Main Page should be displayed")
	public void the_leads_main_page_should_be_displayed() {
		driver.findElement(By.linkText("Create Lead")).isDisplayed();
	}
	
	@When("The Create Lead link is clicked in the Leads Main Page")
	public void the_create_lead_link_is_clicked_in_the_leads_main_page() {
		WebElement createLead = driver.findElement(By.linkText("Create Lead"));
		createLead.click();
	}

	@Then("The Create Lead Form should be displayed")
	public void the_create_lead_form_should_be_displayed() {
		driver.findElement(By.id("createLeadForm_companyName")).isDisplayed();
	}

	@Then("Enter the Company Name as {string}")
	public void enter_the_company_name_as_cts(String companyName) {
		WebElement companyNameEle = driver.findElement(By.id("createLeadForm_companyName"));
		companyNameEle.sendKeys(companyName);
	}

	@Then("Enter the First Name as {string}")
	public void enter_the_first_name_as_bhuvanesh(String firstName) {
		WebElement firstNameEle = driver.findElement(By.id("createLeadForm_firstName"));
		firstNameEle.sendKeys(firstName);
	}

	@Then("Enter the Last Name as {string}")
	public void enter_the_last_name_as_g(String lastName) {
		WebElement lastNameEle = driver.findElement(By.id("createLeadForm_lastName"));
		lastNameEle.sendKeys(lastName);
	}

	@When("The Create Lead button is clicked")
	public void the_create_lead_button_is_clicked() {
		WebElement submitCreateLeadButton=driver.findElement(By.className("smallSubmit"));
		submitCreateLeadButton.click();
	}

	@Then("The Created Lead should be displayed on the View Lead Page")
	public void the_created_lead_should_be_displayed_on_the_view_lead_page() {
		System.out.println("The title is "+driver.getTitle());
	}
}
