package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDashBoardPage {

   @FindBy(id="user_count")
   private WebElement userCountElm;

   @FindBy(id="book_count")
   private WebElement bookCountElm;

    @FindBy (id="borrowed_books")
    private WebElement borrowedBookCountElm;



    public LoginDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // add 3 methods for getting the numbers
    public String getUserCountText(){
        return userCountElm.getText() ;
    }
    public String getBookCountText(){
        return bookCountElm.getText();
    }
    public String getBorrowedBookCountText(){
        return borrowedBookCountElm.getText();
    }


}
