package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        mainPage.navigateToHomePage();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        searchByItem(searchTerm);
    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String searchTerm) {
        Assert.assertTrue("Search results do not contain the search term",
                textOfFirstElementFromSearchResultsInLowerCase().contains(searchTerm.toLowerCase()));
    }

    @Then("the search results should contain at least {int} item")
    public void theSearchResultsShouldContainAtLeastItem(int minItems) {
        Assert.assertTrue("Search results contain fewer items than expected",
                shoppingPage.getSearchResultsCount() >= minItems);
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
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
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
