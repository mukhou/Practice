package goldmansachs;

import java.util.ArrayList;
import java.util.List;

// two arrays are similar iff they contain the same number of elements
// equal number of times
public class CheckIf2ArraysAreSimilar {

	public static void compareArrays(int[] arr1, int[] arr2) {
		
		
		List<Integer> list = new ArrayList<Integer>();
		if (arr1.length != arr2.length) {
			System.out.println("Not same");
			return;
		}
		for (int i : arr1)
			list.add(Integer.valueOf(i));

		// we are removing an object from the list
		// so we need to create an Integer object
		// list.remove(Object o)
		for (int j : arr2)			
			list.remove(Integer.valueOf(j));
		

		if (list.isEmpty())
			System.out.println("same Array");

		else
			System.out.println("Not same");
	}

	public static void main(String[] args) {
        String s = "00:05:06";
        String[] tineArr = s.split(":");
        Integer hour = Integer.valueOf(tineArr[0]);
        if(hour.equals(0)){
            System.out.println("Zero");
        }
		/*int[] arr1 = { 3, 5, 2, 5, 2};
		int[] arr2 = {2, 3, 5, 5, 2};	
		//compareArrays(arr1, arr2);
        int a = 1 << 2;
        *//*int b = a++;
        int c = ++b;*//*
        System.out.println(a );*/

		
		
	}

}
