package com.nbcd.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

@Test
public class PGLaunchNBC 
{
	
	public WebDriver driver;
	String sql;
	
	DatabaseFunction db = new DatabaseFunction();
	
	public List<String> lstObject;
	String sqlQry,Status;
	WebElement objNBCLogo;
	
//Constructor to initialize all the Page Objects  
		public PGLaunchNBC(WebDriver driver) 
		{          
			this.driver = driver; 
			
			
		}
//=========================================================================================================================
		
	@Test
		  public boolean  LaunchNBC( ) throws InterruptedException, FilloException 
		  {
			  lstObject=db.getTestDataObject("Select * from LaunchNBC","ObjectRepository");
			  driver.get("http://www.nbc.com");
			  
			  Synchronization.waitForPageLoad(driver);
			 
			  WebElement objNBCLogo= (WebElement) Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
			  if(Synchronization.explicitWait( driver,objNBCLogo,"visible"))
			  {
					return true;
					
			  }
			  else
			  {
				  return false;
			  }
			
				
		}
			
	
		  

}