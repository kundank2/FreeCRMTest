package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactPageTest extends TestBase{

	LoginPage loginPage;
	FreeCRMHomePage freeCRMHomePage;
	HomePage homePage;
	CreateNewContactPage createNewContactPage;
	String contactSheetName = "contacts";
	
	public CreateNewContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		freeCRMHomePage = new FreeCRMHomePage();
		freeCRMHomePage.clickOnLoginButton();
		loginPage = new LoginPage();
		homePage = new HomePage();
		createNewContactPage = new CreateNewContactPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		createNewContactPage = homePage.clickOnAddNewContact();
	}
	
	
	@Test(priority = 1)
	public void verifyCreateNewContactLabelTest() {
		String label = createNewContactPage.verifyCreateNewContactLabel();
		Assert.assertEquals(label, "Create New Contact");;
	}
	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][] = TestUtil.getTestData(contactSheetName);
		return data;
	}
	@Test(priority = 2, dataProvider = "getContactTestData")
	public void createNewContactTest(String firstName, String lastName, String company, String email) {
		createNewContactPage.CreateNewContact(firstName, lastName, company, email);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
