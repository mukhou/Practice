package interview.qsns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Find_Max_Min_From_Array {
	
	//Alternative way:
	// find max value
	public int find_max(int[] arr){
		int max = arr[0];
		for(int i = 1; i < arr.length  ; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}
	
	public int maxValueFromList(List<Integer> list){
		int max = 0;
		for(int i : list){
			if(i > max){
				max = i;
			}
		}
		
		return max;
	}
	
	//find min value
	public int find_min(int[] arr){
		int min = arr[0];
		for(int i = 0; i <= arr.length-1; i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		return min;
	}

	
	public static void main(String[] args) {
		int[] arr = {61,-1,-2,-3,0,1,2,3,4, 19};
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(-1);
		list.add(-2);
		list.add(0);
		list.add(4);
		
		// Using jva.util.collections
		// Much cleaner code
		Arrays.sort(arr);
		//System.out.println("Minimum value is "+arr[0]);
		//System.out.println("Maximum value is "+ arr[arr.length -1]);
		
		Find_Max_Min_From_Array f = new Find_Max_Min_From_Array();
		System.out.println("Maximum value is "+ f.find_max(arr));
		//System.out.println("Maximum value is "+ f.maxValueFromList(list));
		System.out.println("Minimum value is "+f.find_min(arr));
		
		

	}

}
