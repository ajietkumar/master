package com.nbcd.Pages;
//=======================================PACKAGES=================================================================================================
import com.nbcd.Pages.PGLaunchNBC;

import com.relevantcodes.extentreports.LogStatus;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.*;

@Test
//=======================================CLASS & METHODS===========================================================================================
public class PGHomePage 
{
	
	private WebDriver driver;
	protected static String showDetails,screenshotExtension;
	public List<String> lstObject,lstTestData;
	String sql,sqlQry,Status;;
	WebElement objMenu;
	DatabaseFunction db = new DatabaseFunction();
	int iLoop;
//=================================================Business Logic====================================================================
//Constructor to initialize all the Page Objects  

	public PGHomePage(WebDriver driver) throws MalformedURLException 
	{      
		this.driver = driver; 
				
	}
//=========================================================================================================================
	/** MenuDetails: Verify the menu details on Home Page. 
	 * @throws Exception */
	@Test
	  public PGHomePage MenuDetails( ) throws Exception 
	  {
		  /** Launching NBC Website **/
		  if(new PGLaunchNBC(driver).LaunchNBC())
		  {
			  Assert.assertTrue(true,"NBC Logo is visible.");
			  
		  }
		  else
		  {
			  Assert.assertFalse(false,"NBC Logo is not visible.");
		  }
		  
		  Synchronization.waitForPageLoad(driver);
		  
		  lstObject=db.getTestDataObject("Select * from HomePage","ObjectRepository"); //Reading Object from HomePage Sheet
		  
		  lstTestData=db.getTestDataObject("Select * from HomePage where Menu IS NOT NULL","Input"); //Reading Test Data from HomePage Sheet
		
		  try {
				screenshotExtension=Extent_Reports.getScreenshot(driver);  //Initializing Screenshot Object
			} catch (Exception exc) {
				
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
			}
		try
		 {
			List<WebElement> totalNavigationmenu = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)); //Retrieving Object
			
			Iterator<WebElement> iter = totalNavigationmenu.iterator();
		  
			while(iter.hasNext()) 
			{
				WebElement we = iter.next();
				for ( iLoop = 0; iLoop < lstTestData.size();iLoop++) 
				{
					if (lstTestData.get(iLoop).equalsIgnoreCase(we.getText()))
					{
						
						Assert.assertEquals(lstTestData.get(iLoop), we.getText(),"Expected Navigation Link is available.");
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Menu:"+ lstTestData.get(iLoop) +Extent_Reports.logActual +  "Menu:"+we.getText(),driver);
						break;
					}
					
					
				}
		     
			}
		  }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
	//	driver.close();
		return null;
	
	}
			
	
	
}
