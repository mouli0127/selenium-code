package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myapp.MyAppBaseTest;

public class TestDataProvider4Google extends MyAppBaseTest{

@DataProvider(name = "test1")
public static Object[][] data() {
return new Object[][] {
{ "java " },
{ "selenium" },
{ "how to search in google" },
{ "how to download selenium driver" },
{ "selenium data provider example" } };
}

@Test(dataProvider = "test1")
public void testData(String searchKey) throws InterruptedException {
driver.get("https://www.google.com");

WebElement searchText = driver.findElement(By.name("q"));
searchText.sendKeys(searchKey);
searchText.submit();
Thread.sleep(4000);
}


}