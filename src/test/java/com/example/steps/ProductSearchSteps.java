package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import com.example.pages.HomePage;
import com.example.pages.SearchResultsPage;

public class ProductSearchSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        homePage = new HomePage();
        homePage.open();
    }

    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        searchResultsPage = homePage.clickSearchButton();
    }

    @Then("I should see a list of products related to {string}")
    public void i_should_see_a_list_of_products_related_to(String searchTerm) {
        Assert.assertTrue("Search results should contain the search term",
                searchResultsPage.getSearchResultsText().contains(searchTerm));
    }

    @Then("the search results should contain at least {int} item")
    public void the_search_results_should_contain_at_least_item(Integer minItems) {
        Assert.assertTrue("Search results should contain at least " + minItems + " item(s)",
                searchResultsPage.getNumberOfResults() >= minItems);
    }
}