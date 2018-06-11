package conceptual;

public class TestIncrement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		if ((y == x++) | (x < ++y)) {
			System.out.println("x = " + x + " y = " + y);
		}

	}

}
