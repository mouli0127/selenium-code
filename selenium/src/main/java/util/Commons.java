package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commons {

	private static final String DRIVER_PATH = "C:\\Users\\praka\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe";
	public static final String EMP_DEMO_URL = "http://localhost:8101/EmpDemo/";

	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		WebDriver driver = new ChromeDriver();

		return driver;
	}

	public static WebDriver getFireFoxDriver() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		WebDriver driver = new ChromeDriver();

		return driver;
	}

	public static WebDriver startApplication(WebDriver driver, String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = Commons.getChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = Commons.getFireFoxDriver();
		}
		driver.get(EMP_DEMO_URL);
		driver.manage().window().maximize();
// driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}