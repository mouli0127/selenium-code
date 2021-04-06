package basic;

import java.util.Set;

import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;

import util.Commons;
/**
 
-  How to delete the page cookies?
   driver.manage().deleteAllCookies();

-  How to delete the page cookie by name?
   driver.manage().deleteCookieNamed("language");
   
-  How to GET the page cookie by name?   
   driver.manage().getCookieNamed("SID")
   
 - How to get the page cookies?
   Set<Cookie> cookies = driver.manage().getCookies();
    
 */
public class Ex5Cookies {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.youtube.com");
		
		//get all cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie: cookies) {
			System.out.println("***************************888");
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
		}
		
	}
}