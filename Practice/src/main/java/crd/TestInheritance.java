package crd;

class ABC{
    private ABC(){

    }
}
// Since ABC has private constructor, so BCD cannot inherit ABC
/*class BCD extends ABC{


}*/

class A {
	public String doIt() {
		return "A";
	}
}

class B extends A {
	public String doIt() {
		return "B";
	}
}

class C {
	public static String doIt() {
		return "C";
	}
}

class D extends C {
	public static String doIt() {
		return "D";
	}
}

public class TestInheritance {
	public static void main(String args[]) {
		A b = new B();
		String s1 = b.doIt();
		System.out.println(s1);
		C d = new D();
		String s2 = d.doIt();
		System.out.println(s2);
		/*System.out.println(s2);*/

	}

}
