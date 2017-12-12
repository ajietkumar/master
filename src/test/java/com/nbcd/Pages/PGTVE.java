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
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;
@Test
//=======================================CLASS & METHODS===========================================================================================

public class PGTVE 
{
	
	private  WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objnav,objRespNavBar;
	//=================================================Business Logic====================================================================
	//Constructor to initialize all the Page Objects  
	
	public PGTVE(WebDriver driver) throws MalformedURLException 
	{      
		
		this.driver = driver; 
		lstTestData=db.getTestDataObject("Select * from TVE","Input");
		lstObject=db.getTestDataObject("Select * from TVE","ObjectRepository");
	
	}
	
	//=========================================================================================================================
@Test
	public  PGTVE Authvod() throws Exception 
	{
   	 //Launching the URL
       
       		driver.get(lstTestData.get(0));
	       	WebElement objnav =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
	       	objnav.click();
	       	WebElement objshwnav =Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
	       	objshwnav.click();
	        WebDriverWait wait= new WebDriverWait(driver,60);
	       	wait.until(ExpectedConditions.urlContains("https://www.nbc.com/this-is-us"));
	  	    Synchronization.waitForPageLoad(driver);
		
		
			List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(11),lstObject.get(10));
			objloadbutton.get(0).click();
			Synchronization.waitForPageLoad(driver);
	       	List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
			wait.until(ExpectedConditions.visibilityOf(objauthcode.get(0)));
			Synchronization.waitForPageLoad(driver);
			if(objauthcode.size()>0)
			{
				objauthcode.get(0).click();
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked", driver);
				
			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video", driver);
				//driver.close();
			}
			Synchronization.waitForPageLoad(driver);
	       	List <WebElement> objTVProvider = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
			objTVProvider.get(1).click();	
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked", driver);
			
		///Optimum
			WebElement objOptinium = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
			wait.until(ExpectedConditions.visibilityOf(objOptinium));
			objOptinium.click();
			
			String ParentWindow = driver.getWindowHandle();
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> nWindow= s1.iterator();
			while(nWindow.hasNext()){
				String childWindow = nWindow.next();
				driver.switchTo().window(childWindow);
			}
			Synchronization.waitForPageLoad(driver);
			wait.until(ExpectedConditions.urlContains("https://idp.optimum.net/idp.optimum.net/SSOPOST/metaAlias/realm4/idpv2"));
       	
			WebElement objUserName = Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
			wait.until(ExpectedConditions.visibilityOf(objUserName));
			objUserName.sendKeys("research1000");		
			WebElement objPassword = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
			objPassword.sendKeys("support1000");
			
			WebElement objSignIn = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
			objSignIn.click();
				
			driver.switchTo().window(ParentWindow);     
			Synchronization.waitForPageLoad(driver);

			WebElement objlogo1 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo1));
			Synchronization.waitForPageLoad(driver);
			objlogo1.click();
			WebElement objunlink1 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			wait.until(ExpectedConditions.visibilityOf(objunlink1));
			objunlink1.click();
		
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			Synchronization.waitForPageLoad(driver);
			List <WebElement> objTVProvider1 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider1.get(1)));
			objTVProvider1.get(1).click();	
			WebElement objxfinity = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
			wait.until(ExpectedConditions.visibilityOf(objxfinity));
			objxfinity.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider xfinity should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked", driver);
			String ParentWindow1 = driver.getWindowHandle();
			Set<String> s2=driver.getWindowHandles();
			Iterator<String> nWindow1= s2.iterator();
			while(nWindow1.hasNext()){
				String childWindow1 = nWindow1.next();
				driver.switchTo().window(childWindow1);
			}
			Synchronization.waitForPageLoad(driver);
			WebElement objUserName1 = Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
			wait.until(ExpectedConditions.visibilityOf(objUserName1));
			objUserName1.sendKeys("DEN-CSG-TVE2");
		
			WebElement objPassword1 = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
			objPassword1.sendKeys("HostClip4");
		
			WebElement objSignIn1 = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
			objSignIn1.click();
			driver.switchTo().window(ParentWindow1);   
		
		////dtv
			Synchronization.waitForPageLoad(driver);

			WebElement objlogo2 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo2));
			objlogo2.click();
			WebElement objunlink2 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			wait.until(ExpectedConditions.visibilityOf(objunlink2));
			objunlink2.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider2 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider2.get(1)));
			objTVProvider2.get(1).click();			
	
			WebElement objdtv = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
			wait.until(ExpectedConditions.visibilityOf(objdtv));
			objdtv.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct Tv should be clicked"+Extent_Reports.logActual+"TV provider Direct Tv is clicked", driver);
			Synchronization.waitForPageLoad(driver);
	
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName2 = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
			wait.until(ExpectedConditions.visibilityOf(objUserName2));
			objUserName2.sendKeys("nbcu_np@directv.com");
			WebElement objPassword2 = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
			objPassword2.sendKeys("password");
			WebElement objSignIn2 = Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
			objSignIn2.click();
			Synchronization.waitForPageLoad(driver);
	
		//WebElement objlogo3 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
		//objlogo3.click();
		//WebElement objunlink3 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
		//objunlink3.click();
		//Thread.sleep(8000);
		//driver.navigate().refresh();
		//List <WebElement> objTVProvider3 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
		//wait.until(ExpectedConditions.visibilityOf(objTVProvider3.get(1)));
		//objTVProvider3.get(1).click();			
		//WebElement objdish = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
		//wait.until(ExpectedConditions.visibilityOf(objdish));
		//objdish.click();
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Dishtv should be clicked"+Extent_Reports.logActual+"TV provider Dishtv is clicked");
		//String ParentWindow2 = driver.getWindowHandle();
		//Set<String> s3=driver.getWindowHandles();
		//Iterator<String> nWindow2= s3.iterator();
		//while(nWindow2.hasNext()){
		//String childWindow2 = nWindow2.next();
		//driver.switchTo().window(childWindow2);
//		}
		//Thread.sleep(12000);

		//WebElement objUserName3 = Utilities.returnElement(driver,lstObject.get(92),lstObject.get(91));
		//wait.until(ExpectedConditions.visibilityOf(objUserName3));
		//objUserName3.sendKeys("DishProgNY");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		//WebElement objPassword3 = Utilities.returnElement(driver,lstObject.get(95),lstObject.get(94));
		//objPassword3.sendKeys("Dish123p");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		//WebElement objSignIn3= Utilities.returnElement(driver,lstObject.get(98),lstObject.get(97));
		//objSignIn3.click();
		//System.out.println("yyw");
		//driver.switchTo().window(ParentWindow2);  
		//Thread.sleep(8000);
		//System.out.println("twc");
		//twc
		
			WebElement objlogo4 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			objlogo4.click();
			WebElement objunlink4 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink4.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider22 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider22.get(1)));
			objTVProvider22.get(1).click();
			WebElement objtwc = Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
			wait.until(ExpectedConditions.visibilityOf(objtwc));
			objtwc.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider TWC should be clicked"+Extent_Reports.logActual+"TV provider twc Tv is clicked", driver);
			Synchronization.waitForPageLoad(driver);
			//WebElement objtwcclk = Utilities.returnElement(driver,lstObject.get(197),lstObject.get(196));
		//wait.until(ExpectedConditions.visibilityOf(objtwcclk));
		//objtwcclk.click();
		
			driver.switchTo().frame("mvpdframe");		
			WebElement objUserName4 = Utilities.returnElement(driver,lstObject.get(101),lstObject.get(100));
			wait.until(ExpectedConditions.visibilityOf(objUserName4));
			objUserName4.sendKeys("tve051");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		
			WebElement objPassword4 = Utilities.returnElement(driver,lstObject.get(104),lstObject.get(103));
			objPassword4.sendKeys("aB3s9TaF");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		
			WebElement objSignIn4 = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
			objSignIn4.click();
			Synchronization.waitForPageLoad(driver);
			WebElement objlogo5 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo5));
			objlogo5.click();
			WebElement objunlink5 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink5.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider5 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider5.get(1)));
			objTVProvider5.get(1).click();		
			
			WebElement objveri = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
			wait.until(ExpectedConditions.visibilityOf(objveri));
			objveri.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider verizon  should be clicked"+Extent_Reports.logActual+"TV provider verizon Tv is clicked", driver);

			String ParentWindow3 = driver.getWindowHandle();
			Set<String> s4=driver.getWindowHandles();
			Iterator<String> nWindow3= s4.iterator();
			while(nWindow3.hasNext()){
				String childWindow3 = nWindow3.next();
				driver.switchTo().window(childWindow3);
			}
			Synchronization.waitForPageLoad(driver);
			WebElement objUserName5 = Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));
			wait.until(ExpectedConditions.visibilityOf(objUserName5));
			objUserName5.sendKeys("vzec6mg8");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		
			WebElement objPassword5 = Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
			objPassword5.sendKeys("bizc_123");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		
			WebElement objSignIn5= Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
			objSignIn5.click();
			driver.switchTo().window(ParentWindow3);
			Synchronization.waitForPageLoad(driver);

			WebElement objlogo6 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo6));
			objlogo6.click();
			WebElement objunlink6 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink6.click();
			Thread.sleep(8000);
			driver.navigate().refresh();
			List <WebElement> objTVProvider6 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider6.get(1)));
			objTVProvider6.get(1).click();		
			
			WebElement objatt = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
			wait.until(ExpectedConditions.visibilityOf(objatt));
			objatt.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider att  should be clicked"+Extent_Reports.logActual+"TV provider att Tv is clicked", driver);

			String ParentWindow4 = driver.getWindowHandle();
			Set<String> s5=driver.getWindowHandles();
			Iterator<String> nWindow4= s5.iterator();
			while(nWindow4.hasNext()){
				String childWindow4 = nWindow4.next();
				driver.switchTo().window(childWindow4);
			}
			Synchronization.waitForPageLoad(driver);
			//WebElement objchspecclk = Utilities.returnElement(driver,lstObject.get(203),lstObject.get(202));
			//wait.until(ExpectedConditions.visibilityOf(objchspecclk));
			//objchspecclk.click();
			//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName6 = Utilities.returnElement(driver,lstObject.get(119),lstObject.get(118));
			wait.until(ExpectedConditions.visibilityOf(objUserName6));
			objUserName6.sendKeys("uvsmobile@att.net");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			
			WebElement objPassword6 = Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
			objPassword6.sendKeys("att123");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			
			WebElement objSignIn6= Utilities.returnElement(driver,lstObject.get(126),lstObject.get(124));
			objSignIn6.click();
			driver.switchTo().window(ParentWindow4);
			Synchronization.waitForPageLoad(driver);
		
		
		
		///charterspec 
	    
			WebElement objlogo8 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo8));
			objlogo8.click();
			WebElement objunlink8 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink8.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider8 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider8.get(1)));
			objTVProvider8.get(1).click();			
			WebElement objchaspec = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
			wait.until(ExpectedConditions.visibilityOf(objchaspec));
			objchaspec.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider CharterSpectrum  should be clicked"+Extent_Reports.logActual+"TV provider CharterSpectrum Tv is clicked", driver);
	
			String ParentWindow6 = driver.getWindowHandle();
			Set<String> s7=driver.getWindowHandles();
			Iterator<String> nWindow6= s7.iterator();
			while(nWindow6.hasNext()){
				String childWindow6 = nWindow6.next();
				driver.switchTo().window(childWindow6);
			}
			Synchronization.waitForPageLoad(driver);
		//WebElement objchspecclk = Utilities.returnElement(driver,lstObject.get(203),lstObject.get(202));
		//wait.until(ExpectedConditions.visibilityOf(objchspecclk));
		//objchspecclk.click();
		//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName8 = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
			wait.until(ExpectedConditions.visibilityOf(objUserName8));
			objUserName8.sendKeys("different30");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		
			WebElement objPassword8 = Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			objPassword8.sendKeys("Testing01");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		
			WebElement objSignIn8= Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			objSignIn8.click();
			driver.switchTo().window(ParentWindow6);
			Synchronization.waitForPageLoad(driver);

			System.out.println("bri");
		////brighthouse spec
		
			WebElement objlogo9 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo9));
			objlogo9.click();
			WebElement objunlink9 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink9.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider9 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider9.get(1)));
			objTVProvider9.get(1).click();			
			WebElement objbhspec = Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
			wait.until(ExpectedConditions.visibilityOf(objbhspec));
			objbhspec.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider BrightHouse Spectrum Tv should be clicked"+Extent_Reports.logActual+"TV provider BrightHouse Spectrum Tv is clicked", driver);

			String ParentWindow7 = driver.getWindowHandle();
			Set<String> s8=driver.getWindowHandles();
			Iterator<String> nWindow7= s8.iterator();
			while(nWindow7.hasNext()){
				String childWindow7 = nWindow7.next();
				driver.switchTo().window(childWindow7);
			}
			Synchronization.waitForPageLoad(driver);
			//WebElement objbhcclk = Utilities.returnElement(driver,lstObject.get(212),lstObject.get(211));
		//wait.until(ExpectedConditions.visibilityOf(objbhcclk));
		//objbhcclk.click();
		//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName9 = Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
			wait.until(ExpectedConditions.visibilityOf(objUserName9));
			objUserName9.sendKeys("qatest14");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		
			WebElement objPassword9 = Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
			objPassword9.sendKeys("password1");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		
			WebElement objSignIn9= Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151));
			objSignIn9.click();
			driver.switchTo().window(ParentWindow7);
			Synchronization.waitForPageLoad(driver);
			//suddenlink		
		
			WebElement objlogo10 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo10));
			objlogo10.click();
			WebElement objunlink10 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink10.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider10 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider10.get(1)));
			objTVProvider10.get(1).click();			
			WebElement objsdnlnk = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
			wait.until(ExpectedConditions.visibilityOf(objsdnlnk));
			objsdnlnk.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider suddenlink Tv should be clicked"+Extent_Reports.logActual+"TV provider suddenlink Tv is clicked", driver);

			String ParentWindow8 = driver.getWindowHandle();
			Set<String> s9=driver.getWindowHandles();
			Iterator<String> nWindow8= s9.iterator();
			while(nWindow8.hasNext()){
				String childWindow8 = nWindow8.next();
				driver.switchTo().window(childWindow8);
			}
			Synchronization.waitForPageLoad(driver);
	//		wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName10 = Utilities.returnElement(driver,lstObject.get(155),lstObject.get(154));
	
			Synchronization.explicitWait(driver,objUserName10,"visible");
			objUserName10.sendKeys("allprem_test_5");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			
			WebElement objPassword10 = Utilities.returnElement(driver,lstObject.get(158),lstObject.get(157));
			objPassword10.sendKeys("test01");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			
			WebElement objSignIn10= Utilities.returnElement(driver,lstObject.get(161),lstObject.get(160));
			objSignIn10.click();
			driver.switchTo().window(ParentWindow8);
			
			Synchronization.waitForPageLoad(driver);




	System.out.println("medi");
		//mediacon
			WebElement objlogo11 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo11));
			objlogo11.click();
			WebElement objunlink11 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink11.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider11 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider11.get(1)));
			objTVProvider11.get(1).click();			
			WebElement objmedcon = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			wait.until(ExpectedConditions.visibilityOf(objmedcon));
			objmedcon.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Mediacon Tv should be clicked"+Extent_Reports.logActual+"TV provider Mediacon Tv is clicked", driver);
	
			String ParentWindow9 = driver.getWindowHandle();
			Set<String> s10=driver.getWindowHandles();
			Iterator<String> nWindow9= s10.iterator();
			while(nWindow9.hasNext()){
				String childWindow9 = nWindow9.next();
				driver.switchTo().window(childWindow9);
			}
			Synchronization.waitForPageLoad(driver);
		//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName11 = Utilities.returnElement(driver,lstObject.get(164),lstObject.get(163));
			wait.until(ExpectedConditions.visibilityOf(objUserName11));
			objUserName11.sendKeys("testbench.mediacom@mchsi.com");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			
			WebElement objPassword11 = Utilities.returnElement(driver,lstObject.get(167),lstObject.get(166));
			objPassword11.sendKeys("mediacom10");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			
			WebElement objSignIn11= Utilities.returnElement(driver,lstObject.get(170),lstObject.get(169));
			objSignIn11.click();
			driver.switchTo().window(ParentWindow9);
			Synchronization.waitForPageLoad(driver);
			System.out.println("wow");
			//wow
		
			
			WebElement objlogo13 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo13));
			objlogo13.click();
			WebElement objunlink13 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink13.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider12 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider12.get(1)));
			objTVProvider12.get(1).click();			
			WebElement objwow = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
			wait.until(ExpectedConditions.visibilityOf(objwow));
			objwow.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider wow Tv should be clicked"+Extent_Reports.logActual+"TV provider wow Tv is clicked", driver);
	
			String ParentWindow11 = driver.getWindowHandle();
			Set<String> s12=driver.getWindowHandles();
			Iterator<String> nWindow11= s12.iterator();
			while(nWindow11.hasNext()){
				String childWindow11 = nWindow11.next();
				driver.switchTo().window(childWindow11);
			}
			Synchronization.waitForPageLoad(driver);
			WebElement objwowclk = Utilities.returnElement(driver,lstObject.get(206),lstObject.get(205));
			wait.until(ExpectedConditions.visibilityOf(objwowclk));
			objwowclk.click();
		
			//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
			WebElement objUserName13 = Utilities.returnElement(driver,lstObject.get(173),lstObject.get(172));
			wait.until(ExpectedConditions.visibilityOf(objUserName13));
			objUserName13.sendKeys("digitest");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			
			WebElement objPassword13 = Utilities.returnElement(driver,lstObject.get(176),lstObject.get(175));
			objPassword13.sendKeys("0testdigi1");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			
			WebElement objSignIn13= Utilities.returnElement(driver,lstObject.get(179),lstObject.get(178));
			objSignIn13.click();
			driver.switchTo().window(ParentWindow11);
			Synchronization.waitForPageLoad(driver);
			System.out.println("rcn");
	
			Synchronization.waitForPageLoad(driver);

		//rcn 
		
			WebElement objlogo14 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			wait.until(ExpectedConditions.visibilityOf(objlogo14));
			objlogo14.click();
			WebElement objunlink14 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink14.click();
			Synchronization.waitForPageLoad(driver);
			driver.navigate().refresh();
			List <WebElement> objTVProvider14 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
			wait.until(ExpectedConditions.visibilityOf(objTVProvider14.get(1)));
			objTVProvider14.get(1).click();	
			WebElement objrcn = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
			wait.until(ExpectedConditions.visibilityOf(objrcn));
			objrcn.click();
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider RCN Tv should be clicked"+Extent_Reports.logActual+"TV provider RCN Tv is clicked");
	
			Synchronization.waitForPageLoad(driver);
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName14 = Utilities.returnElement(driver,lstObject.get(182),lstObject.get(181));
		
			Synchronization.explicitWait(driver,objUserName14,"visible");
			objUserName14.sendKeys("nbcu-all-pass");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			
			WebElement objPassword14 = Utilities.returnElement(driver,lstObject.get(185),lstObject.get(184));
			objPassword14.sendKeys("Rcn1NbcU");
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			
			WebElement objSignIn14 = Utilities.returnElement(driver,lstObject.get(188),lstObject.get(187));
			objSignIn14.click();
			Synchronization.waitForPageLoad(driver);
			
		 // driver.close();

		
		
		return null;
	   	
		  }
//==========================================================================================================
@Test
public  PGTVE Livepagetve() throws Exception 
	  {
	 //Launching the URL
   	{
   	 driver.get(lstTestData.get(0));
   	WebElement objnav =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
   	objnav.click();
   	WebElement objLivenav =Utilities.returnElement(driver,lstObject.get(191),lstObject.get(190));
   	objLivenav.click();
    WebDriverWait wait= new WebDriverWait(driver,60);
   	wait.until(ExpectedConditions.urlContains("https://www.nbc.com/live"));
   	List <WebElement> objTVProvider = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
	objTVProvider.get(1).click();	
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked",driver);
	
	///Optimum
	WebElement objOptinium = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
	wait.until(ExpectedConditions.visibilityOf(objOptinium));
	objOptinium.click();
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Optimum should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked");
	
	String ParentWindow = driver.getWindowHandle();
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> nWindow= s1.iterator();
	while(nWindow.hasNext()){
		String childWindow = nWindow.next();
		driver.switchTo().window(childWindow);
	}
	Synchronization.waitForPageLoad(driver);

   	wait.until(ExpectedConditions.urlContains("https://idp.optimum.net/idp.optimum.net/SSOPOST/metaAlias/realm4/idpv2"));
   	
	WebElement objUserName = Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
	wait.until(ExpectedConditions.visibilityOf(objUserName));
	objUserName.sendKeys("research1000");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
	objPassword.sendKeys("support1000");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
	objSignIn.click();
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"SignIn should be Clicked"+Extent_Reports.logActual+"SignIn is Clicked");
	
	driver.switchTo().window(ParentWindow);     
	System.out.println("xfi");
//xfi


	Synchronization.waitForPageLoad(driver);

	WebElement objlogo1 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo1));
	
	objlogo1.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink1 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	wait.until(ExpectedConditions.visibilityOf(objunlink1));
	objunlink1.click();
	System.out.println("yup");
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	
	List <WebElement> objTVProvider1 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider1.get(1)));
	objTVProvider1.get(1).click();	
	WebElement objxfinity = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
	wait.until(ExpectedConditions.visibilityOf(objxfinity));
	objxfinity.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider xfinity should be clicked"+Extent_Reports.logActual+"TV provider optimum is clicked", driver);
	System.out.println("yup2");
	String ParentWindow1 = driver.getWindowHandle();
	Set<String> s2=driver.getWindowHandles();
	Iterator<String> nWindow1= s2.iterator();
	while(nWindow1.hasNext()){
		String childWindow1 = nWindow1.next();
		driver.switchTo().window(childWindow1);
	}
	
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName1 = Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
	wait.until(ExpectedConditions.visibilityOf(objUserName1));
	objUserName1.sendKeys("DEN-CSG-TVE2");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword1 = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
	objPassword1.sendKeys("HostClip4");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn1 = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
	objSignIn1.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow1);   
	System.out.println("yup3");
	////dtv
	

	WebElement objlogo2 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo2));
	objlogo2.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink2 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	wait.until(ExpectedConditions.visibilityOf(objunlink2));
	objunlink2.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider2 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider2.get(1)));
	objTVProvider2.get(1).click();			

	WebElement objdtv = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
	wait.until(ExpectedConditions.visibilityOf(objdtv));
	objdtv.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct Tv should be clicked"+Extent_Reports.logActual+"TV provider Direct Tv is clicked", driver);
	Synchronization.waitForPageLoad(driver);
//WebElement objdtvclk = Utilities.returnElement(driver,lstObject.get(209),lstObject.get(208));
	//wait.until(ExpectedConditions.visibilityOf(objdtvclk));
	//objdtvclk.click();
	driver.switchTo().frame("mvpdframe");
	WebElement objUserName2 = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
	wait.until(ExpectedConditions.visibilityOf(objUserName2));
	objUserName2.sendKeys("nbcu_np@directv.com");
//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword2 = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
	objPassword2.sendKeys("password");
//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn2 = Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
	objSignIn2.click();
	Synchronization.waitForPageLoad(driver);
	System.out.println("dish");
	///dish
	

	//WebElement objlogo3 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	//objlogo3.click();
	//WebElement objunlink3 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	//objunlink3.click();
	//Thread.sleep(8000);
	//driver.navigate().refresh();
	//List <WebElement> objTVProvider3 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	//wait.until(ExpectedConditions.visibilityOf(objTVProvider3.get(1)));
	//objTVProvider3.get(1).click();			
	//WebElement objdish = Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
	//wait.until(ExpectedConditions.visibilityOf(objdish));
	//objdish.click();
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Dishtv should be clicked"+Extent_Reports.logActual+"TV provider Dishtv is clicked");
	//String ParentWindow2 = driver.getWindowHandle();
	//Set<String> s3=driver.getWindowHandles();
	//Iterator<String> nWindow2= s3.iterator();
	//while(nWindow2.hasNext()){
	//String childWindow2 = nWindow2.next();
	//driver.switchTo().window(childWindow2);
//	}
	//Thread.sleep(12000);

	//WebElement objUserName3 = Utilities.returnElement(driver,lstObject.get(92),lstObject.get(91));
	//wait.until(ExpectedConditions.visibilityOf(objUserName3));
	//objUserName3.sendKeys("DishProgNY");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	//WebElement objPassword3 = Utilities.returnElement(driver,lstObject.get(95),lstObject.get(94));
	//objPassword3.sendKeys("Dish123p");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	//WebElement objSignIn3= Utilities.returnElement(driver,lstObject.get(98),lstObject.get(97));
	//objSignIn3.click();
	//System.out.println("yyw");
	//driver.switchTo().window(ParentWindow2);  
	//Thread.sleep(8000);
	//System.out.println("twc");
	//twc
	
	WebElement objlogo4 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	objlogo4.click();
	WebElement objunlink4 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink4.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider22 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider22.get(1)));
	objTVProvider22.get(1).click();
	WebElement objtwc = Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
	wait.until(ExpectedConditions.visibilityOf(objtwc));
	objtwc.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider TWC should be clicked"+Extent_Reports.logActual+"TV provider twc Tv is clicked", driver);

	
	Synchronization.waitForPageLoad(driver);
	//WebElement objtwcclk = Utilities.returnElement(driver,lstObject.get(197),lstObject.get(196));
	//wait.until(ExpectedConditions.visibilityOf(objtwcclk));
	//objtwcclk.click();
	
	driver.switchTo().frame("mvpdframe");		
	WebElement objUserName4 = Utilities.returnElement(driver,lstObject.get(101),lstObject.get(100));
	wait.until(ExpectedConditions.visibilityOf(objUserName4));
	objUserName4.sendKeys("tve051");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword4 = Utilities.returnElement(driver,lstObject.get(104),lstObject.get(103));
	objPassword4.sendKeys("aB3s9TaF");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn4 = Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
	objSignIn4.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objlogo5 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo5));
	objlogo5.click();
	WebElement objunlink5 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink5.click();
	Thread.sleep(8000);
	driver.navigate().refresh();
	List <WebElement> objTVProvider5 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider5.get(1)));
	objTVProvider5.get(1).click();		
	
	WebElement objveri = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
	wait.until(ExpectedConditions.visibilityOf(objveri));
	objveri.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider verizon  should be clicked"+Extent_Reports.logActual+"TV provider verizon Tv is clicked", driver);

	String ParentWindow3 = driver.getWindowHandle();
	Set<String> s4=driver.getWindowHandles();
	Iterator<String> nWindow3= s4.iterator();
	while(nWindow3.hasNext()){
		String childWindow3 = nWindow3.next();
		driver.switchTo().window(childWindow3);
	}
	
	//WebElement objchspecclk = Utilities.returnElement(driver,lstObject.get(203),lstObject.get(202));
	//wait.until(ExpectedConditions.visibilityOf(objchspecclk));
	//objchspecclk.click();
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName5 = Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));
	wait.until(ExpectedConditions.visibilityOf(objUserName5));
	objUserName5.sendKeys("vzec6mg8");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword5 = Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
	objPassword5.sendKeys("bizc_123");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn5= Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
	objSignIn5.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow3);
	
	    System.out.println("veri");
		WebElement objlogo6 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
		wait.until(ExpectedConditions.visibilityOf(objlogo6));
		objlogo6.click();
		WebElement objunlink6 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
		objunlink6.click();
		Synchronization.waitForPageLoad(driver);
		driver.navigate().refresh();
		List <WebElement> objTVProvider6 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
		wait.until(ExpectedConditions.visibilityOf(objTVProvider6.get(1)));
		objTVProvider6.get(1).click();		
		
		WebElement objatt = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
		wait.until(ExpectedConditions.visibilityOf(objatt));
		objatt.click();
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider att  should be clicked"+Extent_Reports.logActual+"TV provider att Tv is clicked", driver);
		Synchronization.waitForPageLoad(driver);
		String ParentWindow4 = driver.getWindowHandle();
		Set<String> s5=driver.getWindowHandles();
		Iterator<String> nWindow4= s5.iterator();
		while(nWindow4.hasNext()){
			String childWindow4 = nWindow4.next();
			driver.switchTo().window(childWindow4);
		}
		
		//WebElement objchspecclk = Utilities.returnElement(driver,lstObject.get(203),lstObject.get(202));
		//wait.until(ExpectedConditions.visibilityOf(objchspecclk));
		//objchspecclk.click();
		//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
		WebElement objUserName6 = Utilities.returnElement(driver,lstObject.get(119),lstObject.get(118));
		wait.until(ExpectedConditions.visibilityOf(objUserName6));
		objUserName6.sendKeys("uvsmobile@att.net");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
		
		WebElement objPassword6 = Utilities.returnElement(driver,lstObject.get(122),lstObject.get(121));
		objPassword6.sendKeys("att123");
		//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
		
		WebElement objSignIn6= Utilities.returnElement(driver,lstObject.get(126),lstObject.get(124));
		objSignIn6.click();
		Synchronization.waitForPageLoad(driver);
		driver.switchTo().window(ParentWindow4);
		
	
	
	
	///charterspec 
    
	WebElement objlogo8 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo8));
	objlogo8.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink8 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink8.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider8 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider8.get(1)));
	objTVProvider8.get(1).click();			
	WebElement objchaspec = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
	wait.until(ExpectedConditions.visibilityOf(objchaspec));
	objchaspec.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider CharterSpectrum  should be clicked"+Extent_Reports.logActual+"TV provider CharterSpectrum Tv is clicked", driver);
	Synchronization.waitForPageLoad(driver);
	String ParentWindow6 = driver.getWindowHandle();
	Set<String> s7=driver.getWindowHandles();
	Iterator<String> nWindow6= s7.iterator();
	while(nWindow6.hasNext()){
		String childWindow6 = nWindow6.next();
		driver.switchTo().window(childWindow6);
	}

	//WebElement objchspecclk = Utilities.returnElement(driver,lstObject.get(203),lstObject.get(202));
	//wait.until(ExpectedConditions.visibilityOf(objchspecclk));
	//objchspecclk.click();
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName8 = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));
	wait.until(ExpectedConditions.visibilityOf(objUserName8));
	objUserName8.sendKeys("different30");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword8 = Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
	objPassword8.sendKeys("Testing01");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn8= Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
	objSignIn8.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow6);
	

	System.out.println("bri");
	////brighthouse spec
	
	WebElement objlogo9 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo9));
	objlogo9.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink9 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink9.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider9 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider9.get(1)));
	objTVProvider9.get(1).click();			
	WebElement objbhspec = Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
	wait.until(ExpectedConditions.visibilityOf(objbhspec));
	objbhspec.click();
	Synchronization.waitForPageLoad(driver);
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider BrightHouse Spectrum Tv should be clicked"+Extent_Reports.logActual+"TV provider BrightHouse Spectrum Tv is clicked", driver);

	String ParentWindow7 = driver.getWindowHandle();
	Set<String> s8=driver.getWindowHandles();
	Iterator<String> nWindow7= s8.iterator();
	while(nWindow7.hasNext()){
		String childWindow7 = nWindow7.next();
		driver.switchTo().window(childWindow7);
	}
	
	//WebElement objbhcclk = Utilities.returnElement(driver,lstObject.get(212),lstObject.get(211));
	//wait.until(ExpectedConditions.visibilityOf(objbhcclk));
	//objbhcclk.click();
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName9 = Utilities.returnElement(driver,lstObject.get(146),lstObject.get(145));
	wait.until(ExpectedConditions.visibilityOf(objUserName9));
	objUserName9.sendKeys("qatest14");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword9 = Utilities.returnElement(driver,lstObject.get(149),lstObject.get(148));
	objPassword9.sendKeys("password1");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn9= Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151));
	objSignIn9.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow7);
	
	System.out.println("sudden");
	//suddenlink		
	
	WebElement objlogo10 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo10));
	objlogo10.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink10 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink10.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider10 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider10.get(1)));
	objTVProvider10.get(1).click();	
	Synchronization.waitForPageLoad(driver);
	WebElement objsdnlnk = Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
	wait.until(ExpectedConditions.visibilityOf(objsdnlnk));
	objsdnlnk.click();
	Synchronization.waitForPageLoad(driver);
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider suddenlink Tv should be clicked"+Extent_Reports.logActual+"TV provider suddenlink Tv is clicked", driver);

	String ParentWindow8 = driver.getWindowHandle();
	Set<String> s9=driver.getWindowHandles();
	Iterator<String> nWindow8= s9.iterator();
	while(nWindow8.hasNext()){
		String childWindow8 = nWindow8.next();
		driver.switchTo().window(childWindow8);
	}
	
//	wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName10 = Utilities.returnElement(driver,lstObject.get(155),lstObject.get(154));
	wait.until(ExpectedConditions.visibilityOf(objUserName10));
	objUserName10.sendKeys("allprem_test_5");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword10 = Utilities.returnElement(driver,lstObject.get(158),lstObject.get(157));
	objPassword10.sendKeys("test01");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn10= Utilities.returnElement(driver,lstObject.get(161),lstObject.get(160));
	objSignIn10.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow8);
	
	
	WebElement objlogo11 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo11));
	objlogo11.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink11 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink11.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider11 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider11.get(1)));
	objTVProvider11.get(1).click();			
	WebElement objmedcon = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
	wait.until(ExpectedConditions.visibilityOf(objmedcon));
	objmedcon.click();
	Synchronization.waitForPageLoad(driver);
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Mediacon Tv should be clicked"+Extent_Reports.logActual+"TV provider Mediacon Tv is clicked", driver);

	String ParentWindow9 = driver.getWindowHandle();
	Set<String> s10=driver.getWindowHandles();
	Iterator<String> nWindow9= s10.iterator();
	while(nWindow9.hasNext()){
		String childWindow9 = nWindow9.next();
		driver.switchTo().window(childWindow9);
	}
	
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName11 = Utilities.returnElement(driver,lstObject.get(164),lstObject.get(163));
	wait.until(ExpectedConditions.visibilityOf(objUserName11));
	objUserName11.sendKeys("testbench.mediacom@mchsi.com");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword11 = Utilities.returnElement(driver,lstObject.get(167),lstObject.get(166));
	objPassword11.sendKeys("mediacom10");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn11= Utilities.returnElement(driver,lstObject.get(170),lstObject.get(169));
	objSignIn11.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow9);
	
	System.out.println("wow");
	//wow
	
	
	WebElement objlogo13 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo13));
	objlogo13.click();
	WebElement objunlink13 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink13.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider12 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider12.get(1)));
	objTVProvider12.get(1).click();		
	Synchronization.waitForPageLoad(driver);
	WebElement objwow = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
	wait.until(ExpectedConditions.visibilityOf(objwow));
	objwow.click();
	Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider wow Tv should be clicked"+Extent_Reports.logActual+"TV provider wow Tv is clicked");

	String ParentWindow11 = driver.getWindowHandle();
	Set<String> s12=driver.getWindowHandles();
	Iterator<String> nWindow11= s12.iterator();
	while(nWindow11.hasNext()){
		String childWindow11 = nWindow11.next();
		driver.switchTo().window(childWindow11);
	}
	
	WebElement objwowclk = Utilities.returnElement(driver,lstObject.get(206),lstObject.get(205));
	wait.until(ExpectedConditions.visibilityOf(objwowclk));
	objwowclk.click();
	Synchronization.waitForPageLoad(driver);
	//wait.until(ExpectedConditions.urlContains("https://login.comcast.net/login?r=comcast.net&s=oauth&continue=https%3A%2F%2Foauth.xfinity.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fsp.auth.adobe.com%2Fadobe-services%2Foauth2%26state%3DsrwNzy%26scope%3Dopenid%2520profile%2520https%3A%2F%2Flogin.comcast.net%2Fpdp%2Ftve%26client_id%3Dadobepass-nbcentertainment%26acr_values%3Durn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Aac%3Aclasses%3AInternetProtocol%26response%3D1&ipAddrAuthn=1&client_id=adobepass-nbcentertainment&reqId=2540b9c5-e58b-40ac-84a2-737e7d8ac78f"));
	WebElement objUserName13 = Utilities.returnElement(driver,lstObject.get(173),lstObject.get(172));
	wait.until(ExpectedConditions.visibilityOf(objUserName13));
	objUserName13.sendKeys("digitest");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword13 = Utilities.returnElement(driver,lstObject.get(176),lstObject.get(175));
	objPassword13.sendKeys("0testdigi1");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn13= Utilities.returnElement(driver,lstObject.get(179),lstObject.get(178));
	objSignIn13.click();
	Synchronization.waitForPageLoad(driver);
	driver.switchTo().window(ParentWindow11);
	

	//rcn 
	
	WebElement objlogo14 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
	wait.until(ExpectedConditions.visibilityOf(objlogo14));
	objlogo14.click();
	Synchronization.waitForPageLoad(driver);
	WebElement objunlink14 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	objunlink14.click();
	Synchronization.waitForPageLoad(driver);
	driver.navigate().refresh();
	List <WebElement> objTVProvider14 = Utilities.returnElements(driver,lstObject.get(14),lstObject.get(13));
	wait.until(ExpectedConditions.visibilityOf(objTVProvider14.get(1)));
	objTVProvider14.get(1).click();	
	WebElement objrcn = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
	wait.until(ExpectedConditions.visibilityOf(objrcn));
	objrcn.click();
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider RCN Tv should be clicked"+Extent_Reports.logActual+"TV provider RCN Tv is clicked", driver);

	
	driver.switchTo().frame("mvpdframe");
	WebElement objUserName14 = Utilities.returnElement(driver,lstObject.get(182),lstObject.get(181));
	wait.until(ExpectedConditions.visibilityOf(objUserName14));
	objUserName14.sendKeys("nbcu-all-pass");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
	
	WebElement objPassword14 = Utilities.returnElement(driver,lstObject.get(185),lstObject.get(184));
	objPassword14.sendKeys("Rcn1NbcU");
	//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
	
	WebElement objSignIn14 = Utilities.returnElement(driver,lstObject.get(188),lstObject.get(187));
	objSignIn14.click();
	Synchronization.waitForPageLoad(driver);
	
	 // driver.close();

	
	
	return null;
   	}
	  }	  }