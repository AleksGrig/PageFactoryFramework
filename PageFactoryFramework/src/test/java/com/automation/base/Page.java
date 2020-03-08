package com.automation.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.actions.TopNavigation;
import com.automation.utilities.ExcelReader;
import com.automation.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	protected static WebDriver driver;
	protected static Logger log = LogManager.getLogger("devpinoyLogger");
	protected static ExcelReader excel = new ExcelReader("src/test/resources/excel/testdata.xlsx");
	protected static WebDriverWait wait;
	protected static ExtentReports report = ExtentManager.getInstance();
	protected static ExtentTest test;
	protected static String browser;
	public static TopNavigation topNavigation;

	public static void initConfiguration() {
		// Load driver for chosen browser
		if (Constants.browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
			log.info("Firefox launched");
		} else if (Constants.browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome launched");
		} else if (Constants.browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info("Explorer launched");
		}


		driver.get(Constants.testURL);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Constants.implicitWait,
		// TimeUnit.SECONDS);
		topNavigation = new TopNavigation(driver);
	}

	public static void click(WebElement element) {
		element.click();
		log.info("Clicking on an Element : " + element);
		test.log(LogStatus.INFO, "Clicking on : " + element);
	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);
		log.info("Typing in an Element : " + element + " entered value as : " + value);
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);
	}

	public static void quitBrowser() {
		driver.quit();
	}
}
