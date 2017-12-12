package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGShowHomePage_043VerifyFacebook_SNLTags
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement android_package,android_app_name,android_url,ios_app_store_id,ios_app_name,ios_url,web_url,web_should_fallback;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGShowHomePage_043VerifyFacebook_SNLTags(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from VerifyFBSNLTags","Input");
		lstObject=db.getTestDataObject("Select * from VerifyFBSNLTags","ObjectRepository");
			
		}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage_043VerifyFacebook_SNLTags VerifyFB_SNLTags_DBB_3078( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			    //Reading Objects
			try
			 {
				android_package =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
				android_app_name=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				android_url=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				ios_app_store_id=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				ios_app_name=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
				ios_url=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				web_url=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
				web_should_fallback=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
									
			/**android_package*/
				
				if (lstTestData.get(1).equalsIgnoreCase(android_package.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(1) +"':"+lstTestData.get(1) +Extent_Reports.logActual+lstObject.get(1) +"':"+android_package.getAttribute("content"),driver);
					
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(1) +"':"+lstTestData.get(1) +Extent_Reports.logActual+lstObject.get(1) +"':"+android_package.getAttribute("content"),driver);

				}
			/**android_app_name*/	
				if (lstTestData.get(2).equalsIgnoreCase(android_app_name.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(4) +"':"+lstTestData.get(2) +Extent_Reports.logActual+lstObject.get(4) +"':"+android_app_name.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(4) +"':"+lstTestData.get(2) +Extent_Reports.logActual+lstObject.get(4) +"':"+android_app_name.getAttribute("content"),driver);

				}
				
			/**android_url*/
				if (lstTestData.get(3).equalsIgnoreCase(android_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(7) +"':"+lstTestData.get(3) +Extent_Reports.logActual+lstObject.get(7) +"':"+android_url.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(7) +"':"+lstTestData.get(3) +Extent_Reports.logActual+lstObject.get(7) +"':"+android_url.getAttribute("content"),driver);

				}
				
			/** ios_app_store_id */
				if (lstTestData.get(4).equalsIgnoreCase(ios_app_store_id.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(10) +"':"+lstTestData.get(4) +Extent_Reports.logActual+lstObject.get(10) +"':"+ios_app_store_id.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(10) +"':"+lstTestData.get(4) +Extent_Reports.logActual+lstObject.get(10) +"':"+ios_app_store_id.getAttribute("content"),driver);

				}
				/**ios_app_name*/
				if (lstTestData.get(5).equalsIgnoreCase(ios_app_name.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(13) +"':"+lstTestData.get(5) +Extent_Reports.logActual+lstObject.get(13) +"':"+ios_app_name.getAttribute("content"),driver);

				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(13) +"':"+lstTestData.get(5) +Extent_Reports.logActual+lstObject.get(13) +"':"+ios_app_name.getAttribute("content"),driver);

				}
				
				/** ios_url */
				if (lstTestData.get(6).equalsIgnoreCase(ios_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(16) +"':"+lstTestData.get(6) +Extent_Reports.logActual+lstObject.get(16) +"':"+ios_url.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(16) +"':"+lstTestData.get(6) +Extent_Reports.logActual+lstObject.get(16) +"':"+ios_url.getAttribute("content"),driver);

				}
				
				/** web_url*/
				if (lstTestData.get(7).equalsIgnoreCase(web_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(19) +"':"+lstTestData.get(7) +Extent_Reports.logActual+lstObject.get(19) +"':"+web_url.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(19) +"':"+lstTestData.get(7) +Extent_Reports.logActual+lstObject.get(19) +"':"+web_url.getAttribute("content"),driver);

				}
				
				/** web_should_fallback  */
				if (lstTestData.get(8).equalsIgnoreCase(web_should_fallback.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(22) +"':"+lstTestData.get(8) +Extent_Reports.logActual+lstObject.get(22) +"':"+web_should_fallback.getAttribute("content"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(22) +"':"+lstTestData.get(8) +Extent_Reports.logActual+lstObject.get(22) +"':"+web_should_fallback.getAttribute("content"),driver);

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
