package goldmansachs;

public class TestAcess {

	
	public static void main(String[] args) {
		B b = new B();
		b.showX();

	}

}

class A{
	private int x = 4;
	public void showX(){
		System.out.println(x);
	}
}

class B extends A{
	
}

