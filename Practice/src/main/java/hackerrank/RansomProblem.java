package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        System.out.println(findRansom(magazine, ransom));
    }

    private static String findRansom(String[] magazine, String[] ransom) {
        String match = "Yes";
        Map<String, Integer> m1 = stringArrayToMap(magazine);
        Map<String, Integer> m2 = stringArrayToMap(ransom);
        for(String key : m2.keySet()){
            if(!m1.containsKey(key)){
                return "No";
            }else {
                int count = m1.get(key);
                if(count < m2.get(key)){
                    match ="No";
                }
            }
        }
        return match;
        
    }

    private static Map<String,Integer> stringArrayToMap(String[] strArr) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : strArr){
            map.merge(str, 1, Integer::sum);
        }
        return map;

    }

}
