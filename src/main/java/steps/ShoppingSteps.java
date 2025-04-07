package steps;

import pages.ShoppingBagPage;

public class ShoppingSteps {

    public void removeItemFromCart(){
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        shoppingBagPage.removeItemFromCart();
    }

    public String getCartTotal(){
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        return shoppingBagPage.getCartTotal();
    }

    public String getEmptyCartMessage(){
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        return shoppingBagPage.getEmptyCartMessage();
    }
}
