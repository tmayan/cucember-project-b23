package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WAllProductPage {

    @FindBy(xpath = "//table[@class='ProductsTable']//th")
    private List<WebElement> allHeaderRowCells;

    @FindBy(xpath = "/table[@class='ProductsTable']//tr[2]/td")
    private List<WebElement> firstRowCells;

    @FindBy(xpath = "/table[@class='ProductsTable']//tr[3]/td")
    private List<WebElement> secondRowCells;

    @FindBy(xpath = "/table[@class='ProductsTable']//tr[4]/td")
    private List<WebElement> thirdRowCells;

    public WAllProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

public List<String> getAllHeaderText(){
        return BrowserUtil.getElementsText(allHeaderRowCells);
}

public Map<String,String> getRowFromWebTable(){
    //we want to create a map
    //-key as column name
    //-value as cell value

    Map<String,String> rowMap=new LinkedHashMap<>();


    //how to get all headers so we can use as key
List<String> allHeaders= BrowserUtil.getElementsText(allHeaderRowCells);

    //how to get all first row so we can use a value
 List<String> allFirstRow=BrowserUtil.getElementsText(firstRowCells);

 //Grab first header and use as key, grab first row first cell and use it as value

    for (int columnIndex = 0; columnIndex <allHeaders.size(); columnIndex++) {
        //go through each column and add column header as key and value as cell value
        rowMap.put(allHeaders.get(columnIndex),allFirstRow.get(columnIndex));
    }

    return rowMap;

}
}




