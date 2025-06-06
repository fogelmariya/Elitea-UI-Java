package pages;
 
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {

    @FindBy(how = How.ID, using = "tr-account_signin")
    WebElement signIn;

    @FindBy(className = "ui-icon-closethick")
    WebElement noThanks;

    @FindBy(how = How.ID, using = "search-input")
    WebElement searchInput;

    @FindBy(how = How.CSS, using = "button[data-testid='search-button']")
    WebElement searchButton;

    public void clickSignIn() {
        signIn.click();
    }

    public void closeCouponWidgetIfVisible(){
        if (noThanks.isDisplayed()) {
            noThanks.click();
        }
    }

    public void searchForItem(String itemName) {
        searchInput.sendKeys(itemName);
        searchButton.click();
    }
}