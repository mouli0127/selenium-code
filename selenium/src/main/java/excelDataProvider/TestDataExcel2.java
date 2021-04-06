package excelDataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataExcel2 {

	@DataProvider(name = "test1")
	public static Object[][] data() throws IOException {
		return ExcelUtils.getTableArray("C://test//data.xlsx", "output");
	}

	@Test(dataProvider = "test1")
	public void testData(String name, String pwd, String status) {
		System.out.println(name + " -" + pwd + "- " + status);
	}

}