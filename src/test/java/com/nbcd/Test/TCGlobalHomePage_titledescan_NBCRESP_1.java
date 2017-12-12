package com.nbcd.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGGlobalHomePage;
public class TCGlobalHomePage_titledescan_NBCRESP_1 extends GetWebDriverInstance
{
	
	@Test(groups="TCGlobalHomePage")
	
	@Parameters({ "Browser"})

public void titledescan() throws Exception 
{
	
		PGGlobalHomePage objSP = new PGGlobalHomePage(driver);
	
	objSP.titledescan();

}
			
}