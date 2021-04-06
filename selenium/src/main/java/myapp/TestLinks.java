package myapp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLinks extends MyAppBaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(URL + "Links.html");
		sleep(2);
	}
	
	//test the page contains only 4 links
		/*
		 How to get the element using the tag name
		 solution)
		 use  driver.findElements(By.tagName("<tag name>"));
	*/
	@Test
	public void testLinks() {
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 //multiple web elements
		 Assert.assertEquals(links.size() , 8,"expected 8 links.");
	}
	//<a href="https://www.youtube.com" id="ytUrl">Click here for Youtube</a>
	@Test
	public void testYt() {
	WebElement link = driver.findElement(By.id("ytUrl"));
	checkEnabledAndDisplayed(link);
	link.click();
	sleep(3);
	}
	@Test
	public void testGoogle1() {
		WebElement link = driver.findElement(By.linkText("Click here for Google"));
		checkEnabledAndDisplayed(link);
		link.click();
		sleep(3);
	}
	
	@Test
	public void testGoogle2() {
		WebElement link =driver.findElement(By.partialLinkText("Google"));
		checkEnabledAndDisplayed(link);
		link.click();
		sleep(3);
	}
	
	@Test
	public void testGoogle3() {
		getLinkText("Click here for Google").click();
		sleep(3);
	}
	
	@Test
	public void testGoogle4() {
		getPartialText("Google").click();
		sleep(3);
	}
}