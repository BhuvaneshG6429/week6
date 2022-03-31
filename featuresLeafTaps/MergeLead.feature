Feature: Merge Lead in Leaftaps

#  Background: 
#    Given A Chrome browser is launched
#    And Load the Leaftaps url
#    And Maximize the browser

@functional
  Scenario Outline: TC004 Merge Lead
    Given Enter the username as <username>
    And Enter the password as <password>
    When the Login button is clicked
    Then The Welcome Page should be displayed
    When The CRM/SFA link is clicked
    Then The Home Page should be displayed
    When The Leads button is clicked in the home page
    Then The Leads Main Page should be displayed
    When The Merge Leads link is clicked in the Leads Main Page
    Then The Merge Leads Page should be displayed
    And Click on the From Lead lookup image
    And Click on First Resulting Lead on the new window
    Then Window should be changed to default
    And Click on the To Lead lookup image
    And Click on Second Resulting Lead on the new window
    Then Window should be changed to default again
    When Clicked on Merge button
    When The Alert is accepted
    Then View Lead Page should be displayed

    Examples: 
      | username           | password |
      | 'DemoSalesManager' | 'crmsfa' |
