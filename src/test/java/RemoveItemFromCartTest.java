import org.junit.Test;
import org.junit.Assert;
import pages.MainPage;
import pages.ShoppingPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        MainPage mainPage = new MainPage();
        ShoppingPage shoppingPage = new ShoppingPage();
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

        // 1. Open application main page by URL (handled in BaseTest)

        // 2. Search for the item 'Sneakers'
        mainPage.searchForItem("Sneakers");

        // 3. Click on the item
        shoppingPage.clickOnFirstItem();

        // 4. Select any available size
        itemDetailsPage.selectFirstAvailableSize();

        // 5. Click on 'Add to Cart' button
        itemDetailsPage.addToCart();

        // 6. Navigate to the shopping cart
        itemDetailsPage.goToShoppingBag();

        // 7. Verify the item is present in the cart
        Assert.assertTrue("Item should be present in the cart", shoppingBagPage.isItemInCart("Sneakers"));

        // 8. Click on 'Remove' button next to the item
        shoppingBagPage.removeItemFromCart("Sneakers");

        // 9. Verify the item is removed from the cart
        Assert.assertFalse("Item should be removed from the cart", shoppingBagPage.isItemInCart("Sneakers"));

        // 10. Verify the cart total is updated
        double expectedTotal = 0.0; // Assuming the cart is empty after removal
        Assert.assertEquals("Cart total should be updated", expectedTotal, shoppingBagPage.getCartTotal(), 0.01);

        // 11. If the cart is empty, verify the message
        String expectedEmptyCartMessage = "Your shopping bag is empty. Start shopping and check out our new arrivals.";
        Assert.assertTrue("Empty cart message should be displayed", shoppingBagPage.isEmptyCartMessageDisplayed(expectedEmptyCartMessage));
    }
}