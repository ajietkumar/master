package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_Meta_Tag_for_Apple_NBCRESP_1012  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage2")
	
	public void Verify_Meta_Tag_for_Apple() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_meta_Tag_for_apple();
		
	 }
				
	

}


	
	

