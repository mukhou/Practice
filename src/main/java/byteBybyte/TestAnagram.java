package byteBybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAnagram {


    //PREFERRED APPROACH - use StringBuilder
    public static boolean checkAnagram1(String first, String second) {
        char[] firstChars = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
        for (char ch : firstChars) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }
        System.out.println(sbSecond.length() == 0 ? true : false);
        return sbSecond.length() == 0 ? true : false;
    }
	
	

    //too many data structures
	public static void CheckAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return ;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		
		List<Character> list = new ArrayList<>();
		for (char c : arr1)
			list.add(c);

		// we are removing an object from the list
		// so we need to create an Integer object
		// list.remove(Object o)
		for (Character j : arr2)
			list.remove(j);
		

		if (list.isEmpty())
			System.out.println("same Array");

		else
			System.out.println("Not same");
    }
	
	public static void main(String[] args) {
		
		//CheckAnagram("basab", "absab");
        checkAnagram1("basab", "sabab");

	}

}
