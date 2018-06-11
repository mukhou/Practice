package com.innerclasses;

public class Popcorn {
	public void pop(){
		System.out.println("popcorn");
	}

}

class Food{
	// This line creates an anonymous class which is a SUBCLASS OF POPCORN
	// A SUPER CLASS REFERENCE VARIABLE is used to refer to the subclass object
	// so you can only call methods on an anonymous class that are declared 
	// in the reference variable type
	// p refers to an instance of an anonymous class that is a subclass of Popcorn 
	// p is just like any other member of the Food class
	Popcorn p = new Popcorn(){
		public void sizzle(){
			System.out.println("Using the anonymous inner class");
		}
		public void pop(){
			System.out.println("Overriding pop in an anonymous class");
		}
	};
	public void popIt(){
		p.pop();
		// compiler error
		//p.sizzle();
	}
}


