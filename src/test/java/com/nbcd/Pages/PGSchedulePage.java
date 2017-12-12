package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================
import com.relevantcodes.extentreports.LogStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGSchedulePage 
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_home,Schedule_Vedio_text,Schedule_vedio_homePage,WeekDay,WeekDate,month,date,WeekStartDay,ActualWeekDay,ActualStartDay,hex,txtVisitSite,PageTitle,url,wnbc_url;
	String og_title,type,og_url,thumbnail,image_type,image_width,image_height,video_embed_url,menu_Name,show_Name,header,Parrent_Window,child_window,Time,Show_Name,Show_Desc,Show_Rating;
	String wnbc,kntv_url,kntv,kusa_url,kusa,knbc_url,knbc,wavy_url,wavy,wnky_url,wnky,wgba_url,wgba,ksnb_url,ksnb,kndu_url,kndu,title,background_color;
	boolean Livelink;
	WebElement objdescription,objcanonical,objtitle,objSchedule_video,objWatchlive,objDay,objDate,objSDay,objRightArrow,objLeftArrow,objSchedule,objday_schedule,objLIVE_flag,objLive_Icon,objbackgroundcolor,objTime,objShow_name,objShow_Desc,objShow_Rating,objliveflag;
	WebElement objshow_Name,first_Video,playerIframe,ele,objog_title,objog_type,objog_url,objog_description,objog_image,objog_image_type,objog_image_width,objog_image_height,objvideo_secure_url,objvideo_embed_url,fb_app_id,og_site_name,video_secure_url,objSchedule_menu;
	List<WebElement> list,menu,sName,objschedule_Time,objschedule_Title,objSchedule_Menu;
	List<WebElement> Week_view,Following_week;
	ArrayList<String> list1,list2,list3,list4;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGSchedulePage(WebDriver driver) throws Exception 
	{   
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGSchedulePage","Input");
		lstObject=db.getTestDataObject("Select * from PGSchedulePage","ObjectRepository");
	}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
		  public PGSchedulePage VerifySEO_DBB_3825( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     Actions Action = new Actions(driver);
			     try {	
			    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
			    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			try
			 {
				objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
				for(WebElement ScheduleMenu: objSchedule_Menu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
						Action.moveToElement(ScheduleMenu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
						break;
					}
				}
		 		
				Thread.sleep(5000);
				
				System.out.println(driver.getCurrentUrl());;
				objdescription =Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				objtitle=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				objcanonical=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				
								
			/**Description*/
				
				if (lstTestData.get(1).equalsIgnoreCase(objdescription.getAttribute("content")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(4) +"Meta tag is displayed is: "+objdescription.getAttribute("content"),driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Meta tag should display as: "+lstTestData.get(1) +Extent_Reports.logActual +lstObject.get(4) +"Meta tag is displayed is: "+objdescription.getAttribute("content"),driver);

				}
				
				/**title*/
				if (lstTestData.get(2).equalsIgnoreCase(objcanonical.getAttribute("innerHTML")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Meta tag should display as: "+lstTestData.get(2) +Extent_Reports.logActual+lstObject.get(7) +"Meta tag is displayed is: "+objcanonical.getAttribute("innerHTML"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +"Meta tag should display as: "+lstTestData.get(2) +Extent_Reports.logActual+lstObject.get(7) +"Meta tag is displayed is: "+objcanonical.getAttribute("innerHTML"),driver);

				}

			/**canonical*/	
				if (lstTestData.get(3).equalsIgnoreCase(objtitle.getAttribute("href")))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +"Meta tag should display as: "+lstTestData.get(3) +Extent_Reports.logActual+lstObject.get(10) +"Meta tag is displayed is: "+objtitle.getAttribute("href"),driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta tag should display as: "+lstTestData.get(3) +Extent_Reports.logActual+lstObject.get(10) +"Meta tag is displayed is: "+objtitle.getAttribute("href"),driver);

				}
				
						
					 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}
	
	
	//------------------------------------Verify Show Name Links to Responsive Show Home page in Schedule Page (NBCRESP - 1213) ------------------------			
	@Test
	  public PGSchedulePage Verify_Responsive_Show_Name_Link_NBCRESP_1213( ) throws InterruptedException, FilloException 
	  {
			
		//Launching Browser with valid URL.
		     driver.get(lstTestData.get(0));
		     Actions Action = new Actions(driver);
		     try {
		    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
		    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//Reading Objects
		try
		 {
			objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
			for(WebElement ScheduleMenu: objSchedule_Menu ){
			//for(int i=0;i<=objmenu.size();i++){
				if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
					Action.moveToElement(ScheduleMenu).click().build().perform();
					break;
				}
			}
			
			Thread.sleep(5000);
			Show_home=driver.getCurrentUrl();
			
			/**schedule home page*/
			
			if (lstTestData.get(6).equalsIgnoreCase(Show_home))
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Click on schedule menu on global Navigation header " + lstTestData.get(6) + Extent_Reports.logActual+ "User should be navigated to Schedule landing page " + Show_home ,driver );
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Click on schedule menu on global Navigation header "+ lstTestData.get(6) +Extent_Reports.logActual + "User is not navigated to Schedule landing page "+ Show_home,driver);

			}	
			
									
			/**schedule video home page*/
			
			objSchedule_video=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			Schedule_Vedio_text=objSchedule_video.getAttribute("href");
			objSchedule_video.click();
			Thread.sleep(5000);
			Schedule_vedio_homePage=driver.getCurrentUrl();
			System.out.println(Schedule_vedio_homePage);
			
			if (Schedule_vedio_homePage.contains(Schedule_Vedio_text))
			
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Click on the Show name displayed on the schedule page"+ Extent_Reports.logActual + "User should be navigated to Show home page of that particular show and url is "+ Schedule_Vedio_text,driver );
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Click on the Show name displayed on the schedule page"+ Extent_Reports.logActual + "User should be navigated to Show home page of that particular show and url is "+ Schedule_Vedio_text,driver);

			}	

					
				 }
		 catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
		driver.close(); 
		
		return null;
	}

	  
	//------------------------------------ "Watch Live Now" CTA link is clicked from a schedule page in eligible DMA region (NBCRESP-1956) ------------------------			
		@Test
		  public PGSchedulePage  Verify_Watch_Live_Now_NBCRESP_1956 ( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     Actions Action = new Actions(driver);
			     try {
			    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
			    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			try
			 {
				objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
				for(WebElement ScheduleMenu: objSchedule_Menu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
						Action.moveToElement(ScheduleMenu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
						break;
					}
				}
				
				Thread.sleep(6000);
				
				objliveflag=Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));

				/**LIVE Flag */
				if (objliveflag.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " \"LIVE\" flag is displayed for the currently played programme " + "Is Displayed" + Extent_Reports.logActual + " \"LIVE\" flag should be displayed for the currently played programme " ,driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + " \"LIVE\" flag is displayed for the currently played programme " + "Is Displayed"  + Extent_Reports.logActual + " \"LIVE\" flag is not displayed for the currently played programme " ,driver);

				}			

				background_color=driver.findElement(By.cssSelector("div.schedule-show.schedule-show--live")).getCssValue("background-color");
							
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " Colored background for the currently played programme " + Extent_Reports.logActual + " Colored background should be displayed and hexa color code is "+background_color ,driver);

				
				objWatchlive=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				Livelink = objWatchlive.isDisplayed();
				
				/**WATCH LIVE NOW */
				if (objWatchlive.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " \"WATCH LIVE NOW\" CTA Icon is displayed for the currently played programme " + "Is Displayed" + Extent_Reports.logActual + " \"WATCH LIVE NOW\" CTA Icon should be displayed for the currently played programme " ,driver);
				}	
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + " \"WATCH LIVE NOW\" CTA Icon is displayed for the currently played programme " + "Is Displayed"  + Extent_Reports.logActual + " \"WATCH LIVE NOW\" CTA Icon is not displayed for the currently played programme " ,driver);

				}			
				
				objWatchlive.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Click on Watch Live Now CTA link for the currently played programme " + Extent_Reports.logActual + "The page should be redirectd to NBC.com/live " + driver.getCurrentUrl() ,driver);
				
							
					 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}

		//------------------------------------ "Desktop - Verify show Home page is opened on clicking the "VISIT SITE" link from schedule page (NBCRESP-1957) ------------------------			
		@Test
		  public PGSchedulePage  Verify_visitSiteLink_NBCRESP_1957 ( ) throws InterruptedException, FilloException 
		  {
				
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     Actions Action = new Actions(driver);
			     try {
			    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
			    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//Reading Objects
			try
			 {
				//Click on Schedule link
				objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
				for(WebElement ScheduleMenu: objSchedule_Menu ){
				//for(int i=0;i<=objmenu.size();i++){
					if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
						Action.moveToElement(ScheduleMenu).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
						break;
					}
				}
				
				Thread.sleep(6000);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//verify Visit Site arrow and text
				WebElement objVisitSite = Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(2);
				txtVisitSite= objVisitSite.getText();
				System.out.println(txtVisitSite);
				
				if(txtVisitSite.equalsIgnoreCase("VISIT SITE"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"VISIT SITE text is displayed"+Extent_Reports.logActual+"VISIT SITE text should be displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"VISIT SITE text is displayed"+Extent_Reports.logActual+"VISIT SITE text is not displayed",driver);
				}
				System.out.println(txtVisitSite);
				 
				if(objVisitSite.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"VISIT SITE Arrow Icon is displayed"+Extent_Reports.logActual+"VISIT SITE Arrow Icon should be displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"VISIT SITE Arrow Icon is displayed"+Extent_Reports.logActual+"VISIT SITE Arrow Icon is not displayed",driver);
				}
				
				Action.moveToElement(objVisitSite).click().build().perform();
				Thread.sleep(10000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on the \"VISIT SITE\" link"+Extent_Reports.logActual+"On clicking the VISIT SITE link show home page should be opened and url is: " + driver.getCurrentUrl() ,driver);						
				
				if(driver.getCurrentUrl().contentEquals("https://www.nbc.com/today?nbc=1"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on the \"VISIT SITE\" link and Show Home page should display"+Extent_Reports.logActual+"On clicking the link show home page should be opened and url is: " + driver.getCurrentUrl() ,driver);
				}
				
			 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
			 }
			
			driver.close(); 
			
			return null;
		}
		//------------------------------------ "New Responsive Web Site -  Verify the navigation from date to date in Timeline in the Schedule Page (DBB-3815) ------------------------			
				@Test
				  public PGSchedulePage  Verify_SchedulePage_Timeline_DBB_3815 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     
					     Actions Action = new Actions(driver);
					     try {	
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
							 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						Synchronization.implicitWait(driver, 50);
						Thread.sleep(30000);
						
					
						objDay=Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
						WeekDay=objDay.getAttribute("innerHTML");
						
						Date now = new Date();
						SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
				        ActualWeekDay = simpleDateformat.format(now);
											
						if(WeekDay.equalsIgnoreCase(ActualWeekDay))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Day of the week should be present in the Schedule page: "+ WeekDay +Extent_Reports.logActual+ "Day of the week is present in the Schedule page: "+ ActualWeekDay ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "Day of the week should be present in the Schedule page: "+ WeekDay +Extent_Reports.logActual+ "Day of the week is present in the Schedule page: "+ ActualWeekDay ,driver);
						}

						objDate=Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
						WeekDate = objDate.getText();
						System.out.println(WeekDate);
						String[] spilt = WeekDate.split(" ");
						month = spilt[0];
						date = spilt[1];
						System.out.println(month);
						System.out.println(date);
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat simpleDateformat1 = new SimpleDateFormat("MMM");
						//Date date1 = cal.getTime();
						int Actualdate = cal.get(Calendar.DATE);
						String ActualdateMonth = simpleDateformat1.format(cal.getTime());
						System.out.println(Actualdate);
						System.out.println(ActualdateMonth);
						if(month.equalsIgnoreCase((ActualdateMonth)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Month should be present in the Schedule page: "+ month +Extent_Reports.logActual+ "Month is present in the Schedule page: "+ ActualdateMonth ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "Month should be present in the Schedule page: "+ month +Extent_Reports.logActual+ "Month is present in the Schedule page: "+ ActualdateMonth ,driver);
						}

						/*if(date.equalsIgnoreCase(Integer.toString(Actualdate)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Date is :" + date +Extent_Reports.logActual+ "Date is :"+ Integer.toString(Actualdate) ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "Date is :"+  date +Extent_Reports.logActual+ "Date is :"+ Integer.toString(Actualdate),driver);
						}*/
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Date should be present in the Schedule page: "+ date +Extent_Reports.logActual+ "Date is present in the Schedule page: "+ date ,driver);
						
						Week_view = Utilities.returnElements(driver,lstObject.get(35),lstObject.get(34));
						list1 = new ArrayList<String>();
						list2 = new ArrayList<String>();
						System.out.println(Week_view.size());
						
						if(Week_view.size()==7)
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Dates displayed in a week view to the user " + "7" +Extent_Reports.logActual+ "Date corousel should be displayed with 7 Dates in a week view " + Week_view.size() ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+  "Dates displayed in a week view to the user " + "7"  +Extent_Reports.logActual+"Date corousel should be displayed with 7 Dates in a week view "+ Week_view.size() ,driver);
						}

						//for (int l=0;l<Week_view.size();l++){
						for(WebElement Weekview: Week_view ){
							list1.add(Weekview.getText());
							System.out.println("Default week Date is" + (Weekview.getText()));
						}
						
						for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++)
						{
					    cal.set(Calendar.DAY_OF_WEEK, i);
					    Date date2 = cal.getTime();
					    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd");
					    String formattedDate = formatter.format(date2);
				        System.out.println(formattedDate);
					    list2.add(formattedDate);
						}
						
					   for (String a : list1)
					    {
					        for (String b : list2)
					        {
					           
					            if(a.equalsIgnoreCase(b))
								{
					            	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Default week view in the DATE corousel is always the Current week" + a + Extent_Reports.logActual+ "Current week should be the default week view in the DATE corousel "+ b ,driver );
									break;
								}
							
					        }
					    }
					    
					    objSDay = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
						WeekStartDay = objSDay.getAttribute("innerHTML");
						ActualStartDay="sun";
						if(WeekStartDay.equalsIgnoreCase(ActualStartDay))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "First day of the current week is always Sunday in the DATE corousel " + WeekStartDay +Extent_Reports.logActual+"First day of the current week should always be displayed as Sunday in the DATE corousel "+ ActualStartDay,driver );
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "First day of the current week is always Sunday in the DATE corousel "+ WeekStartDay +Extent_Reports.logActual+ "First day of the current week should always be displayed as Sunday in the DATE corousel "+ ActualStartDay ,driver);
						}
						
										
						objRightArrow = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
						objRightArrow.click();
						Thread.sleep(3000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Right arrow becomes available to take the user to the following week " +Extent_Reports.logActual+"The Right arrow should become available to take the user to the following week, when user is viewing the current week.",driver );
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						
						Following_week = Utilities.returnElements(driver,lstObject.get(44),lstObject.get(43));
						list3 = new ArrayList<String>();
						System.out.println(Following_week.size());
						for (int j=0;j<Following_week.size();j++){
							list3.add(Following_week.get(j).getText());
							System.out.println("Following week Date is:" + (Following_week.get(j).getText()));
						}
						list4 = new ArrayList<String>();
						SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
						for (int i = 6; i < 13; i++) {
						    Calendar calendar = new GregorianCalendar();
						    calendar.add(Calendar.DATE, i);
						    String day = sdf.format(calendar.getTime());
						    list4.add(day);
						 	}
						
						for (String c : list3)
					    {
					        for (String d : list4)
					        {
					           	if(c.equalsIgnoreCase(d))
								{
					           		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Following week dates should displayed" + Extent_Reports.logActual+"Following week dates is displayed"+  d ,driver);
									break;
								}
								
					        }
					    }
					
						objLeftArrow = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
						objLeftArrow.click();
						Synchronization.implicitWait(driver, 30);
						Week_view = Utilities.returnElements(driver,lstObject.get(35),lstObject.get(34));
						for (int k=0;k<Week_view.size();k++){
							list1.add(Week_view.get(k).getText());
							//System.out.println("Default week Date is" + (Week_view.get(k).getText()));
						}
						
				 
				
					 
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
				
				//------------------------------------ 002-Desktop (990 px and above) - Verify Schedule section on responsive Schedule page (NBCRESP-856)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_section_Page_NBCRESP_856( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					Actions Action = new Actions(driver);
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);

												
						/*********  Time *********/
						//div.schedule-show--live div.schedule-show__time span.schedule-show__time-hmm
						objTime = Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
						Time= objTime.getAttribute("innerHTML");								
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"schedule-show--live Time is displayed: " + Extent_Reports.logActual+"schedule-show--live Time Should be displayed: " + objTime.getAttribute("innerHTML"),driver);
						System.out.println(Time);
						
						/*********  Show Name *********/
						
						//div.schedule-show--live div.schedule-show__content__show-title a
						objShow_name = Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
						Show_Name= objShow_name.getAttribute("innerHTML");
						System.out.println(Show_Name);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"schedule-show--live Show name is displayed"+ Extent_Reports.logActual+"schedule-show--live Show name should be displayed: "+ objShow_name.getAttribute("innerHTML"),driver);
						
						/*********  Show description *********/
						
						//div.schedule-show--live div.schedule-show__content__description p
						objShow_Desc = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
						Show_Desc= objShow_Desc.getText();
						System.out.println(objShow_Desc);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"schedule-show--live Show description is displayed: "+ Extent_Reports.logActual + "schedule-show--live Show description should displayed:  " + objShow_Desc.getText(),driver);
						
						/*********  Rating *********/
						
						//div.schedule-show--live span.schedule-show__meta__rating
						objShow_Rating = Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
						Show_Rating= objShow_Rating.getText();
						System.out.println(Show_Rating);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"schedule-show--live Show Rating is displayed: "+Extent_Reports.logActual + "schedule-show--live Show Rating should be displayed:  "+ objShow_Rating.getText(),driver);
						
						
												
						}
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

				
				//------------------------------------ 010-Desktop (990px and above) - New Responsive Web Site - To Verify the Page Title in Schedule Page (DBB-3821)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_Title_DBB_3821( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     try {  
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
							 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
				 		
						/*********  Page Title *********/
						//div.schedule-page div.page-title h1.page-title__title
						//WebElement objPageTitle = Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
						//String PageTitle= objPageTitle.g;	
						Thread.sleep(3000);
						PageTitle = driver.getTitle();
						System.out.println(PageTitle);
						String[] spilt = PageTitle.split(" ");
						System.out.println(spilt[1]);
						
						if(PageTitle.contains("Schedule"))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "The word \"Schedule\" is appears on the Page Title on Schedule landing page :" + "Schedule" + Extent_Reports.logActual+ "The word \"Schedule\" should appear on the Page Title"+ spilt[1],driver );
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "The word \"Schedule\" is appears on the Page Title on Schedule landing page :" + "Schedule" + Extent_Reports.logActual+ "The word \"Schedule\" is not appear on the Page Title"+ spilt[1],driver );
						}

																
						}
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

				//------------------------------------ 012-Desktop (990px and up) - New Responsive Web Site - To Verify for  Responsive Global Header Navigation in  Schedule Page (DBB-3826)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_Header_Navigation_DBB_3826 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					 
					     Actions Action = new Actions(driver);
					     try {  
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
												
						url = driver.getCurrentUrl();
																
						if(url.equalsIgnoreCase(lstTestData.get(3)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "User is navigate to Schedule landing page :" + lstTestData.get(6) +Extent_Reports.logActual+ "User Should be navigate to Schedule landing page :"+ url ,driver );
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "User is navigate to Schedule landing page :" + lstTestData.get(6) +Extent_Reports.logActual+ "User is not navigate to Schedule landing page :"+ url,driver );
						}

																
						}
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
				
/*			
				//------------------------------------ Verify ability to See Local Schedules by Appending Call Letters to Url (NBCRESP-1054)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_Appending_url_NBCRESP_1054 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						
						
						*//*** http://www.nbc.com/schedule?station=wnbc *****//*
						
						driver.navigate().to(lstTestData.get(7));
						Synchronization.implicitWait(driver, 30);
						wnbc_url = driver.getCurrentUrl();
																						
						if(wnbc_url.equalsIgnoreCase(lstTestData.get(7)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnbc_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(7),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnbc_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(7),driver);
						}
						
						//div.logo-header img
						WebElement objwnbcimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						wnbc = objwnbcimg.getAttribute("src");
						
						if(wnbc.contentEquals(lstTestData.get(8)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objwnbcimg.getAttribute("src") +wnbc +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(8),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnbc +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(8),driver);
						}

						*//*** http://www.nbc.com/schedule?station=kntv *****//*
						
						driver.navigate().to(lstTestData.get(9));
						Synchronization.implicitWait(driver, 30);
						kntv_url = driver.getCurrentUrl();
						
						if(kntv_url.equalsIgnoreCase(lstTestData.get(9)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kntv_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(9),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kntv_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(9),driver);
						}
						
						WebElement objkntvimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						kntv = objkntvimg.getAttribute("src");
						
						if(kntv.contentEquals(lstTestData.get(10)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objkntvimg.isDisplayed()+ kntv +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(10),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kntv +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(10),driver);
						}
						
						*//*** http://www.nbc.com/schedule?station=kusa *****//*
						
						driver.navigate().to(lstTestData.get(11));
						Synchronization.implicitWait(driver, 30);
						kusa_url = driver.getCurrentUrl();
						
						if(kusa_url.equalsIgnoreCase(lstTestData.get(11)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kusa_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(11),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kusa_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(11),driver);
						}
						
						WebElement objkusaimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						kusa = objkusaimg.getAttribute("src");
						
						if(kusa.contentEquals(lstTestData.get(12)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objkusaimg.isDisplayed()+ kusa +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(12),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kusa +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(12),driver);
						}
						
						*//*** http://www.nbc.com/schedule?station=knbc *****//*
						
						driver.navigate().to(lstTestData.get(13));
						Synchronization.implicitWait(driver, 30);
						knbc_url = driver.getCurrentUrl();
						
						if(knbc_url.equalsIgnoreCase(lstTestData.get(13)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ knbc_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(13),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ knbc_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(13),driver);
						}
						
						WebElement objknbcimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						knbc = objknbcimg.getAttribute("src");
						
						if(knbc.contentEquals(lstTestData.get(14)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objknbcimg.isDisplayed()+ knbc +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(14),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ knbc +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(14),driver);
						}
									
						*//*** http://www.nbc.com/schedule?station=wavy *****//*
						
						driver.navigate().to(lstTestData.get(15));
						Synchronization.implicitWait(driver, 30);
						wavy_url = driver.getCurrentUrl();
						
						if(wavy_url.equalsIgnoreCase(lstTestData.get(15)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wavy_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(15),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wavy_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(15),driver);
						}
						
						WebElement objwavyimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						wavy = objwavyimg.getAttribute("src");
						
						if(wavy.contentEquals(lstTestData.get(16)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objwavyimg.isDisplayed()+ wavy +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(16),driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wavy +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(16),driver);
						}
						
						
					
					*//*** http://www.nbc.com/schedule?station=wnky *****//*
					
					driver.navigate().to(lstTestData.get(17));
					Synchronization.implicitWait(driver, 30);
					wnky_url = driver.getCurrentUrl();
					
					if(wnky_url.equalsIgnoreCase(lstTestData.get(17)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnky_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(17),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnky_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(17),driver);
					}
					
					WebElement objwnkyimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
					wnky = objwnkyimg.getAttribute("src");
					
					if(wnky.contentEquals(lstTestData.get(18)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objwnkyimg.isDisplayed()+ wnky +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(18),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wnky +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(18),driver);
					}
					
					
					
					*//*** http://www.nbc.com/schedule?station=wgba *****//*
					
					driver.navigate().to(lstTestData.get(19));
					Synchronization.implicitWait(driver, 30);
					wgba_url = driver.getCurrentUrl();
					
					if(wgba_url.equalsIgnoreCase(lstTestData.get(19)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wgba_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(19),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wgba_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(19),driver);
					}
					
					WebElement objwgbaimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
					wgba = objwgbaimg.getAttribute("src");
					
					if(wgba.contentEquals(lstTestData.get(20)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objwgbaimg.isDisplayed()+ wgba +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(20),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ wgba +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(20),driver);
					}
					
					*//*** http://www.nbc.com/schedule?station=ksnb *****//*
					
					driver.navigate().to(lstTestData.get(21));
					Synchronization.implicitWait(driver, 30);
					ksnb_url = driver.getCurrentUrl();
					
					if(ksnb_url.equalsIgnoreCase(lstTestData.get(21)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ ksnb_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(21),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ ksnb_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(21),driver);
					}
					
					WebElement objksnbimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
					ksnb = objksnbimg.getAttribute("src");
					
					if(ksnb.contentEquals(lstTestData.get(22)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objksnbimg.isDisplayed()+ ksnb +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(22),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ ksnb +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(22),driver);
					}
					
					*//*** http://www.nbc.com/schedule?station=kndu *****//*
					
					driver.navigate().to(lstTestData.get(23));
					Synchronization.implicitWait(driver, 30);
					kndu_url = driver.getCurrentUrl();
					
					if(kndu_url.equalsIgnoreCase(lstTestData.get(23)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kndu_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(23),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kndu_url +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(23),driver);
					}
					
					WebElement objknduimg = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
					kndu = objknduimg.getAttribute("src");
					
					if(kndu.contentEquals(lstTestData.get(24)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ objknduimg.isDisplayed()+ kndu +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(24),driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Schedule link should be Navigated to : "+ kndu +Extent_Reports.logActual+"Schedule link should be Navigated to : " + lstTestData.get(24),driver);
					}
					
					
			}
				
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

*/				
				
				//------------------------------------ 007-  Desktop (990px and up ) - New Responsive Web Site -  To Verify for " What's On Header" and Affiliate Logo on Schedule Page (DBB-3813)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_Whats_On_Header_DBB_3813 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						url = driver.getCurrentUrl();
						
			   		//div.logo-header h1.logo-header__title
						
						WebElement objWhats_on_header = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
						header = objWhats_on_header.getAttribute("innerHTML");
						System.out.println(objWhats_on_header.getAttribute("innerHTML"));
						
						if(objWhats_on_header.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "What's on header is displayed on schedule landing page :" +Extent_Reports.logActual+ "What's on header should be displayed on schedule landing page :"+ objWhats_on_header.getAttribute("innerHTML") ,driver );
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "What's on header is displayed on schedule landing page :" +Extent_Reports.logActual+ "What's on header is not displayed on schedule landing page :"+ objWhats_on_header.getAttribute("innerHTML"),driver );
						}
						
						//div.logo-header > a > img
						WebElement objaffiliate_logo = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
						System.out.println(objWhats_on_header.getAttribute("src"));
						
						if(objaffiliate_logo.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Affiliate logo is displayed on schedule landing page :"+ Extent_Reports.logActual+ "Affiliate logo should be displayed on schedule landing page :"+ objaffiliate_logo.getAttribute("src") ,driver);
						}
										
						if(header.equalsIgnoreCase("what's on"))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "The Phrase \"What's On\" is displayed on schedule landing page :"+ Extent_Reports.logActual+ "The Phrase \"What's On\" should be displayed on schedule landing page :"+ objWhats_on_header.getAttribute("innerHTML"),driver  );
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+ "The Phrase \"What's On\" is displayed on schedule landing page :"+ Extent_Reports.logActual+ "The Phrase \"What's On\" is not displayed on schedule landing page :"+ objWhats_on_header.getAttribute("innerHTML") ,driver );
						}
						
						Parrent_Window = driver.getWindowHandle();
						//div.logo-header >a 
						WebElement objClick_affiliate_logo = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
						objClick_affiliate_logo.click();
						Thread.sleep(5000);
						
						Set<String> w =driver.getWindowHandles();
						Iterator<String> it = w.iterator();
						while(it.hasNext()){
							child_window = it.next();
							driver.switchTo().window(child_window);
							title=driver.getTitle();
						}
						
						Thread.sleep(3000);
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Click on the affiliate logo"+ Extent_Reports.logActual+ "User should be navigated to homepage for that Affiliate's web site" + title,driver);
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
				
	/*			//------------------------------------ Desktop - Verify Schedule is loading data for that day only and then loading the rest of the week in the background (NBCRESP-1601)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_loading_data_for_that_day_NBCRESP_1601 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					
					     Actions Action = new Actions(driver);
					     try {
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						
						Thread.sleep(6000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
												
						//div.schedule__day__day						
						objday_schedule = Utilities.returnElements(driver,lstObject.get(74),lstObject.get(73)).get(1);
						objday_schedule.click();
						Thread.sleep(5000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Current day Schedule is displayed on schedule landing page: "+ objday_schedule.getAttribute("innerHTML"),driver );
						//div.schedule-items div.schedule-show div.schedule-show__time span
						objschedule_Time = Utilities.returnElements(driver,lstObject.get(77),lstObject.get(76));
						//div.schedule-items div.schedule-show div.schedule-show__content__show-title
						objschedule_Title = Utilities.returnElements(driver,lstObject.get(80),lstObject.get(79));
						
						for(int i=0;i<objschedule_Time.size();i++){
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Current day Scheduled Show Time of Schedule landing page: "+ " " +objschedule_Time.get(i).getAttribute("innerHTML") + "Current day Scheduled Show Title of Schedule landing page: " + " "+ objschedule_Title.get(i).getAttribute("innerHTML") , driver );
						}
						
						Synchronization.implicitWait(driver, 30);
						
						objday_schedule = Utilities.returnElements(driver,lstObject.get(74),lstObject.get(73)).get(2);
						objday_schedule.click();
						Thread.sleep(5000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Schedule Day of Schedule landing page:  "+ " " + objday_schedule.getAttribute("innerHTML"),driver );
						//div.schedule-items div.schedule-show div.schedule-show__time span
						objschedule_Time = Utilities.returnElements(driver,lstObject.get(77),lstObject.get(76));
						//div.schedule-items div.schedule-show div.schedule-show__content__show-title
						objschedule_Title = Utilities.returnElements(driver,lstObject.get(80),lstObject.get(79));
						
						for(int i=0;i<objschedule_Time.size();i++){
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+ "Schedule Show Time of Schedule landing page: "+  " " + objschedule_Time.get(i).getAttribute("innerHTML") + "Schedule Show Title of Schedule landing page: " + " " + objschedule_Title.get(i).getAttribute("innerHTML") , driver );
						}
								
																	
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
*/				
			
				//------------------------------------ Desktop - Verify "Watch Live Show" CTA's are available when user opens schedule page in eligible DMA region (NBCRESP-1956)  ------------------------			
				@Test
				  public PGSchedulePage  Verify_Schedule_Page_Watch_Live_Show_NBCRESP_1956 ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     try { 
					    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);	
					    	 screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					//Reading Objects
					try
					 {
						//Click on Schedule link
						objSchedule_Menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement ScheduleMenu: objSchedule_Menu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((ScheduleMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(25))){
								Action.moveToElement(ScheduleMenu).click().build().perform();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Schedule menu should be clicked"+Extent_Reports.logActual+"Schedule Menu is clicked",driver);
								break;
							}
						}
						Thread.sleep(5000);
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						
						
						/*** Verify "LIVE" flag  *****/
						//strong.schedule-show__live-label						
						objLIVE_flag = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
						if(objLIVE_flag.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " \"LIVE\" flag is displayed for the currently played programme " + "Is Displayed" + Extent_Reports.logActual + " \"LIVE\" flag should be displayed for the currently played programme " ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + " \"LIVE\" flag is displayed for the currently played programme " + "Is Displayed"  + Extent_Reports.logActual + " \"LIVE\" flag is not displayed for the currently played programme " ,driver);						}
						
						/*** Verify for "WATCH LIVE NOW" CTA w/ icon *****/						
						//a.schedule-show__cta__live
						objLive_Icon = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
						if(objLive_Icon.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " \"WATCH LIVE NOW\" CTA Icon is displayed for the currently played programme " + "Is Displayed" + Extent_Reports.logActual + " \"WATCH LIVE NOW\" CTA Icon should be displayed for the currently played programme " ,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + " \"WATCH LIVE NOW\" CTA Icon is displayed for the currently played programme " + "Is Displayed"  + Extent_Reports.logActual + " \"WATCH LIVE NOW\" CTA Icon is not displayed for the currently played programme " ,driver);
						}
						
						/*** //background-color ****/											
						//div.schedule-show.schedule-show--live
						objbackgroundcolor = Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
						hex = Color.fromString(objbackgroundcolor.getCssValue("background-color")).asHex();
						System.out.println(objbackgroundcolor.getCssValue("background-color").toString());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Click on Watch Live Now CTA link for the currently played programme " + Extent_Reports.logActual + "The page should be redirectd to NBC.com/live " + driver.getCurrentUrl() ,driver);
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}


				
}
