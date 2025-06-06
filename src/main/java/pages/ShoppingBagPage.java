package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingBagPage extends BasePage {

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;

    @FindBy(css = ".remove-product")
    private WebElement removeItemButton;

    @FindBy(css = ".grand-total-sum")
    private WebElement cartTotalElement;

    @FindBy(css = ".cart-empty")
    private WebElement emptyCartMessage;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public boolean isItemInCart(String itemName) {
        return itemAddedToBagWidgetGetText().contains(itemName);
    }

    public void removeItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton));
        removeItemButton.click();
    }

    public String getCartTotal() {
        wait.until(ExpectedConditions.visibilityOf(cartTotalElement));
        return cartTotalElement.getText();
    }

    public boolean isCartEmpty() {
        return itemsAddedToBagWidget.isEmpty();
    }

    public String getEmptyCartMessage() {
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        return emptyCartMessage.getText();
    }
}
