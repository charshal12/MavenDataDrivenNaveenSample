package com.qa.freeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freeCRM.base.TestBase;
import com.qa.freeCRM.pages.ContactsPage;
import com.qa.freeCRM.pages.HomePage;
import com.qa.freeCRM.pages.LoginPage;
import com.qa.freeCRM.util.TestUtil;
public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage  homePage;	
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent from each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	// after each test case --- close the browser 	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle,"");//Good Habit: if test gets failed
	}
	
	@Test(priority=2)
	public void verifyHomePageUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyHomePageUsername());
	}

	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsPage();
		
	}

	
	@AfterMethod
	public void tearDown() { 
		driver.quit();
	}
}
