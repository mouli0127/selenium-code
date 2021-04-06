package basic;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class Ex2 {
	public static void main(String[] args) throws InterruptedException {
//get driver
		WebDriver driver = Commons.getChromeDriver();

//Open the URL
		driver.get("https://www.gmail.com");

//wait for 5 sleep
		Thread.sleep(5000);

//close the browser
		driver.quit();
	}
}