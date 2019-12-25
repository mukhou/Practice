/* 
User: Urmi
Date: 12/22/2019 
Time: 11:45 AM
*/

/**
 * Given two arrays of integers, find a pair of values (one value from each array) that you
 * can swap to give the two arrays the same sum.
 */
package crackingcodeinterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//This problem reduces to finding a pair of values that have a particular difference.
//We can do this very quickly with a hash table. We just throw all the elements in B into a hash table. Then,
//iterate through A and look for the appropriate element in B.
//time complexity: 0(A+B)
public class SwapArray {

    public static int[] findSwapValues(int[] a, int[] b){
        int sumA = findSum(a);
        int sumB = findSum(b);

        Integer target = findTarget(sumA, sumB);

        if(target == null){
            return null;
        }
        //return findDifference(target, a, b);
        Set<Integer> set = createSet(b);
        for(int i : a){
            int diff = i - target;
            if(set.contains(diff)){
                int[] values = {i, diff};
                return values;
            }

        }
        return null;
    }



    private static Set<Integer> createSet(int[] b) {
        Set<Integer> set = new HashSet<>();
        for(int i : b){
            set.add(i);
        }
        return set;
    }

    private static Integer findTarget(int sumA, int sumB) {
        if((sumA - sumB) % 2 != 0) {
            return null;
        }else {
            return (sumA - sumB) / 2;
        }
    }

    private static int findSum(int[] arr) {
        return Arrays.stream(arr).reduce(0, Integer::sum);

    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 2, 2, 4};
        int[] array2 = {3, 3, 3, 6};
        int[] swaps = findSwapValues(array1, array2);
        if (swaps == null) {
            System.out.println("null");
        } else {
            System.out.println(swaps[0] + " " + swaps[1]);
        }
    }
}
