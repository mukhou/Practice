package test;

public class MyOuter {

	private int x = 7;
	static int y;
	class MyInner{
		public void seeOuter(){
			System.out.println(x);
			y = 0;
		}
	}
	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		MyOuter.MyInner mi  = mo.new MyInner();
		mi.seeOuter();
		
		// alternatively
		MyOuter.MyInner in = new MyOuter().new MyInner();
		in.seeOuter();

	}

}
