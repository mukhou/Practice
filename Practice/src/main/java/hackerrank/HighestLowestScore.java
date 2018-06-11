package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/16/18
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */

/**
 * IMP: WHEN FACED WITH THE LOGIC OF COMPARING ELEMENTS OF AN ARRAY/LIST SEQUENTIALLY
 * AND RUN THE RISK OF ARRAY INDEX OUT OF BOUNDS EXCEPTION DUE TO REACHING END OF COLLECTION:
 * 1. INITIALIZE FIRST(0TH) ELEMENT OF THE COLLECTION TO A VARIABLE
 * 2. START ITERATING FROM THE NEXT(1ST) ELEMENT AND CONTINUE TILL THE END(NTH)
 */
public class HighestLowestScore {
    static int[] breakingRecords(int[] score) {
        int maxCount = 0, minCount = 0;
        int maxSoFar = score[0], minSoFar = score[0];
        int[] res = new int[2];
        for (int i = 1; i < score.length; i++) {
            if (score[i] > maxSoFar) {
                maxSoFar = score[i];
                maxCount++;
            }
            if (score[i] < minSoFar) {
                minSoFar = score[i];
                minCount ++;
            }
        }

        res[0] = maxCount;
        res[1] = minCount;
        return res;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for (int score_i = 0; score_i < n; score_i++) {
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

}
