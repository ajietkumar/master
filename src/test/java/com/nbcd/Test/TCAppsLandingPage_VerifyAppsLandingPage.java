package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGAppsLandingPage;


public class TCAppsLandingPage_VerifyAppsLandingPage extends GetWebDriverInstance
{
	 
	
	@Test(groups="TCPGAppsLandingPage_VerifyAppsLandingPage")
	 
	 public void VerifyAppsLandingPage() throws Exception 
	 {

		PGAppsLandingPage objHP = new PGAppsLandingPage(driver);
		
		objHP.VerifyAppsLandingPage();
		
	 }
} 
