import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage {
    private WebDriver driver;
    private By removeButtonLocator = By.cssSelector(".remove-item-button");
    private By cartItemsLocator = By.cssSelector(".cart-item");
    private By cartTotalLocator = By.id("cart-total");
    private By addToCartButtonLocator = By.cssSelector(".add-to-cart-button");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToShoppingCart() {
        driver.get("https://www.example.com/cart");
    }

    public void removeItem(String itemName) {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        for (WebElement item : cartItems) {
            if (item.getText().contains(itemName)) {
                item.findElement(removeButtonLocator).click();
                break;
            }
        }
    }

    public boolean isItemRemoved(String itemName) {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        for (WebElement item : cartItems) {
            if (item.getText().contains(itemName)) {
                return false;
            }
        }
        return true;
    }

    public double getCartTotal() {
        String totalText = driver.findElement(cartTotalLocator).getText();
        return Double.parseDouble(totalText.replaceAll("[^\\d.]", ""));
    }

    public List<String> getCartItems() {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        return cartItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void addItemToCart(String itemName) {
        // This is a default implementation. You may need to adjust it based on your actual application structure.
        driver.get("https://www.example.com/products");
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        for (WebElement product : products) {
            if (product.getText().contains(itemName)) {
                product.findElement(addToCartButtonLocator).click();
                break;
            }
        }
        // Wait for the item to be added to the cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-added-message")));
    }
}