package bitmanipulation;

public class FindIfANumberIsPowerOf2 {

	public static boolean findPow(int n) {
		int r;
		boolean b = false;
		while (n > 1) {
			r = n % 2;
			n = n >> 1;
			if (r  == 0) {
				b = true;
			} else {
				b = false;
				break;
			}
		}
		return b;
	}

	public static void main(String[] args) {
		boolean b = findPow(6);
		System.out.println(b);

	}

}
