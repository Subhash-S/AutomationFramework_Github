package utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		//it should generate report and share it with all the test cases/classes
		
		ExtentReports extentReport = new ExtentReports();
		//File extentReportPath = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\Report_"+Utility.timestamp()+".html");
		String extentReportPath = System.getProperty("user.dir")+ "/test-output/ExtentReport/AutomationReport_" + Utility.timestamp() + ".html";
		
		//below code creates the folder if it doesn't exists (folder is created if missing)
		new File(extentReportPath).getParentFile().mkdirs();
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		return extentReport;
	}
}
