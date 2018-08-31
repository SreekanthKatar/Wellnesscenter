package com.testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pageLibrary.Bill_Settlement;

public class Bill_Settlement_Repository 
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
	
	//--------------------------------------------Wellness HomePage Locators-----------------------------------------------------
			//Application URL
			public String appurl = "http://172.22.5.34:8080/wellness/";
			
			//Staff Login PageURL
			public String Staff_Login_Page_URL = "http://172.22.5.34:8080/wellness/login";
			
			//Page Title
			public String Page_Title = "Wellness Admin";
			
			//Click Here to Login Xpath
			public String Click_here_to_Login_xpath = "/html/body/div/div[2]/div[3]/div[2]/a/div";
			
			//Click Here to Login Xpath
			public String Click_here_to_Login_button_ClassName = "clickheretext";
			
		
			
			//Click Here to Login Text
			public String Click_here_to_Login_Text = "Click here to login";
			
			//WellnessCenter Logo Text
			public String WellnessCenter_Logo_Text = "Wellnesscenter";
			
			//WellnessCenter Logo Text Xpath
			public String WellnessCenter_Logo_Text_xpath = "/html/body/div/div[2]/div[2]/p";
			
			//Wellness Small Logo Above WellnessCenter Text
			public String WellnessCenter_Logo_Image_xpath = "/html/body/div/div[2]/div[1]/img";
		

	@FindBy (className="clickheretext")
	public WebElement loginlink;
	
	@FindBy (name="username")
	public WebElement username;
	
	@FindBy (name="password")
	public WebElement pasword;
	
	@FindBy (xpath="html/body/form/div/div/div/div[2]/div/div/a/input")
	public WebElement login_button;
	
	

	public WebDriver driver = null;
	// To initialize the Driver
	
	
	public  void getdriver() 
	{
		// driver= new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","D:/MyWorkspace/MyAppointment/MyAppointment/src/main/java/com/browser/chromedriver.exe");
		driver= new ChromeDriver();
		//return driver;
				
			}
	
	
	public  void Refresh() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		Thread.sleep(1000);
	}
	

	
	
	public  boolean isAlertPresent()
	{
		 try {
			 driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
	}
	/*------------------Main Method-----------------------------------------------
	 *	
	 if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
		}
		
	 */
	public  boolean isTextPresent(String ExpectedText)
	{
		
		boolean flag = driver.getPageSource().contains(ExpectedText);
		
		
		return flag;
		
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTextPresent("text"))
			{
				s.o.p("textpresented");
			}
	 */
	
	public  boolean isTitlePresent(String ExpectedTitle)
	{
		boolean flag = driver.getTitle().contains(ExpectedTitle);
		
		return flag;
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTitlePresent(ExpectedTitle))
			{
			
				s.o.p("titlepresented");
			}
	 * 
	 */
	
	public boolean isURLPresent(String ExpectedURL)
	{
		boolean flag = driver.getCurrentUrl().contains(ExpectedURL);
		
		return flag;
	}
	/*------------------Main Method-----------------------------------------------
	 *  if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected Staff Login Page Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at Staff Login Page",true);
		 }
		 else{
			 Reporter.log("Staff Login Page URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed Staff Login Page",true);
		 }
	 */
	
	public boolean isDisplayed(WebElement element)
	{
		boolean flag = element.isDisplayed();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDisplayed(element))
		{
			Reporter.log("As expected element is displayed",true);
		}
		else
		{
			Reporter.log("element is not Displayed",true);
		}
	 * 
	 * 
	 */
	public boolean isEnabled(WebElement element)
	{
		boolean flag = element.isEnabled();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEnabled(element))
		{
			Reporter.log("As expected element is enabled",true);
		}
		else
		{
			Reporter.log("element is not enabled",true);
		}
	 */
	public  boolean isSelected(WebElement element)
	{
		boolean flag = element.isSelected();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isSelected(element))
		{
			Reporter.log("As expected element is Selected",true);
		}
		else
		{
			Reporter.log("element is not Selected",true);
		}
	 */
	public  boolean isEmpty(String field)
	{
		boolean flag = field.isEmpty();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEmpty(field))
		{
			Reporter.log("As expected field is Empty",true);
		}
		else
		{
			Reporter.log("element is not empty",true);
		}
	 */
	public  boolean isMatching(String actual_text,String expected_text)
	{
		boolean flag = actual_text.matches(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isMatching(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text matched",true);
		}
		else
		{
			Reporter.log("actual text and expected text not matched",true);
		}
	 */
	public boolean isEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEquals(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text exactly Same",true);
		}
		else
		{
			Reporter.log("actual text and expected text not exactly Same",true);
		}
	 */
	public  boolean isEqualsIgnoreCase(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equalsIgnoreCase(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEqualIgnoreCase(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text Same,but Case sensitive",true);
		}
		else
		{
			Reporter.log("actual text and expected text not Same",true);
		}
	 */
	public  boolean isContains(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contains(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContains(text1,text2))
		{
			Reporter.log("As expected actual text contains expected text",true);
		}
		else
		{
			Reporter.log("actual text not contains expected text",true);
		}
	 */
	public  boolean isContentEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contentEquals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContentEquals(text1,text2))
		{
			Reporter.log("As expected actual text content equals to expected text",true);
		}
		else
		{
			Reporter.log("actual text content not equals to expected text",true);
		}
	 */
	
	public  String isDropdown(WebElement element)
	{
		String tagname = element.getTagName();
		
		return tagname;
	}	
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDropdown(element).equalsIgnoreCase("select"))
		{
			Reporter.log("element is drop down",true);
		}
		else
		{
			Reporter.log("element is not drop down",true);
		}
	 */
	
	public  void Tab() throws AWTException{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
	}
	
	public  String DateandTime()
	{
		Date d= new Date();
		DateFormat dformat= new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		String date = dformat.format(d);
		return date;
	}
	
	
	// To initialize the utils
	public void initutils() 
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
				
		public void OpenApp(){
		driver.navigate().to(appurl);
		Reporter.log("Launch_Application: Wellness Application Launched Successfully", true);
	}
				
		
				
				
		public void closeBrowser() 
		{
			driver.close();
			Reporter.log("Close_Browser: Chrome Browser Closed Successfully", true);
				
		}
				
		public void Click_on_ClickheretoLogin() throws InterruptedException{
			List<WebElement> alllinks = driver.findElements(By.tagName("a"));
			for (WebElement eachlink : alllinks) 
			{
				eachlink.click();
				Thread.sleep(1000);
			}
		}
				public void Valid_login() throws InterruptedException{
	
					Bill_Settlement_Repository s = PageFactory.initElements(driver, Bill_Settlement_Repository.class);
					Thread.sleep(2000);
					s.username.clear();
					s.username.sendKeys("tester1");
					Reporter.log("Entered Valid Username", true);
					 Thread.sleep(1000);
					s.pasword.clear();
					s.pasword.sendKeys("1");
					Reporter.log("Entered Valid Password", true);
					s.login_button.click();
					Reporter.log("Clicked on Login Button", true);
					Thread.sleep(3000);
					String a = driver.getCurrentUrl();
					System.out.println(a);
				}
				
				public void Invalid_login(){
					
				}
				
				public static boolean flag;
				public void Open_Bill_Settlement_Page() throws InterruptedException
				{
					Bill_Settlement_Repository b = PageFactory.initElements(driver, Bill_Settlement_Repository.class);
					
					WebElement AppMenu = driver.findElement(By.xpath(Appointment_Menu_xpath));
					AppMenu.click();
					Reporter.log("Clicked On Appointment Menu",true);
					Thread.sleep(1000);
					Reporter.log("Displayed Options of Appointment Module",true);
					WebElement BillSettlement = driver.findElement(By.xpath(Bill_Settlement_xpath));
					BillSettlement.click();
					Reporter.log("Clicked on Bill Settlement Option",true);
					Thread.sleep(1000);
					Reporter.log("Bill Settlement List Page Displayed",true);
					WebElement table = driver.findElement(By.xpath(WebTable_BillSettlement_Page_xpath));
					WebElement tbody = table.findElement(By.tagName("tbody"));
					List<WebElement> allrows = tbody.findElements(By.tagName("tr"));
					WebElement FirstBillNo = allrows.get(0).findElement(By.tagName("a"));
					String BillNo = FirstBillNo.getText();
					String GuestName = allrows.get(0).findElement(By.xpath("td[3]")).getText();
					String BillAmount = allrows.get(0).findElement(By.xpath("td[4]")).getText();
					if(FirstBillNo.isDisplayed() && FirstBillNo.isEnabled())
					{
						Reporter.log("Record Available for BillNo "+BillNo+" with Guest Name "+GuestName+", and BillAmount is: "+BillAmount,true);
						FirstBillNo.click();
						Reporter.log("Clicked on BillNo "+BillNo+" with Guest Name "+GuestName,true); 
						Reporter.log("Bill Settlement Page Displayed",true);
						
									
					}
					
						Thread.sleep(2000);	
			
					
					WebElement BillID = driver.findElement(By.xpath(Bill_ID_Disable_xpath));
					WebElement BillAmount1 = driver.findElement(By.xpath(Bill_Amount_Disable_xpath));
					WebElement GuestName1 = driver.findElement(By.xpath(Guest_Name_Disable_xapth));
					String BillID_readonly = BillID.getAttribute("readonly");
					String BillAmount_readonly = BillAmount1.getAttribute("readonly");
					String GuestName_readonly = GuestName1.getAttribute("readonly");
					String BillID_value = BillID.getAttribute("value");
					String BillAmount_value = BillAmount1.getAttribute("value");
					String GuestName_value = GuestName1.getAttribute("value");
					
					
					if(BillID_readonly.equals("true")&&BillAmount_readonly.equals("true")&&GuestName_readonly.equals("true"))	
					{
						flag=true;
					}
					if(flag==true){
						Reporter.log("As expected BillID,BillAmount and GuestName text boxes displayed along with values, but these fields are readonly",true);
						Reporter.log("Bill ID value is displayed as: "+BillID_value,true);
						Reporter.log("Bill Amount value is displayed as: "+BillAmount_value,true);
						Reporter.log("Guest Name value is displayed as : "+GuestName_value,true);
					}
					else
					{
						Reporter.log("BillID,BillAmount and GuestName text boxes displayed these fields are enabled",true);
					}
					
				
					
					WebElement PaymentMode = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
					if(b.isDropdown(PaymentMode).equalsIgnoreCase("select"))
					{
						Reporter.log("Payment Mode is Dropdown",true);
					}
					else
					{
						Reporter.log("Payment Mode is Not Dropdown",true);
					}
					Select PM = new Select(PaymentMode);
					PM.selectByIndex(2);
					Reporter.log("Selected Credit Card option at Payment Dropdown",true);
					Thread.sleep(2000);
				
					
					WebElement Name_on_Credit_Card_textbox = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));
					WebElement CreditCard_Number_Textbox = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
					WebElement CreditCardType_Dropdown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
					WebElement addsettlement_button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
					if(b.isDisplayed(Name_on_Credit_Card_textbox))
					{
						Reporter.log("As expected Name on Credit Card text box is displayed after selected Credit Card option at Payment Dropdown",true);
					}
					else
					{
						Reporter.log("Name on Credit Card text box not displayed after selected Credit Card option at Payment Dropdown",true);
					}
					if(b.isDisplayed(CreditCard_Number_Textbox))
					{
						Reporter.log("As expected Credit Card Number text box is displayed after selected Credit Card option at Payment Dropdown",true);
					}
					else
					{
						Reporter.log("Credit Card Number text box not displayed after selected Credit Card option at Payment Dropdown",true);
					}
					if(b.isDisplayed(CreditCardType_Dropdown))
					{
						Reporter.log("As expected Credit Card Type dropdown is displayed after selected Credit Card option at Payment Dropdown",true);
					}
					else
					{
						Reporter.log("Credit Card Type Dropdown not displayed after selected Credit Card option at Payment Dropdown",true);
					}
					if(b.isEnabled(addsettlement_button))
					{
						Reporter.log("As expected Add Settlement button is enabled by default",true);
					}
					else
					{
						Reporter.log("Add Settlement button is not enabled by default",true);
					}
					Assert.assertTrue(b.isDisplayed(Name_on_Credit_Card_textbox) && b.isDisplayed(CreditCard_Number_Textbox) && b.isDisplayed(CreditCardType_Dropdown));
				
					
					WebElement Name = driver.findElement(By.xpath(Name_On_CreditCard_Textbox_xpath));   
					Name.clear();
					Name.sendKeys("Sreekanth Katar");
					Thread.sleep(1000);
					Reporter.log("Entered Sreekanth Katar as Valid Alphabets at Name on Credit Card text box",true);
					WebElement CreditCardNumber = driver.findElement(By.xpath(CreditCard_Number_Textbox_xpath));
					CreditCardNumber.clear();
					CreditCardNumber.sendKeys("4562");
					Thread.sleep(1000);
					Reporter.log("Entered 4562 at Credit Card Number text box",true);
					WebElement Amount = driver.findElement(By.xpath(Amount_Textbox_xpath));
					Amount.clear();
					Amount.sendKeys("1106");
					Thread.sleep(1000);
					Reporter.log("Entered 1106 at Amount text box",true);
					WebElement CreditCardTypeDropDown = driver.findElement(By.xpath(CreditCardType_Dropdown_xpath));
					Select CCT  = new Select(CreditCardTypeDropDown);
					CCT.selectByIndex(2);
					Thread.sleep(1000);
					Reporter.log("Selected Visa option at Credit Card Type Drop Down",true);
					WebElement button = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
					button.click();
					Reporter.log("Clicked on AddSettlement button",true);
					Thread.sleep(1000);
				
					
					if(b.isAlertPresent())
					{
						Reporter.log("Alert Presented",true);
						String message = driver.switchTo().alert().getText();
						Reporter.log(message+" : is displayed at Pop up",true);
						driver.switchTo().alert().accept();
						Reporter.log("Clicked On OK button in Pop up",true);
					}
					else
					{
						Reporter.log("Alert not presented",true);
					}
					Thread.sleep(1000);
				
					
					WebElement table2 = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
					WebElement Save = driver.findElement(By.xpath(Save_Button_xpath));
					WebElement addsettlement_button2 = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
					if(b.isEnabled(addsettlement_button2))
					{
						Reporter.log("Add Settlement button is not disabled, after generated bill amount grid",true);
					}
					else
					{
						Reporter.log("As expected Add Settlement button is disabled, after generated bill amount grid",true);
					}
					if(b.isDisplayed(table2))
					{
						Reporter.log("As expected Bill Amount Web Table is displayed",true);
					}
					else
					{
						Reporter.log("Bill Amount web table is not displayed",true);	
					}
					if(b.isDisplayed(Save))
					{
						Reporter.log("As expected Save button is displayed",true);
					}
					else
					{
						Reporter.log("Save button is not displayed",true);
					}
					if(b.isEnabled(Save))
					{
						Reporter.log("As expected Save button is enabled",true);
					}
					else
					{
						Reporter.log("Save button is not enabled",true);
					}
					
				
					
					
					WebElement table3 = driver.findElement(By.xpath(BillAmount_WebTable_xpath));
					WebElement header = table3.findElement(By.tagName("thead"));
					String headerrow = header.getText();
					Reporter.log("                                           ",true);
					Reporter.log(headerrow,true);
					Reporter.log("----------------------------------------------",true);
					WebElement body = table3.findElement(By.tagName("tbody"));
					 List<WebElement> rows = body.findElements(By.tagName("tr"));
					 for (WebElement eachrow : rows) {
						List<WebElement> Cell = eachrow.findElements(By.tagName("td"));
						for (WebElement Eachcell : Cell) {
							String CellData = Eachcell.getText();
							if(CellData.equals("1106.00")){
								String Cashamount = Cell.get(9).getText();
								Reporter.log("Cash Amount displayed in Bill Amount grid as "+Cashamount,true);
								
							}
											
						}
						
					}
					Reporter.log("                                           ",true);
				  
					WebElement PaymentMode1 = driver.findElement(By.xpath(Payment_Mode_Dropdown_xpath));
					Select PM1 = new Select(PaymentMode1);
					PM1.selectByIndex(3);
					Reporter.log("Selected Cheque option at Payment Dropdown",true);
					Thread.sleep(2000);
				
					
					WebElement BankName = driver.findElement(By.xpath(Bank_Name_textbox_xpath));
					WebElement ChequeNumber = driver.findElement(By.xpath(Cheque_Number_textbox_xpath));
					WebElement ChequePayee = driver.findElement(By.xpath(Cheque_Payee_textbox_xpath));
					WebElement ChequeDate = driver.findElement(By.xpath(Cheque_date_xpath));
					WebElement AddSettlement = driver.findElement(By.xpath(Add_Settlement_Button_xpath));
					if(b.isDisplayed(BankName))
					{
						Reporter.log("As expected Bank Name text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
					}
					else
					{
						Reporter.log("Not displayed Bank Name text box after selected Cheque option at Payment Drop down",true);
					}
					
					if(b.isDisplayed(ChequeNumber))
					{
						Reporter.log("As expected Cheque Number text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
					}
					else
					{
						Reporter.log("Not displayed Cheque Number text box after selected Cheque option at Payment Drop down",true);
					}
					
					if(b.isDisplayed(ChequePayee))
					{
						Reporter.log("As expected Cheque Payee text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
					}
					else
					{
						Reporter.log("Not displayed Cheque Payee text box after selected Cheque option at Payment Drop down",true);
					}
					
					if(b.isDisplayed(ChequeDate))
					{
						Reporter.log("As expected Cheque Date text box is displayed after selected Cheque option at Payment Mode Dropdown",true);
					}
					else
					{
						Reporter.log("Not displayed Cheque Date text box after selected Cheque option at Payment Drop down",true);
					}
					if(b.isEnabled(AddSettlement))
					{
						Reporter.log("As expected AddSettlement button is enabled by default",true);
					}
					else
					{
						Reporter.log("AddSettlement button is not enabled by default",true);
					}
					
					
					Assert.assertTrue(b.isDisplayed(BankName)&&b.isDisplayed(ChequeNumber)&&b.isDisplayed(ChequePayee)&&b.isDisplayed(ChequeDate)&&b.isEnabled(AddSettlement));
				}
				
				
				
				
				
				@BeforeMethod
				public void init() throws InterruptedException{
					getdriver();
					initutils();
					OpenApp();
					Click_on_ClickheretoLogin();
					Valid_login();
					
					
					
					
					
				}
				
				@AfterMethod
				public void tearDown(){
					closeBrowser();
				}
	}




















