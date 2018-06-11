/**
 * Given an infinite sequence of integers which are repeated many times. 
 * wap to print "beep" if an integer appears ODDth time else print "no beep".
 *  example: input: a[] = { 1,4,2,4,3,2,4} 
 *  output: beep, beep, beep, no beep, beep, no beep, beep
 */

package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class BeepNoBeep {

	public static void printBeep(int[] arr){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i <= arr.length - 1; i++){
			if(!map.containsKey(arr[i])){
				// put for the first time
				map.put(arr[i], 1);
				System.out.print("beep ");				
			}else {
				// put and update its count
				map.put(arr[i], map.get(arr[i]) + 1);
				if(map.get(arr[i]) % 2 == 1){
					System.out.print("beep ");					
				}else{
					System.out.print("no beep ");					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 2, 4, 3, 2, 4};
		printBeep(arr);

	}

}
