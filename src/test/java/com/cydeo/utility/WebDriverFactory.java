package com.cydeo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * We need to utility class with method
 * to get WebDriver object with all the settings needed
 * by passing browserName
 *
 * WebDriverFactory.get("chrome")==>Web Driver object with Chrome Driver
 * WebDriverFactory.get("firefox")==>Web Driver object with Firefox Driver
 */
public class WebDriverFactory {

    public static WebDriver getDriver(String browserName){
        WebDriver driver;

        switch (browserName.toLowerCase().trim()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                driver=null;
                System.out.println("UNKNOWN BROWSER TYPE!!!" + browserName);
        }

        driver.manage().window().maximize();
        return driver;
    }

}
