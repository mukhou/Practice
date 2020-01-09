/* 
User: Urmi
Date: 12/31/2019 
Time: 10:38 AM
*/

package crackingcodeinterview;

import java.util.ArrayList;

//CTCI pg 376, Q 8.12
public class EightQueen {
    public static int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        System.out.println(results.size());
    }

    private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if(row == GRID_SIZE){ // Found valid placement
            results.add(columns.clone());
        }else {
            for(int col = 0; col < GRID_SIZE; col ++){
                if(checkValid(columns, row, col)){
                    columns[row] = col; // Place queen
                    //recurse
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    /* Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for queens
     * in the same row because the calling placeQueen only attempts to place one queen at
     * a time. We know this row is empty.
     */
    private static boolean checkValid(Integer[] columns, int row1, int col1) {
        for(int row2 = 0; row2 < row1; row2 ++){
            int col2 = columns[row2];
            /* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */

            /* Check if rows have a queen in the same column */
            if(col1 == col2){
                return false;
            }

            /* Check diagonals: if the distance between the columns equals the distance
             * between the rows, then they’re in the same diagonal. */
            int colDist = Math.abs(col2 - col1);
            int rowDist = row1 - row2;
            if(colDist == rowDist){
                return false;
            }
        }
        return true;
    }

    private static void clear(Integer[] columns){
        for(int i = 0; i < GRID_SIZE; i ++){
            columns[i] = -1;
        }
    }

}
