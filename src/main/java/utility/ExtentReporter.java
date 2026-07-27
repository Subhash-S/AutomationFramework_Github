package utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		//it should generate report and share it with all the test cases/classes
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportPath = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\Report_"+Utility.timestamp()+".html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		return extentReport;
	}
}
