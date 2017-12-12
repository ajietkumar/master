package com.nbcd.TestRunner;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.json.simple.JSONObject;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.nbcd.GenericLib.DatabaseFunction;

public class TestRunner
{
	public Hashtable<String, String> htTestRunner;
	public List<String> lstBrowser;


	@SuppressWarnings("deprecation")
	
	@Test
	
	public void tRun()
	{

		try
    	{
			DatabaseFunction objDBF= new DatabaseFunction();
			lstBrowser = objDBF.fnExecuteSql("Select Browser from TestSuite Where Execution ='Yes'","TestRunner","Browser");
			htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes'","TestRunner");
			
    	}
		catch(Exception exc)
		{
			System.out.println("Exception in TestRunner:"+ exc.getMessage());
		}
		
		/*if(lstBrowser.get(0).compareToIgnoreCase("Remote")!= 0)
		{*/
		
					TestNG myTestNG = new TestNG();  //Create an instance on TestNG
					XmlSuite mySuite = new XmlSuite(); //Create an instance of XML Suite and assign a name for it.
					mySuite.setName("NBCAutomation");
					XmlTest myTest = new XmlTest(mySuite); //Create an instance of XmlTest and assign a name for it.
					myTest.setName("NBCAutomation");
					List<XmlClass> myClasses = new ArrayList<XmlClass> ();
				 	Set set = htTestRunner.entrySet();
				    Iterator intIterator = set.iterator();
				    while (intIterator.hasNext()) 
				    {
					      Map.Entry entry = (Map.Entry) intIterator.next();
					   
					      myClasses.add(new XmlClass((String) entry.getKey()));
					      
					      myTest.setXmlClasses(myClasses); //Assign that to the XmlTest Object created earlier.
				
					      myTest.addParameter("browser", (String) entry.getValue());
					      myTest.addParameter("environment", (String) entry.getValue());
					      myTest.addParameter("version", (String) entry.getValue());
					      myTest.addParameter("os", (String) entry.getValue());
					      myTest.addParameter("osversion", (String) entry.getValue());
					//Add any parameters that you want to set to the Test.
				
				    }
				    List<XmlTest> myTests = new ArrayList<XmlTest>();//Create a list of XmlTests and add the Xmltest you created earlier to it.
					myTests.add(myTest);
					mySuite.setTests(myTests); //add the list of tests to your Suite.
					List<XmlSuite> mySuites = new ArrayList<XmlSuite>();//Add the suite to the list of suites.
					mySuites.add(mySuite);
					myTestNG.setXmlSuites(mySuites);
					System.out.println(mySuites);
					myTestNG.run(); //invoke run() - this will run your class.
		
			//}
		//For Parallel Execution
		
		}

}
