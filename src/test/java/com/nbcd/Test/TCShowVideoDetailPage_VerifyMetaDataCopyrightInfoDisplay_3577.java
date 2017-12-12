package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyMetaDataCopyrightInfoDisplay_3577 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyMetaDataCopyrightInfoDisplay_3577")
	 
	 public void VerifyMetaDataCopyrightInfoDisplay() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyMetaDataCopyrightInfoDisplay_3577();
		
	 }
}