package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSearch;

public class TCSearch_VerifyGeneralBehaviour_2866 extends GetWebDriverInstance
{
	 
	@Test(groups="TCSearch_VerifyGeneralBehaviour_2866")
	 
	 public void VerifyGeneralBehaviour() throws  Exception 
	 {

		PGSearch objHP = new PGSearch(driver);
		
		objHP.VerifyGeneralBehaviour_2866();
		
	 }
}