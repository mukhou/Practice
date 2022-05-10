package bitmanipulation;

public class UnSetNthBit {

	public static void unSetNthBitPos(int num, int n){
		int result;
		// do AND operation after left shifting 1 by n
		result = num & ~(1 << n);
		System.out.println(Integer.toBinaryString(result));
	}
	public static void main(String[] args) {
		// 01111111    (127 in binary)		
		// 11101111    (~(1<<4))
		unSetNthBitPos(127, 4);

	}

}
