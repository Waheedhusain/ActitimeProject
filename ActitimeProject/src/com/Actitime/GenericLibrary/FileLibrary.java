package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class is generic class which is having non static methods to perform data driven testing 
 * @author 
 * */
public class FileLibrary {
	/**
	 * This method is a non static methOd which is use to read data from property file
	 * @parameter key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromProperty(String key) throws IOException {
		FileInputStream file = new FileInputStream("./Testdata/CommonData.property");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
/**
 *  This method is a non static methd which is use to read data from excel sheet
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */

	public String readDatafromexcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException 
{
		FileInputStream Files1 = new FileInputStream("./TestData/auto.xlsx");
	   Workbook wb = WorkbookFactory.create(Files1);
	   String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	   return value;
	   
}
}