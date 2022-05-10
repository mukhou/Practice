package bitmanipulation;

public class ToggleNthBit {

	public static void toggleNthBitPos(int num, int n){
		int result;
		
		result = num ^ ( 1<< n);
		System.out.println(Integer.toBinaryString(result));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
