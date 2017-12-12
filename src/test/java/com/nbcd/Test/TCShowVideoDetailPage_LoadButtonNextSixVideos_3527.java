package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_LoadButtonNextSixVideos_3527 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_LoadButtonNextSixVideos_3527")
	 
	 public void LoadButtonNextSixVideos() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.LoadButtonNextSixVideos_3527();
		
	 }
}