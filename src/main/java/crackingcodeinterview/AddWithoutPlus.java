/* 
User: Urmi
Date: 12/24/2019 
Time: 10:47 AM
*/

package crackingcodeinterview;

/**
 * Add two numbers without using + operator
 */
public class AddWithoutPlus {

    public static int add(int a, int b){
        while(b != 0){
            //only sum value
            int sum = a ^ b;
            //only carry value
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;

    }
}
