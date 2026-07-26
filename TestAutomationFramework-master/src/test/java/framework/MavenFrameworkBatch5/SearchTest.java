package framework.MavenFrameworkBatch5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.HomePage;
import pageObject.SearchPage;

public class SearchTest extends Base{

	public WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndLaunchApplication();
		
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homeP = new HomePage(driver);
		homeP.QuitBrowser();
	}
	
	@Test
	public void searchWithValidProduct() {
		SearchPage searchP = new SearchPage(driver);
		searchP.enterProduct("HP");
		searchP.clickOnSearchButton();
		
		searchP.verifyProductFound();	
	}
	
	@Test
	public void searchInvalidProduct() {
		SearchPage searchP = new SearchPage(driver);
		searchP.enterProduct("Apache Bike");
		searchP.clickOnSearchButton();
		
		searchP.verifyNoProductFoundText();
	}
	
	@Test
	public void searchWithoutProvidingAnyProduct() {
		SearchPage searchP = new SearchPage(driver);
		searchP.clickOnSearchButton();
		searchP.verifyNoProductFoundText();
	}
	
}







//we need code - taking screenshot code
//extent report
//attach the screenshot to extent report log











