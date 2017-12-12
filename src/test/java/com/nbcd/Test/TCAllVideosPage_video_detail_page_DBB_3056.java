package com.nbcd.Test;


import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAllVideosPage;

public class TCAllVideosPage_video_detail_page_DBB_3056 extends GetWebDriverInstance
{
	
	@Test(groups="TCAllVideosPage_video_detail_page_DBB_3056")
	
	 public void TCAllVideosPage_video_detailpage() throws Exception 
	 {
			PGAllVideosPage objSP = new PGAllVideosPage(driver);
			objSP.Verify_video_detail_page_DBB_3056();
	 }
				
	

}


	
	

