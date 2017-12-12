package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;


public class TCShowHomePage_Verify_Ad_Banner_DBB_3062  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")

	 public void Verify_Ad_Banner( ) throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Ad_Banner_DBB_3062();

	}
				

}


	
	

