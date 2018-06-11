package com.general;

public class TestStatic {

	static int count = 0;
	int x = 0;
	
	TestStatic(){
		count += 1;
		x += 1;
	}
	// cannot access non static members from static methods
	public static void show(){
		//x = 2;
		TestStatic static1 = new TestStatic();
		count++;
	}
	
	public static void main(String[] args) {
		 TestStatic t = new TestStatic();
		 TestStatic t1 = new TestStatic();
		 TestStatic t2 = new TestStatic();
		 System.out.println("count is " + TestStatic.count);
		 //OR
		//show();
		 //System.out.println("count is " + TestStatic.count);

	}

}
