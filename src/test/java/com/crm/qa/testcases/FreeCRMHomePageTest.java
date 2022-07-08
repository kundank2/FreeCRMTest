package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.LoginPage;

public class FreeCRMHomePageTest extends TestBase{
	FreeCRMHomePage freeCRMHomePage;
	LoginPage loginPage;
	
	public FreeCRMHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		freeCRMHomePage = new FreeCRMHomePage();
	}
	
	@Test(priority = 1)
	public void validateFreeCRMPageTitleTest() {
		String title = freeCRMHomePage.validateFreeCRMPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test(priority = 2)
	public void validateCRMImageTest() {
		boolean flag = freeCRMHomePage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void clickOnLoginButtonTest() {
		loginPage = freeCRMHomePage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
