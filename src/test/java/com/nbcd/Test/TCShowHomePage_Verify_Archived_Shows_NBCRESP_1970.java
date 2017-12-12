package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_Archived_Shows_NBCRESP_1970  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage2")
	
	public void Verify_Archived_Shows() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Archived_shows();
		
	 }
				
	

}


	
	

