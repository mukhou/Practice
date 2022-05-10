package collectionsandstring;

import java.util.Arrays;

public class CopyOfExample {

	
	public static void main(String[] args) {
		
		String[] strArr = {"a", "b", "c", "d", "e"};
		String[] copyArr = Arrays.copyOf(strArr, 2);
		System.out.println(Arrays.toString(copyArr));

	}

}
