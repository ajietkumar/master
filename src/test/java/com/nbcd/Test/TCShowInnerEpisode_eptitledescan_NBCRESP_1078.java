package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_eptitledescan_NBCRESP_1078 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")
	


public void eptitledescan() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.eptitledescan();

}
			
}