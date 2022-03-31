Feature: Edit Lead in Leaftaps

#Background:
#Given A Chrome browser is launched
#And Load the Leaftaps url
#And Maximize the browser

@smoke@regression
Scenario Outline: TC002 Edit Lead
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
When Clicked on Edit button
Then Edit Lead page should be displayed
And Edit the Important Note as <importantNote>
And Click on Update button
Then Then The Edited Lead should be displayed on the View Lead Page

Examples:
|username|password|companyName|firstName|lastName|importantNote|
|'DemoSalesManager'|'crmsfa'|'CTS'|'Ganesh'|'G'|'sampleImportantNote'|