package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Utility.ActionUtility;
import Utility.CoreUtility;
import Utility.Setup;
import package1.Verification;

public class LoginWithCoreUtility {
	 WebDriver driver;
	
	@BeforeTest
	public void IntialSteUp() {
	driver = Setup.openbrowser("https://www.testandquiz.com/");
	}
	
	@Test(priority = 0)
	 public void Homepage() {
		CoreUtility.ClickElement(By.cssSelector("a[href='/user-login']"), driver);
	    Reporter.log("Login Link is clicked");    
				}
	
	@Test(priority = 1)
	 public void LoginPage() {
	    CoreUtility.EnterKeys(By.cssSelector("#email"), driver, "ankit.garg@intsof.com");
	    CoreUtility.EnterKeys(By.cssSelector("#password"), driver, "Virat@123");
	    CoreUtility.ClickElement(By.cssSelector("button[type = 'submit']"), driver);
				}
	
	@Test(priority = 2)
	 public void VerificationPoint() {
		Verification.LoggedInPage(driver);
	}
 
	 @AfterTest
	 public void teardown() {
		 Setup.closebrowser();
	 }

}
