Feature: Update Incident

Scenario Outline: TC002 Update Incident
Given Enter the username as <username>
And Enter the password as <password>
And the Login button is clicked
Then The Home Page should be displayed
Then Search Incidents using the filter navigator
And Click on All
And Searched with the Incident <incident>
Then Click on the resulting incident from incident table
And Change the incident state and click Update button
Then Check Incident has been Updated

Examples:
|username|password|incident|
|'admin'|'ONDBoct@2021'|'INC0010013'|