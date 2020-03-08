package com.automation.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	// @FindBys ({ @FindBy, @FindBy}) - finding element inside another element
	@FindAll({ @FindBy(name = "ctl24$Login$UserName"), @FindBy(id = "ctl24_Login_UserName") })
	public WebElement userNameField;
	@FindBy(id = "ctl24_Login_Password")
	public WebElement passwordField;
	@FindBy(id = "ctl24_Login_LoginButton")
	public WebElement loginButton;
	@FindBy(id = "ddRegion_link")
	public WebElement regionLink;
	@FindBy(id = "rpDuration")
	public WebElement numberOfDaysLink;
	@FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
	public WebElement daySlider;
	@FindBy(id = "ddRegion_li_1")
	public WebElement MediterreneanOption;
	@FindBy(id = "btnSubmit")
	public WebElement submitCruiseOptionsButton;
	@FindBy(css = "span[class='linkselect-link-text']")
	public List<WebElement> cruiseSearchOptions;
}
