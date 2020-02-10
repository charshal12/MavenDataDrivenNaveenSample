package com.qa.freeCRM.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.freeCRM.base.TestBase;

public class LoginPage extends TestBase {

	 WebDriverWait wait = new WebDriverWait(driver,90);
	//Create Object Repository(OR)
	@FindBy(name="username")
	WebElement username; 
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(@href,'https://classic.crmpro.com/register/')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Constructor: Initializing Elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean validateCRMlogoImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) {
//		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(un);
//		wait.until(ExpectedConditions.elementToBeSelected(password));
		password.sendKeys(pwd);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", el); 
		return new HomePage();
	}
}
