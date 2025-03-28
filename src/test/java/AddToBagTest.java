import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;
import steps.ShoppingSteps;

//TODO: Rename test class and test method according to name convention, https://howtodoinjava.com/best-practices/unit-testing-best-practices-junit-reference-guide/#6
//https://dzone.com/articles/7-popular-unit-test-naming
// extract repeated lines of code to base test using annotation @BeforeEach and @AfterEach(to open and close driver)
public class AddToBagTest extends BaseTest {

    @Test
    public void verifyThatAddItemToBagPass() {
        String searchValue="Sneaker";
        MainPage mainPage = new MainPage();
        ShoppingSteps shoppingSteps = new ShoppingSteps();
        shoppingSteps.searchByItem(searchValue);
        mainPage.closeCouponWidgetIfVisible();
        shoppingSteps.addItemToBag();
        Assert.assertEquals("Item Added to Bag", shoppingSteps.getCartSuccessWidgetText().trim());
        shoppingSteps.viewShoppingCart();
        ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
        Assert.assertTrue(shoppingBagPage.itemAddedToBagWidgetGetText().contains(searchValue));
    }
}
