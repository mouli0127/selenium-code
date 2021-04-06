package myapp;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScroll extends MyAppBaseTest {



/**
For scroll use the JavascriptExecutor

How to get the JavascriptExecutor
JavascriptExecutor js = (JavascriptExecutor) driver;


How to perform scroll?
js.executeScript("scrollBy(0, 4500)");

*/
@BeforeMethod
public void setup() {
super.setup();
driver.get("https://www.youtube.com");
sleep(5);
}


@Test
public void t1() {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("scrollBy(0, 4500)");
sleep(3);

js.executeScript("scrollBy(0, 4500)");
sleep(3);

js.executeScript("scrollBy(0, 4500)");
sleep(3);

}
}