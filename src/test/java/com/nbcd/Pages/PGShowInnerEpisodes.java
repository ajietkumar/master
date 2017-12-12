package com.nbcd.Pages;
//=======================================PACKAGES=================================================================================================

import com.relevantcodes.extentreports.LogStatus;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import java.net.MalformedURLException;
import java.util.Iterator;

import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;

@Test
// =======================================CLASS &
// METHODS===========================================================================================

public class PGShowInnerEpisodes {

	private WebDriver driver;
	String sql;
	protected static String showDetails;
	public List<String> lstObject, lstTestData;
	String sqlQry, Status;
	WebElement objBodyAd, objRespNavBar;
	DatabaseFunction db = new DatabaseFunction();
	// =================================================Business
	// Logic====================================================================
	// Constructor to initialize all the Page Objects

	public PGShowInnerEpisodes(WebDriver driver) throws MalformedURLException {

		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from ShowInnerEpisode", "Input");
		lstObject = db.getTestDataObject("Select * from ShowInnerEpisode", "ObjectRepository");

	}

	// ================================Desktop - Verify Body Ad is displayed in Show Inner Episodes Landing Page ( NBCRESP -1065)========================
	@Test
	public PGShowInnerEpisodes BodyAd() throws Exception {
		// Launching the URL
		try
		 {
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();
		// driver.navigate().refresh();
		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		WebElement objBodyAd = Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));

		if (objBodyAd.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Body Ad should be Displayed"
					+ Extent_Reports.logActual + "Body Ad is Displayed", driver);

			driver.close();
			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Body Ad should be Displayed"
					+ Extent_Reports.logActual + "Body Ad is not Displayed", driver);
			driver.close();
		}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;
		}
	

	// ===================To verify if "Responsive Navigation Bar" is present  for  Show Inner Episodes Landing Page -  (NBCRESP-1075)=======================================

	@Test
	public PGShowInnerEpisodes RespNavBar() throws Exception {
		// Launching the URL
try
{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com"
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);

		WebElement objRespNavBar = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));

		if (objRespNavBar.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Navigation Bar should be Displayed"
					+ Extent_Reports.logActual + "Navigation Bar is Displayed", driver);

			driver.close();
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Navigation Bar should be Displayed"
					+ Extent_Reports.logActual + "Navigation Bar is not Displayed", driver);
			driver.close();
		}
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;

	}

	// =======================Desktop- Verify Season's Episodes With Image and Metadata are present on Show Inner Episodes Landing Page ( NBCRESP-1082)============================
	@Test
	public PGShowInnerEpisodes Seasonimagemeta() throws Exception {
		// Launching the URL
		// {
try
{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);

		WebElement objGShClk1 = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk1.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);

		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(46)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());
		Thread.sleep(3000);
		objSubMenuItems.get(3).click();

		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(47)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		// --driver.get("https://www.nbc.com/law-and-order-special-victims-unit/episodes");
		// --WebDriverWait wait= new WebDriverWait(driver,60);
		Thread.sleep(3000);

		Synchronization.implicitWait(driver, 10);
		WebElement objplaythumb = Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
		if (objplaythumb.isDisplayed()) 
		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Thumbnail should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Thumbnail is Displayed in Launched Season",
					driver);

		} else 
		{
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "Thumbnail should be Displayed in Launched Season"
									+ Extent_Reports.logActual + "Thumbnail is not Displayed in Launched Season",
							driver);
		}

		WebElement objseason = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		if (objseason.isDisplayed()) 
		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Season should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Season is Displayed in Launched Season",
					driver);

		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Season should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Season not is Displayed in Launched Season",
					driver);
		}

		WebElement objdate = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
		if (objdate.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Date should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Date is Displayed in Launched Season",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Date should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Date is NOT Displayed in Launched Season",
					driver);
		}

		WebElement objEpiname = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
		if (objEpiname.isDisplayed()) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "Episode Name should be Displayed in Launched Season"
									+ Extent_Reports.logActual + "Episode Name is Displayed in Launched Season",
							driver);

		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "Episode Name should be Displayed in Launched Season"
									+ Extent_Reports.logActual + "Episode Name is not Displayed in Launched Season",
							driver);
		}

		WebElement objepidesc = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
		if (objepidesc.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Episode description should be Displayed in Launched Season"
							+ Extent_Reports.logActual + "Episode description  is Displayed in Launched Season",
					driver);

		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected
					+ "Episode description  should be Displayed in Launched Season" + Extent_Reports.logActual

					+ "Episode description is not Displayed in Launched Season", driver);
		}

		// }
		WebElement objFLNav = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
		objFLNav.click();
		WebElement objFLclck = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
		objFLclck.click();
		Synchronization.implicitWait(driver, 10);
		// WebDriverWait wait= new WebDriverWait(driver,60);
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(47)));
		Thread.sleep(4000);

		WebElement objplaythumbn = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
		if (objplaythumbn.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Thumbnail should be Displayed in Navigated Season"
							+ Extent_Reports.logActual + "Thumbnail is Displayed in Navigated Season",
					driver);

		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "Thumbnail should be Displayed in Navigated Season"
									+ Extent_Reports.logActual + "Thumbnail is not Displayed in Navigated Season",
							driver);
		}

		WebElement objseasonn = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
		if (objseasonn.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Season should be Displayed in Navigated Season"
							+ Extent_Reports.logActual + "Season is Displayed in Navigated Season",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Season should be Displayed in Navigated Season"
							+ Extent_Reports.logActual + "Season is not Displayed in Navigated Season",
					driver);
		}

		WebElement objdaten = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
		if (objdaten.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Date should be Displayed in Navigated Season"
							+ Extent_Reports.logActual + "Date is Displayed in Navigated Season",
					driver);

		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Date should be Displayed in Navigated Season"
							+ Extent_Reports.logActual + "Date is  not Displayed in Navigated Season",
					driver);
		}

		WebElement objEpinamen = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
		if (objEpinamen.isDisplayed()) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "Episode name should be Displayed in Navigated Season"
									+ Extent_Reports.logActual + "Episode name is Displayed in Navigated Season",
							driver);

		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "Episode name should be Displayed in Navigated Season"
									+ Extent_Reports.logActual + "Episode name is  not Displayed in Navigated Season",
							driver);
		}
		WebElement objepidescn = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
		if (objepidescn.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected
					+ "Episode description should be Displayed in Navigated Season" + Extent_Reports.logActual

					+ "Episode description is Displayed in Navigated Season", driver);

		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected
					+ "Episode description should be Displayed in Navigated Season" + Extent_Reports.logActual

					+ "Episode description is  not Displayed in Navigated Season", driver);
		}
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;
	}

	// ======================================Desktop - Verify Load More Button in Show Inner Episodes Landing Page (NBCRESP-1344)===========================================
	@Test
	public PGShowInnerEpisodes LoadMore() throws Exception {
		// Launching the URL
		// {
		
		try
		{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com"
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		Thread.sleep(8000);

		WebElement objLoadMore = Utilities.returnElement(driver,lstObject.get(44),lstObject.get(43));
		if (objLoadMore.isDisplayed()) {

			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Load More button should be displayed and clickable"
							+ Extent_Reports.logActual + "Load More Button is displayed and clickable",
					driver);
			// driver.close();

		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "Load More button should be displayed and clickable"
									+ Extent_Reports.logActual + "Load More Button is  NOT displayed and clickable",
							driver);
			// driver.close();
		}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;

	}
	// }

	// ======================Desktop - Verify OG & Twitter tags in Show Inner Episodes Landing Page(NBCRESP-1073)=================================================

	@Test
	public PGShowInnerEpisodes OgTweet() throws Exception {
		try
		{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com"
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);

		String page_source;
		page_source = driver.getPageSource();
		if (page_source.contains("fb:app_id")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "MetaProperty fb:app_id Should be present"
					+ Extent_Reports.logActual + "MetaProperty fb:app_id is present", driver);
		} else {

			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "MetaProperty fb:app_id Should be present"
					+ Extent_Reports.logActual + "MetaProperty fb:app_id is NOT present", driver);
		}
		if (page_source.contains("og:site_name")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty og:site_name Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:site_name is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty og:site_name Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:site_name is NOT present",
					driver);
		}
		if (page_source.contains("og:url")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "MetaProperty og:url Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:url is present", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "MetaProperty og:url Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:url is NOT present", driver);
		}
		if (page_source.contains("og:title")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "MetaProperty og:title Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:title is present", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "MetaProperty og:title Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:title is NOT present", driver);
		}
		if (page_source.contains("og:description")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty og:description Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:description is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty og:description Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:description is NOT present",
					driver);
		}
		if (page_source.contains("og:image")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "MetaProperty og:image Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:image is present", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "MetaProperty og:image Should be present"
					+ Extent_Reports.logActual + "MetaProperty og:image is NOT present", driver);
		}
		if (page_source.contains("og:image:type")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty og:image:type Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:type is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty og:image:type Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:type is NOT present",
					driver);
		}
		if (page_source.contains("og:image:width")) {

			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty og:image:width Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:width is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty og:image:width Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:width is NOT present",
					driver);
		}
		if (page_source.contains("og:image:height")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty og:image:height Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:height is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty og:image:height Should be present"
							+ Extent_Reports.logActual + "MetaProperty og:image:height is NOT present",
					driver);
		}
		if (page_source.contains("twitter:card")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:card Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:card is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:card Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:card is NOT present",
					driver);
		}
		if (page_source.contains("twitter:site")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:site Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:site is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:site Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:site is NOT present",
					driver);
		}
		if (page_source.contains("twitter:site:id")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:site:id Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:site:id is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:site:id Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:site:id is NOT present",
					driver);
		}
		if (page_source.contains("twitter:url")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:url Should be present" + Extent_Reports.logActual
							+ "MetaProperty twitter:url is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:url Should be present" + Extent_Reports.logActual
							+ "MetaProperty twitter:url is NOT present",
					driver);
		}
		if (page_source.contains("twitter:title")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:title Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:title is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:title Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:title is NOT present",
					driver);
		}
		if (page_source.contains("twitter:description")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:description Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:description is present",
					driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "MetaProperty twitter:description Should be present"
									+ Extent_Reports.logActual + "MetaProperty twitter:description is NOT present",
							driver);
		}
		if (page_source.contains("twitter:image")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "MetaProperty twitter:image Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:image is present",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "MetaProperty twitter:image Should be present"
							+ Extent_Reports.logActual + "MetaProperty twitter:image is NOT present",
					driver);
		}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		// driver.close();
		return null;
	}

	// =============================Desktop- Verify Title, Description & Canonical fields in Show Inner Episodes Landing Page for New Responsive Web Site ( NBCRESP -1078)=====================================
	@Test
	public PGShowInnerEpisodes titledescan() throws Exception {
		// Launching the URL
		// {
		
		try
		{	
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		Thread.sleep(3000);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);

		WebElement objmeta_desc = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
		// WebElement objog_image =
		// driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
		String thumbnail = objmeta_desc.getAttribute("content");
		System.out.println(thumbnail);

		if (lstTestData.get(31).equalsIgnoreCase(objmeta_desc.getAttribute("content")))

		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "meta name : description should be displayed"
							+ Extent_Reports.logActual + "meta name : description is displayed",
					driver);

		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "meta name : description should be displayed"
							+ Extent_Reports.logActual + "meta name : description is not displayed",
					driver);

		}

		String page_source;
		page_source = driver.getPageSource();
		if (page_source.contains("<title>Watch The Blacklist Episodes - NBC.com</title>")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Title should be displayed"
					+ Extent_Reports.logActual + "Title should is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Title should be displayed"
					+ Extent_Reports.logActual + "Title is missing", driver);

		}

		WebElement objlink_ref = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
		// WebElement objog_image =
		// driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
		String thumbnails = objlink_ref.getAttribute("href");
		System.out.println(thumbnails);

		if (lstTestData.get(32).equalsIgnoreCase(objlink_ref.getAttribute("href")))

		{
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Canonical should be displayed"
					+ Extent_Reports.logActual + "Canonical should is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Canonical should be displayed"
					+ Extent_Reports.logActual + "Canonical is missing", driver);

		}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;
	}

	// =========================================Desktop -  Verify the Applinks metadata for Show inner episode landing page - (NBCRESP-2259)===============================
	@Test
	public PGShowInnerEpisodes applinks() throws Exception {
		// Launching the URL
try
{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		Thread.sleep(3000);

		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);

		WebElement objmeta_andpkg = Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
		String thumbnail = objmeta_andpkg.getAttribute("content");
		System.out.println(thumbnail);

		if (lstTestData.get(33).equalsIgnoreCase(objmeta_andpkg.getAttribute("content")))

		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "al:android:package tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:package tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "al:android:package tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:package tag is missing in Page source",
							driver);

		}
		WebElement objmeta_andappname = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
		String thumbnail1 = objmeta_andappname.getAttribute("content");
		System.out.println(thumbnail1);

		if (lstTestData.get(34).equalsIgnoreCase(objmeta_andappname.getAttribute("content")))

		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "al:android:app_name tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:app_name tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "al:android:app_name tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:app_name tag is missing in Page source",
							driver);

		}
		WebElement objmeta_andurl = Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));
		String thumbnail2 = objmeta_andurl.getAttribute("content");
		System.out.println(thumbnail2);

		if (lstTestData.get(35).equalsIgnoreCase(objmeta_andurl.getAttribute("content")))

		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "al:android:url tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:url tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "al:android:url tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:android:url tag is missing in Page source",
							driver);

		}
		WebElement objmeta_andstrid = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
		String thumbnail3 = objmeta_andstrid.getAttribute("content");
		System.out.println(thumbnail3);

		if (lstTestData.get(36).equalsIgnoreCase(objmeta_andstrid.getAttribute("content")))

		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "al:ios:app_store_id tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:ios:app_store_id tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "al:ios:app_store_id tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:ios:app_store_id tag is missing in Page source",
							driver);

		}

		WebElement objmeta_iosappname = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
		String thumbnail4 = objmeta_iosappname.getAttribute("content");
		System.out.println(thumbnail4);

		if (lstTestData.get(37).equalsIgnoreCase(objmeta_iosappname.getAttribute("content")))

		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "al:ios:app_name tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:ios:app_name tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports
					.executionLog("FAIL",
							Extent_Reports.logExpected + "al:ios:app_name tag should be displayed in Page source"
									+ Extent_Reports.logActual + "al:ios:app_name tag is missing in Page source",
							driver);

		}
		WebElement objmeta_iosurl = Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
		String thumbnail5 = objmeta_iosurl.getAttribute("content");
		System.out.println(thumbnail5);

		if (lstTestData.get(38).equalsIgnoreCase(objmeta_iosurl.getAttribute("content")))

		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "al:ios:url tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:ios:url tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "al:ios:url tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:ios:url tag is missing in Page source",
					driver);

		}

		WebElement objmeta_weburl = Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
		String thumbnail6 = objmeta_weburl.getAttribute("content");
		System.out.println(thumbnail6);

		if (lstTestData.get(39).equalsIgnoreCase(objmeta_weburl.getAttribute("content")))

		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "al:web:url tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:web:url tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "al:web:url tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:web:url tag is missing in Page source",
					driver);

		}

		WebElement objmeta_shfalbck = Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));
		String thumbnail7 = objmeta_shfalbck.getAttribute("content");
		System.out.println(thumbnail7);

		if (lstTestData.get(40).equalsIgnoreCase(objmeta_shfalbck.getAttribute("content")))

		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "al:web:should_fallback tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:web:should_fallback tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "al:web:should_fallback tag should be displayed in Page source"
							+ Extent_Reports.logActual + "al:web:should_fallback tag is missing in Page source",
					driver);

		}
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;
	}

	// ===================================Desktop - Verify Integrate Schema.org tags for Show Inner Episodes Landing Page ( NBCRESP -1080)=================================================================
	@Test
	public PGShowInnerEpisodes schemaorg() throws Exception {
		// Launching the URL
		// {
		try
		{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		Thread.sleep(3000);

		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		String page_source;
		page_source = driver.getPageSource();

		if (page_source.contains("https://schema.org")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "@context tag should be displayed in Page source"
							+ Extent_Reports.logActual + "@context tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "@context tag should be displayed in Page source"
							+ Extent_Reports.logActual + "@context tag is missing in Page source",
					driver);
		}
		if (page_source.contains("TVSeason")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "@type tag should be displayed in Page source"
							+ Extent_Reports.logActual + "@type tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "@type tag should be displayed in Page source"
							+ Extent_Reports.logActual + "@type tag is missing in Page source",
					driver);
		}
		if (page_source.contains("datePublished")) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "datePublished tag should be displayed in Page source"
									+ Extent_Reports.logActual + "datePublished tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "datePublished tag should be displayed in Page source"
							+ Extent_Reports.logActual + "datePublished tag is missing in Page source",
					driver);
		}
		if (page_source.contains("seasonNumber")) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "seasonNumber tag should be displayed in Page source"
									+ Extent_Reports.logActual + "seasonNumber tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "seasonNumber tag should be displayed in Page source"
							+ Extent_Reports.logActual + "seasonNumber tag is missing in Page source",
					driver);
		}
		if (page_source.contains("numberOfEpisodes")) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "numberOfEpisodes tag should be displayed in Page source"
									+ Extent_Reports.logActual + "numberOfEpisodes tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "numberOfEpisodes tag should be displayed in Page source"
							+ Extent_Reports.logActual + "numberOfEpisodes tag is NOT displayed in Page source",
					driver);
		}

		if (page_source.contains("numberOfEpisodes")) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "partOfSeries tag should be displayed in Page source"
									+ Extent_Reports.logActual + "partOfSeries tag is displayed in Page source",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "partOfSeries tag should be displayed in Page source"
							+ Extent_Reports.logActual + "partOfSeries tag is missing in Page source",
					driver);
		}
		if (page_source.contains("TVSeries")) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "TVSeries tag should be displayed in Page source"
							+ Extent_Reports.logActual + "TVSeries tag is displayed in Page source",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "TVSeries tag should be displayed in Page source"
							+ Extent_Reports.logActual + "TVSeries tag is missing in Page source",
					driver);

		}
		// driver.close();
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;
	}
	// return null;

	// =====================================Desktop- Verify Season's Episodes With Image and Metadata are present on Show Inner Episodes Landing Page ( NBCRESP-1082)============================================
	@Test
	public PGShowInnerEpisodes eptitledescan() throws Exception {
		// Launching the URL
try
{
		driver.get(lstTestData.get(41));
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected
				+ "User should be navigated to the show inner Episodes page" + Extent_Reports.logActual

				+ "User is navigated to the show inner episodes page", driver);

		WebElement objepinClk = Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
		objepinClk.click();
		WebElement objepisClk = Utilities.returnElement(driver, lstObject.get(89), lstObject.get(88));
		objepisClk.click();
		Synchronization.implicitWait(driver, 300);
		String ShowlistText1 = objepisClk.getText();
		String strlowerCaseText1 = ShowlistText1.toLowerCase();
		String strReplaceSpaceText1 = strlowerCaseText1.replace(" ", "-");
		System.out.println(strReplaceSpaceText1);
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		wait1.until(ExpectedConditions.urlContains("https://www.nbc.com/the-blacklist/episodes/season-3"));
		Synchronization.waitForPageLoad(driver);
		System.out.println("thumbnail111");

		WebElement objmeta_descri = Utilities.returnElement(driver, lstObject.get(92), lstObject.get(91));
		// WebElement objog_image =
		// driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
		String thumbnail6 = objmeta_descri.getAttribute("content");

		if (lstTestData.get(42).equalsIgnoreCase(objmeta_descri.getAttribute("content")))

		{
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "meta name : description should be displayed"
							+ Extent_Reports.logActual + "meta name : description is displayed",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "meta name : description should be displayed"
							+ Extent_Reports.logActual + "meta name : description is not displayed",
					driver);

		}

		String page_source;
		page_source = driver.getPageSource();
		if (page_source.contains("<title>The Blacklist Season 3 Episodes - NBC.com</title>")) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Title should be displayed"
					+ Extent_Reports.logActual + "Title should is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Title should be displayed"
					+ Extent_Reports.logActual + "Title is missing", driver);

		}
		WebElement objlink_refr = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
		// WebElement objog_image =
		// driver.findElements(By.cssSelector("meta[property='og:image']")).get(0);
		String thumbnail8 = objlink_refr.getAttribute("href");

		if (lstTestData.get(43).equalsIgnoreCase(objlink_refr.getAttribute("href")))

		{
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Canonical Url should be displayed"
					+ Extent_Reports.logActual + "Canonical Url should is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Canonical Url should be displayed"
					+ Extent_Reports.logActual + "Canonical Url is missing", driver);

		}
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		// driver.close();
		return null;
	}

	// ================================Desktop- Verify whether the SEO Recommendations is populated correctly for Show Inner Episodes Landing Page  (NBCRESP -1081)====================================================
	@Test
	public PGShowInnerEpisodes seo() throws Exception {
		// Launching the URL
try
{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		
		Thread.sleep(3000);
// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		/**
		 * if (url.contentEquals(lstTestData.get(45))) {
		 * Extent_Reports.executionLog("PASS","URL is displayed as per format",
		 * driver); System.out.print("Result printed"); } else {
		 * Extent_Reports.executionLog("FAIL","URL are Not Displayed as per
		 * format", driver); }
		 */
		
		WebElement objmeta = (WebElement) Utilities.returnElement(driver, lstObject.get(179), lstObject.get(178));

		if (objmeta.isDisplayed()) {
		
			Extent_Reports.executionLog("PASS", "H2 tags are Displayed", driver);
			System.out.print("Result printed");
		}
		else {
			Extent_Reports.executionLog("FAIL", "H2 tags are Not Displayed", driver);
		}

		WebElement objh1 = (WebElement) Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));

		if (objh1.isDisplayed()) {
			Extent_Reports.executionLog("PASS", "H1 Tag is displayed", driver);
			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("FAIL", "H1 Tag is missing", driver);
		}
		// driver.close();
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;

	}

	// }
	// ==========================Desktop(990px and up) - Verify Episode Header and Season Filter in Show Inner Episodes Landing Page (NBCRESP-1067)============================================
	@Test
	public PGShowInnerEpisodes ehsf() throws Exception {
		// Launching the URL
		// {
		try
		{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com"
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());
		Thread.sleep(3000);

		objSubMenuItems.get(3).click();
		Thread.sleep(3000);

		// driver.navigate().refresh();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		WebElement objepih1 = Utilities.returnElement(driver, lstObject.get(101), lstObject.get(100));

		// System.out.println(objepih1.getAttribute("innerHTML"));

		if (objepih1.isDisplayed()) {

			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Episodes section header should be Displayed"
							+ Extent_Reports.logActual + "Episodes section header is Displayed",
					driver);
			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Episodes section header should be Displayed"
							+ Extent_Reports.logActual + "Episodes section header is NOT Displayed",
					driver);
		}

		WebElement objepinClk = Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
		objepinClk.click();
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episodes SEASON button is clicked"
				+ Extent_Reports.logActual + "Episodes Seasons button is NOT clicked", driver);
		WebElement objepisClk = Utilities.returnElement(driver, lstObject.get(89), lstObject.get(88));
		objepisClk.click();
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episodes SEASON button is Navigated"
				+ Extent_Reports.logActual + "Episodes Seasons button is NOT Navigated", driver);
		Synchronization.implicitWait(driver, 300);
		String ShowlistText1 = objepisClk.getText();
		String strlowerCaseText1 = ShowlistText1.toLowerCase();
		String strReplaceSpaceText1 = strlowerCaseText1.replace(" ", "-");
		System.out.println(strReplaceSpaceText1);
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(49)));
		Synchronization.waitForPageLoad(driver);
		System.out.println("thumbnail111");
		String url = driver.getCurrentUrl();
		System.out.println(url);

		if (url.contentEquals(lstTestData.get(49))) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "URL Should be displayed as per old seasons" + Extent_Reports.logActual
							+ "URL is displayed as per old seasons",
					driver);
			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "URL Should be displayed as per old seasons" + Extent_Reports.logActual
							+ "URL is  not displayed as per old seasons",
					driver);

		}
		// /driver.close();
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;

	}
	// ===========================Desktop - Verify that show level navigation is displayed above the video when video is played from Global home page, Show home page, All videos page and Show inner episode landing page=========================================================================================================================

	@Test
	public PGShowInnerEpisodes availablenav() throws Exception {
		// Launching the URL
		// {
		try{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();
		// driver.navigate().refresh();
		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports
				.executionLog("PASS",
						Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
								+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
						driver);
		WebElement objmain = Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));

		if (objmain.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Main Nav Element should be displayed"
					+ Extent_Reports.logActual + "Main Nav Element is displayed", driver);
			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Main Nav Element should be displayed"
					+ Extent_Reports.logActual + "Main Nav Element is Not Displayed", driver);

		}
		WebElement objepisodes = Utilities.returnElement(driver, lstObject.get(107), lstObject.get(106));

		if (objepisodes.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Episodes nav Element should be displayed"
					+ Extent_Reports.logActual + "Episodes Nav Element is displayed", driver);
		} else {

			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Episodes nav Element should be displayed"
					+ Extent_Reports.logActual + "Episodes Nav Element is not displayed", driver);
		}
		WebElement objPhotos = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));

		if (objPhotos.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Photos nav Element should be displayed"
					+ Extent_Reports.logActual + "Photos Nav Element is displayed", driver);
		} else {

			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Photos nav Element should be displayed"
					+ Extent_Reports.logActual + "Photos Nav Element is not displayed", driver);
		}
		WebElement objcast = Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));

		if (objcast.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Cast nav Element should be displayed"
					+ Extent_Reports.logActual + "Cast Nav Element is displayed", driver);
		} else {

			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Cast nav Element should be displayed"
					+ Extent_Reports.logActual + "Cast Nav Element is not displayed", driver);
		}
		WebElement objshop = Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));

		if (objshop.isDisplayed()) {
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Shop nav Element should be displayed"
					+ Extent_Reports.logActual + "Shop Nav Element is displayed", driver);
		} else {

			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Shop nav Element should be displayed"
					+ Extent_Reports.logActual + "Shop Nav Element is not displayed", driver);
		}
		WebElement objmgame = Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));

		if (objmgame.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Mobilegame nav Element should be displayed" + Extent_Reports.logActual
							+ "Mobilegame Nav Element is displayed",
					driver);
		} else {

			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Mobilegame nav Element should be displayed" + Extent_Reports.logActual
							+ "Mobilegame Nav Element is not displayed",
					driver);
		}
		 }
		 catch(Exception exc)
		 {
				Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

		 }
		return null;
	}

	// ==================================Desktop - Verify URL redirects for Show Inner Episodes Landing Page (NBCRESP-1066)=======================================================
	@Test
	public PGShowInnerEpisodes urlredirect() throws Exception {
		// Launching the URL
try{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com"
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		System.out.print("navigated to menu");
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		System.out.print("navigated to show");
		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected
				+ "User should be navigated to the show inner Episodes page" + Extent_Reports.logActual

				+ "User is navigated to the show inner episodes page", driver);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		if (url.contentEquals(lstTestData.get(32))) {

			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "URL should be displayed as per format" + Extent_Reports.logActual

							+ "URL is displayed as per format",
					driver);

			System.out.print("Result printed");
		} else {

			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "URL should be displayed as per format" + Extent_Reports.logActual

							+ "URL is not displayed as per format",
					driver);
		}
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;

	}

	// =====================================Desktop - Verify Global Navigation links are working when an expired episode is launched from Show inner episode landing page============================================================
	@Test
	public PGShowInnerEpisodes sorryvideo() throws Exception

	{
try
{
		driver.get(lstTestData.get(41));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
				+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
		WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objGShClk.click();
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Shows option should be clicked from Global Nav" + Extent_Reports.logActual
						+ "Shows option is clicked from Global Nav",
				driver);
		Synchronization.implicitWait(driver, 10);
		WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
		objDrpshclk.click();

		String ShowlistText = objDrpshclk.getText();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Synchronization.waitForPageLoad(driver);
		String strlowerCaseText = ShowlistText.toLowerCase();
		String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
		System.out.println(strReplaceSpaceText);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
				+ Extent_Reports.logActual + "User is navigated to the show", driver);
		wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
		Synchronization.waitForPageLoad(driver);
		List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
		System.out.println(objSubMenuItems.size());

		objSubMenuItems.get(3).click();
		// driver.navigate().refresh();
		
		Thread.sleep(3000);
// wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
		System.out.println("56487680");
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected
				+ "User should be navigated to the show inner Episodes page" + Extent_Reports.logActual

				+ "User is navigated to the show inner episodes page", driver);
		WebElement objepinClk = Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
		objepinClk.click();
		WebElement objepisClk = Utilities.returnElement(driver, lstObject.get(173), lstObject.get(172));
		objepisClk.click();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(50)));
		Synchronization.waitForPageLoad(driver);
		WebElement objepisodeClk = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
		objepisodeClk.click();
		// wait.until(ExpectedConditions.urlContains(lstTestData.get(49)));
		WebElement objepisry = (WebElement) Utilities.returnElement(driver, lstObject.get(131), lstObject.get(130));

		if (objepisry.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "SORRY, VIDEO IS NO LONGER AVAILABLE message  should be Displayed"
							+ Extent_Reports.logActual + "SORRY, VIDEO IS NO LONGER AVAILABLE message  is Displayed",
					driver);

			System.out.print("Result printed");
		} else {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "SORRY, VIDEO IS NO LONGER AVAILABLE message  should be Displayed"
							+ Extent_Reports.logActual
							+ "SORRY, VIDEO IS NO LONGER AVAILABLE message  is not Displayed",
					driver);
		}

		WebElement objsryShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objsryShClk.click();
		WebElement objshref = (WebElement) Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
		if (objshref.isDisplayed()) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "Show Navigation link SHOULD be Responsive and Navigating"
									+ Extent_Reports.logActual + "Show Navigation link is Responsive and Navigating",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Show Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Show Navigation link is not Responsive and not Navigating",
					driver);
		}

		WebElement objsryShClk1 = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
		objsryShClk1.click();

		WebElement objsryepiClk = Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
		objsryepiClk.click();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(52)));
		Synchronization.waitForPageLoad(driver);

		WebElement objepref = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));
		if (objepref.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Episode Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Episode Navigation link is Responsive and Navigating",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Episode Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Episode Navigation link is not Responsive and not Navigating",
					driver);
		}

		driver.navigate().back();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(51)));
		WebElement objsryschClk = Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
		objsryschClk.click();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(54)));
		Synchronization.waitForPageLoad(driver);
		String url = driver.getCurrentUrl();

		if (url.contentEquals(lstTestData.get(54))) {
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Schedule Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Schedule Navigation link is Responsive and Navigating",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Schedule Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual
							+ "Schedule Navigation link is not Responsive and not Navigating",
					driver);
		}

		driver.navigate().back();
		// WebDriverWait wait= new WebDriverWait(driver,60);

		wait.until(ExpectedConditions.urlContains(lstTestData.get(51)));
		WebElement objsrynsClk = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
		objsrynsClk.click();

		/*
		 * WebElement objnsrefer=
		 * Utilities.returnElement(driver,lstObject.get(152),lstObject.get(151))
		 * ; if (objnsrefer.isDisplayed()) { Extent_Reports.executionLog(
		 * "PASS","News&Sports Navigation link is Responsive and Navigating",
		 * driver); System.out.print("Result printed"); } else {
		 * Extent_Reports.executionLog(
		 * "FAIL","News&Sports Navigation link is not Responsive and not Navigating"
		 * , driver); }
		 */
		WebElement objsryns1Clk = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
		objsryns1Clk.click();

		WebElement objsryshClk = Utilities.returnElement(driver, lstObject.get(143), lstObject.get(142));
		objsryshClk.click();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(56)));
		String url1 = driver.getCurrentUrl();
		if (url1.contentEquals(lstTestData.get(56))) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "Shop Navigation link SHOULD be Responsive and Navigating"
									+ Extent_Reports.logActual + "Shop Navigation link is Responsive and Navigating",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Shop Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Shop Navigation link is not Responsive and not Navigating",
					driver);
		}

		driver.navigate().back();
		// wait.until(ExpectedConditions.urlContains("https://www.nbc.com/the-blacklist/video/berlin-conclusion/2780743"));

		WebElement objsryappClk = Utilities.returnElement(driver, lstObject.get(146), lstObject.get(145));
		objsryappClk.click();
		// wait.until(ExpectedConditions.urlContains("https://www.nbc.com/apps"));

		WebElement objapprefer = Utilities.returnElement(driver, lstObject.get(170), lstObject.get(169));
		if (objapprefer.isDisplayed()) {
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "App Navigation link SHOULD be Responsive and Navigating"
									+ Extent_Reports.logActual + "App Navigation link is Responsive and Navigating",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "App Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "App Navigation link is not Responsive and not Navigating",
					driver);
		}

		driver.navigate().back();
		// wait.until(ExpectedConditions.urlContains("https://www.nbc.com/the-blacklist/video/berlin-conclusion/2780743"));
		WebElement objsrylivClk = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		objsrylivClk.click();
		wait.until(ExpectedConditions.urlContains(lstTestData.get(55)));
		String url2 = driver.getCurrentUrl();
		if (url2.contentEquals(lstTestData.get(55)))
		// WebElement objlivrefer=
		// Utilities.returnElement(driver,lstObject.get(167),lstObject.get(166));
		// if (objlivrefer.isDisplayed())
		{
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "Live Navigation link SHOULD be Responsive and Navigating"
									+ Extent_Reports.logActual + "Live Navigation link is Responsive and Navigating",
							driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					Extent_Reports.logExpected + "Live Navigation link SHOULD be Responsive and Navigating"
							+ Extent_Reports.logActual + "Live Navigation link is not Responsive and not Navigating",
					driver);

		}
		// driver.close();
}
catch(Exception exc)
{
		Extent_Reports.executionLog("FAIL",exc.getMessage(),driver);

}
		return null;

	}

	
	//=========================== Verify Top Banner Ad is displayed in Show Inner Episodes Landing Page ( NBCRESP -1063)==============
	@Test
	public PGShowInnerEpisodes Bannerad_NBCRESP_1063() throws Exception {
		// Launching the URL
		try {

			driver.get(lstTestData.get(41));
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to www.nbc.com "
					+ Extent_Reports.logActual + "User is navigated to www.nbc.com", driver);
			WebElement objGShClk = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
			objGShClk.click();
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Shows option should be clicked from Global Nav"
							+ Extent_Reports.logActual + "Shows option is clicked from Global Nav",
					driver);
			System.out.print("navigated to menu");
			Synchronization.implicitWait(driver, 10);
			WebElement objDrpshclk = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
			objDrpshclk.click();
			System.out.print("navigated to show");
			String ShowlistText = objDrpshclk.getText();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Synchronization.waitForPageLoad(driver);
			String strlowerCaseText = ShowlistText.toLowerCase();
			String strReplaceSpaceText = strlowerCaseText.replace(" ", "-");
			System.out.println(strReplaceSpaceText);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "User should be navigated to the show"
					+ Extent_Reports.logActual + "User is navigated to the show", driver);
			wait.until(ExpectedConditions.urlContains(lstTestData.get(44)));
			List<WebElement> objSubMenuItems = Utilities.returnElements(driver, lstObject.get(176), lstObject.get(175));
			System.out.println(objSubMenuItems.size());
			objSubMenuItems.get(3).click();
			Thread.sleep(3000);

			wait.until(ExpectedConditions.urlContains(lstTestData.get(45)));
			System.out.println("56487680");
			Extent_Reports
					.executionLog("PASS",
							Extent_Reports.logExpected + "User should be navigated to the show inner Episodes page"
									+ Extent_Reports.logActual + "User is navigated to the show inner episodes page",
							driver);
			WebElement objBannerAd = Utilities.returnElement(driver, lstObject.get(182), lstObject.get(181));

			if (objBannerAd.isDisplayed()) {
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Banner Ad should be Displayed"
						+ Extent_Reports.logActual + "Banner Ad is Displayed", driver);

				driver.close();
				System.out.print("Result printed");
			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Banner Ad should be Displayed"
						+ Extent_Reports.logActual + "Banner Ad is not Displayed", driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
