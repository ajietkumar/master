package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;


public class TCShowHomePage_Verify_full_Episode_section_DBB_3058  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")

	 public void Verify_full_Episode_section() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Full_Episodes_Section_DBB_3058();

	}
				

}


	
	

