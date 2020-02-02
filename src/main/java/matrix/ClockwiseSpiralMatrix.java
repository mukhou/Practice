/* 
User: Urmi
Date: 1/31/2020 
Time: 5:52 PM
*/
/**
 * Given a number, create a 2D matrix by filling up all the value clockwise:
 *
 */
package matrix;

import java.util.Arrays;
import java.util.stream.Stream;

public class ClockwiseSpiralMatrix {

    private static void printClockwise(int n){
        int[][] matrix = new int[n][n];
        int rowS = 0, rowE = n - 1;
        int colS = 0, colE = n - 1;
        int counter = 1;
        while (counter <= n * n){
            //left to right
            for(int c = colS; c <= colE; c++){
                matrix[rowS][c] = counter++;
            }
            rowS ++;
            //top to bottom
            for(int r = rowS; r <= rowE; r++){
                matrix[r][colE] = counter++;
            }
            colE --;
            //left to right
            for(int c = colE; c >= colS; c--){
                matrix[rowE][c] = counter++;
            }
            rowE --;
            //bottom to top
            for(int r = rowE; r >= rowS; r --){
                matrix[r][colS] = counter++;
            }
            colS ++;
        }

        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void main(String[] args){
        printClockwise(4);
    }

}
