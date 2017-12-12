package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;

public class TCSchedulePage_Verify_visitSiteLink_NBCRESP_1957 extends GetWebDriverInstance
{   
	@Test(groups="TCSchedulePage_Verify_visitSiteLink_NBCRESP_1957")
	
	 public void TCSchedulePage_Verify_Schedule_PageTitile( ) throws Exception 
	 {
			PGSchedulePage objSP = new PGSchedulePage(driver);
			objSP.Verify_visitSiteLink_NBCRESP_1957();
	 }
				
	

}

