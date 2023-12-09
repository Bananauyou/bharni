package Test_Facebook;

import java.io.IOException;

import org.testng.annotations.Test;

import FrameWorkLib.BaseClass;

import Pom_Facebook.Face_login;

public class Face_log extends BaseClass{


	@SuppressWarnings("static-access")
	@Test
	public void tc() throws IOException, InterruptedException {
	
		Face_login f = new Face_login(driver);
		f.email(Rexcelfile.GetCellValue("sheet1", 1, 1));
		Thread.sleep(200);
	
       f.password (Rexcelfile.GetNumerical("sheet1", 0, 0)+" ");
       
	     Thread.sleep(3000);
		f.login();
		Thread.sleep(5000);
	
	
		
		
		
	}

}
