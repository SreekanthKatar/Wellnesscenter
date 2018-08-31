package com.pageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageLocators.Bill_Settlement_Locators;
import com.utils.DriverInitializer;


public class Bill_Settlement extends Bill_Settlement_Locators
{
	public WebDriver driver = DriverInitializer.getDriver();
	public static boolean flag;
	public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login();
	public static Bill_Settlement bst = new Bill_Settlement();
	
	public void Open_Bill_Settlement_Page() throws InterruptedException
	{
		WebElement AppMenu = driver.findElement(By.xpath(Appointment_Menu_xpath));
		AppMenu.click();
		Reporter.log("Clicked On Appointment Menu",true);
		Thread.sleep(1000);
		Reporter.log("Displayed Options of Appointment Module",true);
		WebElement BillSettlement = driver.findElement(By.xpath(Bill_Settlement_xpath));
		BillSettlement.click();
		Reporter.log("Clicked on Bill Settlement Option",true);
		Thread.sleep(1000);
		Reporter.log("Bill Settlement List Page Displayed",true);
		WebElement table = driver.findElement(By.xpath(WebTable_BillSettlement_Page_xpath));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> allrows = tbody.findElements(By.tagName("tr"));
		WebElement FirstBillNo = allrows.get(0).findElement(By.tagName("a"));
		String BillNo = FirstBillNo.getText();
		String GuestName = allrows.get(0).findElement(By.xpath("td[3]")).getText();
		String BillAmount = allrows.get(0).findElement(By.xpath("td[4]")).getText();
		if(FirstBillNo.isDisplayed() && FirstBillNo.isEnabled())
		{
			Reporter.log("Record Available for BillNo "+BillNo+" with Guest Name "+GuestName+", and BillAmount is: "+BillAmount,true);
			FirstBillNo.click();
			Reporter.log("Clicked on BillNo "+BillNo+" with Guest Name "+GuestName,true); 
			Reporter.log("Bill Settlement Page Displayed",true);
			
			Select s = new Select(driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath)));
			s.selectByIndex(4);
			driver.findElement(By.xpath(Amount_Textbox_xpath)).sendKeys("1000");
			driver.findElement(By.xpath(Add_Settlement_Button_xpath)).click();
			Thread.sleep(1000);
			String BA = driver.findElement(By.xpath("//*[@id='amountCharged']")).getAttribute("value");
			System.out.println(BA);
			String PA = driver.findElement(By.xpath("//*[@id='totalOutstanding']")).getAttribute("value");
			System.out.println(PA);
			String NA = driver.findElement(By.xpath("//*[@id='balanceOutstanding']")).getAttribute("value");
			System.out.println(NA);
			
			
				
		}
		
			Thread.sleep(2000);	
	}
	public void Verify_Bill_Settlement_Page_AllElements()
	{
		WebElement BillID = driver.findElement(By.xpath(Bill_ID_Disable_xpath));
		WebElement BillAmount = driver.findElement(By.xpath(Bill_Amount_Disable_xpath));
		WebElement GuestName = driver.findElement(By.xpath(Guest_Name_Disable_xapth));
		String BillID_readonly = BillID.getAttribute("readonly");
		String BillAmount_readonly = BillAmount.getAttribute("readonly");
		String GuestName_readonly = GuestName.getAttribute("readonly");
		String BillID_value = BillID.getAttribute("value");
		String BillAmount_value = BillAmount.getAttribute("value");
		String GuestName_value = GuestName.getAttribute("value");
		
		
		if(BillID_readonly.equals("true")&&BillAmount_readonly.equals("true")&&GuestName_readonly.equals("true"))	
		{
			flag=true;
		}
		if(flag==true){
			Reporter.log("As expected BillID,BillAmount and GuestName text boxes displayed along with values, but these fields are readonly",true);
			Reporter.log("Bill ID value is displayed as: "+BillID_value,true);
			Reporter.log("Bill Amount value is displayed as: "+BillAmount_value,true);
			Reporter.log("Guest Name value is displayed as : "+GuestName_value,true);
		}
		else
		{
			Reporter.log("BillID,BillAmount and GuestName text boxes displayed these fields are enabled",true);
		}
		
	}
	public void Select_CreditCard_Option() throws InterruptedException
	{
		WebElement PaymentMode = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		if(DriverInitializer.isDropdown(PaymentMode).equalsIgnoreCase("select"))
		{
			Reporter.log("Payment Mode is Dropdown",true);
		}
		else
		{
			Reporter.log("Payment Mode is Not Dropdown",true);
		}
		Select PM = new Select(PaymentMode);
		PM.selectByIndex(2);
		Reporter.log("Selected Credit Card option at Payment Dropdown",true);
		Thread.sleep(2000);
	}
	public void Verify_Fields_After_Selected_CreditCard_Option()
	{
		WebElement Name_on_Credit_Card_textbox = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));
		WebElement CreditCard_Number_Textbox = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		WebElement CreditCardType_Dropdown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		WebElement addsettlement_button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		if(DriverInitializer.isDisplayed(Name_on_Credit_Card_textbox))
		{
			Reporter.log("As expected Name on Credit Card text box is displayed after selected Credit Card option at Payment Dropdown",true);
		}
		else
		{
			Reporter.log("Name on Credit Card text box not displayed after selected Credit Card option at Payment Dropdown",true);
		}
		if(DriverInitializer.isDisplayed(CreditCard_Number_Textbox))
		{
			Reporter.log("As expected Credit Card Number text box is displayed after selected Credit Card option at Payment Dropdown",true);
		}
		else
		{
			Reporter.log("Credit Card Number text box not displayed after selected Credit Card option at Payment Dropdown",true);
		}
		if(DriverInitializer.isDisplayed(CreditCardType_Dropdown))
		{
			Reporter.log("As expected Credit Card Type dropdown is displayed after selected Credit Card option at Payment Dropdown",true);
		}
		else
		{
			Reporter.log("Credit Card Type Dropdown not displayed after selected Credit Card option at Payment Dropdown",true);
		}
		if(DriverInitializer.isEnabled(addsettlement_button))
		{
			Reporter.log("As expected Add Settlement button is enabled by default",true);
		}
		else
		{
			Reporter.log("Add Settlement button is not enabled by default",true);
		}
		Assert.assertTrue(DriverInitializer.isDisplayed(Name_on_Credit_Card_textbox) && DriverInitializer.isDisplayed(CreditCard_Number_Textbox) && DriverInitializer.isDisplayed(CreditCardType_Dropdown));
	}
	public void Fill_Input_Details_All_Valid() throws InterruptedException
	{
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4562");
		Thread.sleep(1000);
		Reporter.log("Entered 4562 at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
	}
	public void Verify_Alert() throws InterruptedException
	{
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
		Thread.sleep(1000);
	}
	public void Verify_After_Clicked_On_AddSettlement_Button()
	{
		WebElement table2 = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		WebElement addsettlement_button2 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		if(DriverInitializer.isEnabled(addsettlement_button2))
		{
			Reporter.log("Add Settlement button is not disabled, after generated bill amount grid",true);
		}
		else
		{
			Reporter.log("As expected Add Settlement button is disabled, after generated bill amount grid",true);
		}
		if(DriverInitializer.isDisplayed(table2))
		{
			Reporter.log("As expected Bill Amount Web Table is displayed",true);
		}
		else
		{
			Reporter.log("Bill Amount web table is not displayed",true);	
		}
		if(DriverInitializer.isDisplayed(Save))
		{
			Reporter.log("As expected Save button is displayed",true);
		}
		else
		{
			Reporter.log("Save button is not displayed",true);
		}
		if(DriverInitializer.isEnabled(Save))
		{
			Reporter.log("As expected Save button is enabled",true);
		}
		else
		{
			Reporter.log("Save button is not enabled",true);
		}
		
	}
	public void Verify_BillAmount_Webtable_Data()
	{
		
		WebElement table3 = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement header = table3.findElement(By.tagName("thead"));
		String headerrow = header.getText();
		Reporter.log("                                           ",true);
		Reporter.log(headerrow,true);
		Reporter.log("----------------------------------------------",true);
		WebElement body = table3.findElement(By.tagName("tbody"));
		 List<WebElement> rows = body.findElements(By.tagName("tr"));
		 for (WebElement eachrow : rows) {
			List<WebElement> Cell = eachrow.findElements(By.tagName("td"));
			for (WebElement Eachcell : Cell) {
				String CellData = Eachcell.getText();
				if(CellData.equals("1106.00")){
					String Cashamount = Cell.get(9).getText();
					Reporter.log("Cash Amount displayed in Bill Amount grid as "+Cashamount,true);
					
				}
								
			}
			
		}
		Reporter.log("                                           ",true);
	}
	public void Select_Cheque_Option() throws InterruptedException
	{
		WebElement PaymentMode = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM = new Select(PaymentMode);
		PM.selectByIndex(3);
		Reporter.log("Selected Cheque option at Payment Dropdown",true);
		Thread.sleep(2000);
	}
	public void Verify_After_Clicked_On_AddSettlement_Button_For_Cheque()
	{
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement ChequeDate = driver.findElement(By.xpath(Cheque_date_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		if(DriverInitializer.isDisplayed(BankName))
		{
			Reporter.log("As expected Bank Name text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
		}
		else
		{
			Reporter.log("Not displayed Bank Name text box after selected Cheque option at Payment Drop down",true);
		}
		
		if(DriverInitializer.isDisplayed(ChequeNumber))
		{
			Reporter.log("As expected Cheque Number text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
		}
		else
		{
			Reporter.log("Not displayed Cheque Number text box after selected Cheque option at Payment Drop down",true);
		}
		
		if(DriverInitializer.isDisplayed(ChequePayee))
		{
			Reporter.log("As expected Cheque Payee text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
		}
		else
		{
			Reporter.log("Not displayed Cheque Payee text box after selected Cheque option at Payment Drop down",true);
		}
		
		if(DriverInitializer.isDisplayed(ChequeDate))
		{
			Reporter.log("As expected Cheque Date text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
		}
		else
		{
			Reporter.log("Not displayed Cheque Date text box after selected Cheque option at Payment Drop down",true);
		}
		if(DriverInitializer.isEnabled(AddSettlement))
		{
			Reporter.log("As expected AddSettlement button is enabled by default",true);
		}
		else
		{
			Reporter.log("AddSettlement button is not enabled by default",true);
		}
		
		
		Assert.assertTrue(DriverInitializer.isDisplayed(BankName)&&DriverInitializer.isDisplayed(ChequeNumber)&&DriverInitializer.isDisplayed(ChequePayee)&&DriverInitializer.isDisplayed(ChequeDate)&&DriverInitializer.isEnabled(AddSettlement));
	}
	public void bs_51_Verify_Name_on_CreditCard_With_Valid_Alphabets() throws InterruptedException 
	{
	
		try
		{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		bst.Fill_Input_Details_All_Valid();
		bst.Verify_Alert();
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		bst.Verify_BillAmount_Webtable_Data();
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		  }
	}

	public void bs_52_Verify_Name_on_CreditCard_With_InValid_Alphanumeric() throws InterruptedException
	{
		try
		{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();	
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sree123");
		Thread.sleep(1000);
		Reporter.log("Entered Sree123 as Alphanumeric at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4562");
		Thread.sleep(1000);
		Reporter.log("Entered 4562 at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		bst.Verify_Alert();
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		Assert.assertFalse(DriverInitializer.isEnabled(Save));
		}catch(Exception e)
		  {
			Reporter.log(e.getMessage(),true);
		   }
		
	}

	public void bs_224_Verify_Name_on_CreditCard_With_InValid_SpecialCharacters() throws InterruptedException
	{
		try
		{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
			bst.Open_Bill_Settlement_Page();
			bst.Verify_Bill_Settlement_Page_AllElements();
			bst.Select_CreditCard_Option();
			bst.Verify_Fields_After_Selected_CreditCard_Option();
			WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
			Name.clear();
			Name.sendKeys("@!*^#");
			Thread.sleep(1000);
			Reporter.log("Entered @!*^# as Special Characters at Name on Credit Card text box",true);
			WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
			CreditCardNumber.clear();
			CreditCardNumber.sendKeys("4562");
			Thread.sleep(1000);
			Reporter.log("Entered 4562 at Credit Card Number text box",true);
			WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
			Amount.clear();
			Amount.sendKeys("1106");
			Thread.sleep(1000);
			Reporter.log("Entered 1106 at Amount text box",true);
			WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
			Select CCT  = new Select(CreditCardTypeDropDown);
			CCT.selectByIndex(2);
			Thread.sleep(1000);
			Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
			WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
			button.click();
			Reporter.log("Clicked on AddSettlement button",true);
			Thread.sleep(1000);
			if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up, when Name on Credit Card accepts Special Characters",true);
				
			}
			Thread.sleep(1000);
			bst.Verify_After_Clicked_On_AddSettlement_Button();
			WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
			Assert.assertFalse(DriverInitializer.isEnabled(Save));
		}catch(Exception e)
		{
		Reporter.log(e.getMessage(),true);
		}
	  
	
		
	}

	public void bs_225_Verify_Name_on_CreditCard_With_InValid_Numeric() throws InterruptedException
	{
		try
		{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
			bst.Open_Bill_Settlement_Page();
			bst.Verify_Bill_Settlement_Page_AllElements();
			bst.Select_CreditCard_Option();
			bst.Verify_Fields_After_Selected_CreditCard_Option();
			WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
			Name.clear();
			Name.sendKeys("123456");
			Thread.sleep(1000);
			Reporter.log("Entered 123456 as Numeric at Name on Credit Card text box",true);
			WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
			CreditCardNumber.clear();
			CreditCardNumber.sendKeys("4562");
			Thread.sleep(1000);
			Reporter.log("Entered 4562 at Credit Card Number text box",true);
			WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
			Amount.clear();
			Amount.sendKeys("1106");
			Thread.sleep(1000);
			Reporter.log("Entered 1106 at Amount text box",true);
			WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
			Select CCT  = new Select(CreditCardTypeDropDown);
			CCT.selectByIndex(2);
			Thread.sleep(1000);
			Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
			WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
			button.click();
			Reporter.log("Clicked on AddSettlement button",true);
			Thread.sleep(1000);
			if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up, when Name on Credit Card accepts Numeric",true);
				
			}
			Thread.sleep(1000);
			bst.Verify_After_Clicked_On_AddSettlement_Button();
			WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
			Assert.assertFalse(DriverInitializer.isEnabled(Save));
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
		
		
	}

	public void bs_53_Verify_Name_on_CreditCard_Without_Entering_Name() throws InterruptedException
	{ 
		try
		{
			hp.OpenApplication();
			hp.Click_On_ClickHereToLogin();
			sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
			bst.Open_Bill_Settlement_Page();
			bst.Verify_Bill_Settlement_Page_AllElements();
			bst.Select_CreditCard_Option();
			bst.Verify_Fields_After_Selected_CreditCard_Option();
			Reporter.log("Leaving as Blank at Name on Credit Card text box",true);
			WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
			CreditCardNumber.clear();
			CreditCardNumber.sendKeys("4562");
			Thread.sleep(1000);
			Reporter.log("Entered 4562 at Credit Card Number text box",true);
			WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
			Amount.clear();
			Amount.sendKeys("1106");
			Thread.sleep(1000);
			Reporter.log("Entered 1106 at Amount text box",true);
			WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
			Select CCT  = new Select(CreditCardTypeDropDown);
			CCT.selectByIndex(2);
			Thread.sleep(1000);
			Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
			WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
			button.click();
			Reporter.log("Clicked on AddSettlement button",true);
			Thread.sleep(1000);
			if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up, when Name on Credit Card Field accepts Blank",true);
				Reporter.log("Should be displayed Pop up Message as Please Enter the Name",true);
				
			}
			Assert.assertTrue(DriverInitializer.isAlertPresent());
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
			
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
		
	}

public void bs_54_Verify_Name_on_Credit_Card_Textbox_with_Minimum_6_Char_Valid() throws InterruptedException
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
	bst.Open_Bill_Settlement_Page();
	bst.Verify_Bill_Settlement_Page_AllElements();
	bst.Select_CreditCard_Option();
	bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Pankaj");
	Thread.sleep(1000);
	Reporter.log("Entered Pankaj as Valid minimum 6 characters at Name on Credit Card text box",true);
	WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCardNumber.clear();
	CreditCardNumber.sendKeys("4562");
	Thread.sleep(1000);
	Reporter.log("Entered 4562 at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Thread.sleep(1000);
	Reporter.log("Entered 1106 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	button.click();
	Reporter.log("Clicked on AddSettlement button",true);
	Thread.sleep(1000);
	bst.Verify_Alert();
	bst.Verify_After_Clicked_On_AddSettlement_Button();
	WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
	Assert.assertTrue(DriverInitializer.isEnabled(Save));
	Reporter.log("As expected accepted minimum 6 characters at Name on Card text box",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}

public void bs_55_Verify_Name_on_Credit_Card_Textbox_with_Maximum_30_Char_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanthsreekanthsreekanthabc");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanthsreekanthsreekanthabc as Valid maximum 30 characters at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4562");
		Thread.sleep(1000);
		Reporter.log("Entered 4562 at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		Assert.assertTrue(DriverInitializer.isEnabled(Save));
		Reporter.log("As expected accepted maximum 30 characters at Name on Card text box",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	
}

public void bs_56_Verify_Name_on_CreditCard_with_Morethan_30_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanthsreekanthsreekanthabcabc");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanthsreekanthsreekanthabcabc as invalid morethan 30 characters at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4562");
		Thread.sleep(1000);
		Reporter.log("Entered 4562 at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Not Accept Morethan 30 Characters at Name on CreditCard text box",true);
		}
		Thread.sleep(1000);
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		Assert.assertFalse(DriverInitializer.isEnabled(Save));
		Reporter.log("As expected not accepted morethan 30 characters at Name on Card text box",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_226_Verify_Name_on_CreditCard_with_below_6_Characters_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sree");
		Thread.sleep(1000);
		Reporter.log("Entered Sree as invalid below 6 characters at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4562");
		Thread.sleep(1000);
		Reporter.log("Entered 4562 at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Not Accept below 6 Characters at Name on CreditCard text box",true);
		}
		Thread.sleep(1000);
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		Assert.assertFalse(DriverInitializer.isEnabled(Save));
		Reporter.log("As expected not accepted below 6 characters at Name on Card text box",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
	}

public void bs_57_Verify_CreditCard_Number_with_Numeric_Valid()
{
	try
	{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Sreekanth Katar");
	Thread.sleep(1000);
	Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
	WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCardNumber.clear();
	CreditCardNumber.sendKeys("4562");
	Thread.sleep(1000);
	Reporter.log("Entered 4562 at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Thread.sleep(1000);
	Reporter.log("Entered 1106 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	button.click();
	Reporter.log("Clicked on AddSettlement button",true);
	Thread.sleep(1000);
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
	Thread.sleep(1000);
	bst.Verify_After_Clicked_On_AddSettlement_Button();
	WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
	Assert.assertTrue(DriverInitializer.isEnabled(Save));
	Reporter.log("As expected accepted numeric at Credit Card Number Text box",true);
	bst.Verify_BillAmount_Webtable_Data();
	}catch(Exception e)
	  {
		Reporter.log(e.getMessage(),true);
	   }
}
public void bs_58_Verify_Credit_Card_Number_with_SpecialChar_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("!@#*");
		Thread.sleep(1000);
		Reporter.log("Entered !@#* Special Characters as invalid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Please Enter Credit Card Number at CreditCard Number text box",true);
		}
		Thread.sleep(1000);
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement addsettlement_button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		Assert.assertTrue(DriverInitializer.isEnabled(addsettlement_button));
		Reporter.log("As expected not accepted Special characters to enter at Credit Card Number text box",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
}

public void bs_227_Verify_Credit_Card_Number_with_Alphanumeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("Sree123");
		Thread.sleep(1000);
		Reporter.log("Entered Sree123 Alphanumeric as invalid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Not Accept Alphanumeric at CreditCard Number text box",true);
		}
		Thread.sleep(1000);
		bst.Verify_After_Clicked_On_AddSettlement_Button();
		WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
		Assert.assertTrue(DriverInitializer.isEnabled(Save));
		Reporter.log("As expected not accepted Alphanumeric to enter at Credit Card Number text box",true);
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
}
public void bs_228_Verify_Credit_Card_Number_with_Alphabets_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("Sree");
		Thread.sleep(1000);
		Reporter.log("Entered Sree Alphabets as invalid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Please Enter Credit Card Number at CreditCard Number text box",true);
		}
		
		Assert.assertTrue(button.isEnabled());
		}catch(Exception e){
			Reporter.log(e.getMessage(),true);
		}
}

public void bs_59_Verify_Credit_Card_Number_with_Blank_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		Reporter.log("Leaving as Blank as invalid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Please Enter Credit Card Number at CreditCard Number text box",true);
		}
		Thread.sleep(1000);
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
		}
	
	catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}

 }
public void bs_60_Verify_CreditCard_Number_with_4_Digits_Valid()
{
	try
	{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Sreekanth Katar");
	Thread.sleep(1000);
	Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
	WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCardNumber.clear();
	CreditCardNumber.sendKeys("4562");
	Thread.sleep(1000);
	Reporter.log("Entered 4562, with 4 digits as Valid at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Thread.sleep(1000);
	Reporter.log("Entered 1106 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	button.click();
	Reporter.log("Clicked on AddSettlement button",true);
	Thread.sleep(1000);
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
	Thread.sleep(1000);
	bst.Verify_After_Clicked_On_AddSettlement_Button();
	WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
	Assert.assertTrue(DriverInitializer.isEnabled(Save));
	Reporter.log("As expected accepted 4 digits at Credit Card Number Text box",true);
	bst.Verify_BillAmount_Webtable_Data();
	}catch(Exception e)
	  {
		Reporter.log(e.getMessage(),true);
	   }
}

public void bs_61_Verify_Credit_Card_Number_with_Morethan_4_digits_Invalid()
{
	try
	{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Sreekanth Katar");
	Thread.sleep(1000);
	Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
	WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCardNumber.clear();
	CreditCardNumber.sendKeys("45627");
	Thread.sleep(1000);
	Reporter.log("Accepted 4 digits only as 4562, eventhough given data 45627 with 5 digits, to verify more than 4 digits Invalid at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Thread.sleep(1000);
	Reporter.log("Entered 1106 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement CreditCard_Number_Textbox = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	String length = CreditCard_Number_Textbox.getAttribute("maxlength");
	int l = Integer.parseInt(length);
	if(l>4)
	{
		Reporter.log("Accepting Morethan 4 digits at CreditCard Number Textbox",true);
	}
	else
	{
		Reporter.log("As expected Not Accepting morethan 4 digits at Credit Card Number Text box",true);
	}
	Assert.assertFalse(l>4);
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
}

public void bs_62_Verify_Credit_Card_Number_with_below_4_digits_Invalid()
{
	try
	{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Sreekanth Katar");
	Thread.sleep(1000);
	Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
	WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCardNumber.clear();
	CreditCardNumber.sendKeys("456");
	Thread.sleep(1000);
	Reporter.log("Accepted 3 digits as 456, when verifying below 4 digits Invalid at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Thread.sleep(1000);
	Reporter.log("Entered 1106 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	button.click();
	Reporter.log("Clicked on AddSettlement button",true);
	Thread.sleep(1000);
	if(DriverInitializer.isAlertPresent())
	{
		Reporter.log("As expected Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
	}
	else
	{
		Reporter.log("Alert not presented",true);
		Reporter.log("Should be displayed pop up, when Credit Card Number accepts Below 4 digits",true);
		
	}
	Thread.sleep(1000);
	bst.Verify_After_Clicked_On_AddSettlement_Button();
	WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
	Assert.assertFalse(DriverInitializer.isEnabled(Save));
	}
	catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
	
}




public void bs_63_Verify_Default_Option_At_Credit_Card_Type_Dropdown() throws InterruptedException
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		WebElement CreditCardType_Dropdown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	if(DriverInitializer.isDisplayed(CreditCardType_Dropdown))
	{
		Reporter.log("As expected Credit Card Type dropdown is displayed after selected Credit Card option at Payment Dropdown",true);
	}
	else
	{
		Reporter.log("Credit Card Type Dropdown not displayed after selected Credit Card option at Payment Dropdown",true);
	}
	Select cct = new Select(CreditCardType_Dropdown);
	WebElement default_option = cct.getFirstSelectedOption();
	String t = default_option.getText();
	String actual_text = t;
	String expected_text = "Select";
	if(DriverInitializer.isEqualsIgnoreCase(actual_text,expected_text))
	{
		flag=true;
	}
	
	if(flag==true)
	{
		Reporter.log("As expected "+t+" option displayed at Credit Card Type Dropdown by default",true);
	}
	else
	{
		Reporter.log(t+" option not displayed at Credit Card Type Dropdown by default",true);
	}
	Assert.assertTrue(DriverInitializer.isEqualsIgnoreCase(actual_text, expected_text));
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_64_Verify_Credit_Card_Type_Dropdown_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
	WebElement CreditCardType_Dropdown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	if(DriverInitializer.isDisplayed(CreditCardType_Dropdown))
	{
		Reporter.log("As expected Credit Card Type dropdown is displayed after selected Credit Card option at Payment Dropdown",true);
	}
	else
	{
		Reporter.log("Credit Card Type Dropdown not displayed after selected Credit Card option at Payment Dropdown",true);
	}
	Select cct = new Select(CreditCardType_Dropdown);
	cct.selectByIndex(2);
	List<WebElement> gt = cct.getAllSelectedOptions();
	for (WebElement eachone : gt)
	{
		String actual_text = eachone.getText();
		String expected_text = "Visa";
		if(DriverInitializer.isEquals(actual_text, expected_text))
		{
			Reporter.log("As expected List Displayed and Selected "+actual_text+" option at Credit Card Type Dropdown",true);
		}
		else
		{
			Reporter.log("Not Selected "+actual_text+" option ",true);
		}
		Assert.assertTrue(DriverInitializer.isEquals(actual_text, expected_text));
	}
	
	
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
}

public void bs_65_Verify_Credit_Card_Type_with_Blank_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number.clear();
		CreditCard_Number.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Thread.sleep(1000);
		Reporter.log("Entered 1106 at Amount text box",true);
		Reporter.log("Leaving as Blank as invalid at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
		
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should display a Pop up as Please Select Credit Card Type at CreditCard Type Drop down",true);
		}
		Thread.sleep(1000);
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
		}
	
	catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}

 }
public void bs_66_Verify_Amount_Lessthan_or_Equal_to_NetAmount()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_CreditCard_Option();
		bst.Verify_Fields_After_Selected_CreditCard_Option();
		WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name.clear();
		Name.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number.clear();
		CreditCard_Number.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("250");
		Thread.sleep(1000);
		Reporter.log("Entered 250 at Amount text box",true);
		WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT  = new Select(CreditCardTypeDropDown);
		CCT.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Reporter.log("									",true);
		WebElement PaymentMode2 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM2 = new Select(PaymentMode2);
		PM2.selectByIndex(2);
		Reporter.log("Selected Credit Card option at Payment Dropdown",true);
		WebElement Name2 = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name2.clear();
		Name2.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number2 = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number2.clear();
		CreditCard_Number2.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount2 = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount2.clear();
		Amount2.sendKeys("250");
		Thread.sleep(1000);
		Reporter.log("Entered 250 at Amount text box",true);
		WebElement CreditCardTypeDropDown2 = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT2  = new Select(CreditCardTypeDropDown2);
		CCT2.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button2 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button2.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Reporter.log("									",true);
		WebElement PaymentMode3 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM3 = new Select(PaymentMode3);
		PM3.selectByIndex(2);
		Reporter.log("Selected Credit Card option at Payment Dropdown",true);
		WebElement Name3 = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name3.clear();
		Name3.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number3 = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number3.clear();
		CreditCard_Number3.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount3 = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount3.clear();
		Amount3.sendKeys("250");
		Thread.sleep(1000);
		Reporter.log("Entered 250 at Amount text box",true);
		WebElement CreditCardTypeDropDown3 = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT3  = new Select(CreditCardTypeDropDown3);
		CCT3.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button3 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button3.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Reporter.log("									",true);
		WebElement PaymentMode4 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM4 = new Select(PaymentMode4);
		PM4.selectByIndex(2);
		Reporter.log("Selected Credit Card option at Payment Dropdown",true);
		WebElement Name4 = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name4.clear();
		Name4.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number4 = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number4.clear();
		CreditCard_Number4.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount4 = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount4.clear();
		Amount4.sendKeys("250");
		Thread.sleep(1000);
		Reporter.log("Entered 250 at Amount text box",true);
		WebElement CreditCardTypeDropDown4 = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT4  = new Select(CreditCardTypeDropDown4);
		CCT4.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button4 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button4.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Reporter.log("									",true);
		WebElement PaymentMode5 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM5 = new Select(PaymentMode5);
		PM5.selectByIndex(2);
		Reporter.log("Selected Credit Card option at Payment Dropdown",true);
		WebElement Name5 = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
		Name5.clear();
		Name5.sendKeys("Sreekanth Katar");
		Thread.sleep(1000);
		Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
		WebElement CreditCard_Number5 = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
		CreditCard_Number5.clear();
		CreditCard_Number5.sendKeys("4562");
		Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
		WebElement Amount5 = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount5.clear();
		Amount5.sendKeys("106");
		Thread.sleep(1000);
		Reporter.log("Entered 106 at Amount text box",true);
		WebElement CreditCardTypeDropDown5 = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
		Select CCT5  = new Select(CreditCardTypeDropDown5);
		CCT5.selectByIndex(2);
		Thread.sleep(1000);
		Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
		WebElement button5 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		button5.click();
		Reporter.log("Clicked on AddSettlement button",true);
		Thread.sleep(1000);
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
		Reporter.log("									",true);
		
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			
		}
		WebElement webtable = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement tablehead = webtable.findElement(By.tagName("thead"));
		List<WebElement> headerrow = tablehead.findElements(By.tagName("tr"));
		List<WebElement> theaders = headerrow.get(0).findElements(By.tagName("th"));
		String a = theaders.get(5).getText();
		String b = theaders.get(6).getText();
		String c = theaders.get(7).getText();
		String d = theaders.get(8).getText();
		//String head = tablehead.getText();
		Reporter.log("									",true);
		Reporter.log(" | " +a+ " | " +b+ " | " +c+ " | " +d+ " | ",true);
		Reporter.log("-------------------------------------------------------",true);
		WebElement tablebody = webtable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tablebody.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		String one = cols.get(6).getText();
		String two = cols.get(7).getText();
		String three = cols.get(8).getText();
		String four = cols.get(9).getText();
		Reporter.log(" | " +one+"     "+ " | " +two+"   "+ " | " +three+"    "+ " | " +four+"      "+ " | ",true);
		
		List<WebElement> cols1 = rows.get(2).findElements(By.tagName("td"));
		String one1 = cols1.get(6).getText();
		String two1 = cols1.get(7).getText();
		String three1 = cols1.get(8).getText();
		String four1 = cols1.get(9).getText();
		Reporter.log(" | " +one1+"     "+ " | " +two1+"   "+ " | " +three1+"    "+ " | " +four1+"      "+ " | ",true);
		
		List<WebElement> cols2 = rows.get(3).findElements(By.tagName("td"));
		String one2 = cols2.get(6).getText();
		String two2 = cols2.get(7).getText();
		String three2 = cols2.get(8).getText();
		String four2 = cols2.get(9).getText();
		Reporter.log(" | " +one2+"     "+ " | " +two2+"   "+ " | " +three2+"    "+ " | " +four2+"      "+ " | ",true);
		List<WebElement> cols3 = rows.get(4).findElements(By.tagName("td"));
		String one3 = cols3.get(6).getText();
		String two3 = cols3.get(7).getText();
		String three3 = cols3.get(8).getText();
		String four3 = cols3.get(9).getText();
		Reporter.log(" | " +one3+"     "+ " | " +two3+"   "+ " | " +three3+"    "+ " | " +four3+"      "+ " | ",true);
		
		List<WebElement> cols4 = rows.get(5).findElements(By.tagName("td"));
		String one4 = cols4.get(6).getText();
		String two4 = cols4.get(7).getText();
		String three4 = cols4.get(8).getText();
		String four4 = cols4.get(9).getText();
		Reporter.log(" | " +one4+"     "+ " | " +two4+"   "+ " | " +three4+"    "+ " | " +four4+"      "+ "  | ",true);
		Reporter.log("									",true);
		String firstrow_cashamt = rows.get(1).findElement(By.xpath("td[10]")).getText();
		int first_val = Double.valueOf(firstrow_cashamt).intValue();
		Reporter.log("First Row Cash Amount String Value "+firstrow_cashamt+" converted to Integer Value, The Integer Value is: "+first_val,true);
		String secondrow_cashamt = rows.get(2).findElement(By.xpath("td[10]")).getText();
		int second_val = Double.valueOf(secondrow_cashamt).intValue();
		Reporter.log("Second Row Cash Amount String Value "+secondrow_cashamt+" converted to Integer Value, The Integer Value is: "+second_val,true);
		String thirdrow_cashamt = rows.get(3).findElement(By.xpath("td[10]")).getText();
		int third_val = Double.valueOf(thirdrow_cashamt).intValue();
		Reporter.log("Third Row Cash Amount String Value "+thirdrow_cashamt+" converted to Integer Value, The Integer Value is: "+third_val,true);
		String fourthrow_cashamt = rows.get(4).findElement(By.xpath("td[10]")).getText();
		int fourth_val = Double.valueOf(fourthrow_cashamt).intValue();
		Reporter.log("Fourth Row Cash Amount String Value "+fourthrow_cashamt+" converted to Integer Value, The Integer Value is: "+fourth_val,true);
		String fifth_cashamt = rows.get(5).findElement(By.xpath("td[10]")).getText();
		int fifth_val = Double.valueOf(fifth_cashamt).intValue();
		Reporter.log("Fifth Row Cash Amount String Value "+fifth_cashamt+" converted to Integer Value, The Integer Value is: "+fifth_val,true);
		Reporter.log("-----------------------------------------------------------------------------------------------------------",true);
		int Total_CashAmount = first_val+second_val+third_val+fourth_val+fifth_val;
		Reporter.log("Total Cash Amount Integer Value is: "+Total_CashAmount,true);
		String ab = String.valueOf(Total_CashAmount).toString();
		String billamount = driver.findElement(By.xpath(Bill_Amount_Disable_xpath)).getAttribute("value");
		if(billamount.contains(ab))
		{
			Reporter.log("As expected Total Cash Amount is equal to Bill Amount, And Displayed Net Amount is 0.00 ",true);
			Reporter.log("As expected Amount field is accepting Lessthan or equal to Bill Amount ",true);
		}
		else
		{
			Reporter.log("Total Cash Amount is not equal to Bill Amount, And Displayed Net Amount is not 0.00 ",true);
			Reporter.log("As expected Amount field is not accepting Lessthan or equal to Bill Amount ",true);
		}
		
		Assert.assertTrue(billamount.contains(ab));
	
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_67_Verify_Amount_with_Morethan_NetAmount() throws InterruptedException
{ 	try{
	hp.OpenApplication();
	hp.Click_On_ClickHereToLogin();
	sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
	bst.Open_Bill_Settlement_Page();
	bst.Verify_Bill_Settlement_Page_AllElements();
	bst.Select_CreditCard_Option();
	bst.Verify_Fields_After_Selected_CreditCard_Option();
	WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
	Name.clear();
	Name.sendKeys("Sreekanth Katar");
	Thread.sleep(1000);
	Reporter.log("Entered Sreekanth Katar at Name on Credit Card text box",true);
	WebElement CreditCard_Number = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
	CreditCard_Number.clear();
	CreditCard_Number.sendKeys("4562");
	Reporter.log("Entered 4562 as valid at Credit Card Number text box",true);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1200");
	Thread.sleep(1000);
	Reporter.log("Entered 1200 at Amount text box",true);
	WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
	Select CCT  = new Select(CreditCardTypeDropDown);
	CCT.selectByIndex(2);
	Thread.sleep(1000);
	Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
	WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	button.click();
	Reporter.log("Clicked on AddSettlement button",true);
	Thread.sleep(3000);
	 Assert.assertTrue(DriverInitializer.isAlertPresent());
	 flag=true;
	 if(flag==true)
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
		}
	 Thread.sleep(3000);
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
		
	}
	}
public void bs_68_Verify_PaymentMode_Cheque_Option()
{
	try{
		Thread.sleep(2000);
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
	
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_69_Verify_BankName_with_Alphabets_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));

		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		//Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_0);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_4);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_1);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_5);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_2);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_0);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_1);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_7);
			Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
			Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
			}
		 Assert.assertTrue(!(AddSettlement.isEnabled()));
		WebElement webtable = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement tablehead = webtable.findElement(By.tagName("thead"));
		List<WebElement> headerrow = tablehead.findElements(By.tagName("tr"));
		List<WebElement> theaders = headerrow.get(0).findElements(By.tagName("th"));
		String a = theaders.get(5).getText();
		String b = theaders.get(6).getText();
		String c = theaders.get(7).getText();
		String d = theaders.get(8).getText();
		Reporter.log("									",true);
		Reporter.log(" | " +a+ " | " +b+ " | " +c+ " | " +d+ " | ",true);
		Reporter.log("-------------------------------------------------------",true);
		WebElement tablebody = webtable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tablebody.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		String one = cols.get(6).getText();
		String two = cols.get(7).getText();
		String three = cols.get(8).getText();
		String four = cols.get(9).getText();
		Reporter.log(" | " +one+"     "+ " | " +two+"   "+ " | " +three+"    "+ " | " +four+"      "+ " | ",true);
		Reporter.log("									",true);
		String firstrow_cashamt = rows.get(1).findElement(By.xpath("td[10]")).getText();
		int first_val = Double.valueOf(firstrow_cashamt).intValue();
		Reporter.log("Cash Amount String Value "+firstrow_cashamt+" converted to Integer Value, The Integer Value is: "+first_val,true);
		WebElement BillAmount = driver.findElement(By.xpath(Bill_Amount_Disable_xpath));
		String BillAmount_value = BillAmount.getAttribute("value");
		if(firstrow_cashamt.equals(BillAmount_value))
		{
			Reporter.log("As expected Cash Amount is equal to Net Amount",true);
			Reporter.log("As expected accepted Alphabets at Bank Name",true);
		}
		else
		{
			Reporter.log("Cash Amount is not equal to Net Amount",true);
			Reporter.log("Not Accepted Alphabets at Bank Name",true);
		}
			
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_70_Verify_BankName_with_SplChar_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("!@#$%");
		Reporter.log("Entered !@#$% as Bank Name Special Characters Invalid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		//Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		//ChequeNumber.click();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
				Reporter.log("As expected Bank Name Not accepted Special Characters as Invalid",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Accepted Special Characters at Bank Name as Invalid",true);
				Reporter.log("Should be displayed pop up as Please Enter Bank Name Correctly",true);
			}
		 Assert.assertTrue(AddSettlement.isEnabled());
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
}
public void bs_229_Verify_BankName_with_Numeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
	
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("1234");
		Reporter.log("Entered 1234 as Bank Name Numeric Invalid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
				Reporter.log("As expected Bank Name Not accepted Numeric as Invalid",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Accepted Numeric at Bank Name as Invalid",true);
				Reporter.log("Should be displayed pop up as Please Enter Bank Name Correctly",true);
			}
		 Assert.assertTrue(AddSettlement.isEnabled());
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_230_Verify_BankName_with_AlphaNumeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
	
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("Sree123");
		Reporter.log("Entered Sree123 as Bank Name Alphanumeric Invalid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
				Reporter.log("As expected Bank Name Not accepted Alphanumeric as Invalid",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Accepted Alphanumeric at Bank Name as Invalid",true);
				Reporter.log("Should be displayed pop up as Please Enter Bank Name Correctly",true);
			}
		 Assert.assertTrue(AddSettlement.isEnabled());
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_71_Verify_BankName_with_Blank_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		Reporter.log("Leaving as Blank at Bank Name as Invalid",true);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Please Enter Bank Name",true);
			}
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_72_Verify_BankName_with_Minimum_3_Char_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("SBI");
		Reporter.log("Entered SBI at Bank Name as Minimum 3 Characters valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Minimum 3 characters accepted at Bank Name",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_73_Verify_BankName_with_Maximum_15_Char_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("abcdefghijklmno");
		Reporter.log("Entered abcdefghijklmno at Bank Name as Maximum 15 Characters valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Maximum 15 characters accepted at Bank Name",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_74_Verify_BankName_with_Morethan_15_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("abcdefghijklmnop");
		Reporter.log("Entered abcdefghijklmnop at Bank Name as Morethan 15 Characters Invalid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Not accpeted Morethan 15 Characters at Bank Name",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_75_Verify_Cheque_Number_with_Numeric_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Number as Numeric Valid",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
			}
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Numeric accepted at Cheque Number as valid",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_76_Verify_Cheque_Number_with_Spl_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("!@#$");
		Reporter.log("Entered !@#$ at Cheque Number as Special Characters Invalid, but we are unable to enter special characters here",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Reporter.log("As expected Special Characters not accepted to enter at Cheque Number as invalid",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_231_Verify_Cheque_Number_with_Alphabets_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("abcd");
		Reporter.log("Entered abcd at Cheque Number as Alphabets Invalid, but we are unable to enter alphabets here",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Reporter.log("As expected alphabets not accepted to enter at Cheque Number as invalid",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_232_Verify_Cheque_Number_with_AlphaNumeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("abcd123");
		Reporter.log("Entered abcd123 at Cheque Number as AlphaNumeric Invalid, but we are able to enter 123 only whereas abcd123, unable to enter abcd here",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Not Accepted alphabets, Please Enter Cheque Number Correctly",true);
			}
		 
		
		
		 if(!(AddSettlement.isEnabled()))
		 {
			 Reporter.log("As expected Not Accepted to enter Alphanumeric at Cheque Number,accepted numeric only",true);
		 }
		 else
		 {
			 Reporter.log("Accepted Alphanumeric at Cheque Number",true);
		 }
		 Assert.assertTrue(!(AddSettlement.isEnabled()));
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_233_Verify_BankName_with_below_3_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("SB");
		Reporter.log("Entered SB at Bank Name as below 3 Characters Invalid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Not accpeted below 3 Characters at Bank Name",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_77_Verify_Cheque_Number_with_Blank_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		Reporter.log("Leaving as Blank at Cheque Number Invalid",true);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Please Enter Cheque Number",true);
			}
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_78_Verify_Cheque_Number_with_Minimum_6_Digits_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Number as Minimum 6 digits Valid",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
			}
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Minimum 6 digits accepted at Cheque Number as valid",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_79_Verify_Cheque_Number_with_Lessthan_6_Digits_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("12345");
		Reporter.log("Entered 12345 at Cheque Number as Lessthan 6 digits Invalid",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept lessthan 6 digits at Cheque Number, but accepting here",true);
				Reporter.log("Should display pop up as Please Enter Valid Cheque Number",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_80_Verify_Cheque_Number_with_Morethan_6_Digits_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("1234567");
		Reporter.log("Entered 1234567 at Cheque Number as Morethan 6 digits Invalid",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept morethan 6 digits at Cheque Number, but accepting here",true);
				Reporter.log("Should display pop up as Please Enter Valid Cheque Number",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_81_Verify_Cheque_Payee_with_Alphabets_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC at Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar at Cheque Payee as Alphabets Valid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Alphabets accepted at Cheque Payee",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_82_Verify_Cheque_Payee_with_Spl_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("!@#$");
		Reporter.log("Entered !@#$ at Cheque Payee as Special Characters, Accepting to enter special characters here",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept Special Characters at Cheque Payee, but accepting here",true);
				Reporter.log("Should display pop up as Please Enter Valid Cheque Payee",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_234_Verify_Cheque_Payee_with_AlphaNumeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("abcd123");
		Reporter.log("Entered abcd123 at Cheque Payee as AlphaNumeric Invalid, Accepting to enter alphanumeric here",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not able to enter alphanumeric at Cheque Payee",true);
				Reporter.log("Should be displayed pop up as Not Accepted alphabets, Please Enter Cheque Payee Correctly",true);
			}
		 
		
		
		 if(AddSettlement.isEnabled())
		 {
			 Reporter.log("As expected Not Accepted to enter Alphanumeric at Cheque Payee,accepted numeric only",true);
		 }
		 else
		 {
			 Reporter.log("Accepted Alphanumeric at Cheque Payee",true);
			 
		 }
		 Assert.assertTrue(AddSettlement.isEnabled());
		 Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_235_Verify_Cheque_Payee_with_Numeric_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("123456");
		Reporter.log("Entered 123456 at Cheque Payee as Numeric Invalid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept Numeric to enter at Cheque Payee, but accepting to enter numeric here",true);
				Reporter.log("Should be displayed pop up as Please Enter Valid Cheque Payee",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}

public void bs_83_Verify_Cheque_Payee_with_Minimum_3_Char_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC at Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Ram");
		Reporter.log("Entered Ram at Cheque Payee as Minimum 3 Characters Valid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Minimum 3 Characters accepted at Cheque Payee",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_84_Verify_Cheque_Payee_with_Lessthan_3_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC at Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Ra");
		Reporter.log("Entered Ra at Cheque Payee as Lessthan 3 Characters Invalid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept Lessthan 3 Charactes at Cheque Payee, but accepting here",true);
				Reporter.log("Should display pop up message as Please Enter Cheque Payee Correctly",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_85_Verify_Cheque_Payee_with_Maximum_20_Char_Valid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC at Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("abcdefghijklmnopqrst");
		Reporter.log("Entered abcdefghijklmnopqrst at Cheque Payee as Maximum 20 characters Valid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		Assert.assertTrue(!(AddSettlement.isEnabled()));
		Reporter.log("As expected Maximum 20 characters accepted at Cheque Payee",true);
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_86_Verify_Cheque_Payee_with_Morethan_20_Char_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC at Bank Name",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("abcdefghijklmnopqrstu");
		Reporter.log("Entered abcdefghijklmnopqrstu at Cheque Payee as Morethan 20 characters Invalid",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
			
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should not accept morethan 20 characters at Cheque Payee, but accepting here",true);
				Reporter.log("Should be displayed pop up as Not accpeted Morethan 20 Characters at Cheque Payee",true);
			}
		Assert.assertTrue(AddSettlement.isEnabled());
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_87_Verify_Cheque_Payee_with_Blank_Invalid()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		Reporter.log("Leaving as Blank at Cheque Payee Invalid",true);
		ChequePayee.click();
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("Should be displayed pop up as Please Enter Cheque Payee",true);
			}
		Assert.assertTrue(DriverInitializer.isAlertPresent());
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		}catch(Exception e)
		{
			Reporter.log(e.getMessage(),true);
		}
	
}
public void bs_99_Verify_Cheque_Date_format() throws AWTException, InterruptedException{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement ChequeDate = driver.findElement(By.xpath(Cheque_date_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar at Cheque Payee",true);
		String chdateid = ChequeDate.getAttribute("id");
		String chdatetype = ChequeDate.getAttribute("type");
		if((chdateid.equals("chequedate"))&&(chdatetype.equals("date")))
		{
		Reporter.log("As expected Cheque date is displayed as mm/dd/yyyy format before selecting of date",true);
		}
		else
		{
		Reporter.log("Cheque date not displyed as expected format before selecting of date",true);
		}
		ChequePayee.click();
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date, and displayed as 04/15/2017 at Cheque date",true);
		Thread.sleep(1000);
		Assert.assertTrue((chdateid.equals("chequedate"))&&(chdatetype.equals("date")));
		}catch(Exception  e){
			Reporter.log(e.getMessage(),true);
	}
	}
public void bs_100_Verify_Cheque_Date_with_Morethan_SystemDate()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement ChequeDate = driver.findElement(By.xpath(Cheque_date_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar at Cheque Payee",true);
		String chdateid = ChequeDate.getAttribute("id");
		String chdatetype = ChequeDate.getAttribute("type");
		if((chdateid.equals("chequedate"))&&(chdatetype.equals("date")))
		{
		Reporter.log("As expected Cheque date is displayed as mm/dd/yyyy format before selecting of date",true);
		}
		else
		{
		Reporter.log("Cheque date not displyed as expected format before selecting of date",true);
		}
		ChequePayee.click();
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_3);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_8);
		Reporter.log("Selected Month as 04, Date as 30, Year as 2018 at Cheque Date as Morethan System Date, and displayed as 04/30/2018 at Cheque date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("As expected Morethan System date accepted at Cheque date",true);
			}
		Assert.assertTrue(!(DriverInitializer.isAlertPresent()));
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		}catch(Exception  e){
			Reporter.log(e.getMessage(),true);
	}
}
public void bs_101_Verify_Cheque_Date_with_Lessthan_SystemDate()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement ChequeDate = driver.findElement(By.xpath(Cheque_date_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 123456 as Cheque Number",true);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar at Cheque Payee",true);
		String chdateid = ChequeDate.getAttribute("id");
		String chdatetype = ChequeDate.getAttribute("type");
		if((chdateid.equals("chequedate"))&&(chdatetype.equals("date")))
		{
		Reporter.log("As expected Cheque date is displayed as mm/dd/yyyy format before selecting of date",true);
		}
		else
		{
		Reporter.log("Cheque date not displyed as expected format before selecting of date",true);
		}
		ChequePayee.click();
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date as Lessthan System Date, and displayed as 04/15/2017 at Cheque date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
				
				
			}
			else
			{
				Reporter.log("Alert not presented",true);
				Reporter.log("As expected Lessthan System date accepted at Cheque date",true);
			}
		Assert.assertTrue(!(DriverInitializer.isAlertPresent()));
		
		}catch(Exception  e){
			Reporter.log(e.getMessage(),true);
	}
}
public void bs_102_Verify_Amount_Lessthan_or_Equal_to_NetAmount()
{
	try{
		hp.OpenApplication();
		hp.Click_On_ClickHereToLogin();
		sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
		bst.Open_Bill_Settlement_Page();
		bst.Verify_Bill_Settlement_Page_AllElements();
		bst.Select_Cheque_Option();
		bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
		WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName.clear();
		BankName.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber.clear();
		ChequeNumber.sendKeys("123456");
		Reporter.log("Entered 1234567 at Cheque Number as Morethan 6 digits Invalid",true);
		Thread.sleep(1000);
		ChequePayee.clear();
		ChequePayee.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		DriverInitializer.Tab();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount.clear();
		Amount.sendKeys("1000");
		Reporter.log("Entered 1000 as Amount",true);
		AddSettlement.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
		 if(DriverInitializer.isAlertPresent())
			{
				Reporter.log("As expected Alert Presented",true);
				String message = driver.switchTo().alert().getText();
				Reporter.log(message+" : is displayed at Pop up",true);
				driver.switchTo().alert().accept();
				Reporter.log("Clicked On OK button in Pop up",true);
			}
			else
			{
				Reporter.log("Alert not presented",true);
				
			}
	
		WebElement webtable = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement tablehead = webtable.findElement(By.tagName("thead"));
		List<WebElement> headerrow = tablehead.findElements(By.tagName("tr"));
		List<WebElement> theaders = headerrow.get(0).findElements(By.tagName("th"));
		String a = theaders.get(5).getText();
		String b = theaders.get(6).getText();
		String c = theaders.get(7).getText();
		String d = theaders.get(8).getText();
		Reporter.log("									",true);
		Reporter.log(" | " +a+ " | " +b+ " | " +c+ " | " +d+ " | ",true);
		Reporter.log("-------------------------------------------------------",true);
		WebElement tablebody = webtable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tablebody.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		String one = cols.get(6).getText();
		String two = cols.get(7).getText();
		String three = cols.get(8).getText();
		String four = cols.get(9).getText();
		Reporter.log(" | " +one+"     "+ " | " +two+"   "+ " | " +three+"    "+ " | " +four+"      "+ " | ",true);
		Reporter.log("									",true);
		Assert.assertTrue(four.equals("1000.00"));
		Assert.assertTrue(AddSettlement.isEnabled());
		Reporter.log("As expected Lessthan Net Amount 1000 is accepted",true);
		Reporter.log("As expected Lessthan Net Amount accepted at Amount",true);
		Reporter.log("									",true);
		driver.navigate().back();
		Thread.sleep(2000);
		WebElement table2 = driver.findElement(By.xpath(WebTable_BillSettlement_Page_xpath));
		WebElement tbody2 = table2.findElement(By.tagName("tbody"));
		List<WebElement> allrows2 = tbody2.findElements(By.tagName("tr"));
		for (WebElement Eachrow2 : allrows2)
		{	
			String BillNo2 = Eachrow2.findElement(By.xpath("td[1]")).getText();
			String GuestName2 = Eachrow2.findElement(By.xpath("td[3]")).getText();
			String BillAmount2 = Eachrow2.findElement(By.xpath("td[4]")).getText();
				
				if(BillAmount2.equals("1106.00"))
				{				
					Reporter.log("Record Available for BillNo "+BillNo2+" with Guest Name "+GuestName2,true);
					Eachrow2.findElement(By.tagName("a")).click();
					Reporter.log("Clicked on BillNo "+BillNo2+" with Guest Name "+GuestName2,true); 
					Reporter.log("Bill Settlement Page Displayed",true);
					break;
				}
		}
		Thread.sleep(1000);
		WebElement PaymentMode2 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
		Select PM2 = new Select(PaymentMode2);
		PM2.selectByIndex(3);
		Reporter.log("Selected Cheque option at Payment Dropdown",true);
		WebElement BankName2 = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
		WebElement ChequeNumber2 = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
		WebElement ChequePayee2 = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
		WebElement AddSettlement2 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
		BankName2.clear();
		BankName2.sendKeys("HDFC");
		Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
		Thread.sleep(1000);
		ChequeNumber2.clear();
		ChequeNumber2.sendKeys("123456");
		Reporter.log("Entered 1234567 at Cheque Number as Morethan 6 digits Invalid",true);
		Thread.sleep(1000);
		ChequePayee2.clear();
		ChequePayee2.sendKeys("Sreekanth Katar");
		Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
		DriverInitializer.Tab();
		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_4);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_5);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_2);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		r2.keyPress(KeyEvent.VK_7);
		Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
		Thread.sleep(1000);
		WebElement Amount2 = driver.findElement(By.xpath(Amount_Textbox_xpath));
		Amount2.clear();
		Amount2.sendKeys("1106");
		Reporter.log("Entered 1106 as Amount",true);
		AddSettlement2.click();
		Reporter.log("Clicked on Add Settlement Button",true);
		Thread.sleep(1000);
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
		WebElement webtable2 = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
		WebElement tablehead2 = webtable2.findElement(By.tagName("thead"));
		List<WebElement> headerrow2 = tablehead2.findElements(By.tagName("tr"));
		List<WebElement> theaders2 = headerrow2.get(0).findElements(By.tagName("th"));
		String a2 = theaders2.get(5).getText();
		String b2 = theaders2.get(6).getText();
		String c2 = theaders2.get(7).getText();
		String d2 = theaders2.get(8).getText();
		Reporter.log("									",true);
		Reporter.log(" | " +a2+ " | " +b2+ " | " +c2+ " | " +d2+ " | ",true);
		Reporter.log("-------------------------------------------------------",true);
		WebElement tablebody2 = webtable2.findElement(By.tagName("tbody"));
		List<WebElement> rows2 = tablebody2.findElements(By.tagName("tr"));
		List<WebElement> cols2 = rows2.get(1).findElements(By.tagName("td"));
		String one2 = cols2.get(6).getText();
		String two2 = cols2.get(7).getText();
		String three2 = cols2.get(8).getText();
		String four2 = cols2.get(9).getText();
		Reporter.log(" | " +one2+"     "+ " | " +two2+"   "+ " | " +three2+"    "+ " | " +four2+"      "+ " | ",true);
		Reporter.log("									",true);
		Assert.assertTrue(four2.equals("1106.00"));
		Assert.assertTrue(!(AddSettlement2.isEnabled()));
		Reporter.log("As expected Equal to NetAmount 1106 is accepted",true);
		Reporter.log("As expected Net Amount which is equal to Amount acceptedt",true);
		Reporter.log("									",true);
	
	
	}catch(Exception e)
	{
		Reporter.log(e.getMessage(),true);
	}
}
public void bs_103_Verify_Amount_Morethan_NetAmount_Invalid()
{
	
try{
	hp.OpenApplication();
	hp.Click_On_ClickHereToLogin();
	sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
	bst.Open_Bill_Settlement_Page();
	bst.Verify_Bill_Settlement_Page_AllElements();
	bst.Select_Cheque_Option();
	bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
	WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
	WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
	WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
	WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	BankName.clear();
	BankName.sendKeys("HDFC");
	Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
	Thread.sleep(1000);
	ChequeNumber.clear();
	ChequeNumber.sendKeys("123456");
	Reporter.log("Entered 1234567 at Cheque Number as Morethan 6 digits Invalid",true);
	Thread.sleep(1000);
	ChequePayee.clear();
	ChequePayee.sendKeys("Sreekanth Katar");
	Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
	DriverInitializer.Tab();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_0);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_4);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_1);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_5);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_2);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_0);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_1);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_7);
	Reporter.log("Selected Month as 04, Date as 15, Year as 2017 at Cheque Date",true);
	Thread.sleep(1000);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1200");
	Reporter.log("Entered 1200 as Amount morethan Net Amount Invalid",true);
	AddSettlement.click();
	Reporter.log("Clicked on Add Settlement Button",true);
	Thread.sleep(3000);
	Assert.assertTrue(DriverInitializer.isAlertPresent());
	if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
			
		}
	 
	 Reporter.log("As expected not accepted the value which is morethan Netamount",true);
	
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}


}

public void bs_104_Verify_Cheque_Date_Blank_Invalid()
{
	
try{
	hp.OpenApplication();
	hp.Click_On_ClickHereToLogin();
	sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
	bst.Open_Bill_Settlement_Page();
	bst.Verify_Bill_Settlement_Page_AllElements();
	bst.Select_Cheque_Option();
	bst.Verify_After_Clicked_On_AddSettlement_Button_For_Cheque();
	WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
	WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
	WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
	WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
	BankName.clear();
	BankName.sendKeys("HDFC");
	Reporter.log("Entered HDFC as Bank Name Alphabets valid",true);
	Thread.sleep(1000);
	ChequeNumber.clear();
	ChequeNumber.sendKeys("123456");
	Reporter.log("Entered 1234567 at Cheque Number as Morethan 6 digits Invalid",true);
	Thread.sleep(1000);
	ChequePayee.clear();
	ChequePayee.sendKeys("Sreekanth Katar");
	Reporter.log("Entered Sreekanth Katar as Cheque Payee",true);
	Reporter.log("Leaving as Blank at Cheque Date",true);
	Thread.sleep(1000);
	WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
	Amount.clear();
	Amount.sendKeys("1106");
	Reporter.log("Entered 1106 as Amount",true);
	AddSettlement.click();
	Reporter.log("Clicked on Add Settlement Button",true);
	Thread.sleep(1000);
	 if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("As expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			
		}
		else
		{
			Reporter.log("Alert not presented",true);
			Reporter.log("Should be displayed Pop up as Please Select Cheque Date",true);
			
		}
	
	 Assert.assertTrue(!(AddSettlement.isEnabled()));
	 Assert.assertTrue(DriverInitializer.isAlertPresent());
	 driver.switchTo().alert().accept();
	 Reporter.log("Clicked On OK button in Pop up",true);
	 
	
	}catch(Exception e){
		Reporter.log(e.getMessage(),true);
	}

}

/*public void bs_105_verify_cash_option_in_paymentmode() throws InterruptedException {
	Reporter.log("TEST:----->>   << BS_105_Verify_Cash_Option_In_Paymentmode >>  ",true);
	Reporter.log("                                               ",true);
	WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
	appmod.click();
	Reporter.log("Clicked on Appointment Module", true);
	Thread.sleep(1000);
	WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
	billsettlement.click();
	Reporter.log("Clicked on Bill Settlement", true);
	Thread.sleep(2000);
	WebElement webtable = driver.findElement(By.xpath(ListofBills_Web_Table_Xpath));
	WebElement tablebody = webtable.findElement(By.tagName("tbody"));
	List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
	WebElement billno = tablerows.get(0).findElement(By.tagName("a"));
	billno.click();
	Reporter.log("Clicked on first Bill No", true);
	Thread.sleep(1000);
	WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
	Select payment = new Select(paymentmode);
	payment.selectByIndex(4);
	Thread.sleep(2000);
	Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
	Reporter.log("As expected not displaying extra options after selected cash option in paymentmode dropdown",true);
	
}

public void bs_106_verify_amount_accepting_equalto_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	boolean flag3 = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).isDisplayed();
	String readonly = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).getAttribute("readonly");
	Assert.assertTrue(readonly.equals("true"));
	Reporter.log("As expected Bill Amount is Disabled",true);
	//Assert.assertTrue(flag1 == true && flag2 != true && flag3 == true );
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("103");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
    WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
	WebElement gridbody = grid.findElement(By.tagName("tbody"));
	List<WebElement> gridtablerows = gridbody.findElements(By.tagName("tr"));
	List<WebElement> gridtablecolumns = gridtablerows.get(1).findElements(By.tagName("td"));
	WebElement fourthcolumn = gridtablecolumns.get(9);
	String cashamount = fourthcolumn.getText();
	Reporter.log("As expected Amount equal to Net Amount is adding in the grid and cash amount displayed as "+cashamount,true);
	WebElement billamount = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath));
	String bill = billamount.getAttribute("value");
	Assert.assertEquals(bill, cashamount);
	Reporter.log("As expected CashAmount is equal to BillAmount",true);
	WebElement grid2 = driver.findElement(By.xpath(Grid_Xpath));
	String theadtxt = grid2.findElement(By.tagName("thead")).getText();
	Reporter.log(theadtxt,true);
	Reporter.log("-------------------------------------------------------------",true);
	WebElement body = grid2.findElement(By.tagName("tbody"));
	List<WebElement> rows = body.findElements(By.tagName("tr"));
	String BillAmountRow = rows.get(1).getText();
	if(BillAmountRow.contains("103.00")){
		WebElement Row = rows.get(1);
		String cshamt = Row.findElement(By.id("amount")).getText();
		String billid = Row.findElement(By.id("billId")).getText();
		Reporter.log("As expected displayed Cash amount as "+cshamt+" for BillID "+billid,true);
		
	}

	Assert.assertTrue(BillAmountRow.contains("103.00"));
	Reporter.log("As expected accepted, Amount Equal to  Net Amount is adding in the grid",true);	

}

public void bs_106_verify_amount_accepting_lessthan_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	Assert.assertTrue(flag1 == true && flag2 != true);
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("50");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(1000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
	WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
	WebElement head = grid.findElement(By.tagName("thead"));
	String headtxt = head.getText();
	Reporter.log(headtxt,true);
	Reporter.log("-----------------------------------------",true);
	WebElement body = grid.findElement(By.tagName("tbody"));
	List<WebElement> rows = body.findElements(By.tagName("tr"));
	for (WebElement eachrow : rows) 
	{
		List<WebElement> Cell = eachrow.findElements(By.tagName("td"));
		for (WebElement eachcell : Cell) 
		{
			String Celldata = eachcell.getText();
			if(Celldata.equals("50.00"))
			{
				String CashAmount = Cell.get(9).getText();
				Reporter.log(CashAmount+" Record Available in Cash Amount as Expected",true);
				String TypeofPayment = Cell.get(8).getText();
				Reporter.log(TypeofPayment+" Record Available in Type of Payment as Expected",true);
				String GuestName = Cell.get(7).getText();
				Reporter.log(GuestName+" Record Available in Guest Name as Expected",true);
				String BillNo = Cell.get(6).getText();
				Reporter.log(BillNo+" Record Available in Bill No as Expected",true);
			}
		
			
		}
		
	}
	
	WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
	Select payment = new Select(paymentmode);
	payment.selectByIndex(4);
	Thread.sleep(2000);
	Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
	WebElement amount1 = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount1.clear();
	amount1.sendKeys("53");
	WebElement addsettlement1 = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement1.click();
	Thread.sleep(1000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
	WebElement grid1 = driver.findElement(By.xpath(Grid_Xpath));
	WebElement head1 = grid1.findElement(By.tagName("thead"));
	String headtxt1 = head1.getText();
	Reporter.log(headtxt1,true);
	Reporter.log("-----------------------------------------",true);
	WebElement body1 = grid1.findElement(By.tagName("tbody"));
	List<WebElement> rows1 = body1.findElements(By.tagName("tr"));
	for (WebElement eachrow1 : rows1) 
	{
		List<WebElement> Cells = eachrow1.findElements(By.tagName("td"));
		for (WebElement eachcell1 : Cells) 
		{
			String Celldata1 = eachcell1.getText();
			if(Celldata1.equals("53.00"))
			{
				String CashAmount1 = Cells.get(9).getText();
				Reporter.log(CashAmount1+" Record Available in Cash Amount as Expected",true);
				String TypeofPayment1 = Cells.get(8).getText();
				Reporter.log(TypeofPayment1+" Record Available in Type of Payment as Expected",true);
				String GuestName1 = Cells.get(7).getText();
				Reporter.log(GuestName1+" Record Available in Guest Name as Expected",true);
				String BillNo1 = Cells.get(6).getText();
				Reporter.log(BillNo1+" Record Available in Bill No as Expected",true);
			}
		
			
		}
		
	}
	  
	String fr_billno = driver.findElement(By.xpath(FirstRow_BillNo_xpath)).getText();
	String Sr_billno = driver.findElement(By.xpath(SecondRow_BillNo_xpath)).getText();
	String fr_guest = driver.findElement(By.xpath(FirstRow_GuestName_xpath)).getText();
	String Sr_guest = driver.findElement(By.xpath(SecondRow_GuestName_xpath)).getText();
	String fr_top = driver.findElement(By.xpath(FirstRow_TypeofPayment_xpath)).getText();
	String Sr_top = driver.findElement(By.xpath(SecondRow_TypeofPayment_xpath)).getText();
	String fr_cashamt = driver.findElement(By.xpath(FirstRow_CashAmount_xpath)).getText();
	String Sr_cashamt = driver.findElement(By.xpath(SecondRow_CashAmount_xpath)).getText();
	int a = Double.valueOf(fr_cashamt).intValue();
	int b = Double.valueOf(Sr_cashamt).intValue();
	int Total_Cashamount = a+b;
	Assert.assertTrue(fr_billno.equals(Sr_billno)&&(fr_guest.equals(Sr_guest))&&(fr_top.equals(Sr_top)));
	Assert.assertEquals(fr_cashamt, "50.00");
	Assert.assertEquals(Sr_cashamt, "53.00");
	Reporter.log("Total Cash Amount at grid :"+Total_Cashamount,true);
	Reporter.log("Bill No, Guest Name and Type of Payment are Displayed both rows as Same in the grid",true);
	Reporter.log("As expected Amount less than Net Amount is adding in the grid",true);	
}

public void bs_107_verify_amount_accepting_morethan_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	Assert.assertTrue(flag1 == true && flag2 != true);
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("200");
	String amountentered = driver.findElement(By.xpath(Amount_Textbox_Xpath)).getAttribute("value");
	Reporter.log(amountentered+" Amount entered at Amount Textbox",true);
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Alert alert = driver.switchTo().alert();
	Thread.sleep(1000);
	String text = alert.getText();
	Reporter.log("As expected displayed" +text+" dispalyed at Pop up",true);
	Reporter.log("As expected  not accepted more than Net Amount",true);
	alert.accept();
	Thread.sleep(1000);
    WebElement table = driver.findElement(By.xpath(Grid_Xpath));
    WebElement tbody = table.findElement(By.tagName("tbody"));
    String tbodytxt = tbody.getText();
    Assert.assertTrue(tbodytxt.isEmpty());
    Reporter.log("As expected Bill Amount Grid is not displayed",true);
	
}

public void bs_115_verify_amount_accepting_alphabets_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("abcd");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Alert alert = driver.switchTo().alert();
	String alertmsg = alert.getText();
	alert.accept();
	Thread.sleep(5000);
	Assert.assertEquals(alertmsg, "Please Enter valid amount ");
	Reporter.log(alertmsg,true);
	Reporter.log("As expected not allowed to enter Alphabets" + alertmsg,true);	
}

public void bs_115_verify_amount_accepting_alphanumerics_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("abc1234");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	if(DriverInitializer.isAlertPresent())
	{
		Reporter.log("Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		Reporter.log(" Should not allow to enter Alphabets",true);
	}
	else
	{
		Reporter.log("As expected Alert not presented and not allowing to enter Alphabets",true);
	}		Thread.sleep(5000);
	Assert.assertFalse(DriverInitializer.isAlertPresent());
}

public void bs_115_verify_amount_accepting_specialcharacters_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("*(@*#");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	if(DriverInitializer.isAlertPresent())
	{
		Reporter.log("Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		Reporter.log(" Should not allow to enter Special Characters",true);
	}
	else
	{
		Reporter.log("As expected Alert not presented and not allowing to enter Special Characters",true);
	}		Thread.sleep(5000);
	Assert.assertFalse(DriverInitializer.isAlertPresent());
}

public void bs_116_verify_amount_leaving_blank_Invalid() throws InterruptedException
{
	
	//WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	Assert.assertTrue(DriverInitializer.isAlertPresent());	
	boolean flag = true;
	if(flag==true) 
	{
		Reporter.log("As Expected Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);

	}
	else
	{
		Reporter.log(" Alert not presented",true);
	}
	Thread.sleep(2000);

}*/




}
