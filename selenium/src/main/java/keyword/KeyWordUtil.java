package keyword;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import util.Commons;

/*
- for every keyword create a method.
- call the method based on the keyword configured in the excel.
*/
public class KeyWordUtil {
	WebDriver driver;

	public KeyWordUtil(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void perform(Action action) throws IOException, InterruptedException {
		String keyword = action.getKeyword();
		String objectName = action.getObjectName();
		String locatorType = action.getLocatorType();
		String data = action.getTestdata();
		String assertionType = action.getAssertionType();
		String expectedValue = action.getExpectedValue();

		switch (keyword) {
		case "URL":
//Perform click
			enter_URL(driver, data);
			break;

		case "TYPE":
			type(driver, objectName, locatorType, data);
			break;

		case "CLICK":
			click(driver, objectName, locatorType);
			break;
		case "WAIT":
			Thread.sleep(5000);
			break;
		case "GET_URL":
			get_currentURL(driver);
			break;
		default:
			break;
		}

		switch (assertionType) {
		case "loginTitle":
			Assert.assertEquals(driver.getTitle(), expectedValue);
			break;
		case "homeTitle":
			Assert.assertTrue(get_currentURL(driver).contains("login"));
			Assert.assertEquals(driver.getTitle(), expectedValue);
			break;
		case "invalidLogin":
			WebElement invalidlogin = driver.findElement(this.getObject(objectName, locatorType));
			Assert.assertEquals(invalidlogin.getText(), expectedValue);
			break;
		case "alert":
			Alert a = driver.switchTo().alert();
			Reporter.log(a.getText());
			Assert.assertEquals(a.getText(), expectedValue);
			a.accept();
			break;
		}
	}

	public String get_currentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * method for keyword "CLICK"
	 */
	public void click(WebDriver driver, String expression, String locatorType) throws IOException {
		driver.findElement(this.getObject(expression, locatorType)).click();
	}

	public void enter_URL(WebDriver driver, String data) throws IOException {
		driver.get(data);
	}

	/**
	 * method for keyword "TYPE"
	 */
	public void type(WebDriver driver, String expression, String locatorType, String testdata) throws IOException {
		WebElement field = driver.findElement(this.getObject(expression, locatorType));
		field.clear();
		field.sendKeys(testdata);
// driver.findElement(By.xpath("//")).sendKeys(testdata);
	}

	public By getObject(String expression, String locatorType) throws IOException {
// find by xpath
		if (locatorType.equalsIgnoreCase("XPATH")) {
			return By.xpath(expression);
		}
// find by class
		else if (locatorType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(expression);
		} else if (locatorType.equalsIgnoreCase("ID")) {
			return By.id(expression);
		}
// find by name
		else if (locatorType.equalsIgnoreCase("NAME")) {
			return By.name(expression);
		}
// Find by css
		else if (locatorType.equalsIgnoreCase("CSS")) {
			return By.cssSelector(expression);
		}
// find by link
		else if (locatorType.equalsIgnoreCase("LINK")) {
			return By.linkText(expression);
		}
// find by partial link
		else if (locatorType.equalsIgnoreCase("PARTIALLINK")) {
			return By.partialLinkText(expression);
		}
		return null;
	}
	public void close() {
		driver.quit();
	}

}
