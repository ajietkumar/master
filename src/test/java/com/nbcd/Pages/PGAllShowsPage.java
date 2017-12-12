package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class PGAllShowsPage {
	
	//=========================================Variables=================================================================================
	private  WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	static String screenshotExtension;
	String sqlQry,Status,strResultText;
	WebElement objShows,objAllShows,objAllShowspageTitle,objctiveSubTab,objShowImage,objShowTitle,objShowtune,objmetaDescription,objfooter;
	
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGAllShowsPage(WebDriver driver) throws MalformedURLException 
	{      
		try 
			{
				
				this.driver = driver;
				lstTestData=db.getTestDataObject("Select * from AllShowPage","Input");
				lstObject=db.getTestDataObject("Select * from AllShowPage","ObjectRepository");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
					
					
		}
//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
	  public PGAllShowsPage VerifyAllShowPageFunctionality_2275( ) throws InterruptedException, FilloException 
	  {
		
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     try
			     {
			     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
			     screenshotExtension=Extent_Reports.getScreenshot(driver);
			     }
			     catch(Exception exc)
				 {
					 System.out.println(exc.getMessage());
				 }
				
			//Reading Objects
			try
			 {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				WebElement objShows =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(1);
				objShows.click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Shows list Page should display"+ Extent_Reports.logActual+"Shows list page is displayed after Shows link is clicked from global navigation",driver);
				screenshotExtension=Extent_Reports.getScreenshot(driver);
				
				//Click on All Shows link 
				objAllShows =Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				objAllShows.click();
				Thread.sleep(25000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"All Shows list Page should display"+ Extent_Reports.logActual+"All Shows list page is displayed after All Shows link is clicked from Shows list",driver);
				
				//Validate Menu items from All Show page
				WebElement objShowMenuItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(1);
				if(objShowMenuItem.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: Shows should display"+ Extent_Reports.logActual+"Menu Items: Shows is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: Shows should display"+ Extent_Reports.logActual+"Menu Items: Shows is not displayed",driver);
				}
				WebElement objEpisodeItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(2);
				if(objEpisodeItem.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: Episode should display"+ Extent_Reports.logActual+"Menu Items: Episode is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: Episode should display"+ Extent_Reports.logActual+"Menu Items: Episode is not displayed",driver);
				}
				
				WebElement objSCHEDULEItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(3);
				if(objSCHEDULEItem.isDisplayed())  
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: SCHEDULE should display"+ Extent_Reports.logActual+"Menu Items: SCHEDULE is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: SCHEDULE should display"+ Extent_Reports.logActual+"Menu Items: SCHEDULE is not displayed",driver);
				}
				WebElement objNEWSSPORTSItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(4);
				if(objNEWSSPORTSItem.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: NEWS & SPORTS should display"+ Extent_Reports.logActual+"Menu Items: NEWS & SPORTS is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: NEWS & SPORTS should display"+ Extent_Reports.logActual+"Menu Items: NEWS & SPORTS is not displayed",driver);
				}
				
				WebElement objSHOPItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(5);
				if(objSHOPItem.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: SHOP should display"+ Extent_Reports.logActual+"Menu Items: SHOP is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: SHOP should display"+ Extent_Reports.logActual+"Menu Items: SHOP is not displayed",driver);
				}
				
				WebElement objAPPItem =Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7)).get(6);
				if(objAPPItem.isDisplayed())  
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: APP should display"+ Extent_Reports.logActual+"Menu Items: APP is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: APP should display"+ Extent_Reports.logActual+"Menu Items: APP is not displayed",driver);
				}
				
				WebElement objLIVEItem =Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
				if(objLIVEItem.isDisplayed())  
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: LIVE should display"+ Extent_Reports.logActual+"Menu Items: LIVE is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: LIVE should display"+ Extent_Reports.logActual+"Menu Items: LIVE is not displayed",driver);
				}
				
				//Validate All Shows page h1 heading
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement objAllShowspageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title__title")));
				//objAllShowspageTitle = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				String txtShows = objAllShowspageTitle.getText();
				if(txtShows.contentEquals("SHOWS"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Heading should display as Shows"+ Extent_Reports.logActual+"Sub heading is displayed as :"+txtShows,driver );
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Heading should display as Shows"+ Extent_Reports.logActual+"Sub heading is not displayed as expected and is displaying as :"+txtShows,driver );
				}
				
				//Validate Sub tabs under all shows page
				WebElement objAllShowsSub =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(0);
				String AllSubTab = objAllShowsSub.getText();
				System.out.println(AllSubTab);
				if(AllSubTab.contentEquals("ALL"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Menu Items: All should display"+ Extent_Reports.logActual+"Sub Menu Items: All is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Menu Items: All should display"+ Extent_Reports.logActual+"Sub Menu Items: All is not displayed",driver);
				}
				
				WebElement objCurrentShowsSub =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(1);
				String CurrentSubTab  = objCurrentShowsSub.getText();
				System.out.println(CurrentSubTab);
				if(CurrentSubTab.contentEquals("CURRENT"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Menu Items: Current should display"+ Extent_Reports.logActual+"Sub Menu Items: Current is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Menu Items: Current should display"+ Extent_Reports.logActual+"Sub Menu Items: Current is not displayed",driver);
				}
				
				WebElement objUpcomingShowsSub =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(2);
				String UpcomingSubTab  = objUpcomingShowsSub.getText();
				System.out.println(UpcomingSubTab);
				if(UpcomingSubTab.contentEquals("UPCOMING"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Menu Items: Upcoming should display"+ Extent_Reports.logActual+"Sub Menu Items: Upcoming is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Menu Items: Upcoming should display"+ Extent_Reports.logActual+"Sub Menu Items: Upcoming is not displayed",driver);
				}
				
				WebElement objthrowbackShowsSub =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(3);
				String throwbackSubTab  = objthrowbackShowsSub.getText();
				System.out.println(throwbackSubTab);
				if(throwbackSubTab.contentEquals("THROWBACK"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Menu Items: Throwback should display"+ Extent_Reports.logActual+"Sub Menu Items: Throwback is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Menu Items: Throwback should display"+ Extent_Reports.logActual+"Sub Menu Items: Throwback is not displayed",driver);
				}
				
				//Validate if color is changing when sub menu option is selected
				objctiveSubTab =Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				String colorActive = objctiveSubTab.getCssValue("color");
				System.out.println(colorActive);
				String color_hex[];  
				color_hex = colorActive.replace("rgba(", "").split(",");       
				String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
				System.out.println(actual_hex);
				if(actual_hex.contentEquals("#00b2eb"))
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Color of selected should display as Blue"+ Extent_Reports.logActual+"Color of selected tab is displayed in Blue",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Color of selected should display as Blue"+ Extent_Reports.logActual+"Color of selected tab is not displayed in Blue",driver);
				}
				
				//Meta Data
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//WebDriverWait waits = new WebDriverWait(driver, 20);
				objShowImage = Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
				//waits.until(ExpectedConditions.visibilityOfAllElements(objShowImage));	
				//List <WebElement> objShowImage = driver.findElements(By.cssSelector("img[alt='Access Hollywood']"));
				//a.get(1)
				//String strShowName = objShowImage.get(0).getAttribute("src");
				String strShowName = objShowImage.getAttribute("alt");
				if(objShowImage.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Image of Show should display"+ Extent_Reports.logActual+"Image of show is displayed and link is "+strShowName,driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Image of Show should display"+ Extent_Reports.logActual+"Image of show is not displayed",driver);
				}
				objShowTitle = driver.findElement(By.cssSelector("div.tabs__content > div:nth-child(2) a:nth-child(1)  article "));
				//WebElement objShowTitle = Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(0);
				String strShowTitle = objShowTitle.getText();
				if(objShowTitle.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Image title of Show should display"+ Extent_Reports.logActual+"Image title of show is displayed and the title is "+strShowTitle,driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Image title of Show should display"+ Extent_Reports.logActual+"Image title of show is not displayed",driver);
				}
				objShowtune = driver.findElement(By.cssSelector("div.tabs__content > div:nth-child(2) a:nth-child(1)  article "));
				//WebElement objShowtune = Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(0);
				String strShowtune = objShowtune.getText();
				if(objShowtune.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Image tune of Show should display"+ Extent_Reports.logActual+"Tune details of show is displayed and the tune details are "+strShowtune,driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Image tune of Show should display"+ Extent_Reports.logActual+"Image tune of show is not displayed",driver);
				}
				
				objfooter = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
				if(objfooter.isDisplayed())
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Footer should display"+ Extent_Reports.logActual+"Footer is displayed",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Footer should display"+ Extent_Reports.logActual+"Footer is not displayed",driver);
				}
				
				
			 }
			 catch(Exception exc)
			 {
				 System.out.println(exc.getMessage());
				 driver.close(); 
			 }
			
			driver.close(); 
			
			return null;
		} 
	
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGAllShowsPage VerifyAllShowPageThrowback_2275( ) throws InterruptedException, FilloException 
		  {
			
				//Launching Browser with valid URL.
				     driver.get(lstTestData.get(0));
				     try
				     {
				     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch is succesfull",driver);
				     
				     }
				     catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
				//Reading Objects
				try
				 {
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					WebElement objShows =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(1);
					objShows.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Shows list Page should display"+ Extent_Reports.logActual+"Shows list page is displayed after Shows link is clicked from global navigation",driver);
					
					//Click on All Shows link 
					objAllShows =Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
					objAllShows.click();
					Thread.sleep(25000);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"All Shows list Page should display"+ Extent_Reports.logActual+"All Shows list page is displayed after All Shows link is clicked from Shows list",driver);
					
					
					//Throw back link display
					Thread.sleep(4000);
					WebElement objthrowbackShowsSub = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(3);
					WebDriverWait wait= new WebDriverWait(driver,60);
					wait.until(ExpectedConditions.visibilityOf(objthrowbackShowsSub));
					//WebElement objthrowbackShowsSubs =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(3);
					String throwbackSubTab  = objthrowbackShowsSub.getText();
					System.out.println(throwbackSubTab);
					if(throwbackSubTab.contentEquals("THROWBACK"))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sub Menu Items: Throwback should display"+ Extent_Reports.logActual+"Sub Menu Items: Throwback is displayed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sub Menu Items: Throwback should display"+ Extent_Reports.logActual+"Sub Menu Items: Throwback is not displayed",driver);
					}
					
					
					
					//click on Throw back link
					objthrowbackShowsSub.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"ThrowBack subtab should be clickable"+ Extent_Reports.logActual+"Throwback tab is clicked",driver);
					
					//Validate meta data All Shows page h1 heading
					objAllShowspageTitle = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
					String txtShows = objAllShowspageTitle.getText();
					if(txtShows.contentEquals("SHOWS"))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta Tag H1 Tag should display as Shows"+ Extent_Reports.logActual+"Meta Tag H1 Tag is displayed as :"+txtShows,driver );
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta Tag H1 Tag should display as Shows"+ Extent_Reports.logActual+"Meta Tag H1 Tag is not displayed as expected and is displaying as :"+txtShows,driver );
					}
					
					//Validate meta data for title
					String strTitle = driver.getTitle();
					if(strTitle.contentEquals("Classic Throwback NBC Shows - NBC.com"))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta Tag Title should display as Classic Throwback NBC Shows - NBC.com"+ Extent_Reports.logActual+"Meta Tag Title is displayed as :"+strTitle,driver );
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta Tag Title should display as Shows"+ Extent_Reports.logActual+"Meta Tag Title is not displayed as expected and is displaying as :"+strTitle,driver );
					}
					
					//Validate meta data for Description
					objmetaDescription =  Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
					String CompValTextDescription = objmetaDescription.getAttribute("content");
					System.out.println(objmetaDescription);
					String Textcompval = "Rediscover your favorite throwback shows. Watch full episodes and browse photos of classic TV shows on NBC.com";
					if(CompValTextDescription.contentEquals(Textcompval))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta Tag Description should  be as expected"+ Extent_Reports.logActual+"Meta Tag Description is as expected and the text is :"+CompValTextDescription,driver );
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta Tag Description should  be as expected"+ Extent_Reports.logActual+"Meta Tag Title is not displayed as expected and is displaying as :"+CompValTextDescription,driver );
					}
					
				 }
				 catch(Exception exc)
				 {
					 System.out.println(exc.getMessage());
					 driver.close();
				 }
				
				driver.close(); 
				
				return null;
			} 	
	
}
