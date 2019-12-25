package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/22/17
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplesOranges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        int appCount = 0, orCount = 0;
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
            if(a + apple[apple_i] >= s && a + apple[apple_i] <= t){
                appCount ++;
            }
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
            if(b + orange[orange_i] >= s && b + orange[orange_i] <= t){
                orCount ++;
            }
        }
        System.out.println(appCount);
        System.out.println(orCount);

    }
}
