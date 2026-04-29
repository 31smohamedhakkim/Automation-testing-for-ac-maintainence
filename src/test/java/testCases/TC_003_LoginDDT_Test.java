package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Landing_Page;
import pageObjects.User_HomePage;
import pageObjects.User_Sign_in_Page;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT_Test extends BaseClass {
    
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"Datadriven","Master"})
	public void loginddt(String email, String password, String expected)
	{
		try {
		logger.info("------------- starting tc_001_account registration-------------------");
		Landing_Page lp = new Landing_Page(driver);
		logger.info("clicking user btn");
		lp.click_Userbtn();
		
		
		User_Sign_in_Page in = new User_Sign_in_Page(driver);
		logger.info("Entering details");
		in.set_Email(email);
		in.set_Password(password);
		logger.info("clicking sign in btn");
		in.click_Sign_In_btn();
		
		User_HomePage home = new User_HomePage(driver);
		logger.info("confirming..");
		boolean login_confirmation = home.login_confirmation();
		if(expected.toLowerCase().equals("valid"))
				if(login_confirmation==true)
				{
					logger.info("first if executed");
					home.click_logout_btn();
					Assert.assertEquals(login_confirmation, true);
				}
				else
				{
					logger.info("first else executed");
					
					in.click_go_back_btn();
					Assert.fail();
				}
		
		if(expected.toLowerCase().equals("invalid"))
			if(login_confirmation==true)
			{
				logger.info("second if executed");
				home.click_logout_btn();
				Assert.assertEquals(login_confirmation, false,"invalid should not enter into user page");
			}
			else
			{
				logger.info("second else executed");
				
				in.click_go_back_btn();
				Assert.assertTrue(true);
			}
		
		}catch (Exception e) {
			Assert.fail();
			logger.info("exception handled");
		}
	}
	
	
}
