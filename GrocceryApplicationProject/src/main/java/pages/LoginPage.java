package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		//This catches the browser window opened by your test and brings it into this class.
		this.driver = driver;
		//This is the "magic" line. It tells Selenium to go find all the elements marked with @FindBy (listed below) on the actual webpage. 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")WebElement txtUserName ;
	@FindBy(name = "password") WebElement txtPassword;
	@FindBy(xpath = "//button[@type='submit']") WebElement btnSubmit;
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashboardTile;
	@FindBy(xpath ="//b[text()='7rmart supermarket']") WebElement applicationTitle;
	
	public LoginPage enterUserNameOnUserNameField(String username)
	{
		//txtUserName.click();
		txtUserName.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordeOnPasswordField(String password)
	{
		txtPassword.sendKeys(password);
		return this;
	}
	
	public HomePage clickSubmitButton()
	{
		btnSubmit.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return dashboardTile.isDisplayed();
	}
	
	public String getApplicationTitle() {
		return applicationTitle.getText();
	}
	
	public boolean isSubmitBttonDisplayed() {
		return btnSubmit.isDisplayed();
	}

}
