package bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/3/18
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindAllDiagonals {
    public static void main(String[] args){
        int[][] matrix =  { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        findDiagonals(matrix);
    }

    //Idea: can be done in one iteration
    private static void findDiagonals(int[][] matrix) {
        int length = matrix.length;
        List<Integer> leftDiag = new ArrayList<>();
        List<Integer> rightDiag = new ArrayList<>();
        for(int i = 0; i < length; i++){
            leftDiag.add(matrix[i][i]);
            rightDiag.add(matrix[i][length - (i + 1)]);
        }
        System.out.print(leftDiag.toString());
        System.out.print(rightDiag.toString());

    }
}
