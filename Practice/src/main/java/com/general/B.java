package com.general;

class A {
}

public class B extends A {
	public static void main(String[] args) {
		A myA = new B();
		m2(myA);	
		
		/*String s = "abcdefghi";
		System.out.println(s.substring(2, 5));*/
		
	}

	public static void m2(A a) {
		if (a instanceof B)
			((B) a).doBstuff(); // downcasting an A reference to a B reference

	}

	public static void doBstuff() {
		System.out.println("'a' refers to a B");
	}

}
