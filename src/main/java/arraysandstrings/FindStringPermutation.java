package arraysandstrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindStringPermutation {

	public static void findPermutation(String str, String inputPattern){		
		StringBuilder sb = new StringBuilder(inputPattern);
		sb.reverse();
		// Pattern to find
		Pattern p = Pattern.compile(sb.toString());
		Matcher m = p.matcher("abaaaba");
		boolean b = false;
		System.out.println(m.find());
		
	}
	public static void main(String[] args) {
		findPermutation("abcdefg", "ba");
		

	}

}
