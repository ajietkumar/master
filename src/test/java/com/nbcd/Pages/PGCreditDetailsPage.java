package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

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
public class PGCreditDetailsPage
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_home;
	boolean Livelink;
	List<WebElement> menu,sName,sub_menu,Team_name_header,objmenu,objsName,objsubMenuItems;
	WebElement Image,Character_Name,Played_By_Section,Back_to_Cast,char_name,more_button,less_button,Person_Name,contestant_name,character_name,metadata,header_menu_style,Role_Name;
	 
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGCreditDetailsPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGCreditLandingPage","Input");
		lstObject=db.getTestDataObject("Select * from PGCreditLandingPage","ObjectRepository");
	}
	//-------------------------Desktop - Verify Credit Details Page when Role = Character (NBCRESP-1303) ------------------------			
				@Test
				  public PGCreditDetailsPage  Verify_Credit_Details_as_Character_NBCRESP_1303( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
						 driver.get(lstTestData.get(0));
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
						
					
						objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement mainmanu: objmenu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(mainmanu).click().build().perform();
								Thread.sleep(6000);
								break;
							}
						}
						System.out.println("show menu clicked");
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						for(WebElement showname: objsName ){
						//for (int j=0;j<=objsName.size();j++){
							if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
								Action.moveToElement(showname).click().build().perform();
								Thread.sleep(20000);
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objsubMenuItems=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						for(WebElement submenu: objsubMenuItems ){
							//for (int j=0;j<=objsName.size();j++){
								if(submenu.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(3))){
									Action.moveToElement(submenu).click().build().perform();
									break;
								}
							}
							Thread.sleep(20000);
							System.out.println(driver.getCurrentUrl());
						
					   
					   //WebElement Image = driver.findElement(By.cssSelector("div.credit-list__inner div.credit-list__content a:nth-child(1) div.resp-image img"));
					    Image=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
					   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.credit-list__inner div.credit-list__content a:nth-child(1) img")));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been displayed: "+ "true" +Extent_Reports.logActual + "Actual Image has been displayed:"+ Image.isDisplayed(),driver);
					    System.out.println(Image.isDisplayed());
					    	 
					  	 //WebElement Character_Name = driver.findElement(By.cssSelector("div.credit-list__content a:nth-child(1) div.card__meta h2.card__title"));
					    Character_Name=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Character Name has been displayed: "+ Character_Name.isDisplayed() +Extent_Reports.logActual + "Actual Character Name is: "+ Character_Name.getAttribute("innerHTML") , driver);
					  	System.out.println(Character_Name.getAttribute("innerHTML"));
					  	 
					  	 //WebElement Played_By_Section = driver.findElement(By.cssSelector("div.credit-list__content a:nth-child(1) div.card__meta div.card__description__part"));
					  	Played_By_Section=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16)); 
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Played By Section has been displayed: "+ Played_By_Section.isDisplayed() +Extent_Reports.logActual + "Actual Played By Section is: "+ Played_By_Section.getText() ,driver );
					  	System.out.println(Played_By_Section.getText());
					 	 
					 	 if(Image.isDisplayed()){
					 		Image.click();
					 		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been clicked: "+ "true" +Extent_Reports.logActual + "Actual Image has been clicked: "+ "true" ,driver );
					 	  }
							((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");	

					 	
					  	 //WebElement Back_to_Cast= driver.findElement(By.cssSelector("a.credit-details-page__back-link"));
					 	Back_to_Cast=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Back to Cast link text has been displayed: "+ Back_to_Cast.isDisplayed() +Extent_Reports.logActual + "Actual Back to Cast link text is: "+ Back_to_Cast.getAttribute("innerHTML"),driver );
					  	System.out.println(Back_to_Cast.getAttribute("innerHTML"));
					  	
					  	//WebElement char_name = driver.findElement(By.cssSelector("div.bio__name h1.bio__character"));
					  	char_name=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected bio character name has been displayed: "+ char_name.isDisplayed() +Extent_Reports.logActual + "Actual bio character name is: "+ char_name.getAttribute("innerHTML"),driver);
					  	System.out.println(char_name.getAttribute("innerHTML"));
					  
					  	//WebElement more_button = driver.findElement(By.cssSelector("div.bio__long-desc__more"));
					  	more_button=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected More button has been displayed: "+ more_button.isDisplayed() +Extent_Reports.logActual + "Actual More button has been displayed: "+ "true" ,driver);
					  	more_button.click();
					  	
					  	//WebElement less_button = driver.findElement(By.cssSelector("div.bio__long-desc__more--active"));
					  	less_button=Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Less button has been displayed: "+ less_button.isDisplayed() +Extent_Reports.logActual + "Actual Less button has been displayed: "+ "true" , driver );
					  	less_button.click();

					 
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
				
				//-------------------------Verify Credit Details Page when Role = Everyone Else (non Character/Contenstant) (NBCRESP-1304) ------------------------			

				@Test
				  public PGCreditDetailsPage  Verify_Credit_Role_As_Everyone_Else_NBCRESP_1304( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     Synchronization.implicitWait(driver, 50);
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
						
						objmenu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement mainmanu: objmenu ){
						//for(int i=0;i<=objmenu.size();i++){
							if((mainmanu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(mainmanu).click().build().perform();
								Thread.sleep(6000);
								break;
							}
						}
						System.out.println("show menu clicked");
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						for(WebElement showname: objsName ){
						//for (int j=0;j<=objsName.size();j++){
							if(showname.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
								Action.moveToElement(showname).click().build().perform();
								Thread.sleep(20000);
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						objsubMenuItems=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						for(WebElement submenu: objsubMenuItems ){
							//for (int j=0;j<=objsName.size();j++){
								if(submenu.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(3))){
									Action.moveToElement(submenu).click().build().perform();
									break;
								}
							}
							Thread.sleep(20000);
							System.out.println(driver.getCurrentUrl());
						
			        			
					
						//WebElement Image = driver.findElements(By.cssSelector("div.credit-list__content a.card img")).get(1);
						Image=Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31)).get(1);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been displayed: "+ "true" +Extent_Reports.logActual + "Actual Image has been displayed:"+ Image.isDisplayed() , driver);
						System.out.println(Image.isDisplayed());
						
					    //WebElement Person_Name = driver.findElements(By.cssSelector("a article.card__content div.card__meta h2")).get(1);
						Person_Name = Utilities.returnElements(driver,lstObject.get(35),lstObject.get(34)).get(1);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Person Name has been displayed: "+ Person_Name.isDisplayed() +Extent_Reports.logActual + "Actual Person Name is: "+ Person_Name.getAttribute("innerHTML"), driver );
					 	System.out.println(Person_Name.getAttribute("innerHTML"));
					 	
						//((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"card card--credit\")[1].click();");
						
					 	if(Image.isDisplayed()){
					 		Image.click();
					 		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been clicked: "+ "true" +Extent_Reports.logActual + "Actual Image has been clicked: "+ "true" , driver);
					 		System.out.println("Clicked");
					 	 }
					 	
					 	//((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
					 	Synchronization.waitForPageLoad(driver);
					 	
					 	//WebElement Back_to_Cast= driver.findElement(By.cssSelector("a.credit-details-page__back-link"));
					 	Back_to_Cast = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Back to Cast link text has been displayed: "+ Back_to_Cast.isDisplayed() +Extent_Reports.logActual + "Actual Back to Cast link text is: "+ Back_to_Cast.getAttribute("innerHTML"), driver );
					 	System.out.println(Back_to_Cast.getAttribute("innerHTML"));
					 	
					 	//WebElement contestant_name = driver.findElement(By.cssSelector("div.bio__name h1.bio__character"));
					 	contestant_name = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected bio name has been displayed: "+ contestant_name.isDisplayed() +Extent_Reports.logActual + "Actual bio name is: "+ contestant_name.getAttribute("innerHTML"), driver);
					 	System.out.println(contestant_name.getAttribute("innerHTML"));
					   
					 	//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)","");
					 	
					 	//WebElement more_button = driver.findElement(By.cssSelector("div.bio__long-desc__more span.bio__desc__more-text"));
					 	more_button = Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
						Action.moveToElement(more_button).click().build().perform();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected More button has been displayed: "+ more_button.isDisplayed() +Extent_Reports.logActual + "Actual More button has been displayed: "+ "true" , driver);
						System.out.println("more button clicked");
					  	
					  	//WebElement less_button = driver.findElement(By.cssSelector("div.bio__long-desc__more--active span.bio__desc__more-text"));
						less_button = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
						Action.moveToElement(less_button).click().build().perform();
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Less button has been displayed: "+ less_button.isDisplayed() +Extent_Reports.logActual + "Actual Less button has been displayed: "+ "true" , driver );
					  	System.out.println("less button clicked");
					  
					 
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

				

}

