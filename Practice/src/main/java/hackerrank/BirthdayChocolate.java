package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/18/18
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */

/**
 * 1 2 1 3 2
 * d=3, m=2
 */
public class BirthdayChocolate {
    static int solve(int n, int[] s, int d, int m) {
        // Complete this function
        int i = 0, sum = 0, count = 0;
        //first find the sum of first m numbers(2 in this case) as you can only give m consecutive sqaures
        while(i<m){
            sum+=s[i];
            i++;
        }
        if(sum==d){
            count++;
        }
        //now continuing from the mth number(i = 2), add  the (m + 1)th number(3rd number) to the sum
        // and subtract the (i - m)th (1st number, i = 0) and you can only pick 2 consecutive pieces
        // and keep checking if sum == d for each consecutive pair
        while(i<n){
            sum+=s[i];
            sum-=s[i-m];
            if(sum==d){
                count++;
            }
            i++;

        }
        return count;





}

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int[] s = new int[]{1, 2, 1, 3, 2};

        int d = 3;
        int m = 2;
        int result = solve(5, s, d, m);
        System.out.println(result);
    }
}

