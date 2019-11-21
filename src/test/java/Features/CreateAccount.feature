Feature: Create an account on My Store page

  Background: Open web browser
    Given A browser is open

  Scenario: Login with valid credentials
    Given My Store Sign in page is open
    When I insert correct email address
    And I click the option to create an account
    And I insert all needed information
    And I click on button to create account
    Then My account page is open