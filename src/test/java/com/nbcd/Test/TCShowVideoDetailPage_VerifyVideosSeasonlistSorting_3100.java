package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

@Test
public class TCShowVideoDetailPage_VerifyVideosSeasonlistSorting_3100 extends GetWebDriverInstance
{
	
	
	
	
	@Test(groups="TCShowVideoDetailPage_VerifyVideosSeasonlistSorting")
	
	 public void VerifyVideosSeasonlistSorting() throws InterruptedException, FilloException, IOException 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyVideosSeasonlistSorting_3100();
		
	 }
} 