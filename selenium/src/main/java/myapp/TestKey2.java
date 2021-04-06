package myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**

 */
public class TestKey2 extends MyAppBaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(URL+ "hover.html");
		sleep(5);
	}
	
	@Test
	public void t1() {
		WebElement txtUsername = driver.findElement(By.id("myname"));
		txtUsername.sendKeys("kumar");
		
		sleep(3);
		Actions actions = new Actions(driver);
		actions.moveToElement(txtUsername).click().sendKeys(" shyam ").build().perform();
		
		sleep(3);
		
		
	}
	@Test
	public void t2() {
	WebElement link1 = getLinkText("Click here");
	WebElement link2 = getLinkText("Click for Date");
	WebElement link3 = getLinkText("Send Data");
	WebElement link4 = getLinkText("Ex1");
	WebElement link5 = getLinkText("Ex2");


	Actions actions = new Actions(driver);

	actions.moveToElement(link1).build().perform();
	sleep(3);

	actions.moveToElement(link2).build().perform();
	sleep(3);

	actions.moveToElement(link3).build().perform();
	sleep(3);

	actions.moveToElement(link4).build().perform();
	sleep(3);

	actions.moveToElement(link5).build().perform();
	sleep(3);
	}


	@Test
	public void t3() {
	Actions actions = new Actions(driver);

	actions.moveToElement(getLinkText("Click here")).click().build().perform();
	sleep(2);
	driver.navigate().back();
	sleep(2);

	actions.moveToElement(getLinkText("Click for Date")).click().build().perform();
	sleep(2);
	driver.navigate().back();
	sleep(2);

	actions.moveToElement(getLinkText("Send Data")).click().build().perform();
	sleep(2);
	driver.navigate().back();
	sleep(2);

	actions.moveToElement( getLinkText("Ex1")).click().build().perform();
	sleep(2);
	driver.navigate().back();
	sleep(2);

	actions.moveToElement(getLinkText("Ex2")).click().build().perform();
	sleep(2);
	driver.navigate().back();
	sleep(2);
	}
	@Test
	public void testText_3() {

	//move to text field and click
	WebElement element = getTextField(By.name("uName"));

	Actions action = new Actions(driver);

	action.moveToElement(element).click().build().perform();
	sleep(3);

	action
	.sendKeys(element, "selenium")
	.build().perform();

	// Double click
	action.doubleClick(element).build().perform();
	sleep(3);

	// Right click
	action.contextClick(element).build().perform();
	sleep(3);
	}
	
	
	
}