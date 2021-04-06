package myapp;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathTest extends MyAppBaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(URL + "xpath2.html");
		sleep(5);
	}

	/**
	 * Click on both links
	 * 
	 * <a href="https://www.gmail.com">click here</a> <br/>
	 * <a href="https://www.fb.com">click here</a> <br/>
	 * 
	 */
	@Test
	public void testXpath1() {
		WebElement link1 = driver.findElement(By.xpath("//a[@href='https://www.gmail.com']"));
		link1.click();

		sleep(3);

		driver.navigate().back();

		sleep(3);
		WebElement link2 = driver.findElement(By.xpath("//a[@href='https://www.fb.com']"));
		link2.click();
		sleep(3);

	}

	/**
	 * validate the label text. Enter data to text field.
	 * 
	 * <label id='error'>Enter values here</label> <br/>
	 * Enter name : <input id='error' type="text"/><br/>
	 * <br/>
	 */

	@Test
	public void t2() {
		WebElement label = driver.findElement(By.xpath("//label[@id='error']"));

		Assert.assertEquals(label.getText(), "Enter values here", "invalid label value");

		getTextField(By.xpath("//input[@id='error']")).sendKeys("ramesh");
		sleep(3);
	}
	/**
	click on RESET and ADD button
	<input type="button" value="RESET" onclick="f1()"/><br/><br/>

	<input type="button" value="ADD" onclick="f2()"/><br/>

	<p id="dynamicData"></p>

	*/
	@Test
	public void t3() {
	driver.findElement(By.xpath("//input[@value='RESET']")).click();
	sleep(3);

	String text = driver.findElement(By.id("dynamicData")).getText();
	Assert.assertEquals( text,"RESET selected" ,"Invalid value");
	sleep(3);

	driver.findElement(By.xpath("//input[@value='ADD']")).click();
	sleep(3);

	text = driver.findElement(By.id("dynamicData")).getText();
	Assert.assertEquals( text,"ADD selected" ,"Invalid value");
	sleep(3);
	}
	

		@Test
		public void t4() {
		List<WebElement> elements = driver.findElements(By.xpath("//p[@class='show']"));
		Assert.assertEquals( elements.size(),4 ,"Invalid value");

		for(WebElement e1: elements) {
		Assert.assertTrue(e1.getText().contains("Hello"),"Expected Hello");
		}

		}

}