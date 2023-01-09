Feature: Search Customers Functionality

  Background: 
    Given User launch Chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User view Dashboard
    When User Click customer sidetab
    And Click on Customer link
    Then User can view Search page

  Scenario: Search for Customers by Email
    When User enters customer email
    And Click on Search
    Then User can view email in search table
    When User clicks on logout
    Then page title is "Your store. Login"
    And close browser

  Scenario: Search for Customers by Name
    When User enters customer name
    And Click on Search
    Then User can view name in search table
    When User clicks on logout
    Then page title is "Your store. Login"
    And close browser
