package pages;
 
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {
    public void searchForItem(String itemName) {
        // Implement search functionality
    }
}

    @FindBy(how = How.ID, using = "tr-account_signin")
    WebElement signIn;

    @FindBy(className = "ui-icon-closethick")
    WebElement noThanks;

    public void clickSignIn() {
        signIn.click();
    }

    public void closeCouponWidgetIfVisible(){
        if (noThanks.isDisplayed()) {
            noThanks.click();
        }
    }
}