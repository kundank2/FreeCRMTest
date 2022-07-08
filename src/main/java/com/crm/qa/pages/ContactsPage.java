package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	// contacts checkbox
	////a[text()='Kundan Kumar']//parent::td//preceding-sibling::td//input[@type='checkbox']

	public ContactsPage() {
		super();
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
	}
}
