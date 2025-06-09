import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShoppingBagPage;

public class RemoveFromCartSteps {
    private WebDriver driver;
    private ShoppingBagPage shoppingBagPage;

    @Given("the user is on the shopping bag page")
    public void theUserIsOnTheShoppingBagPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        shoppingBagPage = new ShoppingBagPage(driver);
        shoppingBagPage.navigateToShoppingBag();
    }

    @And("the shopping bag contains at least one item")
    public void theShoppingBagContainsAtLeastOneItem() {
        Assert.assertTrue("Shopping bag should contain at least one item", shoppingBagPage.getItemCount() > 0);
    }

    @When("the user clicks the remove button for an item")
    public void theUserClicksTheRemoveButtonForAnItem() {
        shoppingBagPage.removeFirstItem();
    }

    @Then("the item should be removed from the shopping bag")
    public void theItemShouldBeRemovedFromTheShoppingBag() {
        Assert.assertTrue("Item should be removed from the shopping bag", shoppingBagPage.isItemRemoved());
    }

    @And("the shopping bag total should be updated")
    public void theShoppingBagTotalShouldBeUpdated() {
        Assert.assertTrue("Shopping bag total should be updated", shoppingBagPage.isTotalUpdated());
    }

    @And("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        Assert.assertTrue("Confirmation message should be displayed", shoppingBagPage.isConfirmationMessageDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}