package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.ShoppingBagPage;
import org.junit.Assert;

public class RemoveItemFromCartSteps {
    private ShoppingBagPage shoppingBagPage;

    @Given("the user is on the shopping bag page")
    public void userIsOnShoppingBagPage() {
        shoppingBagPage = new ShoppingBagPage();
        shoppingBagPage.navigateToShoppingBag();
    }

    @Given("the shopping bag contains at least one item")
    public void shoppingBagContainsAtLeastOneItem() {
        Assert.assertTrue("Shopping bag is empty", shoppingBagPage.getItemCount() > 0);
    }

    @When("the user removes an item from the shopping bag")
    public void userRemovesItemFromShoppingBag() {
        shoppingBagPage.removeFirstItem();
    }

    @Then("the item should be removed from the shopping bag")
    public void itemShouldBeRemovedFromShoppingBag() {
        Assert.assertTrue("Item was not removed from the shopping bag", shoppingBagPage.isItemRemoved());
    }

    @Then("the shopping bag total should be updated accordingly")
    public void shoppingBagTotalShouldBeUpdated() {
        Assert.assertTrue("Shopping bag total was not updated", shoppingBagPage.isTotalUpdated());
    }
}