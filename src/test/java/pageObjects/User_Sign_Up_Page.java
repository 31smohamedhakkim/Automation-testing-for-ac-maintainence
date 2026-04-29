package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Sign_Up_Page extends BasePage{
     //constructor
	public User_Sign_Up_Page(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath = "//input[@id='fName']")
	WebElement txtfirst_Name;
	
	@FindBy(xpath = "//input[@id='lName']")
	WebElement txtSecond_Name;
	
	@FindBy(xpath = "//div[@id='signup']//input[@id='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//div[@id='signup']//input[@id='password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//input[@name='signUp']")
	WebElement signup_btn;
	
	
	//Actions
	public void setFirst_Name(String name)
	{
		txtfirst_Name.sendKeys(name);
	}
	
	public void setSecond_Name(String name)
	{
		txtSecond_Name.sendKeys(name);
	}
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		txt_Password.sendKeys(pass);
	}
	public void click_Signup_btn()
	{
		signup_btn.click();
	}

}
