package com.nbcd.GenericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//=========================================================CLASS & METHODS =============================================================================================
public class GetWebDriverInstance extends Extent_Reports {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
 	private static String  genericPath=System.getProperty("user.dir").concat("\\src\\test\\resources\\DriverExecutable\\");
 	protected WebDriver driver;
 	@SuppressWarnings("deprecation")
	@BeforeClass
 	//@Parameters("browser") 
     @Parameters(value={"environment","browser","version","os","osversion"})
	public   void getBrowser(String environment,String browser,String version,String os,String osversion) throws MalformedURLException 
	{
 		
		 driver = null;
		Properties prop = new Properties();
		try 
		{

			 InputStream input = new FileInputStream("config\\Config.properties");
			// load a properties file
				prop.load(input);

			} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		/*if(environment.compareToIgnoreCase("remote")==0)
		{
			browser="remote";
		}*/
		switch (environment.toUpperCase()) 
		{
			case "FIREFOX":
				   System.setProperty("webdriver.gecko.driver", genericPath+"geckodriver.exe");
				  
				   /*DesiredCapabilities caps1 = new DesiredCapabilities();
				    caps1.setCapability("browser",environment);
				    caps1.setCapability("marionnette", true);*/
				  
				   driver = drivers.get("Firefox");
				   if (driver == null) 
					{
						driver = new FirefoxDriver();
						drivers.put("Firefox", driver);
					}
					break;
			 case "IE":
					driver = drivers.get("IE");
					if (driver == null) 
					{
						System.setProperty("webdriver.ie.driver", genericPath+"IEDriverServer.exe");
						
						driver = new InternetExplorerDriver();
						drivers.put("IE", driver);
					}
				   break;
			case "CHROME":
					driver = drivers.get("Chrome");
				
                 
					if (driver == null) 
					{
						System.out.println(genericPath);
						System.setProperty("webdriver.chrome.driver",genericPath+"chromedriver.exe");  
						ChromeOptions options = new ChromeOptions(); 
						options.addArguments("disable-infobars"); 
						options.addArguments("--disable-extensions");
		                options.addArguments("--test-type");
		                options.addArguments("start-maximized");
						driver = new ChromeDriver(options);
	
					}
					break;
			case "REMOTE":
				System.out.println("HERES");
					final String USERNAME =prop.getProperty("username");
					final String AUTOMATE_KEY = prop.getProperty("accessKey");;
					final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
					DesiredCapabilities caps = new DesiredCapabilities();
				    caps.setCapability("browser",browser);
				    caps.setCapability("browser_version", version);
				    caps.setCapability("resolution", "1024x768");
				    caps.setCapability("os", os);
				    caps.setCapability("os_version",osversion);
				    caps.setCapability("resolution","1024x768");
				    driver = new RemoteWebDriver(new URL(URL), caps);
						    driver.get(URL); 
				break;
				
			case "HEADLESS":
				driver = new HtmlUnitDriver();
				break;
			case "OPERA":	
					driver = new OperaDriver();
				    break;
				
			case "SAFARI":
					driver = new SafariDriver();
					break;
				
	    }
			driver.manage().window().maximize();
	 		driver.manage().deleteAllCookies();
			//return driver;
	}

 @AfterMethod
	public  void closeAllDriver() 
	{
		
			
			driver.quit();
		
    }
	
	
}
