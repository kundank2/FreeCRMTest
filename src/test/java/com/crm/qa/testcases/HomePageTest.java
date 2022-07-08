package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	FreeCRMHomePage freeCRMHomePage;
	LoginPage loginPage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @Test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		freeCRMHomePage = new FreeCRMHomePage();
		freeCRMHomePage.clickOnLoginButton();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyHomePageLogoTest() {
		boolean flag = homePage.verifyHomePageLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyUserNameLabelTest() {
		String labelName = homePage.verifyUserNameLabel();
		Assert.assertEquals(labelName, prop.getProperty("labelName"), "Username label not matched");
	}

	@Test(priority = 1)
	public void clickOnContactsButtonTest() {
		contactsPage = homePage.clickOnContactsButton();
	}

	@AfterMethod
	public void tearDown() {
		// homePage.clickOnLogoutButton();
		driver.quit();
	}
}
