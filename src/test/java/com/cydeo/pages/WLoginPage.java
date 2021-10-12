package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    @FindBy(id="ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name="ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css="#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;

    //now we need to instruct selenium to start looking for element
    //when this constructor is called
    //This is no arg constructor of this class
    public WLoginPage(){
        //PageFactory is selenium class that support page object model
        //and it has method called initElements
        //once it's called, it will locate all the element
        //specified using @FindBy annotation with locator
        //initElements accept 2 arguments
        //WebDriver instance and page class instance(this) means

        PageFactory.initElements(Driver.getDriver(), this);
    }

/**
 * Create a method to goTo
 * accept no param just navigate to login page
 * use config.properties for url
 */

public void goTo(){
    Driver.getDriver().get(ConfigReader.read("weborder_url"));
}

/**
 * Login with parameter
 * @param username userName
 * @param password password
 */

public void login(String username,String password){

    this.userNameField.sendKeys(username);
    this.passwordField.sendKeys(password);
    this.loginButton.click();
}


    public boolean loginErrorMsgPresent(){

        return  this.errorMsg.isDisplayed()  ;

    }
}
