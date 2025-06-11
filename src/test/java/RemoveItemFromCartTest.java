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

        // Step 1: Open application main page
        mainPage.openMainPage();

        // Step 2: Search for the item 'Sneakers'
        shoppingPage.searchByItemName("Sneakers");

        // Step 3: Click on the item
        shoppingPage.clickOnFirstItem();

        // Step 4: Select any available size
        itemDetailsPage.clickOnFirstSizeButton();

        // Step 5: Click on 'Add to Cart' button
        itemDetailsPage.clickAddToBagButton();

        // Step 6: Navigate to the shopping cart
        shoppingPage.closeCartWidget();
        shoppingPage.viewShoppingCart();

        // Step 7: Verify the item is present in the cart
        Assert.assertTrue("Item is not present in the cart", shoppingBagPage.isItemPresentInCart());

        // Step 8: Click on 'Remove' button next to the item
        shoppingBagPage.removeItemFromCart();

        // Step 9: Verify the item is removed from the cart
        Assert.assertFalse("Item is still present in the cart", shoppingBagPage.isItemPresentInCart());

        // Step 10: Verify the cart total is updated
        Assert.assertTrue("Cart total was not updated", shoppingBagPage.isCartTotalUpdated());

        // Step 11: If the cart is empty, verify the message
        if (shoppingBagPage.isCartEmpty()) {
            String expectedMessage = "Your shopping bag is empty. Start shopping and check out our new arrivals.";
            Assert.assertEquals("Empty cart message is incorrect", expectedMessage, shoppingBagPage.getEmptyCartMessage());
        }
    }
}