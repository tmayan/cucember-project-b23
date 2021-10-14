package com.cydeo.step_definitions.officeHoursStepDefinitions;


import com.cydeo.pages.officeHoursPage.AdidasPage;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AdidasStepDefs {



    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigReader.read("adidasUrl"));
    }


    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String,String>> productDetails) {
        AdidasPage adidasPage=new AdidasPage();

        for (Map<String, String> productDetail : productDetails) {

            System.out.println("Product Details");

            System.out.println(productDetail.get("Category"));

            adidasPage.clickCategory(productDetail.get("Category"));  // give category name from table


            System.out.println(productDetail.get("Product"));   // give product name

            String actualPrice = adidasPage.getProductPrice(productDetail.get("Product"));
            System.out.println("actualPrice = " + actualPrice);


            String expectedPrice = productDetail.get("expectedPrice"); // gives expectedPrice

            System.out.println("expectedPrice = " + expectedPrice);

            Assert.assertEquals(expectedPrice, actualPrice);
            System.out.println( "================================");

        }









    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {


        for (int i = 0; i < productDetails.size(); i++) {
            List<String> eachRowList = productDetails.get(i);

            System.out.println(eachRowList.get(0));  // Category

            System.out.println(eachRowList.get(1));  // product name

            System.out.println(eachRowList.get(2)); // price

            System.out.println("===================");

        }


        AdidasPage adidasPage=new AdidasPage();

        for (int i = 0; i < productDetails.size(); i++) {
            List<String> eachRowList = productDetails.get(i);
            // click category
            adidasPage.clickCategory(eachRowList.get(0));

            //get price
            String actualProductPrice = adidasPage.getProductPrice(eachRowList.get(1));

            System.out.println("actualProductPrice = " + actualProductPrice);

            String expectedPrice = eachRowList.get(2);
            System.out.println("expectedPrice = " + expectedPrice);

            // assertion
            Assert.assertEquals(expectedPrice,actualProductPrice);


        }



    }



}
