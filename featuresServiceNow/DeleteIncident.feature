Feature: Delete Incident

Scenario Outline: TC004 Delete Incident
Given Enter the username as <username>
And Enter the password as <password>
And the Login button is clicked
Then The Home Page should be displayed
Then Search Incidents using the filter navigator
And Click on All
And Searched with the Incident <incident>
Then Click on the resulting incident from incident table
And Click on the Delete button for the incident <incident>
Then Check if the incident <incident> is deleted

Examples:
|username|password|incident|
|'admin'|'ONDBoct@2021'|'INC0010023'|