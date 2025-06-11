package com.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import com.example.pages.CartPage;

public class RemoveItemFromCartStepDefinitions {

    private WebDriver driver;
    private CartPage cartPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        cartPage = new CartPage(driver);
    }

    @Given("the shopper is viewing their shopping cart")
    public void theShopperIsViewingTheirShoppingCart() {
        driver.get("https://www.example.com/cart");
    }

    @And("the cart contains {int} item")
    public void theCartContainsItem(int itemCount) {
        Assertions.assertEquals(itemCount, cartPage.getItemCount(), "Cart should contain " + itemCount + " item(s)");
    }

    @When("the shopper clicks the {string} button next to the item")
    public void theShopperClicksTheButtonNextToTheItem(String buttonText) {
        cartPage.removeItem();
    }

    @Then("the item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
        Assertions.assertEquals(0, cartPage.getItemCount(), "Cart should be empty");
    }

    @And("the cart total is recalculated and displayed")
    public void theCartTotalIsRecalculatedAndDisplayed() {
        Assertions.assertEquals("$0.00", cartPage.getCartTotal(), "Cart total should be $0.00");
    }

    @And("a confirmation message is shown indicating the item has been removed")
    public void aConfirmationMessageIsShownIndicatingTheItemHasBeenRemoved() {
        Assertions.assertTrue(cartPage.isRemovalConfirmationDisplayed(), "Removal confirmation should be displayed");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}