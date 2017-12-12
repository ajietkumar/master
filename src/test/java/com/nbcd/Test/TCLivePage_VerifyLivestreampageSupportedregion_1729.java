package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyLivestreampageSupportedregion_1729 extends GetWebDriverInstance
{
	 
	@Test(groups="TCLivePage_VerifyLivestreampageSupportedregion_1729")
	 
	 public void VerifyLivestreampageSupportedregion() throws  Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyLivestreampageSupportedregion_1729();
		
	 }
}