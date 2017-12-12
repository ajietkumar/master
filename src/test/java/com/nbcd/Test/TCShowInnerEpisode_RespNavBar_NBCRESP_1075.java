package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_RespNavBar_NBCRESP_1075 extends GetWebDriverInstance
{
	
@Test(groups="TCShowInnerEpisodes")
	
public void RespNavBar() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.RespNavBar();

}
			
}