package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {
	
	public static void ClickAction(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		WaitHandler.waitTillElementClickable(element, driver);
		actions.moveToElement(element).click();
		actions.click().build().perform();	
	}
	public static void SendKeyAction(WebElement element, WebDriver driver, String str) {
		Actions actions = new Actions(driver);
		WaitHandler.waitTillElementVisible(element, driver);
		actions.moveToElement(element).click();
		actions.sendKeys(str).build().perform();
		
	}

}
