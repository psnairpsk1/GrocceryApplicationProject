package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	HomePage home;

	@Test(priority = 1, description = "Validating the login with valid username and password", groups = { "smoke" })
	public void verifyUserLoginwithValidCredentials() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);
		home = login.clickSubmitButton();
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constants.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "Validating the login with valid username and invalid password")
	public void verifyUserLoginwithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password).clickSubmitButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.HOMETITLECOMPARISONERROR);

	}

	@Test(priority = 3, description = "Validating the login with invalid username and valid password")
	public void verifyUserLoginwithInValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password).clickSubmitButton();
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertFalse(dashboardDisplay, Constants.DASHBOARDDISPLAYEDERROR);

	}

	@Test(priority = 4, description = "Validating the login with invalid username and invalid password", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyUserLoginwithInValidCredentials(String username, String password) throws IOException {
		// String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		// String password = ExcelUtility.readStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password).clickSubmitButton();
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
