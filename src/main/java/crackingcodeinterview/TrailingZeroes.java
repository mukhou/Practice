/* 
User: Urmi
Date: 12/20/2019 
Time: 5:50 PM
*/

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
package crackingcodeinterview;

/**
 * Trailing zeros are contributed by pairs of 5 and 2, because 5*2 = 10.
 * To count the number of pairs, we just have to count the number of multiples of 5.
 * Note that while 5 contributes to one multiple of 10, 25 contributes two (because 25 = 5*5).
 */
public class TrailingZeroes {

    public static int trailingZeroes(int num){
        if(num < 0){
            return -1;
        }
        int count = 0;
        for(int i = 5; num / i > 0; i *= 5){
            count ++;
        }
        return count;
    }
}
