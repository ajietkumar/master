package com.nbcd.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGContactUs;

public class TCContactUsCreateRequest_1567 extends GetWebDriverInstance
{ 
	
	@Test(groups="TCContactUsCreateRequest_1567")
	 
	 public void CreateContactUsRequest() throws Exception 
	 {

		PGContactUs objHP = new PGContactUs(driver);
		
		objHP.CreateContactUsRequest_1567();
		
	 }
}
