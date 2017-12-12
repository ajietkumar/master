package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGCreditLandingPage;
public class TCCreditLandingPage_Verify_Credit_Role_As_Coach_NBCRESP_1341 extends GetWebDriverInstance
{
	@Test(groups="TCCreditLandingPage_Verify_Credit_Role_As_Coach_NBCRESP_1341")
	
	 public void TCCreditLandingPage_Verify_Credit_Role_Coach() throws Exception 
	 {
		
		PGCreditLandingPage objSP = new PGCreditLandingPage(driver);
			objSP.Verify_Credit_Role_as_Coach_NBCRESP_1341();
	 }
				
	

}


	
	

