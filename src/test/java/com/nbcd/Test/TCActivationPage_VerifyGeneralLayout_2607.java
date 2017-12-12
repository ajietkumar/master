package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGActivationPage;

public class TCActivationPage_VerifyGeneralLayout_2607 extends GetWebDriverInstance
{
	 
	@Test(groups="TCActivationPage_VerifyGeneralLayout_2607")
	
	 public void VerifyGeneralLayout() throws Exception 
	 {

		PGActivationPage objHP = new PGActivationPage(driver);
		
		objHP.VerifyGeneralLayout_2607();
		
	 }
} 
