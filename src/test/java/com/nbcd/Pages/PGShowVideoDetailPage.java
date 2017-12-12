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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class PGShowVideoDetailPage {

	private static final String VerifyAppsLandingPage = null;
		//=========================================Variables=================================================================================
		private WebDriver driver;
		String sql;
		protected static String showDetails;
		DatabaseFunction db = new DatabaseFunction();
		public List<String> lstObject,lstTestData,arrSeasonsOptions;
		static String screenshotExtension;
		String sqlQry,Status,strResultText;
		WebElement objSeasonList,objauthcode,objTVProvider,objOptinium,objUserName,objPassword,objSignIn,objOptniumLogo;
		WebElement objVisitSite,objUnlink,objShowLinks,objEpisodesHeading,objDetails,objDetailsDescription,objDetailsExpires;
		WebElement objClipDropDown,objCopyRightsInfo,objShare,objShowListmenu,objShowList;
		WebElement objTwitterCard,objTwitterSite,objTwitterSiteId,objTwitterTitle,objTwitterDescription,objTwitterImage;
		
	//=================================================================================================================================================================================	
	//Constructor to initialize all the Page Objects  
		public PGShowVideoDetailPage(WebDriver driver) throws MalformedURLException 
		{      
			try 
				{
					
					this.driver = driver;
					lstTestData=db.getTestDataObject("Select * from ShowVideoDetailPage","Input");
					lstObject=db.getTestDataObject("Select * from ShowVideoDetailPage","ObjectRepository");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						
						
			}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGShowVideoDetailPage VerifyVideoDetailPageOpened( ) throws InterruptedException, FilloException 
		  {
			
				//Launching Browser with valid URL.
				     driver.get(lstTestData.get(0));
					 
				     try
				     {
				     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
				     screenshotExtension=Extent_Reports.getScreenshot(driver);
				     }
				     catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
				//Reading Objects
				try
				 {
					
					driver.navigate().to(lstTestData.get(1));
					String VideoURL = driver.getCurrentUrl();
					if(VideoURL.contentEquals("https://www.nbc.com/video"))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video Detail Page should display"+Extent_Reports.logActual+"Video Detail Page is displayed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Video Detail Page should display"+Extent_Reports.logActual+"Video Detail Page is not displayed",driver);
					}
					
					driver.navigate().to(lstTestData.get(2));
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Navigate to different page"+Extent_Reports.logActual+"Navigated to different page",driver);
					driver.navigate().to(lstTestData.get(1));
					String VideoURLs = driver.getCurrentUrl();
					if(VideoURLs.contentEquals("https://www.nbc.com/video"))
					{
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video Detail Page should display"+Extent_Reports.logActual+"Video Detail Page is displayed",driver);
					}
					else
					{
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Video Detail Page should display"+Extent_Reports.logActual+"Video Detail Page is not displayed",driver);
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
	
//========================================================================Desktop-Verify order of Seasons in Episode drop down menu of Classic Show Video details page in Responsive Web Site in (DBB-3105)=================================================
		@Test
		  public PGShowVideoDetailPage VerifyVideosSeasonlistSorting_3100( ) throws InterruptedException, FilloException 
		  {
			
				//Launching Browser with valid URL.
				     driver.get(lstTestData.get(0));
					 
				     try
				     {
				     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
				     screenshotExtension=Extent_Reports.getScreenshot(driver);
				     }
				     catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
				//Reading Objects
				try
				 {
					WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
					objShowLink.click();
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
					/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
					String ShowlistText = objShowList.getText();
					System.out.println(ShowlistText);
					objShowList.click();*/
					List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
					List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
					int ilinksMenuCount = objShowList.size();
					for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
					{
						String strMenuLinkName = objShowList.get(ilinksIterator).getText();
						if(strMenuLinkName.contentEquals(lstTestData.get(3)))
						{
							objShowList.get(ilinksIterator).click();
							driver.navigate().refresh();
							Thread.sleep(6000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
							break;
						}
					
					}
					WebDriverWait wait= new WebDriverWait(driver,60);
					//Actions act = new Actions(driver);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
					
					Thread.sleep(4000);
					String CompVal = null;
					int mcount = 0;
					int mscount = 0;
					String strlowerCaseText =lstTestData.get(3).toLowerCase();
					String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
					System.out.println(strReplaceSpaceText);
					wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
					//List <WebElement>  objFilter = driver.findElements(By.cssSelector("div.filter-select__inner"));
					List <WebElement>  objFilter = Utilities.returnElements(driver,lstObject.get(62),lstObject.get(61));
					objFilter.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Seasons List box"+Extent_Reports.logActual+"Seasons List box is clicked",driver);
					
					//List <WebElement>  objFilterlink = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) ul li.filter-select__item"));
					List <WebElement>  objFilterlink = Utilities.returnElements(driver,lstObject.get(65),lstObject.get(64));
					int iListOptionsct = objFilterlink.size();
					System.out.println(objFilterlink.size()); 
					for (int itrCount=1;itrCount<iListOptionsct;itrCount++)
				    {
						String strListItem = objFilterlink.get(itrCount).getText();
						System.out.println(objFilterlink.get(itrCount).getText());
						CompVal = CompVal+";"+strListItem;
						System.out.println(CompVal);
				    }
					String[] arrCompVals = CompVal.split(";");
					System.out.println(arrCompVals.length);
					for(int ioptionsList=1;ioptionsList<arrCompVals.length-1;ioptionsList++ )
					{
						System.out.println(arrCompVals[ioptionsList]);
						if(arrCompVals[ioptionsList].compareTo(arrCompVals[ioptionsList+1])>0)
						{
							mcount = mcount+1;
						}
						else
						{
							mscount = mscount+1;
						}
					}
					if(mcount==iListOptionsct-2)
					{
						System.out.println("sorted");
						
						String finalCompVal = CompVal.substring(6, CompVal.length());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video list Season options should be sorted from latest season to old"+Extent_Reports.logActual+"Video list Season options should be sorted from latest season to old and the options are  "+finalCompVal,driver);
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
			
		//========================================================================Desktop-Verify meta tag =================================================
				@Test
				  public PGShowVideoDetailPage VerifyMetatagsmartlink_2557 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(1);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
							Synchronization.implicitWait(driver, 160);
							Thread.sleep(4000);
							//List <WebElement> objVideoList = driver.findElements(By.cssSelector("div.video-list__container > div > a"));
							List <WebElement> objVideoList = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49));
							 String strVideoMetadata = objVideoList.get(0).getText();
							 System.out.println(objVideoList.get(1).getText());
							 objVideoList.get(0).click();
							 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Show Video"+Extent_Reports.logActual+"Show video is clicked and the metadata of video is  "+strVideoMetadata,driver);
							 objShowLinks = Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52)); 
							String txt = objShowLinks.getAttribute("src");
							System.out.println(txt);
							if(txt.contentEquals("https://smart.link/58b4a4186ac97"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta tag for smart link should be as expected"+Extent_Reports.logActual+"Meta tag for smart link is as expected and the tag is "+txt,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta tag for smart link should be as expected"+Extent_Reports.logActual+"Meta tag for smart link is as not expected and the tag is "+txt,driver);
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
	
	//========================================================================Desktop-Verify meta tag =================================================
				@Test
				  public PGShowVideoDetailPage VerifySNLEpisode_3101 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(15);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(4)))
								{
									objShowList.get(ilinksIterator).click();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+lstTestData.get(4),driver);
							Synchronization.implicitWait(driver, 160);
							Thread.sleep(4000);
							//List <WebElement> objVideolist = driver.findElements(By.cssSelector("div.video-list__container > div > a"));
							List <WebElement> objVideolist = Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49));
							String VideoMetadata1 = objVideolist.get(0).getText();
							System.out.println(objVideolist.get(1).getText());
							 objVideolist.get(0).click();
							 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Video"+Extent_Reports.logActual+"Video is clicked and Video page is dispalyed and the metadata of video is "+VideoMetadata1,driver);
							 String VideoTitle = driver.getTitle();
							 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video page should display"+Extent_Reports.logActual+"Video page is dispalyed and the title is "+VideoTitle,driver);
							 driver.navigate().back();
							 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Navigate to back page"+Extent_Reports.logActual+"Navigated to back page",driver);
							 System.out.println(driver.getTitle());
							 String strSNLTitle = driver.getTitle();
							
							 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show page should display"+Extent_Reports.logActual+"Show page is displayed and the title of the page is "+strSNLTitle,driver);
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
						 }
						
						driver.close(); 
						
						return null;
					} 		
//========================================================================Desktop-Verify air date sort =================================================
				@Test
				  public PGShowVideoDetailPage VerifyEarliestairdatetolatestairdate_3100 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(1);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(5)))
								{
									objShowList.get(ilinksIterator).click();
									driver.navigate().refresh();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							Synchronization.implicitWait(driver, 160);
							Thread.sleep(4000);
							String compVal = null;
							int mcount=0;
							int mscount=0;
							//List<WebElement> objVideoslist =  driver.findElements(By.cssSelector("div.show-page__modules >section:nth-child(1) > div >div > div >a"));
							List<WebElement> objVideoslist =  Utilities.returnElements(driver,lstObject.get(47),lstObject.get(46));
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show page should be displayed"+Extent_Reports.logActual+"Show page is displayed for show "+lstTestData.get(5),driver);
							int ctVideos = objVideoslist.size();
							System.out.println(ctVideos);
							
							for(int i =0;i<ctVideos;i++)
							{
								String StrVideoMetadata= objVideoslist.get(i).getText();
								System.out.println(StrVideoMetadata);
								String[] lines = StrVideoMetadata.split("\\n");
								String line1 = lines[0];
								String line2 = lines[1];
								if(line1.contentEquals("NEW"))
								{
									System.out.println(line2);
									String actual=line2.substring(8,16);
									System.out.println(actual);
									compVal = compVal+";"+actual ;
									System.out.println(compVal);
								}
								else
								{
									System.out.println(line1);
									String actual=line1.substring(8,16);
									System.out.println(actual);
									compVal = compVal+";"+actual ;
									System.out.println(compVal);
								}
							}
							
							String[] arrCompVals = compVal.split(";");
							System.out.println(arrCompVals.length);
							for(int l=1;l<arrCompVals.length-1;l++ )
							{
								System.out.println(arrCompVals[l]);
								if(arrCompVals[l].compareTo(arrCompVals[l+1])>0)
								{
									mcount = mcount+1;
								}
								else
								{
									mscount = mscount+1;
								}
							}
							if(mcount==ctVideos-1)
							{
								System.out.println("sorted");
								
								String finalCompVal = compVal.substring(6, compVal.length());
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Video air dates should be sorted from latest to old"+Extent_Reports.logActual+"Show Video air dates are sorted from latest to old and the Show air dates are "+finalCompVal,driver);
							}
							else
							{
								System.out.println("not sorted");
								
								String finalCompVal = compVal.substring(6, compVal.length());
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show Video air dates should be sorted from latest to old"+Extent_Reports.logActual+"Show Video air dates are not sorted from latest to old and the Show air dates are "+finalCompVal,driver);
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
						
//========================================================================MVPD Logo for Desktop Devices  =================================================
				@Test
				  public PGShowVideoDetailPage VerifyMVPDLogo ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(3)))
								{
									objShowList.get(ilinksIterator).click();
									driver.navigate().refresh();
									Thread.sleep(4000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							
							//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
							Thread.sleep(4000);
							//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
							
							List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
							
							objloadbutton.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
							////objloadbutton.click();
							Thread.sleep(10000);  
							
							List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19));
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
							Thread.sleep(16000);
							
							List <WebElement> objTVProvider = Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
							wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
							objTVProvider.get(1).click();	
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked",driver);
							
							Thread.sleep(20000);
							objOptinium = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
							wait.until(ExpectedConditions.visibilityOf(objOptinium));
							objOptinium.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Optimum should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked",driver);
							
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							objUserName = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
							wait.until(ExpectedConditions.visibilityOf(objUserName));
							objUserName.sendKeys("research1000");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered",driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
							objPassword.sendKeys("support1000");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered",driver);
							
							objSignIn = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
							objSignIn.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"SignIn should be Clicked"+Extent_Reports.logActual+"SignIn is Clicked",driver);
							
							Thread.sleep(90000);
							List<WebElement> objOptniumLogo = Utilities.returnElements(driver,lstObject.get(113),lstObject.get(112));
							//wait.until(ExpectedConditions.visibilityOf(objOptniumLogo));
							String Optinumlogotext = objOptniumLogo.get(1).getAttribute("alt");
							if(Optinumlogotext.contentEquals("Optimum"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is not displayed",driver);
							}
							
							objOptniumLogo.get(1).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum logo should be clicked"+Extent_Reports.logActual+"Optimum logo is clicked",driver);
							
							objVisitSite = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
							objVisitSite.click();
							
							String ParentWindows = driver.getWindowHandle();
							Set<String> s2=driver.getWindowHandles();
							Iterator<String> nOptWindow= s2.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							wait.until(ExpectedConditions.urlContains("https://www.optimum.net/"));
							System.out.println(driver.getTitle());
							String ProviderURL = driver.getTitle();
							if(ProviderURL.contentEquals("https://www.optimum.net/"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum URl should be launched"+Extent_Reports.logActual+"Optimum URl is launched",driver);
								driver.close();
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Optimum URl should be launched"+Extent_Reports.logActual+"Optimum URl is not launched",driver);
							}
							driver.switchTo().window(ParentWindows);
							
							objOptniumLogo.get(1).click();
							objUnlink = Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
							objUnlink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum should be unlinked"+Extent_Reports.logActual+"Optimum is unlinked",driver);		
							
							
							
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 driver.close();
						 }
						
						driver.close(); 
						
						return null;
					} 							

//========================================================================Verify_whether_show_video_detailed_page_is_Loading_"next 6"_Most_Recen_clips_upon_page_load=================================================
				@Test
				  public PGShowVideoDetailPage LoadButtonNextSixVideos_3527 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(3)))
								{
									objShowList.get(ilinksIterator).click();
									Thread.sleep(8000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							
							//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
							Thread.sleep(8000);
							//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
							String strlowerCaseText =lstTestData.get(3).toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							
							//Get Videos count in that section
							//objEpisodesHeading = driver.findElement(By.cssSelector("div.show-page__modules section:nth-child(1) h2"));
							objEpisodesHeading = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
							String strHeading = objEpisodesHeading.getText();
							System.out.println(strHeading);
							int iHeadinglen = strHeading.length();
							System.out.println(strHeading);
							String strEpisodesCount = strHeading.substring(12, iHeadinglen-1);
							System.out.println(strEpisodesCount);
							//int iEpisodeIntialCount = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a")).size();
							List<WebElement> objVideosIni = Utilities.returnElements(driver,lstObject.get(59),lstObject.get(58));
							//int iEpisodeIntialCount = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a")).size();
							int iEpisodeIntialCount = objVideosIni.size();
							System.out.println(iEpisodeIntialCount);
							//Click on Load Button 
							List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
							
							objloadbutton.get(0).click();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
							Thread.sleep(8000);
							
							//Get videos count after load button is clicked
							//List<WebElement> objVideos = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a"));
							
							System.out.println(driver.getCurrentUrl());
							List<WebElement> objVideos = Utilities.returnElements(driver,lstObject.get(59),lstObject.get(58));
							System.out.println(driver.getCurrentUrl());
							Thread.sleep(8000);
							//int iEpisodeAfterLoadCount = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a")).size();
							int iEpisodeAfterLoadCount = objVideos.size();
							System.out.println(iEpisodeAfterLoadCount);
							if(iEpisodeAfterLoadCount == iEpisodeIntialCount+6)
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"6 Videos should be loaded after Load Button is clicked"+Extent_Reports.logActual+"6 Videos are loaded after Load Button is clicked",driver);
							}
							else
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"6 Videos should be loaded after Load Button is clicked"+Extent_Reports.logActual+"6 Videos are not loaded after Load Button is clicked",driver);
							}
							
							//Validate Videos air dates for latest to old
							String compVal = null;
							int mcount = 0;
							int mscount = 0;
							for(int iVideoct =0;iVideoct<iEpisodeAfterLoadCount;iVideoct++)
							{
								String StrVideoMetadata= objVideos.get(iVideoct).getText();
								System.out.println(StrVideoMetadata);
								String[] lines = StrVideoMetadata.split("\\n");
								String line1 = lines[0];
								String line2 = lines[1];
								if(line1.contentEquals("NEW"))
								{
									System.out.println(line2);
									String actual=line2.substring(9,18);
									System.out.println(actual);
									compVal = compVal+";"+actual ;
									System.out.println(compVal);
								}
								else
								{
									System.out.println(line1);
									int ilinelength = line1.length();
									if(ilinelength==17)
									{
										System.out.println(ilinelength);
										String actual=line1.substring(9,17);
										System.out.println(actual);
									}
									else
									{
									String actual=line1.substring(8,16);
									System.out.println(actual);
									compVal = compVal+";"+actual ;
									System.out.println(compVal);
									}
								}
							}
							
							String[] arrCompVals = compVal.split(";");
							System.out.println(arrCompVals.length);
							for(int l=1;l<arrCompVals.length-1;l++ )
							{
								System.out.println(arrCompVals[l]);
								System.out.println(arrCompVals[l+1]);
								if(arrCompVals[l].compareTo(arrCompVals[l+1])>0)
								{
									mcount = mcount+1;
								}
								else
								{
									mscount = mscount+1;
								}
							}
							if(mscount==0)
							{
								System.out.println("sorted");
								
								System.out.println(iEpisodeAfterLoadCount);
								String finalCompVal = compVal.substring(6, compVal.length());
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show Video air dates should be sorted from latest to old"+Extent_Reports.logActual+"Show Video air dates are sorted from latest to old and the Show air dates are "+finalCompVal,driver);
							}
							else
							{
								System.out.println("not sorted");
								
								System.out.println(iEpisodeAfterLoadCount);
								String finalCompVal = compVal.substring(6, compVal.length());
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show Video air dates should be sorted from latest to old"+Extent_Reports.logActual+"Show Video air dates are not sorted from latest to old and the Show air dates are "+finalCompVal,driver);
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
				
//========================================================================Verify video series content is populated with the show homepage URL in the OG tags=================================================
				@Test
				  public PGShowVideoDetailPage VerifyOGTagForURLVideoDetail ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
							
							WebDriverWait wait= new WebDriverWait(driver,60);
							Thread.sleep(4000);
							String strlowerCaseText =ShowlistText.toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							
							//Click on any Video
							List<WebElement> objVideoslist = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a"));
							if(objVideoslist.size()>0)
							{
								String strVideoEpisodeDetails = objVideoslist.get(0).getText();
								objVideoslist.get(0).click();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Show Video"+Extent_Reports.logActual+"Shows Video Link is clicked from Show page and the Show Episode details are  "+strVideoEpisodeDetails,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Click on Show Video"+Extent_Reports.logActual+"Shows Video Link is not clicked from Show page ",driver);
								driver.close();
							}
							
							//Get Page Source value for OG Tag for URL
							Thread.sleep(4000);
							System.out.println(driver.getCurrentUrl());
							System.out.println(driver.getTitle());
							Thread.sleep(4000);
						
							WebElement objele;
							objele = driver.findElement(By.xpath("//meta[@property='video:series']"));
							//objele = driver.findElement(By.xpath("//meta[@property='video:series']"));
							String x = objele.getText();
							System.out.println(x);
								
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
							 //driver.close();
						 }
						
						//driver.close(); 
						
						return null;
					} 				

//======================================================================== Verify "Appearing" section in the video metadata when video Details button is expanded in show video detail page=================================================
				@Test
				  public PGShowVideoDetailPage VerifyAppearingSectionVideo_3591 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						    
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(3)))
								{
									objShowList.get(ilinksIterator).click();
									Thread.sleep(8000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							Thread.sleep(4000);
							String strlowerCaseText =lstTestData.get(3).toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							Thread.sleep(4000);
							//Click on any Video
							//List<WebElement> objVideoslist = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a"));
							List<WebElement> objVideoslist = Utilities.returnElements(driver,lstObject.get(68),lstObject.get(67));
							if(objVideoslist.size()>0)
							{
								String strVideoEpisodeDetails = objVideoslist.get(0).getText();
								objVideoslist.get(0).click();
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Show Video"+Extent_Reports.logActual+"Shows Video Link is clicked from Show page and the Show Episode details are  "+strVideoEpisodeDetails,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Click on Show Video"+Extent_Reports.logActual+"Shows Video Link is not clicked from Show page ",driver);
								driver.close();
							}
							
							//Click on Details button
							Thread.sleep(4000);
							System.out.println(driver.getCurrentUrl());
							System.out.println(driver.getTitle());
							Thread.sleep(4000);
							//objDetails = driver.findElement(By.cssSelector("a.video-meta__expand span"));
							objDetails = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							objDetails.click();
							Thread.sleep(4000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Details button"+Extent_Reports.logActual+"Details button is clicked ",driver);
							
							//Validate Details description
							//objDetailsDescription = driver.findElement(By.cssSelector("p.video-meta__description"));
							objDetailsDescription = Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
							String strDetailsDescription = objDetailsDescription.getText();
							System.out.println(strDetailsDescription);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Details Description should display"+Extent_Reports.logActual+"Details Description is displayed",driver);
							
							//Validate Details available status
							//objDetailsExpires = driver.findElement(By.cssSelector("div.video-meta__expires"));
							objDetailsExpires = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
							String strDetailExpires = objDetailsExpires.getText();
							System.out.println(strDetailExpires);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Details Available until should display"+Extent_Reports.logActual+"Details Available until is displayed and the details are :"+strDetailExpires,driver);
							
							//Validate Appearing section in the meta data
							String strAppearingList = null;
							//List<WebElement> objAppearing = driver.findElements(By.cssSelector("div.video-meta__appearing span"));
							List<WebElement> objAppearing = Utilities.returnElements(driver,lstObject.get(80),lstObject.get(79));
							int iAppearingsize = objAppearing.size();
							System.out.println(iAppearingsize);
							for(int iAppVal=0;iAppVal<iAppearingsize;iAppVal++)
							{
								
								String strAppearingText = objAppearing.get(iAppVal).getText();
								System.out.println(strAppearingText);
								strAppearingList = strAppearingText+";"+strAppearingList;
								System.out.println(strAppearingList);
								String strFinalAppearingList = strAppearingList.substring(0, strAppearingList.length()-4);
								System.out.println(strFinalAppearingList);
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Details Appearing Section should display"+Extent_Reports.logActual+"Details Appearing Section is displayed and the details are :"+strFinalAppearingList,driver);
								
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
				
//======================================================================== Verify whether Metadata -"E"  is removed when  clip does not have an episode associated=================================================
				@Test
				  public PGShowVideoDetailPage VerifyMetadataENoEpisodeClip_3578  ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						   
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(0);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(5)))
								{
									objShowList.get(ilinksIterator).click();
									driver.navigate().refresh();
									Thread.sleep(8000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							Thread.sleep(4000);
							String strlowerCaseText =lstTestData.get(5).toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							Thread.sleep(4000);
							
							//Select Web Exclusive option from Clips list box
							objClipDropDown = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							objClipDropDown.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Clip Drop Down"+Extent_Reports.logActual+"Clip Drop Down is clicked",driver);
							
							List<WebElement> objClipOptionList = Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85));
							objClipOptionList.get(2).click();
							Thread.sleep(12000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Web Exclusive option should be selected"+Extent_Reports.logActual+"Web Exclusive option is selected",driver);
							
							//Click on any Video
							//List<WebElement> objVideoslist = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a"));
							//List<WebElement> objEClipList = Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
							//objEClipList.get(1).click();
							List<WebElement> objVideolist = Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
							List<WebElement> objClipslinks = objVideolist.get(1).findElements(By.tagName("a"));
							int iclipsCount = objClipslinks.size();
							System.out.println(iclipsCount);
							objClipslinks.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Clip"+Extent_Reports.logActual+"Clip is clicked",driver);
							
							//Click on Details button
							Thread.sleep(4000);
							System.out.println(driver.getCurrentUrl());
							System.out.println(driver.getTitle());
							Thread.sleep(12000);
							//objDetails = driver.findElement(By.cssSelector("a.video-meta__expand span"));
							objDetails = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							objDetails.click();
							Thread.sleep(4000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Details button"+Extent_Reports.logActual+"Details button is clicked ",driver);
							
							//Get Details Info
							//objDetailsDescription = driver.findElement(By.cssSelector("p.video-meta__description"));
							List<WebElement> objDetailsInfo = Utilities.returnElements(driver,lstObject.get(83),lstObject.get(82));
							String strDetailsInfo = objDetailsInfo.get(0).getText();
							System.out.println(strDetailsInfo);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Details Info should not display"+Extent_Reports.logActual+"Details Info is displayed and the info details are "+strDetailsInfo,driver);
							
							//Validate if E is removed or not
							if(strDetailsInfo.contains("E"))
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Meta Data Info has Episode Info"+Extent_Reports.logActual+"Meta Data has Episode Info and the info is "+strDetailsInfo,driver);
							}
							else
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta Data Info should not have Episode Info"+Extent_Reports.logActual+"Meta Data has no Episode Info and the info is "+strDetailsInfo,driver);
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
//========================================================================Verify Whether Copyright information for the show is provided just above the social icons in the expanded metadata section=================================================
				@Test
				  public PGShowVideoDetailPage VerifyMetaDataCopyrightInfoDisplay_3577  ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(0);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(5)))
								{
									objShowList.get(ilinksIterator).click();
									driver.navigate().refresh();
									Thread.sleep(6000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							Thread.sleep(4000);
							String strlowerCaseText =lstTestData.get(5).toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							Thread.sleep(4000);
							
							//Select Web Exclusive option from Clips list box
							objClipDropDown = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
							objClipDropDown.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Clip Drop Down"+Extent_Reports.logActual+"Clip Drop Down is clicked",driver);
							
							List<WebElement> objClipOptionList = Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85));
							objClipOptionList.get(2).click();
							Thread.sleep(12000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Web Exclusive option should be selected"+Extent_Reports.logActual+"Web Exclusive option is selected",driver);
							
							//Click on any Video
							//List<WebElement> objVideoslist = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) a"));
							//List<WebElement> objEClipList = Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
							//objEClipList.get(1).click();
							List<WebElement> objVideolist = Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
							List<WebElement> objClipslinks = objVideolist.get(1).findElements(By.tagName("a"));
							int iclipsCount = objClipslinks.size();
							System.out.println(iclipsCount);
							objClipslinks.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Clip"+Extent_Reports.logActual+"Clip is clicked",driver);
							
							//Click on Details button
							Thread.sleep(4000);
							System.out.println(driver.getCurrentUrl());
							System.out.println(driver.getTitle());
							Thread.sleep(12000);
							//objDetails = driver.findElement(By.cssSelector("a.video-meta__expand span"));
							objDetails = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
							objDetails.click();
							Thread.sleep(4000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Details button"+Extent_Reports.logActual+"Details button is clicked ",driver);
							
							//Get copyrights Info
							objCopyRightsInfo = Utilities.returnElement(driver,lstObject.get(92),lstObject.get(91));
							String strDetailsCopyRightsInfo = objCopyRightsInfo.getText();
							System.out.println(strDetailsCopyRightsInfo);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"CopyRights Details Info should display"+Extent_Reports.logActual+"CopyRights Details Info should display and the text is  "+strDetailsCopyRightsInfo,driver);
							
							//Validate social icons
							objShare = Utilities.returnElement(driver,lstObject.get(95),lstObject.get(94));
							int iSocialIcons = objShare.findElements(By.tagName("a")).size();
							if(iSocialIcons > 0 )
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Social Icons should display"+Extent_Reports.logActual+"Social Icons are displaying",driver);
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
	
//========================================================================Verify order of Seasons in Episode drop down menu of Classic Show Video details page in Responsive Web Site=================================================
				@Test
				  public PGShowVideoDetailPage VerifySeasonsSortingforClassicVideos_3105 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							objShowList = Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Thread.sleep(25000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText,driver);
							
							WebDriverWait wait= new WebDriverWait(driver,60);
							//Thread.sleep(8000);
							//wait.until(ExpectedConditions.urlContains("https://www.nbc.com/shows/current"));
							
							WebElement objthrowbackShowsSub = Utilities.returnElements(driver,lstObject.get(98),lstObject.get(97)).get(3);
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
							
							//Click on any Video
							List<WebElement> objAllShowVideoList = Utilities.returnElements(driver,lstObject.get(101),lstObject.get(100));
							List <WebElement> objThrowBackVideoList = objAllShowVideoList.get(3).findElements(By.tagName("a"));
							System.out.println(objThrowBackVideoList.size());
							objThrowBackVideoList.get(30).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"ThrowBack Video  should be clickable"+ Extent_Reports.logActual+"Throwback Video is clicked",driver);
							
							Thread.sleep(6000);
							List <WebElement>  objFilter = Utilities.returnElements(driver,lstObject.get(62),lstObject.get(61));
							objFilter.get(0).click();
							Thread.sleep(4000);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Seasons List box"+Extent_Reports.logActual+"Seasons List box is clicked",driver);
							
							//List <WebElement>  objFilterlink = driver.findElements(By.cssSelector("div.show-page__modules section:nth-child(1) ul li.filter-select__item"));
							List <WebElement>  objFilterlink = Utilities.returnElements(driver,lstObject.get(65),lstObject.get(64));
							String CompVal = null;
							int mcount = 0;
							int mscount = 0;
							int iListOptionsct = objFilterlink.size();
							System.out.println(objFilterlink.size()); 
							for (int itrCount=0;itrCount<iListOptionsct;itrCount++)
						    {
								String strListItem = objFilterlink.get(itrCount).getText();
								System.out.println(objFilterlink.get(itrCount).getText());
								CompVal = CompVal+";"+strListItem;
								System.out.println(CompVal);
						    }
							String[] arrCompVals = CompVal.split(";");
							System.out.println(arrCompVals.length);
							for(int ioptionsList=1;ioptionsList<arrCompVals.length-1;ioptionsList++ )
							{
								System.out.println(arrCompVals[ioptionsList]);
								if(arrCompVals[ioptionsList].compareTo(arrCompVals[ioptionsList+1])<0)
								{
									mcount = mcount+1;
									
								}
								else
								{
									mscount = mscount+1;
								}
							}
							if(mcount==iListOptionsct-1)
							{
								System.out.println("sorted");
								System.out.println(mcount);
								System.out.println(iListOptionsct);
								String finalCompVal = CompVal.substring(6, CompVal.length());
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Video list Season options should be sorted from old season to latest"+Extent_Reports.logActual+"Video list Season options should be sorted from old season to latest and the options are  "+finalCompVal,driver);
							}
							else
							{
								String finalCompVal = CompVal.substring(6, CompVal.length());
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Video list Season options should be sorted from old season to latest"+Extent_Reports.logActual+"Video list Season options should be sorted from old season to latest and the options are  "+finalCompVal,driver);
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
				
//========================================================================Verify the display of Shows  in alphabetical order column wise under Responsive Navigation Bar=================================================
				@Test
				  public PGShowVideoDetailPage VerifyDisplayofShowsinAlphabeticalOrder_3579 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							
							/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(0);
							String ShowlistText = objShowList.getText();
							System.out.println(ShowlistText);
							objShowList.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+ShowlistText);
							*/
							
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals(lstTestData.get(5)))
								{
									objShowList.get(ilinksIterator).click();
									Thread.sleep(8000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							WebDriverWait wait= new WebDriverWait(driver,60);
							Thread.sleep(4000);
							String strlowerCaseText =lstTestData.get(5).toLowerCase();
							String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
							System.out.println(strReplaceSpaceText);
							wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));
							Thread.sleep(4000);
							
							List<WebElement> objShowListMenu = Utilities.returnElements(driver,lstObject.get(104),lstObject.get(103));
							objShowListMenu.get(1).click();
							List<WebElement> objShowListsItems = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowListss = objShowListsItems.get(0).findElements(By.tagName("li"));
							int iShowlist = objShowListss.size();
							//String ShowlistText = objShowList.getText();
							System.out.println(objShowListss.size());
							String CompVal = null;
							String CompVals = null;
							for(int iShowListIterator=0;iShowListIterator<iShowlist-1;iShowListIterator++)
							{
								String strShowlistValues = objShowListss.get(iShowListIterator).findElement(By.tagName("a")).getText();
								if(strShowlistValues.contains("The "))
								{
									String strShowTheListValue = strShowlistValues.substring(4);
									strShowlistValues = strShowTheListValue;
								}
								else if(strShowlistValues.contains("A"))
								{
									String strShowAListValue = strShowlistValues.substring(2);
									strShowlistValues = strShowAListValue;
								}
								/*else if(strShowlistValues.contains("TODAY"))
								{
									strShowlistValues = strShowlistValues;
								}*/
								System.out.println(strShowlistValues);
								CompVals = CompVals+";"+ strShowlistValues;
								CompVal = CompVal+";"+ strShowlistValues;
								System.out.println(CompVal);
								
							}
							
							int mcount = 0;
							int mscount = 0;

							String[] arrCompVals = CompVal.split(";");
							System.out.println(arrCompVals.length);
							for(int ioptionsList=1;ioptionsList<arrCompVals.length-2;ioptionsList++ )
							{
								System.out.println(arrCompVals[ioptionsList]);
								if(arrCompVals[ioptionsList].compareTo(arrCompVals[ioptionsList+1])<0)
								{
									mcount = mcount+1;
									
								}
								else
								{
									mscount = mscount+1;
									System.out.println(mscount);
									System.out.println(arrCompVals[ioptionsList]);
									System.out.println(arrCompVals[ioptionsList+1]);
									
								}
							}
							//Exception .....need to fix this issue Law&Order and Today 
							if(mcount==iShowlist-5)
							{
								System.out.println("sorted");
								System.out.println(mcount);
								System.out.println(iShowlist);
								String finalCompVal = CompVals.substring(6, CompVals.length());
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show list should be sorted in alphabatetical order"+Extent_Reports.logActual+"Show list are sorted in alphabatetical order and the Shows are  "+finalCompVal,driver);
							}
							else
							{
								System.out.println(mcount);
								System.out.println(mscount);
								String finalCompVal = CompVals.substring(6, CompVals.length());
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Show list should be sorted in alphabatetical order"+Extent_Reports.logActual+"Show list are not sorted in alphabatetical order and the Shows are   "+finalCompVal,driver);
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
				
//========================================================================Desktop -New Responsive Web Site - Show Video Details Page - Authentication - Verify Video Thumbnails and Authentication Key=================================================
				@Test
				  public PGShowVideoDetailPage VerifyAuthKeyIcon_1920 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
							//WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals("This Is Us"))
								{
									objShowList.get(ilinksIterator).click();
									driver.navigate().refresh();
									Thread.sleep(6000);
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
									break;
								}
							
							}
							//String ShowlistText = objShowList.getText();
							//System.out.println(ShowlistText);
							//objShowList.click();
							
							
							WebDriverWait wait= new WebDriverWait(driver,60);
							
							//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
							Thread.sleep(4000);
							//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
							
							List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
						
							objloadbutton.get(0).click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked",driver);
							////objloadbutton.click();
							Thread.sleep(24000);  
							
							List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19));
							wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
							
							Thread.sleep(8000);
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
							System.out.println(driver.getCurrentUrl());
							List <WebElement> objTVProvider = Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
							wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
							objTVProvider.get(1).click();	
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked",driver);
							Thread.sleep(6000);
							
							objOptinium = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
							wait.until(ExpectedConditions.visibilityOf(objOptinium));
							driver.navigate().refresh();
							objTVProvider.get(1).click();	
							//String ParentWindow = driver.getWindowHandle();
							//Set<String> s1=driver.getWindowHandles();
							
						
							objOptinium.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Optimum should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked",driver);
							Thread.sleep(6000);
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							Thread.sleep(4000);
							driver.navigate().refresh();
							Thread.sleep(6000);
							objUserName = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
							wait.until(ExpectedConditions.visibilityOf(objUserName));
							objUserName.sendKeys("research1000");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered",driver);
							
							objPassword = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
							objPassword.sendKeys("support1000");
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered",driver);
							
							objSignIn = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
							objSignIn.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"SignIn should be Clicked"+Extent_Reports.logActual+"SignIn is Clicked",driver);
							Thread.sleep(60000);
							
							System.out.println(driver.getCurrentUrl());
							
							List<WebElement> objOptniumLogo = Utilities.returnElements(driver,lstObject.get(113),lstObject.get(112));
							//wait.until(ExpectedConditions.visibilityOf(objOptniumLogo));
							String Optinumlogotext = objOptniumLogo.get(1).getAttribute("alt");
							
							
							if(Optinumlogotext.contentEquals("Optimum"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is not displayed",driver);
							}
							if(Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).isEmpty())
							
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should not be displayed "+Extent_Reports.logActual+"Auth code required video should not be displayed ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Auth code required video should not be displayed "+Extent_Reports.logActual+"Auth code required video is displayed ",driver);
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
				
//======================================================================== Verify User-friendly AuthZ fail messages when authenticated in Show video details page of New responsive Website=================================================
				@Test
				  public PGShowVideoDetailPage VerifyUserFriendlyFailMessagesAuthKey_1920 ( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(0));
							 
						     try
						     {
						     Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull");
						     screenshotExtension=Extent_Reports.getScreenshot(driver);
						     }
						     catch(Exception exc)
							 {
								 System.out.println(exc.getMessage());
							 }
							
						//Reading Objects
						try
						 {
							WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
							objShowLink.click();
							
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation");
							//WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
							List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
							List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
							int ilinksMenuCount = objShowList.size();
							for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
							{
								String strMenuLinkName = objShowList.get(ilinksIterator).getText();
								if(strMenuLinkName.contentEquals("This Is Us"))
								{
									objShowList.get(ilinksIterator).click();
									Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName);
									break;
								}
							
							}
							//String ShowlistText = objShowList.getText();
							//System.out.println(ShowlistText);
							//objShowList.click();
							
							
							WebDriverWait wait= new WebDriverWait(driver,60);
							
							//List <WebElement> objloadbutton = driver.findElements(By.cssSelector("div.load-button.full-width"));
							Thread.sleep(4000);
							//WebElement objloadbutton = driver.findElement(By.xpath("//div[@class='load-button full-width'][1]"));
							
							List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16));
						
							objloadbutton.get(0).click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Load Button should be clicked"+Extent_Reports.logActual+"Load Button is clicked");
							////objloadbutton.click();
							Thread.sleep(12000);  
							
							List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19));
							wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
							
							Thread.sleep(8000);
							System.out.println(objauthcode.size());
							if(objauthcode.size()>0)
							{
								
								objauthcode.get(0).click();
								Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked");
								
							}
							else
							{
								Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video");
								//driver.close();
							}
							Thread.sleep(12000);
							System.out.println(driver.getCurrentUrl());
							List <WebElement> objTVProvider = Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
							wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
							objTVProvider.get(1).click();	
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked");
							Thread.sleep(8000);
							
							objOptinium = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
							wait.until(ExpectedConditions.visibilityOf(objOptinium));
							//String ParentWindow = driver.getWindowHandle();
							//Set<String> s1=driver.getWindowHandles();
							
						
							objOptinium.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Optimum should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked");
							Thread.sleep(4000);
							String ParentWindow = driver.getWindowHandle();
							Set<String> s1=driver.getWindowHandles();
							Iterator<String> nWindow= s1.iterator();
							while(nWindow.hasNext()){
								String childWindow = nWindow.next();
								driver.switchTo().window(childWindow);
							}
							Thread.sleep(4000);
							objUserName = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
							wait.until(ExpectedConditions.visibilityOf(objUserName));
							objUserName.sendKeys("research1000");
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
							
							objPassword = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
							objPassword.sendKeys("support1000");
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
							
							objSignIn = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
							objSignIn.click();
							driver.switchTo().window(ParentWindow);
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"SignIn should be Clicked"+Extent_Reports.logActual+"SignIn is Clicked");
							
							
							Thread.sleep(12000);
							
							System.out.println(driver.getCurrentUrl());
							
							Thread.sleep(80000);
							List<WebElement> objOptniumLogo = Utilities.returnElements(driver,lstObject.get(113),lstObject.get(112));
							//wait.until(ExpectedConditions.visibilityOf(objOptniumLogo));
							String Optinumlogotext = objOptniumLogo.get(1).getAttribute("alt");
							if(Optinumlogotext.contentEquals("Optimum"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Optimum logo should be displayed"+Extent_Reports.logActual+"Optimum logo is not displayed",driver);
							}
							
							if(objauthcode.isEmpty())
							{
								Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Auth code required video should not be displayed "+Extent_Reports.logActual+"Auth code required video should not be displayed ");
							}
							else
							{
								Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected+"Auth code required video should not be displayed "+Extent_Reports.logActual+"Auth code required video is displayed ");
							}
							
							
							
						 }
						 catch(Exception exc)
						 {
							 System.out.println(exc.getMessage());
						 }
						
						//driver.close(); 
						
						return null;
					} 							
				
//=======================================================================		

@Test
public PGShowVideoDetailPage verifyPreRollAdvideo( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(3)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(3).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
		Thread.sleep(4000);
		WebElement Image = driver.findElement(By.cssSelector("div.show-header__title span"));
		System.out.print(Image.getText());
		WebElement objvideoclick = Utilities.returnElement(driver,lstObject.get(119),lstObject.get(118));
		wait.until(ExpectedConditions.visibilityOf(objvideoclick));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Video"+Extent_Reports.logActual+"Video is clicked from Episodes list",driver);
		objvideoclick.click();
		Thread.sleep(60000);
		driver.switchTo().frame("player");
		WebElement objPreroll = Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
        wait.until(ExpectedConditions.visibilityOf(objPreroll));
		//Thread.sleep(4000);
			if (objPreroll.isDisplayed())
		{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"PreRoll Ad should be Played"+Extent_Reports.logActual+"Pre Roll Ad is Played",driver);
			driver.close();
			System.out.print("Result printed");
		}
		 else
		 {
  				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"PreRoll Ad should be Played"+Extent_Reports.logActual+"Pre Roll Ad is not Played",driver);
		 driver.close();
    	}
	 }
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
	//driver.close(); 
	
	return null;
} 							

//===========================================================================
@Test
public PGShowVideoDetailPage VerifyBodyAd_NonPlayer_NBCRESP_1406( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(6)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(6).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
           List<WebElement> objSubMenuItems = Utilities.returnElements(driver,lstObject.get(125),lstObject.get(124));
           System.out.println(objSubMenuItems.size());               
           objSubMenuItems.get(3).click();
           
			Thread.sleep(20000);

           WebElement objSeasonclk = Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
           objSeasonclk.click();
           WebElement objSeason1clk = Utilities.returnElement(driver,lstObject.get(131),lstObject.get(130));
           objSeason1clk.click();
           List<WebElement> objSubMenuItems2 = Utilities.returnElements(driver,lstObject.get(134),lstObject.get(133));
           System.out.println(objSubMenuItems2.size());               
           objSubMenuItems2.get(1).click();
		WebElement objNXPBodyadd = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
		wait.until(ExpectedConditions.visibilityOf(objNXPBodyadd));
			if (objNXPBodyadd.isDisplayed())
		{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Body Ad should be displayed"+Extent_Reports.logActual+"Body Ad is displayed",driver);
			driver.close();
			System.out.print("Result printed");
		}
		 else
		 {
  				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Body Ad should be displayed"+Extent_Reports.logActual+"Body Ad is not displayed",driver);
		 driver.close();
    	}
	 }
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
	//driver.close(); 
	
	return null;
} 							


//=================================================================================
@Test
public PGShowVideoDetailPage verifyTwittertagvideo_NBCRESP_2003( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(3)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(3).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
		Thread.sleep(4000);
		WebElement objvideoclick = Utilities.returnElement(driver,lstObject.get(119),lstObject.get(118));
		wait.until(ExpectedConditions.visibilityOf(objvideoclick));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Video"+Extent_Reports.logActual+"Video is clicked from Episodes list",driver);
		objvideoclick.click();

		try
		 {
			objTwitterCard =Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			objTwitterSite=Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			objTwitterSiteId=Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
			objTwitterTitle=Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
			objTwitterDescription=Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151));
			objTwitterImage=Utilities.returnElement(driver,lstObject.get(155),lstObject.get(154));
			
		/**twitter:card*/
			
			if (lstTestData.get(8).equalsIgnoreCase(objTwitterCard.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + lstObject.get(0) +"':"+lstTestData.get(8) +Extent_Reports.logActual +lstObject.get(0) +"':"+objTwitterCard.getAttribute("content"),driver);
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(0) +"':"+lstTestData.get(8) +Extent_Reports.logActual +lstObject.get(0) +"':"+objTwitterCard.getAttribute("content"), driver);

			}
			
		/**twitter:site*/	
			if (lstTestData.get(9).equalsIgnoreCase(objTwitterSite.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +lstObject.get(3) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(3) +"':"+objTwitterSite.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(3) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(3) +"':"+objTwitterSite.getAttribute("content"), driver);

			}
			
		/**twitter:site:id*/
			if (lstTestData.get(10).equalsIgnoreCase(objTwitterSiteId.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(6) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(6) +"':"+objTwitterSiteId.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(6) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(6) +"':"+objTwitterSiteId.getAttribute("content"), driver);

			}
			
		/** twitter:title */
			if (lstTestData.get(11).equalsIgnoreCase(objTwitterTitle.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(9) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(9) +"':"+objTwitterTitle.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(9) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(9) +"':"+objTwitterTitle.getAttribute("content"), driver);

			}
			/**twitter:description*/
			if (objTwitterDescription.getAttribute("content").length() > 0)
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(12) +"':Not Null"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(12) +"':"+objTwitterDescription.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(12) +"':Not Null"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(12) +"':"+objTwitterDescription.getAttribute("content"), driver);

			}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
		 }
		
		driver.close(); 
		
		return null;
	}
			
	catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
driver.close();
return null;
}
//====================================================================

@Test
public PGShowVideoDetailPage verifyTwittertagclip_NBCRESP_2003( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(3)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(3).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
		Thread.sleep(4000);
		List<WebElement> objclipclick = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(157));
		wait.until(ExpectedConditions.visibilityOfAllElements(objclipclick));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any clip"+Extent_Reports.logActual+"clip is clicked from clips list",driver);
		objclipclick.get(0).click();

		try
		 {
			objTwitterCard =Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			objTwitterSite=Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			objTwitterSiteId=Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
			objTwitterTitle=Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
			objTwitterDescription=Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151));
			objTwitterImage=Utilities.returnElement(driver,lstObject.get(155),lstObject.get(154));
			
		/**twitter:card*/
			
			if (lstTestData.get(8).equalsIgnoreCase(objTwitterCard.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + lstObject.get(0) +"':"+lstTestData.get(8) +Extent_Reports.logActual +lstObject.get(0) +"':"+objTwitterCard.getAttribute("content"),driver);
			}	
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + lstObject.get(0) +"':"+lstTestData.get(8) +Extent_Reports.logActual +lstObject.get(0) +"':"+objTwitterCard.getAttribute("content"), driver);

			}
			
		/**twitter:site*/	
			if (lstTestData.get(9).equalsIgnoreCase(objTwitterSite.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +lstObject.get(3) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(3) +"':"+objTwitterSite.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+lstObject.get(3) +"':"+lstTestData.get(9) +Extent_Reports.logActual+lstObject.get(3) +"':"+objTwitterSite.getAttribute("content"), driver);

			}
			
		/**twitter:site:id*/
			if (lstTestData.get(10).equalsIgnoreCase(objTwitterSiteId.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(6) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(6) +"':"+objTwitterSiteId.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(6) +"':"+lstTestData.get(10) +Extent_Reports.logActual+lstObject.get(6) +"':"+objTwitterSiteId.getAttribute("content"), driver);

			}
			
		/** twitter:title */
			if (lstTestData.get(11).equalsIgnoreCase(objTwitterTitle.getAttribute("content")))
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(9) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(9) +"':"+objTwitterTitle.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(9) +"':"+lstTestData.get(11) +Extent_Reports.logActual+lstObject.get(9) +"':"+objTwitterTitle.getAttribute("content"), driver);

			}
			/**twitter:description*/
			if (objTwitterDescription.getAttribute("content").length() > 0)
			{
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected +lstObject.get(12) +"':Not Null"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(12) +"':"+objTwitterDescription.getAttribute("content"),driver);

			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +lstObject.get(12) +"':Not Null"+lstTestData.get(12) +Extent_Reports.logActual+lstObject.get(12) +"':"+objTwitterDescription.getAttribute("content"), driver);

			}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
		 }
		
		driver.close(); 
		
		return null;
	}
			
	catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
driver.close();
return null;
}


@Test
public PGShowVideoDetailPage verifyPreRollAdclip( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(3)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(3).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
		Thread.sleep(4000);
		WebElement Image = driver.findElement(By.cssSelector("div.show-header__title span"));
		System.out.print(Image.getText());
		List<WebElement> objclipclick = Utilities.returnElements(driver,lstObject.get(155),lstObject.get(157));
		wait.until(ExpectedConditions.visibilityOfAllElements(objclipclick));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any clip"+Extent_Reports.logActual+"clip is clicked from clips list",driver);
		objclipclick.get(0).click();
		Thread.sleep(60000);
		driver.switchTo().frame("player");
		WebElement objPreroll = Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
        wait.until(ExpectedConditions.visibilityOf(objPreroll));
		//Thread.sleep(4000);
			if (objPreroll.isDisplayed())
		{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"PreRoll Ad should be Played"+Extent_Reports.logActual+"Pre Roll Ad is Played",driver);
			driver.close();
			System.out.print("Result printed");
		}
		 else
		 {
  				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"PreRoll Ad should be Played"+Extent_Reports.logActual+"Pre Roll Ad is not Played",driver);
		 driver.close();
    	}
	 }
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
	//driver.close(); 

	return null;
}

//======================================================================
@Test
public PGShowVideoDetailPage Verifymetaforexpired_NBCRESP_1282( ) throws InterruptedException, FilloException 
{

	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
		 
	     try
	     {
	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Home Page should Launch"+Extent_Reports.logActual+"NBC Home page launched succesfull",driver);
	     screenshotExtension=Extent_Reports.getScreenshot(driver);
	     }
	     catch(Exception exc)
		 {
			 System.out.println(exc.getMessage());
		 }
		
	//Reading Objects
	try
	 {
		WebElement objShowLink = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(0);
		objShowLink.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation",driver);
		/*WebElement objShowList = Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4)).get(19);
		String ShowlistText = objShowList.getText();
		System.out.println(ShowlistText);
		objShowList.click();*/
		List<WebElement> objShowLists = Utilities.returnElements(driver,lstObject.get(107),lstObject.get(106));
		List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
		int ilinksMenuCount = objShowList.size();
		for(int ilinksIterator=0;ilinksIterator<ilinksMenuCount;ilinksIterator++)
		{
			String strMenuLinkName = objShowList.get(ilinksIterator).getText();
			if(strMenuLinkName.contentEquals(lstTestData.get(6)))
			{
				objShowList.get(ilinksIterator).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Shows"+Extent_Reports.logActual+"Shows Link is clicked from global navigation and the show is "+strMenuLinkName,driver);
				break;
			}
		
		}
		WebDriverWait wait= new WebDriverWait(driver,60);
		//Actions act = new Actions(driver);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on any Show"+Extent_Reports.logActual+"Show is clicked from Shows list and the show is "+lstTestData.get(3),driver);
		
		Thread.sleep(4000);
		String CompVal = null;
		int mcount = 0;
		int mscount = 0;
		String strlowerCaseText =lstTestData.get(6).toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		wait.until(ExpectedConditions.urlContains("https://www.nbc.com/"+strReplaceSpaceText));	
           List<WebElement> objSubMenuItems = Utilities.returnElements(driver,lstObject.get(125),lstObject.get(124));
           System.out.println(objSubMenuItems.size());               
           objSubMenuItems.get(3).click();
           
			Thread.sleep(20000);

           WebElement objSeasonclk = Utilities.returnElement(driver,lstObject.get(128),lstObject.get(127));
           objSeasonclk.click();
           WebElement objSeason1clk = Utilities.returnElement(driver,lstObject.get(131),lstObject.get(130));
           objSeason1clk.click();
           List<WebElement> objSubMenuItems2 = Utilities.returnElements(driver,lstObject.get(134),lstObject.get(133));
           System.out.println(objSubMenuItems2.size());               
           objSubMenuItems2.get(1).click();
	
	WebElement objmetaexp = Utilities.returnElement(driver,lstObject.get(161),lstObject.get(160));
	
	if (lstTestData.get(13).equalsIgnoreCase(objmetaexp.getAttribute("content")))
	
		System.out.println(objmetaexp.getAttribute("content"));      		
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Meta description and content should be displayed correctly"+Extent_Reports.logActual+"Meta description and content are displayed correctly",driver);
		System.out.print("Result printed");
 }
	
           catch(Exception exc)
  		 {
  			 System.out.println(exc.getMessage());
  		 }
  		
  	driver.close(); 
  	
  		return null;
	      }

				
		
}