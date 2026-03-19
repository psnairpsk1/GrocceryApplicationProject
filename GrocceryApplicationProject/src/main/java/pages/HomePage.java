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

public class HomePage {
	public WebDriver driver;
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
	
	public void clickProfileIcon(){
		imgProfile.click();
	}
	public void clickLogout() throws AWTException {
		
		Robot rbt = new Robot();
		//added slight delay to see the logout option
		rbt.delay(500);
		logoutOption.click();
		
	}
	
	public void clickAdminMoreInfo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(adminUsersMoreInfo));
		adminUsersMoreInfo.click();
		
	}
	
	public void clickManageNews() {
		manageNews.click();
	}
}
