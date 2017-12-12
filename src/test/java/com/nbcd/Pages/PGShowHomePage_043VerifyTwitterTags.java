package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGShowHomePage_043VerifyTwitterTags 
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	protected static String screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objTwitterCard,objTwitterSite,objTwitterSiteId,objTwitterTitle,objTwitterDescription,objTwitterImage;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGShowHomePage_043VerifyTwitterTags(WebDriver driver) throws Exception 
	{      
		this.driver = driver; 
		lstTestData=db.getTestDataObject("Select * from VerifyTwitterTags","Input");
		lstObject=db.getTestDataObject("Select * from VerifyTwitterTags","ObjectRepository"); 
					
					
   }
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage_043VerifyTwitterTags VerifyTwitterTags_DBB_3079( ) throws Exception 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     try {
						screenshotExtension=Extent_Reports.getScreenshot(driver); //Initializing Screenshot Object
					} catch (Exception exc) {
						// TODO Auto-generated catch block
						Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
					}
			//Reading Objects
			try
			 {
				objTwitterCard =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
				objTwitterSite=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				objTwitterSiteId=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				objTwitterTitle=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				objTwitterDescription=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
				objTwitterImage=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				
			/**twitter:card*/
				
				if (lstTestData.get(1).equalsIgnoreCase(objTwitterCard.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta_tag:Twitter:card should be displayed" +Extent_Reports.logActual +"Meta_tag:Twitter:card is getting displayed",driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta_tag:Twitter:card should be displayed" +Extent_Reports.logActual +"Meta_tag:Twitter:card isn't getting displayed",driver);

				}
				
			/**twitter:site*/	
				if (lstTestData.get(2).equalsIgnoreCase(objTwitterSite.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Meta_tag:twitter:site should be displayed" +Extent_Reports.logActual+"Meta_tag:twitter:site is getting displayed",driver);

				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_tag:twitter:site should be displayed" +Extent_Reports.logActual+"Meta_tag:twitter:site isn't getting displayed",driver);

				}
				
			/**twitter:site:id*/
				if (lstTestData.get(3).equalsIgnoreCase(objTwitterSiteId.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta_tag:twitter:site:id should get display"+Extent_Reports.logActual+"Meta_tag:twitter:site:id is getting displayed",driver);

				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +"Meta_tag:twitter:site:id should get display"+Extent_Reports.logActual+"Meta_tag:twitter:site:id isn't getting displayed",driver);


				}
				
			/** twitter:title */
				if (lstTestData.get(4).equalsIgnoreCase(objTwitterTitle.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta_tag:twitter:title should get display" +Extent_Reports.logActual+ "Meta_tag:twitter:title is getting displayed",driver);


				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +"Meta_tag:twitter:title should get display" +Extent_Reports.logActual+ "Meta_tag:twitter:title isn't getting displayed",driver);

				}
				/**twitter:description*/
				if (objTwitterDescription.getAttribute("content").length() > 0)
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta_tag:twitter:description should be displayed" +Extent_Reports.logActual+"Meta_tag:twitter:description is getting displayed",driver);

				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +"Meta_tag:twitter:description should be displayed" +Extent_Reports.logActual+"Meta_tag:twitter:description isn't getting displayed",driver);

				}
			 }
			 catch(Exception exc)
			 {
					Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
			 }
			
			//driver.close(); 
			
			return null;
		}
				
	
	  
}
