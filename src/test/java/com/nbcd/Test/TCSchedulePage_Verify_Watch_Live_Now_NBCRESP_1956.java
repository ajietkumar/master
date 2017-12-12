package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Watch_Live_Now_NBCRESP_1956  extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_Verify_Watch_Live_Now_NBCRESP_1956")
	
	 public void VerifyWatchLiveShow() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_Watch_Live_Now_NBCRESP_1956();
	  }
				
	

}


	
	

