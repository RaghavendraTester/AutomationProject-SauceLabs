package com.SauceLabs.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Generic {

	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream stream;
	//@Parameters({"browser"})
    @BeforeClass
	public static void setup() throws Exception {
		File src= new File("./Configuration/config.properties");
			FileInputStream stream=new FileInputStream(src);
			properties= new Properties();
			properties.load(stream);
      String browser = properties.getProperty("browser");
		String qaURL = properties.getProperty("qaurl");

			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath"));
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", properties.getProperty("firefoxpath"));
				driver= new FirefoxDriver();
			}
			else {
				System.out.println("Browser is not found");
			}
			driver.get(qaURL);
			//driver.manage().window().maximize();
			WebUtils.sleep();
		}

	@AfterClass
	public void teardown() {
		driver.quit();
	}







}






