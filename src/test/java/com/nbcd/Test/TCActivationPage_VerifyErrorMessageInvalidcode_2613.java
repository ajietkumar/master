package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGActivationPage;

public class TCActivationPage_VerifyErrorMessageInvalidcode_2613 extends GetWebDriverInstance
{
	
	
	
	@Test(groups="TCActivationPage_VerifyErrorMessageInvalidcode_2613")

	 public void VerifyErrorMessageInvalidcode() throws Exception 
	 {

		PGActivationPage objHP = new PGActivationPage(driver);
		
		objHP.VerifyErrorMessageInvalidcode_2613();
		
	 }
} 
