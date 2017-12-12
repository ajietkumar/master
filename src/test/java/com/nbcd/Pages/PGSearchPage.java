package com.nbcd.Pages;

import java.util.ArrayList;
import java.util.Arrays;

//===============================================PACKAGES==========================================================================


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;


//==============================================================CLASSES AND METHODS==================================================
public class PGSearchPage
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	List<WebElement> objlinks;
	WebElement objSearchIcon,objExitIcon,objsearch_input_text,objDefault_Title,objShow,objShow_Title ;
	List<WebElement> objcard__title,objcard__description,objCarKey_art,objshow_collection,objresentEpisodes,objShowName,objEpisode_ShowName;
	String Search_url,Exit_url,title,Show1,Show2,Show3;
	ArrayList<String> Array1,Array2;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGSearchPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGSearchPage","Input");
		lstObject=db.getTestDataObject("Select * from PGSearchPage","ObjectRepository");
	}
	//-------------------------Validate the "X" Button functionality : It Closes the search overlay and returns the page to it's previous state ------------------------			
				
	
	              @Test
				  public PGSearchPage Verify_X_Icon () throws InterruptedException, FilloException 
				  {
	            //	  ArrayList<String>  url = new ArrayList<>(Arrays.asList("https://www.nbc.com","https://www.nbc.com/video","https://www.nbc.com/apps","https://www.nbc.com/live","https://www.nbc.com/schedule"));

					//Launching Browser with valid URL.
					  driver.get("https://www.nbc.com");
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						//div.search-overlay__outer > div > span
						objExitIcon=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
						if(objExitIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Exit Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Exit Icon should be dispayed on Global Home Page ", driver);
						
						}
						else{
						
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Exit Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Exit Icon is missed on Global Home Page ", driver);
						
						}
						
						Thread.sleep(15000);
						Exit_url=driver.getCurrentUrl();
						System.out.println(Exit_url);
						if (Exit_url.contentEquals("https://www.nbc.com")){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "It Closes the search overlay and returns the page to it's previous state : "+ "https://www.nbc.com" + Extent_Reports.logActual+ "It Closes the search overlay and returns the page to it's previous state :  " + "https://www.nbc.com", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "It Closes the search overlay and returns the page to it's previous state : "+ "https://www.nbc.com" + Extent_Reports.logActual+ "It Closes the search overlay and it is not returns the previous state: " + "https://www.nbc.com", driver);	
							
						}
						
						
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

	            //-------------------------Validate the Search Bar Promt message: That should be "What show are you looking for?" ------------------------			
					
	          	
	              @Test
				  public PGSearchPage Verify_Search_Bar_Promt_message () throws InterruptedException, FilloException 
				  {
	            
					//Launching Browser with valid URL.
					  driver.get(lstTestData.get(1));
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						//div.sticky-outer-wrapper.search-input__wrapper > div > div > div > input
						objsearch_input_text=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
						if(objsearch_input_text.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Search Bar Promt message: is \"What show are you looking for?\" "+ Extent_Reports.logActual+ "Search Bar Promt message Should be "+ objsearch_input_text.getAttribute("placeholder"), driver);
						
						}
						else{
						
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Search Bar Promt message: is \"What show are you looking for?\" "+ Extent_Reports.logActual+ "Search Bar Promt message Should be " + objsearch_input_text.getAttribute("placeholder"), driver);
						
						}
						
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

	              //------------------------- Validate the Default Title : Should be "FEATURED SHOWS" ------------------------			
					
		          	
	              @Test
				  public PGSearchPage Verify_Default_Title () throws InterruptedException, FilloException 
				  {
	            
					//Launching Browser with valid URL.
					  driver.get(lstTestData.get(1));
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						//div.sticky-outer-wrapper.search-input__wrapper > div > div > div > input
						objDefault_Title=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
						if(objDefault_Title.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Default Title : is \"FEATURED SHOWS\" "+ Extent_Reports.logActual+ "Default Title : Should be "+ objDefault_Title.getAttribute("innerHTML").toUpperCase(), driver);
						
						}
						else{
						
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Default Title : is \"FEATURED SHOWS\" "+ Extent_Reports.logActual+ "Default Title : Should be " + objDefault_Title.getAttribute("innerHTML").toUpperCase(), driver);
						
						}
						
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

	              //------------------------- Validate the show details in the default page : And Each show contains  ------------------------			
					
		          	
	              @Test
				  public PGSearchPage Verify_Show_details () throws InterruptedException, FilloException 
				  {
	            
					//Launching Browser with valid URL.
					  driver.get(lstTestData.get(1));
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						objcard__title=Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
						objcard__description=Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
						objCarKey_art=Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19));
						for(int i=0;i<objcard__title.size();i++){
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Show details in the default page : And Each show contains \"Key Art\" is displayed: "+ Extent_Reports.logActual+ "Show details in the default page : And Each show contains \"Key Art\" should be displayed : and value is" +objCarKey_art.get(i).getAttribute("alt") , driver);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Show details in the default page : And Each show contains \"Card Title\" is displayed: "+ Extent_Reports.logActual+ "Show details in the default page : And Each show contains \"Card Title\" should be displayed :  and value is " +objcard__title.get(i).getAttribute("innerHTML") , driver);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Show details in the default page : And Each show contains \"Card Description\" is displayed: "+ Extent_Reports.logActual+ "Show details in the default page : And Each show contains \"Card Description\" should be displayed : and value is" +objcard__description.get(i).getAttribute("innerHTML") , driver);
						}
						
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
	              
	            //------------------------- Search results are always a "show lockup" which is a presentation of the show and the most recent 3 episodes of that shot.  ------------------------			
					
		          	
	              @Test
				  public PGSearchPage Verify_Collection_of_3_shows () throws InterruptedException, FilloException 
				  {
	            
					//Launching Browser with valid URL.
					  driver.get(lstTestData.get(1));
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						objshow_collection=Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
						
						if ((objshow_collection.size())==3){
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "3 Latest shows are displayed in the search default page " + Extent_Reports.logActual+ "no.of latest shows should be displayed in the search default page " + objshow_collection.size(), driver);
							
						}
							else{
								
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "3 Latest shows are displayed in the search default page " + Extent_Reports.logActual+ "no.of latest shows should be displayed in the search default page " + objshow_collection.size(), driver);	
								
						}
					  
						objShow=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
						objShow_Title=Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
						title=objShow_Title.getAttribute("href");
						objShow.click();
						Thread.sleep(9000);
						if((driver.getCurrentUrl()).contains(title)){
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "fg " + Extent_Reports.logActual+ "dsg " + driver.getCurrentUrl(), driver);
							
						}
							else{
								
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "vn " + Extent_Reports.logActual+ "gf " + driver.getCurrentUrl(), driver);	
						
		     			}
						
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}


		            //------------------------- Search results are always a "show lockup" which is a presentation of the show and the most recent 3 episodes of that shot.  ------------------------			
					
		          	
	              @Test
				  public PGSearchPage Verify_show_lockup () throws InterruptedException, FilloException 
				  {
	            
					//Launching Browser with valid URL.
					  driver.get(lstTestData.get(1));
					  
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						driver.getTitle();
						driver.getCurrentUrl();
						Thread.sleep(15000);
						//div.navigation__inner ul.navigation__list a.navigation__search.navigation__item__title
						objSearchIcon=Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.isEnabled();
						if(objSearchIcon.isDisplayed()){
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon should be dispayed on Global Home Page " , driver);
						
						}
						else{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Seacrh Icon is dispayed on Global Home Page "+ Extent_Reports.logActual+ "Seacrh Icon is not displayed on Global Home Page " , driver);
						
						}
						objSearchIcon.click();
						Thread.sleep(10000);
						Search_url=driver.getCurrentUrl();
						System.out.println(Search_url);
						
						if (Search_url.contentEquals(lstTestData.get(0))){
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page should be navigated to : " + "https://www.nbc.com/?overlay=search", driver);
						
						}
						else{
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Seacrh Icon is clicked and Global Home Page is navigated to : "+ Search_url + Extent_Reports.logActual+ "Global Home Page is not navigated to : " + "https://www.nbc.com/?overlay=search", driver);	
							
						}
						
						objsearch_input_text=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
						objsearch_input_text.sendKeys(lstTestData.get(2));
						Thread.sleep(6000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Successfully Enter the input String "+ Extent_Reports.logActual+ "Successfully Enter the input String is : " + lstTestData.get(2), driver);
						
						objresentEpisodes=Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31));
						Show1=objresentEpisodes.get(0).getAttribute("innerHTML");
						Show2=objresentEpisodes.get(1).getAttribute("innerHTML");
						Show2=objresentEpisodes.get(2).getAttribute("innerHTML");						
						objShow=Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
						objShow.click();
						Thread.sleep(8000);
						
						objShowName=Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37));
						for(int j=0;j<objShowName.size();j++){
							if(objShowName.get(j).getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
							   objShowName.get(j).click();
							   break;
							}
						}
						
						Thread.sleep(20000);
						System.out.println(driver.getCurrentUrl());
					    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
					    
					    objEpisode_ShowName=Utilities.returnElements(driver,lstObject.get(41),lstObject.get(40));
					   
					   	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected : "+ Show1 + Extent_Reports.logActual+ "Actual : " + objEpisode_ShowName.get(0).getAttribute("innerHTML"), driver);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected : "+ Show2 + Extent_Reports.logActual+ "Actual : " + objEpisode_ShowName.get(1).getAttribute("innerHTML"), driver);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected : "+ Show3 + Extent_Reports.logActual+ "Actual : " + objEpisode_ShowName.get(2).getAttribute("innerHTML"), driver);
					    
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
           

}

