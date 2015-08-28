package com.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.utility.Excelutils;

public class main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		Excelutils ex = new Excelutils();
		//System.out.println(ex.ReturnDataFromXLRowNumColName("src/com/testdatasheets/Check Disbursements.xls",2,"Account_Number"));
		HashMap hMap= new HashMap();
		hMap=ex.ReturnRowFromXLRowNum("src/com/testdatasheets/Check Disbursements.xls", 2);
		
	
		
		
	}

}
