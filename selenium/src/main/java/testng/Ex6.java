package testng;
import org.testng.annotations.Test;
public class Ex6 {
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("in test1");
	}

	@Test(priority = 2)
	public void test5() {
		System.out.println("in test5");
	}

	@Test(priority = 3)
	public void test3() {
		System.out.println("in test3");
	}

	@Test(priority = 4)
	public void test2() {
		System.out.println("in test2");
	}
}