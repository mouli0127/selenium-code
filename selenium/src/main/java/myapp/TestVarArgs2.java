package myapp;
public class TestVarArgs2 {
	public static void main(String[] args) {
		int s1 = getSum(10,20,30,40,67);
		System.out.println(s1);
		
		int s2 = getSum(1,2,21,214,14,1,14,14,14,14,14,14,24,647645,7457,7);
		System.out.println(s2);
	}
	
	public static int getSum(int... data){
		System.out.println("************************************");
		int sum= 0;
		for(int v: data){
			sum = sum+v;
		}
		return sum;
	}
}