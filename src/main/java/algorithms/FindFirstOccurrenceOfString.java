package algorithms;

import java.util.HashSet;
import java.util.Set;

public class FindFirstOccurrenceOfString {

	public static void findFirst(String[] strArr){
		Set<String> set = new HashSet<String>();
		for(String s : strArr){
			if(!set.contains(s)){
				set.add(s);
			}else{
				System.out.println(s);
			}
		}
	}
	public static void main(String[] args) {
		String[] arr = {"urmi", "rini", "jhini", "urmi"};
		findFirst(arr);

	}

}
