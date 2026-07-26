package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.ExtentReporter;
import utility.Utility;

public class MyListeners implements ITestListener{

	public ExtentReports extentReport;
	public ExtentTest extentTest ;
	public WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project loaded and execution started!!");
		
		extentReport = ExtentReporter.generateExtentReport();	
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName = result.getName();
		extentTest = extentReport.createTest(testCaseName);
		extentTest.log(Status.INFO, testCaseName+" started executing!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getName();
		extentTest.log(Status.PASS, testCaseName+" got executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getName();
		System.out.println(testCaseName+" got Failed");
			
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		String screenshotPath = Utility.takeScreenshot(driver,testCaseName);
		
		//attach screenshot
		extentTest.addScreenCaptureFromPath(screenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testCaseName+" got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName = result.getName();
		extentTest.log(Status.SKIP, testCaseName+" got Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All the test cases executed successfully!");
		extentTest.log(Status.INFO, "All the test cases executed successfully!");
		extentReport.flush();
	}	
}