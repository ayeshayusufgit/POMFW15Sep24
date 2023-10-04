package com.democart.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_DATA_SHEET_PATH = "./src/test/resources/testData/applicationTestData_280923.xlsx";

	public static Object[][] getExcelData(String sheetName) {
		FileInputStream fis = null;
		Object[][] excelData = null;
		Workbook wb = null;
		Sheet sheet = null;
		try {
			fis = new FileInputStream(TEST_DATA_SHEET_PATH);
			wb = WorkbookFactory.create(fis);
			sheet = wb.getSheet(sheetName);
			excelData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					
						excelData[i][j]=sheet.getRow(i+1).getCell(j).toString();
						System.out.print(excelData[i][j]+"->");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelData;
	}

	public static void main(String args[]) {
		getExcelData("registration");
	}
}
