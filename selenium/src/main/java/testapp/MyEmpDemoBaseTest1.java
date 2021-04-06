package testapp;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Commons;

public class MyEmpDemoBaseTest1 {

	public WebDriver driver;
	public static final String URL = "http://localhost:8101/EmpDemo/";

	@BeforeTest
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
		driver.get(URL);
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
// Move image file to new destination
		File DestFile = new File(fileWithPath);

		if (!DestFile.exists())
			DestFile.createNewFile();
// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			System.out.println(element);
			Assert.assertTrue(element.isDisplayed(), "element expeceted to display");
			Assert.assertTrue(element.isEnabled(), "element expected to enable");
		}
	}

	public WebElement getTextField(By by) {
		WebElement element = driver.findElement(by);
//
		checkEnabledAndDisplayed(element);

// verify type
		String actual = element.getAttribute("type");
		Assert.assertEquals(actual, "text");

		return element;
	}

	public WebElement getPasswordField(By by) {
		WebElement element = driver.findElement(by);
//
		checkEnabledAndDisplayed(element);

// verify type
		String actual = element.getAttribute("type");
		Assert.assertEquals(actual, "password");

		return element;
	}

	public WebElement getRadio(By by, boolean isSelected) {
		WebElement radio = driver.findElement(by);

		checkEnabledAndDisplayed(radio);

		Assert.assertEquals(radio.getAttribute("type"), "radio");

		Assert.assertEquals(radio.isSelected(), isSelected, "radio is selected.");

		return radio;
	}

	public WebElement getCheckBox(By by, boolean isSelected) {
		WebElement check = driver.findElement(by);

		checkEnabledAndDisplayed(check);

		Assert.assertEquals(check.getAttribute("type"), "checkbox");

		Assert.assertEquals(check.isSelected(), isSelected, "radio is selected.");

		return check;
	}

	public WebElement getDropDown(By by, int actual, String defaultCity) {
		WebElement cities = driver.findElement(by);
// create select obj
		Select select = new Select(cities);
		Assert.assertFalse(select.isMultiple(), "should be multi dropdown");
		return validateDropDown(actual, defaultCity, cities, select);
	}

	public WebElement getMultiDropDown(By by, int actual, String defaultCity) {
		WebElement cities = driver.findElement(by);
// create select obj
		Select select = new Select(cities);
		Assert.assertTrue(select.isMultiple(), "should be multi dropdown");
		return validateDropDown(actual, defaultCity, cities, select);
	}

	private WebElement validateDropDown(int actual, String defaultValue, WebElement dropdownObj, Select select) {
		checkEnabledAndDisplayed(dropdownObj);

// How to get all the options
		List<WebElement> options = select.getOptions();
//validate the number of cities
		int size = options.size();
		Assert.assertEquals(size, actual, "invalid no of options");

		if (defaultValue != null && !defaultValue.equals("")) {
// validate the default value in dropdown
			WebElement selectedCity = select.getFirstSelectedOption();
			Assert.assertEquals(selectedCity.getText(), defaultValue, "invalid default value");
		}

		return dropdownObj;
	}

	public WebElement getLinkText(String text) {
		WebElement link = driver.findElement(By.linkText(text));
		checkEnabledAndDisplayed(link);
		return link;
	}

	public WebElement getPartialText(String text) {
		WebElement link = driver.findElement(By.partialLinkText(text));
		checkEnabledAndDisplayed(link);
		return link;
	}
	// method to perform login
	public void login(String userNameValue, String passwordValue) {

	// get the web element objects
	WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
	WebElement name = driver.findElement(By.name("loginName"));

	WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
	WebElement password = driver.findElement(By.name("password"));

	WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	WebElement formTitle = driver.findElement(By.tagName("h1"));

	checkEnabledAndDisplayed(usernamelab, passwordlab, loginBtn, password, name);

	// test the form name
	assertTrue(formTitle.getText().equals("Login Page"));

	// test label for username
	assertTrue(usernamelab.getText().equals("User Name:"));

	// test label for Password
	assertTrue(passwordlab.getText().equals("Password:"));

	// test label for button
	assertTrue(loginBtn.getAttribute("value").equals("Login"));

	// test type for username
	assertTrue(name.getAttribute("type").equals("text"));

	// test type for password
	assertTrue(password.getAttribute("type").equals("password"));

	name.sendKeys(userNameValue);
	password.sendKeys(passwordValue);
	loginBtn.click();
	}
}