package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class TestNGBase {
	Properties prop;
	FileInputStream fs;
	
		//web driver declaration
		public WebDriver driver;//webdriver its a predefined interface.
		@BeforeMethod(alwaysRun = true)//alwaysRun = true shows : it says the testcases belongs into "Smoke" or "Regression"
		@Parameters("browser")//Instead of writing "chrome" directly in your Java code, you can pass the browser name dynamically from your TestNG XML file.
		public void browserLaunch(String browser) throws Exception
		{
			prop = new Properties();
			fs = new FileInputStream(Constants.CONFIGFILE);
			prop.load(fs);
			if (browser.equalsIgnoreCase("Chrome"))//equalsIgnoreCase will handle case sensitivity
			{
			driver = new ChromeDriver();//here ChromeDriver is class and driver is a interface object.So interface objects are created through the help of classes
			//if i need to launch the application in firefox we can use firefox driver
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else {
				throw new Exception("Invalid browser");
			}
				
			//To launch url we use the method get inside the wedriver interface
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();//to maximize the window
			//apply implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		
		@AfterMethod(alwaysRun = true)
		//To close the browser we use the new method
		public void driverQuit(ITestResult iTestResult) throws IOException { 
			  
	 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
	  
	 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
	 			screenShot.getScreenshot(driver, iTestResult.getName()); 
	 		} 
	 		//driver.quit(); 
	  
	 	}
}
