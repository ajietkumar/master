package com.nbcd.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGShowInnerEpisodes;
public class TCShowInnerEpisode_availablenav extends GetWebDriverInstance
{
	
	@Test(groups="TCShowInnerEpisodes")
	
	@Parameters({ "Browser"})

public void availablenav() throws Exception
{
	
	PGShowInnerEpisodes objSP = new PGShowInnerEpisodes(driver);
	
	objSP.availablenav();

}
			
}