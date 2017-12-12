package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowHomePage2;

public class TCShowHomePage_Verify_Add_Guest_Schedule_DBB_3689  extends GetWebDriverInstance
{
	
	@Test(groups="TCShowHomePage")
	
	public void Verify_Add_Guest_Schedule() throws Exception 
	 {
		PGShowHomePage2 objSP = new PGShowHomePage2(driver);
		objSP.Verify_Add_Guest_Schedule_DBB_3689();
		

	}
				


}


	
	

