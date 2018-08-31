package com.pageLocators;

public class Appointment_Cancellation_Locator {
	//--------------------------------------------Appointment Cancellation Locators-----------------------------------------------------
	//Appointment List Page URL
	public String App_List_Page_URL = "http://localhost:8080/wellness/appointmentslist#";
	
	//Appointment Module Xpath
	public String Appointment_Module_Xpath = "//*[@id='wrapper']/nav/div[2]/ul/li[1]/a";
	
	
	//Appointment Cancellation Xpath
	public String Appointment_Cancellation_Xpath = "//*[@id='appointment']/li[3]/a";
	
	//Appointment Cancellation Page URL
	public String App_Cancellation_Page_URL = "http://172.22.5.34:8080/wellness/appointmentcancellationlist";
		
	//Page_Title
	public String Page_Title = "Appointment Cancellation" ; 
	
	//Appointment Cancellation Main Heading Xpath
	public String Main_Heading_Xpath = "//*[@id='wrapper']/div/div[1]/div/h1/small";
	
	//Appointment Cancellation Main Heading Text
	public String Main_Heading_Text = "Appointment Cancellation Page";
	
	//Appointment Cancellation Sub Heading Xpath
	public String Sub_Heading_Xpath = "//*[@id='wrapper']/div/div[2]/div/div/div/h3";
	
	//Appointment Cancellation Sub Heading Text
	public String Sub_Heading_Text = "List of Appointments";
	
	//Form Xpath
	public String Form_Xpath = "//*[@id='wrapper']/div/div[2]/div/div/form";
	
	//Appointment Cancellation List Display
	public String WebTable_Display_Xpath = "//*[@id='tblMain']";
	
	
	//Search_By_Appointment_ID
	public String Search_By_Appointment_ID_Xpath = "//*[@id='appointmentsid']";
	
	//Search_By_Appointment_Name
	public String Search_By_Appointment_Name_Xpath = "//*[@id='name']";
		
	//Search_By_Appointment_Date
	public String Search_By_Appointment_Date_Xpath = "//*[@id='appointmentdate']";
	
	//Search_Button
	public String Search_Button_Xpath = "//*[@id='search']";
	
	//No Records found xpath
	public String No_Records_Found_xpath = "//*[@id='refresh']";
		
	//No records found text
	public String No_Records_Found_Text = "No records are found!";

	//Appointment Menu Options xpath
	public String App_Menu_Options_xpath = "//*[@id='appointment']";
	
	//Status xpath
	public String Status_xpath = "//*[@id='trow']/td[4]";
	
	
	//Status text
	public String Status_Text = "Not started";
	
	//Cancel xpath
	public String Cancel_Option_xpath = "//*[@id='status']/b";
	
	
	//Cancel text
	public String Cancel_text = "Click here to Cancel";
	
	
	
	
										

}
