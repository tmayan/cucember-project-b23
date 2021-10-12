package com.cydeo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {

    public static void waitFor(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will check for visibility of element within the time given
     * @param locator By.id or By.xpath or By.whatever
     * @param timeToWait time to wait
     * @return true if the element is found within the time and visible , false if not
     */
    public static boolean checkVisibilityOfElement(By locator,int timeToWait) {
        boolean result = false ;

        WebDriverWait wait = new WebDriverWait(com.cydeo.utility.Driver.getDriver() ,timeToWait ) ;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated( locator  ));
            // if above line does not throw exception we will come to this line and below
            result = true ;
        }catch(TimeoutException e){
            //System.out.println("The error message is = " + e.getMessage()  );
            System.out.println("WE DID NOT SEE THE ERROR MESSAGE ELEMENT ");
        }

        return result ;





    }


}