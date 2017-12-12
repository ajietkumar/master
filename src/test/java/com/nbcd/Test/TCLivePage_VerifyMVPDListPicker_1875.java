package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyMVPDListPicker_1875 extends GetWebDriverInstance
{

	@Test(groups="TCLivePage_VerifyMVPDListPicker_1875")
	 public void VerifyMVPDListPicker() throws Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyMVPDListPicker_1875();
		
	 }
}
/**@Test
public class TCLivePage_VerifyMVPDListPicker  extends GetWebDriverInstance
{
	WebDriver driver;
	@Test(groups="TCLivePage_VerifyAuthFrameDetails")
	 public void MenuDetails() throws Exception
	 {
		PGLivePage objHP = new PGLivePage(driver);
		objHP.VerifyMVPDListPicker();
     }
}*/