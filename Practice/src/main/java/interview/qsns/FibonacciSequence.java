package interview.qsns;


public class FibonacciSequence {
	

	private static int fibonacci_recursive(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
		}
	}
	
	
	private static int fibonacci_iterative (int n){
		
		if(n <= 1){
			return n;
		}
		int fibo = 1;
		int fiboPrev = 0;
		for(int i = 2; i <= n; i ++){
			int temp = fibo;
			fibo += fiboPrev;
			fiboPrev = temp;
		}
		return fibo;
	 
	}
	
	
	
	
	public static void main (String args[]){
		
		FibonacciSequence fb = new FibonacciSequence();
		//System.out.println(fb.fibonacci_iterative(5));
		System.out.println(fibonacci_recursive(12));
		System.out.println(fibonacci_iterative(12));

}}
