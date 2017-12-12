package com.nbcd.Test;


import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage;


public class TCShowHomePage_Verify_Dynamic_Lead_Slide_NBCRESP_1163  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")

	 public void Verify_Dynamic_Lead_Slide() throws Exception 
	 {
			PGShowHomePage objSP = new PGShowHomePage(driver);
			objSP.Verify_Dynamic_Lead_Slide_NBCRESP_1163();
	 }				

}


	
	

