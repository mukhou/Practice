package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArrayToList {
	//convert int array to List<Integer>
	public List<Integer> convertIntArrayToList(int[] arr){
		List<Integer> list = new ArrayList<Integer>(arr.length);
		for(int i = 0; i < arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}

	
	public static void main(String[] args) {
		
		// convert String array to List<String>
		String []arr = {"one", "two", "three", "four"};		
		List<String> list = Arrays.asList(arr);
		//System.out.println("The list size is " + list.size());
		//System.out.println("The item at index 2 is " +list.get(2));
		
		// IMPORTANT: changes made to the list
		// "write through" to the array
		//list.set(3, "nine");
		//arr[1] = "seven";
		//System.out.println("*************"+arr[3]);
		for(String s : arr){
			System.out.println(s);
		}
		list.set(3, "nine");
		System.out.println(list);
		for(String s : arr){
			System.out.println(s);
		}
		// IMPORTANT: CANNOT ADD ANYTHING TO THE CONVERTED LIST, SINCE
		// IT WAS CONVERTED FROM AN ARRAY
		// throws java.lang.UnsupportedOperationException
		list.add("abc");
		System.out.println(list);
		
		
		

	}

}
