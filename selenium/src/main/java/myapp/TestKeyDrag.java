package myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
How to perfrom drag and drop?

Approach#1:
--------------------
WebElement From = driver.findElement(By.id(""));
WebElement To = driver.findElement(By.id(""));
Actions action = new Actions(driver);
Action dragAndDrop = action.clickAndHold(From)
.moveToElement(To)
.release(To)
.build();

dragAndDrop.perform();


Approach#2:
--------------------
WebElement From = driver.findElement(By.id(""));
WebElement To = driver.findElement(By.id(""));
Actions action = new Actions(driver);

action.dragAndDrop(From,To).build().perform();
*/
public class TestKeyDrag extends MyAppBaseTest {

@BeforeMethod
public void setup() {
super.setup();
driver.get("https://jqueryui.com/droppable/");
sleep(5);
}

@Test
public void t1() {
driver.switchTo().frame(0);
WebElement From = driver.findElement(By.id("draggable"));
WebElement To = driver.findElement(By.id("droppable"));

Actions action = new Actions(driver);
action.dragAndDrop(From,To).build().perform();

driver.switchTo().defaultContent();
sleep(3);
}



}