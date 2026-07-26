package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterProduct(String product) {
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(product);
	}
	
	public void clickOnSearchButton() {
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}
	
	public void verifyProductFound() {
		String actualProductText = driver.findElement(By.linkText("HP LP3065")).getText();
		if(actualProductText.contains("HP")) {
			System.out.println("PASS - Product has been verified successfully!");
		}
		else {
			System.out.println("FAIL - Product not displayed");
		}
	}
	
	public void verifyNoProductFoundText() {
		String productNotFoundText = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		if(productNotFoundText.contains("There is no product")) {
			System.out.println("PASS - No Product found!!");
		}
		else {
			System.out.println("FAIL - No Product found message not displayed");
		}
	}
}
