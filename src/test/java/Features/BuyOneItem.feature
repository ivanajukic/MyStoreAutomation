Feature: Buy item from the store

  Background: Open web browser and log in
    Given A browser is open
    And My Store Sign in page is open
    And User is logged in

  Scenario: Successfully buy one item
    When I select category Women
    And I click on one item
    And I add the item to cart
    And I proceed to checkout
    And I verify the shopping cart summary
    And I verify the address
    And I select shipping method
    And I select bank wire as payment type
    And I confirm my order
    Then My order is complete
    And Bought item is visible in Order History
