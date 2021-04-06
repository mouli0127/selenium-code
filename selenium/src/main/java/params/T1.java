package params;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T1 {
	
	@Parameters(value = {"userName"}) 
	@BeforeMethod
	public void before(String userName) {
		System.out.println(userName);
	}
	
	@Test
	public void t1() {
		System.out.println("In t1");
	}

	@Test
	public void t2() {
		System.out.println("In t2");
	}

	
}