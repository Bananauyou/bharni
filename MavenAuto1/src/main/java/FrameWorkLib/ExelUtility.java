 package FrameWorkLib;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



// Under construction Yet to be implemented and tested 

public class ExelUtility {
	// to get data from excel sheet 
	public String GetCellValue (String sheetName, int RowNo, int CellNo) throws EncryptedDocumentException, FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelpath);
		
		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(RowNo);
		Cell cell = row.createCell(CellNo);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell); 
		String value1 = workbook.getSheet("sheet1").getRow(RowNo).getCell(CellNo).getStringCellValue();
		return value;
		
	}
	
	// to insert into excel sheet 
	
	public void InsertIntoExcel (String sheetName,int RowNo , int CellNo, String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(AutoConstant.excelpath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(RowNo);
		Cell cell = row.createCell(CellNo);
		cell.setCellValue(data);
		FileOutputStream fos= new FileOutputStream(AutoConstant.excelpath);
		workbook.write(fos);	
	}
		// to get the last used row no from excel 
	public int getLastrownofromExcel( String sheetName ) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(AutoConstant.excelpath));
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
		
	}



	

}
