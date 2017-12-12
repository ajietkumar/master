package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Schedule_Whats_On_Page_DBB_3813  extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_Verify_Schedule_Whats_On_Page_DBB_3813")
	
	 public void TCSchedulePage_Verify_Schedule_WhatsOnPage() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_Schedule_Page_Whats_On_Header_DBB_3813();
	 }
	
}


	
	

