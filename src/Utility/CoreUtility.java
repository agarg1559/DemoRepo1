package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreUtility {
	
	public static void EnterKeys(WebElement element, WebDriver driver, String Str) {
		WaitHandler.waitTillElementVisible(element, driver);
		element.sendKeys(Str);		
	}
	
	public static void ClickElement(WebElement element, WebDriver driver) {
		WaitHandler.waitTillElementClickable(element, driver);
		element.click();		
	}
	
	public static void EnterKeys(By locator, WebDriver driver, String Str) {
		WaitHandler.waitTillElementVisible(locator, driver);
		driver.findElement(locator).sendKeys(Str);		
	}
	
	public static void ClickElement(By locator, WebDriver driver) {
		WaitHandler.waitTillElementClickable(locator, driver);
		driver.findElement(locator).click();		
	}

}


