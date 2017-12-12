package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.Pages.PGShowHomePage;
import com.nbcd.GenericLib.GetWebDriverInstance;


public class TCShowHomePage_VerifymetaTags_DBB_3087  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage_VerifymetaTags")
	
	public void metaTags() throws Exception 
	 {
		PGShowHomePage objSP = new PGShowHomePage(driver);
		objSP.VerifymetaTags_DBB_3087();
			}
				
	

}


	
	

