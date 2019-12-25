package hackerrank;

/**
 * find the difference of the sum of diagonals of a matrix  :
 * Print the absolute difference between the two sums of the matrix's diagonals as a single integer.
 */

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/diagonal-difference/problem?h_r=internal-search
public class DifferenceOfSumofDiagonals {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < arr.size(); i ++){
            List<Integer> row = arr.get(i);
            sum1 += row.get(i);
            sum2 += row.get(row.size() - i - 1);
        }
        return Math.abs(sum1 - sum2);

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //ADVANCED WAY
        /*int n ;
        int diag1 = 0 ; int diag2 = 0;
        n = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i < n; i++){
            String str[] = in.nextLine().split(" ");
            diag1 = diag1 + Integer.parseInt(str[i]);
            diag2 = diag2 + Integer.parseInt(str[n-(i + 1)]);
        }

        int diagDiff = Math.abs(diag1 -  diag2);
        System.out.println(diagDiff);*/

        List<Integer> l = Arrays.asList(1, 2, 3);
        List<Integer> l1 = Arrays.asList(4, 5, 6 );
        List<Integer> l2 = Arrays.asList(9, 8, 9);
        List<List<Integer>> arr = Lists.newArrayList(l, l1, l2);
        System.out.println(diagonalDifference(arr));
    }


}
