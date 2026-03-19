package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage {
	public WebDriver driver;

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

	public void verifyUserisAbleToClickNewButton() {

		btnNew.click();
	}

	public void enterUserNameOnAdminUserNameField(String adminUserName) {

		txtAdminUserName.sendKeys(adminUserName);
	}

	public void enterPasswordOnAdminPasswordField(String adminPassword) {

		txtAdminPassword.sendKeys(adminPassword);
	}

	public void selectUserRoleFromuserType(String userType) {

		Select select = new Select(ddUserType);
		select.selectByValue(userType);
	}

	public void clickSaveButton() {

		btnSave.click();
	}

	public void clickSearchButton() {

		btnSearch.click();
	}

	public void enterUserNameOnAdminSearchUserNameField(String adminSearchUserName) {

		txtSearchAdminUserName.sendKeys(adminSearchUserName);
	}

	public void selectUserRoleFromSearchUserType(String searchUserType) {

		Select select = new Select(ddSearchUserType);
		select.selectByValue(searchUserType);
	}

	public void clickSearchButtonAfterInputTheValues() {

		btnSearchUser.click();
	}

	public void clickResetButton() {

		btnResetSearch.click();

	}

}
