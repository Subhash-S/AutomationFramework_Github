package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class AccountsPage {
	WebDriver driver;
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyLoginIsSuccessfullInAccountPage() {
		String expectedPageTitle = "My Account";
		// explicit wait until the page title matches the expected title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleIs(expectedPageTitle));
		String actualPageTitle = driver.getTitle();
		System.out.println("Actual page title is: " + actualPageTitle);
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		System.out.println("PASS");
	}
	
	public void ex() {
		System.out.println("Account page commit and push chnages demo");
	}
}