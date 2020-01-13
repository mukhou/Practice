/* 
User: Urmi
Date: 12/24/2019 
Time: 1:20 PM
*/

/**
 * Given an array filled with letters and numbers, find the longest subarray with
 * an equal number of letters and numbers.
 */
//CTCI pg 549, Q 17.5
package crackingcodeinterview;

public class LettersAndNumbers {

    public static char[] findLongestSubarray(char[] array){
        for(int len = array.length; len > 0; len --){
            //IMP: i goes upto array.length - len
            for(int i = 0; i <= array.length - len; i++){
                if(hasEqualLettersNumbers(array, i, i + len - 1)){
                    return extractSubarray(array, i, i + len - 1);
                }
            }
        }
        return null;
    }

    private static boolean hasEqualLettersNumbers(char[] array, int start, int end) {
        int counter = 0;
        for(int i = start; i <= end; i++){
            if(Character.isLetter(array[i])){
                counter ++;
            }else {
                counter --;
            }
        }
        return counter == 0;
    }


    private static char[] extractSubarray(char[] arr, int start, int end) {
        if (start > end) return null;
        char[] sub = new char[end - start + 1];
        for(int i = start; i <= end; i++){
            sub[i - start] = arr[i];
        }
        return sub;
    }


    public static void main(String[] args) {
        char b = '1';
        char a = 'a';
        char[] array = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        char[] max = findLongestSubarray(array);
        System.out.println(max.length);
        for (int i = 0; i < max.length; i++) {
            System.out.print(max[i] + " ");
        }
        System.out.println("\nIs Valid? " + hasEqualLettersNumbers(max, 0, max.length - 1));
    }
}
