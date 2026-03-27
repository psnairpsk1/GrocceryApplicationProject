package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase {
	HomePage home;
	ManageNewsPage news;
	FakerUtility faker = new FakerUtility();
	public String randomNews = faker.createRandomNews();

	@Test(description = "Validating the user is able to adda a new news")
	public void verifyWhetherUserIsAbleToAddANews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);
		home = login.clickSubmitButton();


		news = home.clickManageNews();

		//ManageNewsPage news = new ManageNewsPage(driver);
		news.clickAddNews();
		news.enterMessageInNewsTextArea(randomNews);
		news.saveNews();

		// to view or navigate the list
		//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-news");
		driver.get("https://groceryapp.uniqassosiates.com/admin/list-news");
		boolean flagPageTitleStatus = news.isPageTitleDisplayed();
		Assert.assertTrue(flagPageTitleStatus,Constants.PAGETITLESTATUSERROR);

	}

	@Test(description = "Validating the user can able to search a news")
	public void verifySearchANews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);
		home =login.clickSubmitButton();

		//HomePage home = new HomePage(driver);
		news = home.clickManageNews();

		//ManageNewsPage news = new ManageNewsPage(driver);
		news.clickSearchNews();
		String newsToSearch = ExcelUtility.readStringData(0, 0, "News");
		news.enterNewsTitle(newsToSearch);
		news.clickForFilteringNews();
		boolean flagPageTitleSearchManageNewsStatus = news.isPageTitleSearchManageNewsDisplayed();
		Assert.assertTrue(flagPageTitleSearchManageNewsStatus,Constants.PAGETITLESEARCHMANAGENEWSSTATUSERROR);

	}

	@Test(description = "Validating whether the user can able to reset the news list")
	public void verifyUserIsAbleToResetSearchNewsList() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);
		home = login.clickSubmitButton();

		//HomePage home = new HomePage(driver);
		news = home.clickManageNews();

		//ManageNewsPage news = new ManageNewsPage(driver);
		news.clickSearchNews();
		String newsToSearch = ExcelUtility.readStringData(0, 0, "News");
		news.enterNewsTitle(newsToSearch).clickForFilteringNews().clickResetNewsTitleList();

	}

}
