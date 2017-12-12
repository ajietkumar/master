package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
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
public class PGAllVideosPage 
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_Name,Show_Title,Show_Date,og_title,type,og_url,thumbnail,image_type,image_width,image_height,video_embed_url,menu_Name,show_Name,Episode_Menu,Page_URL,Episode_Title,Full_episodes_url;
	String clips_url,popular_url,classics_url,video_url,meta_tag,strlowerCaseText,strReplaceSpaceText,descrption,ShowlistText;
	String strFinEpisodeName;
	WebElement video_secure_url,objTV_Show_Title,objEpisode_Title,objAirdate,objmeta_tag,obj_Title,objGShClk,objDrpshclk;
	boolean sorted = true;
	WebElement objEpisodes,objepisode_Title,objepisode_Date,objshow_Name,first_Video,playerIframe,ele,objog_title,objog_type,objog_url,objog_description,objog_image,objog_image_type,objog_image_width,objog_image_height,objvideo_secure_url,objvideo_embed_url,fb_app_id,og_site_name;
	List<WebElement> list,menu,sName,objmenu,objsName,menu_list;
	ArrayList<String> array;
	ArrayList<Date> arr2;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGAllVideosPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGAllVideosPage","Input");
		lstObject=db.getTestDataObject("Select * from PGAllVideosPage","ObjectRepository");
	}
//=========================================== verify the page redirect rules for all All legacy Video URLs  (DBB-3761) =================================================
	@Test
		  public PGAllVideosPage Verify_Page_redirect_DBB_3761( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     
			     try {
			    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
					 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			 
	
			try
			 {
							
				driver.navigate().to(lstTestData.get(1));
				
				
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC FULL EPISODES page should Launch"+Extent_Reports.logActual+"NBC FULL EPISODES page launched succesfull",driver);
				Full_episodes_url= driver.getCurrentUrl();
				driver.navigate().back();
				
                /**full-episodes*/
				
				if (lstTestData.get(5).contentEquals(Full_episodes_url))
				{	
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Full Episodes URL is :"+ lstTestData.get(1) + "Should be redirected "+ Extent_Reports.logActual + "Full Episodes page is redirected to :"+ Full_episodes_url , driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Full Episodes URL is :"+ lstTestData.get(1) +"Should be redirected "+ Extent_Reports.logActual + "Full Episodes page is redirected to :"+ Full_episodes_url, driver);

				}
				
				driver.navigate().to(lstTestData.get(2));
				Synchronization.implicitWait(driver, 30);
				Synchronization.waitForPageLoad(driver);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Clips Video page should Launch"+Extent_Reports.logActual+"NBC Clips Video page launched succesfull",driver);
				clips_url= driver.getCurrentUrl();
				driver.navigate().back();
				Synchronization.implicitWait(driver, 30);

				/**clips*/
				
				if (lstTestData.get(5).contentEquals(clips_url))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Clips video URL is :"+ lstTestData.get(2)+ "Should be redirected "+Extent_Reports.logActual + "Clips video page is redirected to :"+ clips_url , driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Clips Video URL is :"+ lstTestData.get(2)+ "Should be redirected "+Extent_Reports.logActual + "Clips video page is redirected to :"+ clips_url , driver);

				}
		
				driver.navigate().to(lstTestData.get(3));
				Synchronization.implicitWait(driver, 30);
				Synchronization.waitForPageLoad(driver);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Popular Video page should Launch"+Extent_Reports.logActual+"NBC Popular Video page launched succesfull",driver);
				popular_url= driver.getCurrentUrl();
				driver.navigate().back();
				Synchronization.implicitWait(driver, 30);

				/**popular*/
				
				if (lstTestData.get(5).contentEquals(clips_url))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Popular Video URL is :"+ lstTestData.get(3)+"Should be redirected" +Extent_Reports.logActual + "Popular Video redirected to :"+ popular_url,driver );
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Popular Video URL is :"+ lstTestData.get(3) +"Should be redirected" +Extent_Reports.logActual + "Popular Video redirected to :"+ popular_url,driver);

				}

		
				driver.navigate().to(lstTestData.get(4));
				Synchronization.implicitWait(driver, 30);
				Synchronization.waitForPageLoad(driver);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Classics Video page should Launch"+Extent_Reports.logActual+"NBC Classics Video page launched succesfull",driver);
				classics_url = driver.getCurrentUrl();
				driver.navigate().back();
				Synchronization.implicitWait(driver, 30);

				/**classics*/
				
				if (lstTestData.get(5).contentEquals(classics_url))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Classics URL is :"+ lstTestData.get(4) + "Should be redirected" +Extent_Reports.logActual + "Classics Video redirected to :"+ classics_url ,driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Classics URL is :"+ lstTestData.get(4) + "Should be redirected" +Extent_Reports.logActual + "Classics Video redirected to :"+ classics_url ,driver);

				}
			
				driver.navigate().to(lstTestData.get(5));
				Synchronization.implicitWait(driver, 30);
				Synchronization.waitForPageLoad(driver);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Video's page should Launch"+Extent_Reports.logActual+"NBC Video's page launched succesfull",driver);
				video_url= driver.getCurrentUrl();
				driver.navigate().back();
				Synchronization.implicitWait(driver, 30);

				/**Video's*/
				
				if (lstTestData.get(5).contentEquals(video_url))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video's URL is :"+ lstTestData.get(5)+"Should be redirected" +Extent_Reports.logActual + "Video's page redirected to :"+ video_url ,driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Video's URL is :"+ lstTestData.get(5)+"Should be redirected" +Extent_Reports.logActual + "Video's page redirected to :"+ video_url ,driver);

				}
						
							
					 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}
	
	
	//------------------------Verify for Metadata Enhancements  in Recently Added Section in Full Episodes Landing Page (DBB-3727) ------------------------			
	@Test
	  public PGAllVideosPage Verify_Metadata_Enhancements_DBB_3727( ) throws InterruptedException, FilloException 
	  {
			
		//Launching Browser with valid URL.
		    driver.get(lstTestData.get(0));
		    Synchronization.implicitWait(driver, 50);
		     try {  
		    	    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
					screenshotExtension=Extent_Reports.getScreenshot(driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//Reading Objects
		try
		 {
			objEpisodes = Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
			objEpisodes.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Full Episodes Page should Launch"+Extent_Reports.logActual+"NBC Full Episodes page launched succesfull",driver);
			
			objshow_Name=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
			Show_Name = objshow_Name.getText();
			System.out.println(Show_Name);
			
			if (objshow_Name.isDisplayed())
			{
				
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Show name in metadata section of recently added column is displayed "+  Extent_Reports.logActual + "The metadata  should reflect show name on the first line: "+ Show_Name , driver );
			}	
		     
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Show name in metadata section of recently added column is displayed "+ Extent_Reports.logActual + "The metadata  should reflect show name on the first line: "+ Show_Name ,driver);

			}	
			
			
			objepisode_Title=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
			Show_Title = objepisode_Title.getText();
			System.out.println(Show_Title);
			
			if (objepisode_Title.isDisplayed())
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode title in metadata section is displayed "+ Extent_Reports.logActual + "The metadata  should reflect the Episode title on the 2nd line: "+ Show_Title , driver);
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Episode title in metadata section is displayed  "+  Extent_Reports.logActual + "The metadata  should reflect the Episode title on the 2nd line: "+ Show_Title , driver);

			}	
			
			objepisode_Date=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
			Show_Date = objepisode_Date.getAttribute("innerHTML");
			System.out.println(Show_Date);
			if (objepisode_Date.isDisplayed())
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Air date in meta data section is displayed "+ Extent_Reports.logActual + "Air date should be in line 3 of meta data section in the format MM/DD/YY: "+ Show_Date , driver );
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Air date in meta data section is displayed  "+ Extent_Reports.logActual + "Air date should be in line 3 of meta data section in the format MM/DD/YY: " + Show_Date, driver);

			}	
						
			
	 }
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
		driver.close(); 
		
		return null;
	}

	  
	//------------------------ Verify Episodes are sorted by Air Date in All Videos Page (NBCRESP-1438) ------------------------			
		@Test
		  public PGAllVideosPage Verify_Episodes_Sorted_NBCRESP_1438( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			    
			     try {
			    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);	
			    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			try
			 {
				objEpisodes = Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
				objEpisodes.click();
				Thread.sleep(20000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Full Episodes Page should Launch"+Extent_Reports.logActual+"NBC Full Episodes page launched succesfull",driver);
				array = new ArrayList<String>();
				list = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
				String strFinEpisodeName = null;
				for(int i=0;i<list.size();i++){
					array.add(list.get(i).getAttribute("innerHTML"));
					String strEpisodeName = list.get(i).getAttribute("innerHTML");
					strFinEpisodeName = strEpisodeName+strFinEpisodeName;
					
					
				}
				
				for(int i = 0; i < array.size(); i++)
			    {
			        for(int j = i+1; j < array.size()-1; j++) 
			        {
			            if (array.get(i).compareTo(array.get(j)) == 1)
			            {
			                sorted = false;
			            }  
			        }  
			    }                
			    System.out.println("sorted:"+ sorted);
			    
			   String  strFinEpisodeNamesortDates = strFinEpisodeName.substring(0, strFinEpisodeName.length()-4);
			    if (sorted==false)
				{
			    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episodes should be sorted by Air date on NBC Full Episodes Page should " + Extent_Reports.logActual+"Episodes are sorted by Air date on NBC Full Episodes Page and the dates are "+strFinEpisodeNamesortDates, driver );
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Episodes should be sorted by Air date NBC Full Episodes Page should "+ Extent_Reports.logActual+"Episodes are not sorted by Air date on NBC Full Episodes Page ", driver);

				}
			    
			    
	
			 }	
			
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}

			 
		//------------------New Responsive Web Site - Verify the display of Meta property for Integrate Open Graph in all show video detail page ( DBB-3056) ------------------------			
		@Test
		  public PGAllVideosPage Verify_video_detail_page_DBB_3056( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
		     driver.get(lstTestData.get(0));
		     Actions Action = new Actions(driver);
		     		     
		     try {
		    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);	
		    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			//Reading Objects
			try
			 {
					
				menu_list=Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
				for(WebElement MainMenu: menu_list ){
				//for(int i=0;i<=menu.size();i++){
					if((MainMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(6))){
						Action.moveToElement(MainMenu).click().build().perform();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
						break;
					}
				}
				System.out.println("show menu clicked");
				
					
				objsName=Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85));
						for(WebElement showname: objsName ){
						//for (int j=0;j<=objsName.size();j++){
							if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(7))){
								Action.moveToElement(showname).click().build().perform();
								Thread.sleep(10000);
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
								break;
							}
						}
			  Thread.sleep(50000);
			  System.out.println(driver.getCurrentUrl());
			   
			  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)","");
			  
			  first_Video = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
			  //WebElement first_Video = driver.findElements(By.cssSelector("section.video-list__item-episodes div.video-list__inner div.video-list__container a.card div.card__thumbnail")).get(0);
			  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", first_Video);
			  //first_Video.click();
			  Thread.sleep(8000);
			  //wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
			 
			  fb_app_id=Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			  //String fb_app_id = driver.findElement(By.cssSelector("meta[property='fb:app_id']")).getAttribute("content");
			  System.out.println(fb_app_id.getAttribute("content"));
			  
			  if (lstTestData.get(10).equalsIgnoreCase(fb_app_id.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Meta tag should display as: "+lstTestData.get(10) +Extent_Reports.logActual +lstObject.get(31) +"Meta tag is displayed is: "+fb_app_id.getAttribute("content"),driver);
				}	
				else
				{
				 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(10) +Extent_Reports.logActual +lstObject.get(31) +"Meta tag is displayed is: "+fb_app_id.getAttribute("content"),driver);
				}
			  
			  og_site_name = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
			  System.out.println(og_site_name);
			  
			  if (lstTestData.get(11).equalsIgnoreCase(og_site_name.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(11) +Extent_Reports.logActual +lstObject.get(34) +"Meta tag is displayed is: "+ og_site_name.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(11) +Extent_Reports.logActual +lstObject.get(34) +"Meta tag is displayed is: "+ og_site_name.getAttribute("content"),driver);

				}

			  
			  objog_title=Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37)).get(0);
			  //WebElement objog_title = driver.findElements(By.cssSelector("meta[property='og:title']")).get(0);
			  og_title = objog_title.getAttribute("content");
			  System.out.println(og_title);
			  
			  if (lstTestData.get(12).equalsIgnoreCase(objog_title.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(12) +Extent_Reports.logActual +lstObject.get(37) +"Meta tag is displayed is: "+ objog_title.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(12) +Extent_Reports.logActual +lstObject.get(37) +"Meta tag is displayed is: "+ objog_title.getAttribute("content"),driver);

				}

			  
			  objog_type=Utilities.returnElements(driver,lstObject.get(41),lstObject.get(40)).get(0);
			  //WebElement objog_type = driver.findElements(By.cssSelector("meta[property='og:type']")).get(0);
			  type =	  objog_type.getAttribute("content");
			  System.out.println(type);
			  
			  if (lstTestData.get(13).equalsIgnoreCase(objog_type.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(13) +Extent_Reports.logActual +lstObject.get(40) +"Meta tag is displayed is: "+objog_type.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(13) +Extent_Reports.logActual +lstObject.get(40) +"Meta tag is displayed is: "+objog_type.getAttribute("content"),driver);

				}

			  
			  objog_url=Utilities.returnElements(driver,lstObject.get(44),lstObject.get(43)).get(0);
			 // WebElement objog_url = driver.findElements(By.cssSelector("meta[property='og:url']")).get(0);
			  og_url =  objog_url.getAttribute("content");
			  System.out.println(og_url);
			  
			  if (lstTestData.get(14).equalsIgnoreCase(objog_url.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(14) +Extent_Reports.logActual +lstObject.get(43) +"Meta tag is displayed is: "+objog_url.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(14) +Extent_Reports.logActual +lstObject.get(43) +"Meta tag is displayed is: "+objog_url.getAttribute("content"),driver);

				}

			  
			  objog_description=Utilities.returnElements(driver,lstObject.get(47),lstObject.get(46)).get(0);
			 // WebElement objog_description = driver.findElements(By.cssSelector("meta[property='og:description']")).get(1);
			  descrption = objog_description.getAttribute("content");
			  System.out.println(descrption);
			  
			  if ((objog_description.getAttribute("content")).contains(lstTestData.get(15)))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(15) +Extent_Reports.logActual +lstObject.get(46) +"Meta tag is displayed is: "+objog_description.getAttribute("content"),driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(15) +Extent_Reports.logActual +lstObject.get(46) +"Meta tag is displayed is: "+objog_description.getAttribute("content"),driver);

				}

			  
			  objog_image=Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(0);
			  //WebElement objog_image = driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
			  thumbnail = objog_description.getAttribute("content");
			  System.out.println(thumbnail);
			  
			  if ((objog_image.getAttribute("content")).contains(lstTestData.get(16)))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(16) +Extent_Reports.logActual +lstObject.get(49) +"Meta tag is displayed is: "+objog_image.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(16) +Extent_Reports.logActual +lstObject.get(49) +"Meta tag is displayed is: "+objog_image.getAttribute("content"),driver);

				}

			  
			  objog_image_type=Utilities.returnElements(driver,lstObject.get(53),lstObject.get(52)).get(0);
			  //WebElement objog_image_type = driver.findElements(By.cssSelector("meta[property='og:image:type']")).get(0);
			  image_type = objog_description.getAttribute("content");
			  System.out.println(image_type);
			  
			  if (lstTestData.get(17).equalsIgnoreCase(objog_image_type.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(17) +Extent_Reports.logActual +lstObject.get(52) +"Meta tag is displayed is: "+objog_image_type.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(17) +Extent_Reports.logActual +lstObject.get(52) +"Meta tag is displayed is: "+objog_image_type.getAttribute("content"),driver);

				}

			  
			  objog_image_width=Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55)).get(0);
			  //WebElement objog_image_width = driver.findElements(By.cssSelector("meta[property='og:image:width']")).get(0);
			  image_width = objog_description.getAttribute("content");
			  System.out.println(image_width);
			  
			  if (lstTestData.get(18).equalsIgnoreCase(objog_image_width.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(18) +Extent_Reports.logActual +lstObject.get(55) +"Meta tag is displayed is: "+objog_image_width.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(18) +Extent_Reports.logActual +lstObject.get(55) +"Meta tag is displayed is: "+objog_image_width.getAttribute("content"),driver);

				}

			  
			  objog_image_height=Utilities.returnElements(driver,lstObject.get(59),lstObject.get(58)).get(0);
			 // WebElement objog_image_height = driver.findElements(By.cssSelector("meta[property='og:image:height']")).get(0);
			  image_height = objog_description.getAttribute("content");
			  System.out.println(image_height);
			  
			  if (lstTestData.get(19).equalsIgnoreCase(objog_image_height.getAttribute("content")))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(19) +Extent_Reports.logActual +lstObject.get(58) +"Meta tag is displayed is: "+objog_image_height.getAttribute("content"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(19) +Extent_Reports.logActual +lstObject.get(58) +"Meta tag is displayed is: "+objog_image_height.getAttribute("content"),driver);

				}

			  
			  objvideo_embed_url=Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			 // WebElement objvideo_embed_url = driver.findElement(By.cssSelector("iframe#player"));
			  video_embed_url = objvideo_embed_url.getAttribute("src");
			  System.out.println(video_embed_url);
			  
			  if (objvideo_embed_url.getAttribute("src").contains(lstTestData.get(20)))
				{
				  Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(20) +Extent_Reports.logActual +lstObject.get(64) +"Meta tag is displayed is: "+objvideo_embed_url.getAttribute("src"),driver);
				}	
				else
				{
				  Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(20) +Extent_Reports.logActual +lstObject.get(64) +"Meta tag is displayed is: "+objvideo_embed_url.getAttribute("src"),driver);

				}

														
		 }
			
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}
		
		//------------------------ Verify the Reduced Scope Version in All Videos Landing Page (DBB-3798) ------------------------			
				@Test
				  public PGAllVideosPage Verify_All_Videos_Landing_Page_DBB_3798( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
					
						objEpisodes = Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objEpisodes.click();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Full Episodes Page should Launch"+Extent_Reports.logActual+"NBC Full Episodes page launched succesfull",driver);
						System.out.println(driver.getCurrentUrl());
						
						System.out.println(driver.findElement(By.cssSelector("h2.section-heading__title")).getAttribute("innerHTML"));
						Synchronization.waitForPageLoad(driver);
						Thread.sleep(3000);
						//wait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("h2.section-heading__title")));
						Page_URL = driver.getCurrentUrl();
						System.out.println(Page_URL);
						
							
						List<WebElement> All_Videos = driver.findElements(By.cssSelector("div.all-video__content a"));
						
						if(All_Videos.size()==12)
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Number of episodes in the RECENTLY ADDED section is: "+ All_Videos.size() + Extent_Reports.logActual + "There should be total number of video's should be displayed when user lands on Full Episode page: "+ "12" , driver);
						}	
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +"Number of episodes in the RECENTLY ADDED section is: "+ All_Videos.size() + Extent_Reports.logActual + "There should be total number of video's should be displayed when user lands on Full Episode page: "+ "12" , driver);

						}

						Episode_Title = driver.getTitle();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Page Title is: "+ Episode_Title , driver);
						
						objTV_Show_Title = Utilities.returnElements(driver,lstObject.get(68),lstObject.get(67)).get(0);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video metadata data for TV Show Title is display"+ Extent_Reports.logActual+"Video metadata data for TV Show Title should displayed as: " +objTV_Show_Title.getAttribute("innerHTML") , driver);
													
						obj_Title = Utilities.returnElements(driver,lstObject.get(71),lstObject.get(70)).get(0);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video metadata data for Title is display"+ Extent_Reports.logActual+"Video metadata data for Title should displayed as: "+ obj_Title.getText() , driver);
						
						objAirdate = Utilities.returnElements(driver,lstObject.get(74),lstObject.get(73)).get(0);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video metadata data for AirDate is display"+ Extent_Reports.logActual+"Video metadata data for AirDate should displayed as: "+ objAirdate.getAttribute("innerHTML") , driver);
						
						

										
					 }	
					
					
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

				//------------------------ Verify Integrate Core Spotlight Website Meta -Tag for apple in  All Videos Page (NBCRESP-1012) ------------------------			
				@Test
				  public PGAllVideosPage Verify_Meta_Tag_NBCRESP_1012( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					    driver.get(lstTestData.get(0));
					    Actions Action = new Actions(driver);
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
												
										
						objEpisodes = Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objEpisodes.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Full Episodes Page should Launch"+Extent_Reports.logActual+"NBC Full Episodes page launched succesfull",driver);
						Thread.sleep(5000);
						System.out.println(driver.getCurrentUrl());
					
						System.out.println(driver.findElement(By.cssSelector("h2.section-heading__title")).getAttribute("innerHTML"));
						
						objmeta_tag = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
						meta_tag = objmeta_tag.getAttribute("content");
						
						if (meta_tag.contains(lstTestData.get(9)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as:"+ lstTestData.get(9)+ Extent_Reports.logActual + "Meta tag is displayed is: "+ meta_tag , driver );
						}	
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as:"+ lstTestData.get(9)+ Extent_Reports.logActual + "Meta tag is displayed is: "+ meta_tag, driver);

						}
						
																
					 }	
					
									
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

  //-----------------------------------------------  DBB-3056 ------------------------------------------------------------
				@Test
				  public PGAllVideosPage Verify_Meta_Property( ) throws Exception 
				  {
				       
				       driver.get(lstTestData.get(0));
				       objGShClk =Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
				       objGShClk.click();
				       System.out.print("navigated to menu");
				       Synchronization.implicitWait(driver, 10);
				       objDrpshclk =Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
				       objDrpshclk.click();
				       System.out.print("navigated to show");
				       ShowlistText = objDrpshclk.getText();
				       Thread.sleep(4000);
				       strlowerCaseText =ShowlistText.toLowerCase();
				       strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
				       System.out.println(strReplaceSpaceText);
				       Synchronization.waitForPageLoad(driver);		       
				       
				       Thread.sleep(4000);
				       List<WebElement> objshowclick = driver.findElements(By.cssSelector("div.video-list__content.video-list__content-5 > a"));
				       System.out.println(objshowclick.size());
				       
				       objshowclick.get(0).click();
				      
				       fb_app_id=Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
				                //String fb_app_id = driver.findElement(By.cssSelector("meta[property='fb:app_id']")).getAttribute("content");
				                System.out.println(fb_app_id.getAttribute("content"));
				                
				                if (fb_app_id.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(32) +"':"+ fb_app_id.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(32) +"':"+ fb_app_id.getAttribute("content"),driver);

				                     }
				                
				                og_site_name = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
				                System.out.println(og_site_name);
				                
				                if (og_site_name.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(35) +"':"+ og_site_name.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                   Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(35) +"':"+ og_site_name.getAttribute("content"),driver);

				                     }

				                
				                objog_title=Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
				                //WebElement objog_title = driver.findElements(By.cssSelector("meta[property='og:title']")).get(0);
				                og_title = objog_title.getAttribute("content");
				                System.out.println(og_title);
				                
				                if (objog_title.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(38) +"':"+ objog_title.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    	 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(38) +"':"+ objog_title.getAttribute("content"),driver);

				                     }

				                
				                objog_type=Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
				                //WebElement objog_type = driver.findElements(By.cssSelector("meta[property='og:type']")).get(0);
				                type = objog_type.getAttribute("content");
				                System.out.println(type);
				                
				                if (objog_type.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(41) +"':"+ objog_type.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    	 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(41) +"':"+ objog_type.getAttribute("content"),driver);

				                     }

				                
				                objog_url=Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
				              // WebElement objog_url = driver.findElements(By.cssSelector("meta[property='og:url']")).get(0);
				                og_url =  objog_url.getAttribute("content");
				                System.out.println(og_url);
				                
				                if (objog_url.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(44) +"':"+ objog_url.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    	 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(44) +"':"+ objog_url.getAttribute("content"),driver);

				                     }

				                
				                objog_description=Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
				              // WebElement objog_description = driver.findElements(By.cssSelector("meta[property='og:description']")).get(1);
				                descrption = objog_description.getAttribute("content");
				                System.out.println(descrption);
				                
				                if (objog_description.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(47) +"':"+ objog_description.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(47) +"':"+ objog_description.getAttribute("content"),driver);

				                     }

				                
				                objog_image=Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
				                //WebElement objog_image = driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
				                thumbnail = objog_description.getAttribute("content");
				                System.out.println(thumbnail);
				                
				                if (objog_image.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(50) +"':"+ objog_image.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(50) +"':"+ objog_image.getAttribute("content"),driver);

				                     }

				                
				                objog_image_type=Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
				                //WebElement objog_image_type = driver.findElements(By.cssSelector("meta[property='og:image:type']")).get(0);
				                image_type = objog_description.getAttribute("content");
				                System.out.println(image_type);
				                
				                if (objog_image_type.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(53) +"':"+ objog_image_type.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(53) +"':"+ objog_image_type.getAttribute("content"),driver);

				                     }

				                
				                objog_image_width=Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
				                //WebElement objog_image_width = driver.findElements(By.cssSelector("meta[property='og:image:width']")).get(0);
				                image_width = objog_description.getAttribute("content");
				                System.out.println(image_width);
				                
				                if (objog_image_width.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(56) +"':"+ objog_image_width.getAttribute("content"),driver);
				                     }      
				                     else
				                     {
				                    	 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(56) +"':"+ objog_image_width.getAttribute("content"),driver);

				                     }

				                
				                objog_image_height=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
				              // WebElement objog_image_height = driver.findElements(By.cssSelector("meta[property='og:image:height']")).get(0);
				                image_height = objog_description.getAttribute("content");
				                System.out.println(image_height);
				                
				                if (objog_image_height.isDisplayed())
				                     {
				                	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + lstObject.get(59) +"':"+ objog_image_height.getAttribute("content"),driver);
				                           driver.close(); 
				                     }      
				                     else
				                     {
				                    	 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(59) +"':"+ objog_image_height.getAttribute("content"),driver);
				                           driver.close(); 
				                     }
				       return null;
				  }

			
				
}
