package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.Commons;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com
  
 */
public class Ex10 {
	
	// get driver
	WebDriver driver; 
			
	@BeforeMethod
	public void openDriver() {
		// get driver
		driver = Commons.getChromeDriver();
	}
	
	@AfterMethod
	public void closeDriver() {
		// close the browser
		driver.quit();
	}
	
	@Test
	public void testFb() throws InterruptedException {
		// Open the URL
		driver.get("https://www.fb.com");

		// wait for 5 sleep
		Thread.sleep(2000);
	}
	
	@Test
	public void testYt() throws InterruptedException {
		// Open the URL
		driver.get("https://www.youtube.com");

		// wait for 5 sleep
		Thread.sleep(2000);
	}
	
	@Test
	public void testGmail() throws InterruptedException {
		// Open the URL
		driver.get("https://www.gmail.com");

		// wait for 5 sleep
		Thread.sleep(2000);
	}
	
}