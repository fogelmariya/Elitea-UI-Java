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

    @FindBy(id = "q-search")
    WebElement search;

    @FindBy(css = "div#search button")
    WebElement searchButton;

    public void clickSignIn() {
        signIn.click();
    }

    public void closeCouponWidgetIfVisible(){
        if (noThanks.isDisplayed()) {
            noThanks.click();
        }
    }

    public void searchByItemName(String itemName){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).clear();
        search.sendKeys(itemName + "\n");
    }
}
}