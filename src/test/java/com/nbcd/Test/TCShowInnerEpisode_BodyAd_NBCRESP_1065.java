package com.nbcd.Test;
//==============================Package Declaration================================================================================

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
//==============================Business Validation Logic================================================================================

public class TCShowInnerEpisode_BodyAd_NBCRESP_1065 extends GetWebDriverInstance
{

	@Test(groups="TCShowInnerEpisodes")

	public void BodyAd() throws Exception 
	{
		
		PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
		
		objSP.BodyAd();
	
	}
			
}