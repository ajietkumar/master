package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_Latest_Clips_Section_DBB_3059  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage")
	
	public void Verify_Latest_Clips_Section() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Latest_Clips_Section_DBB_3059();
		
	 }
				
	

}


	
	

