/**
 * Given a sorted array of strings which is interspersed with empty strings,
 *  write a method to find the location of a given string.
 */

package arraysandstrings;

public class FindAStringInAStringArrayWithEmptyStrings {

	public int search(String[] strArr, String str){
		if(strArr == null || str == null) return -1;
		if(str == ""){
			for(int i = 0; i < strArr.length; i++){
				if(strArr[i] == "")
					return i;
			}
			return -1;
		}
		// just like Merge sort(A, p, q, r)
		return Search(strArr, str, 0, strArr.length - 1);
	}
	
	public int Search(String[] strArr, String str, int start, int end) {
		if(end < start) return -1;
		// while loop
		while(start <= end){
			// ensure there is something at the end
			while(start <= end && strArr[end] == ""){
				-- end;
			}		
			
			int mid = (end + start) / 2;
			while(strArr[mid] == ""){
				++ mid;
			}
			int result = strArr[mid].compareTo(str);
			if(result == 0) return mid;
			// Iterative way
			if(result < 0){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
