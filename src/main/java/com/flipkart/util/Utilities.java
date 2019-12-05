package com.flipkart.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static String[][] getData(String fileName, String sheetName) throws IOException{
		String TestDataWBName = "TestData";
        String[][] resultData;
        FileInputStream fis = new FileInputStream("./TestData/"+fileName+".xlsx");
        XSSFWorkbook virWB = new XSSFWorkbook(fis);
        XSSFSheet virWS = virWB.getSheet(sheetName);
 
        int RowCnt = virWS.getLastRowNum();
        int ColCnt = virWS.getRow(0).getLastCellNum();
        
        resultData = new String[RowCnt][ColCnt];
        
        for (int i = 1; i<=RowCnt; i++) {
               XSSFRow virRow = virWS.getRow(i);
               for (int j = 0; j<ColCnt;j++) {
                     resultData[i-1][j] = virRow.getCell(j).getStringCellValue();
               }
        }
        
        return resultData;
		
	}
}
