package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifySeasonsSortingforClassicVideos_3105 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifySeasonsSortingforClassicVideos_3105")
	 
	 public void VerifySeasonsSortingforClassicVideos() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifySeasonsSortingforClassicVideos_3105();
		
	 }
}