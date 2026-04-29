package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Landing_Page;
import pageObjects.User_Sign_Up_Page;
import pageObjects.User_Sign_in_Page;
import testBase.BaseClass;

public class TC_001_AccountRegistration_Test extends BaseClass{


	@Test(groups = {"Regression","Master"})
	public void Verify_Account_Register()
	{
		try {
		logger.info("------------- starting tc_001_account registration-------------------");
		Landing_Page lp = new Landing_Page(driver);
		logger.info("clicking user btn");
		lp.click_Userbtn();
		
		User_Sign_in_Page in = new User_Sign_in_Page(driver);
		logger.info("clicking sign up link");
		in.click_signup_btn();
		
		
		User_Sign_Up_Page up = new User_Sign_Up_Page(driver);
		logger.info("setting up registration");
		up.setFirst_Name(randomName());
		up.setSecond_Name(randomName());
		up.setEmail(random_email());
		up.setPassword(random_Password());
		logger.info("clicking sign up btn");
		up.click_Signup_btn();
		logger.info("------------- test passed tc_001_account registration-------------------");
		}
		catch (Exception e) {
		 logger.error("test failed");
		 Assert.fail();
		}
		
		
	}
}
