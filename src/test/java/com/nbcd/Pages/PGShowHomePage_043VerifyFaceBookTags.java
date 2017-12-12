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
public class PGShowHomePage_043VerifyFaceBookTags 
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement android_package,android_app_name,android_url,ios_app_store_id,ios_app_name,ios_url,web_url,web_should_fallback;
	WebElement fb_app_id,og_site_name,og_title,og_type,og_url,og_description,og_image,og_image_type,og_image_width,og_image_height,FaceBookUname,FaceBookUpass,FaceBookbutton,ShowPageUrl,FETCH_NEW_SCRAPE;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGShowHomePage_043VerifyFaceBookTags(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from VerifyFBTags","Input");
		lstObject=db.getTestDataObject("Select * from VerifyFBTags","ObjectRepository");
					
	}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage_043VerifyFaceBookTags VerifyFBTags( ) throws InterruptedException, FilloException 
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
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:Android_package Should display" +Extent_Reports.logActual+"Meta_Tag:Android_package is displayed",driver);
					
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:Android_package Should display" +Extent_Reports.logActual+"Meta_Tag:Android_package is not displayed",driver);

				}
			/**android_app_name*/	
				if (lstTestData.get(2).equalsIgnoreCase(android_app_name.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:Android_app_name should display" +Extent_Reports.logActual+"Meta_Tag:Android_app_name is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:Android_app_name should display" +Extent_Reports.logActual+"Meta_Tag:Android_app_name isn't getting displayed",driver);
				}
				
			/**android_url*/
				if (lstTestData.get(3).equalsIgnoreCase(android_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:Android_url should get display" +Extent_Reports.logActual+"Meta_Tag:Android_url is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:Android_url should get display"+Extent_Reports.logActual+"Meta_Tag:Android_url isn't getting displayed",driver);

				}
				
			/** ios_app_store_id */
				if (lstTestData.get(4).equalsIgnoreCase(ios_app_store_id.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:iOS_App_store_id should get display" +Extent_Reports.logActual+"Meta_Tag:iOS_App_store_id is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:iOS_App_store_id should get display"+Extent_Reports.logActual+"Meta_Tag:iOS_App_store_id isn't getting displayed",driver);

				}
				/**ios_app_name*/
				if (lstTestData.get(5).equalsIgnoreCase(ios_app_name.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:iOS_App_name should get display" +Extent_Reports.logActual+"Meta_Tag:iOS_App_name is getting displayed",driver);

				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:iOS_App_name should get display" +Extent_Reports.logActual+"Meta_Tag:iOS_App_name isn't getting displayed",driver);

				}
				
				/** ios_url */
				if (lstTestData.get(6).equalsIgnoreCase(ios_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:iOS_url should get display" +Extent_Reports.logActual+"Meta_Tag:iOS_url is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:iOS_url should get display" +Extent_Reports.logActual+"Meta_Tag:iOS_url isn't getting displayed",driver);
				}
				
				/** web_url*/
				if (lstTestData.get(7).equalsIgnoreCase(web_url.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:Web_url should get display"+Extent_Reports.logActual+"Meta_Tag:Web_url is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:Web_url should get display"+Extent_Reports.logActual+"Meta_Tag:Web_url isn't getting displayed",driver);

				}
				
				/** web_should_fallback  */
				if (lstTestData.get(8).equalsIgnoreCase(web_should_fallback.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_Tag:Web_should_fallback should be displyed" +Extent_Reports.logActual+"Meta_Tag:Web_should_fallback is getting displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_Tag:Web_should_fallback should be displyed" +Extent_Reports.logActual+"Meta_Tag:Web_should_fallback isn't getting displayed",driver);
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
