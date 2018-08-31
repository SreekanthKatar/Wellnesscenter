package com.testScripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.pageLibrary.HomePage;



public class HomePage_Test 
{
	
	public static HomePage hp = new HomePage();
 
  //HP_01: Verify Home Page
  @Test (groups ={"positive","negative"},priority=0)
  public void HP_01_Verify_HomePage() throws InterruptedException {
	 
	  hp.hp_01_HomePage();
	 
  }
  
  /*//HP_02: Verify UI
  @Test (groups ={"positive","positive"},priority=1)
  public void HP_02_Verify_UI() throws InterruptedException {
	
	  hp.hp_02_UI();
	  
  }
  
  //HP_03: Verify Staff Login Page after Clicked on Click here To Login 
  @Test (groups ={"positive"},priority=2)
  public void HP_03_Verify_Click_here_to_login_button() throws InterruptedException {
	
	  hp.hp_03_ClickHereToLoginButton();
  }*/
  
  //HP_04: Verify Staff Login Page after Clicked on Click here To Login 
  @Test (groups ={"positive"},priority=3)
  public void HP_04_Verify_StaffLoginPage() throws InterruptedException {
	 
	  hp.hp_04_ClickHereToLogin();
	  Thread.sleep(3000);
  }
  
  
  @BeforeSuite
  public void Launch_Browser() throws InterruptedException
  {
	hp.LaunchChromeBrowser(); 
	
  }
  
  @AfterSuite
  public void Close_Browser()
  {
	hp.CloseChromeBrowser();  
  }
  
 
}
