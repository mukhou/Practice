/* 
User: Urmi
Date: 12/19/2019 
Time: 2:43 PM
*/

package crackingcodeinterview;

/**
 * Given an M x N matrix in which each row and each column is sorted in
 * ascending order, write a method to find an element.
 * Algorithm:
 * If the start of a column is greater than x, then x is to the left of the column.
 * If the end of a column is less than x, then x is to the right of the column.
 * If the start of a row is greater than x, then x is above that row.
 * If the end of a row is less than x, then x is below that row.
 */
public class FindKeyInSortedMatrix {

    boolean findElem(int[][] matrix, int key){
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                return true;
            }else if(matrix[row][col] > key){
                col--;
            }else {
                row++;
            }
        }
        return false;

    }
}


