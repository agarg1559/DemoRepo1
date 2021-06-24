package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verification {
	
	 public static void LoggedInPage(WebDriver driver) {
	
	WebElement LogoutLink = driver.findElement(By.cssSelector("a[href='/logout-user']"));
	boolean b1 = LogoutLink.isDisplayed();
    WebElement Logo = driver.findElement(By.className("img-responsive"));
     boolean b2 =  Logo.isDisplayed();
     
 
     
    if(b1 && b2 ) {
   	 
   	 System.out.println("User is successfully Login");
    }
    else {
   	 System.out.println("User is unable to Login");
    }
	 }

}
