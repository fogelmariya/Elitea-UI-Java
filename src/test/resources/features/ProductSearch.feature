Feature: Product Search Functionality

  Scenario: Search for a product
    Given I am on the home page
    When I search for "dress"
    Then I should see search results for "dress"
    And the search results should contain at least 1 item