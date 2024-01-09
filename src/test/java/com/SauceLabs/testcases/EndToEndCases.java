package com.SauceLabs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.awt.Checkbox;

import org.testng.annotations.Test;

import com.SauceLabs.Utils.Generic;
import com.SauceLabs.Utils.WebUtils;
import com.SauceLabs.pages.CheckoutPage;
import com.SauceLabs.pages.LoginPage;

public class EndToEndCases extends Generic {
    @Test
    public void TestCase001() {

        LoginPage login = new LoginPage(driver);
        WebUtils.waitForSeconds(10, driver);
        login.loginToTheApplication(properties.getProperty("username"), properties.getProperty("password"));
        CheckoutPage check = new CheckoutPage(driver);
        String Text = check.homePageToCheckOutPageNaviagtion();
        Assert.assertEquals("Checkout: Complete!", Text);

    }

    @Test
    public void TestCase002() {
        WebUtils.waitForSeconds(10, driver);
        LoginPage login = new LoginPage(driver);
        /*login.loginToTheApplication(properties.getProperty("username"), properties.getProperty("password"));
        CheckoutPage check = new CheckoutPage(driver);
        String Text = check.homePageToCheckOutPageNaviagtion();
        Assert.assertEquals("Checkout: Complete!", Text);*/

    }

}
