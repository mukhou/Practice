package goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class FindNthLargestNumberInArray {

	Map<Integer,Integer> map = null;
	public FindNthLargestNumberInArray(int[] arr){
		map = new HashMap<Integer, Integer>(arr.length);
		for(int i = 0; i < arr.length; i++){
			map.put(i, arr[i]);
		}
	}
	
	public int getIndexOfNthLargest(int n){
		return map.get(n);
	}
	
	public void reverseArray(){
		// exactly same logic as TimeEfficientStringReversal
		int length = map.size();
		int middleIndex = length / 2;
		for(int i = 0; i < middleIndex; i++){
			int temp1 = map.get(i);
			int temp2 = map.get(length - i);
			// swap ith and (length - i)th pos
			map.put(length - i, temp1);			
			map.put(i, temp2);
			map.put(i, temp1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
