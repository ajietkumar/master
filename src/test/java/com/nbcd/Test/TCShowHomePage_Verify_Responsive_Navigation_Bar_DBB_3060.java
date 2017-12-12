package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;
public class TCShowHomePage_Verify_Responsive_Navigation_Bar_DBB_3060  extends GetWebDriverInstance
{
	@Test(groups="TCShowHomePage_Verify_Responsive_Navigation_Bar")
	
	 public void Verify_Responsive_Navigation_Bar() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Responsive_Navigation_Bar_DBB_3060();
	 }
				
	

}


	
	

