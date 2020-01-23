/* 
User: Urmi
Date: 12/20/2019 
Time: 5:54 PM
*/

package crackingcodeinterview;

import java.util.Arrays;

//Given two arrays of integers, compute the pair of values (one value in each
//array) with the smallest (non-negative) difference. Return the difference.
public class SmallestDifference {

    //BRUTE FORCE APPROACH: time complexity: O(a X b), see below better way
    public static int diff(int[] a, int[] b){
        int minDiff = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                int diff = Math.abs(a[i] - b[j]);
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }

    //Consider the following two arrays:
    //A: {1, 2, 11, IS)
    //B: {4, 12, 19, 23, 127, 235}
    //Try the following approach:
    //1. Suppose a pointer a points to the beginning of A and a pointer b points to the beginning of B. The
    //current difference between a and b is 3, Store this as the min.
    //2. How can we (potentially) make this difference smaller? Well, the value at b is bigger than the value at a,
    //so moving b will only make the difference larger. Therefore, we want to move a.
    //3. Now a points to 2 and b (still) points to 4. This difference is 2, so we should update min. Move a, since
    //it is smaller.
    //4. Now a points to 11 and b points to 4. Move b.
    //5. Now a points to 11 and b points to 12. Update min to 1. Move b.
    //time complexity: O(a log a + b log b)
    public static int diff1(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        //initialize both index to 0
        int indexA = 0, indexB = 0;
        int minDiff = Integer.MAX_VALUE;
        while(indexA < a.length && indexB < b.length){
            int diff = Math.abs(a[indexA] - b[indexB]);
            minDiff = Math.min(minDiff, diff);
            //move pointers
            if(a[indexA] < b[indexB]){
                indexA++;
            }else {
                indexB++;
            }
        }

        return minDiff;

    }
}
