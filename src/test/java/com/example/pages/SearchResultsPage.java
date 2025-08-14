package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".search-result-item")
    private List<WebElement> searchResults;

    @FindBy(id = "search-results-text")
    private WebElement searchResultsText;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getSearchResultsText() {
        return searchResultsText.getText();
    }

    public int getNumberOfResults() {
        return searchResults.size();
    }
}