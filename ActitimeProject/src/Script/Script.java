package Script;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic.Base;
import Generic.FilesLibrary;
import Pom.Homepg;
import Pom.Taskpg;

public class Script extends Base{
	@Test
	public void CreatCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Homepg home = new Homepg(driver);
		home.getTaskLink().click();
		
		Taskpg tp = new Taskpg(driver);
		tp.getAddNewBtn().click();
		tp.getNewCustomer().click();
		
		FilesLibrary fl = new FilesLibrary();
		String name = fl.ReadDataFromExcel("Sheet1", 4, 1);
		tp.getCustomerTF().sendKeys(name);
		
		String desc = fl.ReadDataFromExcel("Sheet1", 4, 2);
		tp.getDescription().sendKeys(desc);
		
		Thread.sleep(3000);
		tp.getClosebtn().click();
	}
}
