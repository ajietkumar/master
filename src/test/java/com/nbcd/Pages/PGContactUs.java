package com.nbcd.Pages;
//=======================================PACKAGES=================================================================================================

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;
//=======================================CLASS & METHODS===========================================================================================

@Test
public class PGContactUs 
{
	private  WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objSelectSubject,objSelectTopic,objEmail,objconfirm_email,objTechDescription,objSubmit,objInvalidErrMsg,objRequiredErrMsg,objSucess,objSelectShow,objSelectShowSubject,objfeedback_description;
	WebElement objConInvalidErrMsg;
	
	//=================================================================================================================================================================================
	//Constructor to initialize all the Page Objects 
	public PGContactUs(WebDriver driver) throws MalformedURLException 
	{      
		this.driver = driver;
		lstTestData=db.getTestDataObject("Select * from ContactUs","Input");
		lstObject=db.getTestDataObject("Select * from ContactUs","ObjectRepository"); 
					
					
		}
	
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
	@Test
	  public PGContactUs CreateContactUsRequest_1567( ) throws Exception 
	  {
		
		//Launching Browser with valid URL.
		     driver.get(lstTestData.get(0));
		     Extent_Reports.executionLog("PASS","Excpected:Browser should Launch for Contact Us page"+ "\n"+"Actal:Browser Launched succesfully for Contact Us page",driver);
		
		//Reading Objects
		try
		 {
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Select objSelectSubject =new Select (Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1)));
			objSelectSubject.selectByIndex(1);
			Extent_Reports.executionLog("PASS","Expected: Select any subject option"+ "\n"+"Actual: Subject is selected as and  is displayed as : 'I am having a Technical Issue'",driver);
			
			Select objSelectTopic = new Select(Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4)));
			objSelectTopic.selectByIndex(1);
			Extent_Reports.executionLog("PASS","Expected: Select any Topic option"+ "\n"+"Actual: Topic is selected and is displayed as : 'I am having trouble with Live Stream'",driver);
			
			objEmail=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
			objEmail.sendKeys(lstTestData.get(5));
			Extent_Reports.executionLog("PASS","Expected: Enter Email Id"+ "\n"+"Actual: Email Id is entered and the email is :"+lstTestData.get(2),driver);
			
			objconfirm_email=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
			objconfirm_email.sendKeys(lstTestData.get(5));
			Extent_Reports.executionLog("PASS","Expected: Enter Confirm Email Id"+ "\n"+"Actual: Confirm Email Id is entered and the email is :"+lstTestData.get(2),driver);
			
			objTechDescription=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			objTechDescription.sendKeys("Techinical issue");
			Extent_Reports.executionLog("PASS","Expected: Enter Technical Description"+ "\n"+"Actual: Technical Description is entered ",driver);
			
			objSubmit=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
			objSubmit.click();
			Extent_Reports.executionLog("PASS","Expected: Click on Submit button"+ "\n"+"Actual: Submit is clicked",driver);
			
			objSucess=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
			String SucessText = objSucess.getText();
			//String a = driver.findElement(By.xpath("//div[@class='contact-page-success__success-text-inner']")).getText();
			//System.out.println(a);
			int indexSucess = SucessText.indexOf("\n");
			String SucessMsg = SucessText.substring(0, indexSucess);
			System.out.println(SucessMsg);
			if(SucessMsg.equals("SUCCESS!"))
			{
				Extent_Reports.executionLog("PASS","Expected: Sucess message should display"+ "\n"+"Actual: Sucess message is displayed as : "+SucessMsg,driver);
			}
			else
			{
				Extent_Reports.executionLog("FAIL","Expected: Sucess message should display"+ "\n"+"Actual: Sucess message is not displayed ",driver);
			}
				
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		
		//driver.close(); 
		
		return null;
	}
	//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGContactUs VerifyErrMsgInvalidEmailId_1567( ) throws Exception 
		  {
			
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     Extent_Reports.executionLog("PASS","Excpected:Browser should Launch for Contact Us page"+ "\n"+"Actual:Browser Launched succesfully for Contact Us page.",driver);
			
			//Reading Objects
			try
			 {
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Select objSelectSubject =new Select (Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1)));
				objSelectSubject.selectByIndex(1);
				Extent_Reports.executionLog("PASS","Expected: Select any subject option"+ "\n"+"Actual: Subject is selected as and  is displayed as : 'I am having a Technical Issue'",driver);
				
				Select objSelectTopic = new Select(Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4)));
				objSelectTopic.selectByIndex(1);
				Extent_Reports.executionLog("PASS","Expected: Select any Topic option"+ "\n"+"Actual: Topic is selected and is displayed as : 'I am having trouble with Live Stream'",driver);
				
				objEmail=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				objEmail.sendKeys(lstTestData.get(2));
				Extent_Reports.executionLog("PASS","Expected: Enter Email Id"+ "\n"+"Actual: Email Id is entered and the email is :"+lstTestData.get(2),driver);
				
				objconfirm_email=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				objconfirm_email.sendKeys(lstTestData.get(2));
				Extent_Reports.executionLog("PASS","Expected: Enter Confirm Email Id"+ "\n"+"Actual: Confirm Email Id is entered and the email is :"+lstTestData.get(2),driver);
				
				objTechDescription=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
				objTechDescription.sendKeys("Techinical issue");
				Extent_Reports.executionLog("PASS","Expected: Enter Technical Description"+ "\n"+"Actual: Technical Description is entered ",driver);
				
				objSubmit=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				objSubmit.click();
				Extent_Reports.executionLog("PASS","Expected: Click on Submit button"+ "\n"+"Actual: Submit is clicked",driver);
				
				objInvalidErrMsg=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
				String ErrMsg = objInvalidErrMsg.getText();
				System.out.println(objInvalidErrMsg.getCssValue("color"));
				if(ErrMsg.equals(lstTestData.get(3)))
				{
					Extent_Reports.executionLog("PASS","Expected: Invalid Error Message should display"+ "\n"+"Actual: Invalid Error Message is displayed as : "+ErrMsg,driver);
				}
				else
				{
					Extent_Reports.executionLog("PASS","Expected: Invalid Error Message should display"+ "\n"+"Actual: Invalid Error Message is not displayed correctly and displaying as : "+ErrMsg,driver);
				}
				
				objRequiredErrMsg=Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
				String ReqMsg = objRequiredErrMsg.getText();
			
				String InvalidMsgcolor = objRequiredErrMsg.getCssValue("color");
				String InvalidMsgcolor_hex[];  
				InvalidMsgcolor_hex = InvalidMsgcolor.replace("rgba(", "").split(",");       
				String ActualInvalidMsgcolor_hex = String.format("#%02x%02x%02x", Integer.parseInt(InvalidMsgcolor_hex[0].trim()), Integer.parseInt(InvalidMsgcolor_hex[1].trim()), Integer.parseInt(InvalidMsgcolor_hex[2].trim()));
				System.out.println(ActualInvalidMsgcolor_hex);
				if(ReqMsg.equals(lstTestData.get(4)))
				{
					Extent_Reports.executionLog("PASS","Expected: Required Error Message should display"+ "\n"+"Actual: Required Error Message is displayed as : "+ReqMsg,driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL","Expected: Required Error Message should display"+ "\n"+"Actual: Required Error Message is not displayed correctly and displaying as : "+ReqMsg,driver);
				}
				if(ActualInvalidMsgcolor_hex.equals("#f94646"))
				{
					Extent_Reports.executionLog("PASS","Expected: Required Error Message should display in red color"+ "\n"+"Actual: Required Error Message is displayed in red and the code is : "+ActualInvalidMsgcolor_hex,driver);
				}
				else
				{
					Extent_Reports.executionLog("FAIL","Expected: Required Error Message should display in red color"+ "\n"+"Actual: Required Error Message is not displayed redcolor and the code is : "+ActualInvalidMsgcolor_hex,driver);
				}
				//Confirm error message
				objEmail=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));			
				objEmail.clear();
				objEmail.sendKeys(lstTestData.get(5));
				Extent_Reports.executionLog("PASS","Expected: Enter Email Id"+ "\n"+"Actual: Email Id is entered and the email is :"+lstTestData.get(2),driver);
				objconfirm_email=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				objconfirm_email.clear();
				objconfirm_email.sendKeys(lstTestData.get(2));
				Extent_Reports.executionLog("PASS","Expected: Enter Confirm Email Id"+ "\n"+"Actual: Confirm Email Id is entered and the email is :"+lstTestData.get(2),driver);
				
				
				objConInvalidErrMsg=Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
				String ConErrMsg = objConInvalidErrMsg.getText();
				System.out.println(objConInvalidErrMsg.getCssValue("color"));
				if(ErrMsg.equals(lstTestData.get(3)))
				{
					Extent_Reports.executionLog("PASS","Expected: Invalid Error Message should display for Confirm Email "+ "\n"+"Actual: Invalid Error Message is displayed for Confirm Email as : "+ErrMsg,driver);
				}
				else
				{
					Extent_Reports.executionLog("PASS","Expected: Invalid Error Message should display Confirm Email "+ "\n"+"Actual: Invalid Error Message is not displayed for Confirm Email correctly and displaying as : "+ErrMsg,driver);
				}
				
				
				
			 }
			 catch(Exception exc)
			 {
				 Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
			 }
			
			driver.close(); 
			
			return null;
		}
		
		//========================================================================BUSINESS VALIDATION LOGIC=================================================
		@Test
		  public PGContactUs CreateContactUsRequestIhaveFeedback_1528( ) throws Exception 
		  {
			
			//Launching Browser with valid URL.
			     driver.get(lstTestData.get(0));
			     try {
					Extent_Reports.executionLog("PASS","Excpected:Browser should Launch for Contact Us page"+ "\n"+"Actual:Browser Launched succesfully for Contact Us page",driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			//Reading Objects
			try
			 {
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Select objSelectSubject =new Select (Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1)));
				objSelectSubject.selectByIndex(2);
				Extent_Reports.executionLog("PASS","Expected: Select any subject option"+ "\n"+"Actual: Subject is selected as and  is displayed as : 'I have feedback on NBC Programming'",driver);
				
				Select objSelectShow = new Select(Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28)));
				objSelectShow.selectByIndex(1);
				Extent_Reports.executionLog("PASS","Expected: Select any Topic option"+ "\n"+"Actual: Topic is selected and is displayed as : '30 Rock'",driver);
				
				Select objSelectShowSubject = new Select(Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31)));
				objSelectShowSubject.selectByIndex(1);
				Extent_Reports.executionLog("PASS","Expected: Select any Topic option"+ "\n"+"Actual: Topic is selected and is displayed as : 'I have a Comment or Suggestion'",driver);
				
				objEmail=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
				objEmail.sendKeys(lstTestData.get(5));
				Extent_Reports.executionLog("PASS","Expected: Enter Email Id"+ "\n"+"Actual: Email Id is entered and the email is :"+lstTestData.get(2),driver);
				
				objconfirm_email=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
				objconfirm_email.sendKeys(lstTestData.get(5));
				Extent_Reports.executionLog("PASS","Expected: Enter Confirm Email Id"+ "\n"+"Actual: Confirm Email Id is entered and the email is :"+lstTestData.get(2),driver);
				
				objfeedback_description=Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
				objfeedback_description.sendKeys("feedback_description");
				Extent_Reports.executionLog("PASS","Expected: Enter Technical Description"+ "\n"+"Actual: Technical Description is entered ",driver);
				
				objSubmit=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
				objSubmit.click();
				Extent_Reports.executionLog("PASS","Expected: Click on Submit button"+ "\n"+"Actual: Submit is clicked",driver);
				
				objSucess=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
				String SucessText = objSucess.getText();
				//String a = driver.findElement(By.xpath("//div[@class='contact-page-success__success-text-inner']")).getText();
				//System.out.println(a);
				int indexSucess = SucessText.indexOf("\n");
				String SucessMsg = SucessText.substring(0, indexSucess);
				System.out.println(SucessMsg);
				if(SucessMsg.equals("SUCCESS!"))
				{
					Extent_Reports.executionLog("PASS","Expected: Sucess message should display"+ "\n"+"Actual: Sucess message is displayed as : "+SucessMsg,driver);
				}
				else
				{
					Extent_Reports.executionLog("PASS","Expected: Sucess message should display"+ "\n"+"Actual: Sucess message is not displayed ",driver);
				}
					
			 }
			 catch(Exception exc)
			 {
				 Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
			 }
			
			driver.close(); 
			
			return null;
		}
		
		//========================================================================BUSINESS VALIDATION LOGIC=================================================
				@Test
				  public PGContactUs VerifySelectTopicListItems_1842( ) throws Exception 
				  {
					
					//Launching Browser with valid URL.
					     driver.get(lstTestData.get(0));
					     //Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "juhy" +Extent_Reports.logActual +"likuj"); 
					     Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Browser should Launch for Contact Us page"+ Extent_Reports.logActual+"Browser Launched succesfully for Contact Us page", driver);
					     
					//Reading Objects
					try
					 {
						
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						Select objSelectSubject =new Select (Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1)));
						objSelectSubject.selectByIndex(1);
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Select any subject option"+ Extent_Reports.logActual+" Subject is selected as and  is displayed as : 'I am having a Technical Issue'", driver);
						
						String ListItemsText = null;
						String ListItemsTexts = null;
						String ListItemOptions;
						Select objSelectTopic = new Select(Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4)));
						List<WebElement> ListItems = objSelectTopic.getOptions();
						System.out.println(ListItems.size());
						for (int j = 0; j < ListItems.size(); j++) {
					      System.out.println(ListItems.get(j).getText());
					      ListItemsText = ListItems.get(j).getText();
					      ListItemsTexts = ListItemsTexts +";"+ListItemsText;
					    }
						System.out.println(ListItemsTexts);
						ListItemsTexts.substring(4, ListItemsTexts.length()-1);
						ListItemOptions = ListItemsTexts.substring(5, ListItemsTexts.length()-1);
						if(ListItemOptions.equalsIgnoreCase(lstTestData.get(6)))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Select Topic list should match "+Extent_Reports.logActual+"Select Topic List is matching and the list items are  :"+ListItemOptions, driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL","Expected: Select Topic list should match "+ Extent_Reports.logActual+"Select Topic List is not matching and the list items are  :"+ListItemOptions, driver);
						}
						objSelectTopic.selectByIndex(1);
						
						objEmail=Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
						objEmail.sendKeys(lstTestData.get(5));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Email Id"+ Extent_Reports.logActual+" Email Id is entered and the email is :"+lstTestData.get(2), driver);
						
						objconfirm_email=Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
						objconfirm_email.sendKeys(lstTestData.get(5));
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Confirm Email Id"+Extent_Reports.logActual+"Confirm Email Id is entered and the email is :"+lstTestData.get(2), driver);
						
						objTechDescription=Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
						objTechDescription.sendKeys("Techinical issue");
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Technical Description"+Extent_Reports.logActual+" Technical Description is entered ", driver);
						
						objSubmit=Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
						objSubmit.click();
						Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+" Click on Submit button"+Extent_Reports.logActual+" Submit is clicked", driver);
						
						objSucess=Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
						String SucessText = objSucess.getText();
						//String a = driver.findElement(By.xpath("//div[@class='contact-page-success__success-text-inner']")).getText();
						//System.out.println(a);
						int indexSucess = SucessText.indexOf("\n");
						String SucessMsg = SucessText.substring(0, indexSucess);
						System.out.println(SucessMsg);
						if(SucessMsg.equals("SUCCESS!"))
						{
							Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Sucess message should display"+ Extent_Reports.logActual+" Sucess message is displayed as : "+SucessMsg, driver);
						}
						else
						{
							Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Sucess message should display"+Extent_Reports.logActual+" Sucess message is not displayed ", driver);
						}
							
					 }
					 catch(Exception exc)
					 {
						 Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);
					 }
					
					driver.close(); 
					
					return null;
				}
}
