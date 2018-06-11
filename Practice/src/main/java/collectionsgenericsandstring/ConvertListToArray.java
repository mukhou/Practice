package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.List;

public class ConvertListToArray {

	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<3; i++){
			list.add(i);
		}
		System.out.println(list);
		// converts and returns the Object array
		Object[] objArr = list.toArray();
		
		// Creates a new Integer array
		Integer[] intArr = new Integer[list.size()];
		intArr = list.toArray(intArr);
		intArr[1] = 5;		
		
		for(Integer x : intArr){
			System.out.println(x);
		}
		
		System.out.println(list);

	}

}
