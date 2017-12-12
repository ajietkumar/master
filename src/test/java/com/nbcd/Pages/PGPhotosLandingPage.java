package com.nbcd.Pages;

//===============================================PACKAGES==========================================================================
import com.relevantcodes.extentreports.LogStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

//==============================================================CLASSES AND METHODS==================================================
public class PGPhotosLandingPage
{

//=========================================Variables=================================================================================
	private WebDriver driver;
	String sql;
	protected static String showDetails,screenshotExtension;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status,Show_home;
	boolean Livelink;
	List<WebElement> objmenu,objsName,objsub_menu,menu_list,objsecond_Filter,objfirst_Filter ;
	WebElement objgallery_Title,objCategory,objPost_Date,objfooter,objthumbnail,objtitle,objAd_Width_Heigth,objfilter1,objfilter2,objCategories_Filter,objSeason_Filter;
	ArrayList<String> arr1,arr2;
	
//=================================================================================================================================================================================	
//Constructor to initialize all the Page Objects  
	public PGPhotosLandingPage(WebDriver driver) throws Exception 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from PGPhotoLandingPage","Input");
		lstObject=db.getTestDataObject("Select * from PGPhotoLandingPage","ObjectRepository");
	}
	//-------------------------Verify the functionality of Photos Landing Page ------------------------			
				@Test
				  public PGPhotosLandingPage  Verify_PhotoLandingPage ( ) throws InterruptedException, FilloException 
				  {
						
					//Launching Browser with valid URL.
					   driver.get(lstTestData.get(0));
					   //  driver.get(lstTestData.get(13));
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
						/*											
						//List<WebElement> menu = driver.findElements(By.cssSelector("ul.navigation__list li.navigation__item span.navigation__item__title"));
						objmenu = Utilities.returnElements(driver,lstObject.get(2),lstObject.get(1));
						for(int i=1;i<objmenu.size();i++){
							if((objmenu.get(i).getAttribute("innerHTML")).equalsIgnoreCase(lstTestData.get(1))){
								objmenu.get(i).click();
								break;
							}
						}
						
					//	List<WebElement> sName= driver.findElements(By.cssSelector("ul.navigation__item__list li a"));
						objsName=Utilities.returnElements(driver,lstObject.get(5),lstObject.get(4));
						for (int j=0;j<=objsName.size();j++){
							if(objsName.get(j).getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(2))){
								objsName.get(j).click();
								break;
							}
						}
						
						
						objsub_menu=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
					  // 	List<WebElement> sub_menu = driver.findElements(By.cssSelector("ul.show-header__list a"));
					   	 for(int k=8;k<=objsub_menu.size();k++){
						   if(objsub_menu.get(k).getAttribute("innerHTML").equalsIgnoreCase(lstTestData.get(3))){
							   objsub_menu.get(k).click();
							    break;
						   } 
						   
					   }
					 */
						
					   	menu_list=Utilities.returnElements(driver,lstObject.get(11),lstObject.get(10));
						//List<WebElement> menu_list = driver.findElements(By.cssSelector("span.navigation__item__title"));
						for (int i=0;i<menu_list.size();i++){
							String menu_item = menu_list.get(i).getAttribute("innerHTML");
							System.out.println("Menu :" + menu_item);
						}
						
										
					//	"Categories filter is dispalyed: "+ driver.findElement(By.cssSelector("div.gallery-list__filters__categories")).isDisplayed());
					//	"Season filter is dispalyed: "+ driver.findElements(By.cssSelector("span.filter-select__selected")).get(0).isDisplayed());
						
						objCategories_Filter = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
						/****Categories filter*******/
						if (objCategories_Filter.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + lstObject.get(14) +"':"+objCategories_Filter.isDisplayed() +Extent_Reports.logActual +lstObject.get(14) +"':"+ objCategories_Filter.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + lstObject.get(14) +"':"+objCategories_Filter.isDisplayed() +Extent_Reports.logActual +lstObject.get(14) +"':"+ objCategories_Filter.isDisplayed());

						}

						objSeason_Filter = Utilities.returnElements(driver,lstObject.get(17),lstObject.get(16)).get(0);
						/****Season filter*******/
						
						if (objSeason_Filter.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + lstObject.get(17) +"':"+objSeason_Filter.isDisplayed() +Extent_Reports.logActual +lstObject.get(17) +"':"+ objSeason_Filter.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + lstObject.get(17) +"':"+objSeason_Filter.isDisplayed() +Extent_Reports.logActual +lstObject.get(17) +"':"+ objSeason_Filter.isDisplayed());

						}

											
						//driver.findElement(By.cssSelector("div.gallery-list__filters__categories span.filter-select__selected")).click();
						objfilter2=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
						objfilter2.click();
					//	List<WebElement> second_Filter=driver.findElements(By.cssSelector("div.gallery-list__filters__categories > div > div > ul > li > a"));
						objsecond_Filter=Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
						arr2 = new ArrayList<String>();
						for(int r=0;r<objsecond_Filter.size();r++)
						{	
							System.out.println(objsecond_Filter.get(r).getAttribute("innerHTML"));
							arr2.add(objsecond_Filter.get(r).getAttribute("innerHTML"));	
						}
						
						boolean sorted = true;                      
					    for(int i = 0; i < arr2.size(); i++)
					    {
					        for(int j = i+1; j < arr2.size(); j++) 
					        {
					            if (arr2.get(i).compareTo(arr2.get(j)) == 1)
					            {
					                sorted = false;
					            }  
					        }  
					    } 
					    
					    if (sorted==true)
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "All Categories Filter Options are should be in alphabetical order " +Extent_Reports.logActual + "All Categories Filter Options are in alphabetical order");
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "All Categories Filter Options are should be in alphabetical order " +Extent_Reports.logActual + "All Categories Filter Options are not in alphabetical order ");

						}

					    	
					//	driver.findElement(By.cssSelector("div.gallery-list__filters__season div.filter-select div.filter-select__inner")).click();
						objfilter1=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
						objfilter1.click();
						//List<WebElement> first_Filter = driver.findElements(By.cssSelector("div.gallery-list__filters__season > div > div > ul > li a"));
						objfirst_Filter=Utilities.returnElements(driver,lstObject.get(29),lstObject.get(28));
						arr1 =  new ArrayList<String>();
						for(int m=0;m<objfirst_Filter.size();m++)
						{
							System.out.println(objfirst_Filter.get(m).getAttribute("innerHTML"));
							arr1.add(objfirst_Filter.get(m).getAttribute("innerHTML"));
												
						}
							                          
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
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "All Categories Filter Options are should be in reverse chronological order " +Extent_Reports.logActual + "All Categories Filter Options are in reverse chronological order");
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "All Categories Filter Options are should be in reverse chronological order " +Extent_Reports.logActual + "All Categories Filter Options are not in reverse chronological order ");

						}

					    
						for(int m=0;m<objfirst_Filter.size();m++)
						{
							if(objfirst_Filter.get(m).getAttribute("innerHTML").equalsIgnoreCase("Season 5")){
								objfirst_Filter.get(m).click();
								break;
							}
									
						}
						
											
						System.out.println(driver.getTitle());
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
					//	WebElement Ad_Width_Heigth = driver.findElement(By.cssSelector("div[id^='div-gpt-topbox']"));
						objAd_Width_Heigth=Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
						Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Add Width & Height is "+ objAd_Width_Heigth.getAttribute("style")+Extent_Reports.logActual + "Add Width & Height is 300*250");
						
						//WebElement title = driver.findElement(By.cssSelector("h1.section-heading__title"));
						objtitle=Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
						System.out.println("Title is: "+ objtitle.getAttribute("innerHTML"));
						
						//WebElement thumbnail = driver.findElements(By.cssSelector("div.gallery-list__container a div.card__thumbnail")).get(0);
						objthumbnail=Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37)).get(0);
												
						 if (objthumbnail.isDisplayed())
							{
								Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Thumbnail is dispayed on videos" + objthumbnail.isDisplayed() +Extent_Reports.logActual + "Thumbnail is dispayed on videos" + objthumbnail.isDisplayed());
							}	
							else
							{
								Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "Thumbnail is dispayed on videos" + objthumbnail.isDisplayed() +Extent_Reports.logActual + "Thumbnail is not dispayed on videos" + objthumbnail.isDisplayed());

							}

							
				 		//WebElement gallery_Title = driver.findElements(By.cssSelector("div.card__meta h2.card__title")).get(0);
							objgallery_Title=Utilities.returnElements(driver,lstObject.get(41),lstObject.get(40)).get(0);
						if (objgallery_Title.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Gallary Title is dispayed on videos" + objgallery_Title.isDisplayed() +Extent_Reports.logActual + "Gallary Title is dispayed on videos" + objgallery_Title.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "Gallary Title is dispayed on videos" + objgallery_Title.isDisplayed() +Extent_Reports.logActual + "Gallary Title is not dispayed on videos" + objgallery_Title.isDisplayed());

						}

						
						//WebElement Category = driver.findElements(By.cssSelector("div.card__description div:nth-child(1)")).get(0);
						objCategory=Utilities.returnElements(driver,lstObject.get(44),lstObject.get(43)).get(0);
						if (objCategory.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Category is dispayed on videos" + objCategory.isDisplayed() +Extent_Reports.logActual + "Category is dispayed on videos" + objCategory.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "Category Title is dispayed on videos" + objCategory.isDisplayed() +Extent_Reports.logActual + "Category is not dispayed on videos" + objCategory.isDisplayed());

						}
						
											
								
					//	WebElement Post_Date = driver.findElements(By.cssSelector("div.card__description div:nth-child(2)")).get(0);
							objPost_Date=Utilities.returnElements(driver,lstObject.get(47),lstObject.get(46)).get(0);
						if (objPost_Date.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Post Date is dispayed on videos" + objPost_Date.isDisplayed() +Extent_Reports.logActual + "Post Date is dispayed on videos" + objPost_Date.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "Post Date Title is dispayed on videos" + objPost_Date.isDisplayed() +Extent_Reports.logActual + "Post Date is not dispayed on videos" + objPost_Date.isDisplayed());

						}
						
						//driver.findElement(By.cssSelector("footer.footer")).isDisplayed());

						objfooter=Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
						if (objfooter.isDisplayed())
						{
							Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected + "Footer is dispayed " + objfooter.isDisplayed() +Extent_Reports.logActual + "Footer is dispayed" + objfooter.isDisplayed());
						}	
						else
						{
							Extent_Reports.logger.log(LogStatus.FAIL,Extent_Reports.logExpected + "Footer is dispayed" + objfooter.isDisplayed() +Extent_Reports.logActual + "Footer is not dispayed" + objfooter.isDisplayed());

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
