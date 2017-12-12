package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSearch;

public class TCSearch_VerifyGeneralAbilities_2890 extends GetWebDriverInstance
{
	 
	@Test(groups="TCSearch_VerifyGeneralAbilities_2890")
	 
	 public void VerifyGeneralAbilities() throws  Exception 
	 {

		PGSearch objHP = new PGSearch(driver);
		
		objHP.VerifyGeneralAbilities_2890();
		
	 }
}