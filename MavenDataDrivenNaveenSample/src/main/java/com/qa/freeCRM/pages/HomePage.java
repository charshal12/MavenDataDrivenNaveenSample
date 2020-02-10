package com.qa.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freeCRM.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(xpath="//td[contains(text(),'User: Harshal Chaudhari')]")
	WebElement unameLabel; 

	@FindBy(xpath= "//a[contains(text(),'Contacts')]")
	WebElement contactslink; 

	@FindBy(xpath= "//a[contains(text(),'Tasks')]")
	WebElement taskslink; 

	@FindBy(xpath= "//a[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	
	//Constructor: Initializing Elements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	//Page Library: Tasks
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyHomePageUsername() {

		return unameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsPage() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsPage() {
		dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksPage() {
		taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new  Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactLink.click();
		
	}
	
}
