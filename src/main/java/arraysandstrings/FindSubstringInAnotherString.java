package arraysandstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstringInAnotherString {

	private static List<String> findSubstrings(String str){
		List<String> subStringList = new ArrayList<String>();
		String sub = "";
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i; j++) {
				sub = str.substring(i, i + j);
				//System.out.println(sub);
				subStringList.add(sub);
			}

		}
		return subStringList;
	}
	
	public static void main(String[] args) {
		String str = "ab";
		String pattern = "abcd";		
		Pattern p ;
		Matcher m ;
		boolean b;
		// find method returns true if, and only if, a subsequence of the input sequence
		// matches this matcher's pattern
		/*List<String> list = findSubstrings(pattern);
		for(String s : list){
			p = Pattern.compile(pattern);
			m = p.matcher(s);
			b = m.find();
			//System.out.println(b);
		}*/
		
		System.out.println(pattern.contains(str));
		

	}

}
