package byteBybyte;

public class Factorial {

	private static long factorial_recursive(int n) {

		if (n >= 1) {
			return n * factorial_recursive(n - 1);
		} else {
			return 1;
		}
	}


	private static void factorial_iterative(int n) {

		long fact = 1;

		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println("the factorial is " + fact);
	}


	public static void main(String[] args) {
		int fact, n = 20;

		System.out.println(factorial_recursive(20));

		factorial_iterative(20);
	}

}
