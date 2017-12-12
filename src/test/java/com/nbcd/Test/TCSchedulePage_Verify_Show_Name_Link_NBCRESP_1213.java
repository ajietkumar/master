package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Show_Name_Link_NBCRESP_1213  extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_Verify_Show_Name_Link_NBCRESP_1213")
	
	 public void SchedulePage_Verify_Show_NameLink() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_Responsive_Show_Name_Link_NBCRESP_1213();
		
	 }
				
	

}


	
	

