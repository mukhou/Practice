package com.general;

public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		for(int[] a : arr){
			for(int x : a){
				System.out.println(x);
			}
		}

	}

}
