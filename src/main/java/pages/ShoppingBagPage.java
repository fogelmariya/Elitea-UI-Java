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
    WebElement removeItemButton;

    @FindBy(css = "div.cart-total")
    WebElement cartTotal;

    @FindBy(css = "div.empty-cart-message")
    WebElement emptyCartMessage;

    public String itemAddedToBagWidgetGetText() {
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void removeItemFromCart(String itemName) {
        for (WebElement item : itemsAddedToBagWidget) {
            if (item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName)) {
                item.findElement(By.cssSelector("button.remove-item")).click();
                wait.until(ExpectedConditions.invisibilityOf(item));
                break;
            }
        }
    }

    public boolean isItemInCart(String itemName) {
        for (WebElement item : itemsAddedToBagWidget) {
            if (item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName)) {
                return true;
            }
        }
        return false;
    }

    public double getCartTotal() {
        wait.until(ExpectedConditions.visibilityOf(cartTotal));
        String totalText = cartTotal.getText().replace("$", "");
        return Double.parseDouble(totalText);
    }

    public boolean isCartEmpty() {
        return itemsAddedToBagWidget.isEmpty();
    }

    public String getEmptyCartMessage() {
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        return emptyCartMessage.getText();
    }
}

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;



    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }


}
