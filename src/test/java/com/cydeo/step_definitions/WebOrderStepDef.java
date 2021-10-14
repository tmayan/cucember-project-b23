package com.cydeo.step_definitions;

import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDef {

    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea = new WCommonArea();
        switch (tabName) {
            case "View all products":
            commonArea.viewAllProductTab.click();
            break;
            case "View all orders" :
                commonArea.viewAllOrderTAb.click();
                break;
            case "Order":
                commonArea.orderTab.click();
                break;
        }
    }
    @Then("we should see below options in Product dropdown list")

    public void weShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {

        WOrderPage orderPage=new WOrderPage();
        List<String> actualOptions=orderPage.getAllProductsOptionFromList();

        // assert these two list are equal
        // import static org.junit.Assert.assertEquals;
        assertEquals(expectedOptions,actualOptions);
    }


}
