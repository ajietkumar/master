package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
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

public class PGAppsLandingPage {

	private static final String VerifyAppsLandingPage = null;
		//=========================================Variables=================================================================================
		private  WebDriver driver;
		String sql;
		protected static String showDetails;
		DatabaseFunction db = new DatabaseFunction();
		public List<String> lstObject,lstTestData;
		static String screenshotExtension;
		String sqlQry,Status,strResultText;
		WebElement objAppLink,objAndroidAppImg,objRokuChannelImg,objXboxOneAppImg,objShowMenuItem,objEpisodeItem,objSCHEDULEItem,objNEWSSPORTSItem;
		WebElement objSHOPItem,objAPPItem,objLIVEItem,objAppIntro,objiOSAppDowload,objiOSAppImage,objiOSApplogo;
		WebElement objAppleTVImage,AppleTVAppDowload,objAppleTVApplogo,objAmazonFireTVImage,objAmazonFireTVImageURLDowload,objAmazonFireTVlogo;
		WebElement objAppPageFooter,objAndroidAppImage,objAndroidApplogo,objAndroidAppDowload,objAlexaImg,objAlexaLogo;
		
	//=================================================================================================================================================================================	
	//Constructor to initialize all the Page Objects  
		public PGAppsLandingPage(WebDriver driver) throws MalformedURLException 
		{      
			try 
				{
					
					this.driver = driver;
					lstTestData=db.getTestDataObject("Select * from AppsLandingPage","Input");
					lstObject=db.getTestDataObject("Select * from AppsLandingPage","ObjectRepository");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						
						
			}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGAppsLandingPage VerifyAppsLandingPage( ) throws InterruptedException, FilloException 
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
					//WebDriverWait waits = new WebDriverWait(driver, 20);
					//List <WebElement> objAppLink = driver.findElements(By.cssSelector("span.navigation__item__title"));
					//waits.until(ExpectedConditions.visibilityOfAllElements(objAppLink));
					objAppLink =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
					objAppLink.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Apps Landing Page should display"+ Extent_Reports.logActual+"Apps Landing page is dispalyed after App link is clicked from global navigation",driver);
					screenshotExtension=Extent_Reports.getScreenshot(driver);
					
					WebElement objShowMenuItem =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(1);
					if(objShowMenuItem.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: Shows should display"+ Extent_Reports.logActual+"Menu Items: Shows is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: Shows should display"+ Extent_Reports.logActual+"Menu Items: Shows is not dispalyed",driver);
					}
					WebElement objEpisodeItem =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(2);
					if(objEpisodeItem.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: Episode should display"+ Extent_Reports.logActual+"Menu Items: Episode is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: Episode should display"+ Extent_Reports.logActual+"Menu Items: Episode is not dispalyed",driver);
					}
					
					WebElement objSCHEDULEItem =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(3);
					if(objSCHEDULEItem.isDisplayed())  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: SCHEDULE should display"+ Extent_Reports.logActual+"Menu Items: SCHEDULE is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: SCHEDULE should display"+ Extent_Reports.logActual+"Menu Items: SCHEDULE is not dispalyed",driver);
					}
					WebElement objNEWSSPORTSItem =Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13)).get(4);
					if(objNEWSSPORTSItem.isDisplayed())
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: NEWS & SPORTS should display"+ Extent_Reports.logActual+"Menu Items: NEWS & SPORTS is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: NEWS & SPORTS should display"+ Extent_Reports.logActual+"Menu Items: NEWS & SPORTS is not dispalyed",driver);
					}
					
					objSHOPItem =Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
					if(objSHOPItem.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: SHOP should display"+ Extent_Reports.logActual+"Menu Items: SHOP is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: SHOP should display"+ Extent_Reports.logActual+"Menu Items: SHOP is not dispalyed",driver);
					}
					
					objAPPItem =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
					if(objAPPItem.isDisplayed())  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: APP should display"+ Extent_Reports.logActual+"Menu Items: APP is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: APP should display"+ Extent_Reports.logActual+"Menu Items: APP is not dispalyed",driver);
					}
					
					objLIVEItem =Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
					if(objLIVEItem.isDisplayed())  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Menu Items: LIVE should display"+ Extent_Reports.logActual+"Menu Items: LIVE is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Menu Items: LIVE should display"+ Extent_Reports.logActual+"Menu Items: LIVE is not dispalyed",driver);
					}
					screenshotExtension=Extent_Reports.getScreenshot(driver);
					
					objAppIntro =Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
					String valAppPageIntro = objAppIntro.getText();
					System.out.println(valAppPageIntro);
					if(valAppPageIntro.contentEquals(lstTestData.get(1))) 
					
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"App Page Intro should display"+ Extent_Reports.logActual+"App Page Intro  is dispalyed and the text is "+valAppPageIntro,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"App Page Intro should display"+ Extent_Reports.logActual+"App Page Intro  is not dispalyed as expected and the text is "+valAppPageIntro,driver);
					}
					screenshotExtension=Extent_Reports.getScreenshot(driver);
					//ios
					WebElement objiOSAppImage =Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(0);
					String iOSAppImageURL = objiOSAppImage.getAttribute("href");
					if(iOSAppImageURL.equalsIgnoreCase(lstTestData.get(2)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"iOSApp image link should match"+ Extent_Reports.logActual+"iOSApp image link should matching with expected and the link is: "+iOSAppImageURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"iOSApp image link should match"+ Extent_Reports.logActual+"iOSApp image link should not matching with expected and the link is: "+iOSAppImageURL,driver);
					}
					
					
					WebElement objiOSAppDowload =Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(0);
					String iOSAppDowloadURL = objiOSAppDowload.getAttribute("href");
					System.out.println(iOSAppDowloadURL);
					if(iOSAppDowloadURL.equalsIgnoreCase(lstTestData.get(3)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"iOSApp Download link should match"+ Extent_Reports.logActual+"iOSApp Download link should matching with expected and the link is: "+iOSAppDowloadURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"iOSApp Download link should match"+ Extent_Reports.logActual+"iOSApp Download link should not matching with expected and the link is: "+iOSAppDowloadURL,driver);
					}
					
					WebElement objiOSApplogo =Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(0);
					String iOSApplogoURL = objiOSApplogo.getAttribute("href");
					if(iOSApplogoURL.equalsIgnoreCase(lstTestData.get(4)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"iOSApp logo link should match"+ Extent_Reports.logActual+"iOSApp logo link should matching with expected and the link is: "+iOSApplogoURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"iOSApp logo link should match"+ Extent_Reports.logActual+"iOSApp logo link should not matching with expected and the link is: "+iOSApplogoURL,driver);
					}
					
					//AndroidAppa
					WebElement objAndroidAppImage =Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(1);
					String AndroidAppImageURL = objAndroidAppImage.getAttribute("href");
					if(AndroidAppImageURL.equalsIgnoreCase(lstTestData.get(5)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AndroidApp image link should match"+ Extent_Reports.logActual+"AndroidApp image link should matching with expected and the link is: "+AndroidAppImageURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AndroidApp image link should match"+ Extent_Reports.logActual+"AndroidApp image link should not matching with expected and the link is: "+iOSAppImageURL,driver);
					}
					
					
					WebElement objAndroidAppDowload =Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(1);
					String AndroidAppDowloadURL = objAndroidAppDowload.getAttribute("href");
					System.out.println(AndroidAppDowloadURL);
					if(AndroidAppDowloadURL.equalsIgnoreCase(lstTestData.get(6)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AndroidApp Download link should match"+ Extent_Reports.logActual+"AndroidApp Download link should matching with expected and the link is: "+AndroidAppDowloadURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AndroidApp Download link should match"+ Extent_Reports.logActual+"AndroidApp Download link should not matching with expected and the link is: "+AndroidAppDowloadURL,driver);
					}
					
					WebElement objAndroidApplogo =Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(1);
					String AndroidApplogoURL = objAndroidApplogo.getAttribute("href");
					if(AndroidApplogoURL.equalsIgnoreCase(lstTestData.get(7)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AndroidApp logo link should match"+ Extent_Reports.logActual+"AndroidApp logo link should matching with expected and the link is: "+AndroidApplogoURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AndroidApp logo link should match"+ Extent_Reports.logActual+"AndroidApp logo link should not matching with expected and the link is: "+AndroidApplogoURL,driver);
					}
					
					//AppleTV
					Thread.sleep(4000);
					WebElement objAppleTVImage =Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(4);
					String AppleTvImageURL = objAppleTVImage.getAttribute("href");
					if(AppleTvImageURL.equalsIgnoreCase(lstTestData.get(8)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Apple TV image link should match"+ Extent_Reports.logActual+"Apple TV image link should matching with expected and the link is: "+AppleTvImageURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Apple TV image link should match"+ Extent_Reports.logActual+"Apple TV image link should not matching with expected and the link is: "+AppleTvImageURL,driver);
					}
					
					
					WebElement AppleTVAppDowload =Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(4);
					String AppleTVDowloadURL = AppleTVAppDowload.getAttribute("href");
					System.out.println(AppleTVDowloadURL);
					if(AppleTVDowloadURL.equalsIgnoreCase(lstTestData.get(9)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Apple TV Download link should match"+ Extent_Reports.logActual+"Apple TV Download link should matching with expected and the link is: "+AppleTVDowloadURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Apple TV Download link should match"+ Extent_Reports.logActual+"Apple TV Download link should not matching with expected and the link is: "+AppleTVDowloadURL,driver);
					}
					
					WebElement objAppleTVApplogo =Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(4);
					String ApplieTVlogoURL = objAppleTVApplogo.getAttribute("href");
					if(ApplieTVlogoURL.equalsIgnoreCase(lstTestData.get(10)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AmazonFireTV logo link should match"+ Extent_Reports.logActual+"iOSApp logo link should matching with expected and the link is: "+iOSApplogoURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AmazonFireTV logo link should match"+ Extent_Reports.logActual+"iOSApp logo link should not matching with expected and the link is: "+iOSApplogoURL,driver);
					}
					
					//AmazonFire
					Thread.sleep(4000);
					WebElement objAmazonFireTVImage =Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(3);
					String AmazonFireTVImageURL = objAmazonFireTVImage.getAttribute("href");
					if(AmazonFireTVImageURL.equalsIgnoreCase(lstTestData.get(11)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AmazonFireTV image link should match"+ Extent_Reports.logActual+"AmazonFireTV image link should matching with expected and the link is: "+AmazonFireTVImageURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AmazonFireTV image link should match"+ Extent_Reports.logActual+"AmazonFireTV image link should not matching with expected and the link is: "+AmazonFireTVImageURL,driver);
					}
					
					
					WebElement objAmazonFireTVImageURLDowload =Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22)).get(3);
					String AmazonFireTVImageURLDowloadURL = objAmazonFireTVImageURLDowload.getAttribute("href");
					System.out.println(AmazonFireTVImageURLDowloadURL);
					if(AmazonFireTVImageURLDowloadURL.equalsIgnoreCase(lstTestData.get(12)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AmazonFireTV Download link should match"+ Extent_Reports.logActual+"AmazonFireTV Download link should matching with expected and the link is: "+AmazonFireTVImageURLDowloadURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AmazonFireTV Download link should match"+ Extent_Reports.logActual+"AmazonFireTV Download link should not matching with expected and the link is: "+AmazonFireTVImageURLDowloadURL,driver);
					}
					
					WebElement objAmazonFireTVlogo =Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(3);
					String AmazonFireTVlogoURL = objAmazonFireTVlogo.getAttribute("href");
					if(AmazonFireTVlogoURL.equalsIgnoreCase(lstTestData.get(13)))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AmazonFireTV logo link should match"+ Extent_Reports.logActual+"AmazonFireTV logo link should matching with expected and the link is: "+AmazonFireTVlogoURL,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"AmazonFireTV logo link should match"+ Extent_Reports.logActual+"AmazonFireTV logo link should not matching with expected and the link is: "+AmazonFireTVlogoURL,driver);
					}
					
					//Image validation
					Thread.sleep(4000);
					objAndroidAppImg = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
					if(objAndroidAppImg.isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"AndroidApp image should display"+ Extent_Reports.logActual+"AndroidApp image is dispalyed",driver);
					}
					
					objRokuChannelImg = Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
					if(objRokuChannelImg.isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Roku Channel image should display"+ Extent_Reports.logActual+"Roku Channel image is dispalyed",driver);
					}
					
					objXboxOneAppImg = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
					if(objXboxOneAppImg.isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Xbox One App  image should display"+ Extent_Reports.logActual+"Xbox One App  image is dispalyed",driver);
					}
					
					List<WebElement> objAlexaImg = Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37));
					if(objAlexaImg.get(0).isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Alexa  App  image should display"+ Extent_Reports.logActual+"Alexa  App  image is dispalyed",driver);
					}
					
					List <WebElement> objAlexaAppLink = Utilities.returnElements(driver,lstObject.get(41),lstObject.get(40));
					WebElement objAlexaAppName = objAlexaAppLink.get(6).findElement(By.tagName("a"));
					if(objAlexaAppName.isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Alexa  App  should display"+ Extent_Reports.logActual+"Alexa  App  image is dispalyed",driver);
					}
					
					List<WebElement> objAlexalogo = Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37));
					if(objAlexalogo.get(1).isDisplayed());  
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Alexa  Logo  image should display"+ Extent_Reports.logActual+"Alexa  logo  image is dispalyed",driver);
					}
					
					
					//Footer validation
					objAppPageFooter =Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
					if(objAppPageFooter.isDisplayed())
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Footer should display"+ Extent_Reports.logActual+"Footer is dispalyed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Footer should display"+ Extent_Reports.logActual+"Footer is not dispalyed",driver);
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
		

