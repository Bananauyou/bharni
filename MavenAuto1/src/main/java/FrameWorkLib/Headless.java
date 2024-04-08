package FrameWorkLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headless {

	public WebDriver driver;
	public  Logger logger;
	
	public PropertyFile p=new PropertyFile();
	
   public static ReadExcel file = new ReadExcel();
   public static ExelUtility Excel= new ExelUtility();
	
	
	public WebDriverUtilies WebUtility=new WebDriverUtilies();

	@BeforeMethod
	public void OpenApp() throws IOException, InterruptedException {
		
        String browser = p.getPropertyFileldata("browser");
		//launch browser
			switch (browser.toLowerCase()) {
				
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				break;

			case "msedge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions options2 = new EdgeOptions();
				//options2.setHeadless(true);
				driver = new EdgeDriver(options2);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options3 = new FirefoxOptions();
				options3.setHeadless(true);
				driver = new FirefoxDriver(options3);
				break;
				 	
			default:
				driver = null;
				break;
			} 
		driver.manage().window().maximize();
	    driver.get(p.getPropertyFileldata("url"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		logger = LogManager.getLogger("BaseClass");
		System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Thread.sleep(2000);
	}
	
	@AfterMethod
	public void CloseApp(ITestResult result) throws IOException 
	{
		int status = result.getStatus();
		String name = result.getName();
		
		if(status==2) {
			Screenshot  s =  new Screenshot();
			s.getPhoto(driver, name);
		}
		
		//driver.quit();
		
		logger.info("browser closed ");
	}
	

	
}
