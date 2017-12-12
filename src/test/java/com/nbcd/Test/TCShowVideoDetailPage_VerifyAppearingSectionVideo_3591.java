package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyAppearingSectionVideo_3591 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyAppearingSectionVideo_3591")
	 
	 public void VerifyAppearingSectionVideo() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyAppearingSectionVideo_3591();
		
	 }
}