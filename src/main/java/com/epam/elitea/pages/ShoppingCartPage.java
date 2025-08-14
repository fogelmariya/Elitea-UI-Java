package com.epam.elitea.pages;

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

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    @FindBy(css = ".cart-total")
    private WebElement cartTotal;

    @FindBy(css = ".empty-cart-message")
    private WebElement emptyCartMessage;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void removeItem(String itemName) {
        WebElement itemToRemove = cartItems.stream()
                .filter(item -> item.findElement(By.cssSelector(".item-name")).getText().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not found in cart: " + itemName));

        WebElement removeButton = itemToRemove.findElement(By.cssSelector(".remove-button"));
        removeButton.click();

        wait.until(ExpectedConditions.stalenessOf(itemToRemove));
    }

    public void updateItemQuantity(String itemName, int newQuantity) {
        WebElement itemToUpdate = cartItems.stream()
                .filter(item -> item.findElement(By.cssSelector(".item-name")).getText().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not found in cart: " + itemName));

        WebElement quantityInput = itemToUpdate.findElement(By.cssSelector(".quantity-input"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(newQuantity));

        WebElement updateButton = itemToUpdate.findElement(By.cssSelector(".update-button"));
        updateButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(cartTotal, "$"));
    }

    public boolean isItemInCart(String itemName) {
        return cartItems.stream()
                .anyMatch(item -> item.findElement(By.cssSelector(".item-name")).getText().equals(itemName));
    }

    public String getCartTotal() {
        return cartTotal.getText();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }
}