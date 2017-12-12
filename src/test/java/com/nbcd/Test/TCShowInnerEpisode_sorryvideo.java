package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_sorryvideo extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")
	


public void sorryvideo() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.sorryvideo();

}
			
}