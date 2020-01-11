/* 
User: Urmi
Date: 1/10/2020 
Time: 8:39 PM
*/

/**
 * Given a rectangular matrix which has only two possible values ‘X’ and ‘O’. The values ‘X’ always appear in form of
 * rectangular islands and these islands are always row-wise and column-wise separated by at least one line of ‘O’s.
 * Note that islands can only be diagonally adjacent. Count the number of islands in the given matrix.
 */
package byteBybyte;

//https://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
public class CountIslandsInMatrix {

    private static final int VISITED = 2;

    //define indexes of neighbors for fast lookup
    private static final int[] columns = {-1, 0, 1, -1,1, -1,0,1};
    private static final int[] rows =    {-1,-1,-1,0,0,1,1,1};

    static int getNumberOfIslands(int[][] binaryMatrix) {
        return countIslands(binaryMatrix, binaryMatrix.length, binaryMatrix[0].length);
    }

    //INCORRECT
    private static int countIslands(int[][] binaryMatrix, int row, int col) {
        int count = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(binaryMatrix[i][j] == 1){
                    if ((i == 0 || binaryMatrix[i - 1][j] == 0) &&
                            (j == 0 || binaryMatrix[i][j - 1] == 0)) {

                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public static int findIslandsCount(int[][] matrix) {

        int numIslands = 0;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]!=VISITED && matrix[i][j] == 1) {
                    dfs(i,j, matrix);
                    numIslands++;
                }
                else {
                    matrix[i][j]=VISITED;
                }
            }
        }

        return numIslands;
    }

    private static void dfs(int i, int j, int[][] matrix) {

        //Mark current cell as visited
        matrix[i][j] = VISITED;

        //iterate through each neighbors and if legal recursively call dfs
        for(int n=0; n<columns.length; n++) {

            int c = j+columns[n];
            int r = i+rows[n];

            if(isLegal(c, r, matrix)) {
                dfs(r, c, matrix);
            }
        }
    }
    private static boolean isLegal(int c, int r, int[][] matrix) {
        return c>=0 && r>=0 && r<matrix.length && c<matrix[0].length && matrix[r][c]!=VISITED && matrix[r][c]==1;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,0,1,0},
                {0,1,1,1},
                {0,0,1,0}
        };
        System.out.println(getNumberOfIslands(matrix));
        System.out.println(findIslandsCount(matrix));
    }
}
