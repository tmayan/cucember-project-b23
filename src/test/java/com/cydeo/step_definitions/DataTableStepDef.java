package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableStepDef {
     @Given("I have a {string}")
   // @Given("I have a {word}")
    public void i_have_a(String animal) {

        System.out.println("Given I have a " + animal);

    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println(" When I call their names ");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println(" Then they come to me ");
    }

    @Given("I have following animals")
    public void i_have_following_animals(List<String> animalList) {
        System.out.println("animalList = " + animalList);


    }

    @When("I call their names with below names")
    public void iCallTheirNamesWithBelowNames(List<String> nameLst) {

        System.out.println("nameLst = " + nameLst);

    }

    @Then("They come to me with below noise")
    public void they_come_to_me_with_below_noise(Map<String,String> animalNoise) {

        System.out.println("animalNoise = " + animalNoise);
    }


/*
    @Then("They come to me with below noise")
    public void they_come_to_me_with_below_noise(List<List<String>> animalRowLst) {
        System.out.println("animalRowLst = " + animalRowLst);
    }

 */

    @When("we provide below credentials")
    public void we_provide_below_credentials(Map<String,String> credentialMap) {

        WLoginPage login=new WLoginPage();
        login.login(credentialMap.get("username"),credentialMap.get("password"));
        
    }


    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String,Object>> productMapList) {
       /* for (Map<String, Object> eachRowMap : productMapList) {
            System.out.println("eachRowMap = " + eachRowMap);
        }

        */
        /**
         * | Product     | Price | Discount |
         * | MyMoney     | 100   | 0.08     |
         * | FamilyAlbum | 80    | 0.15     |
         * | ScreenSaver | 20    | 0.1      |
         */

        Map<String, Object> thirdRowMap = productMapList.get(2);
        // the key is column name , the value is cell value
        System.out.println("thirdRowMap = " + thirdRowMap);
        // print Discount column of 3rd row
        System.out.println("thirdRowMap.get(\"Discount\") = "
                + thirdRowMap.get("Discount"));

        //give me the price value of 2nd row

        System.out.println("productMapList.get(1).get(\"Price\") = "
                + productMapList.get(1).get("Price"));

    }

    @And("I have another product reference without header")
    public void headlessTable(List<List<String>> productInfoList) {
        System.out.println(productInfoList);

        //get me entire 3rd row
       List<String> thirdRow=productInfoList.get(2);
        System.out.println("thirdRow = " + thirdRow);

        //get price of 3rd column
        System.out.println("thirdRow price is  = " + thirdRow.get(1));

        //get the discount column of first row
        System.out.println("first row discount is = " + productInfoList.get(0).get(2));
    }
}
