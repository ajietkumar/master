package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage_043VerifyTwitterTags;

public class TCShowHomePage_043VerifyTwitterTags_DBB_3079  extends GetWebDriverInstance
{
	
	
	
	@Test(groups="TCShowHomePage")

	 public void TwitterTags() throws Exception 
	 {
		
		PGShowHomePage_043VerifyTwitterTags objSP = new PGShowHomePage_043VerifyTwitterTags(driver);
		
		objSP.VerifyTwitterTags_DBB_3079();

	}
				

}


	
	

