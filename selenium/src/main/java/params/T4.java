package params;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T4 {
	
	@Test
	@Parameters(value = {"userName","password"})
	public void test4_1(String name,String password) {
		System.out.println("test4_1:: "+name + " - " + password);
	}
	
	@Test
	@Parameters(value = {"userName","password"})
	public void test4_2(String name,String password) {
		System.out.println("test4_2:: "+name + " - " + password);
	}
}