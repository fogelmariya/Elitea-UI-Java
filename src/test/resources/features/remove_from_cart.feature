Feature: Remove item from shopping cart

  Scenario: User removes an item from the shopping cart
    Given the user is on the main page
    When the user searches for "Sneakers"
    And selects an item from the search results
    And adds the item to the cart
    And navigates to the shopping cart
    Then the item should be present in the cart
    When the user removes the item from the cart
    Then the item should be removed from the cart
    And the cart should be updated
    And the empty cart message should be displayed