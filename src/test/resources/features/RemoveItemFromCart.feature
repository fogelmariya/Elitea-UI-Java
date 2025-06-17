Feature: Remove Item from Shopping Cart

  Scenario: User removes an item from the shopping cart
    Given the user is on the shopping bag page
    And the shopping bag contains at least one item
    When the user removes an item from the shopping bag
    Then the item should be removed from the shopping bag
    And the shopping bag total should be updated accordingly