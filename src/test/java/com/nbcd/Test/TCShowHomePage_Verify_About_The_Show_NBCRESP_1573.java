package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage;


public class TCShowHomePage_Verify_About_The_Show_NBCRESP_1573  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")

	 public void Verify_About_The_Show() throws Exception 
	 {
		
		PGShowHomePage objSP = new PGShowHomePage(driver);
		objSP.Verify_About_The_Show_NBCRESP_1573();

	}
				

}


	
	

