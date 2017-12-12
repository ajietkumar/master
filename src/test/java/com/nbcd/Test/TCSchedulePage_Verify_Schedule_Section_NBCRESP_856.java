package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Schedule_Section_NBCRESP_856  extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_Verify_Schedule_Section_NBCRESP_856")
	
	 public void TCSchedulePage_Verify_Schedule_Section_Page() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_Schedule_section_Page_NBCRESP_856();
		

	}
				

}


	
	

