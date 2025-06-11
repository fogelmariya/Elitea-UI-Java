import org.junit.Test;
import org.junit.Assert;
import pages.*;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        MainPage mainPage = new MainPage();
        mainPage.open();

        ShoppingPage shoppingPage = mainPage.search("Sneakers");
        ItemDetailsPage itemDetailsPage = shoppingPage.clickFirstItem();
        
        itemDetailsPage.selectAvailableSize();
        itemDetailsPage.addToCart();
        
        ShoppingBagPage shoppingBagPage = itemDetailsPage.goToShoppingBag();
        
        Assert.assertTrue("Item is not present in the cart", shoppingBagPage.isItemInCart("Sneakers"));
        
        shoppingBagPage.removeItem("Sneakers");
        
        Assert.assertFalse("Item is still present in the cart", shoppingBagPage.isItemInCart("Sneakers"));
        Assert.assertTrue("Cart total was not updated", shoppingBagPage.isCartTotalUpdated());
        
        if (shoppingBagPage.isCartEmpty()) {
            String expectedMessage = "Your shopping bag is empty. Start shopping and check out our new arrivals.";
            Assert.assertEquals("Empty cart message is incorrect", expectedMessage, shoppingBagPage.getEmptyCartMessage());
        }
    }
}