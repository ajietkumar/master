package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;
public class TCAllVideosPage_Meta_tag_NBCRESP_1012 extends GetWebDriverInstance
{
	@Test(groups="TCAllVideosPage_Meta_tag")
	
	 public void TCAllVideosPage_metatag() throws Exception 
	 {
		PGAllVideosPage objSP = new PGAllVideosPage(driver);
		objSP.Verify_Meta_Tag_NBCRESP_1012();
     }
				
	

}


	
	

