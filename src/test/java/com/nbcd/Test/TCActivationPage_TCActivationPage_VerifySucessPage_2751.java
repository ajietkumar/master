package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGActivationPage;

public class TCActivationPage_TCActivationPage_VerifySucessPage_2751 extends GetWebDriverInstance
{

	
	
	
	@Test(groups="TCActivationPage_TCActivationPage_VerifySucessPage_2751")
	
	 public void VerifyURLPathingRoutingactivation() throws Exception 
	 {

		PGActivationPage objHP = new PGActivationPage(driver);
		
		objHP.VerifyURLPathingRoutingactivation_2803();
		
	 }
} 