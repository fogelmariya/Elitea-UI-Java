Feature: Remove item from shopping bag

  Scenario: User removes an item from the shopping bag
    Given the user is on the shopping bag page
    And the shopping bag contains at least one item
    When the user clicks the remove button for an item
    Then the item should be removed from the shopping bag
    And the shopping bag total should be updated
    And a confirmation message should be displayed