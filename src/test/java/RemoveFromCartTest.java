package test.java;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        MainPage mainPage = new MainPage();
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

        // Step 1: Open application main page by URL
        mainPage.open();

        // Step 2: Search for the item 'Sneakers'
        mainPage.searchForItem("Sneakers");

        // Step 3: Click on the item
        mainPage.clickOnItem("Sneakers");

        // Step 4: Select any available size
        itemDetailsPage.clickOnFirstSizeButton();

        // Step 5: Click on 'Add to Cart' button
        itemDetailsPage.clickAddToBagButton();

        // Step 6: Navigate to the shopping cart
        mainPage.navigateToShoppingCart();

        // Step 7: Verify the item is present in the cart
        String itemName = shoppingBagPage.itemAddedToBagWidgetGetText();
        assertEquals("Sneakers", itemName);

        // Step 8: Click on 'Remove' button next to the item
        shoppingBagPage.removeItemFromCart("Sneakers");

        // Step 9: Verify the item is removed from the cart
        assertTrue(shoppingBagPage.isItemRemovedFromCart("Sneakers"));

        // Step 10: Verify the cart total is updated
        assertEquals("0", shoppingBagPage.getCartTotal());

        // Step 11: If the cart is empty, verify the message 'Your shopping bag is empty. Start shopping and check out our new arrivals.' is displayed.
        assertTrue(shoppingBagPage.isCartEmptyMessageDisplayed());
    }
}
