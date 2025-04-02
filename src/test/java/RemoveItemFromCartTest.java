import org.junit.Assert;
import org.junit.Test;
pages.MainPage;
pages.ShoppingPage;
pages.ItemDetailsPage;
pages.ShoppingBagPage;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        // Step 1: Open application main page by URL
        MainPage mainPage = new MainPage();
        mainPage.open();

        // Step 2: Search for the item 'Sneakers'
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.searchByItemName("Sneakers");

        // Step 3: Click on the item
        shoppingPage.clickOnFirstItem();

        // Step 4: Select any available size
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        itemDetailsPage.clickOnFirstSizeButton();

        // Step 5: Click on 'Add to Cart' button
        itemDetailsPage.clickAddToBagButton();

        // Step 6: Navigate to the shopping cart
        shoppingPage.viewShoppingCart();

        // Step 7: Verify the item is present in the cart
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        String itemName = shoppingBagPage.itemAddedToBagWidgetGetText();
        Assert.assertTrue(itemName.contains("Sneakers"));

        // Step 8: Click on 'Remove' button next to the item
        shoppingBagPage.removeItemFromCart(itemName);

        // Step 9: Verify the item is removed from the cart
        Assert.assertFalse(shoppingBagPage.isItemInCart(itemName));

        // Step 10: Verify the cart total is updated
        double cartTotal = shoppingBagPage.getCartTotal();
        Assert.assertEquals(0.0, cartTotal, 0.01);

        // Step 11: If the cart is empty, verify the message is displayed
        if (shoppingBagPage.isCartEmpty()) {
            String emptyCartMessage = shoppingBagPage.getEmptyCartMessage();
            Assert.assertEquals("Your shopping bag is empty. Start shopping and check out our new arrivals.", emptyCartMessage);
        }
    }
}
