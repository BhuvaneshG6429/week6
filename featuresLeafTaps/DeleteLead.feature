Feature: Delete Lead in Leaftaps
#
#  Background: 
#    Given A Chrome browser is launched
#    And Load the Leaftaps url
#    And Maximize the browser

@functional
  Scenario Outline: TC004 Delete Lead
    Given Enter the username as <username>
    And Enter the password as <password>
    When the Login button is clicked
    Then The Welcome Page should be displayed
    When The CRM/SFA link is clicked
    Then The Home Page should be displayed
    When The Leads button is clicked in the home page
    Then The Leads Main Page should be displayed
    When The Find Lead link is clicked in the Leads Main Page
    Then The Find Lead Page should be displayed
    And Click on the Phone tab under the Find By Section
    And Enter the Phone Number as <phoneNumber>
    And Click on Find Leads button
    Then Select The First result from Lead list
    When Clicked on Delete button
    Then Find Lead page should be displayed
    Then Click on Find Leads button
    And Enter the Lead ID captured from the Lead list before deletion
    And Click on Find Leads Search button
    Then No records should be displayed

    Examples: 
      | username           | password | phoneNumber  |
      | 'DemoSalesManager' | 'crmsfa' | '0000000001' |
