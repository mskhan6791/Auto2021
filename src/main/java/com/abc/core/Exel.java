package com.abc.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exel {
	XSSFWorkbook workBook = null;
	
	public Exel(String fileName) throws InvalidFormatException, IOException {
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/data/"+fileName+".xlsx");
		InputStream inputStream = new FileInputStream(file);
		workBook = new XSSFWorkbook(inputStream);
	}
	
	public String [][] getDataFordataProvider(String sheetName) throws InvalidFormatException, IOException {
		Sheet sheet = workBook.getSheet(sheetName);
		
		int numOfRow = sheet.getLastRowNum()+1;
		int numOfCell = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String[numOfRow][numOfCell];
		
		for (int i = 0; i < numOfRow; i++) {
			for (int f = 0; f <numOfCell; f++) {
				try {
					data[i][f] = sheet.getRow(i).getCell(f).getStringCellValue();
				}catch (Throwable e) {
					data[i][f]= "";
				}
			}
		}
		return data;
	} 
}
