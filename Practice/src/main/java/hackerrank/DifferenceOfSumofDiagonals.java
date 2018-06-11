package hackerrank;

/**
 * find the difference of the sum of diagonals of a matrix  :
 * Print the absolute difference between the two sums of the matrix's diagonals as a single integer.
 */

import java.util.Scanner;

public class DifferenceOfSumofDiagonals {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n ;
        int diag1 = 0 ; int diag2 = 0;
        n = Integer.parseInt(in.nextLine());
        for(int i =0 ; i < n; i++){
            String str[] = in.nextLine().split(" ");
            diag1 = diag1 + Integer.parseInt(str[i]);
            diag2 = diag2 + Integer.parseInt(str[n-(i + 1)]);
        }

        int diagDiff = Math.abs(diag1 -  diag2);
        System.out.println(diagDiff);
    }


}
