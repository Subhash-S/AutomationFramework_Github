package framework.MavenFrameworkBatch5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.AccountsPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTest extends Base { //child

	public WebDriver driver; //global variable declaration
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndLaunchApplication();
		
		HomePage homeP = new HomePage(driver);
		homeP.clickOnMyAccount();
		homeP.selectLoginOption();	
	}
	
	@Test(priority = 1)
	public void loginWithValidEmailAndValidPassword() {
		LoginPage loginP = new LoginPage(driver);
		
		loginP.enterEmail(prop.getProperty("validEmail"));	
		loginP.enterPassword(prop.getProperty("validPassword"));
		loginP.clickOnLoginButton();
		
		//Assert.fail();
		AccountsPage accP = new AccountsPage(driver);
		accP.verifyLoginIsSuccessfullInAccountPage();		
	}
	
	@Test(priority = 2)
	public void loginWithValidEmailAndInvalidPassword() {
		LoginPage loginP = new LoginPage(driver);
		
		loginP.enterEmail(prop.getProperty("validEmail"));
		loginP.enterPassword(prop.getProperty("invalidPassword"));
		loginP.clickOnLoginButton();
		loginP.verifyLoginErrorMessage();
		
	}
	
	@Test(priority = 3)
	public void loginWithInvalidEmailAndValidPassword() {
		LoginPage loginP = new LoginPage(driver);
		
		loginP.enterEmail(prop.getProperty("invlaidEmail"));
		loginP.enterPassword(prop.getProperty("validPassword"));
		loginP.clickOnLoginButton();
		loginP.verifyLoginErrorMessage();
	}

	@Test(priority = 4)
	public void loginWithInvalidEmailAndInvalidPassword() {
		LoginPage loginP = new LoginPage(driver);
		
		loginP.enterEmail(prop.getProperty("invlaidEmail"));
		loginP.enterPassword(prop.getProperty("invalidPassword"));
		loginP.clickOnLoginButton();
		loginP.verifyLoginErrorMessage();
	}
	
	@Test(priority = 5)
	public void loginWithoutEmailAndPassword() {
		LoginPage loginP = new LoginPage(driver);
		
		loginP.clickOnLoginButton();
		loginP.verifyLoginErrorMessage();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homeP = new HomePage(driver);
		homeP.QuitBrowser();
	}
}