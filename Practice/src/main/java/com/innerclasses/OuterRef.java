package com.innerclasses;


public class OuterRef {

	
	private int x = 7;
	public void makeInner(){	
		MyInner inner = new MyInner();
		inner.seeOuter();
	}	
	class MyInner{
		public void seeOuter(){
			System.out.println("The variable is "+x);
			System.out.println("Inner ref is "+this);
			System.out.println("Outer ref is "+OuterRef.this);
		}
	}
	public static void main(String[] args) {
		
		MyOuter.MyInner inner = new MyOuter().new MyInner();
		inner.seeOuter();

	}

}
