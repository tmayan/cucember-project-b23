package com.cydeo.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebOrderUtil {

    /**
     * Simply navigate to WebOrderApp
     */
    public static void openWebOrderApp(){

       // Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx") ;
        com.cydeo.utility.Driver.getDriver().get(com.cydeo.utility.ConfigReader.read("weborder_url"));
    }

    /**
     * A method for logging into Web Order practice site from login page
     */
    public static void login(){

        // enter username
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // enter password
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_password")) .sendKeys("test");
        // click login
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }


    /**
     * A method for logging into Web Order practice site from login page
     *
     * @param username username for weborder app
     * @param password password for weborder app
     */
    public static void login(String username, String password){

        // enter username
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // enter password
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_password")) .sendKeys(password);
        // click login
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    /**
     * Check for login error message is visible or not , by calling the BrowserUtil method we created
     * @return true if error message displayed , false if not
     */
    public static boolean loginErrorMsgVisible(){

        boolean elementFound =
                BrowserUtil.checkVisibilityOfElement(By.xpath("//span[. ='Invalid Login or Password.']"),2);
        return elementFound ;
    }


    public static void cardExpiration(){

        Faker faker=new Faker();
        List<Integer> month=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        List<Integer>year=new ArrayList<>(Arrays.asList(22,23,24,25,26,27,28,29,30,31,32,33));

        for (Integer eachMonth : month) {

            for (Integer eachYear : year) {
                System.out.println(faker.numerify(String.valueOf(eachMonth)) + "/" + faker.numerify(String.valueOf(eachYear)));
            }

        }
    }
}
