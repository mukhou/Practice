/**
 * Write a function, that given a list of integers and an integer s,
 * prints any 2 numbers in the list that sum to s.
 */

package algorithms;

import java.util.*;

public class FindSumFromAListOfNumbers {
	
	// Preferred approach
	public static void findSumUsingHashMap(List<Integer> numList, int sum){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i <= numList.size() - 1; i++){
			if(map.containsKey(numList.get(i))){
				if(map.containsKey(sum - numList.get(i))){
					System.out.println(numList.get(i) + "" + (sum - numList.get(i)));
				}
			}else{
				// add the number
				map.put(numList.get(i), 1);	
				// check if the difference number is the same as the number
				// if it is, then don't print them
				if(map.containsKey(sum - numList.get(i)) && (sum - numList.get(i) != numList.get(i))){
					System.out.println(numList.get(i) + "" + (sum - numList.get(i)));
				}
			}
		}
		
	}

	public static void findSum(List<Integer> numList, int sum){
		Collections.sort(numList);
		
		for(int i = 0; i <= numList.size() - 1; i++){
			for(int j = numList.size() - 1; j >= 0; j--){
				if((numList.get(i) + numList.get(j)) == sum){
					System.out.println(numList.get(i) + "" + numList.get(j));
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);		
		myList.add(4);
		myList.add(5);
		myList.add(4);
		myList.add(3);
		findSumUsingHashMap(myList, 6);
		//findSum(myList, 6);
		
		
		

	}

}
