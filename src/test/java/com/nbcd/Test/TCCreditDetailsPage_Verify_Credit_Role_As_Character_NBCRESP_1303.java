package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGCreditDetailsPage;

public class TCCreditDetailsPage_Verify_Credit_Role_As_Character_NBCRESP_1303 extends GetWebDriverInstance
{   
	@Test(groups="TCCreditDetailsPage_Verify_Credit_Role_As_Character_NBCRESP_1303")
		
	 public void TCCreditDetailsPage_Verify_Credit_As_Character() throws Exception 
	 {
		PGCreditDetailsPage objSP = new PGCreditDetailsPage(driver);
		objSP.Verify_Credit_Details_as_Character_NBCRESP_1303();
	 }
				
	

}


	
	

