package com.general;

public class Frog {
	int frogCount = 0; // Declare and initialize

	// instance variable
	public Frog() {
		frogCount += 1; // Modify the value in the constructor
	}

	public static void main(String[] args) {
		new Frog();
		new Frog();
		new Frog();
		//COMPILER ERROR
		//System.out.println("Frog count is now " + frogCount);
	}

}
