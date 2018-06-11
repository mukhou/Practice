package goldmansachs;

public class StringTest {
	public static void m1(String arg1) {
		arg1 = "Am I going to disappear?";
	}

	public static void main(String[] args) {
		StringTest test = new StringTest();
		String iAmOfAnArgumentativeNature = "I am born new";
		m1(iAmOfAnArgumentativeNature);
		System.out.print(iAmOfAnArgumentativeNature);
	}
}
