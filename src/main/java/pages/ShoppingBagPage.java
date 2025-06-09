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
    WebElement removeButton;

    @FindBy(css = "div.cart-empty")
    WebElement emptyCartMessage;

    @FindBy(css = "div.order-total")
    WebElement cartTotal;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public boolean isItemPresentInCart(String itemName) {
        return itemsAddedToBagWidget.stream()
                .anyMatch(item -> item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName));
    }

    public void clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public boolean isItemRemovedFromCart(String itemName) {
        return itemsAddedToBagWidget.stream()
                .noneMatch(item -> item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName));
    }

    public String getCartTotal() {
        return wait.until(ExpectedConditions.visibilityOf(cartTotal)).getText();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).isDisplayed();
    }

    public String getEmptyCartMessage() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).getText();
    }
}
