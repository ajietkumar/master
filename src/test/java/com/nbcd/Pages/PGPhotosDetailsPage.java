package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================

import java.util.ArrayList;
import java.util.List;
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
public class PGPhotosDetailsPage
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_home,menu_item,part3;
	boolean sorted = true;
	int Episodes_count;
	List<WebElement> menu_list,sName,sub_menu,objSubMenuItems,objSeason_Filter_values,objfirst_Filter_items,objphotogallery_count,objgallery_Title,objCategory,objPost_Date,objsecond_Filter_items ;
	WebElement objmenu,objsName,objsub_menu,objSeason_Filter,objSeason_Filter_selection,objnavigation_bar,objheader__tune_in,objShow_hearder,objCategories_Filter,objSecond_Filter,objfooter ;
	WebElement objphotoclick,objHover,objgallery__caption,objgallery__credit1,objgallery__credit2,objshare__btn_facebook,objshare__btn_twitter,objshare__btn_google,objslickArrowprevbtn,objslickArrownextbtn,objiframe,objAdvertisement;
	ArrayList<String> arr1,arr2;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGPhotosDetailsPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;	
		lstTestData=db.getTestDataObject("Select * from PGPhotoDetailsPage","Input");
		lstObject=db.getTestDataObject("Select * from PGPhotoDetailsPage","ObjectRepository");
	}
	//-------------------------Verify the functionality of Photos Landing Page ------------------------			
				@Test
				  public PGPhotosDetailsPage  Verify_PhotoDetailsPage ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
				//	  driver.get(lstTestData.get(0));
					driver.get("https://www.nbc.com/blindspot/photos");
					  Synchronization.implicitWait(driver, 50);
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
			/*														
						menu_list=Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(WebElement MainMenu: menu_list ){
						//for(int i=0;i<=menu.size();i++){
							if((MainMenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								Action.moveToElement(MainMenu).click().build().perform();
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
								break;
							}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
				*/		
						//List<WebElement> li = driver.findElements(By.cssSelector("section.show-page ul.show-header__list li"));
						sub_menu=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
						//for(int i=2;i<sub_menu.size();i++){
						for(WebElement Submenu: sub_menu ){
						if((Submenu.getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(3))){
							Action.moveToElement(Submenu).click().build().perform();
							break;
						}
						}
						Thread.sleep(2000);
						System.out.println(driver.getCurrentUrl());
		                	
		         						
						/*** Verify the Gallery image displayed below the gallery header ***/
						
						//WebElement objphotoclick=driver.findElement(By.cssSelector("section > div > div.gallery-list__container.gallery-list__hide-last > div.gallery-list__content > a:nth-child(2)"));
						objphotoclick=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
						objphotoclick.click();
						
						Synchronization.implicitWait(driver, 50);
						
						//WebElement objHover=driver.findElement(By.cssSelector("div.gallery__photo-count"));
						objHover=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
						System.out.println(objHover.getText());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery meta Data Should be displayed :"+ objHover.isDisplayed()+ " " + objHover.getText(),driver);
						
						//WebElement objgallery__caption = driver.findElement(By.cssSelector("div.gallery__caption"));
						objgallery__caption=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
						System.out.println(objgallery__caption.getAttribute("innerHTML"));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery meta Data Caption Should be displayed :"+ objgallery__caption.isDisplayed()+ " " + objgallery__caption.getAttribute("innerHTML"),driver);
						
						Action.moveToElement(objgallery__caption).build().perform();
						System.out.println(objgallery__caption.getAttribute("title"));
											
						//WebElement objgallery__credit1 = driver.findElement(By.cssSelector("div.gallery__credit"));
						objgallery__credit1=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
						System.out.println(objgallery__credit1.getText());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery meta Data Credit Should be displayed :"+ objgallery__credit1.isDisplayed()+ " " + objgallery__credit1.getText(),driver);
						
						//WebElement objgallery__credit2 = driver.findElements(By.cssSelector("div.gallery__credit span:nth-child(2)")).get(0);
						objgallery__credit2=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
						System.out.println(objgallery__credit2.getText());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery meta Data Credit Should be displayed :"+ objgallery__credit2.isDisplayed()+ " " + objgallery__credit2.getText(),driver);
						
						//WebElement objshare__btn_facebook = driver.findElements(By.cssSelector("div.share a.share__btn.share__btn--facebook")).get(0);
						objshare__btn_facebook=Utilities.returnElements(driver,lstObject.get(26),lstObject.get(25)).get(0);
						System.out.println("share button facebook : "+objshare__btn_facebook.isDisplayed());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed facebook shar icon :"+ objshare__btn_facebook.isDisplayed()+ " " + objshare__btn_facebook.getAttribute("innerHTML"),driver);
				  		
						//WebElement objshare__btn_twitter = driver.findElements(By.cssSelector("div.share a.share__btn.share__btn--twitter")).get(0);
						objshare__btn_twitter=Utilities.returnElements(driver,lstObject.get(29),lstObject.get(28)).get(0);
						System.out.println("share button twitter : "+objshare__btn_twitter.isDisplayed());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed twitter shar icon :"+ objshare__btn_twitter.isDisplayed()+ " " + objshare__btn_twitter.getAttribute("innerHTML"),driver);
						
						//WebElement objshare__btn_google = driver.findElements(By.cssSelector("div.share a.share__btn.share__btn--google")).get(0);
						objshare__btn_google=Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31)).get(0);
						System.out.println("share button google : "+objshare__btn_google.isDisplayed());
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Google shar icon :"+ objshare__btn_google.isDisplayed()+ " " + objshare__btn_google.getAttribute("innerHTML"),driver);
												
						//WebElement objslickArrowprevbtn=driver.findElement(By.cssSelector("button.slick-arrow.slick-prev"));
						objslickArrowprevbtn=Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
						objslickArrowprevbtn.isDisplayed();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed slick prev Arrow Button:"+ objslickArrowprevbtn.isDisplayed()+ " " + objslickArrowprevbtn.getAttribute("innerHTML"),driver);
						
						//WebElement objslickArrownextbtn = driver.findElement(By.cssSelector("button.slick-arrow.slick-next"));
						objslickArrownextbtn=Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
						objslickArrownextbtn.isDisplayed();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed slick next Arrow Button:"+ objslickArrownextbtn.isDisplayed()+ " " + objslickArrownextbtn.getAttribute("innerHTML"),driver);
						
						for(int arrow=1;arrow<6;arrow++){
							Action.moveToElement(objslickArrownextbtn).click().build().perform();
							Synchronization.implicitWait(driver, 20);
						}
						
						screenshotExtension=Extent_Reports.getScreenshot(driver);
						Synchronization.implicitWait(driver, 50);
						
						
						/*** verify 300X250 Ad should be displayed ****/
		/*				//WebElement objiframe = driver.findElement(By.cssSelector("div.gallery__ad div.mps-ad__inner iframe[id^='google_ads_iframe']"));
						objiframe=Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
						driver.switchTo().frame(objiframe);
						//WebElement objAdvertisement = driver.findElement(By.cssSelector("body > a > img"));
						objAdvertisement=Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
						
						if(objAdvertisement.isDisplayed()){
						System.out.println("Advertisement is displayed");
							
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Advertisement after 5th photo: "+ " true" +Extent_Reports.logActual +"Gallery page should be displayed Advertisement after 5th photo: " +" " + objAdvertisement.isDisplayed(),driver);
						}else
						{
							
						Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Gallery page should be displayed Advertisement after 5th photo: "+ " true" +Extent_Reports.logActual +"Gallery page is not displayed Advertisement after 5th photo: " +" " + objAdvertisement.isDisplayed(),driver);
						}
		*/			
					 	
						driver.navigate().to("https://www.nbc.com/the-blacklist/photos");
						Synchronization.implicitWait(driver, 50);

						/*** Click on any Photo gallery from the list of galleries displayed on the page ***/
						
						objSeason_Filter=Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
						Action.moveToElement(objSeason_Filter).click().build().perform();
		                
		                /**** All Season filter values *****/
		             //   List<WebElement> objSeason_Filter_values = driver.findElements(By.cssSelector("div.section-heading > div > div.gallery-list__filters__season > div > div > ul > li a"));
		                objSeason_Filter_values=Utilities.returnElements(driver,lstObject.get(50),lstObject.get(49));
		                System.out.println(objSeason_Filter_values.size());
		                
		                /*for(int j=0;j<objSeason_Filter_values.size();j++){
		                	System.out.println(objSeason_Filter_values.get(j).getAttribute("innerHTML"));
		                }*/
		                
		                objSeason_Filter_selection=Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
		                System.out.println(objSeason_Filter_selection.getAttribute("innerHTML"));
		                objSeason_Filter_selection.click();
		                Synchronization.implicitWait(driver, 30);

		                /**** Verify Responsive Global Navigation bar is available ***/
						//List<WebElement> menu_list = driver.findElements(By.cssSelector("span.navigation__item__title"));
						menu_list=Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94));
						//for (int i=0;i<menu_list.size();i++){
						for(WebElement Menu_List: menu_list){
							menu_item = Menu_List.getAttribute("innerHTML");
							System.out.println("Menu Items are : " + menu_item);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Photo Gallery page should be displayed menu list :"+ menu_item , driver);
						}
						
						/*** Verify the presence of Show level navigation bar ***/
						
						//WebElement objnavigation_bar=driver.findElement(By.cssSelector("div.section-heading h1.section-heading__title"));
						objnavigation_bar=Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
						System.out.println("*********************");
						System.out.println(objnavigation_bar.getAttribute("innerHTML"));
						System.out.println("*********************");
						String[] parts = objnavigation_bar.getAttribute("innerHTML").split(" ");
						part3 = parts[3]; 
						Episodes_count = Integer.parseInt(part3);
						System.out.println("Photo Galleries: Season "+ Episodes_count);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Photo Galleries: Season "+ Episodes_count, driver);
				/*		
						if(objnavigation_bar.getAttribute("innerHTML").equalsIgnoreCase("Photo Galleries: Season ")){
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Photo Gallery page should be displayed Photo Galleries: Season (photos count) : "+ " true" +Extent_Reports.logActual + "Photo Gallery page should be displayed Photo Galleries: Season : "+Episodes_count, driver);
						}else{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Photo Gallery page should be displayed Photo Galleries: Season (photos count) : "+ " true" +Extent_Reports.logActual + "Photo Gallery page should not be displayed Photo Galleries: Season : "+Episodes_count , driver );
						}
				 */		
						//WebElement objheader__tune_in=driver.findElement(By.cssSelector("div.show-header__info div.show-header__tune-in"));
						objheader__tune_in=Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Header Tune text:"+ objheader__tune_in.isDisplayed()+ " " + objheader__tune_in.getAttribute("innerHTML"),driver);
						System.out.println(objheader__tune_in.getAttribute("innerHTML"));
						
						//WebElement objShow_hearder=driver.findElement(By.cssSelector("div.show-header__title span.show-header__title__inner"));
						objShow_hearder=Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Show Header text:"+ objShow_hearder.isDisplayed()+ " " + objShow_hearder.getAttribute("innerHTML"),driver);
						System.out.println(objShow_hearder.getAttribute("innerHTML"));
						
						//Season filter is dispalyed
						//driver.findElements(By.cssSelector("span.filter-select__selected")).get(0).isDisplayed();
						objSeason_Filter=Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Season filter is dispalyed:"+ objSeason_Filter.isDisplayed(), driver);
						System.out.println("Season filter is dispalyed"+ objSeason_Filter.isDisplayed());
												
						objSeason_Filter=Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
						objSeason_Filter.click();
						Thread.sleep(5000);
						//List<WebElement> objfirst_Filter = driver.findElements(By.cssSelector("div.gallery-list__filters__season > div > div > ul > li a"));
					    objfirst_Filter_items=Utilities.returnElements(driver,lstObject.get(71),lstObject.get(70));
					    System.out.println(objfirst_Filter_items.size());
						//for(int m=0;m<objfirst_Filter_items.size();m++)
					    for(WebElement FirstFilter: objfirst_Filter_items){
						System.out.println(FirstFilter.getAttribute("innerHTML"));
						arr1.add(FirstFilter.getAttribute("innerHTML"));
												
						}
						System.out.println(arr1);
						
					    for(int i = 0; i < arr1.size(); i++)
					    {
					        for(int j = i+1; j < arr1.size(); j++) 
					        {
					            if (arr1.get(i).compareTo(arr1.get(j)) == 1)
					            {
					                sorted = false;
					            }  
					        }  
					    }                
					    System.out.println("sorted:"+ sorted);
					    
					    
					    if (sorted==false)
						{
					    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "All Season Filter Options are should be in reverse chronological order",driver );
						}	
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "All Season Filter Options are not in reverse chronological order", driver);

						}
					    
					    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "All Season Filter Options are should be in reverse chronological order :"+ arr1 , driver);
					    
					    /*** Verify Photo galleries displayed on the page ***/
					    
					    //List<WebElement> objphotogallery_count = driver.findElements(By.cssSelector("div.gallery-list__container div.gallery-list__content  a.card.card--gallery"));
					    objphotogallery_count=Utilities.returnElements(driver,lstObject.get(74),lstObject.get(73));
					    System.out.println(objphotogallery_count.size());
					    
					    if (objphotogallery_count.size()==8){
					    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "8 photo gallery thumbnails, titles and metadata should be displayed in 3 columns" , driver );
					    }else{
					    	Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "8 photo gallery thumbnails, titles and metadata are not displayed in 3 columns" , driver );
					    }
					    
					    //List<WebElement> objgallery_Title= driver.findElements(By.cssSelector("div.card__meta h2.card__title"));
					    objgallery_Title=Utilities.returnElements(driver,lstObject.get(77),lstObject.get(76));
					    //List<WebElement> objCategory = driver.findElements(By.cssSelector("div.card__meta div:nth-child(1)"));
					    objCategory=Utilities.returnElements(driver,lstObject.get(80),lstObject.get(79));
					   // List<WebElement> objPost_Date = driver.findElements(By.cssSelector("div.card__meta > div > div:nth-child(2)"));
					    objPost_Date=Utilities.returnElements(driver,lstObject.get(83),lstObject.get(82));
					    for (int i=0;i<objgallery_Title.size();i++){
					    	System.out.println(objgallery_Title.get(i).getAttribute("innerHTML")+" "+ objCategory.get(i).getText()+" "+ objPost_Date.get(i).getText() );
					    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + objgallery_Title.get(i).getAttribute("innerHTML")+"   "+ objCategory.get(i).getText()+"   "+ objPost_Date.get(i).getText(),driver );
					    }
					    
					    //Categories filter is dispalyed:  
						//driver.findElement(By.cssSelector("div.gallery-list__filters__categories")).isDisplayed();
						objCategories_Filter=Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Gallery page should be displayed Categories filter is dispalyed:"+ objCategories_Filter.isDisplayed(),driver);
						System.out.println("Categories filter is dispalyed:"+objCategories_Filter.isDisplayed());
						
					    //WebElement objSecond_Filter=driver.findElement(By.cssSelector("div.gallery-list__filters__categories span.filter-select__selected"));
					    objSecond_Filter=Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
					    objSecond_Filter.click();
					    Thread.sleep(5000);
						//List<WebElement> objsecond_Filter_items=driver.findElements(By.cssSelector("div.gallery-list__filters__categories > div > div > ul > li > a"));
					    objsecond_Filter_items=Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
						//for(int r=0;r<objsecond_Filter_items.size();r++)
					    
					    for(WebElement SecondFilter: objsecond_Filter_items ){
							System.out.println(SecondFilter.getAttribute("innerHTML"));
							arr2.add(SecondFilter.getAttribute("innerHTML"));	
						}
								                      
					    for(int i = 0; i < arr2.size(); i++)
					    {
					        for(int j = i+1; j < arr2.size(); j++) 
					        {
					            if (arr2.get(i).compareTo(arr2.get(j)) == 1)
					            {
					                sorted = true;
					            }  
					        }  
					    } 
					    
					    if (sorted==true)
						{
					    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "All Categories Filter Options are should be in chronological order" , driver );
						}	
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "All Categories Filter Options are in reverse chronological order" , driver);

						}

					    //WebElement objfooter = driver.findElement(By.cssSelector("section.footer__top"));
					    objfooter=Utilities.returnElement(driver,lstObject.get(92),lstObject.get(91));
					    System.out.println(objfooter.isDisplayed());
					    if(objfooter.isDisplayed()){
							
					    	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Photo Gallery page should be displayed Global Responsive footer :"+" true" +Extent_Reports.logActual +"Photo Gallery page should be displayed Global Responsive footer :" +" " + objfooter.isDisplayed(),driver);
						}else{
							
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Photo Gallery page should be displayed Global Responsive footer :"+" true" +Extent_Reports.logActual +"Photo Gallery page is not displayed Global Responsive footer :" +" " + objfooter.isDisplayed(),driver);
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
