package FrameWorkLib;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public  Logger logger;
	public ChromeOptions options;
	
	public PropertyFile p=new PropertyFile();
	
   public static ReadExcel Rexcelfile = new ReadExcel();
  
	public static ExelUtility Excel= new ExelUtility();
	
	public WebDriverUtilies WebUtility=new WebDriverUtilies();

	@BeforeMethod
	public void OpenApp() throws IOException, InterruptedException {
		
        String browser = p.getPropertyFileldata("browser");
		//launch browser
			switch (browser.toLowerCase()) {
				
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				options= new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				driver = new ChromeDriver(options);
				
				break;

			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
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
