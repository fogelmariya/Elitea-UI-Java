package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartItems = By.className("cart-item");

    public CartPage() {
        // Initialize driver and wait
    }

    public boolean isItemInCart() {
        return !driver.findElements(cartItems).isEmpty();
    }
}