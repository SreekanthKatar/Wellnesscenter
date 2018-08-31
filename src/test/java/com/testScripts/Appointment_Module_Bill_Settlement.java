package com.testScripts;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pageLocators.Appointment_Module_Bill_Settlement_Repository;
import com.pageLocators.Test_Base;

public class Appointment_Module_Bill_Settlement extends Test_Base 

{
	@Test
	public void BS_137() throws InterruptedException
	{
	com.pageLocators.Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, com.pageLocators.Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	WebElement D_Name=bs.Bill_Settlement_Name_on_Debit_Card_Label;
	WebElement D_Number=bs.Bill_Settlement_Debit_Card_Number_Label;
	WebElement D_type=bs.Bill_Settlement_Debit_Card_Type_Label;
	org.testng.Assert.assertTrue(D_Name.isDisplayed() && D_Number.isDisplayed()&& D_type.isDisplayed());
	Reporter.log("After Selecting Debit Card PaymentMode System Displaying "+"  "+D_Name.getText()+" "+D_Number.getText()+" "+D_type.getText()+" "+"Options");
	

	}
	@Test
	public void BS_138() throws InterruptedException
	{
	com.pageLocators.Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="rahul";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	String Exp_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertTrue(Bill_Details.contains(Exp_name));
		Reporter.log(Bill_Details);
	}
		
	Reporter.log("System accepting Alphabets in the 'Name on Debit Card' Textbox");
	}

	@Test
	public void BS_139() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="ab12@#";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	Reporter.log("System Displaying Bill Table with following Details");
	 String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertFalse(Bill_Details.contains(Exp_Guest_name));
		Reporter.log(Bill_Details);
		
	}
	Reporter.log("System is Not Accepting Alphanumerics in the 'Name on Debit Card' Textbox");
	}
	
	@Test
	public void BS_140() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	Assert.assertTrue(bs.Bill_Settlement_Name_on_Debit_Card_valmessage.isDisplayed());
	
	}
	
	@Test
	public void BS_141() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="Ra";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	Reporter.log("System Displaying Bill Table with following Details");
	 String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertTrue(Bill_Details.contains(Exp_Guest_name));
		Reporter.log(Bill_Details);
	}
	Reporter.log("System  Accepting Minium 2 Alphabets in the 'Name on Debit Card' field");
	}
	@Test
	public void BS_142() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	Reporter.log("System Displaying Bill Table with following Details");
	 String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertTrue(Bill_Details.contains(Exp_Guest_name));
		Reporter.log(Bill_Details);
		
	}
		Reporter.log("System  Accepting Minium 50 Alphabets in the 'Name on Debit Card' field");
	}

	@Test
	public void BS_143() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("4585");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	//Assert.assertTrue(bs.Bill_Settlement_Name_on_Debit_Card_valmessage.isDisplayed());
	String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertFalse(Bill_Details.contains(Exp_Guest_name));
		Reporter.log(Bill_Details);
	}
		Reporter.log("System is Not Accepting More than  50 Alphabets in the 'Name on Debit Card' field");
	}
	
	@Test
	public void BS_144() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	String D_name="kishan";
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
	bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys("0000");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	//Assert.assertTrue(bs.Bill_Settlement_Debit_Card_Number_valmessage.isDisplayed());
	String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
	for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
	{
		String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
		Assert.assertFalse(Bill_Details.contains(Exp_Guest_name));
		Reporter.log(Bill_Details);
	}
		Reporter.log("System is Not Accepting '0000' in the 'Debit Card Number' field");
	}
	
	@Test
	public void BS_145() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="a12#";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		String act= bs.Bill_Settlement_Debit_Card_Number_TextBox.getAttribute("value");
		Reporter.log("Value Entered in the Debit Card Number field"+" "+Exp_D_Num);
		Reporter.log("Value Accepted in the Debit Card Number field"+" "+act);
		Assert.assertFalse(Exp_D_Num.equals(act));
		Reporter.log("System is Not Accepting Alphanumeric values in the Debit Card Number field ");
	}
	
	@Test
	public void BS_146() throws InterruptedException
	{
	Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
	bs.Select_Debit_Card_Payment_Mode();
	bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys("kishan");
	bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
	bs.Select_Debit_Card_Type_Master();
	bs.Bill_Settlement_Add_Settlement_Button.click();
	Assert.assertTrue(bs.Bill_Settlement_Debit_Card_Number_valmessage.isDisplayed());

	}
	
	@Test
	public void BS_147() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="9879";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
		bs.Select_Debit_Card_Type_Master();
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertTrue(Bill_Details.contains(Exp_Guest_name));
			Reporter.log(Bill_Details);
		}
			Reporter.log("System is Accepting '9879' in the 'Debit Card Number' field");
	}

	@Test
	public void BS_148() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="98799";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		String act= bs.Bill_Settlement_Debit_Card_Number_TextBox.getAttribute("value");
		Reporter.log("Value Entered in the Debit Card Number field"+" "+Exp_D_Num);
		Reporter.log("Value Accepted in the Debit Card Number field"+" "+act);
		Assert.assertFalse(Exp_D_Num.equals(act));
		Reporter.log("System is Not Accepting more than 4 Digits in the Debit Card Number field ");
	}
	@Test
	public void BS_149() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="99";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
		bs.Select_Debit_Card_Type_Master();
		bs.Bill_Settlement_Add_Settlement_Button.click();
		//valmessage//
		String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertFalse(Bill_Details.contains(Exp_Guest_name));
			Reporter.log(Bill_Details);
		}
			Reporter.log("System is Not Accepting only 2 digits in the  in the 'Debit Card Number' field");
	}
	
	@Test
	public void BS_150() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String Exp_val="Select";
		Select slt= new Select(bs.Bill_Settlement_Debit_Card_Type_Listbox);
		String Act_val= slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("By Default system Displaying "+" "+Act_val+" "+"in the Debit Card Type Listbox ");
		
	}
	@Test
	public void BS_151() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String Exp_val="Master";
		Select slt= new Select(bs.Bill_Settlement_Debit_Card_Type_Listbox);
		slt.selectByVisibleText(Exp_val);
		String Act_val= slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Displaying "+" "+Act_val+" "+"in the Debit Card Type Listbox ");
		
	}
	@Test
	public void BS_152() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="9879";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Assert.assertTrue(bs.Bill_Settlement_Debit_Card_Type_valmessage.isDisplayed());
	}
	
	@Test
	public void BS_153() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="9879";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1000");
		bs.Select_Debit_Card_Type_Master();
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertTrue(Bill_Details.contains(Exp_Guest_name));
			Reporter.log(Bill_Details);
		}
			Reporter.log("System is Accepting the Amount and Displaying in the Table");
			
	}

	@Test
	public void BS_154() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="9879";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("100000");
		bs.Select_Debit_Card_Type_Master();
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert= "Settlement amount not matching with Net Amount";
		String Act_alert= alt.getText();
		Assert.assertTrue(Act_alert.equalsIgnoreCase(Exp_alert));
		Reporter.log("System Displaying Alert As "+" "+Act_alert);
		alt.accept();
	
	}

	@Test
	public void BS_155() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Select_Debit_Card_Payment_Mode();
		String D_name="kishan";
		bs.Bill_Settlement_Name_on_Debit_Card_Textbox.sendKeys(D_name);
		String Exp_D_Num="9879";
		bs.Bill_Settlement_Debit_Card_Number_TextBox.sendKeys(Exp_D_Num);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("100000");
		bs.Select_Debit_Card_Type_Master();
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert= "Settlement amount not matching with Net Amount";
		String Act_alert= alt.getText();
		Assert.assertTrue(Act_alert.equalsIgnoreCase(Exp_alert));
		Reporter.log("System Displaying Alert As "+" "+Act_alert);
		alt.accept();
		
	}

	@Test
	public void BS_156() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		Thread.sleep(2000);
		String Exp_val= "PMS- 2016-02-20 /Room Posting";
		String Act_val=bs.Bill_Settlement_Room_Posting_ModalBox_Mainheading.getText();
		Assert.assertTrue(bs.Bill_Settlement_Room_Posting_Modalbox.isDisplayed());
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("As Expected System Displaying Room Posting Heading as "+" "+Act_val );
		
	}
	
	@Test
	public void BS_157() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		Thread.sleep(2000);
		String Exp_option= "Select Building";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_Building_Name_Label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
		
	}

	
	@Test
	public void BS_158() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		String Exp_option= "LEO BIZ EXECUITIVE";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_Building_Name_Label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
		
			
	}
	
	@Test
	public void BS_159() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		String Exp_option= "LEO BIZ EXECUITIVE";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(Exp_option);
		String Exp_alert="Sorry no Room avilable in this Building !";
		Alert alt= driver.switchTo().alert();
		String Act_alert= alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("As Expected System Displaying Alert "+" "+Act_alert);
		
		
	}
	@Test
	public void BS_160() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		String option= "LEO BIZ EXECUITIVE";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(option);
		String Exp_alert="Sorry no Room avilable in this Building !";
		Alert alt= driver.switchTo().alert();
		String Act_alert= alt.getText();
		alt.accept();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		String Exp_option="Select Building";
		String Act_option= slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		String label= bs.Bill_Settlement_Room_Posting_Building_Name_Label.getText();
		Reporter.log("As Expected System Displaying "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
		
		
	}
	
	@Test
	public void BS_223() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		String Exp_option= "BUSINESS SUITE";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_Building_Name_Label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
		
			
	}

	@Test
	public void BS_161() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		String label= bs.Bill_Settlement_Room_Posting_Room_Number_label.getText();
		WebElement wbt= bs.Bill_Settlement_Room_Posting_Room_Number_Listbox;
		Assert.assertTrue(wbt.isDisplayed());
		Reporter.log("As Expected System Displaying " +" "+label+" "+"Listbox");
	
	}
	@Test
	public void BS_162() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		String Exp_option= "Select Room";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Room_Number_Listbox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_Room_Number_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");

	}
	
	@Test
	public void BS_163() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		String Exp_option= "1003";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Room_Number_Listbox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_Room_Number_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");

	}
	@Test
	public void BS_164() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		WebElement wbt= bs.Bill_Settlement_Room_Posting_Modalbox_Date_Heading;
		WebElement wbt1= bs.Bill_Settlement_Room_Posting_GuestID_Listbox;
		Assert.assertTrue(wbt.isDisplayed() && wbt1.isDisplayed());
		Reporter.log("As Expected System Displaying corresponding details in Room Posting window");

	}
	@Test
	public void BS_165() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		WebElement wbt= bs.Bill_Settlement_Room_Posting_Modalbox_Date_Heading;
		String label= bs.Bill_Settlement_Room_Posting_Modalbox_Date_Heading.getText();
		Assert.assertTrue(wbt.isDisplayed());
		Reporter.log("As Expected System displaying guest Departure date in Room Posting Window"+" "+label);
	
	}
	
	@Test
	public void BS_166() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_option= "Select GuestId";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_GuestID_Listbox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_GuestID_Label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
			
	}
	@Test
	public void BS_167() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_option= "163";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_GuestID_Listbox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_GuestID_Label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
	
	}
	
	@Test
	public void BS_168() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		bs.Bill_Settlement_Amount_Textbox.sendKeys("499");
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		String Exp_valmessage="Please Select GuestId";
		String Act_valmessage=bs.Bill_Settlement_Room_Posting_GuestID_valerrormsg.getText();
		Assert.assertTrue(Exp_valmessage.equals(Act_valmessage));
		Reporter.log("As Expected System Displaying "+" "+Act_valmessage+" "+"valerror");
	
	}

	@Test
	public void BS_169() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_option= "Select GuestName";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_GuestName_Listbox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_GuestName_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
			
	}
	@Test
	public void BS_170() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_option= "MMM DFGFDG TATI";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_GuestName_Listbox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_GuestName_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
			
	}
	
	@Test
	public void BS_171() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_Folio_no();
		bs.Bill_Settlement_Amount_Textbox.sendKeys("499");
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		String Exp_valmessage="Please Select GuestName";
		String Act_valmessage=bs.Bill_Settlement_Room_Posting_GuestName_valerrormsg.getText();
		Assert.assertTrue(Exp_valmessage.equals(Act_valmessage));
		Reporter.log("As Expected System Displaying "+" "+Act_valmessage+" "+"valerror");
	
	}
	@Test
	public void BS_172() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_option= "Select Filio No";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_FolioNo_Listbox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Room_Posting_FolioNo_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
	
	}
	@Test
	public void BS_173() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		Thread.sleep(2000);
		String Exp_option= "folio229";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_FolioNo_Listbox);
		slt.selectByValue(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		System.out.println(Act_option);
		String label= bs.Bill_Settlement_Room_Posting_FolioNo_label.getText();
		Assert.assertTrue(Act_option.contains(Exp_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
	
		
	}
	
	@Test
	public void BS_174() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Bill_Settlement_Amount_Textbox.sendKeys("499");
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		String Exp_valmessage="Please Select Filio No";
		String Act_valmessage=bs.Bill_Settlement_Room_Posting_FolioNo_valerrormsg.getText();
		Assert.assertTrue(Exp_valmessage.equals(Act_valmessage));
		Reporter.log("As Expected System Displaying "+" "+Act_valmessage+" "+"valerror");
	
	}


	@Test
	public void BS_175() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		String Exp_val="4000";
		bs.Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);;
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		Thread.sleep(2000);
		String Act_val=bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting Numerical values in the Room Post Amount filed ");

	}

	@Test
	public void BS_176() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		String Exp_val="ab1200#";
		bs.Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);
		String Act_val=bs.Bill_Settlement_Room_Posting_Amount.getAttribute("value");
		Reporter.log("Value Entered in the Room Post Amount field is "+" "+Exp_val);
		Reporter.log("Value Accepted in the Room Post Amount field is "+" "+Act_val);
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		Reporter.log("System is Not Accepting Alphanumerics with Special Characters in the Room Post Amount field ");
	}
	@Test
	public void BS_177() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		String Exp_valmessage="Room Post Amount is required";
		String Act_valmessage=bs.Bill_Settlement_Room_Posting_Amount_valerrormsg.getText();
		Assert.assertTrue(Exp_valmessage.equals(Act_valmessage));
		Reporter.log("As Expected System Displaying "+" "+Act_valmessage+" "+"valerror");
		
	}
	@Test
	public void BS_178() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		String Exp_val="4000";
		bs.Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);;
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		Thread.sleep(2000);
		String Act_val=bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("AS Expected System Displaying Room Post Amount In the Amount Text box for Bill Settlement");
		}

	@Test
	public void BS_179() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		String Exp_val=bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Thread.sleep(2000);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Reporter.log("System Displaying Bill Settlement Table with following Details");
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++) 
		{
			Reporter.log(bs.Bill_Settlement_Payment_Table_Rows.get(i).getText());
		}
		String row1= bs.Bill_Settlement_Payment_Table_Rows.get(1).getText();
		Assert.assertTrue(row1.contains(Exp_val));
		Reporter.log("As Expected System Displaying Amount in the Bill Settlement Table for Settlement");
	
	}
	@Test
	public void BS_180() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		String Exp_val="400000000";
		bs.Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);;
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		Thread.sleep(2000);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Alert alt= driver.switchTo().alert();
		String Exp_alert="Settlement amount not matching with Net Amount";
		String Act_alert= alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
	
	}
	
	@Test
	public void BS_181() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		String Exp_option="LAGOON BAY";
		Select slt= new Select(bs.Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=	slt.getFirstSelectedOption().getText();
		Assert.assertFalse(Exp_option.equals(Act_option));
		Reporter.log("System Displaying Alert as ****Please Select Same Building****");
		
	}
	
	@Test
	public void BS_182() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_val = bs.Bill_Settlement_Room_Posting_Department_Field.getAttribute("readonly");
		String label= bs.Bill_Settlement_Room_Posting_Department_label.getText();
		Assert.assertTrue(Exp_val.equals("true"));
		Reporter.log("As Expected System Displaying "+" "+label+" "+"in readonly mode ");
			
	}
	@Test
	public void BS_183() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_val = bs.Bill_Settlement_Room_Posting_Service_Field.getAttribute("readonly");
		String label= bs.Bill_Settlement_Room_Posting_Service_label.getText();
		Assert.assertTrue(Exp_val.equals("true"));
		Reporter.log("As Expected System Displaying "+" "+label+" "+"in readonly mode ");
			
	}
	@Test
	public void BS_184() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		String Exp_val = bs.Bill_Settlement_Room_Posting_incomehead_field.getAttribute("readonly");
		String label= bs.Bill_Settlement_Room_Posting_Incomehead_label.getText();
		Assert.assertTrue(Exp_val.equals("true"));
		Reporter.log("As Expected System Displaying "+" "+label+" "+"in readonly mode ");
		
		
	}
	@Test
	public void BS_185() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		Thread.sleep(2000);
		bs.Bill_Settlement_Room_Posting_Close_button.click();
		Assert.assertTrue(bs.Bill_Settlement_Room_Posting_ModalBox_Mainheading.isDisplayed());
		Reporter.log("As Expected System Redirecting to Bill Settlement Page");
		
	}

	@Test
	public void BS_186() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		String Exp_val = bs.Bill_Settlement_Room_Posting_incomehead_field.getAttribute("readonly");
		Assert.assertFalse(Exp_val.equals("true"));
		Reporter.log("As Expected System Accepting remarks field with Alphanumeric Values");
		
	}

	@Test
	public void BS_187() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		String Exp_heading="Discounts";
		String Act_heading=bs.Bill_Settlement_Discounts_heading_in_Modal_message.getText();
		Assert.assertTrue(Exp_heading.equals(Act_heading));
		Reporter.log("As Expected System Displaying Discounts ModalBox Heading as "+" "+Act_heading);
		
	}

	@Test
	public void BS_188() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		Select slt= new Select(bs.Bill_Settlement_Discount_Type_ListBox);
		String Exp_option= "Select";
		String Act_option=slt.getFirstSelectedOption().getText();
		String label=bs.Bill_Settlement_Discount_Type_Label.getText();
		Assert.assertEquals(Act_option, Exp_option);
		Reporter.log("By Default System Selecting the "+Act_option+" "+"in the"+" "+label+" "+"listBox " , true);
		
	}
	
	@Test
	public void BS_189() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		Select slt= new Select(bs.Bill_Settlement_Discount_Type_ListBox);
		String Exp_option= "Amount";
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label=bs.Bill_Settlement_Discount_Type_Label.getText();
		Assert.assertEquals(Act_option, Exp_option);
		Reporter.log("System Selecting the "+Act_option+" "+"in the"+" "+label+" "+"listBox " , true);

	}
	
	@Test
	public void BS_190() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(bs.Bill_Settlement_Mainheading.isDisplayed());
		Reporter.log("As Expected system Displaying Alert Message as");
	
	}
	
	@Test
	public void BS_191() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String label= bs.Bill_Settlement_Discount_By_Amount_Label.getText();
		Assert.assertTrue(bs.Bill_Settlement_Discount_By_Amount_Label.isDisplayed());
		Reporter.log("As Expected system Displaying "+" "+label);
	
	}

	@Test
	public void BS_192() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Exp_val="5.00";
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
	}
	@Test
	public void BS_193() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Exp_val="111111111111111";
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
		
		
	}
	@Test
	public void BS_194() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Exp_val="1111111111111111";
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("System is Not Accepting the Discount Amount and Not Displaying at"+" "+label+" "+"of Bill Settlement page ");

		
		
	}
	@Test
	public void BS_195() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Disc_Amount="12.66";
		String Exp_val=Disc_Amount.substring(0, 2);
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Disc_Amount);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		String Act_val=act_val.substring(0, 2);
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");


	}
	@Test
	public void BS_196() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Disc_Amount="99.99";
		String Exp_val=Disc_Amount.substring(0, 2);
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Disc_Amount);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		String Act_val=act_val.substring(0, 2);
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");

		
		
	}
	@Test
	public void BS_197() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Exp_val="5.000000";
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Exp_val);
		String Act_val=bs.Bill_Settlement_Discount_By_Amount_TextBox.getAttribute("value");
		Reporter.log("Value Entered in the Discount By Amount field"+" "+Exp_val);
		Reporter.log("Value Accepted in the Discount By Amount field"+" "+Act_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("System is Not Accepting More than 2 Digits in the Decimal point");
		
		
		
	}
	@Test
	public void BS_198() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Disc_Amount="400.50";
		String Exp_val=Disc_Amount.substring(0, 3);
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Disc_Amount);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		String Act_val=act_val.substring(0, 3);
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
		
		
	}
	@Test
	public void BS_199() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		String Exp_val="ab992$";
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys(Exp_val);
		String Act_val=bs.Bill_Settlement_Discount_By_Amount_TextBox.getAttribute("value");
		Reporter.log("Value Entered in the Discount By Amount field"+" "+Exp_val);
		Reporter.log("Value Accepted in the Discount By Amount field"+" "+Act_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("System is Not Accepting Alphanumeric with Special Characters");
		
		
		
	}
	@Test
	public void BS_200() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String Exp_val="5";
		bs.Bill_Settlement_Discount_By_Percent_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Float E_val=Float.valueOf(Act_val);
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Float bill_val= Float.valueOf(bill_Amount);
		int Exp_D_val = (int)(bill_val*(5.0f/100.0f));
		Float val= Float.valueOf(Exp_D_val);
		System.out.println(val);
		System.out.println(E_val);
		Assert.assertEquals(val, E_val);
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
	}
	@Test
	public void BS_201() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String Exp_val="100";
		bs.Bill_Settlement_Discount_By_Percent_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Float A_val=Float.valueOf(Act_val);
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Float bill_val= Float.valueOf(bill_Amount);
		int Exp_D_val = (int)(bill_val*(100.0f/100.0f));
		Float E_val= Float.valueOf(Exp_D_val);
		Assert.assertEquals(E_val, A_val);
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
	}
	@Test
	public void BS_202() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String Exp_val="102";
		bs.Bill_Settlement_Discount_By_Percent_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Float A_val=Float.valueOf(Act_val);
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Float bill_val= Float.valueOf(bill_Amount);
		int Exp_D_val = (int)(bill_val*(102.0f/100.0f));
		Float E_val= Float.valueOf(Exp_D_val);
		Assert.assertNotSame(E_val, A_val);
		Reporter.log("System is Not Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
	}
	@Test
	public void BS_203() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String Exp_val="99";
		bs.Bill_Settlement_Discount_By_Percent_TextBox.sendKeys(Exp_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String label=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String Act_val= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Float A_val=Float.valueOf(Act_val);
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Float bill_val= Float.valueOf(bill_Amount);
		int Exp_D_val = (int)(bill_val*(99.0f/100.0f));
		Float E_val= Float.valueOf(Exp_D_val);
		Assert.assertEquals(E_val, A_val);
		Reporter.log("System Accepting the Discount Amount and Displaying at"+" "+label+" "+"of Bill Settlement page ");
		
	}
	@Test
	public void BS_204() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String Exp_val="6a@2";
		Reporter.log("Value Entered in the Discount by Percent Field is"+" "+Exp_val);
		bs.Bill_Settlement_Discount_By_Percent_TextBox.sendKeys(Exp_val);
		String Act_val= bs.Bill_Settlement_Discount_By_Percent_TextBox.getAttribute("value");
		Reporter.log("Value Accepeted in the Discount by Percent Field is"+" "+Act_val);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("As Expected System is Not Accepting Alphanumeric Values");
		
	}
	
	@Test
	public void BS_205() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		String Exp_option= "Select";
		Select slt= new Select(bs.Bill_Settlement_Discount_Reason_ListBox);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Discount_Reason_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("By Default System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
		

	}
	@Test
	public void BS_206() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		String Exp_option= "vip";
		Select slt= new Select(bs.Bill_Settlement_Discount_Reason_ListBox);
		slt.selectByVisibleText(Exp_option);
		String Act_option=slt.getFirstSelectedOption().getText();
		String label= bs.Bill_Settlement_Discount_Reason_label.getText();
		Assert.assertTrue(Exp_option.equals(Act_option));
		Reporter.log("As Expected System Selecting "+" "+Act_option+" "+"in the"+" "+label+" "+"Listbox");
	

	}
	@Test
	public void BS_207() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Adding_Discount_Details();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		String discount_Amount= bs.Bill_Settlement_Discount_Amount_field_at_Billsettlementpage.getAttribute("value");
		Float Bill_Amount= Float.valueOf(bill_Amount);
		Float Net_Amount= Float.valueOf(net_Amount);
		Float Discount_Amount= Float.valueOf(discount_Amount);
		Float Exp_val= Bill_Amount-Discount_Amount;
		Float Act_val=Net_Amount;
		String label=bs.Bill_Settlement_Bill_Amount_Label.getText();
		String label2=bs.Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage.getText();
		String label3=bs.Bill_Settlement_Net_Amount_Label.getText();
		Reporter.log(label+" "+Bill_Amount);
		Reporter.log(label2+" "+Discount_Amount);
		Reporter.log(label3+" "+Net_Amount);
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("As Expected Discount amount is Deducted from the Bill Amount and Displaying as Amount");
		Reporter.log("As Expected System Adding Discount to Bill Amount");
	
	}
	
	@Test
	public void BS_208() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys("500000");
		String Disc_A= bs.Bill_Settlement_Discount_By_Amount_TextBox.getAttribute("value");
		Reporter.log("Discount By Amount Given"+" "+Disc_A);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Alert alt= driver.switchTo().alert();
		String Act_alert= alt.getText();
		Thread.sleep(2000);
		alt.accept();
		String Exp_alert= "You are Entering More amount than Bill Amount";
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("As Expected System Displaying Alert as "+" "+Act_alert);
		
	}
	@Test
	public void BS_209() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		bs.Bill_Settlement_Discount_By_Amount_TextBox.sendKeys("500000");
		String Disc_A= bs.Bill_Settlement_Discount_By_Amount_TextBox.getAttribute("value");
		Reporter.log("Discount By Amount Given"+" "+Disc_A);
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Alert alt= driver.switchTo().alert();
		String Act_alert= alt.getText();
		Thread.sleep(2000);
		alt.accept();
		Thread.sleep(2000);
		String Exp_alert= "You are Entering More amount than Bill Amount";
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("As Expected System Displaying Alert as "+" "+Act_alert);
		Assert.assertTrue(bs.Bill_Settlement_Discounts_heading_in_Modal_message.isDisplayed());
		Reporter.log("As Expected After Accepting Alert System Redirecting to Discounts Page");
		
	}
	@Test
	public void BS_210() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Adding_Discount_Details();
		bs.Bill_Settlement_Discount_Cancel_Button.click();
		Assert.assertTrue(bs.Bill_Settlement_Mainheading.isDisplayed());
		Reporter.log("After Cancelling the Discount System Redirecting to Bill Settlement Page");
		
	}
	@Test
	public void BS_211() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Adding_Discount_Details();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Thread.sleep(2000);
		Assert.assertFalse(bs.Bill_Settlement_Discount_Button.isEnabled());
		Reporter.log("After Adding Discount System Displaying Discount Button in Disabled Mode");
		
	}

	@Test
	public void BS_212() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Adding_Discount_Details();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Thread.sleep(2000);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String Exp_Guest_name = bs.Bill_Settlement_Guest_Name_Textbox.getAttribute("value");
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertTrue(Bill_Details.contains(Exp_Guest_name));
			Reporter.log(Bill_Details);
		}
			Reporter.log("System is Accepting the Amount and Displaying in the Table");
		
	}
	
	@Test
	public void BS_213() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String r_val= bs.Bill_Settlement_Paid_Amount_TextBox.getAttribute("readonly");
		String label= bs.Bill_Settlement_Paid_Amount_Label.getText();
		Assert.assertTrue(r_val.equals("true"));
		Reporter.log("As Expected System Displaying"+" "+label+" "+"field in Readonly mode");
		

	}
	@Test
	public void BS_214() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Select_Building_Name();
		bs.Select_Room_Number();
		bs.Select_GuestID();
		bs.Select_GuestName();
		bs.Select_Folio_no();
		String Exp_val="999";
		Float Exp_paid_Amount = Float.valueOf(Exp_val);
		bs.Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);
		Reporter.log("Value Entered in Room Posting Amount field is"+" "+Exp_paid_Amount);
		bs.Bill_Settlement_Room_Posting_Add_Button_.click();
		Thread.sleep(1000);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String act_paid_Amount= bs.Bill_Settlement_Paid_Amount_TextBox.getAttribute("value");
		Float Act_paid_Amount = Float.valueOf(act_paid_Amount);
		Reporter.log("Value Displaying in the Paid Amount field is"+" "+Act_paid_Amount);
		String label= bs.Bill_Settlement_Paid_Amount_Label.getText();
		String r_val= bs.Bill_Settlement_Paid_Amount_TextBox.getAttribute("readonly");
		Assert.assertTrue(Exp_paid_Amount.equals(Act_paid_Amount) && r_val.equals("true"));
		Reporter.log("As Expected System Displaying"+" "+label+" "+"field in Readonly mode");
		

	}

	@Test
	public void BS_215() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Float Bill_Amount= Float.valueOf(bill_Amount);
		Float Net_Amount= Float.valueOf(net_Amount);
		String label=bs.Bill_Settlement_Bill_Amount_Label.getText();
		String label3=bs.Bill_Settlement_Net_Amount_Label.getText();
		Reporter.log(label+" "+Bill_Amount);
		Reporter.log(label3+" "+Net_Amount);
		Assert.assertTrue(Bill_Amount.equals(Net_Amount));
		Reporter.log("Bill Amount value equal to Net Amount value");
		
	}

	@Test
	public void BS_216() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		Thread.sleep(2000);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Double Act_Net_Amount= Double.valueOf(net_Amount);
		Double Exp_Net_Amount= 0.0;
		Reporter.log("Value Entered in Amount Field"+" "+Bill_Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Assert.assertTrue(Exp_Net_Amount.equals(Act_Net_Amount));
		Reporter.log("Once Bill Amount Paid Net Amount Becomes Zero");
		
	}
	
	@Test
	public void BS_217() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Payment_by_Cash();
		String Amount="75";
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Float Act_Net_Amount= Float.valueOf(net_Amount);
		Reporter.log("Value Entered in Amount Field"+" "+Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Thread.sleep(2000);
		Assert.assertFalse(bs.Bill_Settlement_Save_Button.isEnabled());
		Reporter.log("As Expected Save Button is in Disable Mode");
		
		
	}
	
	@Test
	public void BS_218() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Double Act_Net_Amount= Double.valueOf(net_Amount);
		Double Exp_Net_Amount= 0.0;
		Reporter.log("Value Entered in Amount Field"+" "+Bill_Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Thread.sleep(2000);
		Assert.assertTrue(Exp_Net_Amount.equals(Act_Net_Amount) && bs.Bill_Settlement_Save_Button.isEnabled());
		Reporter.log("As Expected Save Button is in Enable Mode");
		
	}

	@Test
	public void BS_219() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Float Act_Net_Amount= Float.valueOf(net_Amount);
		Reporter.log("Value Entered in Amount Field"+" "+Bill_Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Thread.sleep(1000);
		Assert.assertTrue(bs.Bill_Settlement_Save_Button.isEnabled());
		bs.Bill_Settlement_Save_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert= "Successfully Bill Paid!";
		String Act_alert=alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		alt.accept();
		Thread.sleep(1000);
		Set<String>hndls= driver.getWindowHandles();
		Iterator<String>it= hndls.iterator();
		String Parntwnd= it.next();
		String childwnd= it.next();
		driver.switchTo().window(childwnd);
		driver.close();
		driver.switchTo().window(Parntwnd);
		Reporter.log("As Expected System Displaying Alert As "+" "+Act_alert);
		
	}
	@Test
	public void BS_220() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Float Act_Net_Amount= Float.valueOf(net_Amount);
		Reporter.log("Value Entered in Amount Field"+" "+Bill_Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Thread.sleep(1000);
		Assert.assertTrue(bs.Bill_Settlement_Save_Button.isEnabled());
		bs.Bill_Settlement_Save_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert= "Successfully Bill Paid!";
		String Act_alert=alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		alt.accept();
		Thread.sleep(1000);
		Set<String>hndls= driver.getWindowHandles();
		Iterator<String>it= hndls.iterator();
		String Parntwnd= it.next();
		String childwnd= it.next();
		driver.switchTo().window(childwnd);
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("generatepdfreceipttttt"));
		Reporter.log("As Expected System Displaying Alert As "+" "+Act_alert);
		Reporter.log("System Generating the Bill in pdf Format");
		driver.close();
		driver.switchTo().window(Parntwnd);
		
	}
	
	@Test
	public void BS_221() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_List_Page();
		Thread.sleep(2000);
		String Exp_App_ID=bs.Appointment_Id_hyperlink.getText();
		bs.Appointment_Id_hyperlink.click();
		Reporter.log("Appointment ID is"+" "+Exp_App_ID);
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String net_Amount=bs.Bill_Settlement_Net_Amount_TextBox.getAttribute("value");
		Float Act_Net_Amount= Float.valueOf(net_Amount);
		Reporter.log("Value Entered in Amount Field"+" "+Bill_Amount);
		Reporter.log("Net Amount Displaying is"+" "+Act_Net_Amount);
		Thread.sleep(1000);
		Assert.assertTrue(bs.Bill_Settlement_Save_Button.isEnabled());
		bs.Bill_Settlement_Save_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert= "Successfully Bill Paid!";
		String Act_alert=alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		alt.accept();
		Set<String>hndls= driver.getWindowHandles();
		Iterator<String>it= hndls.iterator();
		String Parntwnd= it.next();
		String childwnd= it.next();
		driver.switchTo().window(childwnd);
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("generatepdfreceipt"));
		Reporter.log("As Expected System Displaying Alert As "+" "+Act_alert);
		Reporter.log("System Generating the Bill in pdf Format");
		driver.close();
		driver.switchTo().window(Parntwnd);
		String Act_App_ID=bs.Appointment_Id_hyperlink.getText();
		Reporter.log("Appointment ID Displaying After Bill Settlement is"+" "+Act_App_ID);
		Assert.assertFalse(Exp_App_ID.equals(Act_App_ID));
		Reporter.log("After Bill Settlement the Appointment ID is not Displaying in the Bill SettlementList");
		
	}
	
	@Test
	public void BS_222() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String bill_Amount= bs.Bill_Settlement_Bill_Amount_value.getAttribute("value");
		Reporter.log("Bill Amount To Pay"+" "+bill_Amount);
		String Bill_Amount=bill_Amount.substring(0, 4);
		bs.Select_Payment_by_Cash();
		bs.Bill_Settlement_Amount_Textbox.sendKeys(Bill_Amount);
		bs.Bill_Settlement_Clear_Button.click();
		Select slt= new Select(bs.Bill_Settlement_Payment_Mode_Listbox);
		String Exp_val= "Select";
		String Act_val=slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Clearing the Data Entered In the Corresponding fields");
	
		
	}
	@Test
	public void BS_236() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(bs.Bill_Settlement_Mainheading.isDisplayed());
		//valmessage
		Reporter.log("As Expected system Displaying Alert Message as");
	
	}
	@Test
	public void BS_237() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_amount();
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(bs.Bill_Settlement_Mainheading.isDisplayed());
		//valmessage
		Reporter.log("As Expected system Displaying Alert Message as");
		
	}
	
	@Test
	public void BS_238() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		bs.Select_Discount_Reason();
		bs.Bill_Settlement_Discount_Submit_Button.click();
		Assert.assertFalse(bs.Bill_Settlement_Mainheading.isDisplayed());
		//valmessage
		Reporter.log("As Expected system Displaying Alert Message as");
	}
	
	@Test
	public void BS_239() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Room_Posting_Payment_Mode();
		bs.Add_Room_Posting();
		bs.Add_Discount_Button();
		bs.Select_Discount_Type_percent();
		String label= bs.Bill_Settlement_Discount_By_Percent_Label.getText();
		Assert.assertTrue(bs.Bill_Settlement_Discount_By_Percent_Label.isDisplayed());
		Reporter.log("As Expected system Displaying "+" "+label);
		
	}
	@Test
	public void BS_117() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String Exp_val="Gift Voucher";
		Select slt= new Select(bs.Bill_Settlement_Payment_Mode_Listbox);
		slt.selectByVisibleText(Exp_val);
		String Act_val= slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Displaying "+" "+Act_val+" "+"in the Payment Type Listbox ");
		
	}

	@Test
	public void BS_118() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Exp_Gift_amount_value= "789";
		String Act_Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Act_Gift_amount_value);
		Assert.assertTrue(Exp_Gift_amount_value.equals(Act_Gift_amount_value));
	}
	@Test
	public void BS_119() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("27899");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Exp_Gift_amount_value= "0";
		String Act_Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Act_Gift_amount_value);
		Assert.assertTrue(Exp_Gift_amount_value.equals(Act_Gift_amount_value));
	}
	@Test
	public void BS_121() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		String Exp_val="ab@12#";
		Reporter.log("Value Entered In Gift Voucher Id Field is"+" "+Exp_val);
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys(Exp_val);
		String Act_val= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		Reporter.log("Value Accepted In Gift Voucher Id Field is"+" "+Act_val);
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("System is Not Accepting Specialcharacters and Alphabets in the voucher ID field");
	}

	@Test
	public void BS_122() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Amount_Textbox.sendKeys("200");
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Alert alt= driver.switchTo().alert();
		String Exp_alert="Please Enter Gift Voucher ID ";
		String Act_alert= alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
		
	}

	@Test
	public void BS_123() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Gift_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("200");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Double Amount= Double.valueOf(amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String paid_Amount= bs.Bill_Settlement_Paid_Amount_TextBox.getAttribute("value");
		Double Paid_Amount= Double.valueOf(paid_Amount);
		System.out.println(Paid_Amount);
		Assert.assertTrue(Paid_Amount.equals(Amount));
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertTrue(Bill_Details.contains("Gift Voucher"));
			Reporter.log(Bill_Details);
		}	
	}

	@Test
	public void BS_124() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Gift_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("999");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Vale Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert="Your Gift Voucher Amount is";
		String Act_alert=alt.getText();
		Assert.assertTrue(Act_alert.contains(Exp_alert));
		alt.dismiss();
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
		
	}
	@Test
	public void BS_125() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Gift_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("999");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Vale Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		Alert alt2=driver.switchTo().alert();
		System.out.println(alt2.getText());
		String Exp_alert="your are entering more amount than your Gift Vocher amount";
		String Act_alert=alt2.getText();
		Assert.assertTrue(Act_alert.contains(Exp_alert));
		alt.dismiss();
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
	
	}
	@Test
	public void BS_126() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String Gift_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("Gift Voucher Amount Displaying"+" "+Gift_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("999");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Vale Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		alt.accept();
		Assert.assertTrue(bs.Bill_Settlement_Mainheading.isDisplayed());
		Reporter.log("After Accepting the alert's System redirecting to Bill Settlements page");
		
	}
	@Test
	public void BS_127() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		String Exp_val="Marketing Voucher";
		Select slt= new Select(bs.Bill_Settlement_Payment_Mode_Listbox);
		slt.selectByVisibleText(Exp_val);
		String Act_val= slt.getFirstSelectedOption().getText();
		Assert.assertTrue(Exp_val.equals(Act_val));
		Reporter.log("System Displaying "+" "+Act_val+" "+"in the Payment Type Listbox ");
		
	}
	
	@Test
	public void BS_128() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Exp_M_Voucher_Amount="129";
		String Exp_M_Company="Rk india";
		String Act_M_Voucher_Amount=bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("value");
		String Act_M_Company=bs.Bill_Settlement_Marketing_Company_Textbox.getAttribute("value");
		Assert.assertTrue(Exp_M_Voucher_Amount.equals(Act_M_Voucher_Amount) && Exp_M_Company.equals(Act_M_Company));
		Reporter.log("As Expected System displaying Voucher Amount and  Marketing Company name in respective fields ");
		
	}
	@Test
	public void BS_129() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("27899");
		String Market_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Market_ID_value);
		String Exp_Marketing_V_amount_value= "0";
		String Act_Marketing_V_amount_value= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("value");
		Reporter.log("MArketing Voucher Amount Displaying"+" "+Act_Marketing_V_amount_value);
		Assert.assertTrue(Exp_Marketing_V_amount_value.equals(Act_Marketing_V_amount_value));
	}
	@Test
	public void BS_120() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Gift_Voucher();
		bs.Bill_Settlement_Gift_Voucher_ID.sendKeys("29");
		String Gift_ID_value= bs.Bill_Settlement_Gift_Voucher_ID.getAttribute("value");
		bs.Bill_Settlement_Gift_Voucher_Amount_Label.click();
		Reporter.log("Gift Voucher ID Entered"+" "+Gift_ID_value);
		String read_only= bs.Bill_Settlement_Gift_Voucher_Amount.getAttribute("readonly");
		String label= bs.Bill_Settlement_Gift_Voucher_Amount_Label.getText();
		Assert.assertTrue(read_only.equals("true"));
		Reporter.log("System Displaying "+" "+label+" "+" Textbox in readonly Mode");
		
	}
	@Test
	public void BS_130() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Market_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Market_ID_value);
		String read_only= bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("readonly");
		String Read_only= bs.Bill_Settlement_Marketing_Company_Textbox.getAttribute("readonly");
		String label= bs.Bill_Settlement_Marketing_Voucher_Amount_Label.getText();
		String label2= bs.Bill_Settlement_Marketing_Company_Label.getText();
		Assert.assertTrue(read_only.equals("true") && Read_only.equals("true"));
		Reporter.log("System Displaying "+" "+label+" "+" Textbox in readonly Mode");
		Reporter.log("System Displaying "+" "+label2+" "+" Textbox in readonly Mode");
		
	}
	@Test
	public void BS_131() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		String Exp_val= "ab@31";
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys(Exp_val);
		Reporter.log("Value Entered in the Marketing Voucher ID field is"+" "+Exp_val);
		String Act_val=bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		Reporter.log("Value Accepted in the Marketing Voucher ID field is"+" "+Act_val);
		Assert.assertFalse(Exp_val.equals(Act_val));
		Reporter.log("System is Not Accepting Specialcharacters and Alphabets in the voucher ID field");
	}

	@Test
	public void BS_132() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Amount_Textbox.sendKeys("200");
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Alert alt= driver.switchTo().alert();
		String Exp_alert="Please Enter Marketing Voucher ID ";
		String Act_alert= alt.getText();
		Assert.assertTrue(Exp_alert.equals(Act_alert));
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
		
	}

	@Test
	public void BS_133() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Marketing_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Marketing_ID_value);
		String Marketing_amount_value= bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("value");
		Reporter.log("Marketing Voucher Amount Displaying"+" "+Marketing_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("110");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Double Amount= Double.valueOf(amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		String paid_Amount= bs.Bill_Settlement_Paid_Amount_TextBox.getAttribute("value");
		Double Paid_Amount= Double.valueOf(paid_Amount);
		Assert.assertTrue(Paid_Amount.equals(Amount));
		for (int i = 1; i < bs.Bill_Settlement_Payment_Table_Rows.size(); i++)
		{
			String Bill_Details=bs.Bill_Settlement_Payment_Table_Rows.get(i).getText();
			Assert.assertTrue(Bill_Details.contains("Marketing Voucher"));
			Reporter.log(Bill_Details);
		}	
	}

	@Test
	public void BS_134() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Marketing_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Marketing_ID_value);
		String Marketing_amount_value= bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("value");
		Reporter.log("Marketing Voucher Amount Displaying"+" "+Marketing_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1100");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Value Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String Exp_alert="Your Marketing Voucher Amount is";
		String Act_alert=alt.getText();
		System.out.println(Act_alert);
		Assert.assertTrue(Act_alert.contains(Exp_alert));
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
		
	}
	@Test
	public void BS_135() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Marketing_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Marketing_ID_value);
		String Marketing_amount_value= bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("value");
		Reporter.log("Marketing Voucher Amount Displaying"+" "+Marketing_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1100");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Value Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		Alert alt2= driver.switchTo().alert();
		Thread.sleep(2000);
		String Exp_alert="your are entering more amount than your Voucher amount ";
		String Act_alert=alt2.getText();
		System.out.println(Act_alert);
		Assert.assertTrue(Exp_alert.equalsIgnoreCase(Act_alert));
		Reporter.log("Alert is Present");
		Reporter.log("As Expected System displaying Alert as"+" "+Act_alert);
		
	}
	@Test
	public void BS_136() throws InterruptedException
	{
		Appointment_Module_Bill_Settlement_Repository  bs= PageFactory.initElements(driver, Appointment_Module_Bill_Settlement_Repository .class);
		bs.Opening_Bill_Settlement_Page();
		bs.Opening_Bill_Settlement_Page();
		bs.Select_Marketing_Voucher();
		bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.sendKeys("15");
		String Marketing_ID_value= bs.Bill_Settlement_Marketing_Voucher_ID_Textbox.getAttribute("value");
		bs.Bill_Settlement_Marketing_Voucher_Amount_Label.click();
		Reporter.log("Marketing Voucher ID Entered"+" "+Marketing_ID_value);
		String Marketing_amount_value= bs.Bill_Settlement_Marketing_Voucher_Amount_Textbox.getAttribute("value");
		Reporter.log("Marketing Voucher Amount Displaying"+" "+Marketing_amount_value);
		bs.Bill_Settlement_Amount_Textbox.sendKeys("1100");
		String amount= bs.Bill_Settlement_Amount_Textbox.getAttribute("value");
		Reporter.log("Value Entered in Amount Field is "+" "+amount);
		bs.Bill_Settlement_Add_Settlement_Button.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		alt.accept();
		Assert.assertTrue(bs.Bill_Settlement_Mainheading.isDisplayed());
		Reporter.log("After Accepting the alert's System redirecting to Bill Settlements page");
			
	}


























































































































}
