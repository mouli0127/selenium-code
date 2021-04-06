package basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex1 {
	public static void main(String[] args) throws InterruptedException {
		//get driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\praka\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver(); 
	    
		//Open the URL
	    driver.get("https://www.gmail.com");
	    
	    //wait for 5 sleep
	    Thread.sleep(5000);
	    
	    //close the browser
	    driver.quit();
	}
}