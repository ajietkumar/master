package com.nbcd.Test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;

import com.nbcd.Pages.PGBreakingNewsBar;
@Test
public class TCBreakingNewsBar_NBCRESP_1791  extends GetWebDriverInstance
{
	
	
	@Test(groups="TCBreakingnewsbar")
	
	
	 public void BreakingNewsbar() throws Exception 
	 {
		
		PGBreakingNewsBar objSP = new PGBreakingNewsBar(driver);
		
		objSP.BreakingNewsbar();

	}
				
	

}


	
	

