package com.automation.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageLocators {

	@FindBy(id = "drpSortBy")
	public WebElement sortDrop;
	@FindBy(xpath = "//a[@data-sbv='price']")
	public WebElement minPriceDrop;
}
