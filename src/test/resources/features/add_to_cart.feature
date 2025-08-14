Feature: Add item to shopping cart

  Scenario: Successfully add an item to the cart
    Given I am on a product page
    When I click the "Add to Cart" button
    Then the item should be added to my cart
    And I should see a confirmation message
    And the cart icon should update to reflect the new item count