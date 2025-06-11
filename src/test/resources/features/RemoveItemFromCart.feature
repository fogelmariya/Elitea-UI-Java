Feature: Remove Item from Shopping Cart

Scenario: Remove single item from shopping cart
  Given the shopper has items in their shopping cart
  And the shopper is on the shopping cart page
  When the shopper clicks the "Remove" button for a specific item
  Then the item is removed from the shopping cart
  And the total cart value is recalculated
  And the shopping cart displays the updated list of items