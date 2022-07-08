package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FreeCRMHomePage extends TestBase{


	@FindBy(xpath="//a[text()='Login']")
	WebElement loginButton;
	@FindBy(xpath="//a[contains(text(), 'Sign Up')")
	WebElement signUpButton;
	
	@FindBy(xpath="//img[@src='https://freecrm.com/images/freecrm_logo.png']")
	WebElement freeCRMLogo;
	
	public FreeCRMHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateFreeCRMPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return freeCRMLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginButton() {
		loginButton.click();
		
		return new LoginPage();
	}
	
	
}
