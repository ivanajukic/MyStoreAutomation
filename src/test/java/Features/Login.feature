Feature: Login to My Store page

  Background: Open web browser
    Given A browser is open

  Scenario: Login with valid credentials
    Given My Store Sign in page is open
    When I insert existing email address
    And I insert correct password
    And I click login button
    Then My account page is open