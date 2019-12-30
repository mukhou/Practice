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

    public static int add(int x, int y){
        while(y != 0){
            //only carry value
            // carry now contains common
            // set bits of x and y
            int carry = (x & y);

            //only sum value
            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;
            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;

    }
}
