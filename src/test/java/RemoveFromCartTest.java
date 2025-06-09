import org.junit.Test;
import pages.MainPage;
import pages.ShoppingPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;
import static org.junit.Assert.*;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromShoppingCart() {
        MainPage mainPage = new MainPage(driver);
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage(driver);

        // 1. Open application main page by URL
        mainPage.open();

        // 2. Search for the item 'Sneakers'
        mainPage.searchForItem("Sneakers");

        // 3. Click on the item
        shoppingPage.clickOnFirstItem();

        // 4. Select any available size
        itemDetailsPage.selectFirstAvailableSize();

        // 5. Click on 'Add to Cart' button
        itemDetailsPage.addToCart();

        // 6. Navigate to the shopping cart
        shoppingBagPage.open();

        // 7. Verify the item is present in the cart
        assertTrue("Item should be present in the cart", shoppingBagPage.isItemInCart("Sneakers"));

        // 8. Click on 'Remove' button next to the item
        shoppingBagPage.removeItem("Sneakers");

        // 9. Verify the item is removed from the cart
        assertFalse("Item should be removed from the cart", shoppingBagPage.isItemInCart("Sneakers"));

        // 10. Verify the cart total is updated
        assertEquals("Cart total should be 0", 0, shoppingBagPage.getCartTotal(), 0.01);

        // 11. If the cart is empty, verify the message
        assertTrue("Empty cart message should be displayed", 
            shoppingBagPage.isEmptyCartMessageDisplayed("Your shopping bag is empty. Start shopping and check out our new arrivals."));
    }
}