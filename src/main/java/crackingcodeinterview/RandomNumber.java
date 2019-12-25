/* 
User: Urmi
Date: 12/23/2019 
Time: 11:33 AM
*/

/**
 * Implement a method rand7( ) given rand5( ).That is, given a method that
 * generates a random number between 0 and 4 (inclusive], write a method that generates a random
 * number between 0 and 6 (inclusive).
 */
package crackingcodeinterview;

public class RandomNumber {

    public static int rand7(){
        while (true){
            int num = 5 * rand5() + rand5();
            if(num < 21){
                return num % 7;
            }
        }
    }

    public static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }
}
