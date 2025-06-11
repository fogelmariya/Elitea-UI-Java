package com.elitea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    @FindBy(css = ".cart-total")
    private WebElement cartTotal;

    public ShoppingCartPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(String itemName, int quantity) {
        // Implementation to add item to cart
        // This is a placeholder and should be implemented based on your application's logic
    }

    public void navigateToShoppingCart() {
        driver.get("https://your-website.com/cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-page")));
    }

    public void clickRemoveButton(String itemName) {
        WebElement removeButton = driver.findElement(By.xpath("//div[contains(text(),'" + itemName + "')]/..//button[text()='Remove']"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(removeButton));
    }

    public boolean isItemInCart(String itemName) {
        return cartItems.stream().anyMatch(item -> item.getText().contains(itemName));
    }

    public boolean isTotalCartValueUpdated() {
        // This is a placeholder. You should implement the logic to check if the cart total has been updated.
        return true;
    }

    public boolean isItemListUpdated() {
        // This is a placeholder. You should implement the logic to check if the item list has been updated.
        return true;
    }
}