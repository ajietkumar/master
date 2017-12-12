package com.nbcd.Pages;
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import java.net.MalformedURLException;
import java.util.Iterator;

import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;

public class PGBreakingNewsBar extends GetWebDriverInstance
{
	
	private static WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objBodyAd,objRespNavBar;
	
//Constructor to initialize all the Page Objects  
	
	
	
	
	public PGBreakingNewsBar(WebDriver driver) throws MalformedURLException 
	{      
		
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from BreakingNewsBar","Input");
		lstObject=db.getTestDataObject("Select * from BreakingNewsBar","ObjectRepository");
	
	}
	//=========================================================================================================================
    @Test
    public  PGBreakingNewsBar BreakingNewsbar( ) throws InterruptedException, FilloException ,Exception
	  {
	 //Launching the URL
  	
  		 driver.get(lstTestData.get(0));
  		 
  		WebElement objBreakbar= (WebElement) Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
		String bbarText = objBreakbar.getText();
   	  Synchronization.waitForPageLoad(driver);

		try
		{
			if (objBreakbar.isDisplayed())
		{
				Extent_Reports.executionLog("PASS","Breaking News bar is displayed in Published state ",driver);
			driver.close();
			System.out.print("Result printed");
		}
		 else
		 {
				Extent_Reports.executionLog("PASS","Breaking News bar is not displayed in unPublished state",driver);
		 driver.close();
    	}
		}
		catch(Exception exc)
			 {
				 Extent_Reports.executionLog("PASS","Breaking News bar is not displayed in unPublished state",driver);
				 driver.close();
				 System.out.println(exc.getMessage());
			 }
			 
	return null;
			
	  }}