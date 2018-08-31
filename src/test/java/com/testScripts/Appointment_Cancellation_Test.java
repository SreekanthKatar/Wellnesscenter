package com.testScripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.pageLibrary.Appointment_Cancellation;

public class Appointment_Cancellation_Test {
	
  Appointment_Cancellation ac = new Appointment_Cancellation();
  
  //AC_01
  @Test (priority=0)
  public void AC_01_Verify_Appointment_Cancellation_Page () throws InterruptedException, AWTException {
	  ac.ac_01_verify_appointment_cancellation_page();
  }
  
//AC_03
  @Test (priority=1)
  public void AC_03_Verify_Main_Heading () throws InterruptedException {
	  ac.ac_03_verify_main_heading();
  }
  
//AC_04
  @Test (priority=2)
  public void AC_04_Verify_Sub_Heading () throws InterruptedException {
	  ac.ac_04_verify_sub_heading();
  }
  
//AC_38
  @Test (priority=3)
  public void AC_38_Verify_AllText_Boxes () throws InterruptedException {
	  ac.ac_38_verify_all_textboxes();
  }
  
//verify All Datefields in Form
  @Test (priority=4)
  public void Verify_AllDates_Fields () throws InterruptedException {
	  ac.verify_all_date_fields();
  }
  
  
//AC_39
  @Test (priority=5)
  public void AC_39_Verify_All_Buttons () throws InterruptedException {
	  ac.ac_39_verify_all_buttons();
  }
  
//verify webtable data
  @Test (priority=6)
  public void Verify_Web_Table () throws InterruptedException {
	  ac.web_table();
  }
  

//verify Webtable displayed
  @Test (priority=7)
  public void AC_05_Verify_Web_Table_Display () throws InterruptedException {
	  ac.ac_05_verify_webtable_visibility();
  }
  
//verify All Labels in Form
  @Test (priority=8)
  public void AC_06_Verify_All_Labels () throws InterruptedException {
	  ac.ac_06_verify_all_labels();
  }
  
//verify Searched AppointmentId result
  @Test (priority=9)
  public void AC_07_Verify_SerachAppointmentID_Result() throws InterruptedException, AWTException {
	  ac.ac_07_verify_SerachAppointmentID_Result();
  }
  
  //AC_14
  @Test (priority=10)
  public void AC_08_Verify_SerachAppointmentCancellation_Result() throws InterruptedException, AWTException {
 	  ac.ac_08_verify_SerachAppointmentCancellation_Result();
  }
  
  @Test (priority=11)
  public void AC_09_Verify_SerachAppointmentID_invalid() throws InterruptedException, AWTException {
	  ac.ac_09_verify_SearchAppointmentId_invalid();
  }
  @Test (priority=12)
  public void AC_10_Verify_SerachAppointmentID_Alphabets_invalid() throws InterruptedException, AWTException {
	  ac.ac_10_verify_SearchAppointmentId_Alphabets_invalid();
  }
  @Test (priority=13)
  public void AC_10_Verify_SerachAppointmentID_Alphanumerics_invalid() throws InterruptedException, AWTException {
	  ac.ac_10_verify_SearchAppointmentId_Alphanumerics_invalid();
  }
  @Test (priority=14)
  public void AC_10_Verify_SerachAppointmentID_SpecialCharacters_invalid() throws InterruptedException, AWTException {
	  ac.ac_10_verify_SearchAppointmentId_SpecialCharacters_invalid();
  }
  @Test (priority=15)
  public void AC_11_Verify_SerachGuestName_Result() throws InterruptedException, AWTException {
	  ac.ac_11_verify_SearchGuestName_Result();
  }
  @Test (priority=16)
  public void AC_12_Verify_SerachAppointmentCancellation_NameResult() throws InterruptedException, AWTException {
	  ac.ac_012_verify_SerachAppointmentCancellation_NameResult();
  }
  
 @Test (priority=17)
  public void AC_13_Verify_SerachAppointmentName_invalid() throws InterruptedException, AWTException {
	  ac.ac_13_verify_SearchAppointmentName_invalid();
  }
  
  //AC_14
  @Test (priority=18)
  public void AC_14_Verify_SearchAppointmentName_SpecialCharacters_Invalid() throws InterruptedException, AWTException {
 	  ac.ac_14_verify_SearchAppointmentName_SpecialCharacters_invalid();
  }
  
//AC_14
  @Test (priority=19)
  public void AC_14_Verify_SearchAppointmentName_Numerics_Invalid() throws InterruptedException, AWTException {
 	  ac.ac_14_verify_SearchAppointmentName_Numerics_invalid();
  }
  
//AC_14
  @Test (priority=20)
  public void AC_14_Verify_SearchAppointmentName_AlphaNumerics_Invalid() throws InterruptedException, AWTException {
 	  ac.ac_14_verify_SearchAppointmentName_AlphaNumerics_invalid();
  }
  //AC_27
  @Test (priority=21)
  public void AC_27_Verify_SearchByAppointment_MorethanSystemDate_Result() throws InterruptedException, AWTException {
 	  ac.ac_27_verify_SearchByAppointment_MorethanSystemDate_Result();
  }
  
//AC_28
  @Test (priority=22)
  public void AC_28_Verify_SearchByAppointment_LessthanSystemDate_Result() throws InterruptedException, AWTException {
 	  ac.ac_28_verify_SearchByAppointment_LessthanSystemDate_Result();
  }
  
 @Test (priority=23)
  public void AC_29_Verify_SerachAppointmentDate_Result() throws InterruptedException, AWTException {
	  ac.ac_29_verify_SearchByAppointmentDate_Result();
  }
 @Test (priority=24)
 public void AC_30_Verify_SerachAppointment_InvalidDate_Result() throws InterruptedException, AWTException {
	  ac.ac_30_verify_SearchByAppointment_InvalidDate_Result();
 }
  @Test (priority=25)
  public void AC_31_Verify_Status() throws InterruptedException, AWTException {
 	  ac.ac_31_verify_Status();
}
  @Test (priority=26)
  public void AC_32_Verify_Cancel() throws InterruptedException, AWTException {
 	  ac.ac_32_verify_Cancel();
}
  @Test (priority=27)
  public void AC_33_Verify_ClickheretoCancel() throws InterruptedException, AWTException {
 	  ac.ac_33_verify_ClickheretoCancel();
}
  @Test (priority=28)
  public void AC_34_Verify_OKbutton() throws InterruptedException, AWTException {
 	  ac.ac_34_verify_Ok_button();
}
  @Test (priority=29)
  public void AC_35_Verify_Cancelbutton() throws InterruptedException, AWTException {
 	  ac.ac_35_verify_Cancel_button();
}
  @Test (priority=30)
  public void Ac_36_Verify_Cancelled_record() throws InterruptedException, AWTException {
 	  ac.ac_36_verify_Cancelled_record();
}
}

