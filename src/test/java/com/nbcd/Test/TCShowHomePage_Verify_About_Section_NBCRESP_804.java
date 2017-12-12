package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_About_Section_NBCRESP_804  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage_Verify_About_Section")
	
	public void Verify_About_Section() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_ABOUT_THE_Section_NBCRESP_804();
		
	}

}


	
	

