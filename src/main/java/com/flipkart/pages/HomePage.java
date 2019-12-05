package com.flipkart.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends GenericWrappers{
	
	public HomePage(ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}
	
	public ItemList searchItem(String text){
		checkVisibilityByXpath(property.getProperty("HomePage.MyAccountDiv"));
		enterByxpath(property.getProperty("HomePage.searchbarXpath"), text);
		clickByxpath(property.getProperty("HomePage.searchButton"));
		return new ItemList(extentTest);
	}

	public HomePage validateItems() throws InterruptedException, IOException {
        FileInputStream fis = new FileInputStream("./TestData/TestData.xlsx");
        XSSFWorkbook virWB = new XSSFWorkbook(fis);
        XSSFSheet virWS = virWB.getSheetAt(0);
 
        int RowCnt = virWS.getLastRowNum();
        int ColCnt = virWS.getRow(0).getLastCellNum();
        
      
        
        for (int i = 1; i<=RowCnt; i++) {
               XSSFRow virRow = virWS.getRow(i);
               for (int j = 0; j<ColCnt;j++) {
                   
            	enterByxpath(property.getProperty("HomePage.searchbarXpath"), virRow.getCell(j).getStringCellValue());
           		clickByxpath(property.getProperty("HomePage.searchButton"));
           		clearFieldByXpath(property.getProperty("HomePage.searchbarXpath"));
           		waitForPageToLoad(property.getProperty("ItemList.itemXpath"), property.getProperty("HomePage.SearchError"));
           		if(elementIsVisibleByXpath(property.getProperty("HomePage.SearchError"))){
           			reportStep("The Searchkey "+virRow.getCell(j).getStringCellValue()+" is invalid", "pass");
        		}else{
        			reportStep("The result for Searchkey "+virRow.getCell(j).getStringCellValue()+" is displayed", "pass");
        		}
           		
        }
        }
        return new HomePage(extentTest);
	}
	
	public void closePopup(){
		waitForPageLoad();
		clickByxpath(property.getProperty("axis"));
	}
}
    
