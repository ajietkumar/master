//==============================Package Declaration================================================================================
package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGHomePage;

//==========================Business Validation Logic================================================================================
@Test
public class TCHomePage  extends GetWebDriverInstance
{
	@Test(groups="TCHomePage")
	 public void MenuDetails() throws Exception
	 {
		PGHomePage objHP = new PGHomePage(driver);
		objHP.MenuDetails();
     }
}
