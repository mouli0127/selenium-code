package basic;

import org.openqa.selenium.WebDriver;
import util.Commons;

/**
 
 Req:
open the browser and Hit the URL "https://gmail.com" using the Java and fetch the title 
open the browser and Hit the URL "https://youtube.com" using the Java and fetch the title  


 */
public class Ex4 {
	public static void main(String[] args) throws InterruptedException {
		//	get driver
		WebDriver driver = Commons.getChromeDriver();

		//Open the URL
		driver.get("https://www.gmail.com");
		//wait for 5 sleep
		Thread.sleep(5000);
		//get title
		String title = driver.getTitle();
		System.out.println(title);
		
		// Open the URL
		driver.get("https://www.youtube.com");
		// wait for 5 sleep
		Thread.sleep(5000);
		//get title
		title = driver.getTitle();
		System.out.println(title);

		//close the browser
		driver.quit();
	}
}