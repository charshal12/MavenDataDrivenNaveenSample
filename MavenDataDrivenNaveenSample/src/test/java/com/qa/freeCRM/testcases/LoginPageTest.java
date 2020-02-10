package com.qa.freeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freeCRM.base.TestBase;
import com.qa.freeCRM.pages.HomePage;
import com.qa.freeCRM.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;

	//initializing properties of TestBase class
	LoginPageTest(){
		super();
	}

	//Calling initializing()
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); 
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title =	loginPage.validateTitleOfPage();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority=2)
	public void loginPageCRMLogoTest() {
		boolean flag =loginPage.validateCRMlogoImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest() {
		homepage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
