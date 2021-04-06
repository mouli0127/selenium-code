package testng;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com
  
 */
public class Ex9 {
	
	@Test
	public void testFb() throws InterruptedException {
		// get driver
		WebDriver driver = Commons.getChromeDriver();

		// Open the URL
		driver.get("https://www.fb.com");

		// wait for 5 sleep
		Thread.sleep(5000);

		// close the browser
		driver.quit();
	}
	
	@Test
	public void testYt() throws InterruptedException {
		// get driver
		WebDriver driver = Commons.getChromeDriver();

		// Open the URL
		driver.get("https://www.youtube.com");

		// wait for 5 sleep
		Thread.sleep(5000);

		// close the browser
		driver.quit();
	}
	
	@Test
	public void testGmail() throws InterruptedException {
		// get driver
		WebDriver driver = Commons.getChromeDriver();

		// Open the URL
		driver.get("https://www.gmail.com");

		// wait for 5 sleep
		Thread.sleep(5000);

		// close the browser
		driver.quit();
	}
	
}