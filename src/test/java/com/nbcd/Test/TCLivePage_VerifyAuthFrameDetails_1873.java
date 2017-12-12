package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyAuthFrameDetails_1873 extends GetWebDriverInstance
{
	 
	@Test(groups="TCLivePage_VerifyAuthFrameDetails_1873")
	 
	 public void VerifyAuthFrameDetails() throws  Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyAuthFrameDetails_1873();
		
	 }
}