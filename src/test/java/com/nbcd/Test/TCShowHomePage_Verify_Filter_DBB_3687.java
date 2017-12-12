package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage_VerifyFilter;
public class TCShowHomePage_Verify_Filter_DBB_3687  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage_VerifyFilter")
	
	public void VerifyFilter() throws Exception 
	 {
		PGShowHomePage_VerifyFilter objSP = new PGShowHomePage_VerifyFilter(driver);
		objSP.VerifyFilter_DBB_3687();
		
	}
				
	

}


	
	

