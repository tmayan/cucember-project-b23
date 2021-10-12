package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibLoginPage {

    @FindBy(id = "inputEmail")
    private WebElement userNameBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    private WebElement LoginButton;


    public LibLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goTo(){
       Driver.getDriver().get(ConfigReader.read("library2.ui.url"));
    }
    public void login(){
     userNameBox.sendKeys(ConfigReader.read("library_userName"));
     passwordBox.sendKeys(ConfigReader.read("library_password"));
     LoginButton.click();
    }


}
