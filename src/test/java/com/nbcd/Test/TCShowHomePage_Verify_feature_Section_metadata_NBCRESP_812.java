package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_feature_Section_metadata_NBCRESP_812  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage2")
	
	public void Verify_Latest_Clips_Section() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_metadata_for_Feature_NBCRESP_812();
		
	 }
				
	

}


	
	

