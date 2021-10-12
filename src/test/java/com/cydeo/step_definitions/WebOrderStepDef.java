package com.cydeo.step_definitions;

import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDef {
    @And("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea=new WCommonArea();
        commonArea.orderTab.click();
    }

    @Then("we should see below options in Product dropdown list")

    public void weShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {

        WOrderPage orderPage=new WOrderPage();
        List<String> actualOptions=orderPage.getAllProductsOptionFromList();
        assertEquals(expectedOptions,actualOptions);
    }


}
