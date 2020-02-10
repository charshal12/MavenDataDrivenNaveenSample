package com.qa.freeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.freeCRM.base.TestBase;
import com.qa.freeCRM.pages.ContactsPage;
import com.qa.freeCRM.pages.HomePage;
import com.qa.freeCRM.pages.LoginPage;
import com.qa.freeCRM.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage  homePage;	
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName= "newContacts";
	
	public ContactsPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsPage();
		
	}

	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsByNameTest() {
		contactsPage.selectContactsByName("Mithila Subhash");
	}

	@Test(priority=2)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectContactsByName("Mithila Subhash");
		contactsPage.selectContactsByName("Lotus May");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object CRMData[][] = testUtil.getTestData(sheetName);
		return CRMData;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName,String lastName,String company) {
		
		//contactsPage.createNewContact("Mr.", "Tom", "Matt", "Tesla");
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
//	@Test(priority=5)
//	public void validateNewContacts() {
//		homePage.clickOnContactsPage();
//		Assert.assertEquals(, title);
//	}
	
	@AfterMethod
	public void tearDown() { 
		driver.quit();
	}
}
