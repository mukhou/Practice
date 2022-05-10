/**
 * CAPITALIQ interview question.
 * Find the string at the specified index
 */

package arraysandstrings;

public class FindStringFromAnArray {

	public static String findSring(String[] arr, int i){
		String str = "";
		for(String s : arr){
			str = arr[i];
		}
		System.out.println(str);
		return  str;
	}
	
	public static void main(String[] args) {
		String[] strArr = {"one", "nine", "eight", "four", "five"};
		findSring(strArr, 2);

	}

}
