package framework.MavenFrameworkBatch5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.HomePage;
import pageObject.RegisterPage;
import utility.Utility;

public class RegisterTest extends Base{

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndLaunchApplication();
		
		HomePage homeP = new HomePage(driver);
		homeP.clickOnMyAccount();
		homeP.selectRegisterOption();
	}

	@AfterMethod
	public void tearDown() {
		HomePage homeP = new HomePage(driver);
		homeP.QuitBrowser();
	}
	

	
	@Test
	public void registerWithMandatoryDetail() throws InterruptedException {
		
		RegisterPage regP = new RegisterPage(driver);
		regP.enterFirstName("Sumit");
		regP.enterLastName("TV");
		regP.enterEmail("sumittv"+Utility.randomNum()+"@gmail.com");
		regP.enterTelephone("1234567890");
		regP.enterPassword("Password@123");
		regP.enterConfirmPassword("Password@123");
		regP.selectPrivacyPolicy();
		regP.clickOnContinueButton();
		
		regP.verifyRegistrationSuccessfulTextMessage();	
	}
	
	
	@Test
	public void registerWithAllTheDetailAlongWithSubscriptionYes() {
		
		RegisterPage regP = new RegisterPage(driver);
		regP.enterFirstName("Manoj");
		regP.enterLastName("GR");
		regP.enterEmail("manojgr"+Utility.randomNum()+"@gmail.com");
		regP.enterTelephone("1234567890");
		regP.enterPassword("Password@123");
		regP.enterConfirmPassword("Password@123");
		
		regP.selectNewsLetterSubscription_Yes();
		regP.selectPrivacyPolicy();
		regP.clickOnContinueButton();
		
		regP.verifyRegistrationSuccessfulTextMessage();		
	}
	
	@Test
	public void registerWithoutProvidingAnyData() {
		RegisterPage regP = new RegisterPage(driver);
		regP.clickOnContinueButton();
		regP.verifyRegisterWarningMessage();
	}
	
	@Test
	public void noFirstNameValidation() {
		RegisterPage regP = new RegisterPage(driver);
		regP.enterFirstName(""); //empty
		
		regP.enterLastName("GR");
		regP.enterEmail("manojgr"+Utility.randomNum()+"@gmail.com");
		regP.enterTelephone("1234567890");
		regP.enterPassword("Password@123");
		regP.enterConfirmPassword("Password@123");
		regP.selectNewsLetterSubscription_Yes();
		regP.selectPrivacyPolicy();
		regP.clickOnContinueButton();
		
		//verify FirstName field validation error message
		regP.verifyTextFieldErrorValidation();
	}
}











