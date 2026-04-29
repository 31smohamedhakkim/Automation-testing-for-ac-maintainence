package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Landing_Page extends BasePage{
	
	//constructor
	public Landing_Page(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//a[normalize-space()='User']")
	WebElement Userbtn;
	
	@FindBy(xpath = "//a[normalize-space()='Admin']")
	WebElement Adminbtn;
	
	//Actions
	public void click_Userbtn() {
		Userbtn.click();
	}
	public void click_Adminbtn() {
		Adminbtn.click();
	}
	
}
