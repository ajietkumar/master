package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifySNLEpisode_3101 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifySNLEpisode")
	 
	 public void VerifySNLEpisode() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifySNLEpisode_3101();
		
	 }
}