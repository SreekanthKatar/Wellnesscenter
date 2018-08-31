package com.pageLocators;



public class Bill_Settlement_page_Locators 
{
	public String Appointment_Menu_xpath = "//*[@id='wrapper']/nav/div[2]/ul/li[1]/a";
	
	public String Bill_Settlement_xpath = 	"//*[@id='appointment']/li[6]/a";
	
	public String WebTable_BillSettlement_Page_xpath = "//*[@id='wrapper']/div/div[2]/div/div/form/div/div[2]/div/table";
	
	public String Payment_Mode_Dropdown_xpath = "//*[@id='paymentmodetype']";
	
	public String Name_On_CreditCard_Textbox_xpath = "//*[@id='creditcardname']";
	
	public String CreditCard_Number_Textbox_xpath = "//*[@id='creditcardnumber']";
	
	public String CreditCardType_Dropdown_xpath = "//*[@id='creditcardtype']";

	public String Amount_Textbox_xpath = "//*[@id='amount']";
	
	public String Add_Settlement_Button_xpath = "//*[@id='add']";

	public String BillAmount_WebTable_xpath = "//*[@id='addtable']";
	
	public String Save_Button_xpath = "//*[@id='payment']";
	
	public String Bill_ID_Disable_xpath = "//*[@id='billid']";
	
	public String Bill_Amount_Disable_xpath = "//*[@id='amountCharged']";
	
	public String Guest_Name_Disable_xapth = "//*[@id='guestname']";
	
	public String Net_Amount_Disable_xpath = "//*[@id='balanceOutstanding']";
	
	public String Bank_Name_textbox_xpath = "//*[@id='chequebank']";
	
	public String Cheque_Number_textbox_xpath = "//*[@id='chequenumber']";
	
	public String Cheque_Payee_textbox_xpath = "//*[@id='chequepayee']";
	
	public String Cheque_date_xpath = "//*[@id='chequedate']";
	
	public String Cheque_Number_Label_xpath = "//*[@id='chequetable']/tbody/tr[3]/td[3]/label";

	//appointment module
	public String appointment_link_xpath = "//*[@id='wrapper']/nav/div[2]/ul/li[1]/a";
	
	//Bill settlement option
	public String bill_settlement_option_linktext = "Bill Settlement";
	
	//Bill_settlement_page Url
	public String bill_settlement_page_URL = "http://172.22.5.34:8080/wellness/paymentsettlement";
	
	//header of bill settlement page
	public String  main_heading_xpath = "//*[@id='wrapper']/div/div[1]/div/h1/small";
	
	//header of bill settlement page text
	public String main_heading_text = "Bill Settlement List";
	
	//Sub heading
	public String sub_heading_xpath = "//*[@id='wrapper']/div/div[2]/div/div/div/h3";
	
	//sub_heading text
	public String sub_heading_txt = "List of Bills";
	
	//table display
	public String webtable_xpath = "//*[@id='wrapper']/div/div[2]/div/div/form/div/div[2]/div/table";
	
	//search by guest name text box
	public String	search_by_guest_name_text_box_id = "billno";
	
	//search button
	public String search_button_xpath = "//*[@id='search']";
	
	//Bill settlement page title
	public String Bill_settlement_page_title = "Bill Settlement";
	
	//No record found
	public String unregistered_guest_xpath = "//*[@id='wrapper']/div/div[2]/div/div/form/div/div[2]/div";
	                                           	
	//No record found message
	public String no_record_are_found_txt = "No records are found!";
	
	//Bill No Link row first
	public String bill_n0_xpath = "//*[@id='trow']/td[1]/a";
		
	//Bill No Link row second 
	public String bill_n02_xpath = "//*[@id='trow']/td[2]/a";
	
	//Url of bill settlement
	public String bill_n0_id_text = "http://172.22.5.34:8080/wellness/billsettle?billNo=32";
	
	//Bill Id
	public String bill_id_xpath = "//*[@id='billid']";
	
	//Bill amount
	public String bill_amount_xpath = "//*[@id='amountCharged']";
	
	//Guest Name
	public String guest_name_xpath = "//*[@id='guestname']";
	
	//Tip amount
	public String tip_amount_xpath = "//*[@id='tipamount']";
	
	//Add tip button
	public String add_tip_button_xpath = "//*[@id='addtip']";
	
	//Net amount textbox
	public String net_amount_xpath = "//*[@id='balanceOutstanding']";
	
	//Payment mode dropdown
	public String payment_mode_dropdown_id = "paymentmodetype";
	
	// By default value Payment mode dropdown
	public String by_default_value = "Select";            
	
	//Add settlement button
	public String add_settlement_button_xpath = "//*[@id='add']";
	
	//Amount display in the grid
	public String amount_grid_xpath = "//*[@id='amount']";
	
	//Alert message after click bill settlement button
	public String alert_message = "Please Select Payment Mode";
	
	//Corporate
	public String corporate_dropdown_xpath = "//*[@id='corporateType']";
	
	//corporate label
	public String corporate_label_xpath = "//*[@id='corporatetable']/tbody/tr[1]/td[1]/label";
	
	//CreditList Amount
	public String creditList_amount_txtBox_xpath = "//*[@id='creditlistoutsatndingmoney']";
	
	//CreditList Amount label
	public String creditList_amount_label_xpath = "//*[@id='corporatetable']/tbody/tr[1]/td[3]/label";
	
	//alert message
	public String alert_meaasge_after_corporate_selection_txt = "Available CreditList Amount:100000";
	
	//Credit List amount 
	public String credit_list_amount_txtbox_xpath = "//*[@id='creditlistoutsatndingmoney']";
	
	//amount
	public String amount_xpath = "//*[@id='amount']";
	
	//table
	public String table_xpath = "//*[@id='addtable']"; 
	
	//Alert message enter amount more than net amount
	public String alert_mess_EnterAmount_more_than_NetAmount = "Settlement amount not matching with Net Amount";
	
	//Guest Name
	public String guest_name1_xpath = "//*[@id='guestname']";
	
	//Member name Label
	public String member_name_label_xpath = "//*[@id='membershiptable']/tbody/tr[1]/td[1]/label";
	
	//Member name text
	public String member_name_label_txt = "Member Name";
	
	//Membership amount label
	public String membership_amount_label_xpath = "//*[@id='membershiptable']/tbody/tr[1]/td[3]/label";
	
	//Membership amount label text 
	public String membership_amount_txt = "Membership Amount";
	
	//Member Name dropdown
	public String member_name_dropdown_xpath = "//*[@id='membership']";
	
	//Alert message after selection of dropdown
	public String alert_message_member_name_txt = "Available Memebership Amount:4545";
	
	//Membership amount txtbox
	public String membership_amount_txtbox_xpath = "//*[@id='membershipoutsatndingmoney']";
	
	//Alert message ,enter amount more than net amount
	public String alert_message_amount_moreThan_net_amount = "Settlement amount not matching with Net Amount";
	
	//Alert message ,enter amount more than membership amount
	public String alert_message_amount_moreThan_membership_amount = "Settlement amount not matching with membership amount";
	
	//Amount level 
	public String amount_level_xpath = "//*[@id='biisettlement']/table/tbody/tr[3]/td[5]/label";
	
	//Alert message without select member name click add settlement
	public String alert_message_without_select_memberName_click_add_settlement_button = "Please select member name";
	
	

	
}
