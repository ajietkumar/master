package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_schemaorgs_NBCRESP_1080 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")


public void schemaorg() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.schemaorg();

}
			
}