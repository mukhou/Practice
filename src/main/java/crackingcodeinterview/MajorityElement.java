/* 
User: Urmi
Date: 12/25/2019 
Time: 2:55 PM
*/

/**
 * A majority element is an element that makes up more than half of the items in
 * an array. Given a positive integers array, find the majority element. If there is no majority element,
 * return -1. Do this in 0(N) time and 0 ( 1 ) space.
 * Input: 1 2 5 9 5 9 5 5 5
 * Output: 5
 */
package crackingcodeinterview;

//SEE EXPLANATION FROM CTCI, PG 567
//algorithm can now be run in two passes: one to find the possible majority element and another to validate
//it.
//Also HighestOccurringArrayElement
public class MajorityElement {

    private static int findMajorityElement(int[] array) {
        int element = getElement(array);
        return validate(array, element) ? element : -1;
    }

    //very simple algo to find the most occurred element in an array
    private static int getElement(int[] array) {
        int count = 0, majority = 0;
        for(int n : array){
            if(count == 0){
                //Initialize majority
                majority = n;
            }
            if(n == majority){
                count ++;
            }else {
                count --;
            }
        }
        //System.out.println(majority);
        return majority;
    }

    private static boolean validate(int[] array, int element) {
        int count = 0;
        for(int n : array){
            if(n == element){
                count ++;
            }
        }
        return count >= array.length / 2;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 20, 2, 20, 2, 20, 2, 2, 20};//{0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(array.length);
        System.out.println(findMajorityElement(array));
    }



}
