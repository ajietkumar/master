package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGCreditLandingPage;
public class TCCreditLandingPage_Verify_Credit_Role_As_Character_NBCRESP_1312 extends GetWebDriverInstance
{
	@Test(groups="TCCreditLandingPage_Verify_Credit_Role_As_Character_NBCRESP_1312")
	
	 public void TCCreditLandingPage_Verify_Credit_Role_Character() throws Exception 
	 {
			PGCreditLandingPage objSP = new PGCreditLandingPage(driver);
			objSP.Verify_Credit_Role_as_Character_NBCRESP_1312();
	 }
				
	

}


	
	

