package myapp;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex1 extends MyAppBaseTest{

	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(URL + "form.html");
		sleep(3);
	}
	//<input type="text" id="myname" name="uName">
	@Test
	public void testFn() {
	//get web element
	WebElement element = driver.findElement(By.name("uName"));

	//verify enabled
	Assert.assertTrue(element.isEnabled() ,"fn should be enabled");

	//verify displayed
	Assert.assertTrue(element.isDisplayed() ,"fn should be displayd");

	//verify type
	String actual= element.getAttribute("type");
	Assert.assertEquals(actual, "text");

	element.sendKeys("raj kumar");

	sleep(3);


	}
	//<input type="text" name="uName1" readonly="readonly" value="kumar">
		@Test
		public void testMiddleName() {
			WebElement element = driver.findElement(By.name("uName1"));
			
			// How to check if the text field is enabled
			Assert.assertTrue(element.isEnabled(), "Middle name should be enabled");

			// How to check if the text field is displayed
			Assert.assertTrue(element.isDisplayed(), "Middle name should be Displayed");

			// How to check if the field is text field
			Assert.assertEquals(element.getAttribute("type"), "text");
			
			// How to assert the readonly
			Assert.assertEquals(element.getAttribute("readonly"), "true");
			
			// How to assert the value
			Assert.assertEquals(element.getAttribute("value"), "kumar");
			
		}
		
		//<input type="text" name="LName" size="30" width="30">
		@Test
		public void testLastName() {
			//get web element obj
			WebElement element = driver.findElement(By.name("LName"));
			
			//How to check if the text field is enabled
			 Assert.assertTrue(element.isEnabled() ,"LName should be enabled");
			 
			 //How to check if the text field is displayed
			 Assert.assertTrue(element.isDisplayed(),"LName should be Displayed");
			 
			 //How to check if the field is text field
			 Assert.assertEquals(element.getAttribute("type") , "text");
			 
			//How to check width
			// Assert.assertEquals(element.getAttribute("width") , "30");
			 
			 //How to check size
			// Assert.assertEquals(element.getAttribute("size") , "30");
			 
			 element.sendKeys("varma");
			 sleep(3);
			
		}
		//<input type="text" name="uName2" disabled="disabled">
		@Test
		public void testSn() {
			WebElement element = driver.findElement(By.name("uName2"));
			
			//How to check if the field is text field
			Assert.assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		
			//How to check if the text field is disabled
			Assert.assertFalse(element.isEnabled(),"uName2 should be disabled");
			
			//How to check if the text field is displayed
			Assert.assertTrue(element.isDisplayed(),"uName2 should be displayed");
			
		}
		@Test
		public void testPassword() {
			 WebElement element = driver.findElement(By.name("password"));
			 
				//How to check if the password is enabled
			 Assert.assertTrue(element.isEnabled(),"password should be enabled");
			 
			 //How to check if the password is displayed
			 Assert.assertTrue(element.isDisplayed(),"password should be displayed");
		
			 //How to check if the field is password
			 Assert.assertEquals(element.getAttribute("type"),"password", "Invalid field type.Expected password");
			 
			 element.sendKeys("Raju1234345");
			 
			 sleep(3);
			 
		}
		@Test
		public void testRadio() {
			WebElement mRadio = driver.findElement(By.id("mRadio"));
			WebElement fRadio = driver.findElement(By.id("fRadio"));
			WebElement oRadio = driver.findElement(By.id("oRadio"));
			
			Assert.assertTrue(mRadio.isEnabled() && mRadio.isDisplayed(), "mRadio should be enabled and displayed");
			Assert.assertTrue(fRadio.isEnabled() && fRadio.isDisplayed(), "fRadio should be enabled and displayed");
			Assert.assertTrue(oRadio.isEnabled() && oRadio.isDisplayed(), "oRadio should be enabled and displayed");
			
			Assert.assertEquals(mRadio.getAttribute("type"), "radio");
			Assert.assertEquals(fRadio.getAttribute("type"), "radio");
			Assert.assertEquals(oRadio.getAttribute("type"), "radio");
			
			Assert.assertTrue(mRadio.isSelected(), "mRadio is selected.");
			Assert.assertFalse(fRadio.isSelected(), "fRadio is not selected.");
			Assert.assertFalse(oRadio.isSelected(), "oRadio is not selected.");
			
			// how to select radio button
			oRadio.click();
			sleep(2);
			
			fRadio.click();
			sleep(2);
			
			mRadio.click();
			sleep(2);
					
		}
		//<input type="checkbox" name="proof1" value="passport">passport &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		//<input type="checkbox" name="proof2" value="voter">voter &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		//<input type="checkbox" name="proof3" value="pan" checked> pan<br>
		
		@Test
		public void testCheckBox1() {
			WebElement passport = driver.findElement(By.name("proof1"));
			WebElement voter = driver.findElement(By.name("proof2"));
			WebElement pan = driver.findElement(By.name("proof3"));

			Assert.assertEquals(passport.getAttribute("type"), "checkbox");
			Assert.assertEquals(voter.getAttribute("type"), "checkbox");
			Assert.assertEquals(pan.getAttribute("type"), "checkbox");

			// checkEnabledAndDisplayed
			Assert.assertTrue(passport.isEnabled(), "passport should  enabled");
			Assert.assertTrue(voter.isEnabled(), "voter should  enabled");
			Assert.assertTrue(pan.isEnabled(), "pan should be enabled");

			Assert.assertFalse(passport.isSelected(), "passport is not selected.");
			Assert.assertFalse(voter.isSelected(), "voter is not selected.");
			Assert.assertTrue(pan.isSelected(), "pan is  selected.");

			// unchek pan
			pan.click();
			sleep(3);
			
			// unchek pan
			passport.click();
			sleep(3);
			
			// unchek pan
			voter.click();
			sleep(3);
			
			
		}
		
		// <textarea name="address" rows="5" cols="80"></textarea>
		@Test
		public void testTextArea() throws InterruptedException {
		WebElement address = driver.findElement(By.name("address"));

		// How to check if the password is enabled
		Assert.assertTrue(address.isEnabled(), "address should be enabled");

		// How to check if the password is displayed
		Assert.assertTrue(address.isDisplayed(), "address should be displayed");
		
		Assert.assertEquals(address.getAttribute("rows"), "5", "invalid no of rows");
		Assert.assertEquals(address.getAttribute("cols"), "80", "invalid no of cols");
		
		address.sendKeys("#51/15 a-51, panathur road, bangalore.");
		
		sleep(3);
		}
		//Upload image :<input type="file" name="fileupload" accept="image/*" />
				@Test
				public void testUpload() { 
					WebElement uploadElement = driver.findElement(By.name("fileupload"));
					
					// How to check if the password is enabled
					Assert.assertTrue(uploadElement.isEnabled(), "uploadElement should be enabled");

					// How to check if the password is displayed
					Assert.assertTrue(uploadElement.isDisplayed(), "uploadElement should be displayed");
					
					Assert.assertEquals(uploadElement.getAttribute("type"), "file", "invalid type.");
					Assert.assertEquals(uploadElement.getAttribute("accept"), "image/*", "invalid accept.");
					
					uploadElement.sendKeys("C://test//test.jpeg");
					sleep(3);
				}
				
				//	<br> <input type="submit" name="submit" value="submit" />
				@Test
				public void submit() {
					WebElement submit = driver.findElement(By.name("submit"));
					submit.submit();
				}
				@Test
				public void testDropdown() throws InterruptedException {
					WebElement cities = driver.findElement(By.name("city"));
					
					// How to check if the password is enabled
					Assert.assertTrue(cities.isEnabled(), "cities should be enabled");

					// How to check if the password is displayed
					Assert.assertTrue(cities.isDisplayed(), "cities should be displayed");
					
					// create select obj
					Select select = new Select(cities);	
					
					Assert.assertFalse(select.isMultiple(), "city is not multi dropdown");
					
					// How to get all the options
					List<WebElement> options = select.getOptions();	
					//validate the number of cities
					int size = options.size();
					Assert.assertEquals(size, 4,"invalid no of cities");
					
					// validate the default value in dropdown
					WebElement selectedCity = select.getFirstSelectedOption();	
					Assert.assertEquals(selectedCity.getText(), "Bangalore","invalid default value");
					
					select.selectByVisibleText("Chennai");
					sleep(3);
					
					select.selectByIndex(1);
					sleep(3);
					
					select.selectByValue("mum");
					sleep(3);
				}
				@Test
				public void testMultiDropdown() throws InterruptedException {
					WebElement citizen = driver.findElement(By.name("citizen"));
					
					// How to check if the password is enabled
					Assert.assertTrue(citizen.isEnabled(), "citizen should be enabled");

					// How to check if the password is displayed
					Assert.assertTrue(citizen.isDisplayed(), "citizen should be displayed");
				
					//create select obj
					Select select = new Select(citizen);
				
					Assert.assertTrue(select.isMultiple(),"citizen is multi dropdown");
				
					// How to get all the options
					List<WebElement> options = select.getOptions();	
					//validate the number of cities
					int size = options.size();
					Assert.assertEquals(size, 4,"invalid no of citizenships");
					
					
					
					//select the values in dropdown
					select.selectByVisibleText("India");
					sleep(3);
					
					select.selectByIndex(1);
					sleep(3);
					
					select.selectByValue("US");
					sleep(3);
					
					
					//deselect the values in dropdown
					select.deselectByVisibleText("India");
					sleep(3);
					
					select.deselectByIndex(1);
					sleep(3);
					
					select.deselectByValue("US");
					sleep(3);
					
					
					select.selectByVisibleText("India");
					sleep(3);
					
				}
	@Test
	public void testText() {
		
	}
	
}