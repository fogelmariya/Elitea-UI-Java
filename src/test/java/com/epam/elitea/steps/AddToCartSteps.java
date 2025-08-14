package com.epam.elitea.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import com.epam.elitea.pages.ProductPage;
import com.epam.elitea.pages.CartPage;

public class AddToCartSteps {

    private ProductPage productPage;
    private CartPage cartPage;

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        productPage = new ProductPage();
        productPage.open();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        productPage.clickButton(buttonName);
    }

    @Then("the item should be added to my cart")
    public void theItemShouldBeAddedToMyCart() {
        cartPage = new CartPage();
        Assert.assertTrue("Item was not added to the cart", cartPage.isItemInCart());
    }

    @And("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        Assert.assertTrue("Confirmation message not displayed", productPage.isConfirmationMessageDisplayed());
    }

    @And("the cart icon should update to reflect the new item count")
    public void theCartIconShouldUpdateToReflectTheNewItemCount() {
        Assert.assertTrue("Cart icon did not update", productPage.isCartIconUpdated());
    }
}