package steps;

import org.openqa.selenium.WebDriver;
import pages.ItemDetailsPage;
import pages.MainPage;
import pages.ShoppingPage;
import pages.SignInPage;


public class ShoppingSteps {

    protected WebDriver driver;
    MainPage mainPage = new MainPage();
    ShoppingPage shoppingPage = new ShoppingPage();

    public void SignIn(String userEmail, String userPassword)
    {
        SignInPage signInPage = new SignInPage();
        mainPage.clickSignIn();
        signInPage.enterUserEmail(userEmail);
        signInPage.enterUserPassword(userPassword);
        signInPage.clickSignIn();
    }

    public void searchByItem(String searchValue) {
        shoppingPage.searchByItemName(searchValue);
    }

    public String textOfFirstElementFromSearchResultsInLowerCase() {
        return shoppingPage.getTextOfFirstElementFromSearchResults().toLowerCase();
    }

    public void addItemToBag(){
        shoppingPage.clickOnFirstItem();
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        itemDetailsPage.clickOnFirstSizeButton();
        itemDetailsPage.clickAddToBagButton();
    }

    public void viewShoppingCart(){
        shoppingPage.closeCartWidget();
        shoppingPage.viewShoppingCart();
    }

    public String getCartSuccessWidgetText(){
        return shoppingPage.getShoppingBagWidgetText();
    }
}
