/* 
User: Urmi
Date: 1/13/2020 
Time: 5:39 PM
*/

/**
 * Given two integers, the task is to find the hamming distance between two integers.
 * Hamming Distance between two integers is the number of bits which are different at same position in both numbers.
 */
package byteBybyte;

public class HammingDistance {
    //Calculate the XOR of two numbers.
    //Count the number of set bits.
    static int hammingDistance(int n1, int n2){
        int x = n1 ^ n2;
        int setBits = 0;

        while (x > 0)
        {
            setBits += x & 1;
            x >>= 1;
        }

        return setBits;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n1 = 9, n2 = 14;
        System.out.println(hammingDistance(n1, n2));
    }
}


