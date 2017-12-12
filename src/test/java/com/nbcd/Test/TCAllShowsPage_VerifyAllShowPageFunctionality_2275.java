package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllShowsPage;
import com.nbcd.Pages.PGContactUs;

public class TCAllShowsPage_VerifyAllShowPageFunctionality_2275 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCAllShowsPage_VerifyAllShowPageFunctionality_2275")
	 
	 public void VerifyAllShowPageFunctionality() throws Exception 
	 {

		PGAllShowsPage objHP = new PGAllShowsPage(driver);
		
		objHP.VerifyAllShowPageFunctionality_2275();
		
	 }
}
