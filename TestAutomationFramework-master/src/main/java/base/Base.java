package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base { //parent

	public WebDriver driver;
	public Properties prop;
	
	public Base() {
		// Reading data from properties file
		try {
			FileInputStream fis = new FileInputStream("G:\\Subhash_Automation _Folder\\Automation\\MavenFrameworkBatch5\\TestData\\config.properties");
			prop = new Properties();
			prop.load(fis);
			System.out.println("browser name  = " + prop.getProperty("browserName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndLaunchApplication() {
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid broswerName");
		}
		
		driver.get(prop.getProperty("applURL"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}
}
