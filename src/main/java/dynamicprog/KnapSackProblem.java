/* 
User: Urmi
Date: 1/22/2020 
Time: 10:37 AM
*/

package dynamicprog;

//watch video: https://www.youtube.com/watch?v=xCbYmUPvc2Q&t=862s
//https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/

/**Max capacity = 50
 * [item1[$60, 50), Item2[$50, 3], Item3[$70, 4]
 *
 *                   0  1  2  3   4  5  (capacity)
 *  (Items)          ---------------------
 *  Item[val=0,wt=0]|0  0  0  0   0  0
 * Item1[val, wt=5] |0  0  0  0   0  60
 * Item2[val, wt=3] |0  0  0  50  50 60
 * Item3[val, wt=4] |0
 *
 */
public class KnapSackProblem {

    // Returns the maximum value that can be put in a knapsack of capacity W
    private static int knapSack(int totalCapacity, int wts[], int values[]) {
        //like coins problem
        int[][] table = new int[values.length + 1][totalCapacity + 1];
        //amount is 0 and value is 0: total value
        table[0][0] = 0;//maximum profit for 0 capacity is 0
        for (int i = 1; i <= values.length; i++) {
            int curr_value = values[i - 1];
            int curr_wt = wts[i - 1];
            for (int j = 1; j <= totalCapacity; j++) {
                if (curr_wt > j) {//w is current capacity
                    table[i][j] = table[i - 1][j];
                } else {
                    //go to previous row and subtract current weight from current capacity
                    table[i][j] = Math.max(table[i - 1][j], curr_value + table[i - 1][j - curr_wt]);
                }
            }
        }
        return table[values.length][totalCapacity];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val));
    }

}
