package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ItemDetailsPage;
import pages.MainPage;
import pages.ShoppingPage;
import pages.SignInPage;
import pages.ShoppingBagPage;

public class ShoppingSteps {

    protected WebDriver driver;
    MainPage mainPage = new MainPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

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

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        mainPage.open();
        searchByItem("example product");
        shoppingPage.clickOnFirstItem();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            itemDetailsPage.clickOnFirstSizeButton();
            itemDetailsPage.clickAddToBagButton();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonName);
        }
    }

    @Then("the item should be added to my cart")
    public void theItemShouldBeAddedToMyCart() {
        viewShoppingCart();
        assert shoppingBagPage.hasItems();
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        assert !getCartSuccessWidgetText().isEmpty();
    }

    @Then("the cart icon should update to reflect the new item count")
    public void theCartIconShouldUpdateToReflectTheNewItemCount() {
        assert shoppingPage.getCartItemCount() > 0;
    }
}
