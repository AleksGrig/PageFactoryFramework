package com.automation.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.base.Page;
import com.automation.pages.locators.SearchPageLocators;

public class SearchPage extends Page {

	private SearchPageLocators search;

	public SearchPage() {
		this.search = new SearchPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.search);
	}

	public SearchPage orderByPrice() {
		click(search.sortDrop);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		click(search.minPriceDrop);
		return this;
	}
}
