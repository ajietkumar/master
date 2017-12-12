package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
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

public class PGGlobalHomePage extends GetWebDriverInstance
{
	
	private static WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objnav,objRespNavBar;
	private String screenshotExtension;
	
//Constructor to initialize all the Page Objects  
	
	
	
	
	public PGGlobalHomePage(WebDriver driver) throws MalformedURLException 
	{      
		
		this.driver = driver; 
		lstTestData=db.getTestDataObject("Select * from GlobalHomePage","Input");
		lstObject=db.getTestDataObject("Select * from GlobalHomePage","ObjectRepository");
	
	}

	
	//=========================================================================================================================
@Test
public  PGGlobalHomePage Global_BodyAd( ) throws InterruptedException, FilloException ,Exception
{	 {
	 //Launching the URL
	{

      driver.get(lstTestData.get(0));
      WebDriverWait wait= new WebDriverWait(driver,60);
      Synchronization.waitForPageLoad(driver);
      wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
     
   		 WebElement objBodyAd= (WebElement) Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
		
		if (objBodyAd.isDisplayed())
	{
			Extent_Reports.executionLog("PASS","Body Ad is Displayed",driver);
		driver.close();
		System.out.print("Result printed");
	}
	 else
	 {
			Extent_Reports.executionLog("FAIL","Body Ad is NOT Displayed",driver);

	 driver.close();
	}
	return null;

  }    
  }
}


//============================================================================================================================
@Test
public  PGGlobalHomePage Global_BannerAd( ) throws InterruptedException, FilloException ,Exception
{	 {
	 //Launching the URL
	{

      driver.get(lstTestData.get(0));
      WebDriverWait wait= new WebDriverWait(driver,60);
      Synchronization.waitForPageLoad(driver);

      wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
     
   		 WebElement objBannerAd= (WebElement) Utilities.returnElement(driver,lstObject.get(5),lstObject.get(4));
   		if (objBannerAd.isDisplayed())
   		{
			Extent_Reports.executionLog("PASS","Banner Ad is Displayed",driver);
		driver.close();
		System.out.print("Result printed");
	}
	 else
	 {
			Extent_Reports.executionLog("FAIL","Banner Ad is NOT Displayed",driver);

	 driver.close();
	}
	return null;

  }    
}}
//============================================================================================================================
@Test
public  PGGlobalHomePage Global_Footerlinks_Nav( ) throws InterruptedException, FilloException ,Exception
{	 
	 //Launching the URL
	{

    driver.get(lstTestData.get(0));
    WebElement objLogo= (WebElement) Utilities.returnElement(driver,lstObject.get(8),lstObject.get(7));
    objLogo.click();
    WebDriverWait wait= new WebDriverWait(driver,60);
    Synchronization.waitForPageLoad(driver);

    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    String url1 = driver.getCurrentUrl();
    if (url1.contentEquals(lstTestData.get(0)))
    {
			Extent_Reports.executionLog("PASS","URL is displayed as per format",driver);	
			 System.out.print("Result printed");
	  }
	  else
	  
			Extent_Reports.executionLog("FAIL","URL is not displayed as per format",driver);	
}  
    WebElement objfbshare=  Utilities.returnElement(driver,lstObject.get(11),lstObject.get(10));
    objfbshare.click();
    String ParentWindow = driver.getWindowHandle();
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> nWindow= s1.iterator();
	while(nWindow.hasNext()){
		String childWindow = nWindow.next();
		driver.switchTo().window(childWindow);
	}
	Thread.sleep(20000);
    WebDriverWait wait= new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.urlContains(lstTestData.get(4)));
    String url2 = driver.getCurrentUrl();
    if (url2.contentEquals(lstTestData.get(4)))
    {
		Extent_Reports.executionLog("PASS","Facebook share is navigating to valid url",driver);
			 System.out.print("Result printed");
	  }
	  else
	  {
		  Extent_Reports.executionLog("FAIL","Facebook share is navigating to invalid url",driver);
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
    WebElement objtweetshare= Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
    objtweetshare.click();
    String ParentWindow1 = driver.getWindowHandle();
	Set<String> s2=driver.getWindowHandles();
	Iterator<String> nWindow1= s2.iterator();
	while(nWindow1.hasNext()){
		String childWindow1 = nWindow1.next();
		driver.switchTo().window(childWindow1);
	}
	wait.until(ExpectedConditions.urlContains(lstTestData.get(5)));
    String url3 = driver.getCurrentUrl();
    if (url3.contentEquals(lstTestData.get(5)))
    {
    	Extent_Reports.executionLog("PASS","Twitter share is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Twitter share is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow1);
    
    WebElement objtumblrshare=  Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
    objtumblrshare.click();
    String ParentWindow2 = driver.getWindowHandle();
	Set<String> s3=driver.getWindowHandles();
	Iterator<String> nWindow2= s3.iterator();
	while(nWindow2.hasNext()){
		String childWindow2 = nWindow2.next();
		driver.switchTo().window(childWindow2);
	}
	Thread.sleep(12000);
	//wait.until(ExpectedConditions.urlContains(lstTestData.get(6)));
    String url4 = driver.getCurrentUrl();
    if (url4.contentEquals(lstTestData.get(6)))
    {
    	Extent_Reports.executionLog("PASS","Tumblr share is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Tumblr share is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow2);
    
    
    WebElement objpinshare=  Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));
    objpinshare.click();
    String ParentWindow3 = driver.getWindowHandle();
	Set<String> s4=driver.getWindowHandles();
	Iterator<String> nWindow3= s4.iterator();
	while(nWindow3.hasNext()){
		String childWindow3 = nWindow3.next();
		driver.switchTo().window(childWindow3);
	}
	Thread.sleep(12000);
	wait.until(ExpectedConditions.urlContains(lstTestData.get(7)));
    String url5 = driver.getCurrentUrl();
    if (url5.contentEquals(lstTestData.get(7)))
    {
    	Extent_Reports.executionLog("PASS","Pinterest share is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Pinterest share is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow3);
    
    
    WebElement objgplusshare=  Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
    objgplusshare.click();
    String ParentWindow4 = driver.getWindowHandle();
	Set<String> s5=driver.getWindowHandles();
	Iterator<String> nWindow4= s5.iterator();
	while(nWindow4.hasNext()){
		String childWindow4 = nWindow4.next();
		driver.switchTo().window(childWindow4);
	}
	Thread.sleep(12000);
	//wait.until(ExpectedConditions.urlContains("https://plus.google.com/+NBC"));
    String url6 = driver.getCurrentUrl();
    if (url6.contains(lstTestData.get(8)))
    {
    	Extent_Reports.executionLog("PASS","Google Plus share is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Google Plus share is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow4);
    
    
    WebElement objytubshare=  Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
    objytubshare.click();
    String ParentWindow5 = driver.getWindowHandle();
	Set<String> s6=driver.getWindowHandles();
	Iterator<String> nWindow5= s6.iterator();
	while(nWindow5.hasNext()){
		String childWindow5 = nWindow5.next();
		driver.switchTo().window(childWindow5);
	}
	Thread.sleep(12000);
	//https://www.youtube.com/nbc
	wait.until(ExpectedConditions.urlContains(lstTestData.get(9)));
    String url7 = driver.getCurrentUrl();
    if (url7.contentEquals(lstTestData.get(9)))
    {
    	Extent_Reports.executionLog("PASS","Youtube share is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Youtube share is navigating to valid url",driver);
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

  
    driver.switchTo().window(ParentWindow5);
    
    WebElement objnbcapp=  Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
    objnbcapp.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(10)));
    String url8 = driver.getCurrentUrl();
    if (url8.contentEquals(lstTestData.get(10)))
    {
    	Extent_Reports.executionLog("PASS","Apps link is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Apps link  is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
   
    WebElement objnbcsignuplink=  Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
    objnbcsignuplink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(11)));
    String url9 = driver.getCurrentUrl();
    if (url9.contentEquals(lstTestData.get(11)))
    {
    	Extent_Reports.executionLog("PASS","Signup link is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Signup Link is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
    
    WebElement objfaqlink=  Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));
    objfaqlink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(12)));
    String url10 = driver.getCurrentUrl();
    if (url10.contentEquals(lstTestData.get(12)))
    {
    	Extent_Reports.executionLog("PASS","FAQ LINK is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","FAQ LINK  is navigating to valid url",driver);
}  
    driver.navigate().back();
    
   // wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
    WebElement objcastlink= Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));
    objcastlink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(13)));
    String url11 = driver.getCurrentUrl();
    if (url11.contentEquals(lstTestData.get(13)))
    {
    	Extent_Reports.executionLog("PASS","Casting link is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Casting link is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
    WebElement objstorelink=  Utilities.returnElement(driver,lstObject.get(41),lstObject.get(40));
    objstorelink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(14)));
    String url12 = driver.getCurrentUrl();
    if (url12.contentEquals(lstTestData.get(14)))
    {
    	Extent_Reports.executionLog("PASS","Store nav is navigating to valid url",driver);
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Store nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains("https://www.nbc.com"));
    
    WebElement objtourlink= Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
    objtourlink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(15)));
    String url13 = driver.getCurrentUrl();
    if (url13.contentEquals(lstTestData.get(15)))
    {
    	Extent_Reports.executionLog("PASS","Tickets&tour nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
 }
 else
 {
		Extent_Reports.executionLog("FAIL","Tickets&tour nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
  
    
    WebElement objcontus=  Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));
    objcontus.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(16)));
    String url14 = driver.getCurrentUrl();
    if (url14.contentEquals(lstTestData.get(16)))
    {
    	Extent_Reports.executionLog("PASS","Contact Us nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","Tickets&tour nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objcinfolink=  Utilities.returnElement(driver,lstObject.get(50),lstObject.get(49));
    objcinfolink.click();
    String ParentWindow6 = driver.getWindowHandle();
	Set<String> s7=driver.getWindowHandles();
	Iterator<String> nWindow6= s7.iterator();
	while(nWindow6.hasNext()){
		String childWindow6 = nWindow6.next();
		driver.switchTo().window(childWindow6);
	}
    wait.until(ExpectedConditions.urlContains(lstTestData.get(17)));
    String url15 = driver.getCurrentUrl();
    if (url15.contentEquals(lstTestData.get(17)))
    {
    	Extent_Reports.executionLog("PASS","Corporateinfo nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","Corporateinfo nav is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow6);
    wait.until(ExpectedConditions.urlContains("https://www.nbc.com"));
    WebElement objjobs=  Utilities.returnElement(driver,lstObject.get(53),lstObject.get(52));
    objjobs.click();
    
    String ParentWindow7 = driver.getWindowHandle();
	Set<String> s8=driver.getWindowHandles();
	Iterator<String> nWindow7= s8.iterator();
	while(nWindow7.hasNext()){
		String childWindow7 = nWindow7.next();
		driver.switchTo().window(childWindow7);
    wait.until(ExpectedConditions.urlContains(lstTestData.get(18)));
    String url16 = driver.getCurrentUrl();
    if (url16.contentEquals(lstTestData.get(18)))
    {
    	Extent_Reports.executionLog("PASS","jobs nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","jobs nav is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow7);
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objprivacylink=  Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));
    objprivacylink.click();
    String ParentWindow8 = driver.getWindowHandle();
	Set<String> s9=driver.getWindowHandles();
	Iterator<String> nWindow8= s9.iterator();
	while(nWindow8.hasNext()){
		String childWindow8 = nWindow8.next();
		driver.switchTo().window(childWindow8);
    wait.until(ExpectedConditions.urlContains(lstTestData.get(19)));
    String url17 = driver.getCurrentUrl();
    if (url17.contentEquals(lstTestData.get(19)))
    {
    	Extent_Reports.executionLog("PASS","Privacy nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","privacy nav is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow8);    
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objtermslnk=  Utilities.returnElement(driver,lstObject.get(59),lstObject.get(58));
    objtermslnk.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(20)));
    String url18 = driver.getCurrentUrl();
    if (url18.contentEquals(lstTestData.get(20)))
    {
    	Extent_Reports.executionLog("PASS","terms nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","terms nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objadlink=  Utilities.returnElement(driver,lstObject.get(62),lstObject.get(61));
    objadlink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(21)));
    String url19 = driver.getCurrentUrl();
    if (url19.contentEquals(lstTestData.get(21)))
    {
    	Extent_Reports.executionLog("PASS","adlinks nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","adlinks nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objviewpanel=  Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
    objviewpanel.click();
    String ParentWindow9 = driver.getWindowHandle();
	Set<String> s10=driver.getWindowHandles();
	Iterator<String> nWindow9= s10.iterator();
	while(nWindow9.hasNext()){
		String childWindow9 = nWindow9.next();
		driver.switchTo().window(childWindow9);
    wait.until(ExpectedConditions.urlContains(lstTestData.get(22)));
    String url20= driver.getCurrentUrl();
    if (url20.contentEquals(lstTestData.get(22)))
    {
    	Extent_Reports.executionLog("PASS","Viewerpanel nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","viewerpanel nav is navigating to valid url",driver);
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

    driver.switchTo().window(ParentWindow9);    
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objcclink=  Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
    objcclink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(23)));
    String url21 = driver.getCurrentUrl();
    if (url21.contentEquals(lstTestData.get(23)))
    {
    	Extent_Reports.executionLog("PASS","Closecaptioning nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","Closecaptioning nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objtechsup=  Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
    objtechsup.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(24)));
    String url22= driver.getCurrentUrl();
    if (url22.contentEquals(lstTestData.get(24)))
    {
    	Extent_Reports.executionLog("PASS","Tech support nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","Techsupport nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    WebElement objvidviewlink=  Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));
    objvidviewlink.click();
    wait.until(ExpectedConditions.urlContains(lstTestData.get(25)));
    String url23 = driver.getCurrentUrl();
    if (url23.contentEquals(lstTestData.get(25)))
    {
    	Extent_Reports.executionLog("PASS","Videoviewing policy nav is navigating to valid url",driver);
    	
		 System.out.print("Result printed");
}
else
{
		Extent_Reports.executionLog("FAIL","Videoviewing policy nav is navigating to valid url",driver);
}  
    driver.navigate().back();
    
    wait.until(ExpectedConditions.urlContains(lstTestData.get(0)));
    
    driver.close();
}}}
	return null;
	}


@Test
public  PGGlobalHomePage titledescan( ) throws InterruptedException, FilloException, Exception
	  {
	 //Launching the URL
   	{
   	 driver.get(lstTestData.get(0));
  
     Synchronization.waitForPageLoad(driver);
 
		  		  
		
		  WebElement objmeta_desc = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
		  //WebElement objog_image = driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
		  String thumbnail = objmeta_desc.getAttribute("content");
		  System.out.println(thumbnail);
		  
		  
		  
		if (lstTestData.get(1).equalsIgnoreCase(objmeta_desc.getAttribute("content")))
			  
			{
				Extent_Reports.executionLog("PASS","meta name : description is displayed",driver);
			}	
			else
			{
				Extent_Reports.executionLog("FAIL","meta name : description is missing",driver);

			}

		String page_source;
		  page_source = driver.getPageSource();
		if(page_source.contains(lstTestData.get(3)))
		  {
			Extent_Reports.executionLog("PASS","Title is present",driver);	
		  }		  
		  else
			Extent_Reports.executionLog("FAIL","Title is missing",driver);   
		
     	}

	  WebElement objlink_ref = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
	  //WebElement objog_image = driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
	  String thumbnail = objlink_ref.getAttribute("href");
	  System.out.println(thumbnail);
	  
	  
	  
	if (lstTestData.get(2).equalsIgnoreCase(objlink_ref.getAttribute("href")))
		  
		{
			Extent_Reports.executionLog("PASS","Canonical Url is displayed",driver);
		}	
		else
		{
			Extent_Reports.executionLog("FAIL","Canonical Url is missing",driver);

		}

        
		driver.close(); 
	return null;

	  }


//------------------------- Global Show home Page ------------------------			

@Test
public PGGlobalHomePage  Global_Showhome_Page( ) throws InterruptedException, FilloException 
{
		
	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
	     Actions Action = new Actions(driver);
	     WebDriverWait wait = new WebDriverWait(driver,50);
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
		Synchronization.waitForPageLoad(driver);
		//div > div > section:nth-child(3) > div > div.section-heading > h2
		WebElement objEpisode=Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));
		System.out.println(objEpisode.getAttribute("innerHTML"));
	  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Header: "+ objEpisode.isDisplayed() +Extent_Reports.logActual +": " +objEpisode.getAttribute("innerHTML"), driver );
	  	
	  	WebElement obj_FirstVideo_Title=Utilities.returnElement(driver,lstObject.get(107),lstObject.get(106));
	  	Point point1 = obj_FirstVideo_Title.getLocation();
	  	Action.moveToElement(obj_FirstVideo_Title, point1.getX(), point1.getY()).build().perform();
	  	
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content a
		List<WebElement> objEpisodeSection=Utilities.returnElements(driver,lstObject.get(86),lstObject.get(85));
		int number_Clips=(objEpisodeSection.size())/2;
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected number of Clips in a row is: "+ "3" +Extent_Reports.logActual +"Actual number of Clips in a row is : " + number_Clips, driver );
		
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__title
		List<WebElement> objEpisodeTitle=Utilities.returnElements(driver,lstObject.get(89),lstObject.get(88));
		
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__description > span:nth-child(1)
		List<WebElement> objEpisodedescription=Utilities.returnElements(driver,lstObject.get(92),lstObject.get(91));
		
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__description > span:nth-child(2)
		List<WebElement> objEpisodeDate=Utilities.returnElements(driver,lstObject.get(95),lstObject.get(94));
		
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content > a:nth-child(1) > article > div.card__meta > div.card__description > span:nth-child(1)
		WebElement objdescription=Utilities.returnElement(driver,lstObject.get(98),lstObject.get(97));
		String description = objdescription.getText();
		System.out.println(description);
		String[] spilt=description.split(" ");
		System.out.println(spilt[0]);
		System.out.println(spilt[1]);
		char season=spilt[0].charAt(0);
		System.out.println(season);
	  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode season Start's with \"S\": "+ "S" +Extent_Reports.logActual +": " + spilt[0] , driver );
	  	char Episode=spilt[1].charAt(0);
		System.out.println(Episode);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Start's with \"E\": "+ "E" +Extent_Reports.logActual +": " + spilt[1], driver );					
		
		for(int i=0;i<objEpisodeTitle.size();i++){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Title is: "+ objEpisodeTitle.get(i).getAttribute("innerHTML")+"  " + "Episode Description is: "+ objEpisodedescription.get(i).getText()+"  " + "Episode Date is: "+ objEpisodeDate.get(i).getAttribute("innerHTML") , driver );
		}
		
		//section:nth-child(3) > div > div.video-list__container > div.load-button.full-width
		WebElement objload_btn=Utilities.returnElement(driver,lstObject.get(101),lstObject.get(100));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode season Load Button should be hidden: "+ "True" +Extent_Reports.logActual +"Episode season Load Button should be hidden: " + objload_btn.getAttribute("style") , driver );
		
		//section:nth-child(3) > div > div.video-list__container > div.video-list__content > a:nth-child(1)
		WebElement obj_FirstVideo=Utilities.returnElement(driver,lstObject.get(104),lstObject.get(103));
		Action.moveToElement(obj_FirstVideo).build().perform();
		Action.moveToElement(obj_FirstVideo).click().build().perform();
		Thread.sleep(50000);
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");									
		//header > div > div > nav > div.navigation__inner > div.sticky-outer-wrapper.show-header > div > div.show-header__background > div > div.show-header__title > span
		WebElement obj_EpisodeHeader=Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));
		wait.until(ExpectedConditions.visibilityOf(obj_EpisodeHeader));
		Point point2 = obj_EpisodeHeader.getLocation();
	  	Action.moveToElement(obj_EpisodeHeader, point2.getX(), point2.getY()).build().perform();
		if((obj_EpisodeHeader.getText()).equalsIgnoreCase(obj_FirstVideo_Title.getAttribute("innerHTML"))){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Title is: "+ obj_FirstVideo_Title.getAttribute("innerHTML") +Extent_Reports.logActual +"Episode Title is: " + obj_EpisodeHeader.getText(), driver );
		}else{
			Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Episode Title is: "+ obj_FirstVideo_Title.getAttribute("innerHTML") +Extent_Reports.logActual +"Episode Title is: " + obj_EpisodeHeader.getText(), driver );
		}
	
	 }
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
	driver.close(); 
	
	return null;
}

//------------------------- Global Show home Page ------------------------			

@Test
public PGGlobalHomePage  Global_Showhome_Page_Clips( ) throws InterruptedException, FilloException 
{
		
	//Launching Browser with valid URL.
	     driver.get(lstTestData.get(0));
	     Actions Action = new Actions(driver);
	     WebDriverWait wait = new WebDriverWait(driver,50);
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
		Synchronization.waitForPageLoad(driver);
		//div > div > section:nth-child(5) > div > div.section-heading > h2
		WebElement objClip=Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
		Point point1 = objClip.getLocation();
	  	Action.moveToElement(objClip, point1.getX(), point1.getY()).build().perform();
	  	System.out.println(objClip.getAttribute("innerHTML"));
	  	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Header: "+ objClip.isDisplayed() +Extent_Reports.logActual +": " +objClip.getAttribute("innerHTML"), driver );
	  	
	  	//section:nth-child(5) > div > div.video-list__container > div.video-list__content > a:nth-child(1)
	  	WebElement obj_FirstClip_Title=Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
	  					  	
	  	//section:nth-child(5) > div > div.video-list__container > div.video-list__content a
		List<WebElement> objClipSection=Utilities.returnElements(driver,lstObject.get(119),lstObject.get(118));
		int number_Clips=(objClipSection.size())/2;
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Expected number of Clips in a row is: "+ "3" +Extent_Reports.logActual +"Actual number of Clips in a row is : " + number_Clips, driver );
		
		//section:nth-child(5) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__title
		List<WebElement> objClipTitle=Utilities.returnElements(driver,lstObject.get(122),lstObject.get(121));
		
		//section:nth-child(5) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__description > div > div
		List<WebElement> objClipdescription=Utilities.returnElements(driver,lstObject.get(125),lstObject.get(124));
		
		//section:nth-child(5) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__description > div > span > span
		List<WebElement> objCliptype=Utilities.returnElements(driver,lstObject.get(128),lstObject.get(127));
		
		//section:nth-child(5) > div > div.video-list__container > div.video-list__content > a > article > div.card__meta > div.card__description > div > span > span
		List<WebElement> objClipDate=Utilities.returnElements(driver,lstObject.get(131),lstObject.get(130));
														
		for(int i=0;i<objClipTitle.size();i++){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode Title is: "+ objClipTitle.get(i).getAttribute("innerHTML")+"  " + "Episode Description is: "+ objClipdescription.get(i).getAttribute("innerHTML")+"  " + "Episode Date is: "+ objClipDate.get(i).getText() +"  " + "Episode Date is: "+ objCliptype.get(i).getAttribute("innerHTML"), driver );
		}
		
		//section:nth-child(5) > div > div.video-list__container > div.load-button.full-width
		WebElement objload_btn=Utilities.returnElement(driver,lstObject.get(134),lstObject.get(133));
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode season Load Button should be hidden: "+ "True" +Extent_Reports.logActual +"Episode season Load Button should be hidden: " + objload_btn.getAttribute("style") , driver );
		
		//section:nth-child(4) > div > div.video-list__container > div.video-list__content > a
		List<WebElement> obj_ClipVideos=Utilities.returnElements(driver,lstObject.get(137),lstObject.get(136));
		System.out.println(obj_ClipVideos.size());
		for(int i=0;i<obj_ClipVideos.size();i++){
			
			System.out.println(obj_ClipVideos.get(i).getAttribute("href"));
			//.moveToElement(obj_ClipVideos.get(i)).click().build().perform();
		 
			driver.navigate().to(obj_ClipVideos.get(i).getAttribute("href"));
			Thread.sleep(10000);
			//section > div.video-meta > a > span
			WebElement objDetails_btn=Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			Action.moveToElement(objDetails_btn).build().perform();
			Action.moveToElement(objDetails_btn).click().build().perform();
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)","");
			//section > div.video-meta.video-meta--expanded > div.video-meta__details > div.video-meta__info > span.video-meta__type
			WebElement objtype=Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Clip Video Type is: "+ objtype.getText()  , driver );
			driver.navigate().back();
			Thread.sleep(10000);
					
		}
											
								
	
	 }
	 catch(Exception exc)
	 {
		 System.out.println(exc.getMessage());
	 }
	
//	driver.close(); 
	
	return null;
}



}
