package matrix;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/3/18
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.youtube.com/watch?v=IDxaZrrggu0
 */
public class PrintMatrixDiagonally {
    public static void main(String[] args){
        int[][] matrix =  { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        printMatrixDiagonally(matrix);
    }

    private static void printMatrixDiagonally(int[][] matrix) {
        //initialize rowCount and columnCount
        int rowCount = matrix.length, columnCount = matrix[0].length;

        //print rowCount diagonals(row = 0 -> rowCount - 1)
        // col remains same for every iteration(starting with 0), tempCol keeps increasinf
        for(int row = 0, col = 0; row < rowCount ; row ++ ){
            int tempRow = row, tempCol = col;
            System.out.print(matrix[tempRow][tempCol]+ " ");
            while(tempRow != 0 && tempCol != (columnCount - 1)){
                tempRow --;
                tempCol ++;
                System.out.print(matrix[tempRow][tempCol] + " ");
            }
            System.out.println();

        }
        //print columnCount diagonals(col = 1 -> columnCount - 1)
        for(int col = 1, row = rowCount - 1; col < columnCount; col ++){
            int tempRow = row, tempCol = col;
            System.out.print(matrix[tempRow][tempCol]+ " ");
            while(tempRow != 0 && tempCol !=  (columnCount - 1) ){
                tempRow --;
                tempCol ++;
                System.out.print(matrix[tempRow][tempCol] + " ");
            }
            System.out.println();
        }

    }

}
