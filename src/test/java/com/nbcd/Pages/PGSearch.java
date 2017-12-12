package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class PGSearch {
	

	//=========================================Variables=================================================================================
		private  WebDriver driver;
		String sql;
		protected static String showDetails;
		DatabaseFunction db = new DatabaseFunction();
		public List<String> lstObject,lstTestData,lstTestDatasss;
		String sqlQry,Status,strResultText,strVideoDesc,strBadetitle,strValVideoTitle,f,strMetaDataDirectVidoes;
		String strMetaData,strConMetaData,strstrConMetaDataDirectVidoes;
		int vCount,cBadge;
		ArrayList<String> arrMetadataVideo = new ArrayList<String>();
		ArrayList<String> arrMetadataValVideo = new ArrayList<String>();
		WebElement objSearchIcon,objSearchInput,objVideoSection,objExitIcon,objResultText,objVideoDesc,objBadge,objValVideoSection;
		WebElement objClear,objVideos,objSearchLinkShow;
		
	//=================================================================================================================================================================================	
	//Constructor to initialize all the Page Objects  
		public PGSearch(WebDriver driver) throws MalformedURLException
		{      
			try 
				{
					
					this.driver = driver;
					lstTestData=db.getTestDataObject("Select * from SearchPage","Input");
					lstObject=db.getTestDataObject("Select * from SearchPage","ObjectRepository");
					//lstTestDatasss = db.getTestDataObject("Select SearchInput from SearchPage","Input");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						
						
			}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGSearch VerifyGeneralBehaviour_2866( ) throws InterruptedException, FilloException 
		  {
			
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
		//	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+Extent_Reports.logActual+"Browser Launch succesfully",driver);
			
			//Reading Objects
			try
			 {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				objSearchIcon =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
				objSearchIcon.click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search icon should display at right corner and enabled to click"+ Extent_Reports.logActual+"Search icon is displayed at right corner and clicked",driver);
				//driver.navigate().to(lstTestData.get(0));
				
				//objSearchIcon.click();
				System.out.println("testing");
				objSearchInput=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
				objSearchInput.sendKeys("meet the");
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> objVideoSection=Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
				vCount = objVideoSection.size();
				if(vCount==3)
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results screen should display 3 videos per row"+Extent_Reports.logActual+" Search Results screen is displayed as 3 videos per row",driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search Results screen should display 3 videos per row"+ Extent_Reports.logActual+" Search Results screen is not displaying 3 videos per row",driver);
				}
				
				objExitIcon=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				if(objExitIcon.isDisplayed());
				{
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Exit Icon should be displayed"+ Extent_Reports.logActual+" Exit Icon is displayed",driver);
				}
				
				objResultText=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
				strResultText = objResultText.getAttribute("innerHTML");
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Result Text should display"+ Extent_Reports.logActual+" Result text is displayed as "+strResultText,driver);
				
				objVideoDesc=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				strVideoDesc = objVideoDesc.getText();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" VideoDescription should display"+ Extent_Reports.logActual+" Video description is displayed as "+strVideoDesc,driver);
				
				for (int i=0;i<objVideoSection.size();i++){
					arrMetadataVideo.add(objVideoSection.get(i).getText().substring(0, 19));
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Meta data should be displayed"+ Extent_Reports.logActual+" Meta Data is displayed as "+objVideoSection.get(i).getText(),driver);             
				}
				
				List <WebElement> objBadge=Utilities.returnElements(driver,lstObject.get(20),lstObject.get(19));
				cBadge = objBadge.size();
				strBadetitle = objBadge.get(0).getAttribute("innerHTML");	
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Badge is displayed"+Extent_Reports.logActual+"Bagde is displayed as "+strBadetitle,driver);
				
				
				 driver.navigate().to(lstTestData.get(2));
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 strValVideoTitle=driver.getTitle();
			//	 Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+" Video specific page should display"+ Extent_Reports.logActual+" Video specific page displayed as "+strValVideoTitle,driver);
				 List<WebElement> objValVideoSection=Utilities.returnElements(driver,lstObject.get(23),lstObject.get(22));
				 for (int j=0;j<objValVideoSection.size();j++){
                     arrMetadataValVideo.add(objValVideoSection.get(j).getText());
                     System.out.println("metadata of video is: " + objValVideoSection.get(j).getText() );
              }
              // Video's meta data comparison
	             ArrayList<String> compare= new ArrayList<String>();
	             for (String temp : arrMetadataVideo)
	             compare.add(arrMetadataValVideo.contains(temp) ? "Yes" : "No");
	             System.out.println(compare);
	             for (String SearchVideoText : arrMetadataVideo)
				    {
				        for (String VideopageText : arrMetadataValVideo)
				        {
				            if (SearchVideoText.equals(VideopageText))
				            {   System.out.println("Matched Video's " + VideopageText);
				            	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Latest 3 videos are dispalying on search screen"+Extent_Reports.logActual+"Latest 3 videos are dispalying on search screen",driver);
				                break;
				            }
				           
				        }
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
		  public PGSearch VerifyGeneralAbilities_2890( ) throws InterruptedException, FilloException 
		  {
			
			//Launching Browser with valid URL.
				lstTestDatasss=db.getTestDataObject("Select SearchInput from SearchPage","Input");
				System.out.println(lstTestDatasss.get(1));
			     driver.get(lstTestData.get(0));
			 
			 //    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+ Extent_Reports.logActual+" Browser Launch succesfully",driver);
			    
			
			try
			 {
				objSearchIcon =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
				objSearchIcon.isDisplayed();
				objSearchIcon.click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search icon should display at right corner and enabled to click"+ Extent_Reports.logActual+" Search icon is displayed at right corner and clicked",driver);
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				objSearchInput=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4)); 
				objSearchInput.isDisplayed();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Input field should display and enabled to click"+Extent_Reports.logActual+" Search input is displayed and enabled",driver);
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	             
	            // System.out.println(lstTestDatasss.get(1));	
					String[] lines = lstTestData.get(1).split("\r\n|\r|\n");
					int linescount = lines.length;
					System.out.println(linescount);
					Scanner scanner = new Scanner(lstTestData.get(1));
					Scanner scannerComp = new Scanner(lstTestData.get(3));
	             	
					//List<String> lstTestDatasss = db.getTestDataObject("Select SearchInput from SearchPage","Input");
					//System.out.println(lstTestDatasss.get(2));
					for(int lc=0;lc<linescount-1;lc++) {
						while(scannerComp.hasNextLine()){
							String line = scanner.nextLine();
							String compLine = scannerComp.nextLine();
							System.out.println(line);
							objSearchInput.sendKeys(line);
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Input field should be entered"+ Extent_Reports.logActual+"Search input is entered as "+line,driver);
							//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Search Input field should be entered"+Extent_Reports.logActual+" Search input is entered as"+line,driver);
							List <WebElement> objVideos = Utilities.returnElements(driver,lstObject.get(29),lstObject.get(28));	
							for (int i=0;i<objVideos.size();i++){
								String strVideoText = objVideos.get(i).getText();	  
								System.out.println(strVideoText);
								
								int indexaa = strVideoText.indexOf("\n");
								String strVideoCompVal = strVideoText.substring(0, indexaa);
								System.out.println(strVideoCompVal);
								System.out.println(compLine);
								System.out.println("lineooo");
								if(strVideoCompVal.equalsIgnoreCase(compLine))
								{
									Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search results should display for "+line+ Extent_Reports.logActual+" Search is successfull and results are displayed with "+compLine+" Video",driver);
								}
								else
								{
									Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search results should display for "+line+ Extent_Reports.logActual+" Search is successfull and results are not displayed with "+compLine+" Video",driver);
								}
								objClear=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
								objClear.click();
								
							}
							
						}
						
					}
					
				scanner.close();
				scannerComp.close();
				
	             			
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
				  public PGSearch VerifySearchResults_2890( ) throws InterruptedException, FilloException 
				  {
					
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					 
				//	     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch"+ Extent_Reports.logActual+" Browser Launch succesfully",driver);
					    
					
					try
					 {
						objSearchIcon =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
						objSearchIcon.isDisplayed();
						objSearchIcon.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search icon should display at right corner and enabled to click"+ Extent_Reports.logActual+" Search icon is displayed at right corner and clicked",driver);
						
						Thread.sleep(4000);
						objSearchInput=Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4)); 
						objSearchInput.isDisplayed();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Input field should display and enabled to click"+Extent_Reports.logActual+" Search input is displayed and enabled",driver);
						
						//Search for series/show e.g. This Is Us
						objSearchInput.sendKeys(lstTestData.get(4));
						Thread.sleep(8000);
						List<WebElement> objSearchList = Utilities.returnElements(driver,lstObject.get(32),lstObject.get(31));
						List<WebElement> objSearchLists = objSearchList.get(0).findElements(By.tagName("img"));
						String strSearchTitle = objSearchLists.get(0).getAttribute("alt");
						System.out.println(strSearchTitle);
						//Condition for same results dispaly....
						if(strSearchTitle.contentEquals(lstTestData.get(4)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results at first section should match with Input Search value"+Extent_Reports.logActual+"Search Results at first section is matching with Input Search value",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search Results at first section should match with Input Search value"+Extent_Reports.logActual+"Search Results at first section is not matching with Input Search value",driver);
						}
						
						//Get Episode names
						List<WebElement> objSearchEpisodeNames = objSearchList.get(0).findElements(By.cssSelector(lstObject.get(37)));
						System.out.println(objSearchEpisodeNames.size());
						//Condition for 3 videos
						if(objSearchEpisodeNames.size()==4)
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results should have 3 latest videos"+Extent_Reports.logActual+"Search Results are having 3 videos",driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search Results should have 3 latest videos"+Extent_Reports.logActual+"Search Results are not having 3 videos",driver);
						}
						
						//List<WebElement> objSearchEpisodeList = driver.findElements(By.cssSelector("div.search__hit__show div.card__meta"));
						for(int iIterator=1 ;iIterator<objSearchEpisodeNames.size();iIterator++ )
						{
							strMetaData = objSearchEpisodeNames.get(iIterator).getText();
							strConMetaData = strMetaData+";"+ strConMetaData;
							System.out.println(strConMetaData);
							//Enter meta data for report
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results Videos meta should display"+Extent_Reports.logActual+"Search Results Videos meta is displayed"+strConMetaData,driver);
						}
						String strShowNameLowerCase = lstTestData.get(4).toLowerCase();
						String strShownameURL = strShowNameLowerCase.replace(" ","-");
						System.out.println(strShownameURL);
						
						driver.navigate().to("https://www.nbc.com/"+strShownameURL);
						Thread.sleep(4000);
						List<WebElement> objSearchInputDirectList = Utilities.returnElements(driver,lstObject.get(38),lstObject.get(37));
						System.out.println(objSearchInputDirectList.size());
						for(int iIterator=0 ;iIterator<3;iIterator++ )
						{
							strMetaDataDirectVidoes = objSearchInputDirectList.get(iIterator).getText();		
							strstrConMetaDataDirectVidoes = strMetaDataDirectVidoes+";"+strstrConMetaDataDirectVidoes;
							System.out.println(strstrConMetaDataDirectVidoes);
							//Enter meta data for report
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results Videos meta should display on Show Detail page"+Extent_Reports.logActual+"Search Results Videos meta is displayed on Show Detail page"+strstrConMetaDataDirectVidoes,driver);
						}
						if(strConMetaData.contentEquals(strstrConMetaDataDirectVidoes))
						{
							System.out.println("Pass");
							//results report
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search Results Videos are Latest Videos and are matching with Show Detail page"+Extent_Reports.logActual+"Search Results Videos are Latest Videos and are matching with Show Detail page and the videos are "+strstrConMetaDataDirectVidoes,driver);
						}
						else
						{
							System.out.println("Fail");
							//results report
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Search Results Videos are Latest Videos and are matching with Show Detail page"+Extent_Reports.logActual+"Search Results Videos are Latest Videos and are not matching with Show Detail page and the videos are "+strstrConMetaDataDirectVidoes,driver);
						}
						
						objSearchLinkShow = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
						objSearchLinkShow.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Search icon should display at right corner and enabled to click"+ Extent_Reports.logActual+" Search icon is displayed at right corner and clicked",driver);
						Thread.sleep(4000);
						
						
						
						
						
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
