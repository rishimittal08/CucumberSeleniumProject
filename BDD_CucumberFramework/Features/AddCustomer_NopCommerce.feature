Feature: Customer Functionality

  Scenario: Add new Customer
    Given User launch Chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User view Dashboard
    When User Click customer sidetab
    And Click on Customer link
    And Click on Add new
    Then User can view Registration page
    When User fill the registration form
    And Click on Save
    Then User can view Confirmation "The new customer has been added successfully"
    When User clicks on logout
    Then page title is "Your store. Login"
    And close browser
