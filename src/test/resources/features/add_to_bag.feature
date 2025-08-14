Feature: Add item to shopping bag

  Scenario: User adds an item to the shopping bag
    Given the user is on the main page
    When the user searches for "T-shirt"
    And selects the first item from the search results
    And clicks the Add to Bag button
    Then the item should be added to the shopping bag
    And the shopping bag should display the correct item count