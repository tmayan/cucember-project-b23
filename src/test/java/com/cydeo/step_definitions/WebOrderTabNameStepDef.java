package com.cydeo.step_definitions;

import com.cydeo.utility.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void weShouldSeeTableWithBelowContent(List<Map<String, Object>> expectedResult) {
        List<String> expectedProductList=new ArrayList<>();
        List<String>expectedDiscountPrice=new ArrayList<>();
        for (Map<String, Object> eachRow : expectedResult) {
            expectedProductList.add(eachRow.get("Product").toString());
            expectedDiscountPrice.add(eachRow.get("Price").toString());
        }
       // System.out.println(expectedProductList);
       // System.out.println(expectedDiscountPrice);
        List<String>productList=new ArrayList<>();
        for (WebElement eachProductName : Driver.getDriver().findElements(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']//option"))) {
            productList.add(eachProductName.getText());
        }
       
        assertEquals(expectedProductList,productList);


    }



    }

