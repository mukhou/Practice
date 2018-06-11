package conceptual;

public class TestEnum {

	enum Color {
		RED, BLUE
	}

	// both the == and the equals comparison work for enums
	public static void main(String[] args) {
		Color c1 = Color.RED;
		Color c2 = Color.RED;
		if (c1 == c2) {
			System.out.println("==");
		}
		if (c1.equals(c2)) {
			System.out.println("dot equals");

		}
		/*final int x = 1;
		final int y;
		y = 2;
		//x = 1;
		switch (x) {
		case x:
			
			break;
		case y:
			break;

		default:
			break;
		}
*/
	}
}
