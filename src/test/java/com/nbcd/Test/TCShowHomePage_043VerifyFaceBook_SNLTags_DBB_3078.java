package com.nbcd.Test;


import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage_043VerifyFacebook_SNLTags;
public class TCShowHomePage_043VerifyFaceBook_SNLTags_DBB_3078  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage")
	
	public void FB_SNLTags() throws Exception 
	 {
		PGShowHomePage_043VerifyFacebook_SNLTags objSP = new PGShowHomePage_043VerifyFacebook_SNLTags(driver);
		objSP.VerifyFB_SNLTags_DBB_3078();
		
	}
				
	

}


	
	

