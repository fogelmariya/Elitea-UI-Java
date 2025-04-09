package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;
import pages.BaseTest;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        MainPage mainPage = new MainPage();
        mainPage.openHomePage();
        mainPage.searchForItem("Sneakers");

        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        itemDetailsPage.selectSize("10");
        itemDetailsPage.addToCart();

        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        shoppingBagPage.openShoppingBag();
        Assertions.assertTrue(shoppingBagPage.isItemInCart("Sneakers"), "Item should be in the cart");

        shoppingBagPage.removeItemFromCart("Sneakers");
        Assertions.assertFalse(shoppingBagPage.isItemInCart("Sneakers"), "Item should be removed from the cart");
        Assertions.assertTrue(shoppingBagPage.isCartEmpty(), "Cart should be empty");
    }
}
