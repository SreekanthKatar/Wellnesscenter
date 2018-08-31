package com.testScripts;


import java.awt.AWTException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageLibrary.HomePage;
import com.pageLibrary.Staff_Login;


public class Staff_Login_Test {
    public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login();

	/*//SL_01
  @Test (groups ={"positive"},priority=0)
  public void SL_01_Verify_Staff_Login_Page() throws InterruptedException 
  {
	  sl.sl_01_loginpage();
	
  }
  
  //SL_02
  @Test (groups ={"positive"},priority=1)
  public void SL_02_Verify_Main_Heading() throws InterruptedException 
  {
	  sl.sl_02_Verify_MainHeading();
	  Thread.sleep(3000);
  }
  
  //SL_03
  @Test (groups ={"positive"},priority=2)
  public void SL_03_Verify_LoginButton() throws InterruptedException 
  {
	  sl.sl_03_verifyLoginbutton();
	  Thread.sleep(3000);
  }
  
  //SL_04
  @Test (groups ={"negative"},priority=3)
  public void SL_04_Verify_Login_Invaild_Username_Invalid_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_04_Verify_Staff_Login_InValid_Username_InValid_Password();
  }
  
  //SL_05
  @Test (groups ={"negative"},priority=4)
  public void SL_05_Verify_Login_Vaild_Username_Invalid_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_05_Verify_Staff_Login_Valid_Username_InValid_Password();
  }
  
  //SL_06
  @Test (groups ={"negative"},priority=5)
  public void SL_06_Verify_Login_Invaild_Username_Valid_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_06_Verify_Staff_Login_InValid_Username_Valid_Password();
  }
  
  //SL_07
  @Test (groups ={"negative"},priority=6)
  public void SL_07_Verify_Login_Vaild_Username_Blank_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_07_Verify_Staff_Login_Valid_Username_Blank_Password();
  }
  
  //SL_08
  @Test (groups ={"negative"},priority=7)
  public void SL_08_Verify_Login_Blank_Username_Valid_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_08_Verify_Staff_Login_Blank_Username_Valid_Password();
  }
  
  //SL_09
  @Test (groups ={"negative"},priority=8)
  public void SL_09_Verify_Login_Blank_Username_Blank_Password() throws InterruptedException, AWTException 
  {
	  sl.sl_09_Verify_Staff_Login_Blank_Username_Blank_Password();
  }
  
  //SL_10
  @Test (groups ={"positive"},priority=9)
  public void SL_10_Verify_Password_Visibility() throws InterruptedException 
  {
	  sl.sl_10_Verify_Password_visibility();
  }*/
  
  //SL_11
  @Test (groups ={"positive"},priority=10)
  public void SL_11_Verify_Login_Valid_Username_Valid_Password() throws InterruptedException 
  {
	  sl.sl_11_Verify_Staff_Login_Valid_Username_Valid_Password();
  }
  
  
 
  
  
 
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
