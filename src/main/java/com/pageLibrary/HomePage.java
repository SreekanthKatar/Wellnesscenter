package com.pageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageLocators.HomePage_Locators;
import com.utils.DriverInitializer;

public class HomePage extends HomePage_Locators 
{
	
	public WebDriver driver = DriverInitializer.getDriver();
	public static HomePage hp = new HomePage();
	//public static HomePage_Locators hpl = new HomePage_Locators();
	//public WebElement Login_button = driver.findElement(By.xpath(Click_here_to_Login_button_xpath));
	//public WebElement Click_here_to_Login = driver.findElement(By.xpath(Click_here_to_Login_xpath));
	
	public void LaunchChromeBrowser()
	{
		Reporter.log("Chrome Browser Launching", true);
		System.setProperty("webdriver.chrome.driver", "D:/Wellnesscenter/Wellnesscenter/src/main/java/com/browser/chromedriver.exe"); 
		Reporter.log("Launch_Browser: Chrome Browser Launched Successfully", true);	
	}
	
	public void OpenApplication() throws InterruptedException
	{
		 driver.navigate().to(appurl);
		 Thread.sleep(1000);
		 driver.manage().window().maximize();
		 Reporter.log("Launch_Application: Wellness Application Launched Successfully", true);
		 Reporter.log("                               " ,true);
	}
	public void CloseChromeBrowser(){
		Reporter.log("                               " ,true);
		driver.close();
		Reporter.log("Close_Browser: Chrome Browser Closed Successfully", true);
	}
	public void Verify_HomePage_URL(){
		 String ExpectedURL = "http://172.22.5.34:8080/wellness/";
		 if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected HomePage Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at HomePage",true);
		 }
		 else{
			 Reporter.log("HomePage URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed HomePage",true);
		 }
	}
	public void Click_On_ClickHereToLogin() throws InterruptedException
	{
		WebElement Login_button = driver.findElement(By.xpath(Click_here_to_Login_button_xpath));
		Login_button.click();
		Thread.sleep(2000);
	}

	public void Verify_Staff_Login_Page_URL()
	{
		String ExpectedURL = "http://172.22.5.34:8080/wellness/login";
		 if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected Staff Login Page Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at Staff Login Page",true);
		 }
		 else{
			 Reporter.log("Staff Login Page URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed Staff Login Page",true);
		 }
	}
	public void hp_01_HomePage() throws InterruptedException
	{
		
		hp.OpenApplication();
		hp.Verify_HomePage_URL();
		String ExpectedURL = "http://172.22.5.34:8080/wellness/";
		Assert.assertTrue(DriverInitializer.isURLPresent(ExpectedURL));
		
	 
	}	
	
		public void hp_02_UI() throws InterruptedException{
		hp.OpenApplication();
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		int img_count = allimages.size();
		Reporter.log("Total images in Home page "+img_count,true);
		for (WebElement eachimage : allimages) {
		Assert.assertTrue(eachimage.isDisplayed());	
		}
		Reporter.log(img_count+" images displayed",true);
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int links_count = alllinks.size();
		Reporter.log("Total Links in Home page "+links_count,true);
		for (WebElement eachlink : alllinks) {
		Assert.assertTrue(eachlink.isDisplayed() && eachlink.isEnabled());	
		String linkname = eachlink.getText();
		Reporter.log(linkname+" link is displayed and enabled ",true);
		
		}
	}
	
	public void hp_03_ClickHereToLoginButton() throws InterruptedException
	{
		hp.OpenApplication();
		WebElement Login_button = driver.findElement(By.xpath(Click_here_to_Login_button_xpath));
		if(DriverInitializer.isDisplayed(Login_button))
		{
			Reporter.log("As expected Click Here To Login button is displayed",true);
		}
		else
		{
			Reporter.log("Click Here To Login button is not Displayed",true);
		}
		
		if(DriverInitializer.isEnabled(Login_button))
		{
			Reporter.log("As expected Click Here To Login button is enabled",true);
		}
		else
		{
			Reporter.log("Click Here To Login button is not enabled",true);
		}
		Assert.assertTrue(DriverInitializer.isDisplayed(Login_button));
		Assert.assertTrue(DriverInitializer.isEnabled(Login_button));
		
			
	}
	
	public void hp_04_ClickHereToLogin() throws InterruptedException
	{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		hp.Verify_Staff_Login_Page_URL();
		String ExpectedURL = "http://172.22.5.34:8080/wellness/login";
		Assert.assertTrue(DriverInitializer.isURLPresent(ExpectedURL));
	
		}	
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

