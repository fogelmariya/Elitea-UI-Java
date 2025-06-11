import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        MainPage mainPage = new MainPage();
        mainPage.open();

        mainPage.searchForItem("Sneakers");
        ItemDetailsPage itemDetailsPage = mainPage.clickOnFirstItem();

        itemDetailsPage.selectFirstAvailableSize();
        itemDetailsPage.clickAddToBag();

        ShoppingBagPage shoppingBagPage = itemDetailsPage.navigateToShoppingBag();

        Assert.assertTrue("Item is not present in the cart", shoppingBagPage.isItemPresentInCart());

        shoppingBagPage.removeItemFromCart();

        Assert.assertFalse("Item is still present in the cart", shoppingBagPage.isItemPresentInCart());
        Assert.assertTrue("Cart total was not updated", shoppingBagPage.isCartTotalUpdated());

        if (shoppingBagPage.isCartEmpty()) {
            String expectedMessage = "Your shopping bag is empty. Start shopping and check out our new arrivals.";
            Assert.assertEquals("Empty cart message is incorrect", expectedMessage, shoppingBagPage.getEmptyCartMessage());
        }
    }
}