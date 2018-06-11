package com.starandnumbertriangles;

public class NumberReverse {

	public static void main(String[] args) {

		Integer n, m;
		String r, s = "";

		n = 523;
		r = n.toString();

		for (int i = 1; i <= r.length(); i++) {
			m = n % 10;
			n = n / 10;

			s = s + m;

		}
		System.out.println("The reverse is " + s);

	}

}
