package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;
import com.Actitime.pom.TaskPage;

public class BaseClass {
		public static WebDriver driver;
		 FileLibrary f = new FileLibrary ();
		
		@BeforeSuite
		 public void databaseConnection() {
			Reporter.log("DataBase Connected Succesfully",true);
	}
		
	@AfterSuite
	 public void databaseDisConnection() {
			Reporter.log("DataBase DisConnected Succesfully",true);
	}

   @BeforeClass
   public void launchbrowser() throws IOException {
	   	ChromeOptions options = new ChromeOptions();
	   	options.addArguments("--remote-allow-origins=*");
	   	driver=new ChromeDriver(options);
	   	driver.manage().window().maximize();
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   	
	   	String URl = f.readDataFromProperty("url");
	   	driver.get(URl);
	   	Reporter.log("Browser Launched",true);
   	}
   
   	@AfterClass
    public void closebrowser() {
   		driver.close();
   		Reporter.log("Browser closed",true);
    }
   	
   @BeforeMethod
   public void login() throws IOException {
   	String un = f.readDataFromProperty("username");
   	String pwd = f.readDataFromProperty("password");
   	
   	LoginPage lp = new LoginPage(driver);
   	lp.getUntbx().sendKeys(un);
   	lp.getPwtbx().sendKeys(pwd);
   	lp.getLgbtn().click();
   	
	  Reporter.log("logged in succesfully",true);
	}
   
   @AfterMethod
   public void logout() {
	   TaskPage tp = new TaskPage(null);
	   tp.getLogout().click();
   	
		Reporter.log("logout succesfully",true);
   }
}
