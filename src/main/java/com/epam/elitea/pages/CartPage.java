package com.epam.elitea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

    private By cartItems = By.cssSelector(".cart-item");

    public boolean isItemInCart() {
        List<WebElement> items = driver.findElements(cartItems);
        return !items.isEmpty();
    }
}