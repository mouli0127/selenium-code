package testng;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

public class Ex15 extends MyBaseTest {

	@Test
	public void takeScreenShot() throws Exception {
		WebDriver driver = Commons.getChromeDriver();
		// goto url
		driver.get("http://facebook.com");
		
		// Call take screenshot function
		takeSnapShot(driver, "C://test//test.jpeg");
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}