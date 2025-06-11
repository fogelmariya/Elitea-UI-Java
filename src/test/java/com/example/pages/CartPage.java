package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private By removeButton = By.cssSelector(".remove-item-button");
    private By cartItems = By.cssSelector(".cart-item");
    private By cartTotal = By.id("cart-total");
    private By removalConfirmation = By.id("removal-confirmation");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItem() {
        WebElement button = driver.findElement(removeButton);
        button.click();
    }

    public int getItemCount() {
        return driver.findElements(cartItems).size();
    }

    public String getCartTotal() {
        return driver.findElement(cartTotal).getText();
    }

    public boolean isRemovalConfirmationDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removalConfirmation)).isDisplayed();
    }
}