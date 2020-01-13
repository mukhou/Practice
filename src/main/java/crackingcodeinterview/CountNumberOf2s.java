/* 
User: Urmi
Date: 1/12/2020 
Time: 4:41 PM
*/

/**
 * Write a method to count the number of 2s between 0 and n.
 */
package crackingcodeinterview;

//CTCI pg 550
public class CountNumberOf2s {
    static int number0f2sInRange(int n){
        int count = 0;
        for(int i = 2; i <= n; i++){
            count += count2s(i);
        }
        return count;
    }

    static private int count2s(int n) {
        int count = 0;
        while(n > 0){
            if(n % 10 == 2){
                count ++;
            }
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(number0f2sInRange(20));
        for (int i = 0; i <= 20; i++) {
            int v = number0f2sInRange(i);
            System.out.println("Between 0 and " + i + ": " + v);
        }
    }
}
