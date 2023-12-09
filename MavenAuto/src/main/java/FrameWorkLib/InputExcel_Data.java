package FrameWorkLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class InputExcel_Data {
	
public void  ExcelData (int Row ,int Colume,String dataEntry) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis  =  new FileInputStream(AutoConstant.excelpath);

	
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet2");
	
	//go to the row
	//Row row = sheet.getRow(0);
	Row row = sheet.createRow(Row);
	
	
	//go to cell
	//Cell cell = row.getCell(0);
	
	Cell  cell = row.createCell(Colume);
	
	//pass the data inside the excelfile
	//cell.setCellValue("Skillrary is a online app");
	 cell.setCellValue (dataEntry);
	
	
	FileOutputStream fos=new FileOutputStream(AutoConstant.excelpath);

	//provide write premissions
	workbook.write(fos);

	workbook.close();
}

}