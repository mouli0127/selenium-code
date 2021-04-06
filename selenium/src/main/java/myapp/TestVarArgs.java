package myapp;
public class TestVarArgs {
	public static void main(String[] args) {
		System.out.println("------------display-----");
		display("hi");
		display("hi","how");
		display("java programming",".net","c++"); 
		display("welcome","to","java","python","selenium","testing","hana");
	}

	public static void display(String... data){
		System.out.println("*******************************");
		for(String v: data){
			System.out.println(v);
		}
	}
}