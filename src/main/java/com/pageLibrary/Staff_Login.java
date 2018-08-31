package com.pageLibrary;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageLocators.Staff_Login_Locators;
import com.utils.DriverInitializer;



public class Staff_Login extends Staff_Login_Locators
{
	
	
	public  WebDriver driver = DriverInitializer.getDriver();
	public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login(); 
	//public static Staff_Login_Locators sll = new Staff_Login_Locators();
	//public WebElement username = driver.findElement(By.xpath(sll.Username_editbox_xpath));
	//public WebElement password = driver.findElement(By.xpath(sll.Password_editbox_xpath));
	//public WebElement text = driver.findElement(By.xpath(sll.Main_Heading_Text_xpath));
	//public WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
	public void sl_01_loginpage()
	{
		try{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			hp.Verify_Staff_Login_Page_URL();
			String ExpectedURL = "http://172.22.5.34:8080/wellness/login";
			Assert.assertTrue(DriverInitializer.isURLPresent(ExpectedURL));
			 
			}	
		
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
	}
		
	//Main Heading Text at Login 
	public void sl_02_Verify_MainHeading() throws InterruptedException
	{ try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		WebElement text = driver.findElement(By.xpath(Main_Heading_Text_xpath));
		String actual_text = text.getText();
		String expected_text = "Staff Login";
		if(DriverInitializer.isEquals(actual_text,expected_text))
		{
			Reporter.log("As expected displayed Main Heading as "+actual_text,true);
		}
		else
		{
			Reporter.log("Main Heading is not displayed Correctly as per expected, displayed as "+actual_text,true);
		}
		Assert.assertEquals(actual_text, expected_text);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
		
	}
	}
	
	public void sl_03_verifyLoginbutton() throws InterruptedException
	{
		try{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
		boolean flag = Login_button.isEnabled();
		Assert.assertTrue(flag);
		Reporter.log("As expected Login button is enabled ", true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	}
	

	//Staff Login with both Username and Password Invalid Inputs
	public void sl_04_Verify_Staff_Login_InValid_Username_InValid_Password() throws InterruptedException, AWTException
	{
		
		
		try{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
	 	//InValid Username
		 Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
		username.clear();
		username.sendKeys("tes");
		 Reporter.log("Entered Invalid Username", true);
		 Thread.sleep(1000);
		//InValid Password
		WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
		password.clear();
		password.sendKeys("123");
		 Reporter.log("Entered Invalid Password", true);
		 Thread.sleep(1000);
		//Click on Login button
		WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
		Login_button.click();
		Thread.sleep(2000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Shoud display message as Please Enter Username and Password Correctly",true);
		}
		

		
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
		
		Assert.assertTrue(DriverInitializer.isAlertPresent());
	
	}
	
	//Staff Login with Valid Username and Invalid Password 
		public void sl_05_Verify_Staff_Login_Valid_Username_InValid_Password() throws InterruptedException, AWTException
		{
			try{
				hp.OpenApplication();
				hp.Click_On_ClickHereToLogin();
		 	//Valid Username
			 Thread.sleep(1000);
			WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
			username.clear();
			username.sendKeys("tester1");
			 Reporter.log("Entered Valid Username", true);
			 Thread.sleep(1000);
			//InValid Password
			WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
			password.clear();
			password.sendKeys("123");
			 Reporter.log("Entered Invalid Password", true);
			 Thread.sleep(1000);
			//Click on Login button
			WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
			Login_button.click();
			Thread.sleep(2000);
			if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Shoud display message as Please Enter Password Correctly",true);
			}
			}catch(Exception e){
				Reporter.log(e.getMessage(),true);
			}
			Assert.assertTrue(DriverInitializer.isAlertPresent());	
		
		}
		
	
	//Staff Login with InValid Username and Valid Password 
				public void sl_06_Verify_Staff_Login_InValid_Username_Valid_Password() throws InterruptedException, AWTException
				{
					try{
						hp.OpenApplication();
						hp.Click_On_ClickHereToLogin();
				 	//InValid Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("tes");
					 Reporter.log("Entered Invalid Username", true);
					 Thread.sleep(1000);
					//Valid Password
				WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("1");
					 Reporter.log("Entered Valid Password", true);
					 Thread.sleep(1000);
					//Click on Login button
				WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					if(DriverInitializer.isAlertPresent())
					{
						Reporter.log("Alert Presented",true);
						String message = driver.switchTo().alert().getText();
						Reporter.log(message+" : is displayed at Pop up",true);
						driver.switchTo().alert().accept();
						Reporter.log("Clicked On OK button in Pop up",true);
					}
					else
					{
						Reporter.log("Alert not presented",true);
						Reporter.log("Shoud display message as Please Enter Username Correctly",true);
					}
					}catch(Exception e){
						Reporter.log(e.getMessage(),true);
					}
					
					Assert.assertTrue(DriverInitializer.isAlertPresent());
				}
				
				//Staff Login with Valid Username and Blank Password 
				public void sl_07_Verify_Staff_Login_Valid_Username_Blank_Password() throws InterruptedException, AWTException
				{
					try{
						hp.OpenApplication();
						hp.Click_On_ClickHereToLogin();
				 	//Valid Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("tester1");
					 Reporter.log("Entered Valid Username", true);
					 Thread.sleep(1000);
					//Blank Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("");
					 Reporter.log("Entered Blank Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					if(DriverInitializer.isAlertPresent())
					{
						Reporter.log("Alert Presented",true);
						String message = driver.switchTo().alert().getText();
						Reporter.log(message+" : is displayed at Pop up",true);
						driver.switchTo().alert().accept();
						Reporter.log("Clicked On OK button in Pop up",true);
					}
					else
					{
						Reporter.log("Alert not presented",true);
						Reporter.log("Shoud display message as Please Enter Password ",true);
					}
					}catch(Exception e){
						Reporter.log(e.getMessage(),true);
					}
					Assert.assertTrue(DriverInitializer.isAlertPresent());
				}
				
	
				//Staff Login with Blank Username and Valid Password 
				public void sl_08_Verify_Staff_Login_Blank_Username_Valid_Password() throws InterruptedException, AWTException
				{
					try{
						hp.OpenApplication();
						hp.Click_On_ClickHereToLogin();
				 	//Blank Username
					 Thread.sleep(1000);
				WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("");
					 Reporter.log("Blank Username", true);
					 Thread.sleep(1000);
					//Valid Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("1");
					 Reporter.log("Entered Valid Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					if(DriverInitializer.isAlertPresent())
					{
						Reporter.log("Alert Presented",true);
						String message = driver.switchTo().alert().getText();
						Reporter.log(message+" : is displayed at Pop up",true);
						driver.switchTo().alert().accept();
						Reporter.log("Clicked On OK button in Pop up",true);
					}
					else
					{
						Reporter.log("Alert not presented",true);
						Reporter.log("Shoud display message as Please Enter Username",true);
					}
					}catch(Exception e){
						Reporter.log(e.getMessage(),true);
					}
					Assert.assertTrue(DriverInitializer.isAlertPresent());
				}
				
	
				//Staff Login with Blank Username and Blank Password 
				public void sl_09_Verify_Staff_Login_Blank_Username_Blank_Password() throws InterruptedException, AWTException
				{
					try{
						hp.OpenApplication();
						hp.Click_On_ClickHereToLogin();
				 	//Blank Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("");
					 Reporter.log("Blank Username", true);
					 Thread.sleep(1000);
					//Blank Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("");
					 Reporter.log("Blank Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					if(DriverInitializer.isAlertPresent())
					{
						Reporter.log("Alert Presented",true);
						String message = driver.switchTo().alert().getText();
						Reporter.log(message+" : is displayed at Pop up",true);
						driver.switchTo().alert().accept();
						Reporter.log("Clicked On OK button in Pop up",true);
					}
					else
					{
						Reporter.log("Alert not presented",true);
						Reporter.log("Shoud display message as Please Enter Username and Password",true);
					}
					}catch(Exception e){
						Reporter.log(e.getMessage(),true);
					}
					Assert.assertTrue(DriverInitializer.isAlertPresent());
				}
				
	
	public void sl_10_Verify_Password_visibility() throws InterruptedException
	{
		try{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
		String pwd = password.getAttribute("type");
		Assert.assertEquals(pwd, Password_Type);
		Reporter.log("As expected password characters not visible, displaying as ***** ",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	
	}
	
	//Staff Login with Blank Username and Blank Password 
	public void sl_11_Verify_Staff_Login_Valid_Username_Valid_Password() throws InterruptedException
	{
		try{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
	 	//Valid Username
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
		username.clear();
		username.sendKeys("tester1");
		Reporter.log("Entered Valid Username", true);
		Thread.sleep(1000);
		//Valid Password
		WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
		password.clear();
		password.sendKeys("1");
		Reporter.log("Entered Valid Password", true);
		Thread.sleep(1000);
		//Click on Login button
		WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
		Login_button.click();
		Thread.sleep(2000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("As expected Alert not presented",true);
		}
		String ExpectedURL = "http://172.22.5.34:8080/wellness/appointmentslist";
		 if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected Appointment List Page Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at Appointment List Page",true);
		 }
		 else{
			 Reporter.log("Appointment List Page URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed Appointment List Page",true);
		 }
		Assert.assertTrue(DriverInitializer.isURLPresent(ExpectedURL));
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
		
	}
	
	
	
	
	
	
	
	
	
	

}
