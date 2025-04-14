package test.java;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ShoppingPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveFromBagTest extends BaseTest {

    @Test
    public void testRemoveItemFromShoppingCart() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://application-url.com");

        MainPage mainPage = new MainPage(driver);
        mainPage.searchForItem("Sneakers");

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.clickOnItem("Sneakers");

        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        itemDetailsPage.selectSize("10");
        itemDetailsPage.addToCart();

        ShoppingBagPage shoppingBagPage = new ShoppingBagPage(driver);
        shoppingBagPage.navigateToCart();
        Assert.assertTrue(shoppingBagPage.isItemPresent("Sneakers"));

        shoppingBagPage.removeItem("Sneakers");
        Assert.assertFalse(shoppingBagPage.isItemPresent("Sneakers"));
        Assert.assertTrue(shoppingBagPage.isCartTotalUpdated());

        if (shoppingBagPage.isCartEmpty()) {
            Assert.assertEquals("Your shopping bag is empty. Start shopping and check out our new arrivals.", shoppingBagPage.getEmptyCartMessage());
        }

        driver.quit();
    }
}
