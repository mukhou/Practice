package hackerrank;

import java.util.Scanner;

/**
 * Given an array of integers, calculate which fraction of its elements are positive,
 * which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively.
 * Print the decimal value of each fraction on a new line.
 */
public class PlusMinus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        int pos = 0, neg = 0, neutral = 0;
        for(String s : strArr){
            int val = Integer.parseInt(s);
            if( val > 0){
                pos ++;
            }else if(val < 0){
                neg ++;
            } else {
                neutral ++;
            }
        }
        System.out.println((double) pos/n);
        System.out.println((double) neg/n);
        System.out.println((double) neutral/n);

    }
}
