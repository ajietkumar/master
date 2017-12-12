package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGShowHomePage_VerifyFilter 
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objFilter_Section,objdrop_down,Filter_Section;
	List<WebElement> objlist_size,objList_item;
	
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGShowHomePage_VerifyFilter(WebDriver driver) throws Exception 
	{      
		
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from VerifyFilter","Input");
		lstObject=db.getTestDataObject("Select * from VerifyFilter","ObjectRepository");
					
	}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage_VerifyFilter VerifyFilter_DBB_3687( ) throws Exception 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     
			     try {
						screenshotExtension=Extent_Reports.getScreenshot(driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			try
			 {
				Filter_Section = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_tag:Reading Objects should be displayed" +Extent_Reports.logActual+"Meta_tag:Reading Objects is getting displayed",driver);
			 }
				catch(Exception e){	
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_tag:Reading Objects should be displayed" +Extent_Reports.logActual+"Meta_tag:Reading Objects isn't getting displayed",driver);
			
			}
				
		  
			 
			driver.close(); 
			
			return null;
		}
				
	
	  
}
