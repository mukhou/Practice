package bitmanipulation;

public class CheckNthBitSet {
	
	// check http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
	// bit numeration starts with 0. So it's 0th bit, 1st bit, ..., 7th bit.
	public static void checkNthBit(int x, int n){		
		if ((x & (1 << n)) != 0) {
			 System.out.println("set");
			}
			else {
				System.out.println("un-set");
			}
	}
	public static void main(String[] args) {
		checkNthBit(122, 3);
		
		

	}

}
