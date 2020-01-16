package byteBybyte;


import java.util.Arrays;

/**
 * Runtime O(2 ^ n)
 */
public class FibonacciSequence {

	private static int fibo_dyn_top_down_recurse(int n){
		int lookup[] = new int[n + 1];

		Arrays.fill(lookup, -1);

		if(lookup[n] == -1){
			if(n <= 1){
				lookup[n] = n;
			}else {
				lookup[n] = fibo_dyn_top_down_recurse(n - 1) + fibo_dyn_top_down_recurse(n - 2);
			}
		}
		return lookup[n];
	}

	private static int fibo_dyn_bottom_up_iterative(int n){
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= n; i ++){
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(Arrays.toString(arr));
		//we need to add the last and second last as in this method, we are not traversing till "n",
		// but "n - 1"(due to array index overflowing), unlike in the other two approaches.
		return arr[n];
	}


	private static int fibonacci_recursive(int n) {
		//same condition in iterative mode
		if (n <= 1) {
			return n;
		} else {
			return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
		}
	}
	
	
	private static int fibonacci_iterative (int n){

		//same as recursive
		if(n <= 1){
			return n;
		}
		int fibo = 1;
		int fiboPrev = 0;
		for(int i = 2; i <= n; i ++){
			int temp = fibo;//store the value of fibo
			fibo += fiboPrev;
			fiboPrev = temp;
		}
		return fibo;
	 
	}



	public static void main (String args[]){
		
		FibonacciSequence fb = new FibonacciSequence();
		//System.out.println(fb.fibonacci_iterative(5));
		System.out.println(fibonacci_recursive(7));
		System.out.println(fibonacci_iterative(7));
		System.out.println(fibo_dyn_bottom_up_iterative(7));

}}
