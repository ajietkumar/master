package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyAuthKeyIcon_1920 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyAuthKeyIcon_1920")
	 
	 public void VerifyAuthKeyIcon() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyAuthKeyIcon_1920();
		
	 }
}