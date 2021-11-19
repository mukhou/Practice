package goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class TestOverloading {

  public void m(Object o)
    {
      System.out.println("m with Object called");
    }

    public void m(String n)
    {
       System.out.println("m with Number called");
    }
    public static void main(String[] args)
    {
    	TestOverloading a = new TestOverloading();
       // why will m(Number) be called?
       a.m(null);
    }
}
class A1{
	List<String> doSomething(){
		return null;
		
	}
}

class B1 extends A1{
	ArrayList<String> doSomething(){
		return null;
		
	}
}

class C1 extends A1{
	// compile error
	/*String doSomething(){
		
	}*/
}

