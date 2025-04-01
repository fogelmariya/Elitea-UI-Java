package pages;

import core.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class ItemDetailsPage extends BasePage{

    @FindBy(id = "add-to-cart")
    WebElement addToBagButton;

    @FindBy(css = "ul.size-swatches li.variations-attribute:not(.out)")
    List<WebElement> sizeButtons;


    public void clickAddToBagButton() {
        waitForReadyStateComplete();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("product-content"))));
       WebElement button= wait.pollingEvery(Duration.ofMillis(1000)).ignoring StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(addToBagButton));
       // scrollIntoView(button);
        button.click();
    }

    public void clickOnFirstSizeButton(){
        sizeButtons.get(sizeButtons.size()-1).click();
    }
}
