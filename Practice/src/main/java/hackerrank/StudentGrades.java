package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/22/17
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class StudentGrades {
    static int[] solve(int[] grades){
        int[] scores = new int[4];
        for(int i = 0; i < grades.length; i++){
            if(grades[i] < 38){
                continue;
            }else if(grades[i] % 5 >= 3){
                grades[i] = grades[i] + (5 - (grades[i] % 5));
            }else{
                continue;
            }
        }
        scores = grades;
        return scores;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
