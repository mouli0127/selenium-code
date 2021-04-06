package basic;

import org.openqa.selenium.WebDriver;
import util.Commons;

/**
 
  How to get the page title:
-----------------------------
1. create the driver object
2.call  driver.getTitle() method to get the title

 */
public class Ex3 {
	public static void main(String[] args) throws InterruptedException {
		//	get driver
		WebDriver driver = Commons.getChromeDriver();

		//		Open the URL
		driver.get("https://www.gmail.com");

		//wait for 5 sleep
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println(title);

		//close the browser
		driver.quit();
	}
}