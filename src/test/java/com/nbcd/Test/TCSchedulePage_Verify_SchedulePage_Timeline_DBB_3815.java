package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGSchedulePage;
public class TCSchedulePage_Verify_SchedulePage_Timeline_DBB_3815 extends GetWebDriverInstance
{
	@Test(groups="TCSchedulePage_Verify_SchedulePage_Timeline_DBB_3815")
	
	 public void TCSchedulePage_VerifySchedulePageTimeline() throws Exception 
	 {
		PGSchedulePage objSP = new PGSchedulePage(driver);
		objSP.Verify_SchedulePage_Timeline_DBB_3815();
	 }

}


	
	

