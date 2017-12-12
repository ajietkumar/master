package com.nbcd.Test;

import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGPhotosDetailsPage;
public class TCPhotoDetailsPage  extends GetWebDriverInstance
{
	@Test(groups="TCPhotoDetailsPage")
	
	 public void VerifyPhotoDetails_Page() throws Exception 
	 {
		PGPhotosDetailsPage objSP = new PGPhotosDetailsPage(driver);
			objSP.Verify_PhotoDetailsPage();
     }
				
	

}


	
	

