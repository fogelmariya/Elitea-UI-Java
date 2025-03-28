package pages;

import core.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class SignInPage extends BasePage {

    @FindBy(how = How.ID, using = "emailCustomer")
    WebElement emailField;

    @FindBy(how = How.ID, using = "passwordCustomer") WebElement passwordField;

    @FindBy(how = How.ID, using = "signInButton") WebElement signInButton;

    public void enterUserEmail(String userEmail){
        emailField.sendKeys(userEmail);
    }

    public void enterUserPassword(String userPassword){
        passwordField.sendKeys(userPassword);
    }

    public void clickSignIn(){
        signInButton.click();
        Browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
}
