package package1;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest {
	
ExtentHtmlReporter htmlReporter;
ExtentReports extent;
ExtentTest test;
	
	@Parameters({ "OS", "browser" })
	@BeforeTest
	public void startReport(String OS, String browser) {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"//ExtentReport//testReport.html");
		
		String userName = System.getProperty("user.name");
		String OSName = System.getProperty("os.name");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", OS);
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("UserName", userName);
		
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Automation Selenium Demo");
		htmlReporter.config().setReportName("Selenium Test Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			
	}
	
	@Test
	public void testCase1() {
		test = extent.createTest("Test Case 1","My first test case is Passed");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testCase2() {
		test = extent.createTest("Test Case 2","My Second test case is Passed");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testCase3() {
		test = extent.createTest("Test Case 3","My Third test case is Failed");
		Assert.assertTrue(false);
	}
	@Test
	public void testCase4() {
		test = extent.createTest("Test Case 4","My Fourth test case is Skiped");
		throw new SkipException("Skippping with Exception");	
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
			test.fail(result.getThrowable()); 
			}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.BLUE));
			test.skip(result.getThrowable());
		}
	}
	@AfterTest
	public void teardown() {
		extent.flush();
	}

}
