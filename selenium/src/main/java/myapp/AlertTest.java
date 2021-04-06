package myapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends MyAppBaseTest {

@BeforeMethod
public void setup() {
super.setup();
driver.get(URL + "alerts.html");
sleep(5);
}

/*
How to switch to alert and get alert obj?
Alert alert = driver.switchTo().alert();

How to get alert message?
String alertMessage= alert.getText();

How to click ok on alert message?
alert.accept();

How to click on cancel/dismiss?
alert.dismiss();

How to send data to the popup?
alert.sendKeys("<some text>");
*/

//<input type="button" name="alert1" onclick="check1()" value="alert1"><br><br>
@Test
public void testAlert1() {
driver.findElement(By.name("alert1")).click();

// Switching to Alert
Alert alert = driver.switchTo().alert();

// Capturing alert message.
String alertMessage = alert.getText();
Assert.assertEquals(alertMessage, "Hello");
sleep(2);

// Accepting alert
alert.accept();
sleep(2);
}

//<input type="button" name="alert2" onclick="check2()" value="alert2"><br><br>
		@Test
		public void testAlert2Ok() {
			driver.findElement(By.name("alert2")).click();
			
			sleep(2);
			
			// Switching to Alert
			Alert alert = driver.switchTo().alert();
			
			// Capturing alert message.
			String alertMessage = alert.getText();
			
			Assert.assertEquals(alertMessage, "do you want to continue?");
			
			//click on OK
			alert.accept();
			
			sleep(2);
			
		}
		@Test
		public void testAlertCancel() {
			driver.findElement(By.name("alert2")).click();
			
			sleep(2);
			
			// Switching to Alert
			Alert alert = driver.switchTo().alert();
			
			// Capturing alert message.
			String alertMessage = alert.getText();
			
			Assert.assertEquals(alertMessage, "do you want to continue?");
			
			//click on cancel
			alert.dismiss();
			
			sleep(2);
		}
		//<input type="button" name="alert3" onclick="check3()" value="alert3"><br><br>
		@Test
		public void test3() {
		driver.findElement(By.name("alert3")).click();

		sleep(3);

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();

		Assert.assertEquals(alertMessage, "enter page");

		//enter data
		alert.sendKeys("form.html");

		// click ok
		alert.accept();

		sleep(3);
		}


}