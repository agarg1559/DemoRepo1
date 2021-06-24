package Utility;

import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility {
	
		
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		@Parameters({ "OS", "browser" })
		public static ExtentReports startReport(String browser) {
			
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReport/testReport.html");
			
			String userName = System.getProperty("user.name");
			String OSName = System.getProperty("os.name");
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("OS", OSName);
			extent.setSystemInfo("Browser", browser);
			extent.setSystemInfo("UserName", userName);
			
			//htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Automation Selenium Demo");
			htmlReporter.config().setReportName("Selenium Test Report");
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			
			return extent;
				
		}
		
	}
