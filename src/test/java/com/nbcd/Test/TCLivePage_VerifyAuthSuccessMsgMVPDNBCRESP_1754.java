package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGLivePage;

public class TCLivePage_VerifyAuthSuccessMsgMVPDNBCRESP_1754 extends GetWebDriverInstance
{
	 
	@Test(groups="TCLivePage_VerifyAuthSuccessMsgMVPDNBCRESP_1754")
	 
	 public void VerifyAuthSuccessMsgMVPDNBCRESP_1754() throws  Exception 
	 {

		PGLivePage objHP = new PGLivePage(driver);
		
		objHP.VerifyAuthSuccessMsgMVPDNBCRESP_1754();
		
	 }
}