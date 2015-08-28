package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;





public class Excelutils {
	
	
	
	
	

	public String ReturnDataFromXLRowNumColName(String ExcelSheetPath, int rownumToreturn,String colName) throws IOException{
		FileInputStream fis = new FileInputStream(
			      new File(ExcelSheetPath));
			      HSSFWorkbook workbook = new HSSFWorkbook(fis);
			      HSSFSheet spreadsheet = workbook.getSheetAt(0);
			      HSSFRow row = spreadsheet.getRow(0);
			      Iterator <Cell> cellIterator = row.cellIterator();
			      int ctrCol=0;
			      while(cellIterator.hasNext()){
			    	 Cell cell= cellIterator.next();
			    	 if (cell.toString().equalsIgnoreCase(colName)){
			    		 break;
			    	 }
			    	 ctrCol= ctrCol + 1;	  
			      }
			      
			      HSSFCell celltoreturn = spreadsheet.getRow(rownumToreturn).getCell(ctrCol);
			      
			      return (celltoreturn.toString());
	}
	
	public HashMap<String,String> ReturnRowFromXLRowNum(String ExcelSheetPath, int rownumToreturn) throws IOException{
		FileInputStream fis = new FileInputStream(new File(ExcelSheetPath));
		HashMap<String,String> hMap=new HashMap<String,String>();
			      HSSFWorkbook workbook = new HSSFWorkbook(fis);
			      HSSFSheet spreadsheet = workbook.getSheetAt(0);
			      HSSFRow row = spreadsheet.getRow(0);
			      HSSFRow row2 = spreadsheet.getRow(rownumToreturn);
			      Iterator <Cell> cellIterator = row.cellIterator();
			      Iterator <Cell> cellIterator2 = row2.cellIterator();
			      int ctrCol=0;
			      while(cellIterator.hasNext()){
			    	 Cell cell= cellIterator.next();
			    	 Cell cell2 = cellIterator2.next();
			    	  hMap.put(cell.toString(), cell2.toString());
			      }

			      return (hMap);
	}
}
