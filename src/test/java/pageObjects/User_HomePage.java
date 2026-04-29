package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_HomePage extends BasePage{
	
	
	public User_HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement login_confirmation;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout_btn;
	
	
	//actions
	public boolean login_confirmation()
	{
		try {
		return login_confirmation.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}

	public void click_logout_btn()
	{
		logout_btn.click();
	}
}
