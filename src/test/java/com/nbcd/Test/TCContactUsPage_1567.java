package com.nbcd.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGContactUs;

@Test
public class TCContactUsPage_1567  extends GetWebDriverInstance
{
	
	@Test(groups="TCContactUsPage_1567")

	 public void VerifyErrMsgInvalidEmailId() throws Exception 
	 {

		PGContactUs objHP = new PGContactUs(driver);
		
		objHP.VerifyErrMsgInvalidEmailId_1567();
		
	 }
}