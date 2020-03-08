package com.automation.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.base.Page;
import com.automation.enums.Regions;
import com.automation.pages.locators.HomePageLocators;

public class HomePage extends Page {

	private HomePageLocators home;

	public HomePage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);
	}

	public HomePage logIn(String username, String password) {
		type(home.userNameField, username);
		type(home.passwordField, password);
		click(home.loginButton);
		return this;
	}

	public SearchPage searchCruises(Regions region, int minDuration) {
		chooseRegion(region);
		chooseMinDuration(minDuration);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		home.submitCruiseOptionsButton.click();
		return new SearchPage();
	}

	private void chooseMinDuration(int minDuration) {
		click(home.numberOfDaysLink);
		click(home.daySlider);
		Actions action = new Actions(driver);
		for (int i = 0; i < minDuration; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).perform();
		}
		click(home.numberOfDaysLink);
	}

	private void chooseRegion(Regions region) {
		click(home.regionLink);
		switch (region) {
		case Mediterranean:
			click(home.MediterreneanOption);
			break;
		default:
			click(home.MediterreneanOption);
		}
	}

	public int cruiseSearchCount() {
		return home.cruiseSearchOptions.size();
	}

}
