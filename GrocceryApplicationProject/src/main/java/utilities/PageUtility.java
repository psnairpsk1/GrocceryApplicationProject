package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {

		Select object = new Select(element);
		object.selectByContainsVisibleText(text);

	}

	public void selectDropdownWithIndexValue(WebElement element, int indexValue) {

		Select object = new Select(element);
		object.selectByIndex(indexValue);

	}

	public void mouseHoverToAnElement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void rightClickToAnElement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}
}
