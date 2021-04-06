package depends;
import org.testng.annotations.Test;

public class TestMethodDepends {
	
	@Test(dependsOnMethods = { "login" })
	public void createAccount() {
		System.out.println("createAccount");
	}

	@Test
	public void login() {
		System.out.println("login");
	}

	@Test(dependsOnMethods = { "createAccount" })
	public void logout() {
		System.out.println("logout");
	}
	
}