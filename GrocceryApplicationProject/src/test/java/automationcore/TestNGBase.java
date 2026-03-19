package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class TestNGBase {
		//web driver declaration
		public WebDriver driver;//webdriver its a predefined interface.
		@BeforeMethod
		public void browserLaunch()
		{
			driver = new ChromeDriver();//here ChromeDriver is class and driver is a interface object.So interface objects are created through the help of classes
			//if i need to launch the application in firefox we can use firefox driver
			
			//To launch url we use the method get inside the wedriver interface
			driver.get("https://groceryapp.uniqassosiates.com/admin");
			driver.manage().window().maximize();//to maximize the window
			//apply implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		
		@AfterMethod
		//To close the browser we use the new method
		public void driverQuit(ITestResult iTestResult) throws IOException { 
			  
	 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
	  
	 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
	 			screenShot.getScreenshot(driver, iTestResult.getName()); 
	 		} 
	 		//driver.quit(); 
	  
	 	}
}
