package pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountsPage {
	WebDriver driver;
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyLoginIsSuccessfullInAccountPage() {
		String expectedPageTitle = "My Account---";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		System.out.println("PASS");	
	}
	
	public void ex() {
		System.out.println("Account page commit and push chnages demo");
	}
}