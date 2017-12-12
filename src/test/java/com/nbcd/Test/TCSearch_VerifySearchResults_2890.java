package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGLivePage;
import com.nbcd.Pages.PGSearch;

public class TCSearch_VerifySearchResults_2890 extends GetWebDriverInstance
{
	 
	@Test(groups="TCSearch_VerifySearchResults_2890")
	 
	 public void VerifySearchResults() throws  Exception 
	 {

		PGSearch objHP = new PGSearch(driver);
		
		objHP.VerifySearchResults_2890();
		
	 }
}