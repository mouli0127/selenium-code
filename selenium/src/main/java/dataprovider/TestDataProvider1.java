package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider1 {

	@DataProvider(name = "test1")
	public static Object[][] data() {
		return new Object[][] { { "admin1" }, { "admin2" }, { "admin3" }, { "admin4" }, { "admin5" }, { "admin6" },
				{ "admin7" } };
	}

	@Test(dataProvider = "test1")
	public void testData(String name) {
		System.out.println(name);
	}
}