package Excel_Test;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import FrameWorkLib.InputExcel_Data;


public class UserExcelData  {
	
	@Test
public void tc() throws EncryptedDocumentException, IOException, NullPointerException {
		Scanner row = new Scanner(System.in);
		System.out.println("Enter the Rowno");
		int Rowno = row.nextInt();
		
		Scanner colm = new Scanner(System.in);
		System.out.println("Enter ColumeNo");
		int colomNo = colm.nextInt();
		

		
		 Scanner value = new Scanner(System.in);
		 System.out.println(" Enter The Values");
		 String dataEntry = value.next();
		 
		/*  WriteDataExcelYoutube data = new WriteDataExcelYoutube();
           data.SetCellValue(value);
         */
           
		 InputExcel_Data data  = new InputExcel_Data();
		 data.ExcelData( Rowno, colomNo, dataEntry);	 
	
}
}
