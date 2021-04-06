package testapp;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestLoginBasic1 extends MyEmpDemoBaseTest1 {

	@Test
	public void testValidCreds() {
		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

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

		name.sendKeys("admin");
		password.sendKeys("admin");
		loginBtn.click();

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

		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

// test the form name

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

		name.sendKeys("admin");
		password.sendKeys("admin123");
		loginBtn.click();

		sleep(5);

//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}

	@Test
	public void testInValidUnAndInvalidPwd() {

		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

// test the form name

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

		name.sendKeys("admin123");
		password.sendKeys("admin123");
		loginBtn.click();

		sleep(5);

//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));

	}

	@Test
	public void testUserNameEmptyAndPasswordEmpty() {
	WebElement form = driver.findElement(By.tagName("form"));
	WebElement formTitle = driver.findElement(By.tagName("h1"));
	WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
	WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
	WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	WebElement name = driver.findElement(By.name("loginName"));
	WebElement password = driver.findElement(By.name("password"));

	checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

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

	name.sendKeys("");
	password.sendKeys("");
	loginBtn.click();

	sleep(5);

	//test for alert message
	Alert a = driver.switchTo().alert();
	Assert.assertEquals(a.getText(), "Please provide loginName!");
	a.accept();

	sleep(3);
	}
	@Test
	public void testUserNameNotEmptyAndPasswordLengthLessThan4Chars() {
	WebElement form = driver.findElement(By.tagName("form"));
	WebElement formTitle = driver.findElement(By.tagName("h1"));
	WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
	WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
	WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	WebElement name = driver.findElement(By.name("loginName"));
	WebElement password = driver.findElement(By.name("password"));

	checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

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

	name.sendKeys("admin123");
	password.sendKeys("ab");
	loginBtn.click();

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
	WebElement form = driver.findElement(By.tagName("form"));
	WebElement formTitle = driver.findElement(By.tagName("h1"));
	WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
	WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
	WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	WebElement name = driver.findElement(By.name("loginName"));
	WebElement password = driver.findElement(By.name("password"));

	checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

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

	name.sendKeys("admin123");
	password.sendKeys("1212121212122222222");
	loginBtn.click();

	sleep(5);

	//test for alert message
	Alert a = driver.switchTo().alert();
	Reporter.log(a.getText());
	Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
	a.accept();
	sleep(5);
	}
}
