package com.nbcd.Test;
//==============================Package Declaration================================================================================

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
//==============================Business Validation Logic================================================================================

public class TCShowInnerEpisode_Bannerad_NBCRESP_1063 extends GetWebDriverInstance
{

	@Test(groups="TCShowInnerEpisodes_Bannerad_NBCRESP_1063")

	public void Bannerad_NBCRESP_1063() throws Exception 
	{
		
		PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
		
		objSP.Bannerad_NBCRESP_1063();
	
	}
			
}