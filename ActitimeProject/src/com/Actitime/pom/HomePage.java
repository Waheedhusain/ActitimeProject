package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
		@FindBy(xpath="//div[.='Tasks']")
		private WebElement taskLink;
		
		@FindBy(xpath="//div[.='Reports']")
		private WebElement ReportLink;
		
		@FindBy(xpath="//div[.='Users']")
		private WebElement UserLink;
		
		@FindBy(xpath="//a[.='Logout']")
		private WebElement LogoutLink;
		
		// initiliaTION
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
		//utilization

		public WebElement getTaskLink() {
			return taskLink;
		}

		public WebElement getReportLink() {
			return ReportLink;
		}

		public WebElement getUserLink() {
			return UserLink;
		}

		public WebElement getLogoutLink() {
			return LogoutLink;
		}
}
