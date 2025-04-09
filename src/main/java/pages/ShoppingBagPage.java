package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingBagPage extends BasePage {
    public void removeItemFromCart(String itemName) {
        // Implement remove item functionality
    }

    public boolean isItemInCart(String itemName) {
        // Implement check item in cart functionality
        return false;
    }

    public boolean isCartEmpty() {
        // Implement check if cart is empty functionality
        return false;
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
