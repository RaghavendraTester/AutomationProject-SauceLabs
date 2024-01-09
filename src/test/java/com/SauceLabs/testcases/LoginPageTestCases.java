package com.SauceLabs.testcases;

import com.SauceLabs.testData.ExcelDataSupplier10;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SauceLabs.Utils.Generic;
import com.SauceLabs.Utils.WebUtils;
import com.SauceLabs.pages.LoginPage;

import DataProvider.ExcelDataSupplier;

public class LoginPageTestCases extends Generic {

	@Test()
	public void LoginScenario002() {
		LoginPage login= new LoginPage(driver);
		WebUtils.waitForSeconds(20,driver);
		login.loginToTheApplication(properties.getProperty("username"),properties.getProperty("password") );

		String titleOFThePage=driver.getTitle();
		AssertJUnit.assertEquals("Testcase failed","Swag Labs",titleOFThePage);
		login.clickOnLogout();
	
	}
	
	public static String url="https://www.saucedemo.com/inventory.html";
	@Test(dataProvider="Login",dataProviderClass= ExcelDataSupplier10.class)
	public void LoginScenario001(String username,String password) {
		LoginPage login= new LoginPage(driver);
		WebUtils.waitForSeconds(20,driver);

		login.loginToTheApplication(username, password);
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.equals(url)) {
			WebUtils.waitForSeconds(10,driver);
			driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
			WebUtils.sleep();
			driver.findElement(By.id("logout_sidebar_link")).click();
			WebUtils.sleep();
			}

		else {
			WebUtils.sleep();
			driver.navigate().refresh();
			//   WebUtils.refershpage();
		}


	}


}
