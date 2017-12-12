package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;
public class TCAllVideosPage_All_Videos_Landing_Page_3798 extends GetWebDriverInstance
{
	
	@Test(groups="TCAllVideosPage_All_Videos_Landing_Page_3798")
	
	public void TCAllVideosPage_video_Landing_Page () throws Exception 
	 {
		PGAllVideosPage	objSP = new PGAllVideosPage(driver);
		objSP.Verify_All_Videos_Landing_Page_DBB_3798();
		

	}
				
	

}


	
	

