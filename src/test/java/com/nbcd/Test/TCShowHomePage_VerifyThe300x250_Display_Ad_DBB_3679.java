package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage_VerifyThe300x250_Display_Ad;

public class TCShowHomePage_VerifyThe300x250_Display_Ad_DBB_3679  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage_VerifyThe300x250_Display_Ad")
	
	public void Verify_Display_Ad() throws Exception 
	 {
		PGShowHomePage_VerifyThe300x250_Display_Ad objSP = new PGShowHomePage_VerifyThe300x250_Display_Ad(driver);
		objSP.VerifyDisplayAD_DBB_3679();
		
	}
				
	

}


	
	

