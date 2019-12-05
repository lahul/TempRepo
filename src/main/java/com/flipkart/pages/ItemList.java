package com.flipkart.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.flipkart.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ItemList extends GenericWrappers {

	public ItemList(ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}
	
	public ItemDetail clickOnItem() {		
		clickByxpath(property.getProperty("ItemList.itemXpath"));
		changeToNewTab();
		return new ItemDetail(extentTest);
	}
	
	

}
