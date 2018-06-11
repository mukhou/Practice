package com.general;

public class TestSporty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sporty[] sp = new Sporty[3];
		sp[0] = new Ferari();
		// COMPILER ERROR
		//sp[1] = new Frog();

	}

}
