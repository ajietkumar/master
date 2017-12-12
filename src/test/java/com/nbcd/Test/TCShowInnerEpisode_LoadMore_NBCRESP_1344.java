package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_LoadMore_NBCRESP_1344 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")
	

public void LoadMore() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.LoadMore();

}
			
}