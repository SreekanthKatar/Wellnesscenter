package com.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wellness_login_page 
{
	/* Login Page */
	
	
	@FindBy (className="clickheretext")
	public WebElement loginlink;
	
	@FindBy (name="username")
	public WebElement username;
	
	@FindBy (name="password")
	public WebElement pasword;
	
	@FindBy (xpath="html/body/form/div/div/div/div[2]/div/div/a/input")
	public WebElement login_button;
	
	
}
