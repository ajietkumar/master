package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyAuthIFrameLayOutDirectTV_2095 extends GetWebDriverInstance
{
	@Test(groups="TCLivePage_VerifyAuthIFrameLayOutDirectTV_2095")
	
	 public void VerifyAuthIFrameLayOutDirectTV() throws Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyAuthIFrameLayOutDirectTV_2095();
		
	 }
}