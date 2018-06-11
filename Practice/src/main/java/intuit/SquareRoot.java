package intuit;

public class SquareRoot {
	
	public double root(double x, double y){
		double distX = x*x;
		double distY = y*y;
		double dist = Math.sqrt(distX+distY);
		
		return dist;
	}
	public static void main(String[] args) {
		SquareRoot sroot = new SquareRoot();
		System.out.println(sroot.root(4, 4));
		
		
		
		
	}

}
