Feature: Create New Incident

Scenario Outline: TC001 Create New Incident
Given Enter the username as <username>
And Enter the password as <password>
And the Login button is clicked
Then The Home Page should be displayed
Then Search Incidents using the filter navigator
And Click on All
When Clicked on New Button
Then The Create New Incident section should be displayed
When Clicked on Caller search button
Then From the resulting new window select first caller value
And Provide short description as <shortDescription>
Then Click on Submit button
Then Check Incident has been created

Examples:
|username|password|shortDescription|
|'admin'|'ONDBoct@2021'|'checking service now'|