package com.nbcd.Test;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
@Test
public class TCShowInnerEpisode_Seasonimagemeta_NBCRESP_1082 extends GetWebDriverInstance
{
	
	
	@Test(groups="TCShowInnerEpisodes")


public void Seasonimagemeta() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.Seasonimagemeta();

}
			
}