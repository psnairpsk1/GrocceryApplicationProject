package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		// This catches the browser window opened by your test and brings it into this
		// class.
		this.driver = driver;
		// This is the "magic" line. It tells Selenium to go find all the elements
		// marked with @FindBy (listed below) on the actual webpage.
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class = 'btn btn-rounded btn-danger']")
	WebElement btnAddNews;
	@FindBy(id = "news")
	WebElement txtAreaNews;
	@FindBy(xpath = "//button[@name = 'create']")
	WebElement btnSave;
	@FindBy(xpath = "//a[@class = 'btn btn-rounded btn-primary']")
	WebElement btnSearchNews;
	@FindBy(xpath = "//input[@name = 'un']")
	WebElement txtNewsTitle;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement btnGetNews;
	@FindBy(xpath = "//a[@class = 'btn btn-default btn-fix']")
	WebElement btnResetNews;
	@FindBy(xpath = "//h1[text()='Manage News']")
	WebElement pageTitle;
	@FindBy(xpath = "//h4[text()='Search Manage News']")
	WebElement pageTitleSearchManageNews;

	public ManageNewsPage clickAddNews() {
		btnAddNews.click();
		return this;

	}

	public ManageNewsPage enterMessageInNewsTextArea(String randomNews) {
		txtAreaNews.sendKeys(randomNews);
		return this;
	}

	public ManageNewsPage saveNews() {
		btnSave.click();
		return this;
	}

	public ManageNewsPage clickSearchNews() {
		btnSearchNews.click();
		return this;
	}

	public ManageNewsPage enterNewsTitle(String newsTitle) {
		txtNewsTitle.sendKeys(newsTitle);
		return this;
	}

	public ManageNewsPage clickForFilteringNews() {
		btnGetNews.click();
		return this;
	}

	public ManageNewsPage clickResetNewsTitleList() {
		btnResetNews.click();
		return this;
	}

	public boolean isPageTitleDisplayed() {
		return pageTitle.isDisplayed();
	}

	public boolean isPageTitleSearchManageNewsDisplayed() {
		return pageTitleSearchManageNews.isDisplayed();
	}
}
