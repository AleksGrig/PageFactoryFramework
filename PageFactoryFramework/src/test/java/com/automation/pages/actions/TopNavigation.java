package com.automation.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.base.Page;
import com.automation.pages.locators.TopNavigationLocators;

public class TopNavigation {

	private TopNavigationLocators topNavigation;

	public TopNavigation(WebDriver driver) {
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.topNavigation);
	}

	public SearchPage gotoSearch() {
		Page.click(topNavigation.searchCruisesLink);
		return new SearchPage();
	}
}
