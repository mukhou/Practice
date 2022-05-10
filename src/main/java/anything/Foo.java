package anything;
class Foo {
	static int size = 7;
	static void changeIt(int size) {
	size = size + 200;
	System.out.println("size in changeIt is " + size);
	}
	public static void main (String [] args) {
	Foo f = new Foo();
	System.out.println("size = " + size);
	changeIt(size);
	System.out.println("size after changeIt is " + size);
	}
	}
