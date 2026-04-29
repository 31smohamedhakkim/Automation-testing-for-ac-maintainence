package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Landing_Page;
import pageObjects.User_HomePage;
import pageObjects.User_Sign_in_Page;
import testBase.BaseClass;

public class TC_002_Login_Test extends BaseClass {
	
	
	@Test(groups = {"Sanity","Master"})
	public void Login_Test()
	{
		try {
		logger.info("------------- starting tc_001_account registration-------------------");
		Landing_Page lp = new Landing_Page(driver);
		logger.info("clicking user btn");
		lp.click_Userbtn();
		
		
		User_Sign_in_Page in = new User_Sign_in_Page(driver);
		logger.info("Entering details");
		in.set_Email("hakkimalim68@gmail.com");
		in.set_Password("Hakkim8021");
		logger.info("clicking sign in btn");
		in.click_Sign_In_btn();
		
		User_HomePage home = new User_HomePage(driver);
		logger.info("confirming..");
		boolean login_confirmation = home.login_confirmation();
		Assert.assertEquals(login_confirmation, true);
		}catch(Exception e)
		{
			logger.info("Test case failed exception occured");
			Assert.fail();
		}
	}

}
