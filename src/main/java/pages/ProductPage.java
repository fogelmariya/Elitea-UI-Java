package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartButton = By.id("add-to-cart-button");
    private By confirmationMessage = By.id("confirmation-message");
    private By cartIcon = By.id("cart-icon");

    public ProductPage() {
        // Initialize driver and wait
    }

    public void navigateToProductPage() {
        driver.get("https://example.com/product");
    }

    public void clickAddToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }

    public boolean isCartIconUpdated() {
        // Implement logic to check if cart icon is updated
        return true;
    }
}