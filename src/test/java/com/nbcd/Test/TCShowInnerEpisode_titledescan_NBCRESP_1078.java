package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_titledescan_NBCRESP_1078 extends GetWebDriverInstance
{

	
	@Test(groups="TCShowInnerEpisodes")
	


public void titledescan() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.titledescan();

}
			
}