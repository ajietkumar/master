package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================

public class PGShowHomePage
{

//=========================================Variables=================================================================================

	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,menu_Name,show_Name,Run_time_formate,Run_Time;
	List<WebElement> objmenu,objsName,objClips,objlist,objthumbnail,objClip_title,objSunrise_Date;
	WebElement android_package,android_app_name,android_url,ios_app_store_id,ios_app_name,ios_url,web_url,web_should_fallback,objShow_Name,objTunein_Alert,objNext_Arrow,objPrev_Arrow,objDynamic_Lead_Slide,objmore_btn,objless_btn,objAd_Banner,objrun_time_format,objEpisode,objcurrent_video,objEpisode_video;
	WebElement fb_app_id,og_site_name,og_title,og_type,og_url,og_description,og_image,og_image_type,og_image_width,og_image_height,FaceBookUname,FaceBookUpass,FaceBookbutton,ShowPageUrl,FETCH_NEW_SCRAPE,objClip_Header,objfilter,objfil,objfirst_clip,objClipDetailbtn,objFull_Episode,objClassic_Tab,objClassic_video;
	WebElement objupcomingtab,objvideo,objAd,objguest_calendar_header,objguesthighlighted,objguestday,objguestdate,objcalendar_arrow_next_btn,objcalendar_arrow_prev_btn;
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
 	
	public PGShowHomePage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from VerifyFBTags","Input");
		lstObject=db.getTestDataObject("Select * from VerifyFBTags","ObjectRepository");
	}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGShowHomePage VerifyFBTags_DBB_3078( ) throws InterruptedException, FilloException 
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
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta_tag:android_package should get display"+Extent_Reports.logActual+"Meta_tag:android_package is getting displayed",driver);
					
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta_tag:android_package should get display"+Extent_Reports.logActual+"Meta_tag:android_package isn't getting displayed",driver);

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
			//========================================================================BUSINESS VALIDATION LOGIC=================================================
	
				@Test
				  public PGShowHomePage VerifymetaTags_DBB_3087( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions act = new Actions(driver);
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						fb_app_id =Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
						og_site_name=Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
						og_title=Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
						og_type=Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
						og_url=Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
						og_description=Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
						og_image=Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
						og_image_type=Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
						og_image_width=Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
						og_image_height=Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
						
																	
					/**fb_app_id*/
						
						if (lstTestData.get(9).equalsIgnoreCase(fb_app_id.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(25) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(25) +"':"+fb_app_id.getAttribute("content"),driver);
							
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(25) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(25) +"':"+fb_app_id.getAttribute("content"),driver);

						}
					/**og_site_name*/	
						if (lstTestData.get(10).equalsIgnoreCase(og_site_name.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(28) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(28) +"':"+og_site_name.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(28) +"':"+lstTestData.get(10) + Extent_Reports.logActual+lstObject.get(28) +"':"+og_site_name.getAttribute("content"),driver);

						}
						
					/**og_title*/
						if (lstTestData.get(11).equalsIgnoreCase(og_title.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(31) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(31) +"':"+og_title.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(31) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(31) +"':"+og_title.getAttribute("content"),driver);

						}
						
					/** og_type */
						if (lstTestData.get(12).equalsIgnoreCase(og_type.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(34) +"':"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(34) +"':"+og_type.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(34) +"':"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(34) +"':"+og_type.getAttribute("content"),driver);

						}
						/**og_url*/
						if (lstTestData.get(13).contentEquals(og_url.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(37) +"':"+lstTestData.get(13) +Extent_Reports.logActual+lstObject.get(37) +"':"+og_url.getAttribute("content"),driver);

						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(37) +"':"+lstTestData.get(13) +Extent_Reports.logActual+lstObject.get(37) +"':"+og_url.getAttribute("content"),driver);

						}
						
						/** og_description */
						if (lstTestData.get(14).contentEquals(og_description.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(40) +"':"+lstTestData.get(14) +Extent_Reports.logActual+lstObject.get(40) +"':"+og_description.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(40) +"':"+lstTestData.get(14) +Extent_Reports.logActual+lstObject.get(40) +"':"+og_description.getAttribute("content"),driver);

						}
						
						/** og_image*/
						if (lstTestData.get(15).equalsIgnoreCase(og_image.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(43) +"':"+lstTestData.get(15) +Extent_Reports.logActual+lstObject.get(43) +"':"+og_image.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(43) +"':"+lstTestData.get(15) +Extent_Reports.logActual+lstObject.get(43) +"':"+og_image.getAttribute("content"),driver);

						}
						
						/** og_image_type  */
						if (lstTestData.get(16).equalsIgnoreCase(og_image_type.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(46) +"':"+lstTestData.get(16) +Extent_Reports.logActual+lstObject.get(46) +"':"+og_image_type.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(46) +"':"+lstTestData.get(16) +Extent_Reports.logActual+lstObject.get(46) +"':"+og_image_type.getAttribute("content"),driver);

						}
						
						/** og_image_width  */
						if (lstTestData.get(17).equalsIgnoreCase(og_image_width.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(49) +"':"+lstTestData.get(17) +Extent_Reports.logActual+lstObject.get(49) +"':"+og_image_width.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(49) +"':"+lstTestData.get(17) +Extent_Reports.logActual+lstObject.get(49) +"':"+og_image_width.getAttribute("content"),driver);

						}

						/** og_image_height  */
						if (lstTestData.get(18).equalsIgnoreCase(og_image_height.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(52) +"':"+lstTestData.get(18) +Extent_Reports.logActual+lstObject.get(52) +"':"+og_image_height.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(52) +"':"+lstTestData.get(18) +Extent_Reports.logActual+lstObject.get(52) +"':"+og_image_height.getAttribute("content"),driver);

						}
						
						driver.navigate().to(lstTestData.get(19));
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						Synchronization.waitForPageLoad(driver);
						((JavascriptExecutor) driver).executeScript("document.getElementById('email').value=\"nbcqaoffshore1@gmail.com\";");
						//FaceBookUname.sendKeys(lstTestData.get(20));
						Extent_Reports.executionLog("PASS","Expected: Enter UserName"+ Extent_Reports.logExpected+lstObject.get(55),driver);

						//FaceBookUname.sendKeys(lstTestData.get(21));
						((JavascriptExecutor) driver).executeScript("document.getElementById('pass').value=\"@nbcqaoffshore1\";");
						Extent_Reports.executionLog("PASS","Expected: Enter Password"+ Extent_Reports.logExpected+lstObject.get(58),driver);

						((JavascriptExecutor) driver).executeScript("document.getElementById('loginbutton').click();");
						Extent_Reports.executionLog("PASS","Expected: Click on Log in Button"+ Extent_Reports.logExpected+lstObject.get(61),driver);
						
						Synchronization.waitForPageLoad(driver);
						
						ShowPageUrl=Utilities.returnElement(driver,lstObject.get(64),lstObject.get(65));
						((JavascriptExecutor) driver).executeScript("arguments[0].value=\"https://www.nbc.com/this-is-us?nbc=1\";", ShowPageUrl,driver);
						//ShowPageUrl.sendKeys(lstTestData.get(22));
						Extent_Reports.executionLog("PASS","Enter the show home page url in input url field"+ Extent_Reports.logExpected+lstObject.get(65),driver);
						
						FETCH_NEW_SCRAPE=Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
						act.moveToElement(FETCH_NEW_SCRAPE).click().build().perform();
						Extent_Reports.executionLog("PASS","Click on the Fetch NEW SCRAPE INFORMATION"+ Extent_Reports.logExpected+lstObject.get(67),driver);
						
                        /**fb_app_id*/
						
						if (lstTestData.get(9).equalsIgnoreCase(fb_app_id.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(25) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(25) +"':"+fb_app_id.getAttribute("content"),driver);
							
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(25) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(25) +"':"+fb_app_id.getAttribute("content"),driver);

						}
					/**og_site_name*/	
						if (lstTestData.get(10).equalsIgnoreCase(og_site_name.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(28) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(28) +"':"+og_site_name.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(28) +"':"+lstTestData.get(10) + Extent_Reports.logActual+lstObject.get(28) +"':"+og_site_name.getAttribute("content"),driver);

						}
						
					/**og_title*/
						if (lstTestData.get(11).equalsIgnoreCase(og_title.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(31) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(31) +"':"+og_title.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(31) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(31) +"':"+og_title.getAttribute("content"),driver);

						}
						
					/** og_type */
						if (lstTestData.get(12).equalsIgnoreCase(og_type.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(34) +"':"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(34) +"':"+og_type.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(34) +"':"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(34) +"':"+og_type.getAttribute("content"),driver);

						}
						/**og_url*/
						if (lstTestData.get(13).equalsIgnoreCase(og_url.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(37) +"':"+lstTestData.get(13) +Extent_Reports.logActual+lstObject.get(37) +"':"+og_url.getAttribute("content"),driver);

						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(37) +"':"+lstTestData.get(13) +Extent_Reports.logActual+lstObject.get(37) +"':"+og_url.getAttribute("content"),driver);

						}
						
						/** og_description */
						if (lstTestData.get(14).equalsIgnoreCase(og_description.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(40) +"':"+lstTestData.get(14) +Extent_Reports.logActual+lstObject.get(40) +"':"+og_description.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(40) +"':"+lstTestData.get(14) +Extent_Reports.logActual+lstObject.get(40) +"':"+og_description.getAttribute("content"),driver);

						}
						
						/** og_image*/
						if (lstTestData.get(15).equalsIgnoreCase(og_image.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(43) +"':"+lstTestData.get(15) +Extent_Reports.logActual+lstObject.get(43) +"':"+og_image.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(43) +"':"+lstTestData.get(15) +Extent_Reports.logActual+lstObject.get(43) +"':"+og_image.getAttribute("content"),driver);

						}
						
						/** og_image_type  */
						if (lstTestData.get(16).equalsIgnoreCase(og_image_type.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(46) +"':"+lstTestData.get(16) +Extent_Reports.logActual+lstObject.get(46) +"':"+og_image_type.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(46) +"':"+lstTestData.get(16) +Extent_Reports.logActual+lstObject.get(46) +"':"+og_image_type.getAttribute("content"),driver);

						}
						
						/** og_image_width  */
						if (lstTestData.get(17).equalsIgnoreCase(og_image_width.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(49) +"':"+lstTestData.get(17) +Extent_Reports.logActual+lstObject.get(49) +"':"+og_image_width.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(49) +"':"+lstTestData.get(17) +Extent_Reports.logActual+lstObject.get(49) +"':"+og_image_width.getAttribute("content"),driver);

						}

						/** og_image_height  */
						if (lstTestData.get(18).equalsIgnoreCase(og_image_height.getAttribute("content")))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(52) +"':"+lstTestData.get(18) +Extent_Reports.logActual+lstObject.get(52) +"':"+og_image_height.getAttribute("content"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(52) +"':"+lstTestData.get(18) +Extent_Reports.logActual+lstObject.get(52) +"':"+og_image_height.getAttribute("content"),driver);

						}

					 }
					
					
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
							
			driver.close(); 
			
			return null;
		}
				
	//=======================044-Desktop(990px and above) - Verify Show Name and Tune-in Alert values on Dynamic Lead slide are powered by Short Title field and Tune-in field of the TV Show content type in Pub7 (NBCRESP-793) =================================================
				
				@Test
				  public PGShowHomePage Verify_Show_Name_and_TuneIn_Alert_NBCRESP_793( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(23));
					
					     Actions Action = new Actions(driver);
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						
						objmenu=Utilities.returnElements(driver,lstObject.get(182),lstObject.get(181));
						for(WebElement mainmanu: objmenu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(24))){
								Action.moveToElement(mainmanu).click().build().perform();
								break;
							}
						}
						System.out.println("show menu clicked");
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objsName=Utilities.returnElements(driver,lstObject.get(185),lstObject.get(184));
						for(WebElement showname: objsName ){
						//for (int j=0;j<=objsName.size();j++){
							if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(showname).click().build().perform();
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objShow_Name =Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
						System.out.println(objShow_Name.getAttribute("innerHTML"));
						
						/**Show_Name*/
						if (objShow_Name.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Expected Show Name should be displayed: "+objShow_Name.isDisplayed()+Extent_Reports.logActual+"':"+objShow_Name.getAttribute("innerHTML"),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Expected Show Name should be displayed: "+objShow_Name.isDisplayed()+Extent_Reports.logActual+"':"+objShow_Name.getAttribute("innerHTML"),driver);

						}

						
						objTunein_Alert =Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
						System.out.println(objShow_Name.getText());
						
						/**Tunein_Alert*/
						if (objTunein_Alert.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Expected Tune-in Alert should be displayed: "+ objTunein_Alert.isDisplayed() +Extent_Reports.logActual+"':"+objTunein_Alert.getText(),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Expected Tune-in Alert should be displayed: "+ objTunein_Alert.isDisplayed() +Extent_Reports.logActual+"':"+objTunein_Alert.getText(),driver);

						}
  
					 }
					
					
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
							
			driver.close(); 
			
			return null;
		}
				
				
//=======================Desktop (990px and up) - To verify if Entire Dynamic Lead Slide is Clickable for Global and Show Home Pages - (NBCRESP-1163) =================================================
				
				@Test
				  public PGShowHomePage Verify_Dynamic_Lead_Slide_NBCRESP_1163( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(23));
					     Actions act = new Actions(driver);
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						
						objNext_Arrow =Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
						System.out.println("button slick-arrow slick-next: "+ objNext_Arrow.isDisplayed());
						act.moveToElement(objNext_Arrow).build().perform();
						/**slick-arrow slick-next button*/
						if (objNext_Arrow.isDisplayed())
						{
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "slick-arrow slick-next button Should be displayed: "+objNext_Arrow.isDisplayed()+ Extent_Reports.logActual +  "slick-arrow slick-next button: "+objNext_Arrow.getText(),driver);
						} else
						{
						Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "slick-arrow slick-next button Should be displayed: "+objNext_Arrow.isDisplayed()+ Extent_Reports.logActual +  "slick-arrow slick-next button: "+objNext_Arrow.getText(),driver);
						}
						
						objNext_Arrow.click();
						objNext_Arrow.click();
						Synchronization.implicitWait(driver, 2000);
												
						objPrev_Arrow =Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
						System.out.println("button slick-arrow slick-prev: "+ objPrev_Arrow.isDisplayed());
						act.moveToElement(objPrev_Arrow).build().perform();
						/**slick-arrow slick-prev button*/
						if (objPrev_Arrow.isDisplayed())
						{
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "slick-arrow slick-prev button Should be displayed: "+objPrev_Arrow.isDisplayed()+ Extent_Reports.logActual +  "slick-arrow slick-prev button: "+objPrev_Arrow.getText(),driver);
						} else
						{
						Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "slick-arrow slick-prev button Should be displayed: "+objPrev_Arrow.isDisplayed()+ Extent_Reports.logActual +  "slick-arrow slick-prev button: "+objPrev_Arrow.getText(),driver);
						}
						
						objPrev_Arrow.click();
						Synchronization.implicitWait(driver, 2000);
						
						objDynamic_Lead_Slide =Utilities.returnElement(driver,lstObject.get(119),lstObject.get(118));
						objDynamic_Lead_Slide.click();
						Synchronization.waitForPageLoad(driver);
						System.out.println(driver.getCurrentUrl());
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Expected user should be navigated to: "+" destination URL "+ Extent_Reports.logActual +  "User should be navigated to: "+driver.getCurrentUrl(),driver);
						
						
						
					 }
					
					
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
							
			driver.close(); 
			
			return null;
		}

//======================= Desktop - Verify More/Less button appears when unnecessary in "About The Show" section on responsive Show home page (NBCRESP-1573) =================================================
				
				@Test
				  public PGShowHomePage Verify_About_The_Show_NBCRESP_1573( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(26));
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception exc) {
								// TODO Auto-generated catch block
								Extent_Reports.logger.log(LogStatus.FAIL,exc.getMessage());
							}
					//Reading Objects
					try
					 {
						
						((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
						
						objmore_btn=Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
						if(objmore_btn.getLocation().getX()==0){
							//System.out.println("More Button is displayed: "+ objmore_btn.isDisplayed());
							Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Expected More button should not be displayed: "+ Extent_Reports.logActual +  "More button should not be displayed: ",driver);
							
							}else{
							Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Expected More button should not be displayed: "+ Extent_Reports.logActual +  "More button should not be displayed: " ,driver);
							}
						
						Thread.sleep(4000);
				/*		objless_btn=Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
						if(objless_btn.getLocation().getX()==0){
							//System.out.println("button slick-arrow slick-prev: "+ objless_btn.isDisplayed());
							Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Expected Less button should not be displayed: "+ Extent_Reports.logActual +  "Less button should not be displayed: " ,driver);
							}else{
							Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Expected Less button should not be displayed: "+ Extent_Reports.logActual +  "Less button should not be displayed: ", driver);
							}
				*/		
					 }
					
					
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
							
			driver.close(); 
			
			return null;
		}
		

				
  }