package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;

public class TCAllVideosPage_redirect_rules_DBB_3761 extends GetWebDriverInstance
{
	
	@Test(groups="TCAllVideosPage_redirect_rules_DBB_3761")
	
	 public void TCAllVideosPage_redirectrules() throws Exception 
	 {
		PGAllVideosPage objSP = new PGAllVideosPage(driver);
		objSP.Verify_Page_redirect_DBB_3761();
	 }
				
	

}


	
	

