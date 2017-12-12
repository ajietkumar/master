package com.nbcd.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGGlobalHomePage;
public class TCGlobalHomePage_Global_Footerlinks_Nav extends GetWebDriverInstance
{
	
	@Test(groups="TCGlobalHomePage")
	

public void Global_Footerlinks_Nav()  throws Exception 
{
	
		PGGlobalHomePage objSP = new PGGlobalHomePage(driver);
	
	objSP.Global_Footerlinks_Nav();

}
			
}