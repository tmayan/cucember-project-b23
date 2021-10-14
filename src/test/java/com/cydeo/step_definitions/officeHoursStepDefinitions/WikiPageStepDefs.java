package com.cydeo.step_definitions.officeHoursStepDefinitions;


import com.cydeo.pages.officeHoursPage.WikiPage;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiPageStepDefs {

    WikiPage wikiPage=new WikiPage();

    @Given("user in on Wikipedia HomePage")
    public void user_in_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigReader.read("wikiUrl"));
    }
    @When("User Types {string} in wiki searchbox")
    public void user_types_in_wiki_searchbox(String searchValue) {

        wikiPage.searchBox.sendKeys(searchValue);

    }
    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.searchButton.click();
    }
    @Then("user should see {string} in the main header")
    public void user_should_see_in_the_main_header(String expectedMainHeader) {
        String actualMainHeader = wikiPage.mainHeader.getText();
        Assert.assertEquals(expectedMainHeader, actualMainHeader);

    }
    @Then("user should see {string} int he page title")
    public void user_should_see_int_he_page_title(String expectedPageTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedPageTitle));



    }

}
