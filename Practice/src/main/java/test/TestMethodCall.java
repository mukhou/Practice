package test;

public class TestMethodCall {

	static boolean checkNum(int a , int b){
		return a == b;
	}
	
	static public boolean checkMethodCall(){
	boolean b = true;
		return b == checkNum(2, 3);
	}
	public static void main(String[] args) {
		System.out.println(checkMethodCall());

	}

}
