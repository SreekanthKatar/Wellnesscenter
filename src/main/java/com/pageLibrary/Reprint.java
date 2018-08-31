package com.pageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageLocators.Reprint_Locator;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;
import com.utils.DriverInitializer;



public class Reprint extends Reprint_Locator {
	
	public  WebDriver driver = DriverInitializer.getDriver();  
	
	public static boolean IsAlertPresent;
	//Appointment List
	public void rp_01_verify_reprint_page() throws InterruptedException, AWTException {
		WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
		appmod.click();
		Thread.sleep(1000);
		
		WebElement repnt = driver.findElement(By.xpath(Reprint_Xpath));
		repnt.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url, Reprint_Page_URL);
		Reporter.log("RP_01:PASS",true);
		Reporter.log("RP_01:Displaying Page URL as "+url,true);
	}
	
	//Main Heading
		public void rp_02_verify_main_heading() throws InterruptedException {
			
			WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
			appmod.click();
			Thread.sleep(1000);
			
			WebElement menuoption = driver.findElement(By.xpath(App_Menu_Options_xpath));
			List<WebElement> alloptions = menuoption.findElements(By.tagName("li"));
			int option_count = alloptions.size();
			Reporter.log("Total Options in Appointment Module: "+option_count,true);
			
			String reprint = alloptions.get(7).getText();
			System.out.println(reprint);
			Thread.sleep(1000);
			alloptions.get(7).click();
			
			WebElement mainheading = driver.findElement(By.xpath(Main_Heading_Xpath));
			String mh = mainheading.getText();
			
			org.testng.Assert.assertEquals(reprint, mh);
			Reporter.log("RP_02:Displaying Main Heading as "+mh,true);
		}
		
		//Sub Heading
				public void rp_03_verify_sub_heading() {
					WebElement subheading = driver.findElement(By.xpath(Sub_Heading_Xpath));
					String sh = subheading.getText();
					org.testng.Assert.assertTrue(sh.equals(Sub_Heading_Text));
					Reporter.log("rp_03:Displaying Sub Heading as "+sh,true);
					
				}
	public void rp_09_verify_from_date() throws AWTException, InterruptedException{
		WebElement fromdatelabel = driver.findElement(By.xpath(From_Date_Label_Xpath));
		fromdatelabel.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_7);
		Thread.sleep(1000);
		WebElement fromdate = driver.findElement(By.xpath(From_Date_Xpath));
		String dateformat = fromdate.getAttribute("type");
		Assert.assertTrue(dateformat.equals("date"));
		Reporter.log("As expected displayed given format",true); 
	}
	
	public void rp_11_verify_LeavingFromDate_Blank() throws AWTException, InterruptedException
	{
		
		WebElement todatelabel = driver.findElement(By.xpath(ToDate_label_xpath));
		todatelabel.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_7);
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath(Search_Print));
		search.click();
		Thread.sleep(2000);
			try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		String txt = a.getText();
		Reporter.log(txt,true);
		a.accept();
		Reporter.log("As expected Alert presented the message displaying in alert as "+txt,true);
		}catch(UnhandledAlertException e){
			Reporter.log(e.getMessage(),true);
		}
				
	}
	
	public void rp_16_verify_to_date() throws AWTException, InterruptedException{
		WebElement todatelabel = driver.findElement(By.xpath(ToDate_label_xpath));
		todatelabel.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_7);
		Thread.sleep(1000);
		WebElement fromdate = driver.findElement(By.xpath(ToDate_xpath));
		String dateformat = fromdate.getAttribute("type");
		
		Assert.assertTrue(dateformat.equals("date"));
		Reporter.log("As expected displayed given format",true); 
	}
	
	public void rp_18_verify_LeavingToDate_Blank() throws AWTException, InterruptedException
	{
		Reporter.log("Need to Modify",true);
		WebElement todatelabel = driver.findElement(By.xpath(ToDate_label_xpath));
		todatelabel.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_7);
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath(Search_Print));
		search.click();
		Thread.sleep(2000);
			try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		String txt = a.getText();
		Reporter.log(txt,true);
		a.accept();
		Reporter.log("As expected Alert presented the message displaying in alert as "+txt,true);
		}catch(UnhandledAlertException e){
			Reporter.log(e.getMessage(),true);
		}
				
	}
	public void rp_21_verify_SearchGuestName_Result() throws InterruptedException, AWTException {
		//WebElement appid = driver.findElement(By.xpath(Search_By_Appointment_ID_Xpath));
		//appid.clear();
		//Thread.sleep(1000);
		 WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
		guestname.clear();
		guestname.sendKeys("raghava");
		Reporter.log("Entered raghava at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Searchby_GuestName_Xpath)).click();
		Thread.sleep(3000);
		String td = driver.findElement(By.xpath(Searchby_GuestName_Xpath)).getAttribute("value");
		Assert.assertTrue(td.equals("raghava"));
		Reporter.log(td+" as alphabets accepted at Guest Name",true);
		
		WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);

		
		WebElement tablerows = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = tablerows.findElements(By.tagName("tr"));
		for (WebElement eachrow : allrows) {
			List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
			String a = allcols.get(2).getText();
			Assert.assertTrue(a.contains("raghava"));
			String c = eachrow.getText();
			Reporter.log(c,true);
				
			}
		Reporter.log("RP_21 :As Per Given Valid Guest Name the Relavant Data Displayed",true);
		
		//DriverInitializer.refresh();
	}
	
	public void rp_22_verify_SearchGuestName_invalid() throws InterruptedException, AWTException
	{
		WebElement guestname = driver.findElement(By.xpath(Searchby_GuestName_Xpath));
		guestname.clear();
		guestname.sendKeys("xyz");
		Reporter.log("Entered xyz at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Searchby_GuestName_Xpath)).click();
		Thread.sleep(3000);
		String td = driver.findElement(By.xpath(Searchby_GuestName_Xpath)).getAttribute("value");
		Assert.assertFalse(td.equals("xyz"));
		Reporter.log(td+" as alphabets accepted at Guest Name",true);
		
		WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);

		WebElement tablerows = table.findElement(By.tagName("tbody"));
		Assert.assertTrue(tablerows.isDisplayed());
		String tbodydata = tablerows.getText();
		Assert.assertTrue(tbodydata.isEmpty());
		WebElement NRF = driver.findElement(By.xpath(No_Record_Found_xpath));
		String txt = NRF.getText();
		Assert.assertTrue(txt.equals(No_Record_Found_Text));
		Reporter.log(txt+" displayed",true);
		Reporter.log("RP_22 :As Per Given InValid Guest Name the Relavant Data Not Displayed",true);
	}
			
	public void rp_23_verify_SearchGuestName_NumericValues_Invalid() throws InterruptedException, AWTException
	{
		WebElement guestname = driver.findElement(By.xpath(Searchby_GuestName_Xpath));
		guestname.clear();
		guestname.sendKeys("123");
		Reporter.log("Entered 123 at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		String td = driver.findElement(By.xpath(Searchby_GuestName_Xpath)).getAttribute("value");
		Reporter.log("Numerics are accepted at Guest Name",true);
		Assert.assertTrue(td.isEmpty());
		Reporter.log("Should allow only Alphabets at AppointmentName",true);
		Reporter.log("Should not be able to enter Numerics at GuestName",true);
	}
		
	public void rp_23_verify_SearchGuestName_SpecialCharacters_Invalid() throws InterruptedException, AWTException
	{
		WebElement guestname = driver.findElement(By.xpath(Searchby_GuestName_Xpath));
		guestname.clear();
		guestname.sendKeys("*^%$#@");
		Reporter.log("Entered *^%$#@ at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		String td = driver.findElement(By.xpath(Searchby_GuestName_Xpath)).getAttribute("value");
		Reporter.log("SpecialCharacters are accepted at Guest Name",true);
		Assert.assertTrue(td.isEmpty());
		Reporter.log("Should allow only Alphabets at AppointmentName",true);
		Reporter.log("Should not be able to enter SpecialCharacters at GuestName",true);
		
		//Reporter.log(txt+" displayed",true);
		//Reporter.log("RP_23 :Should allow only Alphabets at AppointmentName",true);
		//Reporter.log("RP_23 :Should not be able to enter Numerics at AppointmentName",true);
	}
	
	public void rp_23_verify_SearchGuestName_AlphaNumerics_Invalid() throws InterruptedException, AWTException
	{
		WebElement guestname = driver.findElement(By.xpath(Searchby_GuestName_Xpath));
		guestname.clear();
		guestname.sendKeys("abc123");
		Reporter.log("Entered abc123 at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		String td = driver.findElement(By.xpath(Searchby_GuestName_Xpath)).getAttribute("value");
		Reporter.log("Alphanumerics are accepted at Guest Name",true);
		Assert.assertTrue(td.isEmpty());
		Reporter.log("RP_23 :Should allow only Alphabets at AppointmentName",true);
		Reporter.log("RP_23 :Should not be able to enter AlphaNumerics at AppointmentName",true);
		//Reporter.log(txt+" displayed",true);
		//Reporter.log("RP_23 :Should allow only Alphabets at AppointmentName",true);
		//Reporter.log("RP_23 :Should not be able to enter Numerics at AppointmentName",true);
	}
	
	public void rp_24_verify_SearchBillNumber_Result() throws InterruptedException, AWTException {
		//WebElement appid = driver.findElement(By.xpath(Search_By_Appointment_ID_Xpath));
		//appid.clear();
		//Thread.sleep(1000);
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("76");
		Reporter.log("Entered 76 at Search BillNumber Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);

		
		WebElement tablerows = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = tablerows.findElements(By.tagName("tr"));
		for (WebElement eachrow : allrows) {
			List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
			String a = allcols.get(0).getText();
			Assert.assertTrue(a.contains("76"));
			String c = eachrow.getText();
			Reporter.log(c,true);				
			}
		Reporter.log("RP_24 :As Per Given Valid Bill Number the Relavant Data Displayed",true);
		//Reporter.log("Numerics accepted at Bill Number",true);
		//DriverInitializer.refresh();
	}
	
	public void rp_25_verify_SearchBillNumber_invalid() throws InterruptedException, AWTException
	{
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("100");
		Reporter.log("Entered 100 at Search GuestName Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);
		WebElement tablerows = table.findElement(By.tagName("tbody"));
		Assert.assertTrue(tablerows.isDisplayed());
		String tbodydata = tablerows.getText();
		Assert.assertTrue(tbodydata.isEmpty());
		WebElement NRF = driver.findElement(By.xpath(No_Record_Found_xpath));
		String txt = NRF.getText();
		Assert.assertTrue(txt.equals(No_Record_Found_Text));
		Reporter.log(txt+" displayed",true);
		Reporter.log("RP_25 :As Per Given InValid Bill Number the Relavant Data Not Displayed",true);
	}
	
	public void rp_26_verify_SearchBillNumber_Numerics() throws InterruptedException, AWTException {
		//WebElement appid = driver.findElement(By.xpath(Search_By_Appointment_ID_Xpath));
		//appid.clear();
		//Thread.sleep(1000);
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("76");
		Reporter.log("Entered 76 at Search BillNumber Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);

		
		WebElement tablerows = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = tablerows.findElements(By.tagName("tr"));
		for (WebElement eachrow : allrows) {
			List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
			String a = allcols.get(0).getText();
			Assert.assertTrue(a.contains("76"));
			String c = eachrow.getText();
			Reporter.log(c,true);				
			}
		Reporter.log("RP_26 :As Per Given Valid Bill Number the Relavant Data Displayed",true);
		Reporter.log("Numerics accepted at Bill Number",true);
		//DriverInitializer.refresh();
	}
	public void rp_27_verify_SearchBillNumber_Alphabets_Invalid() throws InterruptedException, AWTException
	{
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("abcd");
		Reporter.log("Entered abcd at Search BillNumber Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		boolean error500 = driver.findElement(By.xpath(ErrorCode500_Xpath)).isDisplayed();
		Reporter.log("RP_27: Displaying ErrorCode 500",true);
		//Reporter.log("RP_27 :Should allow only Numerics at BillNumber",true);
		Assert.assertFalse(error500);
		Reporter.log("As Expected not Displayed Error code 500",true);
		
		//WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
		
		/*Assert.assertTrue(table.isDisplayed());
		WebElement tableheader = table.findElement(By.tagName("thead"));
		WebElement row = tableheader.findElement(By.tagName("tr"));
		String tablerow = row.getText();
		Reporter.log(tablerow,true);
		Reporter.log("-----------------------------------------------------------------------------",true);

		WebElement tablerows = table.findElement(By.tagName("tbody"));
		Assert.assertTrue(tablerows.isDisplayed());
		String tbodydata = tablerows.getText();
		Assert.assertTrue(tbodydata.isEmpty());
		WebElement NRF = driver.findElement(By.xpath(No_Record_Found_xpath));
		String txt = NRF.getText();
		Reporter.log("RP_27 :Should allow only Numerics at BillNumber",true);
		Reporter.log("RP_23 :Should not be able to enter Alphabets at AppointmentName",true);
		Reporter.log(txt+" displayed",true);
		Assert.assertFalse(txt.equals(No_Record_Found_Text));
		//Reporter.log(txt+" displayed",true);
		Reporter.log("RP_23 :Should allow only Alphabets at AppointmentName",true);
		//Reporter.log("RP_23 :Should not be able to enter Numerics at AppointmentName",true);*/
	}
	
	public void rp_27_verify_SearchBillNumber_SpecialCharacters_Invalid() throws InterruptedException, AWTException
	{
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("@#$%*");
		Reporter.log("Entered @#$%* at Search BillNumber Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		boolean error500 = driver.findElement(By.xpath(ErrorCode500_Xpath)).isDisplayed();
		Reporter.log("Displaying ErrorCode 500",true);
		//Reporter.log("RP_27 :Should allow only Numerics at BillNumber",true);
		Assert.assertFalse(error500);
		Reporter.log("As Expected not Displayed Error code 500",true);
	}
	
	public void rp_27_verify_SearchBillNumber_AlphaNumerics_Invalid() throws InterruptedException, AWTException
	{
		WebElement billnumber = driver.findElement(By.xpath(Searchby_BillNumber_Xpath));
		billnumber.clear();
		billnumber.sendKeys("abc123");
		Reporter.log("Entered abc123 at Search BillNumber Textbox",true);
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(1000);
		boolean error500 = driver.findElement(By.xpath(ErrorCode500_Xpath)).isDisplayed();
		Reporter.log("Displaying ErrorCode 500",true);
		//Reporter.log("RP_27 :Should allow only Numerics at BillNumber",true);
		Assert.assertFalse(error500);
		Reporter.log("As Expected not Displayed Error code 500",true);
	}
	
	public void rp_28_verify_SelectOption() throws InterruptedException {
		WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
		guestname.clear();
		guestname.sendKeys("raghava");
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(Web_Table_Xpath));
		WebElement header = table.findElement(By.tagName("thead"));
		WebElement header_row = header.findElement(By.tagName("tr"));
		List<WebElement> allcols = header_row.findElements(By.tagName("th"));
		String Select_Bill_Type = allcols.get(4).getText();
		Reporter.log("                    ",true);
		Reporter.log(Select_Bill_Type,true);
		Reporter.log("-------------------",true);
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = body.findElements(By.tagName("tr"));
		for (WebElement eachrow : allrows) 
		{
			List<WebElement> allcolms = eachrow.findElements(By.tagName("td"));
			for (WebElement eachcol : allcolms) {
				List<WebElement> allselects = allcolms.get(4).findElements(By.tagName("select"));
				for (WebElement eachselect : allselects) {
					String tag = eachselect.getTagName();
					Assert.assertTrue(tag.equalsIgnoreCase("select"));
					Reporter.log(tag,true);
					Reporter.log("As expected displaying select option by default", true);
					
				}
						
			}
			
			//List<WebElement> alldropdowns = td.findElements(By.cssSelector("div[class='form-group']"));
			//for (WebElement eachdropdown : alldropdowns) 
			//{
				//String tag = eachdropdown.getTagName();
				//Reporter.log(tag,true);
				
			//}
			
			}	
		}
	
	public void rp_29_verify_SelectBillTypeOption() throws InterruptedException {
		WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
		guestname.clear();
		guestname.sendKeys("raghava");
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(Web_Table_Xpath));
		WebElement body = table.findElement(By.tagName("tbody"));
		 List<WebElement> allrows = body.findElements(By.tagName("tr"));
		// for (WebElement eachrow : allrows) 
		// {
			 WebElement ele = allrows.get(0).findElement(By.tagName("select"));
			 //List<WebElement> alldrop = eachrow.findElements(By.tagName("select"));
			 //for (WebElement eachdrop : alldrop) 
			// {
				 Select cell = new Select(ele);
				 cell.selectByIndex(1);
				 Thread.sleep(1000); 
				WebElement value = cell.getFirstSelectedOption();
				String dropdown_value = value.getText();
				Assert.assertEquals(dropdown_value, "Invoice bill"); 
				Reporter.log("selected option get placed in the list box", true);
				 
		//	}		 	
			//}	
		}
		//WebElement select = driver.findElement(By.xpath(SelectBillType_Xpath));
		//select.click();
		//Thread.sleep(3000);
		//Select billtype = new Select(driver.findElement(By.xpath("//*[@id='76']")));
		//billtype.selectByIndex(1);		
		
	public void rp_30_PrintMessage() throws InterruptedException
	{ try{
		WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
		guestname.clear();
		guestname.sendKeys("raghava");
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(Web_Table_Xpath));
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = body.findElements(By.tagName("tr"));
		WebElement ele = allrows.get(0).findElement(By.tagName("select"));
		Select cell = new Select(ele);
		 cell.selectByIndex(1);
		 Thread.sleep(1000); 
		WebElement print = driver.findElement(By.xpath(Print_Xpath));
		print.click();
		Thread.sleep(1000);	
		Alert alert = driver.switchTo().alert();
		String alertMessage=alert.getText();
		Assert.assertEquals(alertMessage, "Are you sure you want to print bill invoice"); 
		//System.out.println(alertMessage);
		Reporter.log("Alert displayed same as expected", true);
		//alert.accept();
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
	}
	
	public void rp_31_Popup_OkButton_Click() throws InterruptedException{
		try{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Set<String>hndls= driver.getWindowHandles();
		Iterator<String>it= hndls.iterator();
		String Parntwnd= it.next();
		String childwnd= it.next();
		driver.switchTo().window(childwnd);
		Thread.sleep(5000);
		String invoice_PageURL = driver.getCurrentUrl();
		Reporter.log("URL dispalyed as "+invoice_PageURL,true);
		Assert.assertTrue(invoice_PageURL.contains("pdf"));
		Reporter.log("As expected PDF file generated for Invoice bill",true);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.a)
		
		WebElement PDF_Fail =  driver.findElement(By.id("load-failed-message"));//driver.findElement(By.xpath(Fail_to_load_PDF_Document_Xpath));
		Assert.assertTrue(PDF_Fail.isDisplayed());
		Reporter.log(Fail_to_load_PDF_Document_Text,true);
		String failmsg = PDF_Fail.getText();
		Reporter.log(failmsg,true);
		Assert.assertFalse(failmsg.equals(Fail_to_load_PDF_Document_Text));
		Reporter.log("PDF Document Generated",true);*/
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	}
	
	public void rp_32_CancelButton_Click() {
		try{
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,sear_URL);
		Reporter.log("As expected residing in same page as Reprint page, The URL is: "+url,true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
	}
	public void rp_33_PrintMessage_ReceiptBill() throws InterruptedException
	{try{
		WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
		guestname.clear();
		guestname.sendKeys("raghava");
		WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
		searchbutton.click();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath(Web_Table_Xpath));
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = body.findElements(By.tagName("tr"));
		WebElement ele = allrows.get(0).findElement(By.tagName("select"));
		Select cell = new Select(ele);
		 cell.selectByIndex(2);
		 Thread.sleep(1000); 
		WebElement print = driver.findElement(By.xpath(Print_Xpath));
		print.click();
		Thread.sleep(1000);	
		Alert alert = driver.switchTo().alert();
		String alertMessage=alert.getText();
		Assert.assertEquals(alertMessage, "Are you sure you want to print bill receipt"); 
		//System.out.println(alertMessage);
		Reporter.log("Alert displayed same as expected", true);
		//alert.accept();
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
	}
public void rp_34_Popup_OkButton_Click() throws InterruptedException{
		try{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Set<String>hndls= driver.getWindowHandles();
		Iterator<String>it= hndls.iterator();
		String Parntwnd= it.next();
		String childwnd= it.next();
		driver.switchTo().window(childwnd);
		Thread.sleep(5000);
		String receipt_PageURL = driver.getCurrentUrl();
		Reporter.log("URL dispalyed as "+receipt_PageURL,true);
		String PS = driver.getPageSource();
		Assert.assertFalse(PS.contains("SQLGrammarException"));
		Assert.assertTrue(receipt_PageURL.contains("pdf"));
		Reporter.log("As expected PDF file generated for Receipt bill",true);
		
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
		//Assert.assertTrue(receipt_PageURL.contains("76") && receipt_PageURL.contains("receipt"));
		//Reporter.log("URL dispalyed as "+receipt_PageURL,true);
		//Reporter.log("Displaying exception as << SQLGrammarException >>",true);
		//System.out.println(receipt_PageURL);

	}
public void rp_35_CancelButton_Click_ReceiptBill() {
	try{
	driver.switchTo().alert().dismiss();
	String url = driver.getCurrentUrl();
	Assert.assertEquals(url,sear_URL);
	Reporter.log("As expected residing in same page as Reprint page, The URL is: "+url,true);
    }catch(Exception e){
	Reporter.log(e.getMessage(),true);
}
}

public void rp_36_verify_SelectBillType() throws InterruptedException, AWTException {
	Reporter.log("TEST:----->>   << RP_36_verify_SelectBillType >>  ",true);
	Reporter.log("                                               ",true);
	//WebElement appid = driver.findElement(By.xpath(Search_By_Appointment_ID_Xpath));
	//appid.clear();
	//Thread.sleep(1000);
	 WebElement guestname = driver.findElement(By.cssSelector(Searchby_GuestName_Css));
	guestname.clear();
	guestname.sendKeys("raghava");
	//Reporter.log("Entered raghava at Search GuestName Textbox",true);
	WebElement searchbutton = driver.findElement(By.xpath(Search_Print));
	searchbutton.click();
	Thread.sleep(3000);
	WebElement table = driver.findElement(By.xpath(WebTable_Display_Xpath));
	WebElement tablerows = table.findElement(By.tagName("tbody"));
	List<WebElement> allrows = tablerows.findElements(By.tagName("tr"));
	for (WebElement eachrow : allrows) {
		List<WebElement> allbuttons = eachrow.findElements(By.tagName("button"));
		for (WebElement eachbutton : allbuttons)
		{
			Assert.assertTrue(eachbutton.isDisplayed() && eachbutton.isEnabled());
			String txt = eachbutton.getText();
			Reporter.log("As expected "+txt+" Button is Displayed and Enabled",true);
			eachbutton.click();
			Reporter.log("Clicked on Print Button",true);
			Thread.sleep(1000);
			WebElement MPopup = driver.findElement(By.xpath(MPopup_Please_Select_Bill_Type_Xpath));
			String MPopup_msg = MPopup.getText();
			Assert.assertEquals(MPopup_msg, MPopup_Please_Select_Bill_Type_Text);
			Reporter.log(MPopup_msg+" is Displayed in Modal Popup",true);
			driver.findElement(By.xpath(MPopup_Cancel_Button_Xpath)).click();
			Thread.sleep(2000);
			Reporter.log("Clicked on Cancel Button in Modal Popup",true);
			Reporter.log("                                               ",true);
			
		}
		/*String a = allbuttons.get(2).getText();
		Assert.assertTrue(a.contains("raghava"));
		String c = eachrow.getText();
		Reporter.log(c,true);
		WebElement search = driver.findElement(By.xpath(Search_Print));
		search.click();*/
			
		}
	//Reporter.log("RP_21 :As Per Given Valid Guest Name the Relavant Data Displayed",true);
	
	//DriverInitializer.refresh();
}
	
	}







	

