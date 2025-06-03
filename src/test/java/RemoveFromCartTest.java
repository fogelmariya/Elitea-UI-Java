import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import pages.MainPage;
import pages.ShoppingPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;
import core.Browser;
import core.BrowserFactory;

public class RemoveFromCartTest extends BaseTest {

    private MainPage mainPage;
    private ShoppingPage shoppingPage;
    private ItemDetailsPage itemDetailsPage;
    private ShoppingBagPage shoppingBagPage;

    @BeforeEach
    public void setUp() {
        Browser browser = BrowserFactory.getBrowser();
        mainPage = new MainPage(browser);
        shoppingPage = new ShoppingPage(browser);
        itemDetailsPage = new ItemDetailsPage(browser);
        shoppingBagPage = new ShoppingBagPage(browser);
    }

    @Test
    public void testRemoveItemFromShoppingCart() {
        // Navigate to the main page
        mainPage.open();

        // Search for an item (e.g., "T-shirt")
        mainPage.searchForItem("T-shirt");

        // Click on the first search result
        shoppingPage.clickFirstSearchResult();

        // Add the item to the cart
        itemDetailsPage.addToBag();

        // Go to the shopping bag
        shoppingBagPage.open();

        // Verify that the item is in the cart
        assertTrue(shoppingBagPage.isItemInCart("T-shirt"), "The item should be in the cart");

        // Remove the item from the cart
        shoppingBagPage.removeItem("T-shirt");

        // Verify that the item has been removed
        assertFalse(shoppingBagPage.isItemInCart("T-shirt"), "The item should not be in the cart");

        // Verify that the cart is empty
        assertTrue(shoppingBagPage.isCartEmpty(), "The cart should be empty");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        BrowserFactory.quitBrowser();
    }
}