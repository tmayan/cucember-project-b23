package com.cydeo.pages.officeHoursPage;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = " //input[@id='prependedInput'] ")
    public WebElement userNameField;

    @FindBy(xpath = " //input[@id='prependedInput2'] ")
    public WebElement passwordField;

    @FindBy(xpath = " //button[@id='_submit'] ")
    public WebElement loginButton;



    public void login(String usernameStr,String passwordStr){

        userNameField.sendKeys(usernameStr);
        passwordField.sendKeys(passwordStr);
        loginButton.click();

    }
    public void loginDynamic(String userType){

        userType=userType.replace(" ","_") ;
        String username=ConfigReader.read(userType+"_username");
        String password=ConfigReader.read(userType+"_password");

        login(username, password);

    }
}
