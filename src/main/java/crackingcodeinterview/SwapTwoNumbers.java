package crackingcodeinterview;

public class SwapTwoNumbers {

	public static void swap(int a, int b) {
		 a = b - a; // 9 - 5 = 4
		 b = b - a; // 9 - 4 = 5
		 a = a + b; // 4 + 5 = 9
		
		 System.out.println("a: " + a);
		 System.out.println("b: "  + b);
		 }
	
	public static void main(String[] args) {
		swap(5, 9);

	}

}
