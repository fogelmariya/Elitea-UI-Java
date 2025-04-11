import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ShoppingBagPage;
import steps.ShoppingSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveItemFromCartTest extends BaseTest {

    ShoppingSteps shoppingSteps = new ShoppingSteps();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

    @Test
    public void testRemoveItemFromCart() {
        shoppingSteps.searchByItem("Sneakers");
        shoppingSteps.addItemToBag();
        shoppingSteps.viewShoppingCart();
        
        String itemName = shoppingBagPage.itemAddedToBagWidgetGetText();
        assertEquals("Sneakers", itemName);
        
        shoppingBagPage.removeItemFromCart();
        
        String cartTotal = shoppingBagPage.getCartTotal();
        assertEquals("$0.00", cartTotal);
        
        String emptyCartMessage = shoppingBagPage.getEmptyCartMessage();
        assertEquals("Your shopping bag is empty. Start shopping and check out our new arrivals.", emptyCartMessage);
    }
}
