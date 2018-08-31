package com.testScripts;

import org.testng.annotations.Test;

import com.pageLibrary.Bill_Settlement_page;



public class Bill_Settlement_page_test
{
	public Bill_Settlement_page bsp = new Bill_Settlement_page();
	
	@Test(groups ={"positive","negative"},priority=1 )
	public void BS_01_Display_bill_settlement_page()
	{
		bsp.BS_01_display_bill_settlement_page();
	}
	@Test(groups ={"positive","negative"},priority=2 )
	public void BS_02_Verify_spelling_mistake()
	{
		bsp.BS_02_verify_spelling_mistake();
	}
	@Test(groups ={"positive","negative"},priority=3 )
	public void BS_03_Header_display()
	{
		bsp.BS_03_header_display();
	}
	@Test(groups ={"positive","negative"},priority=4 )
	public void BS_04_Display_list_of_bills_webtable()
	{
		bsp.BS_04_display_list_of_bills_webtable();
	}
	@Test(groups ={"positive","negative"},priority=5)
	public void BS_05_Search_by_guest_name()
	{
		bsp.BS_05_search_by_guest_name();
	}
	@Test(groups ={"positive","negative"},priority=6 )
	public void BS_06_Display_title_of_page()
	{
		bsp.BS_06_display_title_of_page();
	}
	@Test(groups ={"positive","negative"},priority=7 )
	public void BS_07_Search_unavailable_guest_name()
	{
		bsp.BS_07_search_unavailable_guest_name();
	}
	@Test(groups ={"positive","negative"},priority=8)
	public void BS_08_Type_guest_name_alphabetic()
	{
		bsp.BS_08_type_guest_name_alphabetic();
	}
	@Test(groups ={"positive","negative"},priority=9)
	public void BS_09_Search_by_guest_name_as_special_and_numeric_character()
	{
		bsp.BS_09_search_by_guest_name_as_special_and_numeric_character();
	}
	@Test(groups ={"positive","negative"},priority=10 )
	public void BS_10_bill_n0_Link_isenable()
	{
		bsp.BS_10_bill_n0_Link_isenable();
	}
	@Test(groups ={"positive","negative"},priority=11)
	public void BS_11_Click_bill_n0_link()
	{
		bsp.BS_11_click_bill_n0_link();
	
	}
	
	@Test(groups ={"positive","negative"},priority=12 )
	public void BS_12_Verify_Bill_Id_disable()
	{
		bsp.BS_12_Verify_Bill_id_disable();
	
	}
	@Test(groups ={"positive","negative"},priority=13 )
	public void BS_13_Verify_Bill_Amount_disable()
	{
		bsp.BS_13_Verify_Bill_amount_disable();
	
	}
	@Test(groups ={"positive","negative"},priority=14 )
	public void BS_14_Verify_Guest_name_textbox_disable()
	{
		bsp.BS_14_Verify_guest_name_textbox_disable();
	
	}
	@Test(groups ={"positive","negative"},priority=15 )
	public void BS_15_Enter_tip_amount_numeric()
	{
		bsp.BS_15_enter_tip_amount_numeric();
	
	}
	@Test(groups ={"positive","negative"},priority=16 )
	public void BS_16_Enter_tip_amount_alphanumeric_with_special_character()
	{
		bsp.BS_16_enter_tip_amount_alphanumeric_with_special_character();
	
	}
	@Test(groups ={"positive","negative"},priority=17 )
	public void BS_17_Verify_add_tip_button_enable()
	{
		bsp.BS_17_verify_add_tip_button_enable();
	
	}
	@Test(groups ={"positive","negative"},priority=18 )
	public void BS_18_Verify_tip_amount_added_with_net_amount()
	{
		bsp.BS_18_verify_tip_amount_added_with_net_amount();
	
	}
	@Test(groups ={"positive","negative"},priority=19 )
	public void BS_19_Verify_add_tip_button_disable()
	{
		bsp.BS_19_verify_add_tip_button_disable();
	
	}
	@Test(groups ={"positive","negative"},priority=20 )
	public void BS_20_Verify_by_default_dropdown_value_payment_mode()
	{
		bsp.BS_20_verify_by_default_dropdown_value_payment_mode();
	
	}
	@Test(groups ={"positive","negative"},priority=21 )
	public void BS_21_Click_add_settlement_button()
	{
		bsp.BS_21_click_add_settlement_button();
	
	}
	@Test(groups ={"positive","negative"},priority=22 )
	public void BS_22_Click_popup_ok_button()
	{
		bsp.BS_22_click_popup_ok_button();
	
	}
	@Test(groups ={"positive","negative"},priority=23 )
	public void BS_23_Click_cancel_on_popup()
	{
		bsp.BS_23_click_cancel_on_popup();
	
	}
	@Test(groups ={"positive","negative"},priority=24 )
	public void BS_24_Select_dropdown_value_payment_mode()
	{
		bsp.BS_24_select_dropdown_value_payment_mode();
	
	}
	@Test(groups ={"positive","negative"},priority=25 )
	public void BS_25_Verify_select_dropdown_value_payment_mode()
	{
		bsp.BS_25_verify_select_dropdown_value_payment_mode();
	
	}
	@Test(groups ={"positive","negative"},priority=26 )
	public void BS_26_Display_by_default_dropdown_corporate() throws InterruptedException
	{
		bsp.BS_26_display_by_default_dropdown_corporate();
	
	}
	@Test(groups ={"positive","negative"},priority=27 )
	public void BS_27_display_dropdown_List_of_corporate()
	{
		bsp.BS_27_display_dropdown_List_of_corporate();
	
	}
	
	@Test(groups ={"positive","negative"},priority=28 )
	public void BS_28_Select_from_List_of_corporate_dropdown()
	{
		bsp.BS_28_select_from_List_of_corporate_dropdown();
	
	}
	@Test(groups ={"positive","negative"},priority=29 )
	public void BS_29_Click_ok_button_at_popup()
	{
		bsp.BS_29_click_ok_button_at_popup();
	
	}
	@Test(groups ={"positive","negative"},priority=30 )
	public void BS_30_Verify_credit_list_amount()
	{
		bsp.BS_30_verify_credit_list_amount();
	
	}
	@Test(groups ={"positive","negative"},priority=31 )
	public void BS_31_Enter_amount()
	{
		bsp.BS_31_enter_amount();
	
	}
	@Test(groups ={"positive","negative"},priority=32 )
	public void BS_32_enter_amount_moreThan_netAmount()
	{
		bsp.BS_32_enter_amount_moreThan_netAmount();
	
	}
	@Test(groups ={"positive","negative"},priority=33 )
	public void BS_33_Enter_amount_lessThanEqualTo_netAmount()
	{
		bsp.BS_33_enter_amount_lessThanEqualTo_netAmount();
	
	}
	@Test(groups ={"positive","negative"},priority=34 )
	public void BS_34_Enter_amount_lessThan_creditListAmount()
	{
		bsp.BS_34_enter_amount_lessThan_creditListAmount();
	
	}
	@Test(groups ={"positive","negative"},priority=35 )
	public void BS_35_Click_ok_button_display_bill_settlement_page()
	{
		bsp.BS_35_click_ok_button_display_bill_settlement_page();
	
	}
	@Test(groups ={"positive","negative"},priority=36 )
	public void BS_36_Deselect_corporate_and_select()
	{
		bsp.BS_36_deselect_corporate_and_select();
	
	}
	@Test(groups ={"positive","negative"},priority=37 )
	public void BS_37_Click_add_settlement_button_without_select_corporate()
	{
		bsp.BS_37_click_add_settlement_button_without_select_corporate();
	
	}
	@Test(groups ={"positive","negative"},priority=39)
	public void BS_38_select_membership()
	{
		bsp.BS_38_select_membership();
	
	}
	@Test(groups ={"positive","negative"},priority=39 )
	public void BS_39_Display_by_default_select_member_name()
	{
		bsp.BS_39_display_by_default_select_member_name();
	
	}
	@Test(groups ={"positive","negative"},priority=40 )
	public void BS_40_Display_list_of_dropdown_values_member_name()
	{
		bsp.BS_40_display_list_of_dropdown_values_member_name();
	
	}
	@Test(groups ={"positive","negative"},priority=41 )
	public void BS_41_Display_alert_message_after_select_member_name()
	{
		bsp.BS_41_display_alert_message_after_select_member_name();
	
	}
	@Test(groups ={"positive","negative"},priority=42 )
	public void BS_42_Accept_ok_button_of_alert_message_after_select_member_name()
	{
		bsp.BS_42_accept_ok_button_of_alert_message_after_select_member_name();
	
	}
	@Test(groups ={"positive","negative"},priority=43)
	public void BS_43_Display_membership_amount_txtbox_in_disable()
	{
		bsp.BS_43_display_membership_amount_txtbox_in_disable();
	
	}
	@Test(groups ={"positive","negative"},priority=44 )
	public void BS_44_enter_amount_click_add_settlement()
	{
		bsp.BS_44_enter_amount_click_add_settlement();
	}
	@Test(groups ={"positive","negative"},priority=45)
	public void BS_45_Enter_amount_more_than_net_amount_click_add_settlement()
	{
		bsp.BS_45_enter_amount_more_than_net_amount_click_add_settlement();
	}
	@Test(groups ={"positive","negative"},priority=46 )
	public void BS_46_Enter_amount_less_than_or_equal_membership_amount_click_add_settlement()
	{
		bsp.BS_46_enter_amount_less_than_or_equal_membership_amount_click_add_settlement();
	}
	@Test(groups ={"positive","negative"},priority=47 )
	public void BS_47_Enter_amount_more_than__membership_amount_click_add_settlement()
	{
		bsp.BS_47_enter_amount_more_than__membership_amount_click_add_settlement();
	}
	@Test(groups ={"positive","negative"},priority=48 )
	public void BS_48_click_ok_button()
	{
		bsp.BS_48_click_ok_button();
	}
	@Test(groups ={"positive","negative"},priority=49 )
	public void BS_49_deselect_after_select_dropdown_corporate()
	{
		bsp.BS_49_deselect_after_select_dropdown_corporate();
	}
	@Test(groups ={"positive","negative"},priority=50 )
	public void BS_50_Click_add_settlement_without_selelect_member_name()
	{
		bsp.BS_50_click_add_settlement_without_selelect_member_name();
	}



}
