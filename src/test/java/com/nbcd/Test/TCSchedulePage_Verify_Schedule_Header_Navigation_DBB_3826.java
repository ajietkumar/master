package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Schedule_Header_Navigation_DBB_3826  extends GetWebDriverInstance
{
	
	@Test(groups="TCSchedulePage_Verify_Schedule_Header_Navigation_DBB_3826")
	
	 public void TCSchedulePage_Verify_Schedule_HeaderNavigation() throws Exception 
	 {
			PGSchedulePage objSP = new PGSchedulePage(driver);
			objSP.Verify_Schedule_Page_Header_Navigation_DBB_3826();
	 }
				
	

}


	
	

