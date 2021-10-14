package com.cydeo.step_definitions.officeHoursStepDefinitions;


import com.cydeo.pages.officeHoursPage.LoginPage;
import com.cydeo.pages.officeHoursPage.VyTrackHomePage;
import com.cydeo.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTableStepDefs {

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModules) {

        BrowserUtil.waitFor(3);


        List<WebElement> allModules = new VyTrackHomePage().allModules;


        Assert.assertEquals(expectedModules, BrowserUtil.getElementsText(allModules));




    }


    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {

        String username = credentials.get("username");    //  give us --> user10

        String password = credentials.get("password");    // UserUser123

        new LoginPage().login(username, password);

        BrowserUtil.waitFor(3);


    }

    @Then("user should be able to see folllowing information")
    public void user_should_be_able_to_see_folllowing_information(Map<String,String> userInfo) {


        String actualFullName = new VyTrackHomePage().username.getText();

        String expectedFullName = userInfo.get("firstname") + " " + userInfo.get("lastname");

        System.out.println("actualFullName = " + actualFullName);

        System.out.println("expectedFullName = " + expectedFullName);

        Assert.assertEquals(expectedFullName, actualFullName);


    }
}
