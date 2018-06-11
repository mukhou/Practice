package com.innerclasses;

public class MyOuter2 {
	
	private String x = "Outer2";
	private static int a = 3;
	void doStuff(){
		 class MyInner{
			public void seeOuter(){
				System.out.println("Outer is " + x);
			}
		}
		
		// After Inner class definition ends, it can be instantiated
		MyInner inner = new MyInner();
		x = "inner";
		a = 2;
		inner.seeOuter();
	}

	static void doStuffStatic(){
		class MyInner{
			public void seeOuter(){
				//System.out.println("Outer is " + x); -- ERROR
			}
		}

		// After Inner class definition ends, it can be instantiated
		MyInner inner = new MyInner();
        /**
         * Remember that a local class declared in a static method has access
         to only static members of the enclosing class, since there is no associated instance of the
         enclosing class. If you're in a static method there is no this, so an inner class in a static
         method is subject to the same restrictions as the static method. In other words, no access
         to instance variables. So the below line DOES NOT COMPILE
         */
		//x = "inner"; 
		a = 2;
		inner.seeOuter();
	}
	void show(){
		a = 0;
	}

	


}
