package com.pageLocators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Appointment_Module_Bill_Settlement_Repository 
{
	
	@FindBy(xpath="//*[@id='wrapper']/nav/div[2]/ul/li[1]/a")
	public  WebElement Appointment_tab;
	
	@FindBy(xpath="	//*[@id='appointment']/li[6]/a")
	public  WebElement Bill_Settlements_tab;
	
	
	/*********** Billing Settlement page ***********/

	@FindBy(xpath="//*[@id='trow']/td[1]/a")
	public  WebElement Appointment_Id_hyperlink;
	
	@FindBy(xpath="//*[@id='wrapper']/div/div[1]/div/h1/small")
	public  WebElement Bill_Settlement_Mainheading;

	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[1]/td[1]/label")
	public  WebElement Bill_Settlement_Bill_ID_Label;
	
	@FindBy(xpath="//*[@id='billid']")
	public  WebElement Bill_Settlement_Bill_ID_Textbox;
	
	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[1]/td[3]/label")
	public  WebElement Bill_Settlement_Bill_Amount_Label;
	
	@FindBy(xpath="//*[@id='amountCharged']")
	public  WebElement Bill_Settlement_Bill_Amount_Textbox;
	
	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[1]/td[5]/label")
	public  WebElement Bill_Settlement_Guest_Name_Label;
	
	@FindBy(xpath="//*[@id='guestname']")
	public  WebElement Bill_Settlement_Guest_Name_Textbox;
	
	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[3]/td[1]/label")
	public  WebElement Bill_Settlement_Tip_Amount_Label;
	
	@FindBy(xpath="//*[@id='tipamount']")
	public  WebElement Bill_Settlement_Tip_Amount_Textbox;
	
	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[3]/td[3]/label")
	public  WebElement Bill_Settlement_Payment_Mode_label;
	
	@FindBy(css="#paymentmodetype")
	public  WebElement Bill_Settlement_Payment_Mode_Listbox;
	
	@FindBy(xpath="	//*[@id='biisettlement']/table/tbody/tr[3]/td[5]/label")
	public  WebElement Bill_Settlement_Amount_Label;
	
	@FindBy(xpath="//*[@id='amount']")
	public  WebElement Bill_Settlement_Amount_Textbox;
	
	@FindBy(xpath="//*[@id='remarks']")
	public  WebElement Bill_Settlement_Remarks_Textbox;

	@FindBy(xpath="//*[@id='add']")
	public  WebElement Bill_Settlement_Add_Settlement_Button;
	
	@FindBy(xpath="//*[@id='biisettlement']/table/tbody/tr[11]/td[4]/div/input")
	public  WebElement Bill_Settlement_Clear_Button;
	
	@FindBy(xpath="//*[@id='addtip']")
	public  WebElement Bill_Settlement_Add_Tip_Button;
	
	@FindBy(xpath="//*[@id='guest_payment']/table/tbody/tr/td[1]/label")
	public  WebElement Bill_Settlement_Paid_Amount_Label;
	
	@FindBy(xpath="//*[@id='totalOutstanding']")
	public  WebElement Bill_Settlement_Paid_Amount_TextBox;
	
	@FindBy(xpath="//*[@id='guest_payment']/table/tbody/tr/td[3]/label/h5/b")
	public  WebElement Bill_Settlement_Net_Amount_Label;
	
	@FindBy(xpath="//*[@id='balanceOutstanding']")
	public  WebElement Bill_Settlement_Net_Amount_TextBox;
	
	@FindBy(xpath="//*[@id='payment']")
	public  WebElement Bill_Settlement_Save_Button;
	
	@FindBy(xpath="//*[@id='addtable']")
	public  WebElement Bill_Settlement_Payment_Table;
	
	@FindBy(xpath="//*[@id='addtable']/thead")
	public  List<WebElement>Bill_Settlement_Payment_Table_Headers;
	
	@FindBy(xpath="//*[@id='walkinguestlist']/tr/td")
	public  List<WebElement>Bill_Settlement_Payment_Table_Rowscells;
	
	@FindBy(xpath="//*[@id='walkinguestlist']/tr")
	public  List<WebElement>Bill_Settlement_Payment_Table_Rows;
	
	@FindBy(xpath="//*[@id='walkinguestlist']/tr/td[4]")
	public  List<WebElement>Bill_Settlement_Payment_Table_No_of_Columns;
	
	@FindBy(xpath="//*[@id='trow']/tr")
	public  List<WebElement>Bill_Settlement_Bills_List_Table_Rows;
	
	
	
	/***********Gift Voucher ***********/
	
	
	@FindBy(xpath="//*[@id='giftvouchertable']/tbody/tr/td[1]/label")
	public  WebElement Bill_Settlement_Gift_Voucher_ID_Label;
	
	@FindBy(xpath="//*[@id='giftvouchertable']/tbody/tr/td[3]/label")
	public  WebElement Bill_Settlement_Gift_Voucher_Amount_Label;
	
	@FindBy(xpath="//*[@id='giftvoucherid']")
	public  WebElement Bill_Settlement_Gift_Voucher_ID;
	
	@FindBy(xpath="//*[@id='giftvoucheramount']")
	public  WebElement Bill_Settlement_Gift_Voucher_Amount;
	
	public void Select_Gift_Voucher() throws InterruptedException
	{
		Thread.sleep(2000);
		Select slt= new Select(Bill_Settlement_Payment_Mode_Listbox);
		String Exp_PaymentMode= "Gift Voucher";
		slt.selectByVisibleText(Exp_PaymentMode);
		Reporter.log("Selected Payment Mode Is "+" "+slt.getFirstSelectedOption().getText());
	}
	
	/***********Marketing Voucher ***********/
	
	
	@FindBy(xpath="//*[@id='marketingvochertable']/tbody/tr[1]/td[1]/label")
	public  WebElement Bill_Settlement_Marketing_Voucher_ID_Label;
	
	@FindBy(xpath="//*[@id='marketingvochertable']/tbody/tr[1]/td[3]/label")
	public  WebElement Bill_Settlement_Marketing_Voucher_Amount_Label;
	
	@FindBy(xpath="//*[@id='marketingvoucherid']")
	public  WebElement Bill_Settlement_Marketing_Voucher_ID_Textbox;
	
	@FindBy(xpath="//*[@id='voucheramount']")
	public  WebElement Bill_Settlement_Marketing_Voucher_Amount_Textbox;
	
	@FindBy(xpath="//*[@id='marketingvochertable']/tbody/tr[3]/td[1]/label")
	public  WebElement Bill_Settlement_Marketing_Company_Label;
	
	@FindBy(xpath="//*[@id='marketingcompany']")
	public  WebElement Bill_Settlement_Marketing_Company_Textbox;
	
	public void Select_Marketing_Voucher() throws InterruptedException
	{
		Thread.sleep(2000);
		Select slt= new Select(Bill_Settlement_Payment_Mode_Listbox);
		String Exp_PaymentMode= "Marketing Voucher";
		slt.selectByVisibleText(Exp_PaymentMode);
		Reporter.log("Selected Payment Mode Is "+" "+slt.getFirstSelectedOption().getText());
	}
	
	
		
	/*********** Debit Card Payment ***********/
	
	@FindBy(xpath="//*[@id='debitcardtable']/tbody/tr[1]/td[1]/label")
	public  WebElement Bill_Settlement_Name_on_Debit_Card_Label;
	
	@FindBy(xpath="")
	public  WebElement Bill_Settlement_Name_on_Debit_Card_valmessage;
	
	@FindBy(xpath="//*[@id='debitcardtable']/tbody/tr[1]/td[3]/label")
	public  WebElement Bill_Settlement_Debit_Card_Number_Label;
	
	@FindBy(xpath="")
	public  WebElement Bill_Settlement_Debit_Card_Number_valmessage;
	
	@FindBy(xpath="//*[@id='debitcardtable']/tbody/tr[3]/td[1]/label")
	public  WebElement Bill_Settlement_Debit_Card_Type_Label;
	
	@FindBy(xpath="")
	public  WebElement Bill_Settlement_Debit_Card_Type_valmessage;
	
	@FindBy(xpath="//*[@id='debitcardname']")
	public  WebElement Bill_Settlement_Name_on_Debit_Card_Textbox;
	
	@FindBy(xpath="//*[@id='debitcardnumber']")
	public  WebElement Bill_Settlement_Debit_Card_Number_TextBox;
	
	@FindBy(xpath="//*[@id='debitcardtype']")
	public  WebElement Bill_Settlement_Debit_Card_Type_Listbox;
	
	public void Select_Debit_Card_Payment_Mode() throws InterruptedException
	{
		Appointment_tab.click();
		Thread.sleep(2000);
		Bill_Settlements_tab.click();
		Reporter.log("Appointment ID is"+" "+Appointment_Id_hyperlink.getText());
		Appointment_Id_hyperlink.click();
		Select slt= new Select(Bill_Settlement_Payment_Mode_Listbox);
		String PaymentMode= "Debit Card";
		slt.selectByVisibleText(PaymentMode);
		Reporter.log("Selected Payment Mode Is "+" "+slt.getFirstSelectedOption().getText());
		
	}
	public void Select_Payment_by_Cash() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Payment_Mode_Listbox);
		String Exp_PaymentMode= "Cash";
		slt.selectByVisibleText(Exp_PaymentMode);
		Reporter.log("Selected Payment Mode Is "+" "+slt.getFirstSelectedOption().getText());
	}
	
	
	public void Select_Debit_Card_Type_Master() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Debit_Card_Type_Listbox);
		slt.selectByIndex(1);
		Reporter.log("Selected Debit Card Type is"+" "+slt.getFirstSelectedOption().getText());
	}
	public void Select_Debit_Card_Type_Visa() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Debit_Card_Type_Listbox);
		slt.selectByIndex(2);
		Reporter.log("Selected Debit Card Type is"+" "+slt.getFirstSelectedOption().getText());
	}
	
	
	
	/*********** Room Posting Payment ***********/
	
	
	public void Opening_Bill_List_Page() throws InterruptedException
	{
		Appointment_tab.click();
		Thread.sleep(2000);
		Bill_Settlements_tab.click();
	}
	public void Opening_Bill_Settlement_Page() throws InterruptedException
	{
		Appointment_tab.click();
		Thread.sleep(2000);
		Bill_Settlements_tab.click();
		Reporter.log("Appointment ID is"+" "+Appointment_Id_hyperlink.getText());
		Appointment_Id_hyperlink.click();
	}
	
	public void Select_Room_Posting_Payment_Mode() throws InterruptedException
	{
		Thread.sleep(2000);
		Select slt= new Select(Bill_Settlement_Payment_Mode_Listbox);
		String Exp_PaymentMode= "Room Posting";
		slt.selectByVisibleText(Exp_PaymentMode);
		Reporter.log("Selected Payment Mode Is "+" "+slt.getFirstSelectedOption().getText());
	}
	public void Select_Building_Name() throws InterruptedException
	{
		String option= "BUSINESS SUITE";
		Select slt= new Select(Bill_Settlement_Room_Posting_Building_Name_ListBox);
		slt.selectByVisibleText(option);
		String option_n=slt.getFirstSelectedOption().getText();
		Reporter.log("Selected Building Name is"+" "+option_n);
		
	}
	public void Select_Room_Number() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Room_Posting_Room_Number_Listbox);
		slt.selectByIndex(1);;
		String option_n=slt.getFirstSelectedOption().getText();
		Reporter.log("Selected Room Number is"+" "+option_n);
		
	}
	public void Select_GuestID() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Room_Posting_GuestID_Listbox);
		slt.selectByIndex(1);;
		String option_n=slt.getFirstSelectedOption().getText();
		Reporter.log("Selected Guest ID is"+" "+option_n);
	}
	public void Select_GuestName() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Room_Posting_GuestName_Listbox);
		slt.selectByIndex(1);;
		String option_n=slt.getFirstSelectedOption().getText();
		Reporter.log("Selected Guest Name is"+" "+option_n);
	}
	public void Select_Folio_no() throws InterruptedException
	{
		Select slt= new Select(Bill_Settlement_Room_Posting_FolioNo_Listbox);
		slt.selectByIndex(1);;
		String option_n=slt.getFirstSelectedOption().getText();
		Reporter.log("Selected Folio no is"+" "+option_n);
		
	}
	public void Add_Room_Posting() throws InterruptedException
	{
	
		Select_Building_Name();
		Select_Room_Number();
		Select_GuestID();
		Select_GuestName();
		Select_Folio_no();
		String Exp_val="999";
		Bill_Settlement_Room_Posting_Amount.sendKeys(Exp_val);
		Reporter.log("Value Entered in Room Posting Amount field is"+" "+Exp_val);
		Bill_Settlement_Room_Posting_Add_Button_.click();
	}
	
	
		@FindBy(xpath="//*[@id='roommasterpopup']/div/div/div[2]/div/form/div[1]/div[1]/div/label")
		public  WebElement Bill_Settlement_Room_Posting_Building_Name_Label;
		
		@FindBy(xpath="//*[@id='buildigsearch']")
		public  WebElement Bill_Settlement_Room_Posting_Building_Name_ListBox;
		
		@FindBy(xpath="//*[@id='addvaluetolist']")
		public  WebElement Bill_Settlement_Room_Posting_Add_Button_;
		
		@FindBy(xpath="//*[@id='hideshowroom']/label")
		public  WebElement Bill_Settlement_Room_Posting_Room_Number_label;
		
		@FindBy(xpath="//*[@id='searchroom']")
		public  WebElement Bill_Settlement_Room_Posting_Room_Number_Listbox;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[1]/div[1]/label")
		public  WebElement Bill_Settlement_Room_Posting_GuestID_Label;
		
		@FindBy(xpath="//*[@id='regdid']")
		public  WebElement Bill_Settlement_Room_Posting_GuestID_Listbox;
		
		@FindBy(xpath="")
		public  WebElement Bill_Settlement_Room_Posting_GuestID_valerrormsg;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[1]/div[2]/label")
		public  WebElement Bill_Settlement_Room_Posting_GuestName_label;
	
		@FindBy(xpath="//*[@id='roomguestname']")
		public  WebElement Bill_Settlement_Room_Posting_GuestName_Listbox;
		
		@FindBy(xpath="")
		public  WebElement Bill_Settlement_Room_Posting_GuestName_valerrormsg;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[1]/div[3]/label")
		public  WebElement Bill_Settlement_Room_Posting_FolioNo_label;
		
		@FindBy(xpath="//*[@id='foliono']")
		public  WebElement Bill_Settlement_Room_Posting_FolioNo_Listbox;
		
		@FindBy(xpath="")
		public  WebElement Bill_Settlement_Room_Posting_FolioNo_valerrormsg;
		
		@FindBy(xpath="//*[@id='roompostingamount']")
		public  WebElement Bill_Settlement_Room_Posting_Amount;
		
		@FindBy(xpath="")
		public  WebElement Bill_Settlement_Room_Posting_Amount_valerrormsg;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[2]/div[1]/label")
		public  WebElement Bill_Settlement_Room_Posting_Department_label;
		
		@FindBy(xpath="//*[@id='department']")
		public  WebElement Bill_Settlement_Room_Posting_Department_Field;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[2]/div[2]/label")
		public  WebElement Bill_Settlement_Room_Posting_Service_label;
		
		@FindBy(xpath="	//*[@id='service']")
		public  WebElement Bill_Settlement_Room_Posting_Service_Field;
		
		@FindBy(xpath="//*[@id='fulldivhideshowId']/div[2]/div[3]/label")
		public  WebElement Bill_Settlement_Room_Posting_Incomehead_label;
		
		@FindBy(xpath="//*[@id='incomehead']")
		public  WebElement Bill_Settlement_Room_Posting_incomehead_field;
		
		@FindBy(xpath="//*[@id='roommasterpopup']/div/div/div[3]/button[1]")
		public  WebElement Bill_Settlement_Room_Posting_Close_button;
		
		@FindBy(xpath="//*[@id='roommasterpopup']/div/div/div[1]/h4")
		public  WebElement Bill_Settlement_Room_Posting_ModalBox_Mainheading;
		
		@FindBy(xpath="//*[@id='datedetails']")
		public  WebElement Bill_Settlement_Room_Posting_Modalbox_Date_Heading;
		
		@FindBy(xpath="//*[@id='roommasterpopup']/div/div")
		public  WebElement Bill_Settlement_Room_Posting_Modalbox;
		
		
		
		/*********** Discounts ***********/
		
		@FindBy(xpath="//*[@id='discount']")
		public  WebElement Bill_Settlement_Discount_Button;
		
		@FindBy(xpath="//*[@id='modalbillsettlediscount']/div/form/div/div[2]/div/table/tbody/tr[1]/td[1]/label")
		public  WebElement Bill_Settlement_Discount_Type_Label;
		
		@FindBy(xpath="//*[@id='disamount']/td[1]/label")
		public  WebElement Bill_Settlement_Discount_By_Amount_Label;
		
		@FindBy(xpath="//*[@id='dispercent']/td[1]/label")
		public  WebElement Bill_Settlement_Discount_By_Percent_Label;
		
		@FindBy(xpath="//*[@id='modalbillsettlediscount']/div/form/div/div[2]/div/table/tbody/tr[4]/td[1]/label")
		public  WebElement Bill_Settlement_Discount_Reason_label;
		
		@FindBy(xpath="//*[@id='discounttype']")
		public  WebElement Bill_Settlement_Discount_Type_ListBox;
		
		@FindBy(xpath="//*[@id='billdiscountbyamount']")
		public  WebElement Bill_Settlement_Discount_By_Amount_TextBox;
		
		@FindBy(xpath="//*[@id='billdiscountbypercent']")
		public  WebElement Bill_Settlement_Discount_By_Percent_TextBox;
		
		@FindBy(xpath="//*[@id='billdiscountreason']")
		public  WebElement Bill_Settlement_Discount_Reason_ListBox;
		
		@FindBy(xpath="//*[@id='adddiscounttotable']")
		public  WebElement Bill_Settlement_Discount_Submit_Button;
		
		@FindBy(xpath="//*[@id='modalbillsettlediscount']/div/form/div/div[3]/button[2]")
		public  WebElement Bill_Settlement_Discount_Cancel_Button;
		
		@FindBy(xpath="//*[@id='modalbillsettlediscount']/div/form/div/div[1]/h4")
		public  WebElement Bill_Settlement_Discounts_heading_in_Modal_message;
	
//		@FindBy(xpath="//*[@id='summaryModal1']/div/div/div[2]/button")
//		public  WebElement Bill_Settlement_Modal_error_message_Ok_button;
		
//		@FindBy(xpath="//*[@id='addsummaryfields1']")
//		public  WebElement Bill_Settlement_Modal_error_message;
		
		@FindBy(xpath="//*[@id='dislabel']/label")
		public  WebElement Bill_Settlement_Discount_Amount_field_Label_at_Billsettlementpage;
		
		@FindBy(xpath="//*[@id='discountamountt']")
		public  WebElement Bill_Settlement_Discount_Amount_field_at_Billsettlementpage;
		
		@FindBy(xpath="//*[@id='amountCharged']")
		public  WebElement Bill_Settlement_Bill_Amount_value;

	public void Select_Discount_Type_percent()
		{	Select slt= new Select(Bill_Settlement_Discount_Type_ListBox);
			slt.selectByIndex(1);
			String Sltd_discount_type = slt.getFirstSelectedOption().getText();
			Reporter.log("Selected Discount Type Name is"+"  "+Sltd_discount_type, true);
		}
		public void Select_Discount_Type_amount()
		{
			Select slt= new Select(Bill_Settlement_Discount_Type_ListBox);
			slt.selectByIndex(2);
			String Sltd_discount_type = slt.getFirstSelectedOption().getText();
			Reporter.log("Selected Discount Type is "+"  "+Sltd_discount_type, true);
		}
		public void Select_Discount_Reason()
		{
			Select slt= new Select(Bill_Settlement_Discount_Reason_ListBox);
			slt.selectByIndex(2);
			String sltd_discount_reason = slt.getFirstSelectedOption().getText();
			Reporter.log("Selected Discount Reason is "+"  "+sltd_discount_reason, true);
		}
		public void Add_Discount_Button() throws InterruptedException
		{
			Thread.sleep(1000);
			Bill_Settlement_Discount_Button.click();
			Thread.sleep(1000);
		}
		public void Adding_Discount_Details() throws InterruptedException
		{
			Thread.sleep(1000);
			Bill_Settlement_Discount_Button.click();
			Thread.sleep(1000);
			Select_Discount_Type_amount();
			Bill_Settlement_Discount_By_Amount_TextBox.sendKeys("50");
			String Disc_A= Bill_Settlement_Discount_By_Amount_TextBox.getAttribute("value");
			Reporter.log("Discount By Amount Given"+" "+Disc_A);
			Select_Discount_Reason();
			
		}
	
}
