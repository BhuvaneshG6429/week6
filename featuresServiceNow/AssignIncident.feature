Feature: Assign Incident

Scenario Outline: TC003 Assign Incident
Given Enter the username as <username>
And Enter the password as <password>
And the Login button is clicked
Then The Home Page should be displayed
Then Search Incidents using the filter navigator
And Click on All
And Searched with the Incident <incident>
Then Click on the resulting incident from incident table
When Clicked on the assignment group lookup
Then Select <assignmentGroup> as assignment group name and click Update button
Then Check if the assignment group is updated for the incident <incident>

Examples:
|username|password|incident|assignmentGroup|
|'admin'|'ONDBoct@2021'|'INC0010013'|'Software'|