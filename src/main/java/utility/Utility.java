package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static void readData() {
		//code to read data from properties file and also excel file
	}
	
	public static String timestamp() {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		return timestamp;
	}
	
	public static String takeScreenshot(WebDriver driver, String testCaseName) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		//File dest2 = new File("G:\\Subhash_Automation _Folder\\Automation\\MavenFrameworkBatch5\\test-output\\Screenshots\\ApplicationImage"+timestamp+".png");
		String path = System.getProperty("user.dir")+"\\test-output\\Screenshots\\Screenshot_"+testCaseName+"_"+timestamp()+".png";
		File dest = new File(path);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;	
	}
	
	public static String randomNum() {
		Random ran = new Random();
		int num = ran.nextInt(1000); //between 100 and 999 
		return String.valueOf(num);
	}

	
	
}
