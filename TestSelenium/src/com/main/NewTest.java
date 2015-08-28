package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.xml.DOMConfigurator;
import org.autorumba.operation.RumbaOperation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import outputreports.Log;

import com.Pages.Login_OPS_PI_Page;
import com.core.BrowserWrapper;
import com.core.RumbaWrapper;
import com.utility.Excelutils;

public class NewTest {
	BrowserWrapper DriverMain= new BrowserWrapper();  
	RumbaWrapper Rw = new RumbaWrapper();
	
	public static Properties configprop= new Properties();
	//guiwin windowst = new guiwin();

	  
  @Test
  public void homepage() throws InterruptedException, IOException {
	  
	
	  Login_OPS_PI_Page loginOpsPi= new Login_OPS_PI_Page("http://icpfinwlk.fmr.com/");
	  
     Assert.assertEquals(loginOpsPi.Login_OPS_PI_login("CACT501","testers5","033000001"),true);
	  
	/* 
     			
	
	
	GLOBAL.RumbaInstance.SendKey("menu");
	GLOBAL.RumbaInstance.SendKey("@E");
	        
	        
	        if (GLOBAL.RumbaInstance.ReadFromScreen(6, 8, 8).trim().contains("SYSTEM")){
	        	GLOBAL.RumbaInstance.WriteOnScreen(6, 47, "14");
	        	GLOBAL.RumbaInstance.SendKey("@E");
	        }
	        
	        
	        if (GLOBAL.RumbaInstance.ReadFromScreen(40, 3, 2).trim().contains("ENTER VTAM APPLID")){
	        	GLOBAL.RumbaInstance.WriteOnScreen(3, 42, "CIGFTOR");
	        	GLOBAL.RumbaInstance.SendKey("@E");
	        }
	        
	        Thread.sleep(2000);
	        if (GLOBAL.RumbaInstance.ReadFromScreen(40, 1, 27).trim().contains("NATIONAL")){
	        	GLOBAL.RumbaInstance.SendKey("@E");
	        }
	        
	        if (GLOBAL.RumbaInstance.ReadFromScreen(12, 1, 13).trim().contains("TFC")){
	        	GLOBAL.RumbaInstance.WriteOnScreen(1, 19, "BSSO");
	        	GLOBAL.RumbaInstance.WriteOnScreen(1, 24, "SIGN");
	        	GLOBAL.RumbaInstance.WriteOnScreen(1, 29, "ON");
	        	GLOBAL.RumbaInstance.SendKey("@E");
	        }*/
     
     
     
     
     
     
	//  Excelutils ex= new Excelutils();
	//  System.out.println(ex.readdatafromxl("homepage", "pathtype", 2));
 }
  
  
  

  
  
  @BeforeClass
  public void beforeClass() throws FileNotFoundException, IOException, InterruptedException {
	  DOMConfigurator.configure("log4j.xml");
	  configprop.load(new FileInputStream("src\\com\\config\\config.properties"));
	 
	  
	  
	  try{  

	 String browser= "iexplore";
	 GLOBAL.Driver = DriverMain.startbrowser(browser);
	  Random rand = new Random();
	  int randomNum = rand.nextInt((10 - 1) + 1) + 1;
	 GLOBAL.RumbaInstance= Rw.RumbaWrapper(randomNum, "A");
	
	 
	  Thread.sleep(2000);
	  
	  
	  }
	  catch(Exception e){
	  Log.error("Unable to start webdriver. ERROR : " + e.getMessage());
	  Reporter.log("Unable to start webdriver. ERROR : " + e.getMessage(),true);
	  }
  }

  @AfterClass
  public void afterClass() {
	  try{
	// windowst.changestatus("Closing webdriver.");
	  /*GLOBAL.Driver.close();
	  GLOBAL.Driver.quit();*/
	  
	  Log.error("Closed webdriver");
	  Reporter.log("Closed webdriver");
	  }
	  catch(Exception e){
		 // windowst.changestatus("Unable to close webdriver. ERROR : " + e.getMessage());
		  Log.error("Unable to close webdriver. ERROR : " + e.getMessage());
		  Reporter.log("Unable to close webdriver. ERROR : " + e.getMessage(),true);
		  }
	  
  }

  
}
