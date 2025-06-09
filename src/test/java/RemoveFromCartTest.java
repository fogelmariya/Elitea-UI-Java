import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import pages.MainPage;
import pages.ShoppingPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveFromCartTest extends BaseTest {

    private MainPage mainPage;
    private ShoppingPage shoppingPage;
    private ItemDetailsPage itemDetailsPage;
    private ShoppingBagPage shoppingBagPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        shoppingPage = new ShoppingPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        shoppingBagPage = new ShoppingBagPage(driver);
    }

    @Test
    public void testRemoveItemFromShoppingCart() {
        // 1. Open application main page by URL
        mainPage.open();

        // 2. Search for the item 'Sneakers'
        mainPage.searchForItem("Sneakers");

        // 3. Click on the item
        shoppingPage.clickOnFirstItem();

        // 4. Select any available size
        itemDetailsPage.selectFirstAvailableSize();

        // 5. Click on 'Add to Cart' button
        itemDetailsPage.addToCart();

        // 6. Navigate to the shopping cart
        shoppingBagPage.open();

        // 7. Verify the item is present in the cart
        assertTrue(shoppingBagPage.isItemInCart("Sneakers"), "Sneakers should be present in the cart");

        // 8. Click on 'Remove' button next to the item
        shoppingBagPage.removeItem("Sneakers");

        // 9. Verify the item is removed from the cart
        assertFalse(shoppingBagPage.isItemInCart("Sneakers"), "Sneakers should be removed from the cart");

        // 10. Verify the cart total is updated
        assertEquals(0, shoppingBagPage.getCartTotal(), "Cart total should be 0 after removing the item");

        // 11. If the cart is empty, verify the message is displayed
        assertTrue(shoppingBagPage.isEmptyCartMessageDisplayed(), "Empty cart message should be displayed");
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}