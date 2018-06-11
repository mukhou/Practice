package test;

public class TestEquality {

	
	public static void main(String[] args) {
		TestEquality a1 = new TestEquality();
		TestEquality a2 = new TestEquality();
		TestEquality a3 = a1;	
		
		
		// returns false
		System.out.println(a1==a2);
		
		// returns false
		System.out.println(a1.equals(a2));
		
		// returns true
		System.out.println(a1==a3);
		
		// returns true
		System.out.println(a1.equals(a3));

	}

}
