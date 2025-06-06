Feature: Remove item from shopping cart

  Scenario: User removes an item from the shopping cart
    Given the user is on the main page
    When the user searches for "Sneakers"
    And selects the first item from the search results
    And chooses an available size
    And adds the item to the cart
    And navigates to the shopping bag
    Then the item should be present in the cart
    When the user removes the item from the cart
    Then the item should be removed from the cart
    And the cart total should be updated
    And the cart should be empty
    And an empty cart message should be displayed