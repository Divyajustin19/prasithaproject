package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Demo {
	
	@Test
	 public void readExcel() throws Exception {
		 
	
	File src = new File("F:\\livescore\\criccbuzz1.xlsx");
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1 = wb.getSheet("sheet1");
	
	int lastRow = sheet1.getLastRowNum();
	for(int i=0;i<=lastRow;i++) {
		String data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
		System.out.println(data1);
		
	}
		2222
	wb.close();
     }
}
