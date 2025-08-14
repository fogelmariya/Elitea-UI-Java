package com.epam.elitea.pages;

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

    public ProductPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://www.example.com/product"); // Replace with actual product page URL
    }

    public void clickButton(String buttonName) {
        if ("Add to Cart".equals(buttonName)) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            button.click();
        } else {
            throw new IllegalArgumentException("Button " + buttonName + " not found on Product Page");
        }
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return message.isDisplayed();
    }
}