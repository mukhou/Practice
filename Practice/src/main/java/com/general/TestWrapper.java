package com.general;

public class TestWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i = 1000;
		Integer j = 1000;
		// returns false
		System.out.println(i == j);
		System.out.println(i.equals(j));
		
		Integer a = 10;
		Integer b = 10;
		//returns true
		System.out.println(a == b);
		System.out.println(a.equals(b));

	}

}
