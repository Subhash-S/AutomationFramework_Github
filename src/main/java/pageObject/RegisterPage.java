package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
	}
	
	public void selectPrivacyPolicy() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	
	public void clickOnContinueButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void selectNewsLetterSubscription_Yes() {
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	}
	
	public void verifyRegistrationSuccessfulTextMessage() {
		String actualRegSuccessText = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		String expectedRegSuccessText = "Account Has Been Created!";
		if(actualRegSuccessText.contains(expectedRegSuccessText)) {
			System.out.println("PASS - Registration is Successfull");
		}
		else {
			System.out.println("FAIL - Registration has been Failed");
		}
		
		//Hard Assert
		/*Assert.assertEquals(actualRegSuccessText, expectedRegSuccessText, "FAIL - Registration has been Failed - success message not displayed");*/
		System.out.println("PASS - Registration is Successfull");
		Assert.assertTrue(actualRegSuccessText.contains(expectedRegSuccessText),"FAIL - Registration has been Failed - success message not displayed");
	}
	
	
	public void verifyRegisterWarningMessage() {
		String actualRegWarningText = driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		String expectedRegWarningText = "You must agree to the Privacy Policy";
		if(actualRegWarningText.contains(expectedRegWarningText)) {
			System.out.println("PASS - Warning message has been verified");
		}
		else {
			System.out.println("FAIL - Warning message not displayed!");
		}
	}
	
	public void verifyTextFieldErrorValidation() {
		String actualTextFieldErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'must be between 1 and 32 characters')]")).getText();
		
		if(actualTextFieldErrorMessage.contains("must be")) {
			System.out.println("PASS - TextField error validation is successful");
		}
		else {
			System.out.println("FAIL - Error message is not displayed");
		}
	}
}







