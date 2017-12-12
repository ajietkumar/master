package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyOneResultEnterButton_2093 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCLivePage_VerifyOneResultEnterButton_2093")
	 
	 public void VerifyOneResultEnterButton() throws Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyOneResultEnterButton_2093();
		
	 }
}