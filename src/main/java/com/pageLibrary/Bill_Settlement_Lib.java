package com.pageLibrary;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageLocators.Bill_Settlement_Locator;
import com.pageLocators.Bill_Settlement_page_Locators;
import com.utils.DriverInitializer;


public class Bill_Settlement_Lib extends Bill_Settlement_Locator
{
	public WebDriver driver = DriverInitializer.getDriver();
	public static boolean flag;
	public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login();
	public static Bill_Settlement_Lib bst = new Bill_Settlement_Lib();
	
	

public void bs_105_verify_cash_option_in_paymentmode() throws InterruptedException {
	Reporter.log("TEST:----->>   << BS_105_Verify_Cash_Option_In_Paymentmode >>  ",true);
	Reporter.log("                                               ",true);
	WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
	appmod.click();
	Reporter.log("Clicked on Appointment Module", true);
	Thread.sleep(1000);
	WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
	billsettlement.click();
	Reporter.log("Clicked on Bill Settlement", true);
	Thread.sleep(2000);
	WebElement webtable = driver.findElement(By.xpath(ListofBills_Web_Table_Xpath));
	WebElement tablebody = webtable.findElement(By.tagName("tbody"));
	List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
	WebElement billno = tablerows.get(0).findElement(By.tagName("a"));
	billno.click();
	Reporter.log("Clicked on first Bill No", true);
	Thread.sleep(1000);
	WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
	Select payment = new Select(paymentmode);
	payment.selectByIndex(4);
	Thread.sleep(2000);
	Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
	Reporter.log("As expected not displaying extra options after selected cash option in paymentmode dropdown",true);
	
}

public void bs_106_verify_amount_accepting_equalto_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	boolean flag3 = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).isDisplayed();
	String readonly = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).getAttribute("readonly");
	Assert.assertTrue(readonly.equals("true"));
	Reporter.log("As expected Bill Amount is Disabled",true);
	//Assert.assertTrue(flag1 == true && flag2 != true && flag3 == true );
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("103");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
    WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
	WebElement gridbody = grid.findElement(By.tagName("tbody"));
	List<WebElement> gridtablerows = gridbody.findElements(By.tagName("tr"));
	List<WebElement> gridtablecolumns = gridtablerows.get(1).findElements(By.tagName("td"));
	WebElement fourthcolumn = gridtablecolumns.get(9);
	String cashamount = fourthcolumn.getText();
	Reporter.log("As expected Amount equal to Net Amount is adding in the grid and cash amount displayed as "+cashamount,true);
	WebElement billamount = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath));
	String bill = billamount.getAttribute("value");
	Assert.assertEquals(bill, cashamount);
	Reporter.log("As expected CashAmount is equal to BillAmount",true);
	WebElement grid2 = driver.findElement(By.xpath(Grid_Xpath));
	String theadtxt = grid2.findElement(By.tagName("thead")).getText();
	Reporter.log(theadtxt,true);
	Reporter.log("-------------------------------------------------------------",true);
	WebElement body = grid2.findElement(By.tagName("tbody"));
	List<WebElement> rows = body.findElements(By.tagName("tr"));
	String BillAmountRow = rows.get(1).getText();
	if(BillAmountRow.contains("103.00")){
		WebElement Row = rows.get(1);
		String cshamt = Row.findElement(By.id("amount")).getText();
		String billid = Row.findElement(By.id("billId")).getText();
		Reporter.log("As expected displayed Cash amount as "+cshamt+" for BillID "+billid,true);
		
	}

	Assert.assertTrue(BillAmountRow.contains("103.00"));
	Reporter.log("As expected accepted, Amount Equal to  Net Amount is adding in the grid",true);	

}

public void bs_106_verify_amount_accepting_lessthan_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	Assert.assertTrue(flag1 == true && flag2 != true);
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("50");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(1000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
	WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
	WebElement head = grid.findElement(By.tagName("thead"));
	String headtxt = head.getText();
	Reporter.log(headtxt,true);
	Reporter.log("-----------------------------------------",true);
	WebElement body = grid.findElement(By.tagName("tbody"));
	List<WebElement> rows = body.findElements(By.tagName("tr"));
	for (WebElement eachrow : rows) 
	{
		List<WebElement> Cell = eachrow.findElements(By.tagName("td"));
		for (WebElement eachcell : Cell) 
		{
			String Celldata = eachcell.getText();
			if(Celldata.equals("50.00"))
			{
				String CashAmount = Cell.get(9).getText();
				Reporter.log(CashAmount+" Record Available in Cash Amount as Expected",true);
				String TypeofPayment = Cell.get(8).getText();
				Reporter.log(TypeofPayment+" Record Available in Type of Payment as Expected",true);
				String GuestName = Cell.get(7).getText();
				Reporter.log(GuestName+" Record Available in Guest Name as Expected",true);
				String BillNo = Cell.get(6).getText();
				Reporter.log(BillNo+" Record Available in Bill No as Expected",true);
			}
		
			
		}
		
	}
	
	WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
	Select payment = new Select(paymentmode);
	payment.selectByIndex(4);
	Thread.sleep(2000);
	Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
	WebElement amount1 = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount1.clear();
	amount1.sendKeys("53");
	WebElement addsettlement1 = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement1.click();
	Thread.sleep(1000);
    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
    Reporter.log("Bill Amount Grid is displayed",true);
	WebElement grid1 = driver.findElement(By.xpath(Grid_Xpath));
	WebElement head1 = grid1.findElement(By.tagName("thead"));
	String headtxt1 = head1.getText();
	Reporter.log(headtxt1,true);
	Reporter.log("-----------------------------------------",true);
	WebElement body1 = grid1.findElement(By.tagName("tbody"));
	List<WebElement> rows1 = body1.findElements(By.tagName("tr"));
	for (WebElement eachrow1 : rows1) 
	{
		List<WebElement> Cells = eachrow1.findElements(By.tagName("td"));
		for (WebElement eachcell1 : Cells) 
		{
			String Celldata1 = eachcell1.getText();
			if(Celldata1.equals("53.00"))
			{
				String CashAmount1 = Cells.get(9).getText();
				Reporter.log(CashAmount1+" Record Available in Cash Amount as Expected",true);
				String TypeofPayment1 = Cells.get(8).getText();
				Reporter.log(TypeofPayment1+" Record Available in Type of Payment as Expected",true);
				String GuestName1 = Cells.get(7).getText();
				Reporter.log(GuestName1+" Record Available in Guest Name as Expected",true);
				String BillNo1 = Cells.get(6).getText();
				Reporter.log(BillNo1+" Record Available in Bill No as Expected",true);
			}
		
			
		}
		
	}
	  
	String fr_billno = driver.findElement(By.xpath(FirstRow_BillNo_xpath)).getText();
	String Sr_billno = driver.findElement(By.xpath(SecondRow_BillNo_xpath)).getText();
	String fr_guest = driver.findElement(By.xpath(FirstRow_GuestName_xpath)).getText();
	String Sr_guest = driver.findElement(By.xpath(SecondRow_GuestName_xpath)).getText();
	String fr_top = driver.findElement(By.xpath(FirstRow_TypeofPayment_xpath)).getText();
	String Sr_top = driver.findElement(By.xpath(SecondRow_TypeofPayment_xpath)).getText();
	String fr_cashamt = driver.findElement(By.xpath(FirstRow_CashAmount_xpath)).getText();
	String Sr_cashamt = driver.findElement(By.xpath(SecondRow_CashAmount_xpath)).getText();
	int a = Double.valueOf(fr_cashamt).intValue();
	int b = Double.valueOf(Sr_cashamt).intValue();
	int Total_Cashamount = a+b;
	Assert.assertTrue(fr_billno.equals(Sr_billno)&&(fr_guest.equals(Sr_guest))&&(fr_top.equals(Sr_top)));
	Assert.assertEquals(fr_cashamt, "50.00");
	Assert.assertEquals(Sr_cashamt, "53.00");
	Reporter.log("Total Cash Amount at grid :"+Total_Cashamount,true);
	Reporter.log("Bill No, Guest Name and Type of Payment are Displayed both rows as Same in the grid",true);
	Reporter.log("As expected Amount less than Net Amount is adding in the grid",true);	
}

public void bs_107_verify_amount_accepting_morethan_netamount() throws InterruptedException{
	boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
	boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
	Assert.assertTrue(flag1 == true && flag2 != true);
	Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
	String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
	Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("200");
	String amountentered = driver.findElement(By.xpath(Amount_Textbox_Xpath)).getAttribute("value");
	Reporter.log(amountentered+" Amount entered at Amount Textbox",true);
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Alert alert = driver.switchTo().alert();
	Thread.sleep(1000);
	String text = alert.getText();
	Reporter.log("As expected displayed" +text+" dispalyed at Pop up",true);
	Reporter.log("As expected  not accepted more than Net Amount",true);
	alert.accept();
	Thread.sleep(1000);
    WebElement table = driver.findElement(By.xpath(Grid_Xpath));
    WebElement tbody = table.findElement(By.tagName("tbody"));
    String tbodytxt = tbody.getText();
    Assert.assertTrue(tbodytxt.isEmpty());
    Reporter.log("As expected Bill Amount Grid is not displayed",true);
	
}

public void bs_115_verify_amount_accepting_alphabets_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("abcd");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Alert alert = driver.switchTo().alert();
	String alertmsg = alert.getText();
	alert.accept();
	Thread.sleep(5000);
	Assert.assertEquals(alertmsg, "Please Enter valid amount ");
	Reporter.log(alertmsg,true);
	Reporter.log("As expected not allowed to enter Alphabets" + alertmsg,true);	
}

public void bs_115_verify_amount_accepting_alphanumerics_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("abc1234");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	if(DriverInitializer.isAlertPresent())
	{
		Reporter.log("Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		Reporter.log(" Should not allow to enter Alphabets",true);
	}
	else
	{
		Reporter.log("As expected Alert not presented and not allowing to enter Alphabets",true);
	}		Thread.sleep(5000);
	Assert.assertFalse(DriverInitializer.isAlertPresent());
}

public void bs_115_verify_amount_accepting_specialcharacters_Invalid() throws InterruptedException{
	WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	amount.clear();
	amount.sendKeys("*(@*#");
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	if(DriverInitializer.isAlertPresent())
	{
		Reporter.log("Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);
		Reporter.log(" Should not allow to enter Special Characters",true);
	}
	else
	{
		Reporter.log("As expected Alert not presented and not allowing to enter Special Characters",true);
	}		Thread.sleep(5000);
	Assert.assertFalse(DriverInitializer.isAlertPresent());
}

public void bs_116_verify_amount_leaving_blank_Invalid() throws InterruptedException
{
	
	//WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
	WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
	addsettlement.click();
	Thread.sleep(2000);
	Assert.assertTrue(DriverInitializer.isAlertPresent());	
	boolean flag = true;
	if(flag==true) 
	{
		Reporter.log("As Expected Alert Presented",true);
		String message = driver.switchTo().alert().getText();
		Reporter.log(message+" : is displayed at Pop up",true);
		driver.switchTo().alert().accept();
		Reporter.log("Clicked On OK button in Pop up",true);

	}
	else
	{
		Reporter.log(" Alert not presented",true);
	}
	Thread.sleep(2000);

}








/*public class Bill_Settlement extends Bill_Settlement_Locator {
	
	public  WebDriver driver = DriverInitializer.getDriver();
	public void bs_105_verify_cash_option_in_paymentmode() throws InterruptedException {
		Reporter.log("TEST:----->>   << BS_105_Verify_Cash_Option_In_Paymentmode >>  ",true);
		Reporter.log("                                               ",true);
		WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
		appmod.click();
		Reporter.log("Clicked on Appointment Module", true);
		Thread.sleep(1000);
		WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
		billsettlement.click();
		Reporter.log("Clicked on Bill Settlement", true);
		Thread.sleep(2000);
		WebElement webtable = driver.findElement(By.xpath(ListofBills_Web_Table_Xpath));
		WebElement tablebody = webtable.findElement(By.tagName("tbody"));
		List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
		WebElement billno = tablerows.get(0).findElement(By.tagName("a"));
		billno.click();
		Reporter.log("Clicked on first Bill No", true);
		Thread.sleep(1000);
		WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
		Select payment = new Select(paymentmode);
		payment.selectByIndex(4);
		Thread.sleep(2000);
		Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
		Reporter.log("As expected not displaying extra options after selected cash option in paymentmode dropdown",true);
		
	}
	
	public void bs_106_verify_amount_accepting_equalto_netamount() throws InterruptedException{
		boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
		boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
		boolean flag3 = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).isDisplayed();
		String readonly = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath)).getAttribute("readonly");
		Assert.assertTrue(readonly.equals("true"));
		Reporter.log("As expected Bill Amount is Disabled",true);
		//Assert.assertTrue(flag1 == true && flag2 != true && flag3 == true );
		Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
		String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
		Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("103");
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Thread.sleep(2000);
	    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
	    Reporter.log("Bill Amount Grid is displayed",true);
	    WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
		WebElement gridbody = grid.findElement(By.tagName("tbody"));
		List<WebElement> gridtablerows = gridbody.findElements(By.tagName("tr"));
		List<WebElement> gridtablecolumns = gridtablerows.get(1).findElements(By.tagName("td"));
		WebElement fourthcolumn = gridtablecolumns.get(9);
		String cashamount = fourthcolumn.getText();
		Reporter.log("As expected Amount equal to Net Amount is adding in the grid and cash amount displayed as "+cashamount,true);
		WebElement billamount = driver.findElement(By.xpath(Bill_Amount_Disable_Xpath));
		String bill = billamount.getAttribute("value");
		Assert.assertEquals(bill, cashamount);
		Reporter.log("As expected CashAmount is equal to BillAmount",true);
		WebElement grid2 = driver.findElement(By.xpath(Grid_Xpath));
		String theadtxt = grid2.findElement(By.tagName("thead")).getText();
		Reporter.log(theadtxt,true);
		Reporter.log("-------------------------------------------------------------",true);
		WebElement body = grid2.findElement(By.tagName("tbody"));
		List<WebElement> rows = body.findElements(By.tagName("tr"));
		String BillAmountRow = rows.get(1).getText();
		if(BillAmountRow.contains("103.00")){
			WebElement Row = rows.get(1);
			String cshamt = Row.findElement(By.id("amount")).getText();
			String billid = Row.findElement(By.id("billId")).getText();
			Reporter.log("As expected displayed Cash amount as "+cshamt+" for BillID "+billid,true);
			
		}
	
		Assert.assertTrue(BillAmountRow.contains("103.00"));
		Reporter.log("As expected accepted, Amount Equal to  Net Amount is adding in the grid",true);	
	
	}
	
	public void bs_106_verify_amount_accepting_lessthan_netamount() throws InterruptedException{
		boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
		boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
		Assert.assertTrue(flag1 == true && flag2 != true);
		Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
		String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
		Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("50");
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
	    Reporter.log("Bill Amount Grid is displayed",true);
		WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
		WebElement head = grid.findElement(By.tagName("thead"));
		String headtxt = head.getText();
		Reporter.log(headtxt,true);
		Reporter.log("-----------------------------------------",true);
		WebElement body = grid.findElement(By.tagName("tbody"));
		List<WebElement> rows = body.findElements(By.tagName("tr"));
		for (WebElement eachrow : rows) 
		{
			List<WebElement> Cell = eachrow.findElements(By.tagName("td"));
			for (WebElement eachcell : Cell) 
			{
				String Celldata = eachcell.getText();
				if(Celldata.equals("50.00"))
				{
					String CashAmount = Cell.get(9).getText();
					Reporter.log(CashAmount+" Record Available in Cash Amount as Expected",true);
					String TypeofPayment = Cell.get(8).getText();
					Reporter.log(TypeofPayment+" Record Available in Type of Payment as Expected",true);
					String GuestName = Cell.get(7).getText();
					Reporter.log(GuestName+" Record Available in Guest Name as Expected",true);
					String BillNo = Cell.get(6).getText();
					Reporter.log(BillNo+" Record Available in Bill No as Expected",true);
				}
			
				
			}
			
		}
		
		WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
		Select payment = new Select(paymentmode);
		payment.selectByIndex(4);
		Thread.sleep(2000);
		Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
		WebElement amount1 = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount1.clear();
		amount1.sendKeys("53");
		WebElement addsettlement1 = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement1.click();
		Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.xpath(Grid_Xpath)).isDisplayed());
	    Reporter.log("Bill Amount Grid is displayed",true);
		WebElement grid1 = driver.findElement(By.xpath(Grid_Xpath));
		WebElement head1 = grid1.findElement(By.tagName("thead"));
		String headtxt1 = head1.getText();
		Reporter.log(headtxt1,true);
		Reporter.log("-----------------------------------------",true);
		WebElement body1 = grid1.findElement(By.tagName("tbody"));
		List<WebElement> rows1 = body1.findElements(By.tagName("tr"));
		for (WebElement eachrow1 : rows1) 
		{
			List<WebElement> Cells = eachrow1.findElements(By.tagName("td"));
			for (WebElement eachcell1 : Cells) 
			{
				String Celldata1 = eachcell1.getText();
				if(Celldata1.equals("53.00"))
				{
					String CashAmount1 = Cells.get(9).getText();
					Reporter.log(CashAmount1+" Record Available in Cash Amount as Expected",true);
					String TypeofPayment1 = Cells.get(8).getText();
					Reporter.log(TypeofPayment1+" Record Available in Type of Payment as Expected",true);
					String GuestName1 = Cells.get(7).getText();
					Reporter.log(GuestName1+" Record Available in Guest Name as Expected",true);
					String BillNo1 = Cells.get(6).getText();
					Reporter.log(BillNo1+" Record Available in Bill No as Expected",true);
				}
			
				
			}
			
		}
		  
		String fr_billno = driver.findElement(By.xpath(FirstRow_BillNo_xpath)).getText();
		String Sr_billno = driver.findElement(By.xpath(SecondRow_BillNo_xpath)).getText();
		String fr_guest = driver.findElement(By.xpath(FirstRow_GuestName_xpath)).getText();
		String Sr_guest = driver.findElement(By.xpath(SecondRow_GuestName_xpath)).getText();
		String fr_top = driver.findElement(By.xpath(FirstRow_TypeofPayment_xpath)).getText();
		String Sr_top = driver.findElement(By.xpath(SecondRow_TypeofPayment_xpath)).getText();
		String fr_cashamt = driver.findElement(By.xpath(FirstRow_CashAmount_xpath)).getText();
		String Sr_cashamt = driver.findElement(By.xpath(SecondRow_CashAmount_xpath)).getText();
		int a = Double.valueOf(fr_cashamt).intValue();
		int b = Double.valueOf(Sr_cashamt).intValue();
		int Total_Cashamount = a+b;
		Assert.assertTrue(fr_billno.equals(Sr_billno)&&(fr_guest.equals(Sr_guest))&&(fr_top.equals(Sr_top)));
		Assert.assertEquals(fr_cashamt, "50.00");
		Assert.assertEquals(Sr_cashamt, "53.00");
		Reporter.log("Total Cash Amount at grid :"+Total_Cashamount,true);
		Reporter.log("Bill No, Guest Name and Type of Payment are Displayed both rows as Same in the grid",true);
		Reporter.log("As expected Amount less than Net Amount is adding in the grid",true);	
	}
	
	public void bs_107_verify_amount_accepting_morethan_netamount() throws InterruptedException{
		boolean flag1 = driver.findElement(By.xpath(Net_Amount_Xpath)).isDisplayed();
		boolean flag2 = driver.findElement(By.xpath(Net_Amount_Xpath)).isEnabled();
		Assert.assertTrue(flag1 == true && flag2 != true);
		Reporter.log("As expected NetAmount Textbox displayed and disabled by default",true);
		String netamount = driver.findElement(By.xpath(Net_Amount_Xpath)).getAttribute("value");
		Reporter.log(netamount+" Amount displayed at Net Amount Textbox by default",true);
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("200");
		String amountentered = driver.findElement(By.xpath(Amount_Textbox_Xpath)).getAttribute("value");
		Reporter.log(amountentered+" Amount entered at Amount Textbox",true);
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		String text = alert.getText();
		Reporter.log("As expected displayed" +text+" dispalyed at Pop up",true);
		Reporter.log("As expected  not accepted more than Net Amount",true);
		alert.accept();
		Thread.sleep(1000);
	    WebElement table = driver.findElement(By.xpath(Grid_Xpath));
	    WebElement tbody = table.findElement(By.tagName("tbody"));
	    String tbodytxt = tbody.getText();
	    Assert.assertTrue(tbodytxt.isEmpty());
	    Reporter.log("As expected Bill Amount Grid is not displayed",true);
		
	}
	public void bs_115_verify_amount_accepting_alphabets_Invalid() throws InterruptedException{
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("abcd");
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		alert.accept();
		Thread.sleep(5000);
		Assert.assertEquals(alertmsg, "Please Enter valid amount ");
		Reporter.log(alertmsg,true);
		Reporter.log("As expected not allowed to enter Alphabets" + alertmsg,true);	
	}
	
	public void bs_115_verify_amount_accepting_alphanumerics_Invalid() throws InterruptedException{
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("abc1234");
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Thread.sleep(2000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
			Reporter.log(" Should not allow to enter Alphabets",true);
		}
		else
		{
			Reporter.log("As expected Alert not presented and not allowing to enter Alphabets",true);
		}		Thread.sleep(5000);
		Assert.assertFalse(DriverInitializer.isAlertPresent());
	}
	
	public void bs_115_verify_amount_accepting_specialcharacters_Invalid() throws InterruptedException{
		WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		amount.clear();
		amount.sendKeys("*(@*#");
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Thread.sleep(2000);
		if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
			Reporter.log(" Should not allow to enter Special Characters",true);
		}
		else
		{
			Reporter.log("As expected Alert not presented and not allowing to enter Special Characters",true);
		}		Thread.sleep(5000);
		Assert.assertFalse(DriverInitializer.isAlertPresent());
	}
	
	public void bs_116_verify_amount_leaving_blank_Invalid() throws InterruptedException
	{
		
		//WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
		WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
		addsettlement.click();
		Thread.sleep(2000);
		Assert.assertTrue(DriverInitializer.isAlertPresent());	
		boolean flag = true;
		if(flag==true) 
		{
			Reporter.log("As Expected Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
	
		}
		else
		{
			Reporter.log(" Alert not presented",true);
		}
		Thread.sleep(2000);
	
	}
	/*public void bs_117_verify_GiftVoucher_Option_in_paymentmode() throws InterruptedException {
		Reporter.log("TEST:----->>   << BS_117_Verify_GiftVoucher_Option_In_Paymentmode >>  ",true);
		Reporter.log("                                               ",true);
		WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
		appmod.click();
		Reporter.log("Clicked on Appointment Module", true);
		Thread.sleep(1000);
		WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
		billsettlement.click();
		Reporter.log("Clicked on Bill Settlement", true);
		Thread.sleep(2000);
		WebElement webtable = driver.findElement(By.xpath(ListofBills_Web_Table_Xpath));
		WebElement tablebody = webtable.findElement(By.tagName("tbody"));
		List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
		WebElement billno = tablerows.get(0).findElement(By.tagName("a"));
		billno.click();
		Reporter.log("Clicked on first Bill No", true);
		Thread.sleep(1000);
		WebElement paymentmode = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
		Select payment = new Select(paymentmode);
		payment.selectByIndex(4);
		Thread.sleep(2000);
		Reporter.log("Selected Cash Option in Payment Mode Dropdown", true);
		Reporter.log("As expected not displaying extra options after selected cash option in paymentmode dropdown",true);
		
	}
	public void bs_117_verify_GiftVoucher_Option_in_paymentmode() throws InterruptedException 
	{
		Reporter.log("TEST:----->>   << BS_117_Verify_GiftVoucher_Option_In_Paymentmode >>  ",true);
		Reporter.log("                                               ",true);
	{
		try 
		{
			WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
			appmod.click();
			Reporter.log("Clicked on Appointment Module", true);
			Thread.sleep(1000);
			WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
			billsettlement.click();
			Reporter.log("Clicked on Bill Settlement", true);
			Thread.sleep(2000);
			 //driver.navigate().back();
			// Thread.sleep(1000);
			 WebElement bill_no_link = driver.findElement(By.xpath(bill_no_xpath));
			 bill_no_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Bill No. link is clicked",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(8);
			 WebElement value = select.getFirstSelectedOption();
			 String option = value.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement giftvoucherid_label = driver.findElement(By.xpath(gift_voucher_id_xpath));
			 String giftvoucher_label = giftvoucherid_label.getText();
			 Reporter.log(giftvoucher_label,true);
			 Assert.assertEquals(giftvoucher_label,gift_voucher_id_label_txt);
			WebElement giftvoucheramount_label = driver.findElement(By.xpath(gift_voucher_amount_xpath));
			 String giftvoucheramt_label = giftvoucheramount_label.getText();
			 Reporter.log(giftvoucheramt_label,true);
			 Assert.assertEquals(giftvoucheramt_label,giftvoucheramount_label);
			 Reporter.log("System displaying related Payment Mode options in Bill Settlement Page",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	
	}
	public void bs_118_verify_GiftVoucher_amount_display() throws InterruptedException 
	{
		Reporter.log("TEST:----->>   << BS_117_Verify_GiftVoucher_Amount_Display >>  ",true);
		Reporter.log("                                               ",true);
	{
		try 
		{
			WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
			appmod.click();
			Reporter.log("Clicked on Appointment Module", true);
			Thread.sleep(1000);
			WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
			billsettlement.click();
			Reporter.log("Clicked on Bill Settlement", true);
			Thread.sleep(2000);
			 //driver.navigate().back();
			// Thread.sleep(1000);
			 WebElement bill_no_link = driver.findElement(By.xpath(bill_no_xpath));
			 bill_no_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Bill No. link is clicked",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(8);
			 WebElement value = select.getFirstSelectedOption();
			 String option = value.getText();
			 Reporter.log(option,true);
			 Thread.sleep(3000);
			 WebElement gift_voucher_id_textbox = driver.findElement(By.xpath(gift_voucher_id_textbox_xpath));
			 gift_voucher_id_textbox.clear();
			 gift_voucher_id_textbox.sendKeys("26");
			 gift_voucher_id_textbox.click();
			 Thread.sleep(3000);
			WebElement amount = driver.findElement(By.xpath(Amount_Textbox_Xpath));
			amount.clear();
			amount.sendKeys("1000");
			WebElement addsettlement = driver.findElement(By.xpath(Add_Settlement_Xpath));
			addsettlement.click();
			WebElement grid = driver.findElement(By.xpath(Grid_Xpath));
			WebElement thead = driver.findElement(By.tagName("thead"));
			WebElement row = thead.findElement(By.tagName("tr"));
			String header = row.getText();
			Reporter.log(header,true);
			WebElement tbody = grid.findElement(By.tagName("tbody"));
		    WebElement rowtbody = tbody.findElement(By.tagName("tr")).get;
			List<WebElement> cols = rowtbody.findElements(By.tagName("td[10]"));
			for (WebElement eachcol : cols) {
				String values = eachcol.getText();
				Reporter.log(values,true);
				
			}
			 
			 Reporter.log("Displaying Gift Voucher Id amount in Gift Voucher Amount field",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	
	}
	
	public void bs_119_verify_GiftVoucher_InvalidId_amount_display() throws InterruptedException 
	{
		Reporter.log("TEST:----->>   << BS_119_Verify_GiftVoucher_InvalidId_Amount_Display >>  ",true);
		Reporter.log("                                               ",true);
	{
		try 
		{
			WebElement appmod = driver.findElement(By.xpath(Appointment_Module_Xpath));
			appmod.click();
			Reporter.log("Clicked on Appointment Module", true);
			Thread.sleep(1000);
			WebElement billsettlement = driver.findElement(By.xpath(Bill_Settlement_Xpath));
			billsettlement.click();
			Reporter.log("Clicked on Bill Settlement", true);
			Thread.sleep(2000);
			 //driver.navigate().back();
			// Thread.sleep(1000);
			 WebElement bill_no_link = driver.findElement(By.xpath(bill_no_xpath));
			 bill_no_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Bill No. link is clicked",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.xpath(Payment_Mode_Dropdown_Xpath));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(8);
			 WebElement value = select.getFirstSelectedOption();
			 String option = value.getText();
			 Reporter.log(option,true);
			 Thread.sleep(3000);
			 WebElement gift_voucher_id_textbox = driver.findElement(By.xpath(gift_voucher_id_textbox_xpath));
			 gift_voucher_id_textbox.clear();
			 gift_voucher_id_textbox.sendKeys("30");
			 gift_voucher_id_textbox.click();
			 WebElement gift_voucher_txtbox = driver.findElement(By.xpath(gift_voucher_amount_textbox_xpath));
			 Thread.sleep(2000);
			 boolean flag = gift_voucher_txtbox.isDisplayed();
			 //System.out.println(flag);
			 Assert.assertEquals(flag,true);
			WebElement giftvoucheramount_label = driver.findElement(By.xpath(gift_voucher_amount_xpath));
			 String giftvoucheramt_label = giftvoucheramount_label.getText();
			 Reporter.log(giftvoucheramt_label,true);
			 Assert.assertEquals(giftvoucheramt_label,giftvoucheramount_label);
			 Reporter.log("Displaying Zero in Gift Voucher Amount field if Gift Voucher Id doesn't exist",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}*/
	
	}



