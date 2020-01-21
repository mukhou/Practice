/* 
User: Urmi
Date: 1/17/2020 
Time: 6:54 PM
*/

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path
 * to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n)
 * is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e.,
 * from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
 */
package dynamicprog;

import java.util.Arrays;

//https://www.geeksforgeeks.org/min-cost-path-dp-6/
public class MinimumCostPath {

    //(m, n) is zero index based
    private static int minCostPath(int[][]matrix, int m, int n){

        int[][] costTable = new int[m + 1][n + 1];
        costTable[0][0] = matrix[0][0];
         //Initialize first column of total cost(tc) array
        for(int i = 1; i <= m; i++){
            //making use of previous subproblems
            costTable[i][0] = matrix[i][0] + costTable[i - 1][0];
        }
         //Initialize first row of tc array
        for(int j = 1; j <= n; j++){
            //making use of previous subproblems
            costTable[0][j] = matrix[0][j] + costTable[0][j - 1];
        }
        /* Construct rest of the tc array */
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                costTable[i][j] = matrix[i][j] +
                        min(costTable[i - 1][j], costTable[i - 1][j - 1], costTable[i][j - 1]);
            }
        }
        return costTable[m][n];
    }

    private static int min(int x, int y, int z){
       return Math.min(x, Math.min(y, z));
    }

    public static void main(String args[])
    {
        int cost[][]= {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        for(int i = 0; i < cost.length; i++){
            System.out.println(Arrays.toString(cost[i]));
        }
        System.out.println("#####################");
        System.out.println(minCostPath(cost,2,2));
    }

}
