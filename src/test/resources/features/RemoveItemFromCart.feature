Feature: Remove Item from Shopping Cart

  Scenario: Remove single item from cart
    Given the shopper is viewing their shopping cart
    And the cart contains 1 item
    When the shopper clicks the "Remove" button next to the item
    Then the item is removed from the cart
    And the cart total is recalculated and displayed
    And a confirmation message is shown indicating the item has been removed