package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGCreditDetailsPage;
public class TCCreditDetailsPage_Verify_Credit_Role_As_Everyone_NBCRESP_1304 extends GetWebDriverInstance
{   
	@Test(groups="TCCreditDetailsPage_Verify_Credit_Role_As_Everyone_NBCRESP_1304")
	 
	public void TCCreditDetailsPage_Verify_Credit_Role_Everyone() throws Exception 
	 {
		PGCreditDetailsPage objSP = new PGCreditDetailsPage(driver);
		objSP.Verify_Credit_Role_As_Everyone_Else_NBCRESP_1304();
	 }
				
	

}


	
	

