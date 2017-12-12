package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyVideoDetailPageOpened extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyVideoDetailPageOpened")
	 
	 public void VerifyVideoDetailPageOpened() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyVideoDetailPageOpened();
		
	 }
}