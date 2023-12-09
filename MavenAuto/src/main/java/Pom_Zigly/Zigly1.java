package Pom_Zigly;

import java.awt.geom.Ellipse2D.Double;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkLib.ReadExcel;

public class Zigly1 {
	
	@FindBy(xpath = "//*[@id=\"close-icon\"]") 
	private WebElement pop;
	public void popup() {
		pop.click();
	}
			
	@FindBy(xpath = "(//div[text()='Profile'])[2]")
	private WebElement profile;
	
	public void profile() {
		profile.click();
	}

	@FindBy(id = "social_login_email")
	private WebElement mob;
	
	public void password(String data) {
	mob.sendKeys(data);	
	}
		
	@FindBy(xpath = "(//span[text()=\"Continue\"])[1]") 
	private WebElement cont;
	public void login() {
		cont.click();	
	}
	public Zigly1(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	
	
	

}
