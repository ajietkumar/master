package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================
import com.relevantcodes.extentreports.LogStatus;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.akiban.sql.parser.ParseException;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================

public class PGShowHomePage2
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,menu_Name,show_Name,Run_time_formate,Run_Time,Expected_Date,Actual_Date,objTitle,Archived_ShowName;
	ArrayList<String> array;
	List<WebElement> objmenu,objsName,objClips,objlist,objthumbnail,objClip_title,objSunrise_Date,objshowDate,objvideos,oblNavi_menu_list,objresposivebar_col,objALLShows;
	WebElement android_package,android_app_name,android_url,ios_app_store_id,ios_app_name,ios_url,web_url,web_should_fallback,objShow_Name,objTunein_Alert,objNext_Arrow,objPrev_Arrow,objDynamic_Lead_Slide,objmore_btn,objless_btn,objAd_Banner,objrun_time_format,objEpisode,objcurrent_video,objEpisode_video;
	WebElement fb_app_id,og_site_name,og_title,og_type,og_url,og_description,og_image,og_image_type,og_image_width,og_image_height,FaceBookUname,FaceBookUpass,FaceBookbutton,ShowPageUrl,FETCH_NEW_SCRAPE,objClip_Header,objfilter,objfil,objfirst_clip,objClipDetailbtn,objFull_Episode,objClassic_Tab,objClassic_video;
	WebElement objupcomingtab,objvideo,objAd,objguest_calendar_header,objguesthighlighted,objguestday,objguestdate,objcalendar_arrow_next_btn,objcalendar_arrow_prev_btn,objshowDate1,objmetaName,objCanonical_URL,objDownarrow,objNavigation_Bar,objAboutsection,objmorbtn_col,objShow_Art,objfeatureSction,objfeaturemetadata;
    WebElement objmeta_tag_apple,objAll_Tab,objArchived_Show,objEpisodeVideo;
	//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
    public PGShowHomePage2 (WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from ShowHomePage","Input");
		lstObject=db.getTestDataObject("Select * from ShowHomePage","ObjectRepository"); 
						
		}
  
	
	
	//======================= 011- Desktop - New Responsive Web Site -To verify for Latest Clips section in Show home page (DBB-3059) =================================================
	
	@Test
	  public PGShowHomePage2 Verify_Latest_Clips_Section_DBB_3059( ) throws InterruptedException, FilloException, ParseException 
	  {
			
		//Launching Browser with valid URL.
		     driver.get(lstTestData.get(0));
		     try {
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     Actions act = new Actions(driver);
		     
		//Reading Objects
		try
		 {
			
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
			//for(int i=0;i<=objmenu.size();i++){
				if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
					act.moveToElement(mainmanu).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
					break;
				}
			}
			System.out.println("show menu clicked");
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
				if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
					act.moveToElement(showname).click().build().perform();
					Thread.sleep(20000);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
					break;
				}
			}
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
      
			objClip_Header=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			System.out.println("Clip Header"+ objClip_Header.getAttribute("innerHTML"));
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Header is : "+ objClip_Header.isDisplayed()+ Extent_Reports.logActual + "  " + objClip_Header.getAttribute("innerHTML") , driver);
			String Header = objClip_Header.getAttribute("innerHTML");
			String[] parts = Header.split(" ");
			String part1 = parts[1]; 
			String part2 = part1.replaceAll("\\p{P}","");
		 	int Episodes_count = Integer.parseInt(part2);
		 	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episodes count heading should display "+ Extent_Reports.logActual + "Episodes count heading is displayed and the count of Episodes is : "+Episodes_count, driver);
			int loadButton = Math.round(Episodes_count/6);
			System.out.println("Clips Count: "+ loadButton);
			
			objClips=Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
			System.out.println("No of Clips"+ objClips.size());
			
			for(WebElement Clips: objClips ){
			//for(int i=0;i<objClips.size();i++){
				System.out.println("Clips Links: "+ Clips.getAttribute("href"));
			}
			
			objfilter=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
			System.out.println("Filter is diplayed: "+ objfilter.isDisplayed());			
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Header Fillter should be displayed "+ Extent_Reports.logActual + "Clip Header Fillter is displayed", driver);
			
			objfil=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
			Point point = objfil.getLocation();
		    int xcord = point.getX();
		    int ycord = point.getY();
			act.moveToElement(objfil, xcord, ycord).build().perform();
			objfil.click();
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Header Fillter should be clicked"+ Extent_Reports.logActual + "Clip Header Fillter is clicked", driver);
			
			objlist=Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25));
			for(WebElement dropdownlist: objlist ){
			//for(int i=0;i<objlist.size();i++){
				System.out.println(dropdownlist.getAttribute("innerHTML"));
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Header Fillter Option should be selected as : "+ dropdownlist.getAttribute("innerHTML")+Extent_Reports.logActual + dropdownlist.getAttribute("innerHTML") +"is selected from filter",driver);
			}
			
		   objlist.get(1).click();
		   Thread.sleep(2000);
		  
		   objthumbnail=Utilities.returnElements(driver,lstObject.get(29),lstObject.get(28));
		 
		   objClip_title=Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31));
		 
		   objSunrise_Date=Utilities.returnElements(driver,lstObject.get(35),lstObject.get(34));
		   ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
		 
				System.out.println("Thumbnile is displayed on Clips: "+ objthumbnail.get(1).isDisplayed());
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Thumbnile should be displayed on Clips"+Extent_Reports.logActual + "Thumbnile is displayed on Clips",driver);				
				System.out.println("Clip_title is: "+ objClip_title.get(1).getAttribute("innerHTML")+ "CLIP Type and Sunrise_Date are: "+ objSunrise_Date.get(1).getText() );
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip_title should be displayed"+ Extent_Reports.logActual + "Clip_title is displayed",driver);				
				   
		   String[] s = objSunrise_Date.get(0).getText().split(" ");
		   String value = s[1];
		   Date date = null;
		   SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YY");
		   date = sdf.parse(value);
		   if (!value.equals(sdf.format(date))) {
		       date = null;
		       System.out.println("The sunrise date should be in the format \"MM/DD/YY\" is: " + value );
		       Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "The sunrise date should be in the format \"MM/DD/YY\"" +Extent_Reports.logActual +"The sunrise date is in the format"+ value ,driver);
		   }
		   
		  for(int i=0;i<loadButton-1;i++){
				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			  	objDownarrow=Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
			  	Point point1 = objDownarrow.getLocation();
				int xcord1 = point1.getX();
				System.out.println("Position of the webelement from left side is "+xcord1 +" pixels");
				int ycord1 = point1.getY();
				System.out.println("Position of the webelement from top side is "+ycord1 +" pixels");	
				act.moveToElement(objDownarrow, xcord1, ycord1).build().perform(); 
				Thread.sleep(2000);
				if (objDownarrow.getLocation().getX()!=0){
					objDownarrow.click();
					  Thread.sleep(4000);		  
					  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Down arrow should not be displayed: "+ Extent_Reports.logActual +"Down Arrow is displayed",driver);
		          }else{
					  
		        	  System.out.println("Down arrow is not displayed");
		        	  Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Down arrow should not be displayed: "+ Extent_Reports.logActual +"Down Arrow is not displayed",driver);
				  } 
		  }
			  
			  Thread.sleep(4000);
					  
			  
			  objvideos=Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
			 // for(WebElement videoinfo: objvideos ){
			 // for(int j=0;j<objvideos.size();j++){
				//	System.out.println("Clips Link after click on down arrow button : "+ objvideos.get(j).getAttribute("href"));
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clips should be added after load/Down arrow is clicked "+ Extent_Reports.logActual +"Clips count after Down/Load Arrow is clicked are "+objvideos.size(),driver);
				//	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Link is: "+ objvideos.get(j).getAttribute("href") ,driver);
			//	}
			  
			
			  objfirst_clip=Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
			  Point point2 = objfirst_clip.getLocation();
		      int xcord2 = point2.getX();
		      System.out.println("Position of the webelement from left side is "+xcord2 +" pixels");
			  int ycord2 = point2.getY();
			  System.out.println("Position of the webelement from top side is "+ycord2 +" pixels");	
			  act.moveToElement(objfirst_clip, xcord2, ycord2).build().perform();
			  objfirst_clip.click();
			  Thread.sleep(3000);
			  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip should be clicked"+ Extent_Reports.logActual +"Clip is clicked",driver);
			 
			  objClipDetailbtn=Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
			  objClipDetailbtn.click();
			  Thread.sleep(2000);
			  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Clip Detail button should be clicked"+ Extent_Reports.logActual +"Clip Detail Button  is clicked",driver);
			  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			 
			  objrun_time_format=Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
			  Run_Time =objrun_time_format.getText();
			  String[] Run_time_formate= Run_Time.split(" ");
			  
			  if(Run_time_formate[1].contains("min")){
				  
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Run Time should be in the format X min  "+Extent_Reports.logActual +"Run Time is in the format X min "+Run_time_formate[1],driver);
			  }else{
				  
				  Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Run Time should be in the format X min  "+Extent_Reports.logActual +"Run Time is in the format X min "+Run_time_formate[1],driver);
			  }
			 											
		 }
		
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
				
driver.close(); 

return null;
}

//======================= 015- Desktop - New Responsive Web Site - Show Home Page - Verify for  Add Banner Ad for 990+px (DBB-3062) =================================================
	
	@Test
	  public PGShowHomePage2 Verify_Ad_Banner_DBB_3062( ) throws InterruptedException, FilloException, ParseException 
	  {
			
		   //Launching Browser with valid URL.
		     driver.get(lstTestData.get(0));
		     try {
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     Actions act = new Actions(driver);
		    
		//Reading Objects
		try
		 {
			
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
			//for(int i=0;i<=objmenu.size();i++){
				if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
					act.moveToElement(mainmanu).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
					break;
				}
			}
			
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
				if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
					act.moveToElement(showname).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
					break;
				}
			}
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
		
			//WebElement objAd_Banner = driver.findElement(By.cssSelector("div.mps-ad.mps-ad--topbanner div.mps-ad__inner div.ad-topbanner.mps-ad__content div[id^='google_ads_iframe'] iframe[id^='google_ads_iframe']"));
			
									
			try 
			{
			objAd_Banner=Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Ad banner should be fired by MPS on page load"+ Extent_Reports.logActual+"Ad banner is fired by MPS on page load and the Ad title is "+objAd_Banner.getAttribute("title"),driver);
			} catch(Exception e)
			{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Ad banner should be fired by MPS on page load"+ " " + objAd_Banner.getAttribute("title")+Extent_Reports.logActual+"Ad banner is fired by MPS on page load and the Ad title is "+objAd_Banner.getAttribute("title"),driver);
			}
										
		 }
		
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
				
driver.close(); 

return null;
}

//======================= 025-Desktop - 990px+ - New Responsive Web Site -To verify for Full Episodes Section in Show home page (DBB-3058) =================================================
	
	@Test
	  public PGShowHomePage2 Verify_Full_Episodes_Section_DBB_3058( ) throws InterruptedException, FilloException, ParseException 
	  {
			
		   //Launching Browser with valid URL.
		       driver.get(lstTestData.get(0));
		       try {
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		       Actions act = new Actions(driver);
		     
		//Reading Objects
		try
		 {
			
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(int i=0;i<=objmenu.size();i++){
				if((objmenu.get(i).getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
					act.moveToElement(objmenu.get(i)).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
					break;
				}
			}
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for (int j=0;j<=objsName.size();j++){
				if(objsName.get(j).getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
					act.moveToElement(objsName.get(j)).click().build().perform();
					Thread.sleep(20000);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+objsName.get(j).getAttribute("innerHTML"),driver);
					break;
				}
			}
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
		
			//WebElement objEpisode = driver.findElement(By.cssSelector("section.video-list.video-list__item-episodes div.video-list__inner div.video-list__container div.video-list__content a:nth-child(2)"));
			objEpisode=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
			Point point = objEpisode.getLocation();
		    int xcord = point.getX();
		    int ycord = point.getY();
			act.moveToElement(objEpisode, xcord, ycord).build().perform();
			objEpisode.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode should be clicked"+Extent_Reports.logActual+"Episode is clicked ",driver);
			Thread.sleep(20000);
			
		//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)");
			 //a.video-meta__expand span.video-meta__expand__text
			 objClipDetailbtn=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
			 Point p = objClipDetailbtn.getLocation();
			 int x = p.getX();
			 int y = p.getY();
			 act.moveToElement(objClipDetailbtn, x, y).build().perform();
			 objClipDetailbtn.click();
			 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Detail button should be clicked"+Extent_Reports.logActual+"Episode Detail Button is clicked ",driver);
			 Thread.sleep(3000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			 
			 //div.video-meta__info span.video-meta__type
			 objFull_Episode = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			 objFull_Episode.getText();
			 
			 if(objFull_Episode.getText().equalsIgnoreCase("Full Episode")){
				  System.out.println("Pass");
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Video Details Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is displayed as "+ objFull_Episode.getText(),driver);
			  }else{
				  System.out.println("Fail");
				  Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Video Details Page for Full Episode meta data should be displayed"+objFull_Episode.getText()+Extent_Reports.logActual+ "Full Episode Meta data is not displayed as expected",driver);
			  }
			
			 
			System.out.println("*************");
			
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
						act.moveToElement(mainmanu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
						break;
					}
				}
			System.out.println("show menu clicked");
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
				
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
					if(showname.getAttribute("innerHTML").equalsIgnoreCase("All Shows")){
						act.moveToElement(showname).click().build().perform();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
						break;
					}
				}
			Thread.sleep(4000);
			System.out.println(driver.getCurrentUrl());
			
			//div.tabs__content__list--current section.show-list div.show-list__inner  div.show-list__container  div.cards__container  a:nth-child(2)
			objcurrent_video=Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
			objcurrent_video.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Current Tab should be Clicked"+Extent_Reports.logActual+"Current Tab is Clicked",driver);
			
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			objEpisode=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
			Point point2 = objEpisode.getLocation();
		    int xcord2 = point2.getX();
		    int ycord2 = point2.getY();
			act.moveToElement(objEpisode, xcord2, ycord2).build().perform();
			objEpisode.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Current Tab Episode should be Clicked"+Extent_Reports.logActual+"Current Tab Episode is Clicked",driver);
			
		//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)");
			 //a.video-meta__expand span.video-meta__expand__text
			 objClipDetailbtn=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
			 Point p2 = objClipDetailbtn.getLocation();
			 int x2 = p2.getX();
		     int y2 = p2.getY();
			 act.moveToElement(objClipDetailbtn, x2, y2).build().perform();
			 objClipDetailbtn.click();
			 Thread.sleep(3000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Current Tab Episode Detail Button should be Clicked"+Extent_Reports.logActual+"Current Tab Episode Detail Button is Clicked",driver);
			 
			 //div.video-meta__info span.video-meta__type
			 objFull_Episode = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			 objFull_Episode.getText();
			 
			 if(objFull_Episode.getText().equalsIgnoreCase("Full Episode")){
				  System.out.println("Passs");
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Current videos Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is displayed as "+ objFull_Episode.getText(),driver);
				  
			  }else{
				  System.out.println("Fail");
				  Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Current videos Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is not displayed as Expected",driver);
			  }
			
		 System.out.println("**********1st test ****************");	 
		 
		   objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
		   for(WebElement mainmanu: objmenu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
						act.moveToElement(mainmanu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
						break;
					}
				}
			System.out.println("show menu clicked");
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
				
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
					if(showname.getAttribute("innerHTML").equalsIgnoreCase("All Shows")){
						act.moveToElement(showname).click().build().perform();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
						break;
					}
				}
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
			
			//div.tabs__select  div.tabs__select-inner  ul.tabs__tab li:nth-child(4) a
			objClassic_Tab=Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
			objClassic_Tab.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Classic Tab should be clicked"+Extent_Reports.logActual+"Classic Tab is clicked",driver);
			
			//div.tabs__content__list--classic-throwback section.show-list  div.show-list__inner  div.show-list__container a:nth-child(2)
			objClassic_video=Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
			objClassic_video.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Classic Tab Video should be clicked"+Extent_Reports.logActual+"Classic Tab Video is clicked",driver);
			List<WebElement> objEpisodeVideo = Utilities.returnElements(driver,lstObject.get(230),lstObject.get(229));
			objEpisodeVideo.get(0).click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Classic Tab Video image should be clicked"+Extent_Reports.logActual+"Classic Tab Video image is clicked",driver);
			
			
		//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)");
			 //a.video-meta__expand span.video-meta__expand__text
			 objClipDetailbtn=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
			 Point p3 = objClipDetailbtn.getLocation();
			 int x3 = p3.getX();
			 int y3 = p3.getY();
			 act.moveToElement(objClipDetailbtn, x3, y3).build().perform();
			 objClipDetailbtn.click();
			 Thread.sleep(3000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Classic Tab Video Detail Button should be clicked"+Extent_Reports.logActual+"Classic Tab Video Detail Button is clicked",driver);
			 
			 //div.video-meta__info span.video-meta__type
			 objFull_Episode = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			 objFull_Episode.getText();

			 
			 if(objFull_Episode.getText().equalsIgnoreCase("Full Episode")){
				  System.out.println("Passs");
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Classic videos tab Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is displayed as "+ objFull_Episode.getText(),driver);
				  
			  }else{
				  System.out.println("Fail");
				  Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Classic videos tab Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is not displayed as Expected",driver);
			  }

			 System.out.println("**********2nd test ****************");
			 
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase("Episodes")){
						act.moveToElement(mainmanu).click().build().perform();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Menu should be clicked"+Extent_Reports.logActual+"Episode Menu is clicked",driver);
						break;
					}
				}
			 
			Thread.sleep(5000);
			
			//div.all-video__inner div.all-video__content  a:nth-child(1)
			objEpisode_video=Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
			objEpisode_video.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Video should be clicked"+Extent_Reports.logActual+"Episode Video is clicked",driver);
			
			objEpisode=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
			Point point4 = objEpisode.getLocation();
		    int xcord4 = point4.getX();
		    int ycord4 = point4.getY();
			act.moveToElement(objEpisode, xcord4, ycord4).build().perform();
			objEpisode.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Video should be clicked"+Extent_Reports.logActual+"Episode Video is clicked",driver);
			
			List <WebElement> objEpisodeVideoo = Utilities.returnElements(driver,lstObject.get(230),lstObject.get(229));
			objEpisodeVideoo.get(0).click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Video Image should be clicked"+Extent_Reports.logActual+"Episode Video Image is clicked",driver);
		//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)");
			 //a.video-meta__expand span.video-meta__expand__text
			 objClipDetailbtn=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
			 Point p4 = objClipDetailbtn.getLocation();
			 int x4 = p4.getX();
			 int y4 = p4.getY();
			 act.moveToElement(objClipDetailbtn, x4, y4).build().perform();
			 objClipDetailbtn.click();
			 Thread.sleep(3000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Episode Video Detail Button should be clicked"+Extent_Reports.logActual+"Episode Video Detail Button is clicked",driver);
			 
			 //div.video-meta__info span.video-meta__type
			 objFull_Episode = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			 objFull_Episode.getText();

			
			 
			 if(objFull_Episode.getText().equalsIgnoreCase("Full Episode")){
				  System.out.println("Passs");
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episode Menu Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is displayed as "+ objFull_Episode.getText(),driver);
				  
			  }else{
				  System.out.println("Fail");
				  Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episode Menu Page for Full Episode meta data should be displayed"+Extent_Reports.logActual+ "Full Episode Meta data is not displayed as Expected ",driver);
			  }

	   
		 }
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
				
//driver.close(); 

return null;
}

//======================= 027-Desktop - 990px+ Viewport -  New Responsive Web Site-  Show Home Page -Verify the 300x250 Display Ad when NO episodes and NO Clips and NO features are available in Full Episodes Section (DBB-3679) =================================================
	
	@Test
	  public PGShowHomePage2 Verify_300x250_Display_Ad_DBB_3679( ) throws InterruptedException, FilloException, ParseException 
	  {
			
		   //Launching Browser with valid URL.
		      driver.get(lstTestData.get(0));
		      try {
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		    //  driver.get("https://www.nbc.com/shows/current");
		       Actions act = new Actions(driver);
		     
		//Reading Objects
		try
		 {
			
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
			//for(int i=0;i<=objmenu.size();i++){
				if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
					act.moveToElement(mainmanu).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
					break;
				}
			}
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
				if(showname.getAttribute("innerHTML").equalsIgnoreCase("All Shows")){
					act.moveToElement(showname).click().build().perform();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
					break;
				}
			}
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			
			//div.tabs__select  div.tabs__select-inner  ul.tabs__tab li:nth-child(3) a
			objupcomingtab=Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
			objupcomingtab.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Upcoming Tab should be clicked"+Extent_Reports.logActual+"Upcoming Tab is clicked ",driver);
			//div.tabs__content__list--upcoming section.show-list div.show-list__container div.cards__container a:nth-child(1)
			objvideo=Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
			objvideo.click();
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Upcoming Tab Video should be clicked"+Extent_Reports.logActual+"Upcoming Tab Video is clicked ",driver);
			//WebElement objAd = driver.findElement(By.cssSelector("section.video-list.video-list__item-episodes div.video-list__inner div.video-list__container div.video-list__content  div.mps-ad.mps-ad--topbox  iframe[id^='google_ads_iframe']"));
									
			try{
				objAd=Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85)).get(1);
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Show Home page should not Display 300x250 Ad when NO episodes and NO Clips and NO features are available in Full Episodes Section "+Extent_Reports.logActual+"Show Home page should not Display 300x250 Ad when NO episodes and NO Clips and NO features are available in Full Episodes Section",driver);
				
			}catch(Exception e)
			{
				objAd=Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85)).get(1);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Show Home page should not Display 300x250 Ad when NO episodes and NO Clips and NO features are available in Full Episodes Section "+Extent_Reports.logActual+"Show Home page should not Display 300x250 Ad when NO episodes and NO Clips and NO features are available in Full Episodes Section",driver);
			}
			

		 }
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
				
    driver.close(); 

return null;
}

//======================= 010- Desktop - 990+px Viewport - New Responsive Web Site - Show Home Page - Verify Add Guest Schedule to Late Night (DBB-3689) =================================================
	
	@Test
	  public PGShowHomePage2 Verify_Add_Guest_Schedule_DBB_3689( ) throws InterruptedException, FilloException, ParseException 
	  {
			
		   //Launching Browser with valid URL.
		  //   driver.get(lstTestData.get(0));
		     driver.get("https://www.nbc.com/the-tonight-show");
		     try {
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is 'The ToNight Show'",driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       Actions act = new Actions(driver);
		     try {
					
				} catch (Exception exc) {
					// TODO Auto-generated catch block
					Extent_Reports.logger.log(LogStatus.FAIL,exc.getMessage());
				}
		//Reading Objects
		try
		 {
			
		/*	menu_Name =lstTestData.get(1);
										
			objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement mainmanu: objmenu ){
			//for(int i=0;i<=objmenu.size();i++){
				if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(menu_Name)){
					act.moveToElement(mainmanu).click().build().perform();
					break;
				}
			}
			Thread.sleep(6000);
			System.out.println(driver.getCurrentUrl());
			
			objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
			for(WebElement showname: objsName ){
			//for (int j=0;j<=objsName.size();j++){
				if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Tonight Show Starring Jimmy Fallon")){
					act.moveToElement(showname).build().perform();
					act.moveToElement(showname).click().build().perform();
					break;
				}
			}
			Thread.sleep(6000);
			System.out.println(driver.getCurrentUrl());
		*/	
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
			
			//div.show-page__modules div.guest-calendar  div.guest-calendar__inner  div.guest-calendar__heading  div.guest-calendar__headline
			objguest_calendar_header=Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
			Point point = objguest_calendar_header.getLocation();
		    int xcord = point.getX();
		    int ycord = point.getY();
			act.moveToElement(objguest_calendar_header, xcord, ycord).build().perform();
					
			
			//div.guest-calendar__container div.slick-initialized.slick-slider  div.slick-list  div.slick-track  div.guest-calendar__container-headline-bar--current
			objguesthighlighted=Utilities.returnElement(driver,lstObject.get(92),lstObject.get(91));
			System.out.println(objguesthighlighted.getAttribute("style"));
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar current date clip should be highlighted"+Extent_Reports.logActual+"Guest calendar current date clip is highlighted as "+ objguesthighlighted.getAttribute("style"),driver);
			
			//div.guest-calendar__container div.slick-initialized.slick-slider  div.slick-list  div.slick-track  div.guest-calendar__container-headline-bar--current  span.guest-calendar__container-headline-bar__day
			objguestday=Utilities.returnElement(driver,lstObject.get(95),lstObject.get(94));
			System.out.println(objguestday.getAttribute("innerHTML"));
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar current Day should be displayed"+Extent_Reports.logActual+"Guest calendar current Day is displayed as " +objguestday.getAttribute("innerHTML"),driver);
			
			//div.guest-calendar__container div.slick-initialized.slick-slider  div.slick-list  div.slick-track  div.guest-calendar__container-headline-bar--current  span.guest-calendar__container-headline-bar__date
			objguestdate=Utilities.returnElement(driver,lstObject.get(98),lstObject.get(97));
			System.out.println(objguestdate.getText());
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar current Date should be displayed"+Extent_Reports.logActual+"Guest calendar current Date should be displayed"+ objguestdate.getText(),driver);
			
			Calendar cal = Calendar.getInstance(Locale.US);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			//System.out.println(dateFormat.format(cal.getTime()));
						
			//button.guest-calendar__arrow-next
			objcalendar_arrow_next_btn=Utilities.returnElement(driver,lstObject.get(101),lstObject.get(100));
			objcalendar_arrow_next_btn.click();
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar Arrow  should be Clicked"+Extent_Reports.logActual+"Guest calendar Arrow is Clicked for First time",driver);
			objcalendar_arrow_next_btn.click();
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar Arrow  should be Clicked"+Extent_Reports.logActual+"Guest calendar Arrow is Clicked for second time",driver);
			objcalendar_arrow_next_btn.click();
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar Arrow  should be Clicked"+Extent_Reports.logActual+"Guest calendar Arrow is Clicked for thrid time",driver);
			objcalendar_arrow_next_btn.click();
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar Arrow  should be Clicked"+Extent_Reports.logActual+"Guest calendar Arrow is Clicked for fourth time",driver);
			
			//div.guest-calendar__container div.slick-initialized.slick-slider  div.slick-list  div.slick-track  div.guest-calendar__container-headline-bar  span.guest-calendar__container-headline-bar__date
			objshowDate=Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
			objshowDate1=Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106)).get(objshowDate.size()-1);
			System.out.println(objshowDate1.getText());
			Actual_Date=objshowDate1.getText();
			cal.add(Calendar.DATE,6);
		    Expected_Date=dateFormat.format(cal.getTime());
		    
		    if(Expected_Date.equals(Actual_Date)){
		    	System.out.println("Pass");
		    	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Guest calendar following next week Date should be: "+ Expected_Date +Extent_Reports.logActual +"Actual Date is: "+ Actual_Date,driver);
		    }else
		    {
		    	System.out.println("Fail");
		    	Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Guest calendar following next week Date should be: "+ Expected_Date +Extent_Reports.logActual +"Actual Date is: "+ Actual_Date,driver);
		    }
			//button.guest-calendar__arrow-prev
			objcalendar_arrow_prev_btn=Utilities.returnElement(driver,lstObject.get(104),lstObject.get(103));
			objcalendar_arrow_prev_btn.click();
			
										
			
		 }
		
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
				
  driver.close(); 

return null;
}

	//=================================================Verify Title, Description & Canonical fields in Show Home Page for New Responsive Web Site (DBB-3686) =================================================
	
		@Test
		  public PGShowHomePage2 Verify_Description_Canonical_DBB_3686( ) throws InterruptedException, FilloException, ParseException 
		  {
				
			   //Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     try {
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			       Actions act = new Actions(driver);
			     try {
						screenshotExtension=Extent_Reports.getScreenshot(driver);
					} catch (Exception exc) {
						// TODO Auto-generated catch block
						Extent_Reports.logger.log(LogStatus.FAIL,exc.getMessage());
					}
			//Reading Objects
			try
			 {
				
				menu_Name =lstTestData.get(1);
											
				objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
				for(WebElement mainmanu: objmenu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(menu_Name)){
						act.moveToElement(mainmanu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
						break;
					}
				}
				Thread.sleep(3000);
				System.out.println(driver.getCurrentUrl());
				
				objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
				for(WebElement showname: objsName ){
				//for (int j=0;j<=objsName.size();j++){
					if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Blacklist")){
						act.moveToElement(showname).build().perform();
						act.moveToElement(showname).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
						break;
					}
				}
				Thread.sleep(2000);
				System.out.println(driver.getCurrentUrl());
				
				objTitle=driver.getTitle();
				System.out.println(objTitle);
				
				if (lstTestData.get(3).equalsIgnoreCase(objTitle))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Show Page Title should be dispalyed as "+objTitle +Extent_Reports.logActual +"Show Page Title is dispalyed as "+driver.getTitle(),driver);
				}	
				else
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Show Page Title should be dispalyed as "+objTitle +Extent_Reports.logActual +"Show Page Title is not dispalyed as expected ",driver);

				}

				
				//meta[name='description']
				objmetaName=Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));
				System.out.println(objmetaName.getAttribute("content"));
				
              if (objmetaName.getAttribute("content").contains(lstTestData.get(4)))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta tag data description should display"  +Extent_Reports.logActual +"Meta tag data description is displayed  as "+objmetaName.getAttribute("content"),driver);
				}	
				else
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +"Meta tag data description should display"  +Extent_Reports.logActual +"Meta tag data description is not displayed  as expected",driver);

				}

				//link[rel='canonical']
				objCanonical_URL=Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
				System.out.println(objCanonical_URL.getAttribute("href"));	
				
				if (lstTestData.get(5).equalsIgnoreCase(objCanonical_URL.getAttribute("href")))
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Meta Tag Data for rel should displayed as canonical" +Extent_Reports.logActual +"Meta Tag Data for rel is display as "+objCanonical_URL.getAttribute("href"),driver);
				}	
				else
				{
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Meta Tag Data for rel should displayed as canonical" +Extent_Reports.logActual +"Meta Tag Data for rel is not display as expected ",driver);

				}

				
			 }
			
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
					
	  driver.close(); 

	return null;
	}

		//======================================Desktop - New Responsive site - To verify for Responsive Navigation Bar in show home page (DBB-3060) =================================================
		
			@Test
			  public PGShowHomePage2 Verify_Responsive_Navigation_Bar_DBB_3060( ) throws InterruptedException, FilloException, ParseException 
			  {
					
				   //Launching Browser with valid URL.
				     driver.get(lstTestData.get(0));
				     driver.navigate().refresh();
				     try {
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						Thread.sleep(4000);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				       Actions act = new Actions(driver);
				      
				//Reading Objects
				try
				 {
					
					
					objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
					for(WebElement mainmanu: objmenu ){
					//for(int i=0;i<=objmenu.size();i++){
						if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
							act.moveToElement(mainmanu).click().build().perform();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
							break;
						}
					}
					Thread.sleep(4000);
					System.out.println(driver.getCurrentUrl());
					
					objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
					for(WebElement showname: objsName ){
					//for (int j=0;j<=objsName.size();j++){
						if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Blacklist")){
							act.moveToElement(showname).build().perform();
							act.moveToElement(showname).click().build().perform();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
							break;
						}
					}
					Thread.sleep(20000);
					System.out.println(driver.getCurrentUrl());
					
					List<WebElement> objlist = driver.findElements(By.cssSelector("section.show-page ul"));
					System.out.println(objlist.get(0).isDisplayed());
					
					Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +" Responsive Navigation Bar should be displayed in show home page section"+ objlist.get(0).isDisplayed() + Extent_Reports.logActual+ "Responsive Navigation Bar is displayed in show home page section",driver);
				 }
				
				 catch(Exception exc)
				 {
					 System.out.println(exc.getMessage());
					 driver.close();
				 }
						
		  driver.close(); 

		return null;
		}
		
			
	//======================================023-Desktop (990px and above) - Verify whether the ABOUT THE SHOW Section is appearing in responsive Show Homepage in Desktop view port (NBCRESP-804) =================================================
			
			@Test
			  public PGShowHomePage2 Verify_ABOUT_THE_Section_NBCRESP_804 ()  throws InterruptedException, FilloException, ParseException 
			  {
					
				   //Launching Browser with valid URL.
				     driver.get(lstTestData.get(0));
				     try {
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     Actions act = new Actions(driver);
				       
				//Reading Objects
				try
				 {
					
																
					objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
					//for(int i=0;i<=objmenu.size();i++){
					for(WebElement mainmanu: objmenu ){
						if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
							act.moveToElement(mainmanu).click().build().perform();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
							break;
						}
					}
					Thread.sleep(3000);
					System.out.println(driver.getCurrentUrl());
					
					objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
					//for (int j=0;j<=objsName.size();j++){
					for(WebElement showname: objsName ){
						if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Voice")){
							act.moveToElement(showname).build().perform();
							act.moveToElement(showname).click().build().perform();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
							break;
						}
					}
					
					System.out.println(driver.getCurrentUrl());
					//String strResponsiveBarColor = objresposivebar_col.get(0).getCssValue("background-color");
					//div.about-show div.about-show__inner div.about-title__text 
					objAboutsection=Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
					/*Point point = objfil.getLocation();
				    int xcord = point.getX();
				    int ycord = point.getY();
					act.moveToElement(objAboutsection, xcord, ycord).build().perform();*/
					if(objAboutsection.isDisplayed()){
						System.out.println("PASS");
					}else{
						System.out.println("FAIL");
					}
					
					//div.about-show div.about-show__inner  div.about-title__text  div.about-show__more
					objmorbtn_col=Utilities.returnElement(driver,lstObject.get(131),lstObject.get(130));
					//objmorbtn_col=driver.findElement(By.cssSelector("div.about-show__more"));
					objmorbtn_col.getCssValue("background-color");
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"More Button color should be as expected"+Extent_Reports.logActual+"Color for Show 'The Voice' "+"is displayed as"+objmorbtn_col.getCssValue("background-color"),driver);
					
					//section.show-page ul
					objresposivebar_col = Utilities.returnElements(driver,lstObject.get(134),lstObject.get(133));
					System.out.println(objresposivebar_col.get(1).getCssValue("background-color"));
					
					if(objmorbtn_col.getCssValue("background-color").equalsIgnoreCase(objresposivebar_col.get(1).getCssValue("background-color"))){
						System.out.println("PASS");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Responsive Bar color should match with MORE Button color"+Extent_Reports.logActual+"Show Responsive Bar color for Show 'The Voice' "+"is displayed as"+objresposivebar_col.get(0).getCssValue("background-color"),driver);
					}else{
						System.out.println("FAIL");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Responsive Bar color should match with MORE Button color"+Extent_Reports.logActual+"Show Responsive Bar color for Show 'The Voice' "+"is not displayed as Expected",driver);
					}
				    
					//div.about-show div.about-show__inner div.resp-image img
					objShow_Art = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
					
					if(objShow_Art.isDisplayed()){
						//System.out.println("PASS");
						System.out.println(objShow_Art.getAttribute("alt"));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Art should display"+Extent_Reports.logActual+"Show Art is displayed",driver);
					}else{
						System.out.println("FAIL");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Art should display"+Extent_Reports.logActual+"Show Art is not displayed",driver);
					}
					
					objmore_btn=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
					objmore_btn.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"More Button should be enabled to click"+Extent_Reports.logActual+"More Button should be enabled and clicked",driver);
					objless_btn=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
					objmore_btn.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Less Button should be enabled to click"+Extent_Reports.logActual+"Less Button should be enabled and clicked",driver);
				   
					
					
	//Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +" Responsive Navigation Bar should be displayed in show home page section: "+ objlistt.get(0).isDisplayed() + Extent_Reports.logActual+ "true",driver);
				 }
				
				 catch(Exception exc)
				 {
					 System.out.println(exc.getMessage());
				 }
						
		  driver.close(); 

		return null;
		}

			
			
	//============================002- Desktop (990px and above) - New Responsive Web Site - Verify the Line 2 of metadata for Feature Mosaic in Show home page (NBCRESP-812) =================================================
			
			@Test
			  public PGShowHomePage2 Verify_metadata_for_Feature_NBCRESP_812 ()  throws InterruptedException, FilloException, ParseException 
			  {
					
				   //Launching Browser with valid URL.
				   //   driver.get(lstTestData.get(0));
				     driver.get("https://www.nbc.com/the-voice");
				     try {
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is 'The Voice'",driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     Actions act = new Actions(driver);
				       
				//Reading Objects
				try
				 {
					
		/*														
					objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
					//for(int i=0;i<=objmenu.size();i++){
					for(WebElement mainmanu: objmenu ){
						if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
							act.moveToElement(mainmanu).click().build().perform();
							break;
						}
					}
					Thread.sleep(3000);
					System.out.println(driver.getCurrentUrl());
					
					objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
					//for (int j=0;j<=objsName.size();j++){
					for(WebElement showname: objsName ){
						if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Voice")){
							act.moveToElement(showname).build().perform();
							act.moveToElement(showname).click().build().perform();
							break;
						}
					}
					Thread.sleep(3000);
					System.out.println(driver.getCurrentUrl());
			*/
				//	section.features > div.features__inner  > div.section-heading 
					//WebElement objfeatureSction = driver.findElement(By.cssSelector("section.features > div.features__inner  > div.section-heading"));
					objfeatureSction=Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
					Point point = objfeatureSction.getLocation();
				    int xcord = point.getX();
				    int ycord = point.getY();
					act.moveToElement(objfeatureSction, xcord, ycord).build().perform();
					
					((JavascriptExecutor)driver).executeScript("window.scrollBy(600,800)","");
					Thread.sleep(1000);
					//screenshotExtension=Extent_Reports.getScreenshot(driver);
				//	div.features__content > a > article > div.card__meta > div.card__description > div
					//WebElement objfeaturemetadata = driver.findElement(By.cssSelector("div.features__content > a > article > div.card__meta > div.card__description > div"));
					objfeaturemetadata=Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
					if(objfeaturemetadata.getLocation().getX()!=0){
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +" Line 2 of the metadata for Features should be displayed" + Extent_Reports.logActual+ " Line 2 of the metadata for Features is displayed as "+objfeaturemetadata.getText(),driver);
					   }else{
						Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +" Line 2 of the metadata for Features should be displayed" + Extent_Reports.logActual+ "Line 2 of the metadata for Features is not displayed",driver);
					}
					
						 }
				
				 catch(Exception exc)
				 {
					 System.out.println(exc.getMessage());
				 }
						
		  driver.close(); 

		return null;
		}

  


//============================034-Desktop - New Responsive Website - Verify Integrate Core Spotlight Website Meta -Tag for apple in Show Home Page(NBCRESP-1012) =================================================

@Test
  public PGShowHomePage2 Verify_meta_Tag_for_apple ()  throws InterruptedException, FilloException, ParseException 
  {
		
	   //Launching Browser with valid URL.
	   //   driver.get(lstTestData.get(0));
	     driver.get("https://www.nbc.com/the-blacklist");
	     Actions act = new Actions(driver);
	       
	//Reading Objects
	try
	 {
		
/*														
		objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
		//for(int i=0;i<=objmenu.size();i++){
		for(WebElement mainmanu: objmenu ){
			if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
				act.moveToElement(mainmanu).click().build().perform();
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
		//for (int j=0;j<=objsName.size();j++){
		for(WebElement showname: objsName ){
			if(showname.getAttribute("innerHTML").equalsIgnoreCase("The Blacklist")){
				act.moveToElement(showname).build().perform();
				act.moveToElement(showname).click().build().perform();
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
*/
		
		
	
		/**meta name="apple-media-service-subscription" content=‘expires=9999, type=free’*/
		
		//meta[name='apple-media-service-subscription']
		Thread.sleep(10000);
		objmeta_tag_apple=Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
		
		if ((objmeta_tag_apple.getAttribute("content")).equalsIgnoreCase(lstTestData.get(6)))
		{
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+lstObject.get(145) +"':"+lstTestData.get(6) +Extent_Reports.logActual+lstObject.get(145) +"':"+objmeta_tag_apple.getAttribute("content"),driver);
			
		}
		else
		{
			Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(145) +"':"+lstTestData.get(6) +Extent_Reports.logActual+lstObject.get(145) +"':"+objmeta_tag_apple.getAttribute("content"),driver);

		}

	}
	
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
			
driver.close(); 

return null;
}

//============================Desktop - Verify the Show home page when user launches any Archived shows (NBCRESP-1970) =================================================

@Test
public PGShowHomePage2 Verify_Archived_shows ()  throws Exception 
{
		
	   //Launching Browser with valid URL.
	      driver.get(lstTestData.get(7));
	      Actions Action = new Actions(driver);
	      Thread.sleep(4000);
	      
	      Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"URL shoul be navigated to Archived shows Home Page: "+ Extent_Reports.logActual+"Actual Archived shows URL is: "+ driver.getCurrentUrl(),driver);
	//Reading Objects
	try
	 {
		
		//header > div > div > nav > div.navigation__inner > div.sticky-outer-wrapper.show-header.show-header--mobile > div > div.show-header__background > div > div > h1
		objArchived_Show=Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
		Archived_ShowName=objArchived_Show.getAttribute("innerHTML");
				
		if ((objArchived_Show.isDisplayed()))
		{
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Archived ShowName should be displayed"+Extent_Reports.logActual+ "Archived ShowName is displayed",driver);
					
		}
		else
		{
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Archived ShowName should be displayed"+Extent_Reports.logActual+ "Archived ShowName is not displayed",driver);

		}

		
		objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
		//for(int i=0;i<=objmenu.size();i++){
		for(WebElement mainmanu: objmenu ){
			if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
				Action.moveToElement(mainmanu).build().perform();
				Action.moveToElement(mainmanu).click().build().perform();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Menu should be clicked"+Extent_Reports.logActual+"Show Menu is clicked",driver);
				break;
			}
		}
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		
		objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
		//for (int j=0;j<=objsName.size();j++){
		for(WebElement showname: objsName ){
			if(showname.getAttribute("innerHTML").equalsIgnoreCase("All Shows")){
				Action.moveToElement(showname).build().perform();
				Action.moveToElement(showname).click().build().perform();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Name should be clicked"+Extent_Reports.logActual+"Show Name is clicked and the Show Name is "+showname.getAttribute("innerHTML"),driver);
				break;
			}
		}
		Thread.sleep(8000);
		Synchronization.waitForPageLoad(driver);
		System.out.println(driver.getCurrentUrl());
		
		
		//section > section > div.tabs__select > div > ul > li:nth-child(1) > a
		objAll_Tab=Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151));
		Action.moveToElement(objAll_Tab).click().build().perform();
		Thread.sleep(2000);
		
		//section > div.tabs__container > div > div.tabs__content__list.tabs__content__list--all.tabs__content__list--active > section > div > div > div > a > article > div.card__meta > div.card__title
		objALLShows=Utilities.returnElements(driver,lstObject.get(155),lstObject.get(154));
		
		for(WebElement Archived: objALLShows ){
			if(Archived.getAttribute("innerHTML").equalsIgnoreCase(Archived_ShowName)){
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "Archived video should be displayed "+Extent_Reports.logActual+ "Archived video is dispalyed and the Video name is "+Archived.getAttribute("innerHTML"),driver);
				break;
			}else{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "Archived video should be displayed "+Extent_Reports.logActual+ "Archived video is not dispalyed ",driver);
			}
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