package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void enterEmail(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void verifyLoginErrorMessage() {
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		String actualError = driver.findElement(By.xpath("//div[contains(text(),'Warning: No match')]")).getText();
		
		//Hard Assert
		Assert.assertEquals(actualError, expectedError, "Warning message not displayed");
		
		/* alternate verification
		if(expectedError.equals(actualError)) {
			System.out.println("Validation PASS - for Login failed scenario!");
		}
		else {
			System.out.println("Validation FAIL - login successful");
		}
		*/
	}
}
