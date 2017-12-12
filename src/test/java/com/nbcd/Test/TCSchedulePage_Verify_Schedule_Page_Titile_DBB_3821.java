package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_Schedule_Page_Titile_DBB_3821  extends GetWebDriverInstance
{   
	@Test(groups="TCSchedulePage_Verify_Schedule_Page_Titile_DBB_3821")
	
	 public void TCSchedulePage_Verify_Schedule_PageTitile( ) throws Exception 
	 {
			PGSchedulePage objSP = new PGSchedulePage(driver);
			objSP.Verify_Schedule_Page_Title_DBB_3821();
	 }
				
	

}


	
	

