package com.cydeo.step_definitions.officeHoursStepDefinitions;


import com.cydeo.pages.officeHoursPage.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.read("vyTrackUrl"));
    }
    @When("user enters the driver information")
    public void user_enters_the_driver_information() {
        String username = ConfigReader.read("driver_username");
        String password = ConfigReader.read("driver_password");

        loginPage.login(username,password);



    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {         // snake case

        BrowserUtil.waitFor(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @When("user enters the sales manager information")
    public void userEntersTheSalesManagerInformation() {   // camelcase
        String username = ConfigReader.read("sales_manager_username");
        String password = ConfigReader.read("sales_manager_password");

        loginPage.login(username,password);

    }

    @When("user enters the store manager information")
    public void userEntersTheStoreManagerInformation() {
        String username = ConfigReader.read("store_manager_username");
        String password = ConfigReader.read("store_manager_password");

        loginPage.login(username,password);
    }

    @When("user enters the {string} information")
    public void user_enters_the_information(String userType) {
       /* String username="";
        String password="";
        if(userType.equalsIgnoreCase("driver")){
             username = ConfigReader.read("driver_username");
             password = ConfigReader.read("driver_password");
        }else if (userType.equalsIgnoreCase("sales manager")){
            username = ConfigReader.read("sales_manager_username");
            password = ConfigReader.read("sales_manager_password");
        }else if(userType.equalsIgnoreCase("store manager")){
            username = ConfigReader.read("store_manager_username");
            password = ConfigReader.read("store_manager_password");
        }else
        {
            System.out.println("userType is not defined");
        }
        loginPage.login(username, password);
        */

        loginPage.loginDynamic(userType);

    }
}
