package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Sign_in_Page extends BasePage{
	//constructor
	public User_Sign_in_Page(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//button[@id='signUpButton']")
	WebElement signupbtn;
	
	@FindBy(xpath = "//div[@id='signIn']//input[@id='email']")
	WebElement txt_Email;
	
	@FindBy(xpath = "//div[@id='signIn']//input[@id='password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//input[@name='signIn']")
	WebElement Sign_in_btn;
	
	@FindBy(xpath = "//a[normalize-space()='Go Back']")
	WebElement goback_btn;
	
	
	//Actions
	public void click_signup_btn()
	{
		signupbtn.click();
	}
	
	public void set_Email(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void set_Password(String password)
	{
		txt_Password.sendKeys(password);
	}
	public void click_Sign_In_btn()
	{
		Sign_in_btn.click();
	}
	public void click_go_back_btn()
	{
		goback_btn.click();
	}

}
