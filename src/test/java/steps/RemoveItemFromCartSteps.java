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
    private String itemName;

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        mainPage = new MainPage();
        mainPage.open();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        mainPage.searchForItem(searchTerm);
    }

    @And("the user clicks on the item")
    public void theUserClicksOnTheItem() {
        itemDetailsPage = mainPage.clickOnFirstSearchResult();
        itemName = itemDetailsPage.getItemName();
    }

    @And("the user selects an available size")
    public void theUserSelectsAnAvailableSize() {
        itemDetailsPage.selectFirstAvailableSize();
    }

    @And("the user clicks on {string} button")
    public void theUserClicksOnButton(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            itemDetailsPage.clickAddToBagButton();
        } else if (buttonName.equals("Remove")) {
            shoppingBagPage.clickRemoveButton();
        }
    }

    @And("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        shoppingBagPage = itemDetailsPage.navigateToShoppingBag();
    }

    @Then("the item should be present in the cart")
    public void theItemShouldBePresentInTheCart() {
        Assert.assertTrue("Item is not present in the cart", shoppingBagPage.isItemPresentInCart(itemName));
    }

    @Then("the item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {
        Assert.assertFalse("Item is still present in the cart", shoppingBagPage.isItemPresentInCart(itemName));
    }

    @And("the cart total should be updated")
    public void theCartTotalShouldBeUpdated() {
        String cartTotal = shoppingBagPage.getCartTotal();
        Assert.assertNotNull("Cart total is null", cartTotal);
    }

    @And("if the cart is empty, the message {string} should be displayed")
    public void ifTheCartIsEmptyTheMessageShouldBeDisplayed(String expectedMessage) {
        if (shoppingBagPage.isCartEmpty()) {
            String actualMessage = shoppingBagPage.getEmptyCartMessage();
            Assert.assertEquals("Empty cart message is incorrect", expectedMessage, actualMessage);
        }
    }
}