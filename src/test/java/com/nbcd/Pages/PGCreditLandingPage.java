package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGCreditLandingPage
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_home,menu_Name,show_Name,Character_submenu_Name,Contestant_show_Name,Contestant_submenu_Name,Coach_show_Name,Coach_submenu_Name,title;
	boolean Livelink;
	List<WebElement> menu,sName,sub_menu,Team_name_header;
	WebElement Image,Character_Name,Played_By_Section,Back_to_Cast,char_name,more_button,less_button,Person_Name,contestant_name,character_name,metadata,header_menu_style,Role_Name;
	 
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGCreditLandingPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGCreditLandingPage","Input");
		lstObject=db.getTestDataObject("Select * from PGCreditLandingPage","ObjectRepository");
	}
	//-------------------------Verify Non-Team Credits from TV show in Credit Landing Page when Credit Role is listed as "Character" (NBCRESP-1312) ------------------------			
				@Test
				  public PGCreditLandingPage  Verify_Credit_Role_as_Character_NBCRESP_1312( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     Actions Action = new Actions(driver);
					     Synchronization.implicitWait(driver, 50);
					     WebDriverWait wait = new WebDriverWait(driver,50);
					     try {
								screenshotExtension=Extent_Reports.getScreenshot(driver);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    
					//Reading Objects
					try
					 {
																	
						//List<WebElement> menu = driver.findElements(By.cssSelector("ul.navigation__list li.navigation__item span.navigation__item__title"));
						menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement MainMenu: menu ){
						//for(int i=0;i<=menu.size();i++){
							if((MainMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(MainMenu).click().build().perform();
								Thread.sleep(6000);
								break;
							}
						}
						System.out.println("show menu clicked");
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						
						//List<WebElement> sName= driver.findElements(By.cssSelector("ul.navigation__item__list li a"));
						sName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						for(WebElement ShowName: sName ){
						//for (int j=0;j<=sName.size();j++){
							if(ShowName.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
								Action.moveToElement(ShowName).click().build().perform();
								Thread.sleep(20000);
								break;
							}
						}
						
						System.out.println(driver.getCurrentUrl());
						
						//List<WebElement> li = driver.findElements(By.cssSelector("section.show-page ul.show-header__list li"));
						sub_menu=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						//for(int i=2;i<sub_menu.size();i++){
						for(WebElement Submenu: sub_menu ){
						if((Submenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(3))){
							Action.moveToElement(Submenu).click().build().perform();
							break;
						}
						}
						Thread.sleep(20000);
						System.out.println(driver.getCurrentUrl());
		                
				 
					   //WebElement Image = driver.findElement(By.cssSelector("div.credit-list__inner div.credit-list__content a:nth-child(1) div.resp-image img"));
					    Image=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
					    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.credit-list__inner div.credit-list__content a:nth-child(1) img")));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been displayed: "+ "true" +Extent_Reports.logActual + "Actual Image has been displayed:"+ Image.isDisplayed() , driver);
					    System.out.println(Image.isDisplayed());
					    	 
					  	 //WebElement Character_Name = driver.findElement(By.cssSelector("div.credit-list__content a:nth-child(1) div.card__meta h2.card__title"));
					    Character_Name=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Character Name has been displayed: "+ Character_Name.isDisplayed() +Extent_Reports.logActual + "Actual Character Name is: "+ Character_Name.getAttribute("innerHTML"), driver );
					  	System.out.println(Character_Name.getAttribute("innerHTML"));
					  	 
					  	 //WebElement Played_By_Section = driver.findElement(By.cssSelector("div.credit-list__content a:nth-child(1) div.card__meta div.card__description__part"));
					  	Played_By_Section=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16)); 
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Played By Section has been displayed: "+ Played_By_Section.isDisplayed() +Extent_Reports.logActual + "Actual Played By Section is: "+ Played_By_Section.getText() , driver);
					  	System.out.println(Played_By_Section.getText());
					 	 
					 	 if(Image.isDisplayed()){
					 		Image.click();
					 		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been clicked: "+ "true" +Extent_Reports.logActual + "Actual Image has been clicked: "+ "true" , driver );
					 	  }
							((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");	

					 	
					  	 //WebElement Back_to_Cast= driver.findElement(By.cssSelector("a.credit-details-page__back-link"));
					 	Back_to_Cast=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Back to Cast link text has been displayed: "+ Back_to_Cast.isDisplayed() +Extent_Reports.logActual + "Actual Back to Cast link text is: "+ Back_to_Cast.getAttribute("innerHTML"),driver );
					  	System.out.println(Back_to_Cast.getAttribute("innerHTML"));
					  	
					  	//WebElement char_name = driver.findElement(By.cssSelector("div.bio__name h1.bio__character"));
					  	char_name=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected bio character name has been displayed: "+ char_name.isDisplayed() +Extent_Reports.logActual + "Actual bio character name is: "+ char_name.getAttribute("innerHTML"), driver);
					  	System.out.println(char_name.getAttribute("innerHTML"));
					  	
					  	//WebElement more_button = driver.findElement(By.cssSelector("div.bio__long-desc__more"));
					  	more_button=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected More button has been displayed: "+ more_button.isDisplayed() +Extent_Reports.logActual + "Actual More button has been displayed: "+ "true" , driver );
					  	more_button.click();
					  	
					  	//WebElement less_button = driver.findElement(By.cssSelector("div.bio__long-desc__more--active"));
					  	less_button=Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Less button has been displayed: "+ less_button.isDisplayed() +Extent_Reports.logActual + "Actual Less button has been displayed: "+ "true" , driver);
					  	less_button.click();

					 
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}
				
				//-------------------------Verify Non-Team Credits from TV Show in Credit Landing Page, where Credit Role is "Contestant" (NBCRESP-1312) ------------------------			

				@Test
				  public PGCreditLandingPage  Verify_Credit_Role_as_Contestant_NBCRESP_1312( ) throws InterruptedException, FilloException 
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
					
						//List<WebElement> menu = driver.findElements(By.cssSelector("ul.navigation__list li.navigation__item span.navigation__item__title"));
						menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						//for(int i=0;i<=menu.size();i++){
						for(WebElement MainMenu: menu ){
							if((MainMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(MainMenu).click().build().perform();;
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
						
						//List<WebElement> sName= driver.findElements(By.cssSelector("ul.navigation__item__list li a"));
						sName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						//for (int j=0;j<=sName.size();j++){
						for(WebElement ShowName: sName ){
							if(ShowName.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(4))){
								Action.moveToElement(ShowName).click().build().perform();;
								break;
							}
						}
						Thread.sleep(3000);
						System.out.println(driver.getCurrentUrl());

											
						sub_menu=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						for(WebElement Submenu: sub_menu ){
						//for(int i=0;i<=sub_menu.size();i++){
						if((Submenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(5))){
							Action.moveToElement(Submenu).click().build().perform();
						   break;
						    }
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());	
						
						//WebElement Image = driver.findElements(By.cssSelector("div.credit-list__content a.card img")).get(1);
						Image=Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31)).get(1);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been displayed: "+ "true" +Extent_Reports.logActual + "Actual Image has been displayed:"+ Image.isDisplayed(), driver);
						System.out.println(Image.isDisplayed());
						
					    //WebElement Person_Name = driver.findElements(By.cssSelector("a article.card__content div.card__meta h2")).get(1);
						Person_Name = Utilities.returnElements(driver,lstObject.get(35),lstObject.get(34)).get(1);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Person Name has been displayed: "+ Person_Name.isDisplayed() +Extent_Reports.logActual + "Actual Person Name is: "+ Person_Name.getAttribute("innerHTML") , driver );
					 	System.out.println(Person_Name.getAttribute("innerHTML"));
					 	
						if(Image.isDisplayed()){
					 		Image.click();
					 		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been clicked: "+ "true" +Extent_Reports.logActual + "Actual Image has been clicked: "+ "true" , driver );
					 		System.out.println("Clicked");
					 	 }
					 	
					 	((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
					 	
					 	//WebElement Back_to_Cast= driver.findElement(By.cssSelector("a.credit-details-page__back-link"));
					 	Back_to_Cast = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Back to Cast link text has been displayed: "+ Back_to_Cast.isDisplayed() +Extent_Reports.logActual + "Actual Back to Cast link text is: "+ Back_to_Cast.getAttribute("innerHTML") , driver);
					 	System.out.println(Back_to_Cast.getAttribute("innerHTML"));
					 	
					 	//WebElement contestant_name = driver.findElement(By.cssSelector("div.bio__name h1.bio__character"));
					 	contestant_name = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected bio contestant name has been displayed: "+ contestant_name.isDisplayed() +Extent_Reports.logActual + "Actual bio contestant name is: "+ contestant_name.getAttribute("innerHTML"), driver);
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
					  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Less button has been displayed: "+ less_button.isDisplayed() +Extent_Reports.logActual + "Actual Less button has been displayed: "+ "true" , driver);
					  	System.out.println("less button clicked");
					  
					 
					 }
					 catch(Exception exc)
					 {
						 System.out.println(exc.getMessage());
					 }
					
					driver.close(); 
					
					return null;
				}

				//-------------------------Verify Team Credits from TV Season in Credit Landing Page when Credit Role is "Coach" (NBCRESP-1341) ------------------------			

				@Test
				  public PGCreditLandingPage  Verify_Credit_Role_as_Coach_NBCRESP_1341( ) throws InterruptedException, FilloException 
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
						
						//List<WebElement> menu = driver.findElements(By.cssSelector("ul.navigation__list li.navigation__item span.navigation__item__title"));
						menu=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						//for(int i=0;i<=menu.size();i++){
						for(WebElement MainMenu: menu ){
							if((MainMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(MainMenu).click().build().perform();
								Thread.sleep(6000);
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
												
						//List<WebElement> sName= driver.findElements(By.cssSelector("ul.navigation__item__list li a"));
						sName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						//for (int j=0;j<=sName.size();j++){
						for(WebElement ShowName: sName ){
							if(ShowName.getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(6))){
								Action.moveToElement(ShowName).click().build().perform();
								Thread.sleep(10000);
								break;
							}
						}
						
						System.out.println(driver.getCurrentUrl());
						
						//driver.findElement(By.cssSelector("div.sticky-outer-wrapper.show-header.show-header--animate.show-header--sticky > div > div.show-header__menu > ul > li:nth-child(5) > a")).click();
											
						sub_menu=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						//for(int i=0;i<=sub_menu.size();i++){
						for(WebElement Submenu: sub_menu ){
						if((Submenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(7))){
							Action.moveToElement(Submenu).click().build().perform();
							
						break;
						    }
						}
						Thread.sleep(20000);
						System.out.println(driver.getCurrentUrl());			
					  
						title = driver.getTitle();
						System.out.println(title);
						
						//List<WebElement> Team_name_header = driver.findElements(By.cssSelector("div.credit-list__inner div.section-heading  h2.section-heading__title"));
					    Team_name_header=Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49));
					    for(WebElement TeamNameHeader: Team_name_header){
					    //for(int i=0;i<Team_name_header.size();i++){
					 		 System.out.println("Team Header is Dispayed:"+ TeamNameHeader.isDisplayed()+ " "+ TeamNameHeader.getAttribute("innerHTML"));
					 	}
						
						//WebElement Image = driver.findElements(By.cssSelector("div.credit-list__content a:nth-child(1) article.card__content div.resp-image img")).get(0);
					    Image=Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been displayed: "+ "true" +Extent_Reports.logActual + "Actual Image has been displayed:"+ Image.isDisplayed(),driver );
					    System.out.println("Image is Displayed: "+ Image.isDisplayed());
					        
					    //WebElement Person_Name = driver.findElements(By.cssSelector("a article.card__content div.card__meta h2")).get(0);
					    Person_Name=Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Person Name has been displayed: "+ Person_Name.isDisplayed() +Extent_Reports.logActual + "Actual Person Name is: "+ Person_Name.getAttribute("innerHTML") , driver);
					    System.out.println("Person Name is"+ Person_Name.getAttribute("innerHTML"));
					 	
					 	//WebElement Role_Name = driver.findElements(By.cssSelector("a article.card__content div.card__meta div.card__description div.card__description__part")).get(0);
					    Role_Name=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Person Name has been displayed: "+ Role_Name.isDisplayed() +Extent_Reports.logActual + "Actual Person Name is: "+ Role_Name.getAttribute("innerHTML"),driver );
					    System.out.println("Role Name is:"+ Role_Name.getAttribute("innerHTML"));
					 	
					 	//WebElement metadata = driver.findElements(By.cssSelector("div.card__meta[style='background-color: rgb(187, 105, 156);']")).get(0);
					    metadata=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected metadata background color is  "+ metadata.getAttribute("style") +Extent_Reports.logActual + "Actual metadata background color is : "+ metadata.getAttribute("style"),driver );
					    System.out.println("metadata style is:"+ metadata.getAttribute("style"));
					 	
					 	//WebElement header_menu_style = driver.findElement(By.cssSelector("div.show-header__menu"));
					 	header_menu_style=Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected header menu background color is  "+ header_menu_style.getAttribute("style") +Extent_Reports.logActual + "Actual header menu background color is : "+ header_menu_style.getAttribute("style"),driver );
					 	System.out.println("header_menu_style is:"+ header_menu_style.getAttribute("style"));
					 	
					 	if(metadata.getAttribute("style").equalsIgnoreCase(header_menu_style.getAttribute("style"))){
					 		Extent_Reports.executionLog("PASS","Metadata should be displayed in a colored box and the color should be same as show level navigation background color",driver);
					 	}else{
					 		Extent_Reports.executionLog("FAIL","Metadata should be displayed in a colored box and the color is diffent with show level navigation background color",driver);
					 	}
					 	
					 	if(Image.isDisplayed()){
					 		Image.click();
					 		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Image has been clicked: "+ "true" +Extent_Reports.logActual + "Actual Image has been clicked: "+ "true" , driver);
					 		System.out.println("Clicked");
					 	 }
					 	
					 	Synchronization.waitForPageLoad(driver);
					 	
					 	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,90)","");
					 	
					 	//WebElement Back_to_Cast= driver.findElement(By.cssSelector("div.credit-details-page__back-link-wrapper a.credit-details-page__back-link"));
					 	Back_to_Cast=Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected Back to Cast link text has been displayed: "+ Back_to_Cast.isDisplayed() +Extent_Reports.logActual + "Actual Back to Cast link text is: "+ Back_to_Cast.getAttribute("innerHTML"),driver );
					 	System.out.println(Back_to_Cast.getAttribute("innerHTML"));
					 	
						//WebElement character_name = driver.findElement(By.cssSelector("div.bio__name h1.bio__character"));
					 	character_name=Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected bio character name has been displayed: "+ character_name.isDisplayed() +Extent_Reports.logActual + "Actual bio character name is: "+ character_name.getAttribute("innerHTML"),driver);
					 	System.out.println(character_name.getAttribute("innerHTML"));
					 	
					 	//WebElement more_button = driver.findElement(By.cssSelector("div.bio__long-desc__more span.bio__desc__more-text"));
					 	more_button=Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
					 	Action.moveToElement(more_button).click().build().perform();
					 	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected More button has been displayed: "+ more_button.isDisplayed() +Extent_Reports.logActual + "Actual More button has been displayed: "+ "true" , driver);
						System.out.println("more button clicked");
					  	
					  	//WebElement less_button = driver.findElement(By.cssSelector("div.bio__long-desc__more--active span.bio__desc__more-text"));
						less_button=Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
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

