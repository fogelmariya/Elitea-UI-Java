package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingBagPage extends BasePage {

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;

    @FindBy(css = "button.remove-item")
    List<WebElement> removeItemButtons;

    @FindBy(css = "div.cart-total")
    WebElement cartTotal;

    @FindBy(css = "div.empty-cart-message")
    WebElement emptyCartMessage;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void removeItem(String itemName) {
        for (WebElement item : itemsAddedToBagWidget) {
            if (item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().equals(itemName)) {
                item.findElement(By.xpath(".//button[@class='remove-item']")).click();
                break;
            }
        }
    }

    public boolean isItemPresent(String itemName) {
        for (WebElement item : itemsAddedToBagWidget) {
            if (item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCartTotalUpdated() {
        // Implement logic to check if cart total is updated
        return true;
    }

    public boolean isCartEmpty() {
        return itemsAddedToBagWidget.isEmpty();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }
}
