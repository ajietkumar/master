package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyLiveStreamGeneralLayOut_2093 extends GetWebDriverInstance
{
 
	@Test(groups="TCLivePage_VerifyLiveStreamGeneralLayOut_2093")
 
	 public void VerifyLiveStreamGeneralLayOut() throws Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyLiveStreamGeneralLayOut_2093();
		
	 }
}
