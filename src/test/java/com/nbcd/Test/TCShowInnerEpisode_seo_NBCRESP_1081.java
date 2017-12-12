package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_seo_NBCRESP_1081 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")
	


public void seo() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.seo();

}
			
}