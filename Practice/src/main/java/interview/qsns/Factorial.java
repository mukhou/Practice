package interview.qsns;

public class Factorial {

	private static int factorial_recursive(int n) {

		if (n == 0) {
			return 1;
		} else {
			return n * factorial_recursive(n - 1);
		}
	}

	private static void factorial_iterative(int n) {

		int fact = 1;

		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println("the factorial is " + fact);
	}

	public static void main(String[] args) {
		int fact, n = 5;

		fact = factorial_recursive(5);

		System.out.println("The factorial is " + fact);
		factorial_iterative(n);

	}

}
