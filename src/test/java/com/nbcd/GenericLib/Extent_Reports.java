package com.nbcd.GenericLib;import java.io.File;import java.lang.reflect.Method;import java.text.SimpleDateFormat;import java.util.Date;import org.apache.commons.io.FileUtils;import org.openqa.selenium.OutputType;import org.openqa.selenium.TakesScreenshot;import org.openqa.selenium.WebDriver;import org.testng.ITestResult;import org.testng.annotations.AfterMethod;import org.testng.annotations.AfterTest;import org.testng.annotations.BeforeClass;import org.testng.annotations.BeforeMethod;import org.testng.annotations.Parameters;import com.relevantcodes.extentreports.ExtentReports;import com.relevantcodes.extentreports.ExtentTest;import com.relevantcodes.extentreports.LogStatus;public class Extent_Reports  {		//private static  String  = null;	public static ExtentReports extentReport;	public static ExtentTest logger;	static String screenshotExtension,reportFolder,destination,screenshotPath,screenshotExtensions;	//public String screenshotExtensions;	static File folder;	static String browserType,ImagePath;	static WebDriver drivers;	static int iFlag=0;		public static String logExpected="<b><font color=#0d0d0f>Expected Result: </font></b>" ;	public static String logActual="<br><b><font color=#0d0d0f>Actual  Result: </font></b>" ;		static	{	if(extentReport==null)	{		SimpleDateFormat sdfDateReport = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");		Date now = new Date();		screenshotExtension=sdfDateReport.format(now) +"_"+System.currentTimeMillis();		if(iFlag == 0)		{			folder = new File(System.getProperty("user.dir") +"/ReportGenerator/NBCAutomation__"+screenshotExtension);						screenshotPath="NBCAutomation__"+screenshotExtension;			if(!folder.exists())			{				folder.mkdir();				iFlag=1;							}		}		extentReport=new ExtentReports(folder+"/NBCAutomation_"+ sdfDateReport.format(now) +".html",true);				extentReport.addSystemInfo("Selenium Version", "3.8.0");    	extentReport.assignProject("NBC");    }       	}	//=====================//==================	@BeforeClass	@Parameters({"browser"})	public String getBrowserType(String browser)	{			return browserType = browser;	}		//==================    //This method is to capture the screenshot and return the path of the screenshot.		public static String getScreenshot(WebDriver driver) throws Exception 		{			SimpleDateFormat sdfDateReport = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");			Date now = new Date();			screenshotExtensions=sdfDateReport.format(now) +"_"+System.currentTimeMillis();					   TakesScreenshot ts = (TakesScreenshot) driver;				File source = ts.getScreenshotAs(OutputType.FILE);								destination = folder+"/"+logger.getTest().getName()+"_"+screenshotExtensions+".png";				File finalDestination = new File(destination);							FileUtils.copyFile(source, finalDestination);				// ImagePath = logger.getTest().getName()+"_"+screenshotExtension+".png";				 ImagePath = logger.getTest().getName()+"_"+screenshotExtensions+".png";					System.out.println("ImagePath:"+ImagePath);					System.out.println("source:"+source);					System.out.println("destination:"+finalDestination);				//}			return ImagePath;						}//==========================================================================================================		//============================================================================================================		public static void executionLog(String status,String Description,WebDriver driver) throws Exception		{			drivers=driver;			switch(status.toUpperCase())			{			case  "PASS":				Extent_Reports.logger.log(LogStatus.PASS,Description+Extent_Reports.logger.addScreenCapture(Extent_Reports.getScreenshot(driver)));				break;			case  "FAIL":				Extent_Reports.logger.log(LogStatus.FAIL,Description+Extent_Reports.logger.addScreenCapture(Extent_Reports.getScreenshot(driver)));				break;			case  "INFO":				Extent_Reports.logger.log(LogStatus.INFO,Description+Extent_Reports.logger.addScreenCapture(Extent_Reports.getScreenshot(driver)));				break;			}		}//======================================				public void getResult(ITestResult result)	{			if(result.getStatus() == ITestResult.FAILURE)		{			logger.log(LogStatus.FAIL, "Test Case Failed :"+result.getName());			logger.log(LogStatus.FAIL, "Failed Reason is :"+result.getThrowable());			//logger.log(LogStatus.FAILsdf, logger.addScreenCapture(destination));					}		else if(result.getStatus() == ITestResult.SKIP)		{			logger.log(LogStatus.SKIP, "Test Case Skipped is :"+"_"+result.getName());			logger.log(LogStatus.FAIL, "Skipped Reason is  :"+result.getThrowable());						//logger.log(LogStatus.PASS, logger.addScreenCapture(destination));					}		else if(result.getStatus() == ITestResult.SUCCESS) 		{						logger.log(LogStatus.PASS, "Test Case Pass :"+result.getName());			//logger.log(LogStatus.PASS, logger.addScreenCapture(destination));								}		else if(result.getStatus() == ITestResult.STARTED)		{			logger.log(LogStatus.INFO, "Test Case Started :"+result.getName());					}			}		@BeforeMethod	public void beforeMethod(Method result)	{		//logger=extentReport.startTest(browserType+"_"+this.getClass().getSimpleName()+"_"+result.getName());		logger=extentReport.startTest(browserType+"_"+this.getClass().getSimpleName());				logger.log(LogStatus.INFO, result.getName()+ " test Started");	}		@AfterMethod	public void afterMethod(ITestResult result)	{		getResult(result);				}	@AfterTest	public void endReport(){			extentReport.endTest(logger);		extentReport.flush();				     }	}