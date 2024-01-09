package com.SauceLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceLabs.Utils.WebUtils;

public class HomePage {
	public WebDriver driver;
	public static String filter1="Name (A to Z)";
	public static String filter2="Name (Z to A))";
	public static String filter3="Price (low to high)";
	public static String filter4="Price (high to low)";
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="back-to-products")
	private WebElement backarrowbutton;

	@FindBy(xpath="//img[@alt='Sauce Labs Backpack']")
	private WebElement product;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement productName;
	
	
	//a[@class='shopping_cart_link']
	@FindBy(className="shopping_cart_link")
	private WebElement cart;
	@FindBy(className="product_sort_container")
	public WebElement filterElement;
	@FindBy(xpath="//option[@value='hilo']")
	public WebElement filtername;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addToCartElement;
	
	@FindBy(xpath="//div[text()='Sauce Labs Fleece Jacket']")
	private WebElement Jacket;
	
	@FindBy(id="about_sidebar_link")
	private WebElement aboutbutton;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement openmenu;
	
	@FindBy(xpath="//a[text()='Facebook']")
	private WebElement facebooklink;
	
	public WebElement getFacebookLink() {
		return facebooklink;
	}
	public void getAboutPage() {
		WebUtils.sleep();
		openmenu.click();
		aboutbutton.click();
		
	}
	public void clickOnLogout() {
		WebUtils.sleep();
		openmenu.click();
		WebUtils.sleep();
		logout.click();
	}
	
	
	
	public String validateAddToCartButton() {
		addToCartElement.click();
		WebUtils.sleep();
		cart.click();
		return Jacket.getText();
	}
	public WebElement getElement() {
		return filterElement;
	}
	public String getFiltername() {
		return filtername.getText();
	}
	
	
	public boolean clickOnCartButton() {
		cart.click();
		return true;
		}
	
	public boolean checkProductNameDisplayed() {
		product.click();
		backarrowbutton.click();
		String ExpectedName=productName.getText();
		if(ExpectedName.equals("Sauce Labs Backpack"))
			return true;
		else {
			System.out.println("Product is not found");
		return false;
	}
	}
	

}
