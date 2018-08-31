package com.testScripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageLibrary.Reprint;
import com.utils.DriverInitializer;

public class Reprint_Test {
	public WebDriver driver = DriverInitializer.getDriver();
	Reprint rp = new Reprint();
	
	  //RP_01
	  @Test (priority=0)
	  public void RP_01_Verify_Reprint_Page () throws InterruptedException, AWTException {
		  rp.rp_01_verify_reprint_page();
	  }
	  
	//RP_02
	  @Test (priority=1)
	  public void RP_02_Verify_Main_Heading () throws InterruptedException, AWTException {
		  rp.rp_02_verify_main_heading();
	  }
	  
	//RP_03
	  @Test (priority=2)
	  public void RP_03_Verify_Sub_Heading () throws InterruptedException, AWTException {
		  rp.rp_03_verify_sub_heading();
	  }
	  
	//RP_04
	  @Test (priority=3)
	  public void RP_09_Verify_From_Date () throws InterruptedException, AWTException {
		  rp.rp_09_verify_from_date();
	  }
	  
	//RP_05
	  @Test (priority=4)
	  public void RP_11_Verify_LeavingFromDate_Blank () throws InterruptedException, AWTException {
		  rp.rp_11_verify_LeavingFromDate_Blank();
	  }
	//RP_06
	  @Test (priority=16)
	  public void RP_16_Verify_To_Date () throws InterruptedException, AWTException {
		  rp.rp_16_verify_to_date();
	  }
	  
	  //RP_07
	  @Test (priority=17)
	  public void RP_21_Verify_SearchGuestName () throws InterruptedException, AWTException {
		  rp.rp_21_verify_SearchGuestName_Result();
	  }
	  
	//RP_08
	  @Test (priority=18)
	  public void RP_22_Verify_SearchGuestName_invalid () throws InterruptedException, AWTException {
		  rp.rp_22_verify_SearchGuestName_invalid();
	  }
	  
	//RP_09
	  @Test (priority=19)
	  public void RP_23_Verify_SearchGuestName_NumericValues_Invalid () throws InterruptedException, AWTException {
		  rp.rp_23_verify_SearchGuestName_NumericValues_Invalid();
	  }
	  
	//RP_10
	  @Test (priority=20)
	  public void RP_23_Verify_SearchGuestName_SpecialCharacters_Invalid () throws InterruptedException, AWTException {
		  rp.rp_23_verify_SearchGuestName_SpecialCharacters_Invalid();
	  }
	  
	//RP_11
	  @Test (priority=21)
	  public void RP_23_Verify_SearchGuestName_AlphaNumerics_Invalid () throws InterruptedException, AWTException {
		  rp.rp_23_verify_SearchGuestName_AlphaNumerics_Invalid();
	  }
	  
	//RP_12
	  @Test (priority=22)
	  public void RP_24_Verify_SearchBillNumber () throws InterruptedException, AWTException {
		  rp.rp_24_verify_SearchBillNumber_Result();
	  }
	  
	//RP_13
	  @Test (priority=23)
	  public void RP_25_Verify_SearchBillNumber_Invalid () throws InterruptedException, AWTException {
		  rp.rp_25_verify_SearchBillNumber_invalid();
	  }
	  
	//RP_14
	  @Test (priority=24)
	  public void RP_26_Verify_SearchBillNumber_Numerics () throws InterruptedException, AWTException {
		  rp.rp_26_verify_SearchBillNumber_Numerics();
	  }
	  
	//RP_15
	  @Test (priority=24)
	  public void RP_27_Verify_SearchBillNumber_Alphabets () throws InterruptedException, AWTException {
		  rp.rp_27_verify_SearchBillNumber_Alphabets_Invalid();
	  }
	  
	//RP_16
	  @Test (priority=25)
	  public void RP_27_Verify_SearchBillNumber_SpecialCharacters () throws InterruptedException, AWTException {
		  rp.rp_27_verify_SearchBillNumber_SpecialCharacters_Invalid();
	  }
	  
	//RP_17
	  @Test (priority=26)
	  public void RP_28_Verify_SelectOption () throws InterruptedException, AWTException {
		  rp.rp_28_verify_SelectOption();
	  }
	  
	//RP_18
	  @Test (priority=27)
	  public void RP_29_Verify_SelectBillTypeOption () throws InterruptedException, AWTException {
		  rp.rp_29_verify_SelectBillTypeOption();
	  }
	  
	//RP_19
	  @Test (priority=28)
	  public void RP_30_Verify_PrintMessage () throws InterruptedException, AWTException {
		  rp.rp_30_PrintMessage();
	  }
	  
	//RP_20
	  @Test (priority=29)
	  public void RP_31_Popup_OkButton_Click() throws InterruptedException, AWTException {
		  rp.rp_31_Popup_OkButton_Click();
	  }
	  
	//RP_21
	  @Test (priority=30)
	  public void RP_32_CancelButton_Click() throws InterruptedException, AWTException {
		  rp.rp_32_CancelButton_Click();
	  }
	  
	//RP_22
	  @Test (priority=31)
	  public void RP_33_PrintMessage_ReceiptBill() throws InterruptedException, AWTException {
		  rp.rp_33_PrintMessage_ReceiptBill();
	  }
	  
	//RP_23
	  @Test (priority=32)
	  public void RP_34_OkButton_Click() throws InterruptedException, AWTException {
		  rp.rp_34_Popup_OkButton_Click();
	  }
	  
	//RP_24
	  @Test (priority=33)
	  public void RP_35_CancelButton_Click_ReceiptBill() throws InterruptedException, AWTException {
		  rp.rp_35_CancelButton_Click_ReceiptBill();
	  }
	  
	//RP_25
	  @Test (priority=34)
	  public void RP_36_Verify_SelectBillType() throws InterruptedException, AWTException {
		  rp.rp_36_verify_SelectBillType();
	  }

}

