package com.automation.testcases;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.Page;
import com.automation.pages.actions.HomePage;
import com.automation.utilities.TestUtil;

public class LoginTest {

	@BeforeTest
	public void setUP() {
		Page.initConfiguration();
	}

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginTest(Map<String, String> map) {
		HomePage home = new HomePage();
		home.logIn(map.get("username"), map.get("password"));
	}

	@AfterTest
	public void tearDown() {
		Page.quitBrowser();
	}
}

