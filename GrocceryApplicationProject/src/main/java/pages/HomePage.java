package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public HomePage(WebDriver driver)
	{
		//This catches the browser window opened by your test and brings it into this class.
		this.driver = driver;
		//This is the "magic" line. It tells Selenium to go find all the elements marked with @FindBy (listed below) on the actual webpage. 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@class='img-circle']")WebElement imgProfile ;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logoutOption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class = 'small-box-footer']") WebElement manageNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement btnNew;
	@FindBy(xpath ="//b[text()='7rmart supermarket']") WebElement applicationTitle;
	
	public HomePage clickProfileIcon(){
		imgProfile.click();
		return this;
	}
	public LoginPage clickLogout() throws AWTException {
		
	
		logoutOption.click();
		return new LoginPage(driver);
		
	}
	
	public AdminUsersPage clickAdminMoreInfo() {
		wait.waitUntilElementToBeClickable(driver, adminUsersMoreInfo);
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
		
	}
	
	public ManageNewsPage clickManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	
	public boolean isNewButtonDisplayed() {
		return btnNew.isDisplayed();
		
	}
	
	public String getApplicationTitle() {
		return applicationTitle.getText();
	}
}
