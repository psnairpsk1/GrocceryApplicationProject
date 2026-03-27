package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		// This catches the browser window opened by your test and brings it into this
		// class.
		this.driver = driver;
		// This is the "magic" line. It tells Selenium to go find all the elements
		// marked with @FindBy (listed below) on the actual webpage.
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class= 'btn btn-rounded btn-danger']")
	WebElement btnNew;
	@FindBy(id = "username")
	WebElement txtAdminUserName;
	@FindBy(id = "password")
	WebElement txtAdminPassword;
	@FindBy(id = "user_type")
	WebElement ddUserType;
	@FindBy(name = "Create")
	WebElement btnSave;
	@FindBy(xpath = "//a[@class = 'btn btn-rounded btn-primary']")
	WebElement btnSearch;
	@FindBy(id = "un")
	WebElement txtSearchAdminUserName;
	@FindBy(id = "ut")
	WebElement ddSearchUserType;
	@FindBy(name = "Search")
	WebElement btnSearchUser;
	@FindBy(xpath = "//a[@class = 'btn btn-rounded btn-warning']")
	WebElement btnResetSearch;
	@FindBy(xpath = "//button[@class = 'btn btn-block-sm btn-danger' and @ name='Search']")
	WebElement btnResetSearchList;
	@FindBy(xpath = "//h4[text()='Search Admin Users']") WebElement titleSearchAdminUsers;

	public AdminUsersPage verifyUserisAbleToClickNewButton() {

		btnNew.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage enterUserNameOnAdminUserNameField(String adminUserName) {

		txtAdminUserName.sendKeys(adminUserName);
		return this;
	}

	public AdminUsersPage enterPasswordOnAdminPasswordField(String adminPassword) {

		txtAdminPassword.sendKeys(adminPassword);
		return this;
	}

	public AdminUsersPage selectUserRoleFromuserType(String userType) {

		//Select select = new Select(ddUserType);
		//select.selectByValue(userType);
		page.selectDropdownWithValue(ddUserType, userType);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage clickSaveButton() {

		wait.waitUntilElementToBeClickable(driver, btnSave);
		btnSave.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage clickSearchButton() {
		wait.waitUntilElementToBeClickable(driver, btnSearch);
		btnSearch.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage enterUserNameOnAdminSearchUserNameField(String adminSearchUserName) {

		txtSearchAdminUserName.sendKeys(adminSearchUserName);
		return this;
	}

	public AdminUsersPage selectUserRoleFromSearchUserType(String searchUserType) {

		Select select = new Select(ddSearchUserType);
		select.selectByValue(searchUserType);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage clickSearchButtonAfterInputTheValues() {

		btnSearchUser.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage clickResetButton() {
		wait.waitUntilElementToBeClickable(driver, btnResetSearch);
		btnResetSearch.click();
		return new AdminUsersPage(driver);

	}
	
	public AdminUsersPage clickResetSearchListButton() {
		wait.waitUntilElementToBeClickable(driver, btnResetSearchList);
		btnResetSearchList.click();
		return new AdminUsersPage(driver);

	}
	public boolean isUserNameDisplayed() {
		return txtAdminUserName.isDisplayed();
	}

	public boolean istitleAdminUsersDisplayed()
	{
		return titleSearchAdminUsers.isDisplayed();
	}
	
	public String getTitleAdminUsersDisplayed()
	{
		return titleSearchAdminUsers.getText();
	}
}
