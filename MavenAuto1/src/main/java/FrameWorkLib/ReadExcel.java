package FrameWorkLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.CharacterData;

public class ReadExcel {
	

 

public String GetCellValue(String sheet, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet("sheet1").getRow(rowNo).getCell(cellNo).getStringCellValue();
		
        return value;		
	
	}


	public String GetNumerical(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		String data =( (int) workbook.getSheet("sheet1").getRow(row).getCell(cell).getNumericCellValue()+ " ");
		return data;
	}


	
	
}
