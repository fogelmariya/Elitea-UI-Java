package com.epam.elitea.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import com.epam.elitea.pages.ProductPage;
import com.epam.elitea.pages.CartPage;

public class AddItemToCartSteps {

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

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        Assert.assertTrue("Confirmation message not displayed", productPage.isConfirmationMessageDisplayed());
    }

    @Then("the cart icon should update to reflect the new item count")
    public void theCartIconShouldUpdateToReflectTheNewItemCount() {
        int expectedCount = cartPage.getExpectedItemCount();
        int actualCount = cartPage.getActualItemCount();
        Assert.assertEquals("Cart icon count did not update correctly", expectedCount, actualCount);
    }
}