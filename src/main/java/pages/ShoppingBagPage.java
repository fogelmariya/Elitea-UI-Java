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
    List<WebElement> removeButtons;

    @FindBy(css = "div.cart-empty")
    WebElement emptyCartMessage;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void open() {
        driver.get(baseUrl + "/cart");
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
    }

    public boolean isItemInCart(String itemName) {
        return itemsAddedToBagWidget.stream()
                .anyMatch(item -> item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName));
    }

    public void removeItem(String itemName) {
        WebElement itemToRemove = itemsAddedToBagWidget.stream()
                .filter(item -> item.findElement(By.xpath(".//div[@class='line-item-name']")).getText().contains(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found in cart: " + itemName));

        WebElement removeButton = itemToRemove.findElement(By.cssSelector("button.remove-product"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(itemToRemove));
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).isDisplayed();
    }
}
