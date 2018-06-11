package bitmanipulation;

public class CheckBitPositionInANumber {

	/**
	 * Given a function, take a number and the bit position 
	 * and return true if that bit is set to 1 and false otherwise. 
	 * ALGORITHM:
	 * 1. right shift the given number by the number of bits = 
	 * the given position(the zeroth bit in the number is the rightmost bit).
	 * 2. do a bitwise AND with 1 .
	 * 
	 */
	public static boolean checkBit(int n, int pos){
		return(((n >> pos) & 1) == 1);
	}
	public static void main(String[] args) {
		System.out.println(checkBit(3, 1));
		//System.out.println(15 >> 0);
		

	}

}
