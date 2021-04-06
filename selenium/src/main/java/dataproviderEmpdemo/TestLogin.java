package dataproviderEmpdemo;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelDataProvider.ExcelUtils;
import pompages.LoginPage;
import pomtests.POMBaseTest;

/**
 * Data provider for login page
 * 
 * excel: ------------------ <username> , <password> , <asserType>
 * 
 * /* if asserType = A (login success) then perform Logout if asserType = B then
 * Test for Alert (Please provide LoginName!) if asserType = C then Test for
 * Alert (Please provide Password!) if asserType = D then Test for TextMessage
 * (Invalid Login) if asserType = E then Test for Password length (Password
 * length)
 */

public class TestLogin extends POMBaseTest {

	LoginPage loginPageObj;

	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@DataProvider(name = "excelData")
	public static Object[][] getData() throws Exception {
		return ExcelUtils.getTableArray("C://test//DataProvider.xlsx", "input");
	}

	@Test(dataProvider = "excelData")
	public void testLogin(String name, String pass, String assertType) {
		
		name = name==null? "": name;
		pass = pass==null? "": pass;
		
		loginPageObj.login(name, pass);
		if (assertType.equals("A")) {
			loginPageObj.logout();
		} else if (assertType.equals("B")) {
			loginPageObj.validateLoginNameAlert();
		} else if (assertType.equals("C")) {
			loginPageObj.validatePasswordAlert();
		} else if (assertType.equals("D")) {
			loginPageObj.validateLoginFailure();
		} else if (assertType.equals("E")) {
			loginPageObj.validatePasswordLength();
		}
	}
}