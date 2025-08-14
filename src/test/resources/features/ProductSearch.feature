Feature: Product Search

  As a user of the e-commerce website
  I want to be able to search for products
  So that I can find and purchase items I'm interested in

  Scenario: Search for a product by name
    Given I am on the homepage
    When I enter "laptop" into the search bar
    And I click the search button
    Then I should see a list of products related to "laptop"
    And the search results should contain at least 1 item