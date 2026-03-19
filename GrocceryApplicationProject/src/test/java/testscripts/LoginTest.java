package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test(priority = 1 , description = "Validating the login with valid username and password")
	public void verifyUserLoginwithValidCredentials() throws IOException
	{

	
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();
		
	}
	@Test(priority = 2, description = "Validating the login with valid username and invalid password")
	public void verifyUserLoginwithValidUsernameAndInvalidPassword() throws IOException
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();
		
	}
	@Test (priority = 3 , description = "Validating the login with invalid username and valid password")
	public void verifyUserLoginwithInValidUsernameAndValidPassword() throws IOException
	{
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();
	}
	@Test (priority = 4 , description = "Validating the login with invalid username and invalid password")
	public void verifyUserLoginwithInValidCredentials() throws IOException
	{
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();
	}
	
}
