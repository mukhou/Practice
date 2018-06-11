package conceptual;

import java.util.ArrayList;
import java.util.List;

public class SumOfNNumbes {

	public static int findSum(List<Integer> list){
		int sum = 0;
		for(Integer i : list){
			sum = sum + i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		
		System.out.println(findSum(list));
		
		}

	}


