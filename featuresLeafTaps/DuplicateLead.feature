Feature: Duplicate Lead in Leaftaps

#Background:
#Given A Chrome browser is launched
#And Load the Leaftaps url
#And Maximize the browser

@functional
Scenario Outline: TC003 Duplicate Lead
Given Enter the username as <username>
And Enter the password as <password>
When the Login button is clicked
Then The Welcome Page should be displayed
When The CRM/SFA link is clicked
Then The Home Page should be displayed
When The Leads button is clicked in the home page
Then The Leads Main Page should be displayed
When The Create Lead link is clicked in the Leads Main Page
Then The Create Lead Form should be displayed
And Enter the Company Name as <companyName>
And Enter the First Name as <firstName>
And Enter the Last Name as <lastName>
When The Create Lead button is clicked
Then The Created Lead should be displayed on the View Lead Page
When Clicked on Duplicate Lead button
Then Duplicate Lead page should be displayed
And Edit the Company Name as <companyNameDup>
And Edit the First Name as <firstNameDup>
And Click on Create Lead button
Then Then The Created Lead should be displayed on the View Lead Page

Examples:
|username|password|companyName|firstName|lastName|companyNameDup|firstNameDup|
|'DemoSalesManager'|'crmsfa'|'CTS'|'Ganesh'|'G'|'TCS'|'Bhuvanesh'|