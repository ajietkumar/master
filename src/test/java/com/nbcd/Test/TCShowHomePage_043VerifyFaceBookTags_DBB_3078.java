package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage;

public class TCShowHomePage_043VerifyFaceBookTags_DBB_3078  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")
		
	public void FBTags() throws Exception 
	 {
		PGShowHomePage objSP = new PGShowHomePage(driver);
		objSP.VerifyFBTags_DBB_3078();
		
	}
				

}


	
	

