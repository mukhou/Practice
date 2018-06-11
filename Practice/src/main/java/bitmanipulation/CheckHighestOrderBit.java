package bitmanipulation;

public class CheckHighestOrderBit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte b = 15;
		int x = (b & 0Xff) >> 7;
		System.out.println(x);

	}

}
