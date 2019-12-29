/* 
User: Urmi
Date: 12/27/2019 
Time: 2:53 PM
*/

package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//hackerrank.com/challenges/sock-merchant/problem
public class MatchingSocksPair {

    public static void main(String[] args){
        System.out.println(sockMerchant1(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
        System.out.println(sockMerchant(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    //PREFERRED APPRAOCH
    //Explanation:
    // 1. since the colors are two digit integers, create an array(colors) of length 101: 0 -> 100
    // 2. iterate through the array and keep increasing the position in the colors array which matches
    // with the array element. For ex: 10 : 1, 20 :1, 20 : 2 etc
    //3. in the end the colors array will have the count of all those positions(10, 20 etc) which were
    // elements in the array. Now iterate colors array one more time(using Stream), divide each element by 2
    // and find sum of all those divisions
    static int sockMerchant1( int[] arr) {
        int[] colors = new int[101];
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];
            colors[c]++;
        }
        return Arrays.stream(colors).map(count -> count / 2).sum();
    }

    static int sockMerchant( int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr){
            map.merge(i, 1, Integer::sum);
        }
        System.out.println(map);
        int count = 0;
        for(Integer i : map.values()){
            count += i / 2;
        }
        return count;
    }
}
