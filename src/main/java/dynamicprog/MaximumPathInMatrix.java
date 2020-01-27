/* 
User: Urmi
Date: 1/17/2020 
Time: 6:05 PM
*/

/**
 * Given a matrix of numbers, find the path from bottom left to top right with the highest value.
 */
package dynamicprog;

import java.util.Arrays;

//https://www.youtube.com/watch?v=wqCDkuKxmPQ
public class MaximumPathInMatrix {
    private static int maxPath(int[][] matrix, int m, int n){
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];
        dp[row][0] = matrix[row][0];

        for(int i = row - 1; i >= 0; i--){
            dp[i][0] = dp[i + 1][0] + matrix[i][0];
        }

        for(int i = 0; i <= row; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("#####################");

        for(int j = 1; j <= col; j++){
            dp[row][j] = dp[row][j - 1] + matrix[row][j];
        }


        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("#####################");
        for(int i = row - 1; i >= m; i--){
            for(int j = 1; j <= n; j++){
                dp[i][j] = matrix[i][j] + Math.max(dp[i + 1][j], dp[i][j - 1]);

            }
        }

        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }



    public static void main(String[] args){
        int cost[][]= {
                {1, 1, 3},
                {2, 2, 1},
                {0, 3, 2}};

        for(int i = 0; i < cost.length; i++){
            System.out.println(Arrays.toString(cost[i]));
        }
        System.out.println("#####################");
        System.out.println(maxPath(cost, 0, 2));
    }

}
