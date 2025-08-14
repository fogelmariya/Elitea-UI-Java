package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, 10);
    }
}