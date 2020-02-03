package byteBybyte;


import java.util.Arrays;

/**
 * Runtime O(2 ^ n)
 */
public class FibonacciSequence {

	private static int fibo_dyn_top_down_recurse(int n){
		int lookup[] = new int[n + 1];

		if(n <= 1){
		    return n;
        }
        if(lookup[n] != 0){
		    return lookup[n];
        }else {
		    //compute subproblems
		    lookup[n] = fibo_dyn_top_down_recurse(n - 1) + fibo_dyn_top_down_recurse((n - 2));
		    return lookup[n];
        }
	}

	private static int fibo_dyn_bottom_up_iterative(int n){
		int[] lookup = new int[n + 1];
        lookup[0] = 0;
        lookup[1] = 1;
		for(int i = 2; i <= n; i ++){
            lookup[i] = lookup[i - 1] + lookup[i - 2];
		}
		System.out.println(Arrays.toString(lookup));
		return lookup[n];
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
		/*System.out.println(fibonacci_recursive(7));
		System.out.println(fibonacci_iterative(7));*/
		System.out.println(fibo_dyn_bottom_up_iterative(7));
        System.out.println(fibo_dyn_top_down_recurse(7));

}}
