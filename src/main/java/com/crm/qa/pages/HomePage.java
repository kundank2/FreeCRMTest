package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup  //--> Using cachelookup, webdriver will find element from cache instead of page, it'll increase the performance of framework/test.-- it'll try to get locator from the DOM
	//cachelookup create small memory, and it'll store perticular element into the cache
	WebElement userNameLabel;
	@FindBy(xpath = "//div[@class='header item']")
	WebElement freeCRMLogo;
	@FindBy(xpath = "//div[@role='listbox']/i[1]")
	WebElement settingsIcon;
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement logoutBtn;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsBtn;
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsBtn;
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksBtn;
	
	@FindBy(xpath = "//a[@href='/contacts']//following-sibling::button")
	WebElement addNewContact;
	@FindBy(xpath = "//div[@class='ui loader']//parent::div")
	WebElement createNewContactLabel;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyHomePageLogo() {
		return freeCRMLogo.isDisplayed();
	}

	public String verifyUserNameLabel() {
		return userNameLabel.getText();
	}
	public CreateNewContactPage clickOnAddNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//i[@class='users icon']"))).build().perform();
		addNewContact.click();
		action.moveToElement(createNewContactLabel).build().perform();
		return new CreateNewContactPage();
	}

//	public void clickOnLogoutButton() {
//		settingsIcon.click();
//		logoutBtn.click();
//	}

	public ContactsPage clickOnContactsButton() {
		contactsBtn.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsButton() {
		dealsBtn.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksButton() {
		tasksBtn.click();
		return new TasksPage();
	}

}
