package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/7/15
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindDigitDivisibleByN {

    public static void findDigit(int[] a){
        for(int i=0;i<a.length;i++){
            //number
            int tmp=a[i];
            int sum=0;
            //each digit
            char[] cs= String.valueOf(a[i]).toCharArray();

            //if divider should not be zero but remain should be zero
            for(int j=0;j<cs.length;j++){
                int div=Integer.parseInt(String.valueOf(cs[j]));
                if(div!=0 && (tmp%div)==0)
                    sum++;
            }

            //print
            System.out.println(sum);
        }

    }

    public static void findDigit1(int[] arr){

        for(Integer n : arr){
            int original = n;//24
            int count = 0;
            while(n != 0){
                int temp = n % 10; //4
                if(original % temp == 0){
                    count ++;
                }
                n = n / 10;//2

            }
            System.out.println(count);

        }


    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //no of test cases
        int T=in.nextInt();
        //number array
        int[] a=new int[T];

        for(int i=0;i<a.length;i++){
            a[i]=in.nextInt();
        }
        //input close to prevent leak
        in.close();
        findDigit1(a);

    }
}
