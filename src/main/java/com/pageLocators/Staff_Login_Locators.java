package com.pageLocators;



public class Staff_Login_Locators 
{
		//----------------------------------------Login Page Locators-----------------------------------------------------
		//URL
		public String Page_URL = "http://172.22.5.34:8080/wellness/login";
		
		//Appointments List PageURL
		public String App_List_Page_URL = "http://172.22.5.34:8080/wellness/appointmentslist";
		
		//Page Title
		public String Page_title = "";
		
		//Password Type
		public String Password_Type = "password";
		
		//Appointments List PageURL
		public String Appointment_List_Page_URL = "http://172.22.5.34:8080/wellness/appointmentslist";
		
		//Staff Login Title Text
		public String Main_Heading_Text = "Staff Login";
		
		//Staff Login Title Text Xpath
		public String Main_Heading_Text_xpath = "/html/body/form/div/div/div/div[2]/div/h3";
	
		//UserName Edit box Xpath
		public String Username_editbox_xpath = "/html/body/form/div/div/div/div[2]/div/div/div[1]/input";
		
		//Password Edit box Xpath
		public String Password_editbox_xpath = "/html/body/form/div/div/div/div[2]/div/div/div[2]/input";
		
		//Login Button Xpath
		public String Login_button_xpath = "/html/body/form/div/div/div/div[2]/div/div/a/input";
		
		public String user_xpath_at_logut = "//*[@id='wrapper']/nav/ul/li[3]";
		
		public String user_LogOut_xpath = "//*[@id='wrapper']/nav/ul/li[3]/ul/li[4]/a";
		
		
}
