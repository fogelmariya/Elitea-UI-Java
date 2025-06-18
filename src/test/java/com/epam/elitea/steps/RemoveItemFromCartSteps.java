package com.epam.elitea.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import com.epam.elitea.pages.ShoppingCartPage;
import com.epam.elitea.pages.HomePage;

public class RemoveItemFromCartSteps {

    private ShoppingCartPage shoppingCartPage;
    private HomePage homePage;

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        // Implementation for logging in the user
    }

    @And("the user has items in their shopping cart")
    public void theUserHasItemsInTheirShoppingCart() {
        // Implementation for adding items to the cart
    }

    @When("the user views their shopping cart")
    public void theUserViewsTheirShoppingCart() {
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.open();
    }

    @And("the user clicks the remove button for a specific item")
    public void theUserClicksTheRemoveButtonForASpecificItem() {
        shoppingCartPage.removeItem("SpecificItemName");
    }

    @Then("the item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {
        Assert.assertFalse(shoppingCartPage.isItemInCart("SpecificItemName"));
    }

    @And("the cart total should be updated")
    public void theCartTotalShouldBeUpdated() {
        Assert.assertTrue(shoppingCartPage.isCartTotalUpdated());
    }

    @And("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        Assert.assertTrue(shoppingCartPage.isConfirmationMessageDisplayed());
    }

    @Given("the user has only one item in their shopping cart")
    public void theUserHasOnlyOneItemInTheirShoppingCart() {
        // Implementation for ensuring only one item in the cart
    }

    @When("the user removes the last item")
    public void theUserRemovesTheLastItem() {
        shoppingCartPage.removeLastItem();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        Assert.assertTrue(shoppingCartPage.isCartEmpty());
    }

    @And("the empty cart state should be displayed with product suggestions")
    public void theEmptyCartStateShouldBeDisplayedWithProductSuggestions() {
        Assert.assertTrue(shoppingCartPage.isEmptyCartStateDisplayed());
        Assert.assertTrue(shoppingCartPage.areProductSuggestionsDisplayed());
    }

    @When("the user attempts to remove an item that is not in the cart")
    public void theUserAttemptsToRemoveAnItemThatIsNotInTheCart() {
        shoppingCartPage.removeItem("NonExistentItem");
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(shoppingCartPage.isErrorMessageDisplayed());
    }

    @And("the cart contents should remain unchanged")
    public void theCartContentsShouldRemainUnchanged() {
        Assert.assertTrue(shoppingCartPage.areCartContentsUnchanged());
    }

    @Given("the user has multiple items in their shopping cart")
    public void theUserHasMultipleItemsInTheirShoppingCart() {
        // Implementation for adding multiple items to the cart
    }

    @When("the user removes several items")
    public void theUserRemovesSeveralItems() {
        shoppingCartPage.removeMultipleItems(new String[]{"Item1", "Item2", "Item3"});
    }

    @Then("all selected items should be removed from the cart")
    public void allSelectedItemsShouldBeRemovedFromTheCart() {
        Assert.assertTrue(shoppingCartPage.areItemsRemoved(new String[]{"Item1", "Item2", "Item3"}));
    }

    @And("the cart total should be updated accordingly")
    public void theCartTotalShouldBeUpdatedAccordingly() {
        Assert.assertTrue(shoppingCartPage.isCartTotalUpdated());
    }

    @And("a confirmation dialog appears")
    public void aConfirmationDialogAppears() {
        Assert.assertTrue(shoppingCartPage.isConfirmationDialogDisplayed());
    }

    @And("the user cancels the removal")
    public void theUserCancelsTheRemoval() {
        shoppingCartPage.cancelRemoval();
    }

    @Then("the item should remain in the cart")
    public void theItemShouldRemainInTheCart() {
        Assert.assertTrue(shoppingCartPage.isItemInCart("SpecificItemName"));
    }

    @And("the cart total should remain unchanged")
    public void theCartTotalShouldRemainUnchanged() {
        Assert.assertFalse(shoppingCartPage.isCartTotalUpdated());
    }
}