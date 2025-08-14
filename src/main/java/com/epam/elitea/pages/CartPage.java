package com.epam.elitea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartItems = By.cssSelector(".cart-item");
    private By cartIcon = By.id("cart-icon");

    public CartPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public boolean isItemInCart() {
        return !driver.findElements(cartItems).isEmpty();
    }

    public int getExpectedItemCount() {
        return driver.findElements(cartItems).size();
    }

    public int getActualItemCount() {
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        String countText = icon.getText();
        return Integer.parseInt(countText);
    }
}