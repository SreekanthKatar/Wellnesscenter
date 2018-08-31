package com.pageLocators;

public class Reprint_Locator {
	//-------------------------------------------Reprint Locators-----------------------------------------------------
	//Appointment List Page URL
		public String App_List_Page_URL = "http://localhost:8080/wellness/appointmentslist#";
		
    //Appointment Module Xpath
		public String Appointment_Module_Xpath = "//*[@id='wrapper']/nav/div[2]/ul/li[1]/a";
		
    //Reprint Xpath
		public String Reprint_Xpath = "//*[@id='appointment']/li[8]/a";
		
	
    //Reprint Page URL
		public String Reprint_Page_URL = "http://172.22.5.34:8080/wellness/reprint";	
		
    //Reprint Main Heading Xpath
		public String Main_Heading_Xpath = "//*[@id='wrapper']/div[1]/div[1]/div/h1/small";
		
		
    //Reprint Main Heading Text
		public String Main_Heading_Text = "Reprint Bill";
		
    //Appointment Menu Options xpath
		public String App_Menu_Options_xpath = "//*[@id='appointment']";
		
	//Reprint Sub Heading Xpath
	   public String Sub_Heading_Xpath = "//*[@id='wrapper']/div/div[2]/div/div/div/h3";
	   
	 //Reprint Sub Heading Text
	 		public String Sub_Heading_Text = "Reprint Bill Data"; 
							
    //Reprint Main Heading Text

	//Reprint From Date Xpath
	   public String From_Date_Xpath = "//*[@id='fromdate']";
	   
	   public String From_Date_Text = "";
	   
	   public String From_Date_Label_Xpath = "//*[@id='wrapper']/div[1]/div[2]/div/div/div[2]/div[1]/div[1]/form/div/table/tbody/tr/td[1]/label";
	   
	   public String Search_Print = "//*[@id='searchreprint']";
	   
	   public String Web_Table_Xpath = "//*[@id='tblMain']";
	   
	   public String form_xpath = "//*[@id='wrapper']/div[1]/div[2]/div/div/div[2]/div[1]/div[1]/form";
	   
	   public String ToDate_label_xpath = "//form/div/table/tbody/tr/td[4]/label";
	   
	   public String ToDate_xpath = "//form/div/table/tbody/tr/td[5]/input";
	   
	   public String Searchby_GuestName_Xpath = "//*[@id='guestname']";
	   
	   public String Searchby_GuestName_Css = "input[type='text'][id='guestname'][name='guestname']";
	   
	   public String GuestName_Text = "guestname";
	   
	 //Reprint List Display
		public String WebTable_Display_Xpath = "//*[@id='tblMain']";
		
		public String No_Record_Found_xpath = "//*[@id='refresh']/div";
		
		public String No_Record_Found_Text = "No records are found!";
		
		public String Searchby_BillNumber_Xpath = "//*[@id='billnumber']";
		
		public String BillNumber_Text = "billnumber";
		
		public String ErrorCode500_Xpath = "/html/body/div/div/div/div/div[2]/div/table/tbody/tr/td[2]";
		
		public String SelectBillType_Xpath = "//*[@id='76']";
		
		public String Print_Xpath = "//*[@id='trow']/td[6]/button";
		
		public String sear_URL = "http://172.22.5.34:8080/wellness/reprintsearch";
		
		public String Fail_to_load_PDF_Document_Xpath = "//*[@id='load-failed-message']";
		
		public String Fail_to_load_PDF_Document_Text = "Failed to load PDF document";
		
		public String MPopup_Xpath = "//*[@id='summaryModal']";
		
		public String MPopup_Please_Select_Bill_Type_Xpath = "//*[@id='addsummaryfields']";
		
		public String MPopup_Please_Select_Bill_Type_Text  = "please select bill type";
		
		public String MPopup_Cancel_Button_Xpath = "//*[@id='summaryModal']/div/div/div[2]/button";
		
		
	   
}
