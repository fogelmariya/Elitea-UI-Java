package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchResultsPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class RemoveFromCartSteps {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        searchResultsPage = mainPage.search(searchTerm);
    }

    @And("selects an item from the search results")
    public void selectsAnItemFromTheSearchResults() {
        productPage = searchResultsPage.selectFirstItem();
    }

    @And("adds the item to the cart")
    public void addsTheItemToTheCart() {
        productPage.addToCart();
    }

    @And("navigates to the shopping cart")
    public void navigatesToTheShoppingCart() {
        shoppingCartPage = productPage.goToShoppingCart();
    }

    @Then("the item should be present in the cart")
    public void theItemShouldBePresentInTheCart() {
        Assert.assertTrue("Item is not present in the cart", shoppingCartPage.isItemInCart());
    }

    @When("the user removes the item from the cart")
    public void theUserRemovesTheItemFromTheCart() {
        shoppingCartPage.removeItem();
    }

    @Then("the item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {
        Assert.assertFalse("Item is still present in the cart", shoppingCartPage.isItemInCart());
    }

    @And("the cart should be updated")
    public void theCartShouldBeUpdated() {
        Assert.assertTrue("Cart was not updated", shoppingCartPage.isCartUpdated());
    }

    @And("the empty cart message should be displayed")
    public void theEmptyCartMessageShouldBeDisplayed() {
        Assert.assertTrue("Empty cart message is not displayed", shoppingCartPage.isEmptyCartMessageDisplayed());
    }
}