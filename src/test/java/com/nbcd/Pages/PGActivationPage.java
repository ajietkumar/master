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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class PGActivationPage {

	private static final String VerifyAppsLandingPage = null;
		//=========================================Variables=================================================================================
		
		private  WebDriver driver;
		String sql;
		protected static String showDetails;
		DatabaseFunction db = new DatabaseFunction();
		public List<String> lstObject,lstTestData;
		static String screenshotExtension;
		String sqlQry,Status,strResultText;
		WebElement objAppLink,objActivateLink,objEnterCode,objContinue,objConDis,objErrMsg,objVal,objGenerateCode;
		WebElement objMvpdActLogo,objMvpdActBack,objMvpdActFooter,objUserName,objPassword,objSignin,objSucessCheckMarck;
		
		
	//=================================================================================================================================================================================	
	//Constructor to initialize all the Page Objects
		public PGActivationPage(WebDriver driver) throws MalformedURLException 
		//public PGActivationPage(String Browser) 
		{      
			try 
				{
					this.driver = driver;
					//this.driver = GetWebDriverInstance.getBrowser(Browser);
					lstTestData=db.getTestDataObject("Select * from ActivationPage","Input");
					lstObject=db.getTestDataObject("Select * from ActivationPage","ObjectRepository");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						
						
			}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGActivationPage VerifyInvalidAndValidData_2598( ) throws InterruptedException, FilloException 
		  {
			
				//Launching Browser with valid URL.
				     driver.get(lstTestData.get(8));
					   //driver.get("https://www.nbc.com/apps");
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
					
					/**driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					WebElement objAppLink =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(6);
					objAppLink.click();
					Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Apps Landing Page should display"+ Extent_Reports.logActual+"Apps Landing page is dispalyed after App link is clicked from global navigation");
					screenshotExtension=Extent_Reports.getScreenshot(driver);
					*/
					List <WebElement> objActivateLink =Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
					int objActivateLinkct = objActivateLink.size();
					System.out.println(objActivateLinkct);
					//for(int i=0;i<objActivateLinkct;i++)
					//{
						String StrlinkType = objActivateLink.get(2).getText();
						System.out.println(StrlinkType);
						//if(StrlinkType.contentEquals("ACTIVATE"))
						//{
							objActivateLink.get(2).click();
							
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							objEnterCode = Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
							if(objEnterCode.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is not displayed",driver);
							}
							
							String strDefaulttxt = objEnterCode.getAttribute("placeholder");
							System.out.println(objEnterCode.getAttribute("placeholder"));
							if(strDefaulttxt.contentEquals("Enter your activation code"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is displaying as "+strDefaulttxt,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is not displaying as "+strDefaulttxt,driver);
							}
							objEnterCode.sendKeys("1234567");
							objContinue = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objContinue.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is displayed ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is not displayed ",driver);
							}
							//Validate if less than 7 characters
							objEnterCode.clear();
							objEnterCode.sendKeys("123456");
							objConDis = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
							System.out.println("lokiyht");
							if(objConDis.isEnabled())
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should disabled"+ Extent_Reports.logActual+"Continue Button is enabled if less than 7 characters",driver);
							}
							else
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should disabled"+ Extent_Reports.logActual+"Continue Button is disabled if less than 7 characters",driver);
							}
							
							objEnterCode.clear();
							//Validate if there 7 characters
							objEnterCode.sendKeys("1234567");
							if(objContinue.isEnabled())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should enabled"+ Extent_Reports.logActual+"Continue Button is enabled if 7 characters ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should enabled"+ Extent_Reports.logActual+"Continue Button is disabled if 7 characters",driver);
							}
							
							
							//Validate if again less than 7 characters previous 
							objEnterCode.sendKeys(Keys.BACK_SPACE);
							if(objConDis.isEnabled())	
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should disabled"+ Extent_Reports.logActual+"Continue Button is enabled if less than 7 characters",driver);
							}
							else
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should disabled"+ Extent_Reports.logActual+"Continue Button is disabled if less than 7 characters",driver);
							}
							
							 
							// driver.navigate().to("https://www.nbc.com/apps");
							
							 
							 
							 
						//}
					//}
					
					
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
		  public PGActivationPage VerifyErrorMessageInvalidcode_2613( ) throws InterruptedException, FilloException 
		  {
			
				//Launching Browser with valid URL.
				     driver.get(lstTestData.get(8));
					  // driver.get("https://www.nbc.com/apps");
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
					
					/**driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					WebElement objAppLink =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(6);
					objAppLink.click();
					Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Apps Landing Page should display"+ Extent_Reports.logActual+"Apps Landing page is dispalyed after App link is clicked from global navigation");
					screenshotExtension=Extent_Reports.getScreenshot(driver);
					*/
					List <WebElement> objActivateLink =Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
					int objActivateLinkct = objActivateLink.size();
					System.out.println(objActivateLinkct);
					//for(int i=0;i<objActivateLinkct;i++)
					//{
						String StrlinkType = objActivateLink.get(2).getText();
						System.out.println(StrlinkType);
						//if(StrlinkType.contentEquals("ACTIVATE"))
						//{
							objActivateLink.get(2).click();
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							objEnterCode = Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
							if(objEnterCode.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is displayed",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is not displayed",driver);
							}
							
							String strDefaulttxt = objEnterCode.getAttribute("placeholder");
							System.out.println(objEnterCode.getAttribute("placeholder"));
							if(strDefaulttxt.contentEquals("Enter your activation code"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is displaying as "+strDefaulttxt,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is not displaying as "+strDefaulttxt,driver);
							}
							objEnterCode.sendKeys("1234567");
							objContinue = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
							if(objContinue.isDisplayed())
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is displayed ",driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is not displayed ",driver);
							}
							
							objContinue.click();
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should clicked"+ Extent_Reports.logActual+"Continue Button is clicked ",driver);
							driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
							objErrMsg = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
							String CompErrMsg = ("Your activation code has expired or is invalid. Please generate a new code from your device.");
							String txtErrorMessage = objErrMsg.getText();
							if(txtErrorMessage.contentEquals(CompErrMsg))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Error Message should display"+ Extent_Reports.logActual+"Error Message is displayed and the error message is  "+txtErrorMessage,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Error Message should display"+ Extent_Reports.logActual+"Error Message is not displayed as expected and the error message is  "+txtErrorMessage,driver);
							}
							
							String colErrorMsg = objErrMsg.getCssValue("color");
							System.out.println(colErrorMsg);
							String color_hex[];  
							color_hex = colErrorMsg.replace("rgba(", "").split(",");       
							String actual_hexErr = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
							System.out.println(actual_hexErr);
							if(actual_hexErr.equalsIgnoreCase("#c20009"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Error Message should display in red color"+ Extent_Reports.logActual+"Error Message is displayed and is in red color and the color code is "+actual_hexErr,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Error Message should display in red color"+ Extent_Reports.logActual+"Error Message is displayed and is not in red color ",driver);
							}
							String colCodeText = objEnterCode.getCssValue("color");
							System.out.println(colCodeText);
							color_hex = colErrorMsg.replace("rgba(", "").split(",");       
							String actual_hexCode = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
							System.out.println(actual_hexCode);
							if(actual_hexErr.equalsIgnoreCase("#c20009"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should display in red color"+ Extent_Reports.logActual+"Enter code text box is displayed and is in red color and the color code is "+colCodeText,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Enter code text box should display in red color"+ Extent_Reports.logActual+"Enter code text box is displayed and is not in red color ",driver);
							}
							
						//}
					//}
					
					
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
				  public PGActivationPage VerifyGeneralLayout_2607( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(8));
							   //driver.get("https://www.nbc.com/apps");
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
							
							/**driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							WebElement objAppLink =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(6);
							objAppLink.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Apps Landing Page should display"+ Extent_Reports.logActual+"Apps Landing page is dispalyed after App link is clicked from global navigation");
							screenshotExtension=Extent_Reports.getScreenshot(driver);
							*/
							List <WebElement> objActivateLink =Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
							int objActivateLinkct = objActivateLink.size();
							System.out.println(objActivateLinkct);
							//for(int i=0;i<objActivateLinkct;i++)
							//{
								String StrlinkType = objActivateLink.get(2).getText();
								System.out.println(StrlinkType);
								//if(StrlinkType.contentEquals("ACTIVATE"))
								//{
									objActivateLink.get(2).click();
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									objEnterCode = Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
									if(objEnterCode.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is not displayed",driver);
									}
									
									String strDefaulttxt = objEnterCode.getAttribute("placeholder");
									System.out.println(objEnterCode.getAttribute("placeholder"));
									if(strDefaulttxt.contentEquals("Enter your activation code"))
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is displaying as "+strDefaulttxt,driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is not displaying as "+strDefaulttxt,driver);
									}
									
									driver.navigate().to("http://tvestaging-origin.nbcuni.com/device_activation_code.php");
									String ParentWindow = driver.getWindowHandle();
									Set<String> s1=driver.getWindowHandles();
									Iterator<String> nWindow= s1.iterator();
									while(nWindow.hasNext()){
										String childWindow = nWindow.next();
										driver.switchTo().window(childWindow);
									}
									Select objSelectEnv = new Select(Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(0));
									objSelectEnv.selectByIndex(1);
									Select objSelectBrand = new Select(Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(1));
									objSelectBrand.selectByIndex(7);
									objGenerateCode = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
									objGenerateCode.click();
									driver.getTitle();
									System.out.println(driver.getTitle());
									WebDriverWait wait= new WebDriverWait(driver,60);
									objVal = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
									wait.until(ExpectedConditions.visibilityOf(objVal));
									
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									//objVal = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
								
									String valCode = objVal.getAttribute("innerHTML");
									System.out.println(valCode);
									System.out.println("JHYTGRR");
									//driver.switchTo().window(ParentWindow);
									driver.navigate().to("https://www.nbc.com/activate");
									driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
									WebDriverWait waits = new WebDriverWait(driver, 20);
									WebElement objEnterCode = waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
									
									
									objEnterCode.sendKeys(valCode);
									System.out.println("lkjumngffdeedd");
									objContinue = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
									if(objContinue.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is displayed ",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is not displayed ",driver);
									}
									
									objContinue.click();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should clicked"+ Extent_Reports.logActual+"Continue Button is clicked ",driver);
									driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
									String strTitle = driver.getTitle();
									System.out.println(strTitle);
									objMvpdActLogo =  Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
									if(objMvpdActLogo.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"NBC Logo should display"+ Extent_Reports.logActual+"NBC Logo is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"NBC Logo should display"+ Extent_Reports.logActual+"NBC Logo is not displayed",driver);
									}
									WebElement objMvpdActtitle =  Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31)).get(1);
									if(objMvpdActtitle.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Title should display"+ Extent_Reports.logActual+"Title is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"NBC Logo should display"+ Extent_Reports.logActual+"NBC Logo is not displayed",driver);
									}
									objMvpdActBack =  Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
									if(objMvpdActBack.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Back link should display"+ Extent_Reports.logActual+"Back link is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Back link should display"+ Extent_Reports.logActual+"Back link is not displayed",driver);
									}
									WebElement objMvpdActfaq =  Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37)).get(1);
									if(objMvpdActfaq.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Need Help linking?See our FAQ. should display"+ Extent_Reports.logActual+"Need Help linking?See our FAQ. is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Need Help linking?See our FAQ. should display"+ Extent_Reports.logActual+"Need Help linking?See our FAQ. is not displayed",driver);
									}
									objMvpdActFooter =  Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
									if(objMvpdActFooter.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Back link should display"+ Extent_Reports.logActual+"Back link is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Back link should display"+ Extent_Reports.logActual+"Back link is not displayed",driver);
									}
									
									
									
								//}
							//}
							
							
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
				  public PGActivationPage VerifyURLPathingRoutingactivation_2803( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						   	 driver.get(lstTestData.get(0));
							//driver.get("https://www.nbc.com/apps");
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
							
							//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							driver.navigate().to(lstTestData.get(2));
							Thread.sleep(6000);
							String appletvredirURL = driver.getCurrentUrl();
							if(appletvredirURL.contentEquals("https://www.nbc.com/activate"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"URL should get redirected for URL"+ lstTestData.get(2)+Extent_Reports.logActual+"URL is redirected and the url is"+appletvredirURL,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(2)+Extent_Reports.logActual+"URL is not redirected and the url is"+appletvredirURL,driver);
							}
							
							driver.navigate().to(lstTestData.get(3));
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							String amazonredirURL = driver.getCurrentUrl();
							if(amazonredirURL.contentEquals("https://www.nbc.com/activate"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"URL should get redirected for URL "+lstTestData.get(3)+Extent_Reports.logActual+"URL is redirected and the url is"+appletvredirURL,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(3)+Extent_Reports.logActual+"URL is not redirected and the url is"+appletvredirURL,driver);
							}
							
							driver.navigate().to(lstTestData.get(4));
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							String rokudirURL = driver.getCurrentUrl();
							if(rokudirURL.contentEquals("https://www.nbc.com/activate"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(4)+Extent_Reports.logActual+"URL is redirected and the url is"+appletvredirURL,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(4)+Extent_Reports.logActual+"URL is not redirected and the url is"+appletvredirURL,driver);
							}
							
							driver.navigate().to(lstTestData.get(5));
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							String xboneonedirURL = driver.getCurrentUrl();
							if(xboneonedirURL.contentEquals("https://www.nbc.com/activate"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(5)+Extent_Reports.logActual+"URL is redirected and the url is"+appletvredirURL,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(5)+Extent_Reports.logActual+"URL is not redirected and the url is"+appletvredirURL,driver);
							}
							
							driver.navigate().to(lstTestData.get(6));
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							String xboxoneURL = driver.getCurrentUrl();
							if(xboxoneURL.contentEquals("https://www.nbc.com/activate?redir=xbox360"))
							{
								Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(6)+Extent_Reports.logActual+"URL is redirected and the url is"+appletvredirURL,driver);
							}
							else
							{
								Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"URL should get redirected for URL"+lstTestData.get(6)+Extent_Reports.logActual+"URL is not redirected and the url is"+appletvredirURL,driver);
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
				  public PGActivationPage VerifySucessPage_2751( ) throws InterruptedException, FilloException 
				  {
					
						//Launching Browser with valid URL.
						     driver.get(lstTestData.get(8));
							   //driver.get("https://www.nbc.com/apps");
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
							
							/**driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							WebElement objAppLink =Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1)).get(6);
							objAppLink.click();
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Apps Landing Page should display"+ Extent_Reports.logActual+"Apps Landing page is dispalyed after App link is clicked from global navigation");
							screenshotExtension=Extent_Reports.getScreenshot(driver);
							*/
							List <WebElement> objActivateLink =Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
							int objActivateLinkct = objActivateLink.size();
							System.out.println(objActivateLinkct);
							//for(int i=0;i<objActivateLinkct;i++)
							//{
								String StrlinkType = objActivateLink.get(2).getText();
								System.out.println(StrlinkType);
								//if(StrlinkType.contentEquals("ACTIVATE"))
								//{
									objActivateLink.get(2).click();
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									objEnterCode = Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
									if(objEnterCode.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is displayed",driver);
									}
									else
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter code text box should be displayed"+ Extent_Reports.logActual+"Enter code text box is not displayed",driver);
									}
									
									String strDefaulttxt = objEnterCode.getAttribute("placeholder");
									System.out.println(objEnterCode.getAttribute("placeholder"));
									if(strDefaulttxt.contentEquals("Enter your activation code"))
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is displaying as "+strDefaulttxt,driver);
									}
									else
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Default Text should display"+ Extent_Reports.logActual+"Default text is not displaying as "+strDefaulttxt,driver);
									}
									
									driver.navigate().to("http://tvestaging-origin.nbcuni.com/device_activation_code.php");
									String ParentWindow = driver.getWindowHandle();
									Set<String> s1=driver.getWindowHandles();
									Iterator<String> nWindow= s1.iterator();
									while(nWindow.hasNext()){
										String childWindow = nWindow.next();
										driver.switchTo().window(childWindow);
									}
									Select objSelectEnv = new Select(Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(0));
									objSelectEnv.selectByIndex(1);
									Select objSelectBrand = new Select(Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19)).get(1));
									objSelectBrand.selectByIndex(7);
									objGenerateCode = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
									objGenerateCode.click();
									driver.getTitle();
									System.out.println(driver.getTitle());
									WebDriverWait wait= new WebDriverWait(driver,60);
									objVal = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
									wait.until(ExpectedConditions.visibilityOf(objVal));
									
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									//objVal = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
								
									String valCode = objVal.getAttribute("innerHTML");
									System.out.println(valCode);
									
									//driver.switchTo().window(ParentWindow);
									driver.navigate().to("https://www.nbc.com/activate");
									
									driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
									WebDriverWait waits = new WebDriverWait(driver, 20);
									WebElement objEnterCode = waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
									objEnterCode.sendKeys(valCode);
									
									objContinue = Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
									if(objContinue.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is displayed ",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Continue button should display"+ Extent_Reports.logActual+"Continue Button is not displayed ",driver);
									}
									
									objContinue.click();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Continue button should clicked"+ Extent_Reports.logActual+"Continue Button is clicked ",driver);
									driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
									String strTitle = driver.getTitle();
									System.out.println(strTitle);
									WebDriverWait waitss = new WebDriverWait(driver, 20);
									List <WebElement> objMVPDOptiums = driver.findElements(By.cssSelector("div.mvpd-provider__content img"));
									//WebElement objMVPDOptium = Utilities.returnElements(driver,lstObject.get(44),lstObject.get(43)).get(8);
									//List<WebElement> objMVPDOptiums = waitss.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.mvpd-provider__content img")));
									//List<WebElement> objMVPDOptiums = waitss.until(ExpectedConditions.visibilityOfAllElements(By.cssSelector("div.mvpd-provider__content img")));
									Thread.sleep(20000);
									waitss.until(ExpectedConditions.visibilityOfAllElements(objMVPDOptiums));		
									objMVPDOptiums.get(8).click();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Optimium image should be clicked"+ Extent_Reports.logActual+"Optimium image is clicked ",driver);
									driver.navigate().refresh();
									objUserName = Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
									objUserName.sendKeys("research1000");
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Login page should display and the UserName should be entered"+ Extent_Reports.logActual+"Login page is displayed and the UserName is  entered as research1000",driver);
									objPassword = Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
									objPassword.sendKeys("support1000");
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Password should be entered"+ Extent_Reports.logActual+"Password is  entered as support1000",driver);
									objSignin = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
									objSignin.click();
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on SignIn button"+ Extent_Reports.logActual+"SignIn button is clicked",driver);
									Thread.sleep(40000);
									objSucessCheckMarck = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
									if(objSucessCheckMarck.isDisplayed())
									{
										Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Check Marck should display on Success Page"+ Extent_Reports.logActual+"Check Marck is displayed on Sucess Page",driver);
									}
									else
									{
										Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Check Marck should display on Success Page"+ Extent_Reports.logActual+"Check Marck is not displayed on Sucess Page",driver);
									}
										
										
									
								//}
							//}
							
							
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

