package com.automation.rough;

import com.automation.base.Page;
import com.automation.enums.Regions;
import com.automation.pages.actions.HomePage;

public class LoginTest {

	public static void main(String[] args) {
		Page.initConfiguration();
		HomePage home = new HomePage();
		// Page.topNavigation.gotoSearch().orderByPrice();
		home.searchCruises(Regions.Mediterranean, 6).orderByPrice();
		// Page.quitBrowser();
	}

}
