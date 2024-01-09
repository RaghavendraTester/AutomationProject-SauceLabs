package com.SauceLabs.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
public class WebUtils extends Generic {
	public static WebDriver driver;
	
	//utility for dropdown
	public static void selectDropDownValue(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void setTextUsingAction(WebDriver driver,String text) {
		Actions action= new Actions(driver);
		action.sendKeys(text).build().perform();
	}
	
	//ScrollToBottomOfThePage
	public static void scrollToBottom() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	//ScrollToUpOfThePage
	public static void scrollToUp() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

	}
	
    
	public static void scrollToElementUsingVisibleText(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0],scrollIntoView();", element);
	}

	 
	public static void scrollPageVerticallyDown(WebElement element) {
		WebUtils.sleep();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		while (!element.isDisplayed()) {
			js.executeScript("window.scrollBy(0,200)");
		}
	}

	public static void scrollPageVerticallyUp(WebElement element) {
		WebUtils.sleep();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		while (!element.isDisplayed()) {
			js.executeScript("window.scrollBy(0,-400)");
		}
	}
	public static void scrollPageDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + pixel + ",0)");
	}
	public static void scrollPageUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static void scrollToElementUsingVisibleXpathText(String text) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		try {
			js.executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
		} catch (Exception e) {
		}
	}

	public static void switchToNewTab() {
		WebUtils.sleep();
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public static String getDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		return dateTime.format(formatter);
	}


    public static void sleep() {
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e) {
			e.getStackTrace();
		}
    }
		public static void waitForSeconds(int seconds,WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
		public static void refershpage(WebDriver driver) {
			driver.navigate().refresh();
		/*	try {
				Robot robot= new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_R);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		public static void navigateToBack(WebDriver driver) {
			driver.navigate().back();
		}
	
}
