package com.cydeo.pages;

import com.cydeo.utility.Driver;
import jdk.internal.dynalink.linker.LinkerServices;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class WOrderPage {

    @FindBy(xpath = "//h2")
    public WebElement header;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropDown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBOx;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement PriceBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discountField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement totalBox;

    @FindBy(css = "input[type='submit'][value='Calculate']")
    public WebElement calculateButton;


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement costumerNameBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement StreetBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement CityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement ZipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement cardDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = " //strong[normalize-space(.)='New order has been successfully added.']")
    public WebElement successMsg;


    public WOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public List<String> getAllProductsOptionFromList() {

        Select selectObj = new Select(productDropDown);

        List<WebElement> allProductOptions = selectObj.getOptions();
        List<String> actualOptions = new ArrayList<>();
        for (WebElement eachOption : allProductOptions) {
            actualOptions.add(eachOption.getText());
        }
       return  actualOptions;
    }
}