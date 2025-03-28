package pages;

import core.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class ShoppingPage extends BasePage {

    @FindBy(id = "q-search")
    WebElement search;

    @FindBy(css = "div#search button")
    WebElement searchButton;

    @FindBy(className = "site-header__customer-name")
    WebElement loggedInUserNameText;

    @FindBy(css = "div.product-name a")
    List<WebElement> searchResults;

    @FindBy(css = "a.mini-cart-link")
    WebElement viewBagButton;

    @FindBy(css = "div.mini-cart-content")
    WebElement shoppingBagWidget;

    @FindBy(className = "mt-atb-close")
    WebElement closeCartWidget;


    public void searchByItemName(String itemName){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).clear();
        search.sendKeys(itemName + "\n");
    }

    public String getTextOfFirstElementFromSearchResults(){
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        return searchResults.get(0).getText().toLowerCase();
    }

    public void clickOnFirstItem(){
        searchResults.get(0).click();
    }

    public String getLoggedInUserNameText(){
        return loggedInUserNameText.getText();
    }

    public void viewShoppingCart(){
        waitForReadyStateComplete();
        scrollIntoView(viewBagButton);
        WebElement button = wait.pollingEvery(Duration.ofMillis(1000)).ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.mini-cart-link")));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    public String getShoppingBagWidgetText(){
        wait.until(ExpectedConditions.visibilityOf(shoppingBagWidget));
        return wait.until(ExpectedConditions.visibilityOf(shoppingBagWidget.findElement(By.xpath(".//div[@class='mt-atb-success']")))).getText();
        //return shoppingBagWidget.findElement(By.xpath(".//div[@class='mt-atb-success']")).getText();
    }

    public void closeCartWidget(){
        wait.until(ExpectedConditions.visibilityOf(closeCartWidget)).click();
        wait.until(ExpectedConditions.invisibilityOf(shoppingBagWidget));
    }
}
