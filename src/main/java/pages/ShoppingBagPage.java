package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingBagPage extends BasePage {

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;

    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }

    public void removeItemFromCart(){
        WebElement removeButton = itemsAddedToBagWidget.get(0).findElement(By.cssSelector("button.remove"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(removeButton));
    }

    public String getCartTotal(){
        WebElement cartTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-total")));
        return cartTotal.getText();
    }

    public String getEmptyCartMessage(){
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.empty-cart-message")));
        return emptyCartMessage.getText();
    }

    @FindBy(css = "div.product-line-items-container")
    List<WebElement> itemsAddedToBagWidget;



    public String itemAddedToBagWidgetGetText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsAddedToBagWidget));
        WebElement itemAddedToBagWidget = itemsAddedToBagWidget.get(0);
        return itemAddedToBagWidget.findElement(By.xpath(".//div[@class='line-item-name']")).getText();
    }


}
