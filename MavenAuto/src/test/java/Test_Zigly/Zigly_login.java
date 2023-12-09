package Test_Zigly;

import java.io.IOException;

import org.testng.annotations.Test;

import FrameWorkLib.BaseClass;
import Pom_Zigly.Zigly1;

public class Zigly_login extends BaseClass {
	@Test
	public void tc () throws IOException, InterruptedException {
		Zigly1 z = new Zigly1(driver);
		Thread.sleep(3000);
		WebUtility.switchframe(driver);
		z.popup();
		z.profile();
		Thread.sleep(2000);
	
		z.login();
		
		
	}

}
