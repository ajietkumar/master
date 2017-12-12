package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyDisplayofShowsinAlphabeticalOrder_3579 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyDisplayofShowsinAlphabeticalOrder_3579")
	 
	 public void VerifyDisplayofShowsinAlphabeticalOrder() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyDisplayofShowsinAlphabeticalOrder_3579();
		
	 }
}