package com.automation.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.Page;

public class TopNavigationTest {

	@BeforeTest
	public void setUP() {
		Page.initConfiguration();
	}

	@Test
	public void topNavigationTest() {
		Page.topNavigation.gotoSearch().orderByPrice();
	}

	@AfterTest
	public void tearDown() {
		Page.quitBrowser();
	}
}
