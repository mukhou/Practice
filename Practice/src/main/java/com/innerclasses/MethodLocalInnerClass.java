package com.innerclasses;

public class MethodLocalInnerClass {
	private String x = "Outer";
	void doStuff(){
		class MyMethodInner{
			public void seeOuter(){
				System.out.println("Outer is " + x);
			}
		}
		
		MyMethodInner in = new MyMethodInner();
		in.seeOuter();
	}

}

