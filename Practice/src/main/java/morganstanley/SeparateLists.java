package morganstanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeparateLists {

	
	
	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 6, 8, 10, 17, 34));
		List<Integer> bList = new ArrayList<Integer>(Arrays.asList(2, 8, 17, 33, 44, 66, 89, 100, 123));
		List<Integer> finalList = new ArrayList<Integer>();

		//int i=0;

		//In A; but not in B
		for (Integer value : aList){
			if (!bList.contains(value)) {
				finalList.add(value);
			}
			//i++;
		}

		//In B; but not in A
		//i=0;
		for (Integer value : bList){
			if (!aList.contains(value)) {
				finalList.add(value);
			}
			//i++;
		}

		//Final List
		Collections.sort(finalList);
		System.out.println(finalList + " " + finalList.size());
		


	}

}
