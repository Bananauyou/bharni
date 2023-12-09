package Pom_Facebook;

import java.awt.print.Pageable;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Face_login {
	
	
	@FindBy(id = "email") 
	private WebElement username;
	public void email(String user) {
		username.sendKeys(user);
	}
	
		@FindBy(name = "pass")
	private WebElement pass;
	public void password(String d) {
		pass.sendKeys(d);
	}
	
	@FindBy(name = "login")
	private WebElement log;
	public void login() {
		log.click();
	}

	public Face_login(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
	}

	
	
}
