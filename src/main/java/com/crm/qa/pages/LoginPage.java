package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - Object repository
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Forgot your password?')]")
	WebElement forgotPassword;
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String uName, String pwd) {
		username.sendKeys(uName);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
}
