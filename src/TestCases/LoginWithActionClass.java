package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.ActionUtility;
//import Utility.CoreUtility;
import Utility.Setup;
import package1.Verification;

public class LoginWithActionClass {
		 WebDriver driver;
		
		@BeforeTest
		public void IntialSteUp() {
		driver = Setup.openbrowser("https://www.testandquiz.com/");
		}
		
		@Test(priority = 0)
		 public void Homepage() {
			ActionUtility.ClickAction(driver.findElement(By.cssSelector("a[href='/user-login']")), driver);
			Reporter.log("Login Link is clicked");   
					}
		
		@Test(priority = 1)
		 public void LoginPage() {
			ActionUtility.SendKeyAction(driver.findElement(By.cssSelector("#email")), driver, "ankit.garg@intsof.com");
			ActionUtility.SendKeyAction(driver.findElement(By.cssSelector("#password")), driver, "Virat@123");
			ActionUtility.ClickAction(driver.findElement(By.cssSelector("button[type = 'submit']")), driver);
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
