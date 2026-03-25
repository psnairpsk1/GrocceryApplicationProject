package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase {
	@Test(priority = 1 , description = "Validating the user is able to adda a new user")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();

		HomePage home = new HomePage(driver);
		home.clickAdminMoreInfo();

		// Fill the details for admin username and admin password
		FakerUtility faker = new FakerUtility();
		String adminUserName = faker.createRandomUserName();
		String adminPassword = faker.createRandomPassword();
		String userType = ExcelUtility.readStringData(0, 2, "AdminUsers");
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.verifyUserisAbleToClickNewButton();
		admin.enterUserNameOnAdminUserNameField(adminUserName);
		admin.enterPasswordOnAdminPasswordField(adminPassword);
		admin.selectUserRoleFromuserType(userType);
		admin.clickSaveButton();
		boolean txtAdminUserNameDisplay = admin.isUserNameDisplayed();
		Assert.assertFalse(txtAdminUserNameDisplay,"Error : The user is in Admin Users Creation Page");

	}

	@Test(priority = 2 , description = "Validating the user is able to search a user")
	public void verifyUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();

		HomePage home = new HomePage(driver);
		home.clickAdminMoreInfo();

		// Fill the details for admin username and admin password
		String adminUserName = ExcelUtility.readStringData(0, 0, "AdminUsers");
		String userType = ExcelUtility.readStringData(0, 2, "AdminUsers");
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickSearchButton();
		admin.enterUserNameOnAdminSearchUserNameField(adminUserName);
		admin.selectUserRoleFromSearchUserType(userType);
		admin.clickSearchButtonAfterInputTheValues();
		boolean titleSearchAdminUsers = admin.istitleAdminUsersDisplayed();
		Assert.assertTrue(titleSearchAdminUsers, "Error : The user is in Admin Users List Page");
	}

	@Test(priority = 3 , description = "Validating the reset action on users list")
	public void verifyUserIsAbleToResetSearchUserList() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordeOnPasswordField(password);
		login.clickSubmitButton();

		HomePage home = new HomePage(driver);
		home.clickAdminMoreInfo();

		// Fill the details for admin username and admin password
		String adminUserName = ExcelUtility.readStringData(0, 0, "AdminUsers");
		String userType = ExcelUtility.readStringData(0, 2, "AdminUsers");
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickSearchButton();
		String actual = admin.getTitleAdminUsersDisplayed();
		admin.enterUserNameOnAdminSearchUserNameField(adminUserName);
		admin.selectUserRoleFromSearchUserType(userType);
		admin.clickSearchButtonAfterInputTheValues();
		admin.clickResetButton();
		//Assertion Area
		String expected = "Search Admin Users";
		Assert.assertEquals(actual, expected,"Error : The user is in home page");
	}

}
