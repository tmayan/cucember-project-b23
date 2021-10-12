package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.datatable.DataTable;
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
        for (Map<String, Object> eachRowMap : productMapList) {
            System.out.println("eachRowMap = " + eachRowMap);
        }
    }
}
