package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoPage_VerifyBodyAd_NonPlayer_NBCRESP_1406  extends GetWebDriverInstance
{
	
	
	
	@Test(groups="TCShowVideoDetailPage_VerifyBodyAd_NonPlayer_NBCRESP_1406")
	@Parameters({ "Browser"})
	 public void VerifyBodyAd_NonPlayer_NBCRESP_1406() throws InterruptedException, FilloException, IOException 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyBodyAd_NonPlayer_NBCRESP_1406();
		
	 }
} 