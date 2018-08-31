package com.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInitializer 
{
	public static WebDriver driver;
	
	static int i = 0;
	
	public static void launch()
	{
	  System.setProperty("webdriver.chrome.driver", "D:/Wellnesscenter/Wellnesscenter/src/main/java/com/browser/chromedriver.exe"); 
	  Reporter.log("Launch_Browser: Chrome Browser Launching", true);
	 
	}
	
	public static void OpenApplication() throws InterruptedException
	{
		 driver.navigate().to("http://172.22.5.34:8080/wellness/");
		 Thread.sleep(1000);
		 driver.manage().window().maximize();
		 Reporter.log("Launch_Application: Wellness Application Launched Successfully", true);
		 Reporter.log("                               " ,true);
	}
	public static void CloseChromeBrowser(){
		Reporter.log("                               " ,true);
		driver.close();
		Reporter.log("Close_Browser: Chrome Browser Closed Successfully", true);
	}
	
	public static WebDriver getDriver()
	{
		
		if(i==0)
		{
			launch();
			driver = new ChromeDriver();
			i++;
		}
		
		return driver;
	}
	
	public static void close()
	{
		driver.close();
		Reporter.log("Close_Browser: Chrome Browser Closed Successfully", true);
	}
	public static void Refresh() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		Thread.sleep(1000);
	}
	
	public static void screenshot() throws InterruptedException
	{
		Thread.sleep(2000);
		try 
		{
		Date d= new Date();
		DateFormat dformat= new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("D://"+dformat.format(d)+".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	public static void fileSeperator()
	{
		  String path = "D:";
		  String pathSep = path + File.separator + "Hello" + File.separator;
		  System.out.println(pathSep);
	 }

	public static boolean isAlertPresent()
	{
	      try 
	      {
	    	  driver.switchTo().alert();
	    	  return true;   //When Dialog box present it return true	
	      } catch (Exception e) 
	      {
			
		return false;   //When Dialog box not present it return false
	      }
	}
	/*------------------Main Method-----------------------------------------------
	 *	
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
		}
		
	 */
	public static boolean isTextPresent(String ExpectedText)
	{
		
		boolean flag = driver.getPageSource().contains(ExpectedText);
		
		
		return flag;
		
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTextPresent("text"))
			{
				s.o.p("textpresented");
			}
	 */
	
	public static boolean isTitlePresent(String ExpectedTitle)
	{
		boolean flag = driver.getTitle().contains(ExpectedTitle);
		
		return flag;
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTitlePresent(ExpectedTitle))
			{
			
				s.o.p("titlepresented");
			}
	 * 
	 */
	
	public static boolean isURLPresent(String ExpectedURL)
	{
		boolean flag = driver.getCurrentUrl().contains(ExpectedURL);
		
		return flag;
	}
	/*------------------Main Method-----------------------------------------------
	 *  if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected Staff Login Page Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at Staff Login Page",true);
		 }
		 else{
			 Reporter.log("Staff Login Page URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed Staff Login Page",true);
		 }
	 */
	
	public static boolean isDisplayed(WebElement element)
	{
		boolean flag = element.isDisplayed();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDisplayed(element))
		{
			Reporter.log("As expected element is displayed",true);
		}
		else
		{
			Reporter.log("element is not Displayed",true);
		}
	 * 
	 * 
	 */
	public static boolean isEnabled(WebElement element)
	{
		boolean flag = element.isEnabled();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEnabled(element))
		{
			Reporter.log("As expected element is enabled",true);
		}
		else
		{
			Reporter.log("element is not enabled",true);
		}
	 */
	public static boolean isSelected(WebElement element)
	{
		boolean flag = element.isSelected();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isSelected(element))
		{
			Reporter.log("As expected element is Selected",true);
		}
		else
		{
			Reporter.log("element is not Selected",true);
		}
	 */
	public static boolean isEmpty(String field)
	{
		boolean flag = field.isEmpty();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEmpty(field))
		{
			Reporter.log("As expected field is Empty",true);
		}
		else
		{
			Reporter.log("element is not empty",true);
		}
	 */
	public static boolean isMatching(String actual_text,String expected_text)
	{
		boolean flag = actual_text.matches(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isMatching(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text matched",true);
		}
		else
		{
			Reporter.log("actual text and expected text not matched",true);
		}
	 */
	public static boolean isEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEquals(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text exactly Same",true);
		}
		else
		{
			Reporter.log("actual text and expected text not exactly Same",true);
		}
	 */
	public static boolean isEqualsIgnoreCase(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equalsIgnoreCase(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEqualIgnoreCase(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text Same,but Case sensitive",true);
		}
		else
		{
			Reporter.log("actual text and expected text not Same",true);
		}
	 */
	public static boolean isContains(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contains(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContains(text1,text2))
		{
			Reporter.log("As expected actual text contains expected text",true);
		}
		else
		{
			Reporter.log("actual text not contains expected text",true);
		}
	 */
	public static boolean isContentEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contentEquals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContentEquals(text1,text2))
		{
			Reporter.log("As expected actual text content equals to expected text",true);
		}
		else
		{
			Reporter.log("actual text content not equals to expected text",true);
		}
	 */
	
	public static String isDropdown(WebElement element)
	{
		String tagname = element.getTagName();
		
		return tagname;
	}	
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDropdown(element).equalsIgnoreCase("select"))
		{
			Reporter.log("element is drop down",true);
		}
		else
		{
			Reporter.log("element is not drop down",true);
		}
	 */
	
	public static void Tab() throws AWTException{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
	}
	
	public static String DateandTime()
	{
		Date d= new Date();
		DateFormat dformat= new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		String date = dformat.format(d);
		return date;
	}
	
	/*@BeforeMethod
	public void Launch() throws InterruptedException{
		DriverInitializer.launch();
		DriverInitializer.OpenApplication();
	}
	@AfterMethod
	public void Close(){
		DriverInitializer.CloseChromeBrowser();
	}*/
	
}