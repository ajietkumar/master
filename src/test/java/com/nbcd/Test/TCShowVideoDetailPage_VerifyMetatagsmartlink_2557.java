package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowVideoDetailPage;

public class TCShowVideoDetailPage_VerifyMetatagsmartlink_2557 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCShowVideoDetailPage_VerifyMetatagsmartlink_2557")
	 
	 public void VerifyMetatagsmartlink() throws Exception 
	 {

		PGShowVideoDetailPage objHP = new PGShowVideoDetailPage(driver);
		
		objHP.VerifyMetatagsmartlink_2557();
		
	 }
}