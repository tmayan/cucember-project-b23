package com.cydeo.step_definitions.officeHoursStepDefinitions;

import com.cydeo.pages.officeHoursPage.GoogleSearchPage;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefs {

    @Given("User is on Google Home Page")
    public void user_is_on_google_home_page() {

        Driver.getDriver().get(ConfigReader.read("googleUrl"));


    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


    }

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user search for {string}")
    public void user_search_for(String word) {
        googleSearchPage.searchBar.sendKeys(word+ Keys.ENTER);
    }

    @Then("user should see {string} in title")
    public void user_should_see_in_title(String expectedInTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
}
