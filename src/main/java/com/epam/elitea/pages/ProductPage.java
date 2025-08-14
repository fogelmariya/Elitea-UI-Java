package com.epam.elitea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private By addToCartButton = By.id("add-to-cart-button");
    private By confirmationMessage = By.id("confirmation-message");
    private By cartIcon = By.id("cart-icon");

    public void open() {
        driver.get("https://example.com/product"); // Replace with actual product page URL
    }

    public void clickButton(String buttonName) {
        if ("Add to Cart".equals(buttonName)) {
            WebElement button = driver.findElement(addToCartButton);
            button.click();
        } else {
            throw new IllegalArgumentException("Button " + buttonName + " not found on Product Page");
        }
    }

    public boolean isConfirmationMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return message.isDisplayed();
    }

    public boolean isCartIconUpdated() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        String itemCount = icon.getAttribute("data-item-count");
        return Integer.parseInt(itemCount) > 0;
    }
}