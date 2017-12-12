package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;
public class TCAllVideosPage_Meta_tag extends GetWebDriverInstance
{
	@Test(groups="TCAllVideosPage_Meta_tag")
	
	 public void TCAllVideosPage_metatag() throws Exception 
	 {
		PGAllVideosPage objSP = new PGAllVideosPage(driver);
		objSP.Verify_Meta_Property();
     }
				
	

}


	
	

