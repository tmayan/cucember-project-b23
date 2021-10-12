package com.cydeo.step_definitions;

import com.cydeo.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    //We can set up a hook class that contains
    //methods that run before each scenario and after each scenario
    //or even when we learn tags
    //we can run certain code before and after each scenario that tagged with certain tag

    @Before("@ui")
    public void setupDriver(){
        System.out.println("This is from @Before inside hooks class");
        //set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After("@ui")
    public void tearDown(){
        System.out.println("This is from @After inside hooks class");
        Driver.closeBrowser();

    }
}
