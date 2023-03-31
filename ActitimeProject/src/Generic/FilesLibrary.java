package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FilesLibrary {
	
	public String ReadDataFromProperty(String Value) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/CommonData.property");
		Properties p = new Properties();
		p.load(fis);
		String name = p.getProperty(Value);
		return name;
	}
	
	public String ReadDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/auto.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String val = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return val;
	}
}
