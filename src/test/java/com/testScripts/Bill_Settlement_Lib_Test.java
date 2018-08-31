package com.testScripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageLibrary.Bill_Settlement_Lib;
import com.pageLibrary.HomePage;
import com.pageLibrary.Staff_Login;
import com.utils.DriverInitializer;





import java.awt.AWTException;

import org.testng.annotations.Test;


public class Bill_Settlement_Lib_Test 
{
	public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login();
	public static Bill_Settlement_Lib bst = new Bill_Settlement_Lib();

	
//BS_105
  @Test (groups={"positive"},priority=0)
  public void BS_105_Verify_Cash_Option_In_Paymentmode () throws InterruptedException, AWTException {
	  bst.bs_105_verify_cash_option_in_paymentmode();
  }
  //BS_106
  @Test (groups={"positive"},priority=1)
  public void BS_106_Verify_Amount_Accepting_EqualTo_Netamount () throws InterruptedException, AWTException {
	  bst.bs_106_verify_amount_accepting_equalto_netamount();
  }
  //BS_106
  @Test (groups={"negative"},priority=2)
  public void BS_106_Verify_Amount_Accepting_LessThan_Netamount () throws InterruptedException, AWTException {
	  bst.bs_106_verify_amount_accepting_lessthan_netamount();
  }
   //BS_107
  @Test (groups={"negative"},priority=3)
  public void BS_106_Verify_Amount_Accepting_MoreThan_Netamount () throws InterruptedException, AWTException {
	  bst.bs_107_verify_amount_accepting_morethan_netamount();
  }
//BS_115
  @Test (groups={"negative"},priority=4)
  public void BS_115_Verify_Amount_Accepting_Alphabets_Invalid () throws InterruptedException, AWTException {
	  bst.bs_115_verify_amount_accepting_alphabets_Invalid();
  }
  
//BS_115
  @Test (groups={"negative"},priority=5)
  public void BS_115_Verify_Amount_Accepting_AlphaNumerics_Invalid () throws InterruptedException, AWTException {
	  bst.bs_115_verify_amount_accepting_alphanumerics_Invalid();	 
}  
//BS_115
  @Test (groups={"negative"},priority=6)
  public void BS_115_Verify_Amount_Accepting_SpecialCharacters_Invalid () throws InterruptedException, AWTException {
	  bst.bs_115_verify_amount_accepting_specialcharacters_Invalid();	 
}  
  
//BS_116
  @Test (groups={"negative"},priority=7)
  public void BS_116_Verify_Amount_Leaving_Blank_Invalid () throws InterruptedException, AWTException {
	  bst.bs_116_verify_amount_leaving_blank_Invalid(); 
} 

}

