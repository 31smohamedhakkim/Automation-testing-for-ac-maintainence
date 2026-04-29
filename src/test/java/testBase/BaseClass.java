package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void before(String os, String br) throws IOException
	{
		
		
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		if(p.getProperty("env").equalsIgnoreCase("grid"))
		{
			DesiredCapabilities capablitlity = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capablitlity.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capablitlity.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no such os ");
				return;
			}
			
			
			switch (br.toLowerCase()) {
			case "chrome":
				capablitlity.setBrowserName("chrome");
				break;
			case "edge":
				capablitlity.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capablitlity.setBrowserName("firefox");
				break;
			default:
				System.out.println("no such browser");
				return;
			}
			driver= new RemoteWebDriver(new URL(" http://192.168.1.5:4444"),capablitlity);
		}
		
		if(p.getProperty("env").equalsIgnoreCase("local"))
		{
		switch (br.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver= new ChromeDriver(options);
			break;

		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver= new FirefoxDriver();
			break;
			
		default:
			System.out.println("invalid browser");
			return;
		}
		
		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("localAppUrl"));
	}
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void after()
	{
		driver.quit();
	}
	
	//random generations
	public String randomName()
	{
		String generated_name= RandomStringUtils.randomAlphabetic(7);
		return generated_name;
	}
	
	public String randomNumber()
	{
		String generated_Number= RandomStringUtils.randomNumeric(10);
		return generated_Number;
	}
	public String random_email()
	{
		String email= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
		return email;
	}
	public String random_Password()
	{
		String password= "A"+RandomStringUtils.randomAlphanumeric(10);
		return password;
	}
	//screenshot
	
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
