package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase{
	@FindBy(xpath = "//div[@class='ui loader']//parent::div")
	WebElement createNewContactLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	@FindBy(xpath="//div[@name='company']//input")
	WebElement companyName;
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailInput;
//	@FindBy(xpath="//div[@name='category']//parent::div//label[contains(text(),'Category')]")
//	WebElement categoryDropdown;
//	@FindBy(xpath="//div[@name='status']//parent::div//label[contains(text(),'Status')]")
//	WebElement statusDropdown;
	@FindBy(xpath="//input[@name='do_not_call']")
	WebElement doNotCallBtn;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	
	public CreateNewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCreateNewContactLabel() {
		return createNewContactLabel.getText();
	}
	
	public ContactsViewPage CreateNewContact(String fname, String lname, String cname, String email) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(cname);
		emailInput.sendKeys(email);
		doNotCallBtn.click();
		saveBtn.click();
		return new ContactsViewPage();
		
	}

}
