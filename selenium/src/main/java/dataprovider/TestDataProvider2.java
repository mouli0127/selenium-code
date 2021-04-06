package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider2 {

	@DataProvider(name = "test1")
	public static Object[][] data() {
		return new Object[][] { { "admin1", "admin123" }, { "admin2", "admin124" }, { "admin3", "admin125" },
				{ "admin4", "admin126" }, { "admin5", "admin127" }, { "admin6", "admin128" },
				{ "admin7", "admin129" } };
	}

	@Test(dataProvider = "test1")
	public void testData(String name, String pwd) {
		System.out.println(name + " - " + pwd);
	}
}