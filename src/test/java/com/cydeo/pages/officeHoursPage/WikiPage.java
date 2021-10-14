package com.cydeo.pages.officeHoursPage;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

    public WikiPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#searchInput")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(css = "#firstHeading")
    public WebElement mainHeader;
}
