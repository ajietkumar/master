package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSearchPage;



public class TCSeachPage_verify_Collection_of_3_shows  extends GetWebDriverInstance
{
	@Test(groups="PGSearchPage")
	

	 public void Verify_Show_Name() throws Exception 
	 {
		PGSearchPage objSP = new PGSearchPage(driver);
		objSP.Verify_Collection_of_3_shows();

	}
				

}


	
	

