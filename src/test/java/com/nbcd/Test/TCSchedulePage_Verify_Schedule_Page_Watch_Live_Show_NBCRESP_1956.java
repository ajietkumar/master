package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Schedule_Page_Watch_Live_Show_NBCRESP_1956  extends GetWebDriverInstance
{   
	@Test(groups="TCSchedulePage_Verify_Schedule_Page_Watch_Live_Show_NBCRESP_1956")
	
	 public void TCSchedulePage_Verify_Schedule_Page_Watch_LiveShow() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_Schedule_Page_Watch_Live_Show_NBCRESP_1956();
		
	 }
				
	

}


	
	

