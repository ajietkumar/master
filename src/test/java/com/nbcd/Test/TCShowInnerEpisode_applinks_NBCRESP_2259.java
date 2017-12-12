package com.nbcd.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_applinks_NBCRESP_2259 extends GetWebDriverInstance
{
	
	@Test(groups="TCShowInnerEpisodes")
	

public void applinks() throws Exception 
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.applinks();

}
			
}