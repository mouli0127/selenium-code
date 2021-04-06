package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
In before
running test1
in after 

In before
running test2
in after 

In before
running test3
in after 

 */
public class Ex2 {
	
	@BeforeMethod
	public void before() {
		System.out.println("In before");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("in after ");
	}
	
	@Test
	public void test1() {
		System.out.println("running test1");
	}
	
	@Test
	public void test2() {
		System.out.println("running test2");
	}
	
	@Test
	public void test3() {
		System.out.println("running test3");
	}
}