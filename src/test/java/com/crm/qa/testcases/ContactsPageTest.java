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

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	FreeCRMHomePage freeCRMHomePage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		freeCRMHomePage = new FreeCRMHomePage();
		freeCRMHomePage.clickOnLoginButton();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsButton();

	}
	

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag, "Contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContacts("Kundan Kumar");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
