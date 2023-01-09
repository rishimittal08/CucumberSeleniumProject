Feature: NopCommerce login functionality

  Scenario: Verify the Home page title with valid credentials
    
    Given User launch Chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login 
    Then The page title is "Dashboard / nopCommerce administration"
    When User clicks on logout 
    Then page title is "Your store. Login"
    And close browser
