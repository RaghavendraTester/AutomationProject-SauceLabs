package com.SauceLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceLabs.Utils.WebUtils;

public class CheckoutPage {
	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(className="shopping_cart_link")
	private WebElement cart;
	@FindBy(id="checkout")
	private WebElement checkoutbutton;
	@FindBy(id="first-name")
	private WebElement first;
	@FindBy(id="last-name")
	private WebElement last;
	@FindBy(id="postal-code")
	private WebElement postalcose;
	@FindBy(id="continue")
	private WebElement continuebutton;
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement product1;
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement product2;
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement checkouttitle;
	@FindBy(id="finish")
	private WebElement finishButton;
	
	public String homePageToCheckOutPageNaviagtion() {
		WebUtils.sleep();
		product1.click();
		WebUtils.sleep();
		product2.click();
		WebUtils.sleep();
		cart.click();
		WebUtils.sleep();
		checkoutbutton.click();
		WebUtils.sleep();
		first.sendKeys("Raghavendra");
		WebUtils.sleep();
		last.sendKeys("Kulkarni");
		WebUtils.sleep();
		postalcose.sendKeys("580006");
		WebUtils.sleep();
		continuebutton.click();
		WebUtils.sleep();
		finishButton.click();
		return checkouttitle.getText();
	}
	
	
	
	
	
}
