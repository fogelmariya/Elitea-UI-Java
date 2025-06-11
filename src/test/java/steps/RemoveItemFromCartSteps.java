package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.MainPage;
import pages.ItemDetailsPage;
import pages.ShoppingBagPage;

public class RemoveItemFromCartSteps {

    private MainPage mainPage;
    private ItemDetailsPage itemDetailsPage;
    private ShoppingBagPage shoppingBagPage;

    @Given("the user is on the application main page")
    public void userIsOnMainPage() {
        mainPage = new MainPage();
        mainPage.open();
    }

    @When("the user searches for {string}")
    public void userSearchesForItem(String item) {
        mainPage.searchForItem(item);
    }

    @And("the user clicks on the item")
    public void userClicksOnItem() {
        itemDetailsPage = mainPage.clickOnFirstItem();
    }

    @And("the user selects an available size")
    public void userSelectsAvailableSize() {
        itemDetailsPage.selectFirstAvailableSize();
    }

    @And("the user clicks on 'Add to Cart' button")
    public void userClicksAddToCart() {
        itemDetailsPage.clickAddToBag();
    }

    @And("the user navigates to the shopping cart")
    public void userNavigatesToShoppingCart() {
        shoppingBagPage = itemDetailsPage.navigateToShoppingBag();
    }

    @Then("the item should be present in the cart")
    public void itemShouldBePresentInCart() {
        Assert.assertTrue("Item is not present in the cart", shoppingBagPage.isItemPresentInCart());
    }

    @When("the user clicks on 'Remove' button next to the item")
    public void userClicksRemoveButton() {
        shoppingBagPage.removeItemFromCart();
    }

    @Then("the item should be removed from the cart")
    public void itemShouldBeRemovedFromCart() {
        Assert.assertFalse("Item is still present in the cart", shoppingBagPage.isItemPresentInCart());
    }

    @And("the cart total should be updated")
    public void cartTotalShouldBeUpdated() {
        Assert.assertTrue("Cart total was not updated", shoppingBagPage.isCartTotalUpdated());
    }

    @And("if the cart is empty, the message {string} should be displayed")
    public void emptyCartMessageShouldBeDisplayed(String expectedMessage) {
        if (shoppingBagPage.isCartEmpty()) {
            Assert.assertEquals("Empty cart message is incorrect", expectedMessage, shoppingBagPage.getEmptyCartMessage());
        }
    }
}