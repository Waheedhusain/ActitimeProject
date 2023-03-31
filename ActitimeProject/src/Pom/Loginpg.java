package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpg {
	// declaration
	@FindBy(name = "username")
	private WebElement UNTF;
	
	@FindBy(name = "pwd")
	private WebElement PWTF;
	
	@FindBy(xpath = "//DIV[. = 'Login ']")
	private WebElement BTN;

	// initialization    // Constructor
	public Loginpg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilization
	public WebElement getUNTF() {
		return UNTF;
	}

	public WebElement getPWTF() {
		return PWTF;
	}

	public WebElement getBTN() {
		return BTN;
	}
}
