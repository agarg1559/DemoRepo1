package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Setup {
	
	private static WebDriver driver;
	public static WebDriver openbrowser(String Str)
	{  
		 System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\Driver\\chromedriver.exe");
         driver = new ChromeDriver();
         
         driver.get(Str);
         
         driver.manage().window().maximize();
         
         return driver;
           
	    }
	public static void closebrowser()
	{  
		 driver.quit();

	    }	

}
