package Generic;

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

import Pom.Loginpg;


public class Base {
	public static WebDriver driver;
	FilesLibrary f = new FilesLibrary();
	
	@BeforeSuite
	public void DataBaseConn() {
		Reporter.log("DataBase Connected Successfully" , true);
	}
	
	@AfterSuite
	public void DataBaseDisConn() {
		Reporter.log("DataBase Disconnected Successfully" , true);
	}
	
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url = f.ReadDataFromProperty("url");
		driver.get(url);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Browser Closed" , true);
	}
	
	@BeforeMethod
	public void Login() throws IOException {
		String un = f.ReadDataFromProperty("username");
		String pwd = f.ReadDataFromProperty("password");
		
		Loginpg l = new Loginpg(driver);
		l.getUNTF().sendKeys(un);
		l.getPWTF().sendKeys(pwd);
		l.getBTN().click();
		
		Reporter.log("Login Success" , true);
	}
	
	@AfterMethod
	public void Logout() {
		driver.findElement(By.xpath("//a[.='Logout']")).click();;
		Reporter.log("logout succesfully",true);
	}
}
