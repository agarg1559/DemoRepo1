package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {
	
	public static void  waitTillElementVisible(WebElement element, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
public static void  waitTillElementClickable(WebElement element, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

public static void waitTillElementVisible(By locator, WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
}

public static void  waitTillElementClickable(By locator, WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}

}
