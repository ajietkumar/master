package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;
public class TCAllVideosPage_Episodes_Sorted_NBCRESP_1438 extends GetWebDriverInstance
{
	@Test(groups="TCAllVideosPage_Episodes_Sorted_NBCRESP_1438")
	
	 public void TCAllVideosPage_EpisodesSorted() throws Exception 
	 {
		
		PGAllVideosPage objSP = new PGAllVideosPage(driver);
		objSP.Verify_Episodes_Sorted_NBCRESP_1438();
	 }

}


	
	

