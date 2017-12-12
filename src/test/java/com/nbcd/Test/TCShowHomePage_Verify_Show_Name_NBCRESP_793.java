package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage;


public class TCShowHomePage_Verify_Show_Name_NBCRESP_793  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage")

	 public void Verify_Show_Name() throws Exception 
	 {
		PGShowHomePage objSP = new PGShowHomePage(driver);
		objSP.Verify_Show_Name_and_TuneIn_Alert_NBCRESP_793();

	}
				

}


	
	

