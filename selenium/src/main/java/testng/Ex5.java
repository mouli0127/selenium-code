package testng;
import org.testng.annotations.Test;

//By default the test cases are executed in alphabetical order.
public class Ex5 {
	
	@Test
		public void test1() {
			System.out.println("test1");
		}

		@Test
		public void test5() {
			System.out.println("test5");
		}

		@Test
		public void test3() {
			System.out.println("test3");
		}

		@Test
		public void test2() {
			System.out.println("test2");
		}
}