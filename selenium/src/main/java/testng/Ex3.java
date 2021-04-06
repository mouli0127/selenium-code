package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
In BeforeClass

In before
running test1
in after 

In before
running test2
in after 

In before
running test3
in after 

In AfterClass


 */
public class Ex3 {
	
	@BeforeClass
	public void beforeclz() {
		System.out.println("In BeforeClass");
	}
	
	@AfterClass
	public void afterclz() {
		System.out.println("In AfterClass");
	}
	
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