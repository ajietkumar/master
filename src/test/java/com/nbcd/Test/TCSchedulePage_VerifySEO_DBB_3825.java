package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_VerifySEO_DBB_3825  extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_VerifySEO_DBB_3825")
	
	 public void VerifySEOmetatags() throws Exception 
	 {
			PGSchedulePage objSP = new PGSchedulePage(driver);
			objSP.VerifySEO_DBB_3825();
     }
				
	

}


	
	

