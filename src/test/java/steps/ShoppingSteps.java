package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import org.junit.Assert;

public class ShoppingSteps {

    protected WebDriver driver;
    MainPage mainPage = new MainPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

    @Given("the user is on the application main page")
    public void userIsOnMainPage() {
        mainPage.openMainPage();
    }

    @When("the user searches for {string}")
    public void userSearchesForItem(String searchValue) {
        shoppingPage.searchByItemName(searchValue);
    }

    @And("the user clicks on the item")
    public void userClicksOnItem() {
        shoppingPage.clickOnFirstItem();
    }

    @And("the user selects an available size")
    public void userSelectsSize() {
        itemDetailsPage.clickOnFirstSizeButton();
    }

    @And("the user clicks on 'Add to Cart' button")
    public void userClicksAddToCart() {
        itemDetailsPage.clickAddToBagButton();
    }

    @And("the user navigates to the shopping cart")
    public void userNavigatesToShoppingCart() {
        shoppingPage.closeCartWidget();
        shoppingPage.viewShoppingCart();
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

    public void SignIn(String userEmail, String userPassword)
    {
        SignInPage signInPage = new SignInPage();
        mainPage.clickSignIn();
        signInPage.enterUserEmail(userEmail);
        signInPage.enterUserPassword(userPassword);
        signInPage.clickSignIn();
    }

    public String textOfFirstElementFromSearchResultsInLowerCase() {
        return shoppingPage.getTextOfFirstElementFromSearchResults().toLowerCase();
    }

    public String getCartSuccessWidgetText(){
        return shoppingPage.getShoppingBagWidgetText();
    }
}
