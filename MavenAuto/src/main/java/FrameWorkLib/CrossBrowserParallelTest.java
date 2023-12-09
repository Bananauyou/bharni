package FrameWorkLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserParallelTest {
	
// Extend CrossbrowserParallelTest  in Test scripts instead of Base class, 
//Write test scripts  and convert it to XML file then change parameters, name, Value and execute 
	
	public WebDriver driver;
	public  Logger logger;
	
	public PropertyFile p=new PropertyFile();
	
   public static ReadExcel file = new ReadExcel();
	
	public WebDriverUtilies WebUtility=new WebDriverUtilies();
	
	
	@Parameters("browser")
	
	@BeforeMethod
	
	public void LaunchApp(String browser) throws IOException, InterruptedException {

		//launch browser
			switch (browser.toLowerCase()) {
				
			case "chrome": 
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
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
		
		logger = LogManager.getLogger("CrossBrowserParallelTest");
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
			Screenshot  s=new Screenshot();
			s.getPhoto(driver, name);
		}
		
		driver.quit();
		
		logger.info("browser closed ");
	}
	

}
