package anything;

import java8.lambda.java8inaction.AllFunctionalInterfaces;

import java.util.function.Predicate;

public class Anything1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int c = 4;
		int[][] abc = new int[arr.length][c];
		abc[0][1] = 4;
		Predicate<Integer> p = i -> i % 2 == 0;

	}

}
