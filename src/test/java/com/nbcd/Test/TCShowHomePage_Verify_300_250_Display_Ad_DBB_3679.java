package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;
public class TCShowHomePage_Verify_300_250_Display_Ad_DBB_3679  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage")

	public void Verify_300_250_Display_Ad() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_300x250_Display_Ad_DBB_3679();
	 }
	

}


	
	

