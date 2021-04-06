package testapp;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestLoginBasic2 extends MyEmpDemoBaseTest1 {

	@Test
	public void testValidCreds() {
		login("admin", "admin");

		sleep(5);
//logout
		WebElement logout = driver.findElement(By.id("logoutLbl"));
		;
		checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();

		sleep(5);
	}

	@Test
	public void testValidUnAndInvalidPwd() {
		login("admin", "admin123");
		sleep(5);

//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}

	@Test
	public void testInValidUnAndInvalidPwd() {
		login("admin123", "admin123");
		sleep(5);

//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}

	@Test
	public void testUserNameEmptyAndPasswordEmpty() {
		login("", "");
		sleep(5);

//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}

	@Test
	public void testUserNameEmptyAndPasswordNotEmpty() {
		login("", "admin123");

		sleep(5);

//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
		sleep(5);

	}

	@Test
	public void testUserNameNotEmptyAndPasswordEmpty() {
		login("admin123", "");

		sleep(5);

//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
		sleep(5);
	}

	@Test
	public void testUserNameNotEmptyAndPasswordLengthLessThan4Chars() {
		login("admin123", "ab");
		sleep(5);

//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}

	@Test
	public void testUserNameNotEmptyAndPasswordGreaterThan10Chars() {
		login("admin123", "1212121212122222222");
		sleep(5);

//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}

//method to perform login
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