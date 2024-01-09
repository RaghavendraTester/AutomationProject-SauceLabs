package com.SauceLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceLabs.Utils.WebUtils;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name")
	private WebElement usernameField;

	@FindBy(id="password")
	private WebElement passwordField; 

	@FindBy(id="login-button")
	private WebElement loginButton; 
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement openmenu;

	public void loginToTheApplication(String user,String password) {
		
		usernameField.sendKeys(user);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	public void clickOnLogout() {
		WebUtils.sleep();
		openmenu.click();
		WebUtils.sleep();
		logout.click();
	}



















}
