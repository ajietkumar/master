package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_urlredirect_NBCRESP_1066 extends GetWebDriverInstance
{

	
	@Test(groups="TCShowInnerEpisodes")


public void urlredirect() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.urlredirect();

}
			
}