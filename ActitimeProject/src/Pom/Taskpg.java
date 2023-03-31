package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpg {
	
	@FindBy(xpath = "//div[. = 'Add New']")
	private WebElement AddNewBtn;
	
	@FindBy(xpath = "//div[. = '+ New Customer']")
	private WebElement NewCustomer;
	
	@FindBy(xpath = "(//input[@placeholder = 'Enter Customer Name'])[2]")
	private WebElement CustomerTF;
	
	@FindBy(xpath = "(//div[@class = 'inputContainer'])[9]")
	private WebElement Description;
	
	@FindBy(xpath = "(//div[@class = 'closeButton'])[7]")
	private WebElement Closebtn;
	
	
	public Taskpg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getAddNewBtn() {
		return AddNewBtn;
	}

	public WebElement getNewCustomer() {
		return NewCustomer;
	}

	public WebElement getCustomerTF() {
		return CustomerTF;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getClosebtn() {
		return Closebtn;
	}
}
