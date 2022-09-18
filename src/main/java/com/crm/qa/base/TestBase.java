package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

@SuppressWarnings("deprecation")
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			String configFilePath = "C:\\Users\\kndnk\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
			FileInputStream fis = new FileInputStream(configFilePath);
			prop.load(fis);
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		String chromeDriverPath = "C:\\Users\\kndnk\\eclipse-workspace\\FreeCRMTest\\Drivers\\chromedriver.exe";
		String firefoxDriverPath = "C:\\Users\\kndnk\\eclipse-workspace\\FreeCRMTest\\Drivers\\geckodriver.exe";

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
