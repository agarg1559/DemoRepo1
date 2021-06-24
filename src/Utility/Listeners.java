package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners implements ITestListener {
	
    ExtentReports extent = ExtentReportUtility.startReport("Chrome");
    ExtentTest test;
                @Override
                public void onTestStart(ITestResult result) {
                                
                 test = extent.createTest(result.getMethod().getMethodName());
                                
                }
                @Override
                public void onFinish(ITestContext result) {
                
                	extent.flush();
                }

                @Override
                public void onTestSuccess(ITestResult result) {
                                                  
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
                                
                }

                @Override
                public void onTestFailure(ITestResult result) {
                	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
        			test.fail(result.getThrowable());
        			//Screenshot.failedScreenshot(result.getMethod().getMethodName());
                                
                }

                @Override
                public void onTestSkipped(ITestResult result) {
                	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.BLUE));
        			test.skip(result.getThrowable());
        		}
                
               
                                      
                }



