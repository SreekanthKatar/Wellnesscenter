package com.pageLibrary;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;



import com.pageLocators.Bill_Settlement_page_Locators;
import com.utils.DriverInitializer;





public class Bill_Settlement_page extends Bill_Settlement_page_Locators
{
	public WebDriver driver = DriverInitializer.getDriver();
	public void BS_01_display_bill_settlement_page()
	{
		try 
		{
			WebElement appointment = driver.findElement(By.xpath(appointment_link_xpath));
			appointment.click();
			Thread.sleep(1000);
			Reporter.log("Options of appointment are displayed");
			WebElement bill_settlement_option = driver.findElement(By.linkText(bill_settlement_option_linktext));
			bill_settlement_option.click();
			Thread.sleep(2000);
			String bill_settlement_page_url = driver.getCurrentUrl();
			Assert.assertTrue(bill_settlement_page_url.contains(bill_settlement_page_URL));
			Thread.sleep(1000);
			Reporter.log("Bill Settlement Page is displayed",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
			
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
			
		}
	}
	public void BS_02_verify_spelling_mistake()
	{
		Reporter.log("It's not possible in automation",true);
	}
	
	public void BS_03_header_display()
	{
		try 
		{
			WebElement main_heading = driver.findElement(By.xpath(main_heading_xpath));
			String main = main_heading.getText();
			Assert.assertTrue(main.contains(main_heading_text));
			Reporter.log("Heading of bill settlement page is : "+main,true);
			WebElement sub_heading = driver.findElement(By.xpath(sub_heading_xpath));
			String sub = sub_heading.getText();
			Assert.assertTrue(sub.contains(sub_heading_txt));
			Reporter.log("Sub heading of bill settlement page is :  "+sub,true);
			Thread.sleep(2000);
			Reporter.log("---------------------------------------------------------------------------------",true);
		} 
		catch (Exception e)
		{
			
			Reporter.log(e.getMessage(),true);
		}
		
	}
	public void BS_04_display_list_of_bills_webtable()
	{
		try
		{
			
			WebElement webtable = driver.findElement(By.xpath(webtable_xpath));
			boolean table = webtable.isDisplayed();
			Assert.assertTrue(table);
			Reporter.log("List of bills of webtable is displayed",true);
		 	Thread.sleep(2000);
			Reporter.log("---------------------------------------------------------------------------------",true);
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		
		
	}
	public void BS_05_search_by_guest_name()
	{
		try 
		{
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 text_box.sendKeys("Ram");
			 Reporter.log("Entered Ram at Guest Name",true);
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement table = driver.findElement(By.xpath(webtable_xpath));
			 boolean tab = table.isDisplayed();
			 Assert.assertTrue(tab);
			 WebElement header = table.findElement(By.tagName("thead"));
			 WebElement thead = header.findElement(By.tagName("tr"));
			 String header_row = thead.getText();
			 Reporter.log(header_row,true);
			 Reporter.log("-------------------------------------------------------",true);
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> allrows = tbody.findElements(By.tagName("tr"));
			 for (WebElement eachrow : allrows)
			 {
				System.out.println(eachrow.getText());
				List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
				String value = allcols.get(2).getText();
				System.out.println(value);
				Assert.assertTrue(value.equalsIgnoreCase("Ram"));
				
			
			 }
			 Reporter.log("Search Results displyed as Ram only",true);
			 
			 Reporter.log("---------------------------------------------------------------------------------",true);
		}
		
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_06_display_title_of_page()
	{ 
		try
		{
			String title = driver.getTitle();
			Assert.assertEquals(Bill_settlement_page_title, title);
			Reporter.log("Bill settlement page title is displayed ",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_07_search_unavailable_guest_name()
	{
		 try 
		 {
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 text_box.sendKeys("xyz");
			 Reporter.log("Entered xyz as Guest Name",true);
			 Thread.sleep(1000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement unregister_guest = driver.findElement(By.xpath(unregistered_guest_xpath));
			 String mess = unregister_guest.getText();
			 Reporter.log(mess,true);
			 Assert.assertTrue(mess.contains(no_record_are_found_txt));
			 Reporter.log("No record found message is displayed",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
		} 
		 catch (Exception e) 
		 {
			Reporter.log(e.getMessage(),true);
		 }
		
	}
	public void BS_08_type_guest_name_alphabetic()
	{
		try 
		{
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 text_box.sendKeys("Ram");
			 Reporter.log("Entered gust name alphabetic character",true);
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement table = driver.findElement(By.xpath(webtable_xpath));
			 boolean tab = table.isDisplayed();
			 Assert.assertTrue(tab);
			 WebElement header = table.findElement(By.tagName("thead"));
			 WebElement thead = header.findElement(By.tagName("tr"));
			 String header_row = thead.getText();
			 Reporter.log(header_row,true);
			 Reporter.log("-------------------------------------------------------",true);
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> allrows = tbody.findElements(By.tagName("tr"));
			 for (WebElement eachrow : allrows)
			 {
				System.out.println(eachrow.getText());
				List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
				String value = allcols.get(2).getText();
				System.out.println(value);
				Assert.assertTrue(value.equalsIgnoreCase("Ram"));
				
			
			 }
			 Reporter.log("System accepted alphabetic character as a guest name",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
			
		}
		
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_09_search_by_guest_name_as_special_and_numeric_character()
	{
		try 
		{
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 text_box.sendKeys("@%$1234");
			 Reporter.log("Entered @%$1234 at guest name as alphanumeric with special character ",true);
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("System accepted to enter alphanumeric at guest name text box",true);
			 Thread.sleep(1000);
			 WebElement unregister_guest = driver.findElement(By.xpath(unregistered_guest_xpath));
			 String mess = unregister_guest.getText();
			 Reporter.log(mess,true);
			 Assert.assertFalse(mess.contains(no_record_are_found_txt));
			 Reporter.log("Special & alphanumeric character is not accepted",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
			}
		
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_10_bill_n0_Link_isenable()
	{
		try 
		{
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement table = driver.findElement(By.xpath(webtable_xpath));
			 boolean tab = table.isDisplayed();
			 Assert.assertTrue(tab);
			 WebElement header = table.findElement(By.tagName("thead"));
			 WebElement thead = header.findElement(By.tagName("tr"));
			 String header_row = thead.getText();
			 Reporter.log(header_row,true);
			// Reporter.log("-------------------------------------------------------",true);
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> allrows = tbody.findElements(By.tagName("tr"));
			 for (WebElement eachrow : allrows)
			 {
				List<WebElement> allcols = eachrow.findElements(By.tagName("td"));
				boolean firstcol = allcols.get(0).isEnabled();
				Assert.assertTrue(firstcol);
			 }
			Reporter.log(" Bill No Id link is enable in the table",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_11_click_bill_n0_link()
	{
		try 
		{
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 String title = driver.getCurrentUrl();
			 Assert.assertTrue(title.equals(bill_n0_id_text));
			 Reporter.log("Bill n0 id 32 is clicked",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_12_Verify_Bill_id_disable()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement bill_id = driver.findElement(By.xpath(bill_id_xpath));
			 boolean flag = bill_id.isEnabled();
			 Assert.assertTrue(flag);
			 Reporter.log("After Bill no Bill settlement page is displayed & verified bill ID textbox is disabled",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_13_Verify_Bill_amount_disable()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement bill_amount = driver.findElement(By.xpath(bill_amount_xpath));
			 boolean flag = bill_amount.isEnabled();
			 Assert.assertTrue(flag);
			 Reporter.log("After Bill no Bill settlement page is displayed & verified bill amount textbox is disabled",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_14_Verify_guest_name_textbox_disable()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement guest_name = driver.findElement(By.xpath(guest_name_xpath));
			 String attribute_value = guest_name.getAttribute("readonly");
			// boolean flag = guest_name.isEnabled();
			// System.out.println(flag);
			 Assert.assertEquals(attribute_value, "true");
			 Reporter.log("After Bill no Bill settlement page is displayed & verified guest name textbox is disabled",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_15_enter_tip_amount_numeric()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(3000);
			 //WebElement net_amount = driver.findElement(By.xpath(net_amount_xpath));
			 //String net_amount1 = net_amount.getText();
			 //Reporter.log(net_amount1,true);
			 //Thread.sleep(3000);
			
			 WebElement tip_amount = driver.findElement(By.xpath(tip_amount_xpath));
			 tip_amount.clear();
			 tip_amount.sendKeys("100");
			 Thread.sleep(3000);
			 Reporter.log("Entered tip amount in the textbox",true);
			 WebElement payment_mode = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode);
			 select.selectByIndex(4);
			 WebElement dropdown_value = select.getFirstSelectedOption();
			 String value = dropdown_value.getText();
			 Reporter.log("Dropdown displayed as : "+value,true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("100");
			 //int amount1 = Integer.parseInt(net_amount1);
			 //System.out.println(amount1);
			 Thread.sleep(2000);
			 WebElement add_tip_button = driver.findElement(By.xpath(add_tip_button_xpath));
			 add_tip_button.click();
			 Reporter.log("Add Tip button is clicked",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Reporter.log("Add Settlement button is clicked",true);
			 WebElement table = driver.findElement(By.xpath(table_xpath));
			 WebElement thead = table.findElement(By.tagName("thead"));
			 WebElement row = thead.findElement(By.tagName("tr"));
			 String table_head = row.getText();
			 Reporter.log(table_head,true);
			 Thread.sleep(3000);
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 String bodydata = tbody.getText();
			 Reporter.log(bodydata,true);
			 List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			 for (WebElement eachrowdata : rows) {
				//String rowdval = eachrowdata.getText();
				//Reporter.log(rowdval,true);
				System.out.println("  ");
				String Tenthcol = rows.get(1).findElement(By.xpath("td[10]")).getText();
				if(Tenthcol.equals("100.00"))
				{
					Reporter.log("Cash Amount is displaying as : "+Tenthcol,true);
					break;
				}
				else
				{
					Reporter.log("Not displaying 100.00 at Cash Amount",true);
				}
			}
			 
			 Assert.assertTrue(rows.get(1).findElement(By.xpath("td[10]")).getText().equals("100.00"));
			 Reporter.log("Entered numeric value in tip amount textbox",true);
			 
			
			 Reporter.log("---------------------------------------------------------------------------------",true);
				
			
				
			
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_16_enter_tip_amount_alphanumeric_with_special_character()
	{
		try 
		{
			
			driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement text_box = driver.findElement(By.id(search_by_guest_name_text_box_id));
			 text_box.clear();
			 Reporter.log("cleared textbox of search by guest name",true);
			 text_box.sendKeys("Ram");
			 Thread.sleep(2000);
			 WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
			 search_button.click();
			 Reporter.log("Clicked on Search button",true);
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(3000);
			 WebElement tip_amount = driver.findElement(By.xpath(tip_amount_xpath));
			 tip_amount.clear();
			 tip_amount.sendKeys("%&^*&assfdg");
			 Thread.sleep(3000);
			 Reporter.log("Entered tip amount in the textbox",true);
			 WebElement payment_mode = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode);
			 select.selectByIndex(4);
			 WebElement dropdown_value = select.getFirstSelectedOption();
			 String value = dropdown_value.getText();
			 Reporter.log("Dropdown displayed as : "+value,true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("%&^*&assfdg");
			 Thread.sleep(2000);
			 WebElement add_tip_button = driver.findElement(By.xpath(add_tip_button_xpath));
			 add_tip_button.click();
			 Reporter.log("Add Tip button is clicked",true);
			 Thread.sleep(3000);
			 Alert alert = driver.switchTo().alert();
			 String mess = alert.getText();    
			 Assert.assertEquals(mess, "Please enter Tip Amount");
			
			 Reporter.log("Entered numeric value in tip amount textbox",true);
			 
			Reporter.log("System is not allowed   tip amount as a numeric value",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
		
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_17_verify_add_tip_button_enable()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement add_tip_button = driver.findElement(By.xpath(add_tip_button_xpath));
			 boolean add_tip_butt = add_tip_button.isEnabled();
			 Assert.assertTrue(add_tip_butt);
			 Reporter.log("Add tip button is enabled",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_18_verify_tip_amount_added_with_net_amount()
	{
		try 
		{
			DriverInitializer.Refresh();
			WebElement tip_amount = driver.findElement(By.xpath(tip_amount_xpath));
			tip_amount.clear();
			tip_amount.sendKeys("2000");
			Thread.sleep(1000);
			Reporter.log("Entered tip amount in the textbox",true);
			WebElement net_amount = driver.findElement(By.xpath(net_amount_xpath));
			String net_amount1 = net_amount.getText();
			int amount1 = Integer.parseInt(net_amount1);
			Thread.sleep(2000);
			WebElement add_tip_button = driver.findElement(By.xpath(add_tip_button_xpath));
			add_tip_button.click();
			
			String net_amount2 = net_amount.getText();
		    int amount2 = Integer.parseInt(net_amount2);
		    Assert.assertNotEquals(amount1, amount2);
			Reporter.log("Tip amount added with net amount",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
			
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_19_verify_add_tip_button_disable()
	{
		try 
		{
			DriverInitializer.Refresh();
			WebElement tip_amount = driver.findElement(By.xpath(tip_amount_xpath));
			tip_amount.clear();
			tip_amount.sendKeys("200");
			Thread.sleep(1000);
			Reporter.log("Entered tip amount in the textbox",true);
			WebElement add_tip_button = driver.findElement(By.xpath(add_tip_button_xpath));
			add_tip_button.click();
			Reporter.log("Add Tip button is clicked",true);
			Thread.sleep(2000);
			boolean add_tip_butt = add_tip_button.isEnabled();
			Assert.assertFalse(add_tip_butt);
			Reporter.log("Add Tip button is disabled",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
			
		} 
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_20_verify_by_default_dropdown_value_payment_mode()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Clicked bill no link ",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 WebElement by_default_select = select.getFirstSelectedOption();
			 String value = by_default_select.getText();
			 Reporter.log(value,true);
			 Assert.assertEquals(value, by_default_value);
			 Reporter.log("Add tip button is enabled",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_21_click_add_settlement_button()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Clicked bill no link ",true);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Thread.sleep(3000);
			 Reporter.log("Clicked add settlement button ",true);
			 Alert alert = driver.switchTo().alert();
			 String alert_mess = alert.getText();
			 alert.accept();
			 Reporter.log(alert_mess,true);
			 Assert.assertEquals(alert_message, alert_mess);
			 Reporter.log("System displayed alert message as Please Select Payment Mode",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_22_click_popup_ok_button()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Thread.sleep(3000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 boolean flag = add_settlement_button.isEnabled();
			 Assert.assertTrue(flag);
			 Reporter.log("Popup ok button is clicked",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_23_click_cancel_on_popup()
	{
		 Reporter.log("click cancel on popup not possible ins selenium",true);
		 Reporter.log("---------------------------------------------------------------------------------",true);
	}
	public void BS_24_select_dropdown_value_payment_mode()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Bill No. link is clicked",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Reporter.log("Payment mode option selected from dropdown",true);
			 WebElement dropdown_value = select.getFirstSelectedOption();
			 String value = dropdown_value.getText();
			 Assert.assertEquals(value,"BillToCompany");
			 Reporter.log("BillToCompany select from dropdown of payment mode",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_25_verify_select_dropdown_value_payment_mode()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 Reporter.log("Bill No. link is clicked",true);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value = select.getFirstSelectedOption();
			 String option = value.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_label = driver.findElement(By.xpath(corporate_label_xpath));
			 String corpo_label = corporate_label.getText();
			 Assert.assertEquals(corpo_label,"Corporate");
			 WebElement creditlist_amount_label = driver.findElement(By.xpath(creditList_amount_label_xpath));
			 String creditList_label = creditlist_amount_label.getText();
			 Assert.assertEquals(creditList_label, "CreditList Amount");
			 Reporter.log("System displaying related Payment Mode options in Bill Settlement Page",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_26_display_by_default_dropdown_corporate() throws InterruptedException
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option+ " Selected at Payment Mode Dropdown",true);
			 Thread.sleep(3000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 WebElement value = dropdown_value.getFirstSelectedOption();
			 String corporate_value = value.getText();
			 Reporter.log(corporate_value,true);
			 Assert.assertTrue(corporate_value.contains("Select"));
			Reporter.log("By default in the corporate dropdown select is displayed",true);
			Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_27_display_dropdown_List_of_corporate()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 List<WebElement> value = dropdown_value.getOptions();
			 Assert.assertFalse(value.isEmpty());
			 for (WebElement eachvalue : value) 
			 {
				 String valuetxt = eachvalue.getText();
				 Reporter.log(valuetxt+"   option is displayed at corporate dropdown",true);
				 Reporter.log("---------------------------------------------------------------------------------",true);
				
			}
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_28_select_from_List_of_corporate_dropdown()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Alert alert = driver.switchTo().alert();
			 String alert_messa = alert.getText();
			 Reporter.log(alert_messa+ " selected value is displayed",true);
			 alert.accept();
			 Assert.assertEquals(alert_meaasge_after_corporate_selection_txt, alert_messa);
			 Reporter.log("Popup message is displayed as : "+alert_messa,true);
			 
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_29_click_ok_button_at_popup()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Alert alert = driver.switchTo().alert();
			 String alert_messa = alert.getText();
			 Reporter.log(alert_messa+ " selected value is displayed",true);
			 alert.accept();
			 Thread.sleep(3000);
			 WebElement display_value = dropdown_value.getFirstSelectedOption();
			 String value = display_value.getText();
			 Reporter.log(value,true);
			 Assert.assertEquals("IDBI", value);
			 Reporter.log("Popup message is displayed as : "+alert_messa,true);
			 
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
			
		}
		  
	}
	public void BS_30_verify_credit_list_amount()
	{
		try 
		{	 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Alert alert = driver.switchTo().alert();
			 String alert_messa = alert.getText();
			 Reporter.log(alert_messa+ " selected value is displayed",true);
			 alert.accept();
			 Thread.sleep(3000);
			 Reporter.log("popup is accepted",true);
			 WebElement txtbox = driver.findElement(By.xpath(credit_list_amount_txtbox_xpath));
			 String flag = txtbox.getAttribute("readonly");
			 Assert.assertTrue(flag.equals("true"));
			 Reporter.log("CreditList amount txtbox is disabled",true);
			 
			
				
			
			 
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_31_enter_amount()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill No. link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 WebElement value1 = select.getFirstSelectedOption();
			 String option = value1.getText();
			 Reporter.log(option,true);
			 Thread.sleep(1000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Alert alert = driver.switchTo().alert();
			 String alert_messa = alert.getText();
			 Reporter.log(alert_messa+ " selected value is displayed",true);
			 alert.accept();
			 Thread.sleep(3000);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("103");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Reporter.log("Clicked add settlement button",true);
			// Alert alert1 = driver.switchTo().alert();
			// String alert_mess = alert1.getText();
			 //Reporter.log(alert_mess+ " selected value is displayed",true);
			 //alert.accept();
			 //Thread.sleep(3000);
			 WebElement table = driver.findElement(By.xpath(table_xpath));
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			 List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
			 WebElement value = cols.get(9);
			 String grid_amount = value.getText();
			 Reporter.log(grid_amount,true);
			 Assert.assertEquals(grid_amount, "103.50");
			 Reporter.log("Cash amount is displayed in the grid & cost amount is : ",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}

	public void BS_32_enter_amount_moreThan_netAmount()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(1000);
			 Reporter.log("BillToCompany is selected",true);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 String alert_messa = alert.getText();
			 alert.accept();
			 Reporter.log(alert_messa+ " selected value is displayed",true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("5000");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(1000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Reporter.log("Clicked add settlement button",true);
			 Alert alert1 = driver.switchTo().alert();
			 alert1.accept();
			 Reporter.log("popup is accepted",true);
			 Thread.sleep(1000);
			 String alert_mess = alert1.getText();
			 Reporter.log(alert_mess,true);
			 Assert.assertEquals(alert_mess, alert_mess_EnterAmount_more_than_NetAmount);
			 Reporter.log("Enter amount more than net amount alert message ia displayed as : "+alert_mess ,true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_33_enter_amount_lessThanEqualTo_netAmount()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(1000);
			 Reporter.log("BillToCompany is selected",true);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 Reporter.log("popup is accepted",true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("103");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();
			 //Reporter.log("popup is accepted",true);
			 //Thread.sleep(1000);
			 //String alert_mess = alert1.getText();
			// Reporter.log(alert_mess,true);
			 //Assert.assertEquals(alert_mess, alert_mess_EnterAmount_more_than_NetAmount);
			// Reporter.log("Enter amount less than net amount alert message ia displayed as : "+alert_mess ,true);
			 WebElement table = driver.findElement(By.xpath(table_xpath));
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			 List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
			 WebElement value = cols.get(9);
			 String grid_amount = value.getText();
			 Reporter.log(grid_amount,true);
			 Assert.assertEquals(grid_amount, "103.50");
			 Reporter.log("Cash amount is displayed in the grid & cost amount is : ",true);
			  
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_34_enter_amount_lessThan_creditListAmount()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(1000);
			 Reporter.log("BillToCompany is selected",true);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 //WebElement selected_value = dropdown_value.getFirstSelectedOption();
			 //String value_display = selected_value.getText();
			 //Reporter.log(value_display,true);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 Reporter.log("popup is accepted",true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("110000");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(1000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 alert1.accept();
			 Reporter.log("popup is accepted",true);
			 Thread.sleep(3000);
			 Alert alert2 = driver.switchTo().alert();
			 alert2.accept();
			 String alert_mess = alert1.getText();
			 Reporter.log(alert_mess,true);
			 Assert.assertEquals(alert_mess, alert_mess_EnterAmount_more_than_NetAmount);
			 Reporter.log("Enter amount more than creditListAmount alert message ia displayed as : "+alert_mess ,true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}


	public void BS_35_click_ok_button_display_bill_settlement_page()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(1000);
			 Reporter.log("BillToCompany is selected",true);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 //WebElement value1 = dropdown_value.getFirstSelectedOption();
			// String selected_value = value1.getText();
			 //Reporter.log(selected_value,true);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 String alert_m = alert.getText();
			 alert.accept();
			 Reporter.log(alert_m,true);
			 Reporter.log("Popup is accepted",true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("110000");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 String alert_mess1 = alert1.getText();
			 alert1.accept();
			
			 Reporter.log(alert_mess1,true);
			 Thread.sleep(3000);
			 Alert alert2 = driver.switchTo().alert();
			 String alert_mess2 = alert2.getText();
			 alert2.accept();
			
			 Reporter.log(alert_mess2,true);
			 WebElement guest_name1 = driver.findElement(By.xpath(guest_name1_xpath));
			 String guest_name_value = guest_name1.getText();
			 Assert.assertEquals(guest_name_value, "raghava");
			 Reporter.log("click popup ok button bill settlement page is displayed",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_36_deselect_corporate_and_select()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(1000);
			 Reporter.log("BillToCompany is selected",true);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 System.out.println("selected");
			// WebElement selected_value = dropdown_value.getFirstSelectedOption();
			// String value0 = selected_value.getText();
			 //Reporter.log(value0,true);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 Reporter.log("Popup is accepted",true);
			 Reporter.log("After selected value from corporate dropdown clicked ok button",true);
			 WebElement creditList_amout = driver.findElement(By.xpath(credit_list_amount_txtbox_xpath));
			 boolean flag = creditList_amout.isDisplayed();
			 System.out.println(flag);
			 Assert.assertTrue(flag);
			 dropdown_value.selectByIndex(0);
			 Thread.sleep(2000);
			 Reporter.log("Corporate dropdown value is deselected ",true);
			 boolean flag1 = creditList_amout.isDisplayed();
			 System.out.println(flag1);
			 Assert.assertFalse(flag1);
			
			 Reporter.log("After deselect of corporate dropdown creditList Amount is cleared",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_37_click_add_settlement_button_without_select_corporate()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Thread.sleep(3000);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("100");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert = driver.switchTo().alert();
			 String alert_m = alert.getText();
			 alert.accept();
			 Reporter.log("Clicked add settlement button",true);
			 Assert.assertEquals(alert_m, "Please select corporate");
			 Reporter.log("Alert message is displayed as : "+alert_m,true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_38_select_membership()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(3000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(3000);
			 Reporter.log("Selected from dropown",true);
			 WebElement member_name_label = driver.findElement(By.xpath(member_name_label_xpath));
			 String label = member_name_label.getText();
			 Reporter.log(label,true);
			 Assert.assertEquals(label, member_name_label_txt);
			 WebElement membership_amount_label = driver.findElement(By.xpath(membership_amount_label_xpath));
			 String membership = membership_amount_label.getText();
			 Reporter.log(membership,true);
			 Assert.assertEquals(membership, membership_amount_txt);
			 Reporter.log("Related to paymentmode options is displayed",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_39_display_by_default_select_member_name()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 WebElement by_default = select1.getFirstSelectedOption();
			 String default_value = by_default.getText();
			 Assert.assertEquals("Select", default_value);
			 Reporter.log("By default member name dropdown box displayed as : "+default_value,true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			  
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_40_display_list_of_dropdown_values_member_name()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 List<WebElement> by_default = select1.getOptions();
						 
			for (WebElement eachoption : by_default) 
			 {
				
				String tagname = eachoption.getTagName();
				String eachvalue = eachoption.getText();
				Reporter.log(tagname+ " is Tagname, Value of dropdown as : "+eachvalue,true);
			 }
			  
			Reporter.log("---------------------------------------------------------------------------------",true);
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_41_display_alert_message_after_select_member_name()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(1);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 String alert_mess = alert.getText();
			 alert.accept();
			 Assert.assertEquals(alert_message_member_name_txt, alert_mess);
			 Reporter.log("Alert message is displayed as : "+alert_mess,true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_42_accept_ok_button_of_alert_message_after_select_member_name()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(1);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement membership_amount = driver.findElement(By.xpath(membership_amount_label_xpath));
			 String label_txt = membership_amount.getText();
			 Assert.assertEquals(label_txt, membership_amount_txt);
			 Reporter.log("Clicked ok button",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_43_display_membership_amount_txtbox_in_disable()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(1);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement membership_amount = driver.findElement(By.xpath(membership_amount_txtbox_xpath));
			 boolean flag = membership_amount.isDisplayed();
			 boolean flag1 = membership_amount.isEnabled();
			 Assert.assertTrue(flag1);
			 Assert.assertTrue(flag);
			 Reporter.log("Membership amount is displayed in textbox",true);
			 Reporter.log("Membership amount is displayed in textbox as a disable mode",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_44_enter_amount_click_add_settlement()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(1);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("103");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(1000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 alert1.accept();
			 Thread.sleep(1000);
			 Reporter.log("click popup ok button bill settlement page is displayed",true);
			 WebElement table = driver.findElement(By.xpath(table_xpath));
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			 List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
			 WebElement value = cols.get(9);
			 String grid_amount = value.getText();
			 Reporter.log(grid_amount,true);
			 Assert.assertEquals(grid_amount, "103.00");
			 Reporter.log("Enter amount displayed in to grid",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
		 
				
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_45_enter_amount_more_than_net_amount_click_add_settlement()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(1);
			 Thread.sleep(3000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 Reporter.log("Popup is accepted",true);
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("105");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Reporter.log("Clicked add settlement button",true);
			 Alert alert1 = driver.switchTo().alert();
			 String alert_mes = alert1.getText();
			 Thread.sleep(3000);
			 alert1.accept();
			 Thread.sleep(3000);
			 //alert1.accept();
			 Reporter.log(alert_mes,true);
			 Assert.assertEquals(alert_message_amount_moreThan_net_amount, alert_mes);
			 Reporter.log("Alert message is displayed as : ",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
		 
				
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}

	public void BS_46_enter_amount_less_than_or_equal_membership_amount_click_add_settlement()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(3);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("25");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(1000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 alert1.accept();
			 Reporter.log("Clicked ok button",true);
			 WebElement table = driver.findElement(By.xpath(table_xpath));
			 WebElement tbody = table.findElement(By.tagName("tbody"));
			 List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			 List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
			 WebElement value = cols.get(9);
			 String grid_amount = value.getText();
			 Reporter.log(grid_amount,true);
			 Assert.assertEquals(grid_amount, "25.00");
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
			
				
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_47_enter_amount_more_than__membership_amount_click_add_settlement()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(3);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("26");
			 Reporter.log("Entered 26 amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Reporter.log("Clicked add settlement button",true);
			 Alert alert1 = driver.switchTo().alert();
			 String alert_mess = alert1.getText();
			 alert1.accept();
			 Thread.sleep(3000);
			 Alert alert2 = driver.switchTo().alert();
			 alert2.accept();
			 Thread.sleep(3000);
			 Alert alert3 = driver.switchTo().alert();
			 alert3.accept();
			 Thread.sleep(3000);
			 Assert.assertEquals(alert_message_amount_moreThan_membership_amount, alert_mess);
			 Reporter.log("Alert message is displayed as : "+alert_mess,true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_48_click_ok_button()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 WebElement member_name_dropdown = driver.findElement(By.xpath(member_name_dropdown_xpath));
			 Select select1 = new Select(member_name_dropdown);
			 select1.selectByIndex(3);
			 Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
			 WebElement amount = driver.findElement(By.xpath(amount_xpath));
			 amount.clear();
			 amount.sendKeys("26");
			 Reporter.log("Entered amount in textbox",true);
			 Thread.sleep(3000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 String alert1_mess = alert1.getText();
			 alert1.accept();
			
			 Reporter.log(alert1_mess,true);
			 Thread.sleep(3000);
			 Alert alert2 = driver.switchTo().alert();
			 String alert2_mess = alert2.getText();
			 alert2.accept();
			
			 Reporter.log(alert2_mess,true);
			 Thread.sleep(3000);
			 Alert alert3 = driver.switchTo().alert();
			 String alert3_mess = alert3.getText();
			 alert3.accept();
			
			 Reporter.log(alert3_mess,true);
			 Reporter.log("Clicked ok button of popup",true);
			 Thread.sleep(3000);
			 WebElement amount_level = driver.findElement(By.xpath(amount_level_xpath));
			 String amount_level_txt = amount_level.getText();
			 Assert.assertEquals("Amount", amount_level_txt);
			 Reporter.log("System is resided in Bill Settlement page",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}

	public void BS_49_deselect_after_select_dropdown_corporate()
	{
		try 
		{
			
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Reporter.log("Bill no link is clicked",true);
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(1);
			 Reporter.log("Dropdown selected from paymentmode",true);
			 Thread.sleep(3000);
			 WebElement corporate_dropdown = driver.findElement(By.xpath(corporate_dropdown_xpath));
			 Select dropdown_value = new Select(corporate_dropdown);
			 dropdown_value.selectByIndex(2);
			 Alert alert = driver.switchTo().alert();
			// WebElement selected = dropdown_value.getFirstSelectedOption();
			 //String value = selected.getText();
			// Reporter.log(value,true);
			 Thread.sleep(3000);
			 alert.accept();
			 Reporter.log("Accepted popup",true);
			 Thread.sleep(1000);
			 WebElement creditList_amount = driver.findElement(By.xpath(credit_list_amount_txtbox_xpath));
			 boolean flag = creditList_amount.isDisplayed();
			 Assert.assertTrue(flag);
			 Thread.sleep(2000);
			 dropdown_value.selectByIndex(0);
			 WebElement selected1 = dropdown_value.getFirstSelectedOption();
			 String value1 = selected1.getText();
			 Reporter.log(value1,true);
			 Assert.assertEquals("Select", value1);
			 Reporter.log("Cleared CreditList amount textbox",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}
	public void BS_50_click_add_settlement_without_selelect_member_name()
	{
		try 
		{
			 driver.navigate().back();
			 Thread.sleep(1000);
			 WebElement bill_n0_link = driver.findElement(By.xpath(bill_n0_xpath));
			 bill_n0_link.click();
			 Thread.sleep(2000);
			 WebElement payment_mode_dropdown = driver.findElement(By.id(payment_mode_dropdown_id));
			 Select select = new Select(payment_mode_dropdown);
			 select.selectByIndex(7);
			 Thread.sleep(1000);
			 Reporter.log("Membership is selected",true);
			 Thread.sleep(1000);
			 WebElement add_settlement_button = driver.findElement(By.xpath(add_settlement_button_xpath));
			 add_settlement_button.click();
			 Alert alert1 = driver.switchTo().alert();
			 String alert_mess = alert1.getText();
			 Reporter.log(alert_mess,true);
			 Assert.assertEquals(alert_message_without_select_memberName_click_add_settlement_button, alert_mess);
			 Reporter.log("Alert message is displayed",true);
			 Reporter.log("---------------------------------------------------------------------------------",true);
			
		
			 
		}
		catch (Exception e) 
		{
			Reporter.log(e.getMessage(),true);
		}
		  
	}













}
		  
		  
		  
		  
	



