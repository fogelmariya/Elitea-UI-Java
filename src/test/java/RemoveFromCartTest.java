import org.junit.Before;
import org.junit.Test;
import pages.ShoppingBagPage;
import org.junit.Assert;

public class RemoveFromCartTest extends BaseTest {
    private ShoppingBagPage shoppingBagPage;

    @Before
    public void setUp() {
        super.setUp();
        shoppingBagPage = new ShoppingBagPage();
    }

    @Test
    public void testRemoveItemFromCart() {
        shoppingBagPage.navigateToShoppingBag();

        // Ensure there's at least one item in the cart
        Assert.assertTrue("Shopping bag is empty", shoppingBagPage.getItemCount() > 0);

        // Remove the first item
        shoppingBagPage.removeFirstItem();

        // Verify the item was removed
        Assert.assertTrue("Item was not removed from the shopping bag", shoppingBagPage.isItemRemoved());

        // Verify the total was updated
        Assert.assertTrue("Shopping bag total was not updated", shoppingBagPage.isTotalUpdated());
    }
}