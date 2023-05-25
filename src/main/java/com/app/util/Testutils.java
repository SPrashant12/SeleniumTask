package com.app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Testutils {

	public static long Page_Load_Timeout=20;
	public static long implicit_wait =10;
    
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestdata(String sheetName){
		 FileInputStream file = null;
		 try {
			 file= new FileInputStream("/home/am-pc-41/Am-pc-Backup/eclipse-workspace/99flows/src/main/java/com/app/testdata/FlowName.xlsx");
		 }catch(FileNotFoundException e){
			 e.printStackTrace();
		 }
		 try {
			 book= WorkbookFactory.create(file);
		 }catch(InvalidFormatException e) {
			 e.printStackTrace();
		 }catch(IOException e1) {
			 e1.printStackTrace();
		 }
		 
		 sheet= book.getSheet(sheetName);
		 
		 Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i=0;i< sheet.getLastRowNum();i++) {
			 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 }
		 }
		 
		return data;
		
	}
}
