/**
 * Write a program to swap odd and even bits of a 32-bit
 *  unsigned integer with as few instructions as possible.
 *  Given an unsigned integer, swap all odd bits with even bits. 
 *  For example, if the given number is 23 (00010111), it should be converted to 43 (00101011).
 *  Every even position bit is swapped with adjacent bit on right side , 
 *  and every odd position bit is swapped with adjacent on left side.
 */

package bitmanipulation;

public class SwapEvenOddBits {

	/**
	 * ALGORITHM:
	 * 0xAAAAAAAA is a hexadecimal number 
	 * its binary representation would be 
	 * 1010 1010 1010 1010 1010 1010 1010 1010
	 * (each A = 1010 in binary, so a total of 8 such bits)
	 * when you do a bit wise AND of this with any 32 bit number,
	 * it results in all the EVEN number bits masked to 0.
	 * Now u RIGHT shift the result by 1 => moving the bits in even number position 
	 * to odd position.
	 *  
	 * Similarly
	 * 0x55555555 and its binary representation would be
	 *(0101 0101 0101 0101 0101 0101 0101 0101)
	 * when you do a bit wise AND with any 32 bit number,
	 * it results in all the ODD number bits masked to 0.
	 * Now you LEFT shift by 1 => moving the odd number position to even number position .
	 * 
	 */
	public static void main(String[] args) {
		int num = 23;

		int res1 = (num & 0xAAAAAAAA) ; // clear every even bit
		res1 >>= 1; // shift right 
		
		int res2 = num & 0x55555555; // clear every odd bit
		res2 <<= 1; // shift left
		
		int res = res1 | res2;
		
		System.out.println(Integer.toBinaryString(num));
		System.out.println( Integer.toBinaryString(res) );

	}

}
