import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import core.Browser;
import pages.MainPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveItemFromCartTest {
    private Browser browser;
    private MainPage mainPage;
    private ItemDetailsPage itemDetailsPage;
    private ShoppingBagPage shoppingBagPage;

    @Before
    public void setUp() {
        // Initialize the browser and page objects
        browser = new Browser();
        mainPage = new MainPage(browser);
        itemDetailsPage = new ItemDetailsPage(browser);
        shoppingBagPage = new ShoppingBagPage(browser);
    }

    @Test
    public void testRemoveItemFromCart() {
        // Step 1: Open application main page by URL
        mainPage.open();

        // Step 2: Search for the item 'Sneakers'
        mainPage.searchForItem("Sneakers");

        // Step 3: Click on the item
        mainPage.clickOnItem("Sneakers");

        // Step 4: Select any available size
        itemDetailsPage.selectSize("M");

        // Step 5: Click on 'Add to Cart' button
        itemDetailsPage.addToCart();

        // Step 6: Navigate to the shopping cart
        mainPage.navigateToCart();

        // Step 7: Verify the item is present in the cart
        assertTrue(shoppingBagPage.isItemInCart("Sneakers"));

        // Step 8: Click on 'Remove' button next to the item
        shoppingBagPage.removeItemFromCart("Sneakers");

        // Step 9: Verify the item is removed from the cart
        assertFalse(shoppingBagPage.isItemInCart("Sneakers"));

        // Step 10: Verify the cart total is updated
        assertEquals("$0.00", shoppingBagPage.getCartTotal());

        // Step 11: Verify the message 'Your shopping bag is empty. Start shopping and check out our new arrivals.' is displayed
        assertTrue(shoppingBagPage.isEmptyCartMessageDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        browser.quit();
    }
}
