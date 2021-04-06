package testng;

import org.openqa.selenium.WebDriver;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import util.Commons;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import util.Commons;

public class MyBaseTest {

	// get driver
		public WebDriver driver; 
				
		@BeforeClass
		public void openDriver() {
			// get driver
			driver = Commons.getChromeDriver();
		}
		
		@AfterClass
		public void closeDriver() {
			// close the browser
			driver.quit();
		}
		
		public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
			// Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			if(!DestFile.exists())
				DestFile.createNewFile();
			// Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			
		}
}