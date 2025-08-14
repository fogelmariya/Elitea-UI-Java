package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "search-bar")
    private WebElement searchBar;

    @FindBy(id = "search-button")
    private WebElement searchButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.example-ecommerce.com");
    }

    public void enterSearchTerm(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage();
    }
}