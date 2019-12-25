package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/8/17
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Staircase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < (n - (i + 1)); j ++){
                System.out.print(" ");
            }
            for(int k = 0; k < i + 1; k ++){
                System.out.print("#");
            }
            System.out.println();

        }
    }
}
