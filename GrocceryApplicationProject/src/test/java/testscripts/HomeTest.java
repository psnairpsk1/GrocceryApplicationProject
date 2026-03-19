package testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	@Test
	public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException, AWTException{	
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();
	
		HomePage home = new HomePage(driver);
		home.clickAdminMoreInfo();
		home.clickManageNews();
		//home.clickProfileIcon();
		//home.clickLogout();
		
		
		
		
		
	}
	

}
