package com.general;

public class TestConstructor1 {

	public TestConstructor1(){
		super();
		show();
	}
	
	private int x = 10;
	public void show(){
		System.out.println("Value of x is " + x);
	}
	public static void main(String[] args) {
		TestConstructor1 constructor = new TestConstructor1();

	}

}
