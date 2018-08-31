package com.testScripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.pageLibrary.Bill_Settlement;
import com.pageLibrary.HomePage;
import com.pageLibrary.Staff_Login;



public class Bill_Settlement_Test 
{
	public static HomePage hp = new HomePage();
	public static Staff_Login sl = new Staff_Login();
	public static Bill_Settlement bst = new Bill_Settlement();
	
	
 
 //BS_51
 @Test (groups={"positive"},priority=0)	
 public void BS_51_Verify_Name_on_CreditCard_With_Valid_Alphabets() throws InterruptedException
 {
	 bst.bs_51_Verify_Name_on_CreditCard_With_Valid_Alphabets();
		
 }
 //BS_52
 @Test (groups={"negative"},priority=1)	
 public void BS_52_Verify_Name_on_CreditCard_With_InValid_Alphanumeric() throws InterruptedException
 {
	 bst.bs_52_Verify_Name_on_CreditCard_With_InValid_Alphanumeric();
		
 }

//BS_224
@Test (groups={"negative"},priority=2)	
public void BS_224_Verify_Name_on_CreditCard_With_InValid_SpecialCharacters() throws InterruptedException
{
	 bst.bs_224_Verify_Name_on_CreditCard_With_InValid_SpecialCharacters();
		
}

//BS_225
@Test (groups={"negative"},priority=3)	
public void BS_225_Verify_Name_on_CreditCard_With_InValid_Numeric() throws InterruptedException
{
	 bst.bs_225_Verify_Name_on_CreditCard_With_InValid_Numeric();
		
}
//BS_53
@Test (groups={"negative"},priority=4)	
public void BS_53_Verify_Name_on_CreditCard_Without_Entering_Name() throws InterruptedException
{
	 bst.bs_53_Verify_Name_on_CreditCard_Without_Entering_Name();
		
}
//BS_54
@Test (groups={"positive"},priority=5)	
public void BS_54_Verify_Name_on_Credit_Card_Textbox_with_Minimum_6_Char_Valid() throws InterruptedException
{
	 bst.bs_54_Verify_Name_on_Credit_Card_Textbox_with_Minimum_6_Char_Valid();
		
}

//BS_55
@Test (groups={"positive"},priority=6)	
public void BS_55_Verify_Name_on_Credit_Card_Textbox_with_Maximum_30_Char_Valid() throws InterruptedException
{
	 bst.bs_55_Verify_Name_on_Credit_Card_Textbox_with_Maximum_30_Char_Valid();
		
}
//BS_56
@Test (groups={"negative"},priority=7)	
public void BS_56_Verify_Name_on_CreditCard_with_Morethan_30_Char_Invalid() throws InterruptedException
{
	 bst.bs_56_Verify_Name_on_CreditCard_with_Morethan_30_Char_Invalid();
		
}
//BS_226
@Test (groups={"negative"},priority=8)	
public void BS_226_Verify_Name_on_CreditCard_with_below_6_Characters_Invalid() throws InterruptedException
{
	 bst.bs_226_Verify_Name_on_CreditCard_with_below_6_Characters_Invalid();
		
}

//BS_57
@Test (groups={"positive"},priority=9)	
public void BS_57_Verify_CreditCard_Number_with_Numeric_Valid() throws InterruptedException
{
	 bst.bs_57_Verify_CreditCard_Number_with_Numeric_Valid();
		
}

//BS_58
@Test (groups={"negative"},priority=10)	
public void BS_58_Verify_Credit_Card_Number_with_SpecialChar_Invalid() throws InterruptedException
{
	 bst.bs_58_Verify_Credit_Card_Number_with_SpecialChar_Invalid();
		
}

//BS_227
@Test (groups={"negative"},priority=11)	
public void BS_227_Verify_Credit_Card_Number_with_Alphanumeric_Invalid() throws InterruptedException
{
	 bst.bs_227_Verify_Credit_Card_Number_with_Alphanumeric_Invalid();
		
}
//BS_228
@Test (groups={"negative"},priority=12)	
public void BS_228_Verify_Credit_Card_Number_with_Alphabets_Invalid() throws InterruptedException
{
	 bst.bs_228_Verify_Credit_Card_Number_with_Alphabets_Invalid();
		
}

//BS_59
@Test (groups={"negative"},priority=13)	
public void BS_59_Verify_Credit_Card_Number_with_Blank_Invalid() throws InterruptedException
{
	 bst.bs_59_Verify_Credit_Card_Number_with_Blank_Invalid();
		
}
//BS_60
@Test (groups={"positive"},priority=14)	
public void BS_60_Verify_CreditCard_Number_with_4_Digits_Valid() throws InterruptedException
{
	 bst.bs_60_Verify_CreditCard_Number_with_4_Digits_Valid();
		
}
//BS_61
@Test (groups={"negative"},priority=15)	
public void BS_61_Verify_Credit_Card_Number_with_Morethan_4_digits_Invalid() throws InterruptedException
{
	 bst.bs_61_Verify_Credit_Card_Number_with_Morethan_4_digits_Invalid();
		
}
//BS_62
@Test (groups={"negative"},priority=16)	
public void BS_62_Verify_Credit_Card_Number_with_below_4_digits_Invalid() throws InterruptedException
{
	 bst.bs_62_Verify_Credit_Card_Number_with_below_4_digits_Invalid();
		
}
//BS_63
@Test (groups={"positive"},priority=17)	
public void BS_63_Verify_Default_Option_At_Credit_Card_Type_Dropdown() throws InterruptedException
{
	 bst.bs_63_Verify_Default_Option_At_Credit_Card_Type_Dropdown();
		
}
//BS_64
@Test (groups={"positive"},priority=18)	
public void BS_64_Verify_Credit_Card_Type_Dropdown_Valid() throws InterruptedException
{
	 bst.bs_64_Verify_Credit_Card_Type_Dropdown_Valid();
		
}
//BS_65
@Test (groups={"negative"},priority=19)	
public void BS_65_Verify_Credit_Card_Type_with_Blank_Invalid() throws InterruptedException
{
	 bst.bs_65_Verify_Credit_Card_Type_with_Blank_Invalid();
		
}
//BS_66
@Test (groups={"positive"},priority=20)	
public void BS_66_Verify_Amount_Lessthan_or_Equal_to_NetAmount() throws InterruptedException
{
	 bst.bs_66_Verify_Amount_Lessthan_or_Equal_to_NetAmount();
		
}
//BS_67
@Test (groups={"negative"},priority=21)	
public void BS_67_Verify_Amount_with_Morethan_NetAmount() throws InterruptedException
{
	 bst.bs_67_Verify_Amount_with_Morethan_NetAmount();
		
}
//BS_68
@Test (groups={"positive"},priority=22)	
public void BS_68_Verify_PaymentMode_Cheque_Option() throws InterruptedException
{
	 bst.bs_68_Verify_PaymentMode_Cheque_Option();
		
}
//BS_69
@Test (groups={"positive"},priority=23)	
public void BS_69_Verify_BankName_with_Alphabets_Valid() throws InterruptedException
{
	 bst.bs_69_Verify_BankName_with_Alphabets_Valid();

}
//BS_70
@Test (groups={"negative"},priority=24)	
public void BS_70_Verify_BankName_with_SplChar_Invalid() throws InterruptedException
{
	 bst.bs_70_Verify_BankName_with_SplChar_Invalid();
		
}
//BS_229
@Test (groups={"negative"},priority=25)	
public void BS_229_Verify_BankName_with_Numeric_Invalid() throws InterruptedException
{
	 bst.bs_229_Verify_BankName_with_Numeric_Invalid();	
}
//BS_230
@Test (groups={"negative"},priority=26)	
public void BS_230_Verify_BankName_with_AlphaNumeric_Invalid() throws InterruptedException
{
	 bst.bs_230_Verify_BankName_with_AlphaNumeric_Invalid();
}
//BS_71
@Test (groups={"negative"},priority=27)	
public void BS_71_Verify_BankName_with_Blank_Invalid() throws InterruptedException
{
	 bst.bs_71_Verify_BankName_with_Blank_Invalid();
		
}
//BS_72
@Test (groups={"positive"},priority=28)	
public void BS_72_Verify_BankName_with_Minimum_3_Char_Valid() throws InterruptedException
{
	 bst.bs_72_Verify_BankName_with_Minimum_3_Char_Valid();
		
}
//BS_73
@Test (groups={"positive"},priority=29)	
public void BS_73_Verify_BankName_with_Maximum_15_Char_Valid() throws InterruptedException
{
	 bst.bs_73_Verify_BankName_with_Maximum_15_Char_Valid();
		
}
//BS_74
@Test (groups={"negative"},priority=30)	
public void BS_74_Verify_BankName_with_Morethan_15_Char_Invalid() throws InterruptedException
{
	 bst.bs_74_Verify_BankName_with_Morethan_15_Char_Invalid();
		
}
//BS_75
@Test (groups={"positive"},priority=31)	
public void BS_75_Verify_Cheque_Number_with_Numeric_Valid() throws InterruptedException
{
	 bst.bs_75_Verify_Cheque_Number_with_Numeric_Valid();
		
}
//BS_76
@Test (groups={"negative"},priority=32)	
public void BS_76_Verify_Cheque_Number_with_Spl_Char_Invalid() throws InterruptedException
{
	 bst.bs_76_Verify_Cheque_Number_with_Spl_Char_Invalid();
		
}
//BS_231
@Test (groups={"negative"},priority=33)	
public void BS_231_Verify_Cheque_Number_with_Alphabets_Invalid() throws InterruptedException
{
	 bst.bs_231_Verify_Cheque_Number_with_Alphabets_Invalid();
		
}
//BS_232
@Test (groups={"negative"},priority=34)	
public void BS_232_Verify_Cheque_Number_with_AlphaNumeric_Invalid() throws InterruptedException
{
	 bst.bs_232_Verify_Cheque_Number_with_AlphaNumeric_Invalid();
		
}
//BS_233
@Test (groups={"negative"},priority=35)	
public void BS_233_Verify_BankName_with_below_3_Char_Invalid() throws InterruptedException
{
	 bst.bs_233_Verify_BankName_with_below_3_Char_Invalid();
		
}
//BS_77
@Test (groups={"negative"},priority=36)	
public void BS_77_Verify_Cheque_Number_with_Blank_Invalid() throws InterruptedException
{
	 bst.bs_77_Verify_Cheque_Number_with_Blank_Invalid();
		
}
//BS_78
@Test (groups={"positive"},priority=37)	
public void BS_78_Verify_Cheque_Number_with_Minimum_6_Digits_Valid() throws InterruptedException
{
	 bst.bs_78_Verify_Cheque_Number_with_Minimum_6_Digits_Valid();
		
}
//BS_79
@Test (groups={"negative"},priority=38)	
public void BS_79_Verify_Cheque_Number_with_Lessthan_6_Digits_Invalid() throws InterruptedException
{
	 bst.bs_79_Verify_Cheque_Number_with_Lessthan_6_Digits_Invalid();
		
}
//BS_80
@Test (groups={"negative"},priority=39)	
public void BS_80_Verify_Cheque_Number_with_Morethan_6_Digits_Invalid() throws InterruptedException
{
	 bst.bs_80_Verify_Cheque_Number_with_Morethan_6_Digits_Invalid();
		
}
//BS_81
@Test (groups={"positive"},priority=40)	
public void BS_81_Verify_Cheque_Payee_with_Alphabets_Valid() throws InterruptedException
{
	 bst.bs_81_Verify_Cheque_Payee_with_Alphabets_Valid();
		
}
//BS_82
@Test (groups={"negative"},priority=41)	
public void BS_82_Verify_Cheque_Payee_with_Spl_Char_Invalid() throws InterruptedException
{
	 bst.bs_82_Verify_Cheque_Payee_with_Spl_Char_Invalid();
		
}
//BS_234
@Test (groups={"negative"},priority=42)	
public void BS_234_Verify_Cheque_Payee_with_AlphaNumeric_Invalid() throws InterruptedException
{
	 bst.bs_234_Verify_Cheque_Payee_with_AlphaNumeric_Invalid();
		
}
//BS_235
@Test (groups={"negative"},priority=43)	
public void BS_235_Verify_Cheque_Payee_with_Numeric_Invalid() throws InterruptedException
{
	 bst.bs_235_Verify_Cheque_Payee_with_Numeric_Invalid();
		
}
//BS_83
@Test (groups={"positive"},priority=44)	
public void BS_83_Verify_Cheque_Payee_with_Minimum_3_Char_Valid() throws InterruptedException
{
	 bst.bs_83_Verify_Cheque_Payee_with_Minimum_3_Char_Valid();
		
}
//BS_84
@Test (groups={"negative"},priority=45)	
public void BS_84_Verify_Cheque_Payee_with_Lessthan_3_Char_Invalid() throws InterruptedException
{
	 bst.bs_84_Verify_Cheque_Payee_with_Lessthan_3_Char_Invalid();
		
}
//BS_85
@Test (groups={"positive"},priority=46)	
public void BS_85_Verify_Cheque_Payee_with_Maximum_20_Char_Valid() throws InterruptedException
{
	 bst.bs_85_Verify_Cheque_Payee_with_Maximum_20_Char_Valid();
		
}
//BS_86
@Test (groups={"negative"},priority=47)	
public void BS_86_Verify_Cheque_Payee_with_Morethan_20_Char_Invalid() throws InterruptedException
{
	 bst.bs_86_Verify_Cheque_Payee_with_Morethan_20_Char_Invalid();
		
}
//BS_87
@Test (groups={"negative"},priority=48)	
public void BS_87_Verify_Cheque_Payee_with_Blank_Invalid() throws InterruptedException
{
	 bst.bs_87_Verify_Cheque_Payee_with_Blank_Invalid();
		
}
//BS_99
@Test (groups={"positive"},priority=49)	
public void BS_99_Verify_Cheque_Date_format() throws InterruptedException, AWTException
{
	 bst.bs_99_Verify_Cheque_Date_format();
		
}
//BS_100
@Test (groups={"positive"},priority=50)	
public void BS_100_Verify_Cheque_Date_with_Morethan_SystemDate() throws InterruptedException, AWTException
{
	 bst.bs_100_Verify_Cheque_Date_with_Morethan_SystemDate();
		
}
//BS_101
@Test (groups={"positive"},priority=51)	
public void BS_101_Verify_Cheque_Date_with_Lessthan_SystemDate() throws InterruptedException, AWTException
{
	 bst.bs_101_Verify_Cheque_Date_with_Lessthan_SystemDate();
		
}
//BS_102
@Test (groups={"positive"},priority=52)	
public void BS_102_Verify_Amount_Lessthan_or_Equal_to_NetAmount() throws InterruptedException, AWTException
{
	 bst.bs_102_Verify_Amount_Lessthan_or_Equal_to_NetAmount();
		
}
//BS_103
@Test (groups={"negative"},priority=53)	
public void BS_103_Verify_Amount_Morethan_NetAmount_Invalid() throws InterruptedException, AWTException
{
	 bst.bs_103_Verify_Amount_Morethan_NetAmount_Invalid();
		
}
//BS_104
@Test (groups={"negative"},priority=54)	
public void BS_104_Verify_Cheque_Date_Blank_Invalid() throws InterruptedException, AWTException
{
	 bst.bs_104_Verify_Cheque_Date_Blank_Invalid();
		
}



}
