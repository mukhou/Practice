/* 
User: Urmi
Date: 12/24/2019 
Time: 2:04 PM
*/

/**
 * Write a method to count the number of 2s between 0 and n.
 */
package crackingcodeinterview;

public class NumberOfTwos {

    //brute force algo
    public static int countOfTwos(int n){
        int count = 0;
        for(int i = 2; i <= n; i ++){
            count += numBerOf2(i);
        }
        return count;
    }

    private static int numBerOf2(int n) {
        int count = 0;
        while(n > 0){
            if(n % 10 == 2){
                count ++;
            }
            n/= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            int v = countOfTwos(i);
            System.out.println("Between 0 and " + i + ": " + v);
        }
    }
}
