package com.nbcd.Test;


import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;

public class TCAllVideosPage_Metadata_Enhancements_DBB_3727 extends GetWebDriverInstance
{
	
	@Test(groups="TCAllVideosPage_Metadata_Enhancements_DBB_3727")
	
	 public void TCAllVideosPage_MetadataEnhancements() throws Exception 
	 {
		PGAllVideosPage	objSP = new PGAllVideosPage(driver);
		objSP.Verify_Metadata_Enhancements_DBB_3727();
		
	 }
	

}


	
	

