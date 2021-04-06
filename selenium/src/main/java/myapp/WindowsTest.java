package myapp;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTest extends MyAppBaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(URL + "window.html");
		sleep(5);
	}
	
	/**
	 How to get the current window name?
	   String parentWindowHandle = driver.getWindowHandle();
	 
	 	 
	 How to get all window handles?
	   Set<String> allWindowHandles = driver.getWindowHandles();
	
	 How to switch between the windows?
	   driver.switchTo().window("<window name>");
	 
	 
	 */
	
	/**
	<a id="gLink1" href="form.html"  
    onclick="window.open('form.html', 
                         'newwindow', 
                         'width=700,height=750');return false;">Open Window</a>
	 */
	@Test
	public void testWindow() {
		//Get the parent window name
		String parentWindowName = driver.getWindowHandle();
		Assert.assertEquals(driver.getTitle() , "test3", "Invalid title");
		driver.findElement(By.id("gLink1")).click();
		sleep(3);
		
		
		//get the child window name
		String childWindowName = getchildWIndowName(driver, parentWindowName);
		
		
		// switch to the child window using the child window name
		driver.switchTo().window(childWindowName);
		Assert.assertEquals(driver.getTitle() , "Insert title here", "Invalid title");
		//enter 1st name
		enterFn();
		
		
		// switch to the child window using the parentWindowName
		driver.switchTo().window(parentWindowName);
		Assert.assertEquals(driver.getTitle() , "test3", "Invalid title");
		//enter the data to the field in parent window
        getTextField(By.name("uName")).sendKeys("kumar");
		sleep(3);
	}
	
	private String getchildWIndowName(WebDriver driver, String parentWindowHandle) {
		String childWindowHandle = null;
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				return handle;
			}
		}
		return childWindowHandle;
	}

	
	public void enterFn() {
		//get web element 
		WebElement element = driver.findElement(By.name("uName"));
		 
		 //verify enabled
		 Assert.assertTrue(element.isEnabled() ,"fn should be enabled");
		 
		 //verify displayed
		 Assert.assertTrue(element.isDisplayed() ,"fn should be displayd");
		 
		 //verify type
		 String  actual= element.getAttribute("type");
		 Assert.assertEquals(actual, "text");
		 
		 element.sendKeys("raj kumar");
		 
		 sleep(3);
		
	}
			
			

}