package com.general;
import com.cts.test.Parent;

class Parent1{
	protected int p1 = 5;
}

public class Child extends Parent{
	public void testProtected(){
		Parent p = new Parent();
		Child c = new Child();
		Parent1 p2 = new Parent1();
		// Error
		//p.x = 10;
		// OK, through inheritance
		c.x = 5;
		// Both OK, in same package
		p2.p1 = 4;
		//c.p1 = 2;
		
	}
	public void show(){
		System.out.println("Child class");
	}
	public static void main(String[] args){
		Parent p = new Parent();
		Child c = (Child) p;
		c.show();
	}
}
