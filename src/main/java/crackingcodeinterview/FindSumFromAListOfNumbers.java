/**
 * Write a function, that given a list of integers and an integer s,
 * prints any 2 numbers in the list that sum to s.
 */

package crackingcodeinterview;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSumFromAListOfNumbers {

    // Preferred approach
    //time complexity: 0(N log N) time to sort and 0(N) time to find the pairs.
    public static void findSumUsingHashMap(int[] arr, int sum) {
        Arrays.sort(arr);
        //define starting and ending index
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int s = arr[first] + arr[last];
            if (s == sum) {
                System.out.println(arr[first] + ", " + arr[last]);
                //keep moving on to find the next pair of numbers
                first++;
                last--;
            }else {
                if (s < sum) {
                    first++;
                } else {
                    last--;
                }
            }
        }
    }
        //THIS WORKS, ALTHOUGH BAD APPROACH
        public static void findSum (List <Integer> numList,int sum){
            for (int i = 0; i <= numList.size() - 1; i++) {
                for (int j = i + 1; j < numList.size(); j++) {
                    if ((numList.get(i) + numList.get(j)) == sum) {
                        System.out.println(numList.get(i) + ", " + numList.get(j));
                    }
                }
            }

        }


        public static void main (String[]args){
            List<Integer> myList = new ArrayList<Integer>();
            myList.add(1);
            myList.add(2);
            myList.add(3);
            myList.add(4);
            myList.add(5);
            myList.add(4);
            myList.add(3);

            int[] test = {9, 3, 6, 5, 5, 7, -1, 13, 14, -2, 12, 0};
            List l = Lists.newArrayList(9, 3, 6, 5, 5, 7, -1, 13, 14, -2, 12, 0);
            //findSum(l, 12);
            findSumUsingHashMap(test, 12);
            //findSum(myList, 6);


        }

    }
