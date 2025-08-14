Feature: Remove item from shopping cart

  As an online shopper
  I want to remove items from my shopping cart
  So that I can exclude products I no longer wish to purchase

  Background:
    Given the user is logged in
    And the user has items in their shopping cart

  Scenario: Successfully remove an item from the shopping cart
    When the user views their shopping cart
    And the user clicks the remove button for a specific item
    Then the item should be removed from the cart
    And the cart total should be updated
    And a confirmation message should be displayed

  Scenario: Remove the last item from the shopping cart
    Given the user has only one item in their shopping cart
    When the user removes the last item
    Then the cart should be empty
    And the empty cart state should be displayed with product suggestions

  Scenario: Attempt to remove an item that doesn't exist in the cart
    When the user attempts to remove an item that is not in the cart
    Then an error message should be displayed
    And the cart contents should remain unchanged

  Scenario: Remove multiple items from the shopping cart
    Given the user has multiple items in their shopping cart
    When the user removes several items
    Then all selected items should be removed from the cart
    And the cart total should be updated accordingly

  Scenario: Cancel item removal
    When the user clicks the remove button for a specific item
    And a confirmation dialog appears
    And the user cancels the removal
    Then the item should remain in the cart
    And the cart total should remain unchanged