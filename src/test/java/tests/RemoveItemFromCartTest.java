import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import steps.ShoppingSteps;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void verifyRemoveItemFromCart() {
        String searchValue = "Sneaker";
        MainPage mainPage = new MainPage();
        ShoppingSteps shoppingSteps = new ShoppingSteps();

        // Search for the item
        shoppingSteps.searchByItem(searchValue);
        mainPage.closeCouponWidgetIfVisible();

        // Add item to cart
        shoppingSteps.addItemToBag();
        Assert.assertEquals("Item Added to Bag", shoppingSteps.getCartSuccessWidgetText().trim());

        // View shopping cart
        shoppingSteps.viewShoppingCart();
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        Assert.assertTrue(shoppingBagPage.itemAddedToBagWidgetGetText().contains(searchValue));

        // Remove item from cart
        shoppingSteps.removeItemFromCart();
        Assert.assertFalse(shoppingBagPage.itemAddedToBagWidgetGetText().contains(searchValue));

        // Verify cart total is updated
        String cartTotal = shoppingSteps.getCartTotal();
        Assert.assertEquals("0.00", cartTotal);

        // Verify empty cart message
        String emptyCartMessage = shoppingSteps.getEmptyCartMessage();
        Assert.assertEquals("Your shopping bag is empty. Start shopping and check out our new arrivals.", emptyCartMessage);
    }
}
