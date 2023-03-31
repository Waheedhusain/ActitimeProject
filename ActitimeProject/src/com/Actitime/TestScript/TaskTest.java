package com.Actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class TaskTest extends BaseClass{
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getTaskLink().click();
	
		TaskPage tp = new TaskPage(driver);
		tp.getAddNewBtn().click();
		tp.getNewCustomer().click();
		
		FileLibrary f = new FileLibrary();
		String AxisName = f.readDatafromexcelFile("Sheet1",2, 1);
		tp.getCustName().sendKeys(AxisName);
		
		String desc = f.readDatafromexcelFile("Sheet1", 2, 2);
		tp.getCustDescp().sendKeys(desc);
		Thread.sleep(3000);
		tp.getCreateCust().click();
	}	
}
