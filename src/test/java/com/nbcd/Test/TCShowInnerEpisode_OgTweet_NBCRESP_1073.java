package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_OgTweet_NBCRESP_1073 extends GetWebDriverInstance
{
	
	@Test(groups="TCShowInnerEpisodes")
	


public void OgTweet() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.OgTweet();

}
			
}