package myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestKey1 extends MyAppBaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get("https://www.google.com");
		sleep(5);
	}

	/**
	 * Open Google.com Type selenium press down press down press down press Enter
	 */

	@Test
	public void t1() {
		WebElement e = driver.findElement(By.name("q"));

		e.sendKeys("selenium");
		sleep(2);

		Actions a = new Actions(driver);

		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		a.sendKeys(Keys.ENTER).build().perform();
		sleep(2);

	}

	@Test
	public void t2() {
		WebElement element = driver.findElement(By.name("q"));

		Actions action = new Actions(driver);

		action.keyDown(element, Keys.SHIFT);
		action.sendKeys(element, "selenium");
		action.keyUp(element, Keys.SHIFT);
		action.sendKeys(element, " java tutorial");
		action.build().perform();
		sleep(3);

		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);

		action.sendKeys(Keys.ENTER).build().perform();
		sleep(2);
	}
	/**
	Press
	1.control + Home
	2.control + End
	3.control + f5
	 */
	@Test
	public void t3() {
		t2();
		Actions action = new Actions(driver);
		// Press END using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		sleep(3);
		// Press HOME using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		sleep(3);
		// Refresh
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		sleep(3);
	}
}