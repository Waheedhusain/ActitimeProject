package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepg {
	// declare
	@FindBy(xpath = "//div[. = '//div[. = 'Tasks']']")
	private WebElement TaskLink;
	
	@FindBy(xpath = "//div[. = 'Reports']")
	private WebElement ReportsLink;

	@FindBy(xpath = "(//div[. = 'Users'])[1]")
	private WebElement UserLink;
	
	// initialization
	public Homepg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// utilize
	public WebElement getTaskLink() {
		return TaskLink;
	}

	public WebElement getReportsLink() {
		return ReportsLink;
	}

	public WebElement getUserLink() {
		return UserLink;
	}
}
