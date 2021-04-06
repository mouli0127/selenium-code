package testsuits;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
Test4:in beforeSuite
Test5:in beforeSuite

Test4:in beforeTest
Test4:in t4 case 1
Test4:in afterTest


Test5:in beforeTest
Test5:in test case 1
Test5:in afterTest


Test4:in afterSuite
Test5:in afterSuite
 */
public class Test4 {
		// test case 1
		@Test
		public void t4() {
			System.out.println("Test4:in t4 case 1");
		}
		
		@BeforeTest
		public void beforeTest() {
			System.out.println("Test4:in beforeTest");
		}

		@AfterTest
		public void afterTest() {
			System.out.println("Test4:in afterTest");
		}

		@BeforeSuite
		public void beforeSuite() {
			System.out.println("Test4:in beforeSuite");
		}

		@AfterSuite
		public void afterSuite() {
			System.out.println("Test4:in afterSuite");
		}
}