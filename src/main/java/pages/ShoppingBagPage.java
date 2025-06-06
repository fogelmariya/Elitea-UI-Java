package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingBagPage extends BasePage {

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;

    @FindBy(css = "button.remove-product")
    WebElement removeItemButton;

    @FindBy(css = "div.cart-empty")
    WebElement emptyCartMessage;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void removeItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton)).click();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).isDisplayed();
    }

    public String getEmptyCartMessage() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).getText();
    }
}
