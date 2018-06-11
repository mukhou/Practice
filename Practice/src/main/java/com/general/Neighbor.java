package com.general;

public class Neighbor 
 {
	Child c = new Child();
	public void useIt(){
		// compiler error
		//System.out.println(c.x);
	}
}
