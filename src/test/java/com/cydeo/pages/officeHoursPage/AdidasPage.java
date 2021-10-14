package com.cydeo.pages.officeHoursPage;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdidasPage {
    public AdidasPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addCart;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeButton;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmation;

    @FindBy(xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
    public WebElement OK;

    @FindBy(xpath = "//a[@class='hrefch']")
    public List<WebElement> products;

    public int productAdder(String category, String product){
        Driver.getDriver().findElement(By.xpath("//a[.='"+category+"']")).click();
        BrowserUtil.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[.='"+product+"']")).click();
        BrowserUtil.waitFor(1);

        String amountString = purchasePrice.getText();
        String[] arrayAmount = amountString.split(" ");
        int amount = Integer.parseInt(arrayAmount[0].substring(1));

        addCart.click();
        BrowserUtil.waitFor(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        BrowserUtil.waitFor(1);

        homeLink.click();

        return amount;

    }

    public int productRemover(String product){
        cart.click();
        BrowserUtil.waitFor(1);
        int amount = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[3]")).getText());
        Driver.getDriver().findElement(By.xpath("//table//tr//td[.='"+product+"']/..//td[.='Delete']/a")).click();
        BrowserUtil.waitFor(3);
        return amount;
    }

    public void fillForm() {
        Faker faker = new Faker();

        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        year.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));

    }

    public void clickCategory(String category){

        Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtil.waitFor(2);

    }


    public String getProductPrice(String product){


        String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();
        // $790

        return actualPrice.substring(1);



    }
}
