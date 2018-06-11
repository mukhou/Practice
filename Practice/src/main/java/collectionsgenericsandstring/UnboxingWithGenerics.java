package collectionsgenericsandstring;

import java.util.*;
import java.util.ArrayList;

public class UnboxingWithGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(30);
		int x = (int) list.get(0);
		

	}

}
