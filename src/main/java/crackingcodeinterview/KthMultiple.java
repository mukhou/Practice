/* 
User: Urmi
Date: 12/25/2019 
Time: 11:59 AM
*/

/**
 * Design an algorithm to find the kth number such that the only prime factors are 3, S,
 * and 7. Note that 3,5, and 7 do not have to be factors, but it should not have any other prime factors.
 * For example, the first several multiples would be (in order) 1,3,5,7,9,15,21.
 */
package crackingcodeinterview;

import java.util.LinkedList;
import java.util.Queue;

//see detailed explanation from CTCI pg 561
//time complexity O(k^2)
public class KthMultiple {

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.println(i + " : " + getKthMagicNumber(i));
        }
    }

    private static int getKthMagicNumber(int k) {
        if(k < 0){
            return 0;
        }

        //initialize val to 1
        int val = 1;
        Queue<Integer> queue = new LinkedList<>();
        addToProducts(queue, 1);
        for(int i = 0; i < k; i ++){
            //the minimum number from 0 - k which has 3/5/7 as factors
            val = removeMin(queue);
            addToProducts(queue, val);
        }
        return val;
    }

    private static int removeMin(Queue<Integer> queue) {
        int min = queue.peek();
        for(Integer v : queue){
            if(v < min){
                min = v;
            }
        }
        while (queue.contains(min)) {
            queue.remove(min);
        }
        return min;
    }

    private static void addToProducts(Queue<Integer> queue, int v) {
        queue.add(3 * v);
        queue.add(5 * v);
        queue.add(7 * v);
    }
}
