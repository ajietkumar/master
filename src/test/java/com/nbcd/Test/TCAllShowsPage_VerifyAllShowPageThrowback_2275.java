package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllShowsPage;

public class TCAllShowsPage_VerifyAllShowPageThrowback_2275 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCAllShowsPage_VerifyAllShowPageThrowback_2275")
	 
	 public void VerifyAllShowPageThrowback() throws Exception 
	 {

		PGAllShowsPage objHP = new PGAllShowsPage(driver);
		
		objHP.VerifyAllShowPageThrowback_2275();
		
	 }
}