package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.ItemDetailsPage;
import pages.MainPage;
import pages.ShoppingPage;
import pages.SignInPage;
import org.junit.Assert;

public class ShoppingSteps {

    protected WebDriver driver;
    MainPage mainPage = new MainPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    ItemDetailsPage itemDetailsPage = new ItemDetailsPage();

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        // Assuming the browser is already initialized and navigated to the main page
        Assert.assertTrue("User is not on the main page", mainPage.isOnMainPage());
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        searchByItem(searchTerm);
    }

    @And("selects the first item from the search results")
    public void selectsTheFirstItemFromTheSearchResults() {
        shoppingPage.clickOnFirstItem();
    }

    @And("clicks the Add to Bag button")
    public void clicksTheAddToBagButton() {
        itemDetailsPage.clickOnFirstSizeButton();
        itemDetailsPage.clickAddToBagButton();
    }

    @Then("the item should be added to the shopping bag")
    public void theItemShouldBeAddedToTheShoppingBag() {
        String widgetText = getCartSuccessWidgetText();
        Assert.assertTrue("Item was not added to the bag", widgetText.contains("Item added to your bag"));
    }

    @And("the shopping bag should display the correct item count")
    public void theShoppingBagShouldDisplayTheCorrectItemCount() {
        int itemCount = shoppingPage.getShoppingBagItemCount();
        Assert.assertTrue("Shopping bag does not contain the correct item count", itemCount > 0);
    }

    public void SignIn(String userEmail, String userPassword)
    {
        SignInPage signInPage = new SignInPage();
        mainPage.clickSignIn();
        signInPage.enterUserEmail(userEmail);
        signInPage.enterUserPassword(userPassword);
        signInPage.clickSignIn();
    }

    public void searchByItem(String searchValue) {
        shoppingPage.searchByItemName(searchValue);
    }

    public String textOfFirstElementFromSearchResultsInLowerCase() {
        return shoppingPage.getTextOfFirstElementFromSearchResults().toLowerCase();
    }

    public void addItemToBag(){
        shoppingPage.clickOnFirstItem();
        itemDetailsPage.clickOnFirstSizeButton();
        itemDetailsPage.clickAddToBagButton();
    }

    public void viewShoppingCart(){
        shoppingPage.closeCartWidget();
        shoppingPage.viewShoppingCart();
    }

    public String getCartSuccessWidgetText(){
        return shoppingPage.getShoppingBagWidgetText();
    }
}
