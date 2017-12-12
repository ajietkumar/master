package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGShowHomePage_VerifyThe300x250_Display_Ad
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	List<WebElement> HeaderTitle,No_of_Videos;
	WebElement Ad_Width_Heigth,Load_button;
	int Episodes_count,loadButton;

//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGShowHomePage_VerifyThe300x250_Display_Ad(WebDriver driver) throws Exception 
	{      
		this.driver = driver;	
		lstTestData=db.getTestDataObject("Select * from VerifyDispayAd","Input");
		lstObject=db.getTestDataObject("Select * from VerifyDispayAd","ObjectRepository");
				
					
	}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage_VerifyThe300x250_Display_Ad VerifyDisplayAD_DBB_3679( ) throws InterruptedException, FilloException 
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
				HeaderTitle =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
				Actions act = new Actions(driver);
				WebDriverWait wait = new WebDriverWait(driver,50);
  				String Header=HeaderTitle.get(0).getAttribute("innerHTML");
			 	String[] parts = Header.split(" ");
				String part1 = parts[1]; 
				String part2 = part1.replaceAll("\\p{P}","");
			 	Episodes_count = Integer.parseInt(part2);
				loadButton = Math.round(Episodes_count/6)+1;
				Ad_Width_Heigth=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				
				/**Ad_Width_Heigth*/
				if (lstTestData.get(1).equalsIgnoreCase(Ad_Width_Heigth.getAttribute("style")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta_tag:Ad_Width_Heigth should get display" +Extent_Reports.logActual +"Meta_tag:Ad_Width_Heigth is getting displayed",driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +  "Meta_tag:Ad_Width_Heigth should get display" +Extent_Reports.logActual +"Meta_tag:Ad_Width_Heigth isn't getting displayed",driver);
				}
				
				Load_button=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				
		if (Episodes_count>5)
			{
				for (int j=0;j<=loadButton;j++)
						{
					Synchronization.implicitWait(driver, 9000);
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,50)","");
					wait.until(ExpectedConditions.elementToBeClickable(Load_button));
					if (Load_button.isDisplayed())	{
					((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", Load_button);
					act.moveToElement(Load_button).doubleClick().perform();
					Synchronization.implicitWait(driver, 9000);
					No_of_Videos=Utilities.returnElements(driver,lstObject.get(11),lstObject.get(10));
					System.out.println("No of videos : "+No_of_Videos.size());
						
						/**Verify the Ad_Width_Heigth After click on load_Button Episodes Section of Show Home Page*/
						if (lstTestData.get(1).equalsIgnoreCase(Ad_Width_Heigth.getAttribute("style")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Verify the Ad_Width_Heigth After click on load_Button Episodes Section of Show Home Page" + lstObject.get(4) +"':"+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(0) +"':"+Ad_Width_Heigth.getAttribute("style"),driver);
						}	
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Verify the Ad_Width_Heigth After click on load_Button Episodes Section of Show Home Page" +lstObject.get(0) +"':"+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(0) +"':"+Ad_Width_Heigth.getAttribute("style"),driver);
						}		
												 }
							}
			}
				Synchronization.implicitWait(driver, 8000);
				No_of_Videos=Utilities.returnElements(driver,lstObject.get(11),lstObject.get(10));
				System.out.println("After full page load , No of videos : "+No_of_Videos.size());
				
				/**Verify the Ad_Width_Heigth After Full Episodes Section of Show Home Page*/
				if (lstTestData.get(1).equalsIgnoreCase(Ad_Width_Heigth.getAttribute("style")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Verify the Ad_Width_Heigth After Full Episodes Section of Show Home Page" + lstObject.get(4) +"':"+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(0) +"':"+Ad_Width_Heigth.getAttribute("style"),driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Verify the Ad_Width_Heigth After Full Episodes Section of Show Home Page" +lstObject.get(0) +"':"+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(0) +"':"+Ad_Width_Heigth.getAttribute("style"),driver);
				}				
			 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}
				
	
	  
}
