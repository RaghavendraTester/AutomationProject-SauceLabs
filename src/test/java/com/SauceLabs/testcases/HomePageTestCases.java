package com.SauceLabs.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceLabs.Utils.Generic;
import com.SauceLabs.Utils.WebUtils;
import com.SauceLabs.pages.HomePage;
import com.SauceLabs.pages.LoginPage;

public class HomePageTestCases extends Generic {
	@Test(enabled =true,description="Check ProductName is displayed on Homepage")
	public void HomePage001() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
	    AssertJUnit.assertTrue(home.checkProductNameDisplayed());
		home.clickOnLogout();
	}
	@Test(enabled =true,description ="Check user can able to open cart")
	public void HomePage002() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		AssertJUnit.assertTrue(home.clickOnCartButton());
		home.clickOnLogout();

}
	@Test(enabled =true,description ="Check user can able to apply filter")
	public void HomePage003() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		WebUtils.selectDropDownValue(home.getElement(),HomePage.filter4);
		WebUtils.sleep();
		AssertJUnit.assertEquals("Price (high to low)",home.getFiltername());
		home.clickOnLogout();
	}
	@Test(enabled =true,description ="Check product is added to cart")
	public void HomePage004() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		WebUtils.sleep();
		AssertJUnit.assertEquals("Sauce Labs Fleece Jacket",home.validateAddToCartButton(),"Testcase failed");
		WebUtils.sleep();
		home.clickOnLogout();
	}
	@Test(enabled =true,description ="Check user can navigate to About page or not")
	public void HomePage005() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		WebUtils.sleep();
		home.getAboutPage();
		WebUtils.sleep();
		WebUtils.navigateToBack(driver);
	}
	@Test(enabled =true,description ="Check user can Logout")
	public void HomePage006() {
		//WebUtils.waitForSeconds(10, driver);
		/*LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));*/
		HomePage home=new HomePage(driver);
		WebUtils.sleep();
		home.clickOnLogout();
	}
	@Test(enabled =true,description ="Home page Srollable or not")
	public void HomePage007() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		WebUtils.scrollToBottom();
		WebUtils.sleep();
		WebUtils.scrollToUp();
		WebUtils.sleep();
		WebUtils.scrollPageDown(400);
		WebUtils.sleep();
		WebUtils.scrollPageUp(400);
	}
	@Test(enabled =true,description ="Home page Srollable up to the facebookLink element")
	public void HomePage008() {
		WebUtils.waitForSeconds(10, driver);
		LoginPage login= new LoginPage(driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password"));
		HomePage home=new HomePage(driver);
		WebUtils.sleep();
		WebUtils.scrollPageVerticallyDown(home.getFacebookLink());
	}
	
	
	
}
