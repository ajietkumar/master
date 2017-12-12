package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;
@Test
public class TCShowHomePage_Verify_Description_Canonical_DBB_3686  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage_VerifyThe300x250_Display_Ad")
	
	 public void Verify_Description_Canonical() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Description_Canonical_DBB_3686();
		
	}
				
	

}


	
	

