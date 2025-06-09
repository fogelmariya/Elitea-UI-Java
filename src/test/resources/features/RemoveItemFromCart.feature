Feature: Remove Item from Shopping Cart

  Scenario: User removes an item from the shopping cart
    Given the user is on the main page
    When the user searches for "Sneakers"
    And the user clicks on the item
    And the user selects an available size
    And the user clicks on "Add to Cart" button
    And the user navigates to the shopping cart
    Then the item should be present in the cart
    When the user clicks on "Remove" button next to the item
    Then the item should be removed from the cart
    And the cart total should be updated
    And if the cart is empty, the message "Your shopping bag is empty. Start shopping and check out our new arrivals." should be displayed