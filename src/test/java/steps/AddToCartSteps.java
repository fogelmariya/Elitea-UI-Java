package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProductPage;
import pages.CartPage;

public class AddToCartSteps {

    private ProductPage productPage;
    private CartPage cartPage;

    public AddToCartSteps() {
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        productPage.navigateToProductPage();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        productPage.clickAddToCartButton();
    }

    @Then("the item should be added to my cart")
    public void theItemShouldBeAddedToMyCart() {
        Assert.assertTrue("Item was not added to the cart", cartPage.isItemInCart());
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        Assert.assertTrue("Confirmation message not displayed", productPage.isConfirmationMessageDisplayed());
    }

    @Then("the cart icon should update to reflect the new item count")
    public void theCartIconShouldUpdateToReflectTheNewItemCount() {
        Assert.assertTrue("Cart icon did not update", productPage.isCartIconUpdated());
    }
}