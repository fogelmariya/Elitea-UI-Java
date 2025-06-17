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

    @FindBy(css = ".order-total")
    private WebElement orderTotal;

    private String initialTotal;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void navigateToShoppingBag() {
        // Implement navigation to shopping bag page
        // This might involve clicking on a shopping bag icon or navigating to a specific URL
    }

    public int getItemCount() {
        return itemsAddedToBagWidget.size();
    }

    public void removeFirstItem() {
        initialTotal = orderTotal.getText();
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton));
        removeItemButton.click();
    }

    public boolean isItemRemoved() {
        return wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.product-line-items-container"), getItemCount() - 1));
    }

    public boolean isTotalUpdated() {
        wait.until(ExpectedConditions.visibilityOf(orderTotal));
        return !orderTotal.getText().equals(initialTotal);
    }
}
