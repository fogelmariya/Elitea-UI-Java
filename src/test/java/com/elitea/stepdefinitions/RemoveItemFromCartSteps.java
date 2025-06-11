package com.elitea.stepdefinitions;

import com.elitea.pages.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RemoveItemFromCartSteps {

    private ShoppingCartPage shoppingCartPage;

    public RemoveItemFromCartSteps() {
        shoppingCartPage = new ShoppingCartPage();
    }

    @Given("the shopper has items in their shopping cart")
    public void theShopperHasItemsInTheirShoppingCart() {
        // Assuming we have a method to add items to the cart
        shoppingCartPage.addItemToCart("Test Item", 1);
    }

    @Given("the shopper is on the shopping cart page")
    public void theShopperIsOnTheShoppingCartPage() {
        shoppingCartPage.navigateToShoppingCart();
    }

    @When("the shopper clicks the {string} button for a specific item")
    public void theShopperClicksTheButtonForASpecificItem(String buttonName) {
        shoppingCartPage.clickRemoveButton("Test Item");
    }

    @Then("the item is removed from the shopping cart")
    public void theItemIsRemovedFromTheShoppingCart() {
        Assert.assertFalse(shoppingCartPage.isItemInCart("Test Item"));
    }

    @Then("the total cart value is recalculated")
    public void theTotalCartValueIsRecalculated() {
        Assert.assertTrue(shoppingCartPage.isTotalCartValueUpdated());
    }

    @Then("the shopping cart displays the updated list of items")
    public void theShoppingCartDisplaysTheUpdatedListOfItems() {
        Assert.assertTrue(shoppingCartPage.isItemListUpdated());
    }
}