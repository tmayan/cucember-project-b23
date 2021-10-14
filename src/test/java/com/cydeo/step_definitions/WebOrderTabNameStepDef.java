package com.cydeo.step_definitions;

import com.cydeo.pages.WAllProductPage;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WebOrderTabNameStepDef {
    @Then("side bar tabs should be as below")
    public void sideBarTabsShouldBeAsBelow(List<String> expectedResult) {
        List<String> actualResult = new ArrayList<>();
        List<WebElement> actualResult1 = Driver.getDriver().findElements(By.xpath("//ul[@id='ctl00_menu']//li//a"));
        for (WebElement eachElement : actualResult1) {
            actualResult.add(eachElement.getText());
        }
        assertEquals(expectedResult, actualResult);
    }

    @Then("we should see table with below content")
    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String,String>> productMapLst) {

        System.out.println("productMapLst = " + productMapLst);

        // how to get first map
        Map<String,String> expectedFirstRowMap = productMapLst.get(0) ;

        WAllProductPage allProductPage = new WAllProductPage();

        System.out.println("allProductPage.getRowMapFromWebTable() = "
                + allProductPage.getRowFromWebTable());

        Map<String,String> actualFirstRowMap = allProductPage.getRowFromWebTable() ;

        // assert two maps are equal
        assertEquals(  expectedFirstRowMap , actualFirstRowMap );


        // assert the first row match from datatable and web table




//        // get expected headers :
//        Set<String> headerSet = productMapLst.get(0).keySet() ;
//        System.out.println("headerSet = " + headerSet);
//
//        // get actual header :
//        List<String> actualHeaders = allProductPage.getAllHeaderText();
//        System.out.println("actualHeaders = " + actualHeaders);
//
//        // check the size is the same
//        assertEquals(headerSet.size() , actualHeaders.size() );
//
//        // list to set equality check will not work
//        // so we need to turn the set into list
//        List<String> expectedHeaders = new ArrayList<>( headerSet );
//        assertEquals(expectedHeaders, actualHeaders);


    }
    }


