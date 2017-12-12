package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGTVE;

public class TCTVE_AuthVod  extends GetWebDriverInstance
{	
	@Test(groups="TCHomePage")

	 public void Authvod() throws Exception 
	 {

		PGTVE objHP = new PGTVE(driver);
		
		objHP.Authvod();

	}
}
