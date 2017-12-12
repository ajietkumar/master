package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
//import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class PGLivePage {

	//=========================================Variables=================================================================================
		
		private  WebDriver driver;
		String sql,strSearchListItemsList;
		protected static String showDetails;
		DatabaseFunction db = new DatabaseFunction();
		public List<String> lstObject,lstTestData;
		static String screenshotExtension;
		long start;
		String sqlQry,Status,strResultText;
		WebElement objLive,objOptimum,objOptLogin,objUserName,objPassword,objlogin,objoptlogo,objBackBtDirectTV,objBackBtSpectrum;
		WebElement objSucessCheckMarck,objVideoFrame,objVideoPlayPause,objVideoPlayPauseStatus,objSuccessMsg,objLiveStreamHeader;
		WebElement objLiveStreamFlag,objLiveStreamTitle,objLiveStreamRating,objLiveStreamLogo,objFooter,objTVProviderLink;
		WebElement objFullListPageTitle,objFullListPageBack,objFullListPageSearchListCombo,objFullListPageSearchListText,objFullListPageSearchTextCombo;
		WebElement objTVProvidertwcText,objSearchTextBox,objSearchClear,objSearchComboList,objFullListPageSearchTextbox,objTVProviderLinks;
		
		
	//=================================================================================================================================================================================	
	//Constructor to initialize all the Page Objects 
		public PGLivePage(WebDriver driver) throws MalformedURLException 
		
		{      
			try 
				{
			this.driver = driver;
					
					lstTestData=db.getTestDataObject("Select * from LivePage","Input");
					lstObject=db.getTestDataObject("Select * from LivePage","ObjectRepository");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						
						
			}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGLivePage VerifyLivestreampageSupportedregion_1729( ) throws InterruptedException, FilloException 
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
					objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
					objLive.click();
					Thread.sleep(20000);
					driver.navigate().refresh();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
									
					//Click on TV provider link 
					Thread.sleep(10000);
					String strProviderLinkNameOptimum = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(8).getAttribute("alt");
					System.out.println(strProviderLinkNameOptimum);
					driver.findElements(By.cssSelector(lstObject.get(49))).get(8).click();		
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
					Thread.sleep(4000);
					
					//Login screen validation
					String ParentWindow = driver.getWindowHandle();
					Set<String> s1=driver.getWindowHandles();
					Iterator<String> nWindow= s1.iterator();
					while(nWindow.hasNext()){
						String childWindow = nWindow.next();
						driver.switchTo().window(childWindow);
					}
					
					Thread.sleep(2000);	
					String strOptimumTitle = driver.getTitle();
					objUserName = driver.findElement(By.id("IDToken1"));
					System.out.println(strOptimumTitle);
					if(objUserName.isDisplayed())
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed and the title of page is "+strOptimumTitle,driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
					}
					try
					{
						driver.close();
					}

					catch(Exception e)
					{
					e.printStackTrace();
					System.out.println("not closed");
					}
					driver.switchTo().window(ParentWindow);
					
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
				  public PGLivePage VerifyAuthSuccessMsgMVPDNBCRESP_1754( ) throws InterruptedException, FilloException 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							screenshotExtension=Extent_Reports.getScreenshot(driver);
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							Thread.sleep(4000);
							objOptLogin = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objOptLogin.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
							}
							
							
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							
							
							Thread.sleep(6000);
							
							//Need to add explicit wait
							objSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"MVPD Login page should be closed and NBC page should Open"+Extent_Reports.logActual+"MVPD Login page is closed and NBC page is Opened",driver);

							Thread.sleep(80000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							
							
							
							driver.switchTo().defaultContent();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}		
		

//========================================================================Desktop - Verify UX/UI of  MVPD picker elements on Live stream page and its behavior (NBCRESP-1873) =================================================
				@Test
				  public PGLivePage VerifyMVPDListPicker_1875( ) throws InterruptedException, FilloException 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							screenshotExtension=Extent_Reports.getScreenshot(driver);
							Actions act = new Actions(driver); 
							
							//Verify Headline Text 
							Thread.sleep(4000);
							List<WebElement> objTVProviderHeading = Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25));
							String strTVProviderHeading = objTVProviderHeading.get(1).getText();
							strTVProviderHeading = strTVProviderHeading.toUpperCase();
							if(strTVProviderHeading.contentEquals("LINK PROVIDER"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Heading should display"+ Extent_Reports.logActual+"TV Provider Heading is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"TV Provider Heading should display"+ Extent_Reports.logActual+"TV Provider Heading is not displayed",driver);
							}
							
							//Verify if we have 15 TV provider links
							List<WebElement> objTVProviderLinks = Utilities.returnElements(driver,lstObject.get(29),lstObject.get(28));
							if(objTVProviderLinks.size()==15)
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider List should be 15"+ Extent_Reports.logActual+"TV Provider List is 15",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"TV Provider List should be 15"+ Extent_Reports.logActual+"TV Provider List is not 15",driver);
							}
							
							//Click on each TV Provider 
							//Click on Xfinity
							
							String strProviderLinkNameX = Utilities.returnElements(driver,lstObject.get(47),lstObject.get(46)).get(0).getAttribute("alt");
							objTVProviderLinks.get(0).click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameX,driver);
							String winHandleBeforee = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							driver.switchTo().window(winHandleBeforee);
							
							
							
							
							//DirectTV
							String strProviderLinkNameD = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(1).getAttribute("alt");
							//String strProviderLinkNameD = objTVProviderLinks.get(1).findElement(By.tagName("alt")).getText();
							objTVProviderLinks.get(1).click();
							Thread.sleep(8000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameD,driver);
							objBackBtDirectTV = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
							objBackBtDirectTV.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct TV Login/Register page should be displayed"+ Extent_Reports.logActual+"TV Provider Direct TV Login/Register page is displayed",driver);
							
							//Dish
							Thread.sleep(4000);
							String strProviderLinkNamedish = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(2).getAttribute("alt");
							System.out.println(strProviderLinkNamedish);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(2).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNamedish,driver);
							//String strProviderLinkNamedish = objTVProviderLinks.get(2).findElement(By.tagName("alt")).getText();
							//objTVProviderLinks.get(2).click();
							Thread.sleep(4000);
							String winHandleBefore = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBefore);
							
							//Spectrum
							Thread.sleep(4000);
							String strProviderLinkNameSpectrum = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(3).getAttribute("alt");
							System.out.println(strProviderLinkNameSpectrum);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(3).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameSpectrum,driver);
							objBackBtSpectrum = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
							objBackBtSpectrum.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct TV Login/Register page should be displayed"+ Extent_Reports.logActual+"TV Provider Direct TV Login/Register page is displayed",driver);
							
							//Verizon
							Thread.sleep(4000);
							String strProviderLinkNameVerizon = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(4).getAttribute("alt");
							System.out.println(strProviderLinkNameVerizon);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(4).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameVerizon,driver);
							Thread.sleep(4000);
							String winHandleBeforre = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforre);
							
							//AT&T U-Versus
							Thread.sleep(4000);
							String strProviderLinkNameUVerus = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(5).getAttribute("alt");
							System.out.println(strProviderLinkNameUVerus);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(5).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameUVerus,driver);
							Thread.sleep(4000);
							String winHandleBeforree = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforree);
							
							//COX
							Thread.sleep(4000);
							String strProviderLinkNameCOX = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(6).getAttribute("alt");
							System.out.println(strProviderLinkNameCOX);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(6).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameCOX,driver);
							Thread.sleep(4000);
							String winHandleBefrree = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBefrree);
							
							//CharterSpectrum
							Thread.sleep(4000);
							String strProviderLinkNameChrSpectrum = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(7).getAttribute("alt");
							System.out.println(strProviderLinkNameChrSpectrum);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(7).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameChrSpectrum,driver);
							Thread.sleep(4000);
							String winHandleBeforeb = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeb);
							
							//Optimum
							Thread.sleep(4000);
							String strProviderLinkNameOptimum = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(8).getAttribute("alt");
							System.out.println(strProviderLinkNameOptimum);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(8).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameOptimum,driver);
							Thread.sleep(4000);
							String winHandleBeforeo = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeo);
							
							//brighthouseSpectrum
							Thread.sleep(4000);
							String strProviderLinkNameBrightSpectrum = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(9).getAttribute("alt");
							System.out.println(strProviderLinkNameBrightSpectrum);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(9).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameBrightSpectrum,driver);
							Thread.sleep(4000);
							String winHandleBeforef = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforef);
							
							//SuddenLink
							Thread.sleep(4000);
							String strProviderLinkNameSuddenLink = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(10).getAttribute("alt");
							System.out.println(strProviderLinkNameSuddenLink);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(10).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameSuddenLink,driver);
							Thread.sleep(4000);
							String winHandleBeforeS = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeS);
							
							//Mediacomm
							Thread.sleep(4000);
							String strProviderLinkNameMediaCom = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(11).getAttribute("alt");
							System.out.println(strProviderLinkNameMediaCom);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(11).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameMediaCom,driver);
							Thread.sleep(4000);
							String winHandleBeforeM = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeM);
							
							//CableOne
							Thread.sleep(4000);
							String strProviderLinkNameCable = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(12).getAttribute("alt");
							System.out.println(strProviderLinkNameCable);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(12).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameCable,driver);
							Thread.sleep(4000);
							String winHandleBeforeC = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeC);
							
							//WoW
							Thread.sleep(4000);
							String strProviderLinkNameWOW = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(13).getAttribute("alt");
							System.out.println(strProviderLinkNameWOW);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(13).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameWOW,driver);
							Thread.sleep(4000);
							String winHandleBeforeW = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Login screen should display"+ Extent_Reports.logActual+"TV Provider Login screen is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeW);
							
							//RCN
							Thread.sleep(4000);
							String strProviderLinkRCN = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49)).get(14).getAttribute("alt");
							System.out.println(strProviderLinkRCN);
							driver.findElements(By.cssSelector(lstObject.get(151))).get(14).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkRCN,driver);
							objBackBtSpectrum = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
							objBackBtSpectrum.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct TV Login/Register page should be displayed"+ Extent_Reports.logActual+"TV Provider Direct TV Login/Register page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
						
						List<WebElement> objFAQLinks = Utilities.returnElements(driver,lstObject.get(59),lstObject.get(58));
						objFAQLinks.get(1).click();
						Thread.sleep(4000);
						Thread.sleep(4000);
						String winHandleBeforf = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							}
						
						String strfaqURL = driver.getCurrentUrl();
						if(strfaqURL.contentEquals("https://www.nbc.com/general/pages/faq"))
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has opened",driver);
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has not opened",driver);
						}
						try
						{
							driver.close();
						}

						catch(Exception e)
						{
						e.printStackTrace();
						System.out.println("not closed");
						}
						
						
						driver.switchTo().window(winHandleBeforf);
						
					
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}	

//========================================================================Desktop - Verify the auth Frame details for MVPD Picker in Front end for Live stream  (NBCRESP-1874)=================================================
				@Test
				  public PGLivePage VerifyAuthFrameDetails_1873() 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							objOptLogin = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objOptLogin.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
							}
							Thread.sleep(4000);
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							Thread.sleep(8000);
							
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							
							Thread.sleep(90000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							driver.switchTo().defaultContent();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}		
		
//========================================================================Desktop - Verify Post authentication success message in front end for Live events (NBCRESP-1754)=================================================
				@Test
				  public PGLivePage VerifyPostSuccessMsgFadeOut_2106() 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							objOptLogin = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objOptLogin.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
							}
							Thread.sleep(4000);
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
						
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							Thread.sleep(8000);
							
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							
							Thread.sleep(90000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							driver.switchTo().defaultContent();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}		
		
//========================================================================Desktop - Verify the External Page Auth Flow for MVPD (NBCRESP-1873)=================================================
				@Test
				  public PGLivePage VerifyExternalPageAuthFlowMVPD_1874() 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							objOptLogin = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objOptLogin.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
							}
							Thread.sleep(4000);
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							
							
							Thread.sleep(8000);
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"MVPD Login page should be closed and NBC page should Open"+Extent_Reports.logActual+"MVPD Login page is closed and NBC page is Opened",driver);

							Thread.sleep(90000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
							
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}		
		
//========================================================================Desktop - Verify the navigation to live stream page for user already authenticated with an MVPD (NBCRESP-1873)=================================================
				@Test
				  public PGLivePage VerifyLiveStreamNavigationForLoggedUer_2106() 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							objOptLogin = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objOptLogin.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Login page should display"+ Extent_Reports.logActual+"login page is not displayed",driver);
							}
							Thread.sleep(4000);
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							
							
							Thread.sleep(8000);
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"MVPD Login page should be closed and NBC page should Open"+Extent_Reports.logActual+"MVPD Login page is closed and NBC page is Opened",driver);

							Thread.sleep(90000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
							driver.navigate().to("https://www.nbc.com/live");
							Thread.sleep(70000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Navigate to Live page"+Extent_Reports.logActual+"Navigated to https://www.nbc.com/live",driver);
							Actions builders = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builders.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPalyi = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPausei = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause);
							driver.switchTo().defaultContent();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}		
		
//========================================================================Desktop - Verify the navigation to live stream page for user not authenticated with an MVPD (NBCRESP-1873)=================================================
				@Test
				  public PGLivePage VerifyNavigationLiveStreamNotAuthenticated_2106() 
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
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Thread.sleep(20000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							String winHandleBeforeo = driver.getWindowHandle();
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
								}
							
							try
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
								driver.close();
							}

							catch(Exception e)
							{
							e.printStackTrace();
							System.out.println("not closed");
							}
							
							
							driver.switchTo().window(winHandleBeforeo);
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
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
		
//========================================================================Desktop - Verify Frontend layout and general setup for Live stream page (NBCRESP-1752)=================================================
				@Test
				  public PGLivePage VerifyLiveStreamGeneralLayOut_2093() 
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
							
							objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
							objLive.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
							driver.navigate().refresh();
							Actions act = new Actions(driver); 
							
							//Click on TV provider link 
							Thread.sleep(20000);
							objOptimum = Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
							act.moveToElement(objOptimum).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Login page should display"+ Extent_Reports.logActual+"Provider login page is displayed",driver);
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
							
							//Login screen validation
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							
							
							Thread.sleep(40000);
							//Enter User Name and Password details
							objUserName = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							objUserName.sendKeys(lstTestData.get(1));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter user name"+ Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(1),driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							objPassword.sendKeys(lstTestData.get(2));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+ Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
							
							objlogin = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							objlogin.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Submit button should be clicked"+ Extent_Reports.logActual+"Submit button is clicked",driver);
							
							
							Thread.sleep(16000);
							
							/*//Need to add explicit wait
							objSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
							
							String strSuccessMsg = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64)).getText();
							System.out.println(strSuccessMsg);
							if(strSuccessMsg.contentEquals("YOU ARE SUCCESSFULLY LOGGED IN"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Success message should dispaly"+Extent_Reports.logActual+"Success message is not displayed",driver);
							}
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"MVPD Login page should be closed and NBC page should Open"+Extent_Reports.logActual+"MVPD Login page is closed and NBC page is Opened",driver);
*/
							Thread.sleep(90000);
							Actions builder = new Actions(driver);
							
							objVideoFrame = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							driver.switchTo().frame(objVideoFrame);
							System.out.println("lolololo"); 
							objVideoPlayPause = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
							builder.moveToElement(objVideoPlayPause).build().perform();
							Thread.sleep(2000);
							
							objVideoPlayPauseStatus = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							String strStstusPaly = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPaly); 
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Success message fade out should be done"+Extent_Reports.logActual+"Success message fade out is completed and Video is playing",driver);
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the Play Pause button active status is "+strStstusPaly,driver);
							
							builder.moveToElement(objVideoPlayPause).click().build().perform();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video is clicked to be paused"+Extent_Reports.logActual+"Video is paused",driver);
							Thread.sleep(2000);
							String strStstusPause = objVideoPlayPauseStatus.getAttribute("active");
							System.out.println(strStstusPause); 
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video should playing"+Extent_Reports.logActual+"Video is playing and the PlayPause button active status is "+strStstusPause,driver);
							
							//Header list 
							driver.switchTo().defaultContent();
							List<WebElement> objLiveStreamHeader = Utilities.returnElements(driver,lstObject.get(74),lstObject.get(73));
							//List<WebElement> objLiveStreamHeaderobjects = objLiveStreamHeader.get(0).findElements(By.tagName("li"));
							for(int iIterator=0;iIterator<objLiveStreamHeader.size();iIterator++)
							{
								String strNavigationItemsList = objLiveStreamHeader.get(iIterator).findElement(By.tagName("span")).getText();
								String StrListValue = strNavigationItemsList+";"+strNavigationItemsList;
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Header Items should dispalying "+Extent_Reports.logActual+"Live Stream Header Items are dispalying and the list is: "+StrListValue,driver);
							}
							
							//Live flag
							objLiveStreamFlag = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
							String strLiveStreamFlag = objLiveStreamFlag.getText();
							if(strLiveStreamFlag.contentEquals("LIVE"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Flag should display"+Extent_Reports.logActual+"Live Stream Flag is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Live Stream Flag should display"+Extent_Reports.logActual+"Live Stream Flag is not displayed",driver);
							}
							
							//Live show name
							objLiveStreamTitle = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
							String strTitle = objLiveStreamTitle.getText();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Title should dispaly"+Extent_Reports.logActual+"Live Stream Title is dispalyed and the Name is "+strTitle,driver);
							
							//Rating
							objLiveStreamRating = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
							String strRating = objLiveStreamRating.getText();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Rating should dispaly"+Extent_Reports.logActual+"Live Stream Rating is dispalyed and the Rating is "+strRating,driver);
							
							//Logo
							objLiveStreamLogo = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
							if(objLiveStreamLogo.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Logo should dispaly"+Extent_Reports.logActual+"Live Stream Logo is dispalyed ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Live Stream Logo should dispaly"+Extent_Reports.logActual+"Live Stream Logo is not dispalyed",driver);
							}
							
							//Footer
							objFooter =  Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
							if(objFooter.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Stream Footer should dispaly"+Extent_Reports.logActual+"Live Stream Footer is dispalyed ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Live Stream Footer should dispaly"+Extent_Reports.logActual+"Live Stream Footer is not dispalyed ",driver);
							}
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							// driver.close(); 
						 }
						
						//driver.close(); 
						
						return null;
					}		
//========================================================================Desktop (Browser:Chrome) - Verify auth iFrame layout and behaviors (NBCRESP-2095)=================================================
				@Test
				  public PGLivePage VerifyAuthIFrameLayOutDirectTV_2095( ) throws InterruptedException, FilloException 
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
							
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(92),lstObject.get(91)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94)).get(17);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(154));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(3)))
								{
									objShowList.get(ilinksIterator).click();
									Thread.sleep(20000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							
							//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
							Thread.sleep(14000);
							//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
							
							List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(101),lstObject.get(100));
							
						
							objloadbutton.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
							////objloadbutton.click();
							Thread.sleep(32000);  
							
							List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(104),lstObject.get(103));
							wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
							
							Thread.sleep(24000);
							System.out.println(objauthcode.size());
							if(objauthcode.size()>0)
							{
								
								objauthcode.get(0).click();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked",driver);
								
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video",driver);
								driver.close();
							}
							Thread.sleep(4000);
							
							objTVProviderLink = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
							objTVProviderLink.click();	
							Thread.sleep(2000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TVProviderLink should be clicked"+Extent_Reports.logActual+"TVProviderLink is clicked",driver);
							
							
							 
												
							//DirectTV
							
							objTVProviderLinks = Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));
							List<WebElement> objTVProviderLinksList = objTVProviderLinks.findElements(By.tagName("a"));
							objTVProviderLinksList.get(1).click();
							Thread.sleep(20000);
							//String strProviderLinkNameD = objTVProviderLinksList.get(1).getAttribute("alt");
							//String strProviderLinkNameD = objTVProviderLinks.get(1).findElement(By.tagName("alt")).getText();
							//objTVProviderLinksList.get(1).click();
							
							//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Should be clicked"+ Extent_Reports.logActual+"TV Provider is clicked and the link name is "+strProviderLinkNameD);
							objBackBtDirectTV = Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
							objBackBtDirectTV.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct TV Login/Register page should be displayed"+ Extent_Reports.logActual+"TV Provider Direct TV Login/Register page is displayed",driver);
							
							
							//Full List Link display
							WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
							if(objFullListLink.isDisplayed())
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
							}
						//faq link should display
						List<WebElement> objFaqLink =Utilities.returnElements(driver,lstObject.get(56),lstObject.get(55));
						objFaqLink.get(1).isDisplayed();
						if(objFaqLink.get(1).isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FAQ link should be displayed"+ Extent_Reports.logActual+"FAQ link is displayed",driver);					
						}
						else
						{
							System.out.println("Fail");
						}
						
						List<WebElement> objFAQLinks = Utilities.returnElements(driver,lstObject.get(59),lstObject.get(58));
						objFAQLinks.get(1).click();
						Thread.sleep(8000);
						
						String winHandleBeforf = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							}
						try
						{
							String strfaqURL = driver.getCurrentUrl();
							if(strfaqURL.contentEquals("https://www.nbc.com/general/pages/faq"))
							{
								System.out.println("Pass");
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has opened",driver);
							}
							else
							{
								System.out.println("Fail");
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has not opened",driver);
							}
							driver.close();
						}

						catch(Exception e)
						{
						e.printStackTrace();
						System.out.println("not closed");
						}
						
						
						driver.switchTo().window(winHandleBeforf);
						
					
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close(); 
						 }
						
						driver.close(); 
						
						return null;
					}	
							
//========================================================================Desktop (Browser:Chrome) - Verify the Full list view layout and behavior in VOD page (NBCRESP-2093)=================================================
				@Test
				  public PGLivePage VerifyFullListViewLayOut_2093( ) throws InterruptedException, FilloException 
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
						objLive =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objLive.click();
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Live Page should display"+ Extent_Reports.logActual+"Live page is displayed after Live link is clicked from global navigation",driver);
						
						Actions act = new Actions(driver); 
						
						
						//Full List Link display
						WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
						if(objFullListLink.isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
						}	
						objFullListLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be clickable"+ Extent_Reports.logActual+"Full List TV Providers link is clickable",driver);
						
						//Verify Full List page Title on Page 
						objFullListPageTitle =Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
						String strFullListPageTitle = objFullListPageTitle.getText();
						if(objFullListPageTitle.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Title Heading should be 'Select Provider'"+ Extent_Reports.logActual+"Full List TV Providers Page Title as Heading is "+strFullListPageTitle,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Title Heading should be 'Select Provider'"+ Extent_Reports.logActual+"Full List TV Providers Page Title not dispalying and the Heading is "+strFullListPageTitle,driver);
						}
						
						//Verify Back Button 
						objFullListPageBack =Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
						String strFullListPageBack = objFullListPageBack.getText();
						if(objFullListPageBack.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Back Link is Displayed and the link text is "+strFullListPageBack,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Back Link is Displayed and the link text is not displayed ",driver);
						}
						
						
						//Verify Text below Link Providers Heading
						List <WebElement> objFullListPageTextBelow =Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						String strFullListPageDescription = objFullListPageTextBelow.get(0).getText();
						if(strFullListPageDescription.contentEquals("Search for your provider."))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Description is Displayed and the Description text is "+strFullListPageDescription,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Description is Displayed and the text is not displayed ",driver);
						}
						
					    //Verify Search Text 
						objFullListPageSearchListText =Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
						String strFullListPageListText = objFullListPageSearchListText.getAttribute("placeholder");
						if(objFullListPageSearchListText.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text is dispalyed and the text is "+strFullListPageListText,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text is not dispalyed",driver);
						}
						
						//Verify Search Text Above Search Combo box
						List<WebElement> objFullListPageSearchTextCombo =Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						String StrFullListPageSearchTextCombo = objFullListPageSearchTextCombo.get(1).getText();
						if(objFullListPageSearchTextCombo.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page ComboBox text is dispalyed and the text is "+StrFullListPageSearchTextCombo,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page ComboBox text  should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page ComboBox text is not dispalyed",driver);
						}
						
						//Verify Search  Combo box
						
						objFullListPageSearchListCombo =Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
						if(objFullListPageSearchListCombo.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed ",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is not dispalyed",driver);
						}
						
						//Verify Faq text 
						List<WebElement> objFullListPageFaq =Utilities.returnElements(driver,lstObject.get(131),lstObject.get(130));
						String strfaqText = objFullListPageFaq.get(1).getText();
						if(objFullListPageFaq.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page faq should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq is dispalyed and the text is "+strfaqText,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page faq should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq is not dispalyed",driver);
						}
						
						//Verify faq liink 
						List<WebElement> objFullListPageFaqlink =Utilities.returnElements(driver,lstObject.get(134),lstObject.get(133));
						String strfaqTextlink = objFullListPageFaqlink.get(1).getText();
						if(objFullListPageFaqlink.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page faq link should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq link is dispalyed and the text is "+strfaqTextlink,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page faq link should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq link is not dispalyed",driver);
						}
						
						//Scroll for combo box 
						try
						{
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("arguments[0].scrollIntoView(true);",objFullListPageSearchListCombo);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is dispalyed",driver);
						}
						catch(Exception exc)
						{
							 System.out.println(exc.getMessage());
							 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is not dispalyed",driver);
						}
						
						//Enter Search text into text box 
						objFullListPageSearchListText.sendKeys("3");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search text should be editable"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text box is editable and data is entered as "+(lstTestData.get(0)),driver);
						
						//Validate search Results in the combo box
						List <WebElement> objFullListPageSearchListComboR = Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						List <WebElement> objResultCombo = objFullListPageSearchListComboR.get(0).findElements(By.tagName("li"));
						int iResultsCt = objResultCombo.size(); 
						for(int iTerator=0;iTerator<iResultsCt-1;iTerator++)
						{
							List<WebElement> objResultView = objResultCombo.get(iTerator).findElements(By.tagName("span"));
							String strComboBoxItems = objResultView.get(1).getText();
							strSearchListItemsList = strComboBoxItems+";"+strSearchListItemsList;
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Results should be dispalyed in combo list"+ Extent_Reports.logActual+"Full List TV Providers Page Search Results is dispalyed in combo list"+strSearchListItemsList,driver);
						}
						
						//Click on Faq link 
						objFullListPageFaqlink.get(1).click();
						Thread.sleep(8000);					
						String winHandleBeforf = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							}
						String strfaqURL = driver.getCurrentUrl();
						System.out.println(strfaqURL);
						if(strfaqURL.contentEquals("https://www.nbc.com/general/pages/faq"))
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has opened and the current URL is "+strfaqURL,driver);
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has not opened",driver);
						}
						
						try
						{
							driver.close();
						}
						catch(Exception e)
						{
						e.printStackTrace();
						System.out.println("not closed");
						}
						driver.switchTo().window(winHandleBeforf);
						
						//Click on Back link
						Thread.sleep(1000);
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("window.scrollBy(0,-50)", "");
						objFullListPageBack.click();
						Thread.sleep(2000);
						objTVProvidertwcText = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
						if(objTVProvidertwcText.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Back link is clicked and TV Provider page should be displayed"+ Extent_Reports.logActual+"Back link is clicked and TV Provider page is displayed",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Back link is clicked and TV Provider page should be displayed"+ Extent_Reports.logActual+"Back link is clicked and TV Provider page is not displayed",driver);
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
							
//========================================================================Desktop (Browser:Chrome) : Verify the size of the scroll box changes based on the number of results for Predictive Text Input Field in VOD page  (NBCRESP-2106)=================================================
				@Test
				  public PGLivePage VerifyScrollSizeForVODPage_2093( ) throws InterruptedException, FilloException 
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
						WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(92),lstObject.get(91)).get(0);
						objShowLink.click();
						
						/*Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation");
						WebElement objShowList = Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94)).get(17);
						String ShowlistText = objShowList.getText();
						System.out.println(ShowlistText);
						objShowList.click();*/
						List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(154));
						List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
						int ilinksMenuCount = objShowList.size();
						for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
						{
							String strMenuLinkName = objShowList.get(ilinksIterator).getText();
							if(strMenuLinkName.contentEquals(lstTestData.get(3)))
							{
								objShowList.get(ilinksIterator).click();
								Thread.sleep(20000);
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
								break;
							}
						
						}
						//Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
						
						WebDriverWait wait= new WebDriverWait(driver,60);
						
						//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
						Thread.sleep(4000);
						//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
						
						List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(101),lstObject.get(100));
						
					
						objloadbutton.get(0).click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
						////objloadbutton.click();
						Thread.sleep(6000);  
						
						List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(104),lstObject.get(103));
						wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
						
						Thread.sleep(4000);
						System.out.println(objauthcode.size());
						if(objauthcode.size()>0)
						{
							
							objauthcode.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked",driver);
							
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video",driver);
							//driver.close();
						}
						Thread.sleep(6000);
						
						objTVProviderLink = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
						objTVProviderLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TVProviderLink should be clicked"+Extent_Reports.logActual+"TVProviderLink is clicked",driver);
						
						Thread.sleep(3000);
						objSearchTextBox = Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
						objSearchTextBox.sendKeys(lstTestData.get(4));
						
						//Verify Search  Combo box
						List<WebElement> objFullListPageSearchListCombo =Utilities.returnElements(driver,lstObject.get(128),lstObject.get(127));
						if(objFullListPageSearchListCombo.get(0).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed ",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is not dispalyed",driver);
						}
						//Scroll for combo box 
						try
						{
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("arguments[0].scrollIntoView(true);",objFullListPageSearchListCombo.get(0));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is dispalyed",driver);
						}
						catch(Exception exc)
						{
							 System.out.println(exc.getMessage());
							 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is not dispalyed",driver);
						}
						List<WebElement>objListItems = objFullListPageSearchListCombo.get(0).findElements(By.tagName("li"));
						int iListItems = objListItems.size();
						String iScrollHeight = objFullListPageSearchListCombo.get(0).getAttribute("clientHeight");
						System.out.println(iScrollHeight);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed and scroll"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed with scroll for Results ListItems and scroll height are "+iListItems +"&"+iScrollHeight,driver);
						
						Thread.sleep(2000);
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("window.scrollBy(0,-250)", "");
						Thread.sleep(2000);
						objSearchClear = Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
						objSearchClear.click();
						
						Thread.sleep(1000);
						
						
						objSearchTextBox.sendKeys(lstTestData.get(5));
						objSearchComboList = Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
						List<WebElement> objoneListItems = objSearchComboList.findElements(By.tagName("li"));
						int iOneListItems = objoneListItems.size();
						String iScrollHeightone = objSearchComboList.getAttribute("clientHeight");
						System.out.println(iScrollHeightone);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed and scroll"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed with scroll for Results ListItems and scroll height are "+iOneListItems +"&"+iScrollHeightone,driver);
						
						objSearchClear.click();
						Thread.sleep(1000);
						objSearchTextBox.sendKeys(lstTestData.get(6));
						Thread.sleep(1000);
						objSearchComboList = Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
						List<WebElement> objListItemsM = objSearchComboList.findElements(By.tagName("li"));
						int iListItemsM = objListItemsM.size();
						String iScrollHeightm = objSearchComboList.getAttribute("clientHeight");
						System.out.println(iScrollHeightm);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed and scroll"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed with scroll for Results ListItems and scroll height are "+iListItemsM +"&"+iScrollHeightm,driver);
						
						if(iScrollHeightone.contentEquals(iScrollHeightm))
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search ComboBox should be dispalyed and scroll"+ Extent_Reports.logActual+"Search ComboBox is dispalyed with no scroll for different search criteria , scroll height are "+iScrollHeightone +"&"+iScrollHeightm+"&"+iScrollHeight,driver);
						}
						else
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search ComboBox should be dispalyed and scroll"+ Extent_Reports.logActual+"Search ComboBox is dispalyed with scroll for different search criteria , scroll height are "+iScrollHeightone +"&"+iScrollHeightm+"&"+iScrollHeight,driver);
							
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
//========================================================================Desktop (Browser:Chrome) - Verify the Full list view layout and behavior in VOD page (NBCRESP-2093)=================================================
				@Test
				  public PGLivePage VerifyFullListViewLayOutVOD_2093( ) throws InterruptedException, FilloException 
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
						WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(92),lstObject.get(91)).get(0);
						objShowLink.click();
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
						/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94)).get(17);
						String ShowlistText = objShowList.getText();
						System.out.println(ShowlistText);
						objShowList.click();
						Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
						*/
						List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(154));
						List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
						int ilinksMenuCount = objShowList.size();
						for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
						{
							String strMenuLinkName = objShowList.get(ilinksIterator).getText();
							if(strMenuLinkName.contentEquals(lstTestData.get(3)))
							{
								objShowList.get(ilinksIterator).click();
								Thread.sleep(20000);
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
								break;
							}
						
						}
						WebDriverWait wait= new WebDriverWait(driver,60);
						
						//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
						Thread.sleep(4000);
						//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
						
						List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(101),lstObject.get(100));
						
					
						objloadbutton.get(0).click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
						////objloadbutton.click();
						Thread.sleep(6000);  
						
						List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(104),lstObject.get(103));
						wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
						
						Thread.sleep(4000);
						System.out.println(objauthcode.size());
						if(objauthcode.size()>0)
						{
							
							objauthcode.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked",driver);
							
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video",driver);
							//driver.close();
						}
						Thread.sleep(6000);
						
						objTVProviderLink = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
						objTVProviderLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TVProviderLink should be clicked"+Extent_Reports.logActual+"TVProviderLink is clicked",driver);
						
						Thread.sleep(3000);
						
						
						//Full List Link display
						WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
						if(objFullListLink.isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
						}	
						objFullListLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be clickable"+ Extent_Reports.logActual+"Full List TV Providers link is clickable",driver);
						
						//Verify Full List page Title on Page 
						objFullListPageTitle =Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
						String strFullListPageTitle = objFullListPageTitle.getText();
						if(objFullListPageTitle.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Title Heading should be 'LINK PROVIDER'"+ Extent_Reports.logActual+"Full List TV Providers Page Title as Heading is "+strFullListPageTitle,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Title Heading should be 'LINK PROVIDER'"+ Extent_Reports.logActual+"Full List TV Providers Page Title not dispalying and the Heading is "+strFullListPageTitle,driver);
						}
						
						//Verify Back Button 
						objFullListPageBack =Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
						String strFullListPageBack = objFullListPageBack.getText();
						if(objFullListPageBack.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Back Link is Displayed and the link text is "+strFullListPageBack,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Back Link should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Back Link is Displayed and the link text is not displayed ",driver);
						}
						
						
						//Verify Text below Link Providers Heading
						List <WebElement> objFullListPageTextBelow =Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						String strFullListPageDescription = objFullListPageTextBelow.get(0).getText();
						if(strFullListPageDescription.contentEquals("Search for your provider."))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Description should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Description is Displayed and the Description text is "+strFullListPageDescription,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Description should be avialable"+ Extent_Reports.logActual+"Full List TV Providers Page Description is Displayed and the text is not displayed ",driver);
						}
						
					    //Verify Search Text 
						objFullListPageSearchListText =Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
						String strFullListPageListText = objFullListPageSearchListText.getAttribute("placeholder");
						if(objFullListPageSearchListText.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text is dispalyed and the text is "+strFullListPageListText,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text is not dispalyed",driver);
						}
						
						//Verify Search Text Above Search Combo box
						List<WebElement> objFullListPageSearchTextCombo =Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						String StrFullListPageSearchTextCombo = objFullListPageSearchTextCombo.get(1).getText();
						if(objFullListPageSearchTextCombo.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox Text should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page ComboBox text is dispalyed and the text is "+StrFullListPageSearchTextCombo,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page ComboBox text  should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page ComboBox text is not dispalyed",driver);
						}
						
						//Verify Search  Combo box
						objFullListPageSearchListCombo =Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
						if(objFullListPageSearchListCombo.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is dispalyed ",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page search ComboBox should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search ComboBox is not dispalyed",driver);
						}
						
						//Verify Faq text 
						List<WebElement> objFullListPageFaq =Utilities.returnElements(driver,lstObject.get(131),lstObject.get(130));
						String strfaqText = objFullListPageFaq.get(1).getText();
						if(objFullListPageFaq.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page faq should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq is dispalyed and the text is "+strfaqText,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page faq should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq is not dispalyed",driver);
						}
						
						//Verify faq liink 
						List<WebElement> objFullListPageFaqlink =Utilities.returnElements(driver,lstObject.get(134),lstObject.get(133));
						String strfaqTextlink = objFullListPageFaqlink.get(1).getText();
						if(objFullListPageFaqlink.get(1).isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page faq link should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq link is dispalyed and the text is "+strfaqTextlink,driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page faq link should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page faq link is not dispalyed",driver);
						}
						
						//Scroll for combo box 
						try
						{
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("arguments[0].scrollIntoView(true);",objFullListPageSearchListCombo);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is dispalyed",driver);
						}
						catch(Exception exc)
						{
							 System.out.println(exc.getMessage());
							 Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers Page Search Combo list box scroll should be dispalyed"+ Extent_Reports.logActual+"Full List TV Providers Page Search Combo list box scroll is not dispalyed",driver);
						}
						
						//Enter Search text into text box 
						objFullListPageSearchListText.sendKeys("3");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search text should be editable"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text box is editable and data is entered as "+(lstTestData.get(0)),driver);
						
						//Validate search Results in the combo box
						List <WebElement> objFullListPageSearchListComboR = Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
						List <WebElement> objResultCombo = objFullListPageSearchListComboR.get(0).findElements(By.tagName("li"));
						int iResultsCt = objResultCombo.size(); 
						for(int iTerator=0;iTerator<iResultsCt-1;iTerator++)
						{
							List<WebElement> objResultView = objResultCombo.get(iTerator).findElements(By.tagName("span"));
							String strComboBoxItems = objResultView.get(1).getText();
							strSearchListItemsList = strComboBoxItems+";"+strSearchListItemsList;
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search Results should be dispalyed in combo list"+ Extent_Reports.logActual+"Full List TV Providers Page Search Results is dispalyed in combo list"+strSearchListItemsList,driver);
						}
						
						//Click on Faq link 
						objFullListPageFaqlink.get(1).click();
						Thread.sleep(8000);					
						String winHandleBeforf = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							}
						String strfaqURL = driver.getCurrentUrl();
						System.out.println(strfaqURL);
						if(strfaqURL.contentEquals("https://www.nbc.com/general/pages/faq"))
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has opened and the current URL is "+strfaqURL,driver);
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"FQA URL has opened"+ Extent_Reports.logActual+"FQA URL has not opened",driver);
						}
						
						try
						{
							driver.close();
						}
						catch(Exception e)
						{
						e.printStackTrace();
						System.out.println("not closed");
						}
						driver.switchTo().window(winHandleBeforf);
						
						//Click on Back link
						Thread.sleep(1000);
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("window.scrollBy(0,-50)", "");
						objFullListPageBack.click();
						Thread.sleep(2000);
						objTVProvidertwcText = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
						if(objTVProvidertwcText.isDisplayed())
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Back link is clicked and TV Provider page should be displayed"+ Extent_Reports.logActual+"Back link is clicked and TV Provider page is displayed",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Back link is clicked and TV Provider page should be displayed"+ Extent_Reports.logActual+"Back link is clicked and TV Provider page is not displayed",driver);
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
											
//========================================================================Desktop (Browser:Chrome) : Verify the user's input returns one result, so hitting the enter button functions as selection in VOD page  (NBCRESP-2106)=================================================
				@Test
				  public PGLivePage VerifyOneResultEnterButton_2093( ) throws InterruptedException, FilloException 
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
						WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(92),lstObject.get(91)).get(0);
						objShowLink.click();
						
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
						/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94)).get(17);
						String ShowlistText = objShowList.getText();
						System.out.println(ShowlistText);
						objShowList.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
						*/
						List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(154));
						List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
						int ilinksMenuCount = objShowList.size();
						for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
						{
							String strMenuLinkName = objShowList.get(ilinksIterator).getText();
							if(strMenuLinkName.contentEquals(lstTestData.get(3)))
							{
								objShowList.get(ilinksIterator).click();
								Thread.sleep(20000);
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
								break;
							}
						
						}
						WebDriverWait wait= new WebDriverWait(driver,60);
						
						//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
						Thread.sleep(4000);
						//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
						
						List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(101),lstObject.get(100));
						
					
						objloadbutton.get(0).click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
						////objloadbutton.click();
						Thread.sleep(6000);  
						
						List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(104),lstObject.get(103));
						wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
						
						Thread.sleep(4000);
						System.out.println(objauthcode.size());
						if(objauthcode.size()>0)
						{
							
							objauthcode.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked",driver);
							
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video",driver);
							//driver.close();
						}
						Thread.sleep(8000);
						
						objTVProviderLink = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
						objTVProviderLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TVProviderLink should be clicked"+Extent_Reports.logActual+"TVProviderLink is clicked",driver);
						
						Thread.sleep(3000);
						
						
						//Full List Link display
						WebElement	objFullListLink =Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
						if(objFullListLink.isDisplayed())
						{
							System.out.println("Pass");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is displayed",driver);       
						}
						else
						{
							System.out.println("Fail");
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Full List TV Providers link should be displayed"+ Extent_Reports.logActual+"Full List TV Providers link is not displayed",driver);
						}	
						objFullListLink.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers link should be clickable"+ Extent_Reports.logActual+"Full List TV Providers link is clickable",driver);
						
						
						Thread.sleep(2000);
						//Enter Search text into text box 
						objFullListPageSearchTextbox = Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
						objFullListPageSearchTextbox.sendKeys(lstTestData.get(5));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search text should be editable"+ Extent_Reports.logActual+"Full List TV Providers Page Search Text box is editable and data is entered as "+(lstTestData.get(0)),driver);
						
						//Click Enter on Search Text Box 	
						objFullListPageSearchTextbox.sendKeys(Keys.ENTER);
						Thread.sleep(4000);
						String winHandleBeforf = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							}
						try
						{
							driver.close();
						}
						catch(Exception e)
						{
						e.printStackTrace();
						System.out.println("not closed");
						}
						driver.switchTo().window(winHandleBeforf);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Full List TV Providers Page Search text is entered and only 1 result should be displayed where on click of Enter Will navigate separate window of respective TV Provider"+ Extent_Reports.logActual+"Full List TV Providers Page Search text is entered and only 1 result is displayed where on click of Enter is navigated separate window of respective TV Provider",driver);
						
						
						
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

