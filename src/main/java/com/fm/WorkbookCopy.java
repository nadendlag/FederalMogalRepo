package com.fm;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WorkbookCopy {

	public String [][] workbookCopyfunc(int n,File f) throws BiffException, IOException{
		
	Workbook wb = Workbook.getWorkbook(f);
	Sheet sheet = wb.getSheet(n);
	int Rows = sheet.getRows();
	int Coloumns = sheet.getColumns();
	String distLightVehRegArray[][] = new String[Rows][Coloumns];
	
	 //String distLightVehRegArray[][] = new String[Rows][Coloumns];
	 for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Coloumns; j++) {
				Cell c = sheet.getCell(j, i);
				// Now to get contents from string array
				distLightVehRegArray[i][j] = c.getContents();
			}
		}
	    // return distLightVehRegArray;
	 return distLightVehRegArray;
	}
}