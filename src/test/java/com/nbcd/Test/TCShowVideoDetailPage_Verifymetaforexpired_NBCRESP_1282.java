package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_Verifymetaforexpired_NBCRESP_1282 extends GetWebDriverInstance
{
	public WebDriver driver;
	
	
	
	@Test(groups="TCShowVideoDetailPage_Verifymetaforexpired_NBCRESP_1282")
	
	 public void Verifymetaforexpired_NBCRESP_1282() throws InterruptedException, FilloException, IOException 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.Verifymetaforexpired_NBCRESP_1282();
		
	 }
} 
