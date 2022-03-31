package assignment.week6day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LearnRetry extends ProjectSpecificMethods{
	
	@Test
	public void createLead() {
		System.out.println(driver.findElement(By.tagName("title")).getText());
		
		//enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemosalesManager");
		//enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//click Login button
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		
		/*linktext provided as invalid value to fail test for checking retry*
		 * 
		 ----------------------IMPORTANT--------------------------------
		 */
		
		WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SF"));
		linkTextCRM.click();
		
		//click Leads
		WebElement leads = driver.findElement(By.linkText("Leads"));
		leads.click();
		
		//click on Create Lead from Side Menu
		WebElement createLead = driver.findElement(By.linkText("Create Lead"));
		createLead.click();
		
		//Enter mandatory fields to create lead
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("CTS");
		
		//Enter first name
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Bhuvanesh");
		
		//Enter last name
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("G");
		
		//Enter first name local
		WebElement firstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		firstNameLocal.sendKeys("Bhuvi");
		
		//Enter Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("testing");
		
		//Enter Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("sample description");
		
		//Enter phone number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("0000000001");
		
		//Enter mail
		WebElement primaryEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		primaryEmail.sendKeys("bhuvicheck@gmail.com");
		
		//Select state/province
		WebElement provinceElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select province=new Select(provinceElement);
		province.selectByVisibleText("New York");
		
		//click on create lead submit button
		WebElement submitCreateLeadButton = driver.findElement(By.className("smallSubmit"));
		submitCreateLeadButton.click();
	
		//get title of the landing page
		System.out.println("The title is "+driver.getTitle());
	}
	
	
	@Test
	public void mergeLead() {

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemosalesManager");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Merge Contact
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		
		//Click on Widget of From Contact
		WebElement fromWidget = driver.findElement(By.xpath("//span[text()='From Lead']//following::a[1]"));
		fromWidget.click();
		  
		//Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		WebElement firstRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//a[1]"));
		String firstRowText = firstRowValue.getText();
		firstRowValue.click();
		driver.switchTo().window(list.get(0));
		
		String fromLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).getAttribute("value");
		Assert.assertEquals(firstRowText, fromLeadValue);
		
		//Click on Widget of To Contact
		WebElement toWidget = driver.findElement(By.xpath("//span[text()='To Lead']//following::a[1]"));
		toWidget.click();
		  
		//Click on Second Resulting Contact
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(list1.get(1));
		
		WebElement secondRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[1]"));
		String secondRowText = secondRowValue.getText();
		secondRowValue.click();
		driver.switchTo().window(list.get(0));
		
		String toLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).getAttribute("value");
		Assert.assertEquals(secondRowText, toLeadValue);
		  
		//Click on Merge button using Xpath Locator
		  driver.findElement(By.xpath("//form[@name='MergePartyForm']//child::a[text()='Merge']")).click();
		//Accept the Alert
		  
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
		//Verify the title of the page
		 
		Assert.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");
		}
	
}
