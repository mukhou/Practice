package bitmanipulation;

public class SetNthBit {

	// check: http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
	public static void setNthBitPos(int num, int n){
		int result;
		// do OR operation after left shifting 1 by n
		result = num | (1 << n);
		System.out.println(Integer.toBinaryString(result));
	}
	public static void main(String[] args) {
		// 01111000    (120 in binary)
		// 00000100    (1<<2)
		setNthBitPos(120, 2);

	}

}
