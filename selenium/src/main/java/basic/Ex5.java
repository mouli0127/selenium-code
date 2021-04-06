package basic;

import org.openqa.selenium.WebDriver;
import util.Commons;

/**
 
 
How to perform refresh on page?
------------------------------------
driver.navigate().refresh();


How to perform back on page?
------------------------------------
driver.navigate().back();

 
How to perform forward on page?
------------------------------------
driver.navigate().forward();


Req:
1.Open gmail.com
2.wait for 5 seconds
3.perform refresh   --> opens gmail

4.Open youtube.com
5.wait for 5 seconds
6.Perform back operation  -----> redirects to gmail.com

7.wait for 5 seconds
8.Perform forward operation  -->redirects to youtube.com


9.wait for 5 seconds
10.close browser


 */
public class Ex5 {
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
		driver.navigate().refresh();
		//wait for 5 sleep
		Thread.sleep(5000);
		
		// Open the URL
		driver.get("https://www.youtube.com");
		// wait for 5 sleep
		Thread.sleep(5000);
		//get title
		title = driver.getTitle();
		System.out.println(title);
		driver.navigate().back();
		//wait for 5 sleep
		Thread.sleep(5000);
		
		
		driver.navigate().forward();
		//wait for 5 sleep
		Thread.sleep(5000);
		title = driver.getTitle();
		System.out.println(title);

		//close the browser
		driver.quit();
	}
}