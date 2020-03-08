package com.automation.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.Page;
import com.automation.enums.Regions;
import com.automation.pages.actions.HomePage;

public class SearchTest {

	@BeforeTest
	public void setUP() {
		Page.initConfiguration();
	}

	@Test
	public void searchTest() {
		HomePage home = new HomePage();
		// Assert.assertEquals(home.cruiseSearchCount(), 14);
		// ErrorCollector.verifyEquals(home.cruiseSearchCount(), 14);
		// ErrorCollector.verifyEquals(home.cruiseSearchCount(), 13);
		home.searchCruises(Regions.Mediterranean, 6).orderByPrice();
	}

	@AfterTest
	public void tearDown() {
		Page.quitBrowser();
	}
}
