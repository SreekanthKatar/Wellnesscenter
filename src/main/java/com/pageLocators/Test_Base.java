package com.pageLocators;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test_Base
{
	// Create the Global Objects
		
		public static Properties CONFIG = null;
		public static WebDriver driver = null;
		
		// To initialize the Date 
		public static String Date_format() 
		{
			Date dat= new Date();
			System.out.println(dat);
			DateFormat dtfrmt= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
			String Date= dtfrmt.format(dat);
			return Date;
		}
		// To initialize the Driver
		public  static  WebDriver getdriver() 
		{
			// driver= new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver","E:\\Workspace_Vinod\\Wellnesscenter\\src\\main\\java\\com\\browser\\chromedriver.exe");
			driver= new ChromeDriver();
			return driver;
		}
		
		// To initialize the utils
		public void initutils() 
		{
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		public void invokeApplication() {
			driver.get("http://172.22.5.34:8080/wellness/");
		}
		public void do_login() 
		{ 
			wellness_login_page l= PageFactory.initElements(driver, wellness_login_page.class);
			l.loginlink.click();
			l.username.clear();
			l.username.sendKeys("tester3");
			l.pasword.clear();
			l.pasword.sendKeys("1");
			l.login_button.click();
			
		}
		public void closeBrowser() 
		{
			driver.close();
		
		}

		public void quitDriver() 
		{
			driver.quit();
			
		}
		public  boolean isAlertPresent() {
			    try {
			      driver.switchTo().alert();
			      return true;
			    } catch (NoAlertPresentException e) {
			      return false;
			    }
			  }

		public void takeScreenShot() 
		{
			Date dat= new Date();
			DateFormat dtfrmt= new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss ");
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("/home/krishna/Kishan/Wellness/My Pro Work/ScreenShots/"+dtfrmt.format(dat)+".png"));
			} catch (Exception e) {
			
				
			}
		}
		
		public void page_refresh()
		{
			driver.navigate().refresh();
		}

		@BeforeMethod
		public void init() 
		{
			
			getdriver();
			initutils();
			invokeApplication();
			do_login();
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException 
		{	
		Thread.sleep(3000);
		closeBrowser();
		}
	

}
