package com.elitea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.get("https://www.example.com/cart");  // Replace with your actual shopping cart URL
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

    public boolean isItemInCart(String itemName) {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        for (WebElement item : cartItems) {
            if (item.getText().contains(itemName)) {
                return true;
            }
        }
        return false;
    }

    public String getCartTotal() {
        return driver.findElement(cartTotalLocator).getText();
    }

    public List<String> getCartItems() {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        return cartItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void addItemToCart(String itemName) {
        // This is a simplified implementation. In a real scenario, you might need to:
        // 1. Navigate to the product page
        // 2. Select the product
        // 3. Click the "Add to Cart" button
        // For this example, we'll simulate adding an item to the cart
        driver.get("https://www.example.com/product/" + itemName.toLowerCase().replace(" ", "-"));
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        // Wait for the item to be added to the cart (you might want to add an explicit wait here)
        try {
            Thread.sleep(1000);  // Wait for 1 second (not recommended for production code)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Navigate back to the cart page
        navigateToShoppingCart();
    }
}