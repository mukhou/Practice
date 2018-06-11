package conceptual;

import java.lang.reflect.Method;
/**
 * Java Reflection makes it possible to inspect classes, interfaces, 
 * fields and methods at runtime, without knowing the names of the classes,
 * methods etc. at compile time. 
 * It is also possible to instantiate new objects, invoke methods and
 * get/set field values using reflection.
 * 
 *
 */

class AppTest{
	 
	private int counter;
 
	public void printIt(){
		System.out.println("printIt() no param");
	}
 
	public void printItString(String temp){
		System.out.println("printIt() with param String : " + temp);
	}
 
	public void printItInt(int temp){
		System.out.println("printIt() with param int : " + temp);
	}
 
	public void setCounter(int counter){
		this.counter = counter;
		System.out.println("setCounter() set counter to : " + counter);
	}
 
	public void printCounter(){
		System.out.println("printCounter() : " + this.counter);
	}
	
	public static void show(){
		System.out.println("static");
	}
}

public class TestReflectionInJava {
	public static void main(String[] args){
		Class noparams[] = {};
		try{
			Class c = Class.forName("conceptual.AppTest");
			Object o = c.newInstance();
			// invoking static method
			Method m1 = c.getDeclaredMethod("show", noparams);
			m1.invoke(c, null);
			
			//invoke insance method
			Method m = c.getDeclaredMethod("printIt", noparams);
			m.invoke(o, null);
			
		}catch(Exception e){
			
		}
	}
}
