package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_ehsf_NBCRESP_1067 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")
	
	

public void ehsf() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.ehsf();

}
			
}