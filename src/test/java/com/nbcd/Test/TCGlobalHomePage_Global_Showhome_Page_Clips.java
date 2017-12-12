package com.nbcd.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGGlobalHomePage;
public class TCGlobalHomePage_Global_Showhome_Page_Clips extends GetWebDriverInstance
{
	
	@Test(groups="TCGlobalHomePage")
	

public void Global_Showhome_Page_Clips()  throws Exception 
{
	
		PGGlobalHomePage objSP = new PGGlobalHomePage(driver);
	
	objSP.Global_Showhome_Page_Clips();

}
			
}