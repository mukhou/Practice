package com.innerclasses;

public class MyOuter {
	
	private int x = 7;
	public void makeInner(){
		// Instantiate the inner class from within the Outer Class
		MyInner inner = new MyInner();
		inner.seeOuter();
		
	}
	
	
	class MyInner{
		private int y = 4;
		public void seeOuter(){
			System.out.println("The variable x is "+x);
			System.out.println("Inner class ref is " + this);
			System.out.println("Outer class ref is" + MyOuter.this);
		}
		
	}
	
	public static void main(String args[]){
		// Instantiate the inner class outside the Outer class
		MyInner inn = new MyOuter().new MyInner();
		inn.seeOuter();
		System.out.println(inn.y);
		// OR
		MyOuter mo  = new MyOuter();
		MyInner myinn = mo.new MyInner();
	}

}
