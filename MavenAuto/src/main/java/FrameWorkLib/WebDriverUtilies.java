package FrameWorkLib;

import java.util.Set;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilies {
	
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);	
	}
	
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void dragdrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void switchframe(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void switchbackframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	public void switchingTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String c:child) {
			driver.switchTo().window(c);
		}
	}
	
	public void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public void disablechromenotifications (WebDriver driver) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver1=new ChromeDriver(option);
		 
	}

	public void disableFireFoxnotifications() {
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver1=new FirefoxDriver(options);
		
	}
}
