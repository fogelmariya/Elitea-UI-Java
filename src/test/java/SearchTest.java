import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MainPage;
import steps.ShoppingSteps;


public class SearchTest extends BaseTest{

    public static final Logger log = LoggerFactory.getLogger(SearchTest.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/search_values.csv", numLinesToSkip = 1)
    public void VerifySearchByItemNamePass(String searchValue) {
//        MainPage mainPage = new MainPage();
//        mainPage.closeCouponWidgetIfVisible();
        log.info("Search for {}",searchValue);
        ShoppingSteps shoppingSteps = new ShoppingSteps();
        shoppingSteps.searchByItem(searchValue);
        Assert.assertTrue(shoppingSteps.textOfFirstElementFromSearchResultsInLowerCase().contains(searchValue.toLowerCase()));
    }
}
